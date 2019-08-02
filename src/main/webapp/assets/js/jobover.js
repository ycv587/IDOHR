var addFlag = 1;

/* 计算表格高度 */
function tableHeight() {
	return $(window).height() - 52;
};

/* 根据窗口调整表格高度 */
$(window).resize(function() {
	$("#jobover-table").bootstrapTable('resetView', {
		height : tableHeight()
	})
});

/* 加载表格内容 */
function initTable() {
	$("#jobover-table").bootstrapTable({
		method : 'get', // 请求方式
		contentType : 'application/x-www-form-urlencoded',
		url : '/jobover/show', // 请求后台的URL
		height : tableHeight(), // 行高
		toolbar : '#toolbar', // 工具按钮容器
		toolbarAlign : 'left', // 工具按钮水平居左
		striped : true, // 隔行变色
		pagination : true, // 显示分页
		pageNumber : 1, // 初始化加载第一页，默认第一页
		queryParamsType : 'limit', // 查询参数组织方式，RESTful风格
		queryParams : function(params) {
			return {
				pageIndex : params.pageNumber, // 请求第几页
				pageSize : params.limit, // 每页数据条数
				search : params.search, // 查询内容
				order : params.order, // 排序方式
				orderName : params.sort
			// 排序列
			}
		}, // 请求服务器时传递参数
		singleSelect : true, // 禁止多选
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageSize : 10, // 每页的记录行数
		pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		showRefresh : true, // 显示刷新按钮
		showColumns : true, // 显示所有的列
		clickToSelect : true, // 是否启用点击选中行
		search : true, // 显示表格搜索，此搜索是客户端搜索，不会进服务端
		strictSearch : false, // 全匹配搜索
		minimumCountColumns : 2, // 最少允许的列数
		detailView : false, // 父子表
		showExport : true,
		exportDataType : "basic",
		columns : [ {
			field : 'overno',
			title : '加班记录号',
			visible : false
		}, {
			field : 'employee.empno',
			title : '员工号',
			sortable : true
		}, {
			field : 'employee.ename',
			title : '姓名',
			sortable : true
		}, {
			field : 'overstart',
			title : '开始时间',
			formatter : msToDtlocal,
			sortable : true
		}, {
			field : 'overend',
			title : '结束时间',
			formatter : msToDtlocal,
			sortable : true
		}, {
			field : 'overtype',
			title : '加班类型',
			formatter : overTypeFormatter,
			sortable : true
		}, {
			field : 'remark',
			title : '备注'
		} ]
	});
}

function overTypeFormatter(value) {
	if (value == "普通") {
		return "普通加班";
	} else if (value == "周末") {
		return "周末加班";
	} else if (value == "法定") {
		return "法定节假日加班";
	} else {
		return "其他";
	}
}

function overTypeTran(value) {
	if (value == "no") {
		return "普通";
	} else if (value == "wo") {
		return "周末";
	} else if (value == "qo") {
		return "法定";
	} else {
		return "其他";
	}
}

/* 毫秒转datetime-local */
function msToDtlocal(value) {
	var date = new Date();
	date.setTime(value);
	return date.Format("yyyy-MM-dd") + " " + date.Format("HH:mm");
}

/* datetime-local转毫秒 */
function dtlocalToMs(value) {
	var date = value.replace('T', ' ');
	date += ":00";
	return new Date(date).getTime();
}

$(function() {
	// 初始化table
	initTable();

	/* 工具按钮点击事件 */
	$("#btn-add").click(function() {
		$("#model-add").modal();
	});

	$("#empno-add").change(
			function() {
				$.get('/emp/findname?empno=' + $("#empno-add").val(), function(
						data, status) {
					if (data.ename == null) {
						toastr.warning("员工不存在");
						$("#ename-add").val("员工不存在");
						$("#add").prop('disabled', true);
					} else {
						$("#ename-add").val(data.ename);
						$("#add").prop('disabled', false);
					}
				});
			});

	$("#add")
			.click(
					function() {
						if (dtlocalToMs($("#overstart-add").val()) >= dtlocalToMs($(
								"#overend-add").val())) {
							toastr.error('加班结束时间不能提前于开始时间!');
							return 0;
						}
						var date1 = new Date();
						var date2 = new Date();
						date1.setTime(dtlocalToMs($("#overstart-add").val()));
						date2.setTime(dtlocalToMs($("#overend-add").val()));
						if (date1.getDay() == 0 || date1.getDay() == 1) {
							// 双休日
						} else {
							// 工作日
							if (addFlag == 1
									&& ((date1.getHours() >= 8 && date1
											.getHours() <= 16) || (date2
											.getHours() >= 8 && date2
											.getHours() <= 16))) {
								// 工作时间
								toastr.warning("再次点击'添加'按钮提交加班记录！");
								toastr
										.warning("您填写的加班时间中包含工作时间，请确认加班时间（法定节假日请无视此消息）！");
								addFlag = 0;
								return;
							}
						}
						$
								.ajax({
									type : 'put',
									url : '/jobover/add',
									contentType : 'application/json;charset=utf-8',
									data : JSON
											.stringify({
												"employee" : {
													"empno" : $("#empno-add")
															.val()
												},
												"overstart" : dtlocalToMs($(
														"#overstart-add").val()),
												"overend" : dtlocalToMs($(
														"#overend-add").val()),
												"overtype" : overTypeTran($(
														"#overtype-add option:selected")
														.attr("id")),
												"remark" : $("#remark-add")
														.val()
											}),
									success : function(data) {
										if (data == "1") {
											toastr.success('加班记录成功!');
											$("#model-add").modal('hide');
											$('#jobover-table').bootstrapTable(
													"refresh", {
														url : "/jobover/show"
													});
										} else {
											toastr.error('加班记录失败!');
										}
										addFlag = 1;
									}
								});
					});
});

/* toastr自定义参数 */
toastr.options = {
	closeButton : false, // 关闭按钮
	debug : false, // 是否为调试
	progressBar : false, // 是否显示进度条
	positionClass : "toast-top-center", // 消息框在页面显示的位置
	onclick : null, // 点击消息框自定义事件
	showDuration : "300", // 显示动作时间
	hideDuration : "1000", // 隐藏动作时间
	timeOut : "2000", // 自动关闭超时时间
	extendedTimeOut : "1000",
	showEasing : "swing",
	hideEasing : "linear",
	showMethod : "fadeIn", // 显示的方式
	hideMethod : "fadeOut" // 隐藏的方式
};
/* 计算表格高度 */
function tableHeight() {
	return $(window).height() - 52;
};

/* 根据窗口调整表格高度 */
$(window).resize(function() {
	$("#joblevel-table").bootstrapTable('resetView', {
		height : tableHeight()
	})
});

/* 加载表格内容 */
function initTable() {
	$("#joblevel-table").bootstrapTable({
		method : 'get', // 请求方式
		contentType : 'application/x-www-form-urlencoded',
		url : '/joblevel/show', // 请求后台的URL
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
			field : 'levno',
			title : '请假记录号',
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
			field : 'levstart',
			title : '开始时间',
			formatter : msToDtlocal,
			sortable : true
		}, {
			field : 'levend',
			title : '结束时间',
			formatter : msToDtlocal,
			sortable : true
		}, {
			field : 'remark',
			title : '备注'
		} ]
	});
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

	$("#add").click(
			function() {
				if (dtlocalToMs($("#levstart-add").val()) > dtlocalToMs($(
						"#levend-add").val())) {
					toastr.error('请假结束时间不能提前于开始时间!');
					return 0;
				}
				$.ajax({
					type : 'put',
					url : '/joblevel/add',
					contentType : 'application/json;charset=utf-8',
					data : JSON.stringify({
						"employee" : {
							"empno" : $("#empno-add").val()
						},
						"levstart" : dtlocalToMs($("#levstart-add").val()),
						"levend" : dtlocalToMs($("#levend-add").val()),
						"remark" : $("#remark-add").val()
					}),
					success : function(data) {
						if (data == "1") {
							toastr.success('请假办理成功!');
							$("#model-add").modal('hide');
							$('#joblevel-table').bootstrapTable("refresh", {
								url : "/joblevel/show"
							});
						} else {
							toastr.error('请假办理失败!');
						}
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
$(function() {
	// 初始化table
	initTable();
	/* 新增按钮点击事件 */
	$("#btn-add").click(function() {
		$("#modal-add").modal();
	});
	/* 添加按钮 */
	$("#add").click(addJob);
	/* 合并按钮点击事件 */
	$("#btn-del").click(
			function() {
				var selectJobs = $("#job-table")
						.bootstrapTable('getSelections');
				if (selectJobs.length != 2) {
					toastr.warning("请选择两个职位");
				} else {
					$("#op-first").text(
							selectJobs[0].jname + "(" + selectJobs[0].jobid
									+ ")");
					$("#op-second").text(
							selectJobs[1].jname + "(" + selectJobs[1].jobid
									+ ")");
					$("#modal-merge").modal();
				}
			});
	/* 提交合并职位请求 */
	$("#merge").click(mergeJob);
	/* 修改按钮点击事件 */
	$("#btn-edit").click(function() {
		var selectJobs = $("#job-table").bootstrapTable('getSelections');
		if (selectJobs.length != 1) {
			toastr.warning("请选择一个职位");
		} else {
			/* 表单赋初值 */
			$("#jobid-modify").val(selectJobs[0].jobid);
			$("#jname-modify").val(selectJobs[0].jname);
			$("#count-modify").val(selectJobs[0].count);
			$("#modal-modify").modal();
		}
	});
	/* 修改保存按钮 */
	$("#modify").click(modifyJob);

	/* 职位编号单击恢复颜色 */
	$("#jobid-add").click(function() {
		$("#jobid-add").parent().parent().removeClass('has-error');
	});
	/* 判断职位编号是否重复 */
	$("#jobid-add").blur(
			function() {
				$.get('/job/distinct?jobid=' + $("#jobid-add").val(),
						function(data, status) {
							if (data != "1") {
								toastr.error('职位编号已存在!');
								$("#jobid-add").parent().parent().addClass(
										'has-error');
							}
						});
			});

});

/* 计算表格高度 */
function tableHeight() {
	return $(window).height() - 52;
};
/* 根据窗口调整表格高度 */
$(window).resize(function() {
	$("#job-table").bootstrapTable('resetView', {
		height : tableHeight()
	})
});

/* 加载表格内容 */
function initTable() {
	$("#job-table").bootstrapTable({
		method : 'get', // 请求方式
		contentType : 'application/x-www-form-urlencoded',
		url : '/job/show', // 请求后台的URL
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
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageSize : 10, // 每页的记录行数
		pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		showRefresh : true, // 显示刷新按钮
		showColumns : true, // 显示所有的列
		clickToSelect : true, // 是否启用点击选中行
		search : true, // 显示表格搜索，此搜索是客户端搜索，不会进服务端
		strictSearch : false, // 全匹配搜索
		minimumCountColumns : 2, // 最少允许的列数
		showExport : true,
		exportDataType : "basic",
		columns : [ {
			checkbox : true
		}, {
			field : 'jobid',
			title : '职位编号',
			sortable : true
		}, {
			field : 'jname',
			title : '职位名称',
			sortable : true
		}, {
			field : 'count',
			title : '职位人数',
			sortable : true
		} ]
	});
}
/* 添加职位 */
function addJob() {
	$.ajax({
		type : 'put',
		url : '/job/add',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify({
			"jobid" : $("#jobid-add").val(),
			"jname" : $("#jname-add").val()
		}),
		success : function(data) {
			if (data == "1") {
				toastr.success('添加成功!');
				$("#modal-add").modal('hide');
				$('#job-table').bootstrapTable("refresh", {
					url : "/job/show"
				});
			} else {
				toastr.error('添加失败!');
			}
			/* 清空文本框内容 */
			$("#jobid-add").val("");
			$("#jname-add").val("");
		}
	});
}

/* 修改职位信息 */
function modifyJob() {
	$.ajax({
		type : 'post',
		url : '/job/modify',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify({
			"jobid" : $("#jobid-modify").val(),
			"jname" : $("#jname-modify").val()
		}),
		success : function(data) {
			if (data == "1") {
				toastr.success('修改成功!');
				$("#modal-modify").modal('hide');
				$('#job-table').bootstrapTable("refresh", {
					url : "/job/show"
				});
			} else {
				toastr.error('修改失败!');
			}
		}
	});
}
/* 职位合并 */
function mergeJob() {
	var selectJobs = $("#job-table").bootstrapTable('getSelections');
	var checkIndex = $("#select-merge").get(0).selectedIndex;
	$.ajax({
		type : 'delete',
		url : '/job/merge',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(new Array(
				selectJobs[checkIndex == 0 ? 1 : 0].jobid,
				selectJobs[checkIndex].jobid)),
		success : function(data) {
			if (data == "1") {
				toastr.success('职位合并成功!');
				$("#modal-merge").modal('hide');
				$('#job-table').bootstrapTable("refresh", {
					url : "/job/show"
				});
			} else {
				toastr.error('职位合并失败!');
			}
		}
	});
}

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
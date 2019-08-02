$(function() {
	/* 初始化table */
	initTable();
	/* 新增按钮点击事件 */
	$("#btn-add").click(function() {
		$("#model-add").modal();
	});
	/* 添加按钮 */
	$("#add").click(addDept);
	/* 合并按钮点击事件 */
	$("#btn-del").click(function() {
		// 取得选中的部门
		var selectDepts = $("#dept-table").bootstrapTable('getSelections');
		if(selectDepts.length != 2) {
			toastr.warning("请选择两个部门");
		} else {
			$("#op-first").text(selectDepts[0].dname + "(" + selectDepts[0].deptno +
				" " + selectDepts[0].location + ")");
			$("#op-second").text(selectDepts[1].dname + "(" + selectDepts[1].deptno +
				" " + selectDepts[1].location + ")");
			$("#modal-merge").modal();
		}
	});
	/* 合并部门按钮 */
	$("#merge").click(mergeDept);
	/* 修改按钮点击事件 */
	$("#btn-edit").click(function() {
		var selectDepts = $("#dept-table").bootstrapTable('getSelections');
		if(selectDepts.length != 1) {
			toastr.warning("请选择一个部门");
		} else {
			/* 表单赋初值 */
			$("#deptno-modify").val(selectDepts[0].deptno);
			$("#dname-modify").val(selectDepts[0].dname);
			$("#location-modify").val(selectDepts[0].location);
			$("#count-modify").val(selectDepts[0].count);
			$("#model-modify").modal();
		}
	});
	/* 修改保存按钮 */
	$("#modify").click(modifyDept);

	/* 部门编号单击恢复颜色 */
	$("#deptno-add").click(function() {
		$("#deptno-add").parent().parent().removeClass('has-error');
	});
	/* 判断部门编号是否重复 */
	$("#deptno-add").blur(function() {
		$.get('/dept/distinct?deptno=' + $("#deptno-add").val(), function(data, status) {
			if(data != "1") {
				toastr.error('部门编号已存在!');
				$("#deptno-add").parent().parent().addClass('has-error');
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
	$("#dept-table").bootstrapTable('resetView', {
		height: tableHeight()
	})
});

/* 加载表格内容 */
function initTable() {
	$("#dept-table").bootstrapTable({
		method: 'get', // 请求方式
		contentType: 'application/x-www-form-urlencoded',
		url: '/dept/show', // 请求后台的URL
		height: tableHeight(), // 行高
		toolbar: '#toolbar', // 工具按钮容器
		toolbarAlign: 'left', // 工具按钮水平居左
		striped: true, // 隔行变色
		pagination: true, // 显示分页
		pageNumber: 1, // 初始化加载第一页，默认第一页
		queryParamsType: 'limit', // 查询参数组织方式，RESTful风格
		queryParams: function(params) {
			return {
				pageIndex: params.pageNumber, // 请求第几页
				pageSize: params.limit, // 每页数据条数
				search: params.search, // 查询内容
				order: params.order, // 排序方式
				orderName: params.sort
				// 排序列
			}
		}, // 请求服务器时传递参数
		sidePagination: "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageSize: 10, // 每页的记录行数
		pageList: [10, 25, 50, 100], // 可供选择的每页的行数（*）
		showRefresh: true, // 显示刷新按钮
		showColumns: true, // 显示所有的列
		clickToSelect: true, // 是否启用点击选中行
		search: true, // 显示表格搜索，此搜索是客户端搜索，不会进服务端
		strictSearch: false, // 全匹配搜索
		minimumCountColumns: 2, // 最少允许的列数
		showExport: true,
		exportDataType: "basic",
		columns: [{
			checkbox: true
		}, {
			field: 'deptno',
			title: '部门编号',
			sortable: true
		}, {
			field: 'dname',
			title: '部门名称',
			sortable: true
		}, {
			field: 'location',
			title: '部门地址'
		}, {
			field: 'count',
			title: '部门人数',
			sortable: true
		}]
	});
}
/* 添加部门 */
function addDept() {
	$.ajax({
		type: 'put',
		url: '/dept/add',
		contentType: 'application/json;charset=utf-8',
		data: JSON.stringify({
			"deptno": $("#deptno-add").val(),
			"dname": $("#dname-add").val(),
			"location": $("#location-add").val()
		}),
		success: function(data) {
			if(data == "1") {
				toastr.success('添加成功!');
				$("#model-add").modal('hide');
				$('#dept-table').bootstrapTable("refresh", {
					url: "/dept/show"
				});
			} else {
				toastr.error('添加失败!');
			}
			/* 清空文本框内容 */
			$("#deptno-add").val("");
			$("#dname-add").val("");
			$("#location-add").val("");
		}
	});
}

/* 修改部门信息 */
function modifyDept() {
	$.ajax({
		type: 'post',
		url: '/dept/modify',
		contentType: 'application/json;charset=utf-8',
		data: JSON.stringify({
			"deptno": $("#deptno-modify").val(),
			"dname": $("#dname-modify").val(),
			"location": $("#location-modify").val()
		}),
		success: function(data) {
			if(data == "1") {
				toastr.success('修改成功!');
				$("#model-modify").modal('hide');
				$('#dept-table').bootstrapTable("refresh", {
					url: "/dept/show"
				});
			} else {
				toastr.error('修改失败!');
			}
		}
	});
}

/* 部门合并 */
function mergeDept() {
	var selectDepts = $("#dept-table").bootstrapTable('getSelections');
	var checkIndex = $("#select-merge").get(0).selectedIndex;
	$.ajax({
		type: 'delete',
		url: '/dept/merge',
		contentType: 'application/json;charset=utf-8',
		data: JSON.stringify(new Array(selectDepts[checkIndex == 0 ? 1 : 0].deptno, selectDepts[checkIndex].deptno)),
		success: function(data) {
			if(data == "1") {
				toastr.success('部门合并成功!');
				$("#modal-merge").modal('hide');
				$('#dept-table').bootstrapTable("refresh", {
					url: "/dept/show"
				});
			} else {
				toastr.error('部门合并失败!');
			}
		}
	});
}

/* toastr自定义参数 */
toastr.options = {
	closeButton: false, // 关闭按钮
	debug: false, // 是否为调试
	progressBar: false, // 是否显示进度条
	positionClass: "toast-top-center", // 消息框在页面显示的位置
	onclick: null, // 点击消息框自定义事件
	showDuration: "300", // 显示动作时间
	hideDuration: "1000", // 隐藏动作时间
	timeOut: "2000", // 自动关闭超时时间
	extendedTimeOut: "1000",
	showEasing: "swing",
	hideEasing: "linear",
	showMethod: "fadeIn", // 显示的方式
	hideMethod: "fadeOut" // 隐藏的方式
};
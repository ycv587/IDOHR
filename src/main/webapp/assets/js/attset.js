/* 计算表格高度 */
function tableHeight() {
	return $(window).height() - 52;
};

/* 根据窗口调整表格高度 */
$(window).resize(function() {
	$("#attset-table").bootstrapTable('resetView', {
		height: tableHeight()
	})
});

/* 加载表格内容 */
function initTable() {
	$("#attset-table").bootstrapTable({
		method: 'get', // 请求方式
		contentType: 'application/x-www-form-urlencoded',
		url: '/attset/show', // 请求后台的URL
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
				orderName: params.sort // 排序列
			}
		}, // 请求服务器时传递参数
		singleSelect: true, //禁止多选
		sidePagination: "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageSize: 10, // 每页的记录行数
		pageList: [10, 25, 50, 100], // 可供选择的每页的行数（*）
		showRefresh: true, // 显示刷新按钮
		showColumns: true, // 显示所有的列
		clickToSelect: true, // 是否启用点击选中行
		search: true, // 显示表格搜索，此搜索是客户端搜索，不会进服务端
		strictSearch: false, // 全匹配搜索
		minimumCountColumns: 2, // 最少允许的列数
		detailView: false, // 父子表
		showExport: true,
		exportDataType: "basic",
		columns: [{
			title: '#',
			checkbox: true
		}, {
			field: 'setno',
			title: '考勤配置号',
			sortable: true
		}, {
			field: 'attstart',
			title: '开始时间',
			formatter: timeFormatter,
			sortable: true
		}, {
			field: 'attend',
			title: '结束时间',
			formatter: timeFormatter,
			sortable: true
		}, {
			field: 'attflag',
			title: '是否启用',
			formatter: flagFormatter,
			sortable: true
		}]
	});
}

/* 标志格式化 */
function flagFormatter(value, row, index) {
	if(value == "0") {
		return "否";
	} else {
		return "是";
	}
}

/* 日期格式化 */
function dateFormatter(value, row, index) {
	var date = new Date();
	date.setTime(value);
	return date.Format("yyyy-MM-dd");
}

/* 时间格式化 */
function timeFormatter(value, row, index) {
	var date = new Date();
	date.setTime(value);
	return date.Format("HH:mm:ss");
}

/* 时间字符串转毫秒值 */
function timeToMs(time) {
	var t = "2018/01/01 " + time;
	return new Date(t).getTime();
}

/* 修改下拉框的值 */
function setSelect(elemId, content) {
	for(var i = 0; i < ($("#" + elemId)[0].options).length; i++) {
		if($("#" + elemId)[0].options[i].innerText == content) {
			$("#" + elemId)[0].options[i].selected = true;
			break;
		}
	}
}

/* 添加配置项 */
function addAttset() {
	$.ajax({
		type: 'put',
		url: '/attset/add',
		contentType: 'application/json;charset=utf-8',
		data: JSON.stringify({
			"setno": $("#setno-add").val(),
			"attstart": timeToMs($("#attstart-add").val()),
			"attend": timeToMs($("#attend-add").val()),
			"attflag": ($("#attflag-add").val() == "是" ? 1 : 0)
		}),
		success: function(data) {
			if(data == "1") {
				toastr.success('添加成功!');
				$("#model-add").modal('hide');
				$('#attset-table').bootstrapTable("refresh", {
					url: "/attset/show"
				});
			} else {
				toastr.error('添加失败!');
			}
			/* 清空文本框内容 */
			$("#setno-add").val("");
			$("#attstart-add").val("");
			$("#attend-add").val("");
		}
	});
}

/* 修改配置信息 */
function modifyAttset() {
	$.ajax({
		type: 'post',
		url: '/attset/modify',
		contentType: 'application/json;charset=utf-8',
		data: JSON.stringify({
			"setno": $("#setno-modify").val(),
			"attstart": timeToMs($("#attstart-modify").val()),
			"attend": timeToMs($("#attend-modify").val()),
			"attflag": ($("#attflag-modify").val() == "是" ? 1 : 0)
		}),
		success: function(data) {
			if(data == "1") {
				toastr.success('修改成功!');
				$("#model-modify").modal('hide');
				$('#attset-table').bootstrapTable("refresh", {
					url: "/attset/show"
				});
			} else {
				toastr.error('修改失败!');
			}
		}
	});
	/* 清空文本框内容 */
	$("#setno-modify").val("");
	$("#attstart-modify").val("");
	$("#attend-modify").val("");
}

/* 删除配置信息 */
function delAttset(data) {
	alert(data.setno);
	// 发送删除请求
	$.ajax({
		type: 'delete',
		url: '/attset/del?setno=' + data.setno,
		contentType: 'application/json;charset=utf-8',
		success: function(data) {
			if(data == "1") {
				toastr.success('删除配置成功!');
				$('#attset-table').bootstrapTable("refresh", {
					url: "/attset/show"
				});
			} else {
				toastr.error('配置删除失败!');
			}
		}
	});
}

/* ----------------------------------------------- start --------------------------------------------- */
$(function() {
	// 初始化table
	initTable();
	// 表格高度
	$("#attset-table").bootstrapTable('resetView', {
		height: tableHeight()
	});

	/* 新增按钮点击事件 */
	$("#btn-add").click(function() {
		$("#model-add").modal();
	});

	/* 添加按钮 */
	$("#add").click(addAttset);

	/* 修改按钮点击事件 */
	$("#btn-edit").click(function() {
		var selectSet = $("#attset-table").bootstrapTable('getSelections');
		if(selectSet.length != 1) {
			toastr.warning("请先选择一个配置项");
		} else {
			/* 表单赋初值 */
			$("#setno-modify").val(selectSet[0].setno);
			$("#attstart-modify").val(timeFormatter(selectSet[0].attstart, 0, 0));
			$("#attend-modify").val(timeFormatter(selectSet[0].attend, 0, 0));
			setSelect("attflag-modify", flagFormatter(selectSet[0].attflag, 0, 0));
			$("#model-modify").modal();
		}
	});
	/* 修改保存按钮 */
	$("#modify").click(modifyAttset);

	/* 删除按钮点击事件 */
	$("#btn-del").click(function() {
		// 取得选中的配置
		var selectSet = $("#attset-table").bootstrapTable('getSelections');
		if(selectSet.length != 1) {
			toastr.warning("请选择一项配置！");
		} else {
			// 显示删除提示框
			BootstrapDialog.confirm({
				title: '删除配置',
				message: '您确定删除此配置项吗？',
				type: BootstrapDialog.TYPE_DANGER,
				btnCancelLabel: '取消',
				btnOKLabel: '删除',
				btnOKClass: 'btn-danger',
				callback: function(result) {
					if(result) delAttset(selectSet[0]);
				}
			});
		}
	});

	/* 配置编号单击恢复颜色 */
	$("#setno-add").click(function() {
		$("#setno-add").parent().parent().removeClass('has-error');
	});
	/* 判断配置编号是否重复 */
	$("#setno-add").blur(function() {
		$.get('/attset/distinct?setno=' + $("#setno-add").val(), function(data, status) {
			if(data != "1") {
				toastr.error('配置号/配置名已存在!');
				$("#setno-add").parent().parent().addClass('has-error');
			}
		});
	});

});

/* ----------------------------------------------- end ---------------------------------------------- */

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
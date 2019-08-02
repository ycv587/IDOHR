/* 查询方式 */
var batchStr = "all";

/* 计算表格高度 */
function tableHeight() {
	return $(window).height() - 52;
};

/* 根据窗口调整表格高度 */
$(window).resize(function() {
	$("#cdattend-table").bootstrapTable('resetView', {
		height: tableHeight()
	})
});

/* 加载表格内容 */
function initTable() {
	$("#cdattend-table").bootstrapTable({
		method: 'get', // 请求方式
		contentType: 'application/x-www-form-urlencoded',
		url: '/attend/cdshow', // 请求后台的URL
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
				orderName: params.sort, // 排序列
				batch: batchStr,
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
			field: 'attno',
			title: '考勤流水号',
			visible: false
		}, {
			field: 'employee.empno',
			title: '员工号',
			sortable: true
		}, {
			field: 'employee.ename',
			title: '姓名',
			sortable: true
		}, {
			field: 'ptime',
			title: '打卡时间',
			formatter: timeFormatter,
			sortable: true
		}, {
			field: 'pdate',
			title: '打卡日期',
			formatter: dateFormatter,
			sortable: true
		}, {
			field: 'attset.setno',
			title: '打卡批次',
			sortable: true
		}, {
			field: 'attset.attstart',
			title: '开始时间',
			formatter: timeFormatter,
			sortable: true,
			visible: false
		}, {
			field: 'attset.attend',
			title: '结束时间',
			formatter: timeFormatter,
			sortable: true,
			visible: false
		}]
	});
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

function selectAttend() {
	$("#model-select").modal('hide');
	batchStr = $("#setno-select option:selected").attr("id");
	$('#cdattend-table').bootstrapTable("refresh", {
		url: "/attend/cdshow"
	});
	toastr.success('查询成功!');
	batchStr = "all";
}

/* ----------------------------------------------- start --------------------------------------------- */
$(function() {

	// 初始化table
	initTable();

	// 表格高度
	$("#cdattend-table").bootstrapTable('resetView', {
		height: tableHeight()
	});

	/* 工具按钮点击事件 */
	$("#btn-view").click(function() {
		// 初始化表单
		$.ajax({
			type: 'get',
			url: '/attset/findon',
			async: false,
			success: function(data, status) {
				$("#setno-select").empty();
				$("#setno-select").append("<option id='all'>全部</option>")
				for(var i = 0; i < data.rows.length; i++) {
					$("#setno-select").append("<option id='" + data.rows[i].setno + "'>" + data.rows[i].setno + " [" + timeFormatter(data.rows[i].attstart) + "~" + timeFormatter(data.rows[i].attend) + "]" + "</option>")
				}
			}
		});
		$("#model-select").modal();
	});

	/* 查询按钮 */
	$("#select").click(selectAttend);

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
/* 查询方式 */
var batchStr = "0";

/* 计算表格高度 */
function tableHeight() {
	return $(window).height() - 52;
};

/* 根据窗口调整表格高度 */
$(window).resize(function() {
	$("#salary-table").bootstrapTable('resetView', {
		height : tableHeight()
	})
});

/* 加载表格内容 */
function initTable() {
	$("#salary-table").bootstrapTable({
		method : 'get', // 请求方式
		contentType : 'application/x-www-form-urlencoded',
		url : '/salary/show', // 请求后台的URL
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
				orderName : params.sort, // 排序列
				month : batchStr
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
			field : 'salno',
			title : '薪资记录号',
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
			field : 'basesal',
			title : '基础工资',
			sortable : true
		}, {
			field : 'overtime',
			title : '加班工时',
			sortable : true
		}, {
			field : 'osal',
			title : '加班工资',
			sortable : true
		}, {
			field : 'absence',
			title : '缺勤天数',
			sortable : true
		}, {
			field : 'asal',
			title : '缺勤扣款',
			sortable : true
		}, {
			field : 'lve',
			title : '事假天数',
			sortable : true
		}, {
			field : 'lsal',
			title : '事假扣款',
			sortable : true
		}, {
			field : 'sick',
			title : '病假天数',
			sortable : true
		}, {
			field : 'ssal',
			title : '病假扣款',
			sortable : true
		}, {
			field : 'tax',
			title : '个人所得税',
			sortable : true
		}, {
			field : 'ownfund',
			title : '五险一金',
			sortable : true
		}, {
			field : 'realsal',
			title : '实发工资',
			sortable : true
		}, {
			field : 'setdate',
			title : '结算日期',
			formatter : msToDt
		} ]
	});
}

/* 毫米值转日期时间 */
function msToDt(value, row, index) {
	var date = new Date();
	date.setTime(value);
	return date.Format("yy-MM");
}

/* 日期时间转毫秒值 */
function dtToMs(value) {
	return new Date(value).getTime();
}

$(function() {
	// 初始化table
	initTable();

	$("#btn-view").click(
			function() {
				$("#year-select").empty();
				for (i = 2018; i < 2030; i++) {
					$("#year-select").append(
							"<option id=" + i + ">" + i + "</option>");
				}
				$("#model-select").modal();
			});

	$("#select").click(function() {
		var year = $("#year-select option:selected").attr("id");
		var month = $("#month-select option:selected").attr("id");
		batchStr = new Date(year + "-" + month + "-05 00:00:00").getTime();
		$('#salary-table').bootstrapTable("refresh", {
			url : "/salary/show"
		});
		batchStr = "0";
		$("#model-select").modal('hide');
		toastr.success("查询成功");
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
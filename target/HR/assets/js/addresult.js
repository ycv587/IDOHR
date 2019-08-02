/* 查询方式 */
var batchStr = "all";

/* 计算表格高度 */
function tableHeight() {
	return $(window).height() - 52;
};

/* 根据窗口调整表格高度 */
$(window).resize(function() {
	$("#addresult-table").bootstrapTable('resetView', {
		height: tableHeight()
	})
});

/* 加载表格内容 */
function initTable() {
	$("#addresult-table").bootstrapTable({
		method: 'get', // 请求方式
		contentType: 'application/x-www-form-urlencoded',
		url: '/result/show', // 请求后台的URL
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
				merno: batchStr
			}
		}, // 请求服务器时传递参数
		singleSelect: true, // 禁止多选
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
		exportDataType: 'all',
		exportTypes: ['csv', 'txt', 'sql', 'doc', 'excel', 'xlsx', 'pdf'],
		columns: [{
			field: 'resno',
			title: '考核结果记录号',
			visible: false
		}, {
			field: 'employee.empno',
			title: '员工号',
			sortable: true
		}, {
			field: 'employee.ename',
			title: '员工姓名',
			sortable: true
		}, {
			field: 'merit.merno',
			title: '考核编号',
			visible: false
		}, {
			field: 'merit.assname',
			title: '考核名称',
			sortable: true
		}, {
			field: 'score',
			title: '分数',
			editable: {
				type: 'text',
				title: '分数',
				validate: function(v) {
					if(!$.trim(v)) {
						return '不能为空';
					}
					if(isNaN(v)) return '分数必须是数字';
					var s = parseInt(v);
					if(s < 0) return '分数必须是正数';
					if(s > 100) return '分数不能大于100';
				}
			}
		}],
		onEditableSave: function(field, row, oldValue, $el) {
			$.ajax({
				type: "post",
				url: "/result/edit",
				contentType: 'application/json;charset=utf-8',
				data: JSON.stringify({
					"resno": row.resno,
					"score": row.score
				}),
				success: function(data, status) {
					if(data == "1") {
						toastr.success('评分成功');
					}
				}
			});
		}
	});
}

function selectResult() {
	batchStr = $("#batch-select option:selected").attr("id");
	$('#addresult-table').bootstrapTable("refresh", {
		url: "/result/show"
	});
	$("#model-select").modal('hide');
	toastr.success('查询成功，请开始评分！');
	batchStr = "all";
}

function viewClick() {
	// 初始化表单
	$.ajax({
		type: 'get',
		url: '/merit/findnn',
		success: function(data, status) {
			for(var i = 0; i < data.length; i++) {
				$("#batch-select").append("<option id='" + data[i].merno + "'>" + data[i].assname + "</option>");
			}
		}
	});
	$("#model-select").modal({
		backdrop: 'static',
		keyboard: false
	});
}

/*
 * ----------------------------------------------- start
 * ---------------------------------------------
 */
$(function() {
	viewClick();

	// 初始化table
	initTable();

	// 表格高度
	$("#addresult-table").bootstrapTable('resetView', {
		height: tableHeight()
	});

	/* 工具按钮点击事件 */
	$("#btn-view").click(viewClick);

	/* 查询按钮 */
	$("#select").click(selectResult);

});

/*
 * ----------------------------------------------- end
 * ----------------------------------------------
 */

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
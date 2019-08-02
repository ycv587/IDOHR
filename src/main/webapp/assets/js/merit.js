/* 查询方式 */
var batchStr = "all";
var meritTime = 0;

/* 计算表格高度 */
function tableHeight() {
	return $(window).height() - 52;
};

/* 根据窗口调整表格高度 */
$(window).resize(function() {
	$("#merit-table").bootstrapTable('resetView', {
		height : tableHeight()
	})
});

/* 加载表格内容 */
function initTable() {
	$("#merit-table").bootstrapTable({
		method : 'get', // 请求方式
		contentType : 'application/x-www-form-urlencoded',
		url : '/merit/show', // 请求后台的URL
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
				way : batchStr,
				time : meritTime
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
			title : '#',
			checkbox : true
		}, {
			field : 'merno',
			title : '考核编号',
			visible : false
		}, {
			field : 'assname',
			title : '考核名称',
			sortable : true
		}, {
			field : 'starttime',
			title : '开始时间',
			formatter : msToDt,
			sortable : true
		}, {
			field : 'endtime',
			title : '结束时间',
			formatter : msToDt,
			sortable : true
		}, {
			field : 'initemp',
			title : '考核发起人'
		} ]
	});
}

/* 日期时间转毫秒值 */
function dtToMs(value, row, index) {
	return new Date(value).getTime();
}

/* 毫米值转日期时间 */
function msToDt(value, row, index) {
	var date = new Date();
	date.setTime(value);
	return date.Format("yyyy-MM-dd HH:mm:ss");
}

/* 毫秒转datetime-local */
function msToDtlocal(value) {
	var date = new Date();
	date.setTime(value);
	return date.Format("yyyy-MM-dd") + "T" + date.Format("HH:mm");
}

/* datetime-local转毫秒 */
function dtlocalToMs(value) {
	var date = value.replace('T', ' ');
	date += ":00";
	return new Date(date).getTime();
}

function selectAttend() {
	var isSel = $('input:radio[name="sway"]:checked').val();
//	alert(isSel);
	if (isSel == null) {
		toastr.warning('请选择一种查询方式！');
	} else {
		if (isSel == "sw1") {
			meritTime = dtToMs($("#date-start").val(), 0, 0);
		} else {
			batchStr = $("#batch-select option:selected").attr("id");
		}
		$('#merit-table').bootstrapTable("refresh", {
			url : "/merit/show"
		});
		$("#model-select").modal('hide');
		toastr.success('查询成功!');
		$("#date-start").val("");
		meritTime = 0;
		batchStr = "all";
	}
}

/*
 * ----------------------------------------------- start
 * ---------------------------------------------
 */
$(function() {

	// 初始化table
	initTable();

	// 表格高度
	$("#merit-table").bootstrapTable('resetView', {
		height : tableHeight()
	});

	/* 工具按钮点击事件 */
	$("#btn-view").click(function() {
		$("#date-start").attr('readonly', 'readonly');
		$("#batch-select").attr('readonly', 'readonly');
		$("#model-select").modal();
	});

	/* 查询按钮 */
	$("#select").click(selectAttend);

	/* 修改按钮 */
	$("#btn-edit").click(function() {
		var selectMerit = $("#merit-table").bootstrapTable('getSelections');
		if (selectMerit.length != 1) {
			toastr.warning("请先选择一次考核！");
		} else {
			/* 表单赋初值 */
			$("#assname-modify").val(selectMerit[0].assname);
			$("#starttime-modify").val(msToDtlocal(selectMerit[0].starttime));
			$("#endtime-modify").val(msToDtlocal(selectMerit[0].endtime));
			$("#model-modify").modal();
		}
	});

	$("#modify").click(function() {
		var selectMerit = $("#merit-table").bootstrapTable('getSelections');
		$.ajax({
			type : 'post',
			url : '/merit/modify',
			contentType : 'application/json;charset=utf-8',
			data : JSON.stringify({
				"merno" : selectMerit[0].merno,
				"assname" : $("#assname-modify").val(),
				"starttime" : dtlocalToMs($("#starttime-modify").val()),
				"endtime" : dtlocalToMs($("#endtime-modify").val())
			}),
			success : function(data) {
				if (data == "1") {
					toastr.success('修改成功!');
					$("#model-modify").modal('hide');
					$('#merit-table').bootstrapTable("refresh", {
						url : "/merit/show"
					});
				} else {
					toastr.error('修改失败!');
				}
			}
		});
	});

	/* 查询方式选择 */
	$("#sw1").click(function() {
		$("#date-start").removeAttr('readonly');
		$("#batch-select").attr('readonly', 'readonly');
	});
	$("#sw2").click(function() {
		$("#date-start").attr('readonly', 'readonly');
		$("#batch-select").removeAttr('readonly');
	});

});

/*
 * ----------------------------------------------- end
 * ----------------------------------------------
 */

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

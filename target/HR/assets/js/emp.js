/* 合同计数器 */
var contractIndex = 1;
/* 教育信息计数器 */
var educationIndex = 1;
/* 工作经历计数器 */
var jobhistoryIndex = 1;
/* 存储save按钮当前操作类型：add、modify、detail */
var saveType = "";

/* 计算表格高度 */
function tableHeight() {
	return $(window).height() - 52;
};

/* 根据窗口调整表格高度 */
$(window).resize(function() {
	$("#emp-table").bootstrapTable('resetView', {
		height: tableHeight()
	})
});

/* 加载表格内容 */
function initTable() {
	$("#emp-table").bootstrapTable({
		method: 'get', // 请求方式
		contentType: 'application/x-www-form-urlencoded',
		url: '/emp/show', // 请求后台的URL
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
		detailView: true, // 父子表
		showExport: true,
		exportDataType: "basic",
		exportOptions: {
			ignoreColumn: [0, 1], //忽略某一列的索引
			fileName: '员工信息', //文件名称设置  
			worksheetName: 'sheet1', //表格工作区名称  
			tableName: '员工信息',
			excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
		},
		columns: [{
			title: '#',
			checkbox: true
		}, {
			field: 'empno',
			title: '员工编号',
			sortable: true
		}, {
			field: 'ename',
			title: '姓名',
			sortable: true
		}, {
			field: 'gender',
			title: '性别',
			sortable: true
		}, {
			field: 'birthday',
			title: '出生日期',
			formatter: dateFormatter,
			sortable: true
		}, {
			field: 'age',
			title: '年龄',
			sortable: true
		}, {
			field: 'phone',
			title: '手机号码'
		}, {
			field: 'hiredate',
			title: '入职日期',
			formatter: dateFormatter,
			sortable: true
		}, {
			field: 'job.jname',
			title: '职位',
			sortable: true
		}, {
			field: 'department.dname',
			title: '部门',
			sortable: true
		}, {
			field: 'mgrname',
			title: '直属上级'
		}, {
			field: 'salary',
			title: '基本工资',
			sortable: true,
			visible: false
		}, {
			field: 'marriage',
			title: '婚姻状态',
			sortable: true,
			visible: false
		}, {
			field: 'address',
			title: '现住址',
			visible: false
		}, {
			field: 'nativeaddr',
			title: '籍贯',
			visible: false
		}, {
			field: 'peoples',
			title: '民族',
			visible: false
		}, {
			field: 'idcard',
			title: '身份证号',
			visible: false
		}, {
			field: 'estatus',
			title: '员工状态',
			sortable: true
		}, {
			field: 'blood',
			title: '血型',
			sortable: true,
			visible: false
		}, {
			field: 'political',
			title: '政治面貌',
			sortable: true,
			visible: false
		}, {
			field: 'close',
			title: '紧急联系人',
			visible: false
		}, {
			field: 'cphone',
			title: '紧急联系方式',
			visible: false
		}],
		//注册加载子表的事件
		onExpandRow: function(index, row, $detail) {
			initSubTable(index, row, $detail);
		},
		// 双击个人信息打开详细信息
		onDblClickRow: function(row) {
			modalDblClick(row);
		}
	});
}

/* 加载子表 */
function initSubTable(index, row, $detail) {
	var allData = $("#emp-table").bootstrapTable('getData');
	// 加载合同信息子表
	var subTable = $detail.html("<p class='h4'>合同信息：</p><table></table>").find('table');
	$(subTable).bootstrapTable({
		data: allData[index].labors,
		columns: [{
			field: 'labno',
			title: '合同记录号',
			visible: false
		}, {
			field: 'contract.conname',
			title: '合同名称',
			sortable: true
		}, {
			field: 'startdate',
			title: '合同开始日期',
			formatter: dateFormatter,
			sortable: true
		}, {
			field: 'enddate',
			title: '合同终止日期',
			formatter: dateFormatter,
			sortable: true
		}],
		rowStyle: function(row, index) {
			//这里有5个取值代表5种颜色['active', 'success', 'info', 'warning', 'danger'];
			var strclass = "";
			if(row.enddate >= (new Date())) {
				return {};
			} else {
				strclass = 'danger';
			}
			return {
				classes: strclass
			}
		}
	});
	// 加载教育经历子表
	var subTable = $detail.append("<br><p class='h4'>教育背景：</p><table></table>").find('table');
	$(subTable).bootstrapTable({
		data: allData[index].educations,
		columns: [{
			field: 'eduno',
			title: '教育经历记录号',
			visible: false
		}, {
			field: 'gschool',
			title: '毕业院校'
		}, {
			field: 'majors',
			title: '所学专业',
			sortable: true
		}, {
			field: 'gyear',
			title: '毕业时间',
			formatter: dateFormatter,
			sortable: true
		}, {
			field: 'diploma',
			title: '学历',
			sortable: true
		}]
	});
	// 加载工作经历子表
	var subTable = $detail.append("<br><p class='h4'>工作经历：</p><table></table>").find('table');
	$(subTable).bootstrapTable({
		data: allData[index].jobhistories,
		columns: [{
			field: 'hisno',
			title: '工作经历记录号',
			visible: false
		}, {
			field: 'company',
			title: '公司名称'
		}, {
			field: 'job',
			title: '担任职务'
		}, {
			field: 'hhire',
			title: '入职日期',
			formatter: dateFormatter,
			sortable: true
		}, {
			field: 'hquit',
			title: '离职日期',
			formatter: dateFormatter,
			sortable: true
		}]
	});
}

/* 年龄自动计算 */
function setAge() {
	if($("#birthday").val() == null) return;
	var age = Math.floor(((new Date()).getTime() - new Date($("#birthday").val()).getTime()) / (1000 * 60 * 60 * 24 * 365.2422));
	$("#age").val(age);
}

/* 日期格式化 */
function dateFormatter(value, row, index) {
	var date = new Date();
	date.setTime(value);
	return date.Format("yyyy-MM-dd");
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

/* 获取部门、员工、职位、合同信息 */
function setModalInfos() {
	// 部门信息
	$.ajax({
		type: 'get',
		url: '/dept/findnameandno',
		async: false,
		success: function(data, status) {
			for(var i = 0; i < data.length; i++) {
				$("#dept").append("<option id='" + data[i].deptno + "'>" + data[i].dname + "</option>")
			}
		}
	});
	// 直属上级信息
	$.ajax({
		type: 'get',
		url: '/emp/findnameandno',
		async: false,
		success: function(data, status) {
			for(var i = 0; i < data.length; i++) {
				$("#mgr").append("<option id='" + data[i].empno + "'>" + data[i].ename + "</option>")
			}
		}
	});
	// 职位信息
	$.ajax({
		type: 'get',
		url: '/job/findnameandno',
		async: false,
		success: function(data, status) {
			for(var i = 0; i < data.length; i++) {
				$("#job").append("<option id='" + data[i].jobid + "'>" + data[i].jname + "</option>")
			}
		}
	});
	// 合同信息
	$.ajax({
		type: 'get',
		url: '/contract/findnameandno',
		async: false,
		success: function(data, status) {
			for(var i = 0; i < data.length; i++) {
				$("#contract0").append("<option name='" + data[i].conno + "'>" + data[i].conname + "</option>")
			}
		}
	});
}

/* 获取员工表单填写内容的JSON数据 */
function getWriteInfo() {
	// 组合合同信息
	var contracts = new Array();
	for(var i = 0; i < contractIndex; i++) {
		var contract = {
			"contract": {
				"conno": $("#contract" + i + " option:selected").attr('name')
			},
			"startdate": $("#startdate" + i).val(),
			"enddate": $("#enddate" + i).val(),
			"empno": $("#empno").val()
		};
		contracts[contracts.length] = contract;
	}
	// 组合教育信息
	var educations = new Array();
	for(var j = 0; j < educationIndex; j++) {
		var education = {
			"gschool": $("#gschool" + j).val(),
			"majors": $("#majors" + j).val(),
			"gyear": $("#gyear" + j).val(),
			"diploma": $("#diploma" + j).val(),
			"empno": $("#empno").val()
		}
		educations[educations.length] = education;
	}
	// 组合工作经历
	var jobhistories = new Array();
	for(var k = 0; k < jobhistoryIndex; k++) {
		var jobhistory = {
			"company": $("#company" + k).val(),
			"job": $("#job" + k).val(),
			"hhire": $("#hhire" + k).val(),
			"hquit": $("#hquit" + k).val(),
			"empno": $("#empno").val()
		}
		jobhistories[jobhistories.length] = jobhistory;
	}
	var data = {
		"empno": $("#empno").val(),
		"ename": $("#ename").val(),
		"gender": $("#gender").val(),
		"birthday": $("#birthday").val(),
		"age": $("#age").val(),
		"phone": $("#phone").val(),
		"idcard": $("#idcard").val(),
		"marriage": $("#marriage").val(),
		"peoples": $("#peoples").val(),
		"blood": $("#blood").val(),
		"political": $("#political").val(),
		"close": $("#close").val(),
		"cphone": $("#cphone").val(),
		"nativeaddr": $("#nativeaddr").val(),
		"address": $("#address").val(),
		"department": {
			"deptno": $("#dept option:selected").attr("id")
		},
		"job": {
			"jobid": $("#job option:selected").attr("id")
		},
		"mgr": $("#mgr option:selected").attr("id"),
		"salary": $("#esalary").val(),
		"hiredate": $("#hiredate").val(),
		"estatus": $("#estatus option:selected").val(),
		/*"password": hex_sha1($("#password").val()),*/
		/* 福利信息 */
		"card": {
			"empno": $("#empno").val(),
			"socac": $("#socac").val(),
			"socaddr": $("#socaddr").val(),
			"salaryac": $("#salaryac").val(),
			"saladdr": $("#saladdr").val(),
			"provideac": $("#provideac").val(),
			"proaddr": $("#proaddr").val()
		},
		/* 合同信息 */
		"labors": contracts,
		/* 教育信息 */
		"educations": educations,
		/* 工作经历 */
		"jobhistories": jobhistories
	}
	var pwd = $("#password").val();
	if(pwd != null && pwd.trim() != "") {
		data.password = hex_sha1($("#password").val());
	}
	// 修改时添加各项的主键
	if(saveType == "modify") {
		var selectEmp = $("#emp-table").bootstrapTable('getSelections')[0];
		data.card.carno = selectEmp.card.carno;
		data.educations[0].eduno = selectEmp.educations[0].eduno;
		for(var i = 1; i < educationIndex; i++) {
			data.educations[i].eduno = selectEmp.educations[i].eduno;
		}
		data.jobhistories[0].hisno = selectEmp.jobhistories[0].hisno;
		for(var i = 1; i < jobhistoryIndex; i++) {
			data.jobhistories[i].hisno = selectEmp.jobhistories[i].hisno;
		}
		data.labors[0].labno = selectEmp.labors[0].labno;
		for(var i = 1; i < contractIndex; i++) {
			data.jobhistories[i].labno = selectEmp.jobhistories[i].labno;
		}
	}
	return data;
}

/* 添加、修改时检查信息完整性 */
function checkWriteInfo(type) {
	var isLegal = true;
	// 检查没有填写的项
	// 基本信息、职位信息
	isLegal = falseTran("ename") ? isLegal : false;
	isLegal = falseTran("birthday") ? isLegal : false;
	isLegal = falseTran("phone") ? isLegal : false;
	if(type == "add") {
		isLegal = falseTran("password") ? isLegal : false;
	}
	isLegal = falseTran("hiredate") ? isLegal : false;
	//isLegal = falseTran("esalary") ? isLegal : false;
	isLegal = falseTran("empno") ? isLegal : false;
	isLegal = falseTran("address") ? isLegal : false;
	isLegal = falseTran("nativeaddr") ? isLegal : false;
	isLegal = falseTran("cphone") ? isLegal : false;
	isLegal = falseTran("idcard") ? isLegal : false;
	isLegal = falseTran("close") ? isLegal : false;
	isLegal = falseTran("socac") ? isLegal : false;
	isLegal = falseTran("socaddr") ? isLegal : false;
	isLegal = falseTran("salaryac") ? isLegal : false;
	isLegal = falseTran("saladdr") ? isLegal : false;
	isLegal = falseTran("provideac") ? isLegal : false;
	isLegal = falseTran("proaddr") ? isLegal : false;

	/* 合同信息 */
	for(var i = 0; i < contractIndex; i++) {
		isLegal = falseTran("startdate" + i) ? isLegal : false;
		isLegal = falseTran("enddate" + i) ? isLegal : false;
	}
	console.log("contractIndex : %d ", contractIndex);
	/* 教育信息 */
	for(var j = 0; j < educationIndex; j++) {
		isLegal = falseTran("gschool" + j) ? isLegal : false;
		isLegal = falseTran("majors" + j) ? isLegal : false;
		isLegal = falseTran("gyear" + j) ? isLegal : false;
		isLegal = falseTran("diploma" + j) ? isLegal : false;
	}
	console.log("educationIndex : %d", educationIndex);
	/* 工作经历 */
	for(var k = 0; k < jobhistoryIndex; k++) {
		isLegal = falseTran("company" + k) ? isLegal : false;
		isLegal = falseTran("job" + k) ? isLegal : false;
		isLegal = falseTran("hhire" + k) ? isLegal : false;
		isLegal = falseTran("hquit" + k) ? isLegal : false;
	}
	console.log("jobhistoryIndex : %d", jobhistoryIndex);
	return isLegal;
}

/* 检验数据项是否为空，增加颜色效果 */
function falseTran(elemid) {
	tmpStr = $("#" + elemid).val();
	if((tmpStr == null) || (tmpStr == "")) {
		$("#" + elemid).parent().prev().css('color', '#A94442');
		$("#" + elemid).css('border-color', '#A94442');
		console.log("%s is false of falseTran in line 499", elemid);
		return false;
	} else {
		$("#" + elemid).parent().prev().css('color', '#333');
		$("#" + elemid).css('border-color', '#ccc');
		return true;
	}
}

/* 员工编号查重 */
function empDistinct() {
	$.get('/emp/distinct?empno=' + $("#empno").val(), function(data, status) {
		if(data != "1") {
			toastr.error('该员工编号已被占用!');
			$("#empno").parent().prev().css('color', '#A94442');
			$("#empno").css('border-color', '#A94442');
		} else {
			$("#empno").parent().prev().css('color', '#333');
			$("#empno").css('border-color', '#ccc');
		}
	});
}

/* 添加员工 */
function addEmp(data) {
	console.log(data);
	$.ajax({
		type: 'put',
		url: '/emp/add',
		contentType: 'application/json;charset=utf-8',
		data: data,
		success: function(data) {
			if(data == "1") {
				toastr.success('添加成功!');
				// 关闭窗体，清空内容
				$("#model-emp").modal('hide');
				clearWriteInfo();
				$('#emp-table').bootstrapTable("refresh", {
					url: "/emp/show"
				});
			} else {
				toastr.error('添加失败!');
			}
		}
	});
}

/* 添加额外合同信息 */
function addExtrContract(index, type) {
	// 根据类型判断添加的额外信息是否只读
	var readonly = type == "detail" ? "readonly" : "";
	var contractView = "<div id='contracts" + index + "'><div class='form-group'>";
	contractView += "<label for='contract" + index + "' class='control-label col-sm-2'>劳务合同</label>";
	contractView += "<div class='col-sm-9'>";
	contractView += "<select class='form-control' id='contract" + index + "' " + readonly + "></select></div>";
	contractView += "<div class='col-sm-1'><i class='glyphicon glyphicon-minus btn btn-danger' id='contracts-remove-" + index + "' onclick='removeInfos(this)'></i></div></div>";
	contractView += "<div class='form-group'>";
	contractView += "<label for='startdate" + index + "' class='control-label col-sm-2'>合同起始日</label>";
	contractView += "<div class='col-sm-4'>";
	contractView += "<input type='date' class='form-control' id='startdate" + index + "' " + readonly + "></div>";
	contractView += "<label for='enddate" + index + "' class='control-label col-sm-2'>合同终止日</label>";
	contractView += "<div class='col-sm-3'>";
	contractView += "<input type='date' class='form-control' id='enddate" + index + "' " + readonly + "></div></div></div>";
	$("#labors").append(contractView);
	for(var i = 1; i < index; i++) {
		$("#contracts-remove-" + i).hide();
	}
	// 拷贝合同信息到新添加项
	$("#contract" + index).append($("#contract0").children().clone());
}

/* 添加额外教育信息 */
function addExtrEducation(index, type) {
	// 根据类型判断添加的额外信息是否只读
	var readonly = type == "detail" ? "readonly" : "";
	var educationView = "<div id='education" + index + "'><div class='form-group'>";
	educationView += "<label for='gschool" + index + "' class='control-label col-sm-2'>毕业院校</label>";
	educationView += "<div class='col-sm-4'>";
	educationView += "<input type='text' class='form-control' id='gschool" + index + "' maxlength='50' " + readonly + "></div>";
	educationView += "<label for='majors" + index + "' class='control-label col-sm-2'>所在专业</label>";
	educationView += "<div class='col-sm-3'>";
	educationView += "<input type='text' class='form-control' id='majors" + index + "' maxlength='50' " + readonly + "></div>";
	educationView += "<div class='col-sm-1'><i class='glyphicon glyphicon-minus btn btn-danger' id='education-remove-" + index + "' onclick='removeInfos(this)'></i></div></div>";
	educationView += "<div class='form-group'>";
	educationView += "<label for='gyear" + index + "' class='control-label col-sm-2'>毕业时间</label>";
	educationView += "<div class='col-sm-4'>";
	educationView += "<input type='date' class='form-control' id='gyear" + index + "' " + readonly + "></div>";
	educationView += "<label for='diploma" + index + "' class='control-label col-sm-2'>学历</label>";
	educationView += "<div class='col-sm-3'>";
	educationView += "<input type='text' class='form-control' id='diploma" + index + "' maxlength='50' " + readonly + "></div></div></div>";
	$("#educations").append(educationView);
	// 隐藏之前的删除按钮
	for(var i = 1; i < index; i++) {
		$("#education-remove-" + i).hide();
	}
}

/* 添加额外工作经历 */
function addExtrJobhistory(index, type) {
	// 根据类型判断添加的额外信息是否只读
	var readonly = type == "detail" ? "readonly" : "";
	var jobhistoryView = "<div id='jobhistory" + index + "'><div class='form-group'>";
	jobhistoryView += "<label for='company" + index + "' class='control-label col-sm-2'>公司名称</label>";
	jobhistoryView += "<div class='col-sm-4'>";
	jobhistoryView += "<input type='text' class='form-control' id='company" + index + "' maxlength='50' " + readonly + "></div>";
	jobhistoryView += "<label for='job" + index + "-" + type + "' class='control-label col-sm-2'>担任职位</label>";
	jobhistoryView += "<div class='col-sm-3'>";
	jobhistoryView += "<input type='text' class='form-control' id='job" + index + "' maxlength='50' " + readonly + "></div>";
	jobhistoryView += "<div class='col-sm-1'><i class='glyphicon glyphicon-minus btn btn-danger' id='jobhistory-remove-" + index + "' onclick='removeInfos(this)'></i></div></div>";
	jobhistoryView += "<div class='form-group'>";
	jobhistoryView += "<label for='hhire" + index + "' class='control-label col-sm-2'>入职日期</label>";
	jobhistoryView += "<div class='col-sm-4'>";
	jobhistoryView += "<input type='date' class='form-control' id='hhire" + index + "' " + readonly + "></div>";
	jobhistoryView += "<label for='hquit" + index + "' class='control-label col-sm-2'>离职日期</label>";
	jobhistoryView += "<div class='col-sm-3'>";
	jobhistoryView += "<input type='date' class='form-control' id='hquit" + index + "' " + readonly + "></div></div></div>";
	$("#jobhistories").append(jobhistoryView);
	// 隐藏之前的删除按钮
	for(var i = 1; i < index; i++) {
		$("#jobhistory-remove-" + i).hide();
	}
}

/* 添加额外合同信息按钮点击 */
function addExtrContractClick() {
	addExtrContract(contractIndex++, "add");
}

/* 添加额外教育信息按钮点击 */
function addExtrEducationClick() {
	if(educationIndex > 4) {
		toastr.warning("最多只能添加五项教育信息");
		return;
	}
	addExtrEducation(educationIndex++, "add");
}

/* 添加额外工作经历按钮点击 */
function addExtrJobhistoryClick() {
	if(jobhistoryIndex > 4) {
		toastr.warning("最多只能添加五项工作经历");
		return;
	}
	addExtrJobhistory(jobhistoryIndex++, "add");
}

/* 移除一条额外记录 */
function removeInfos(elem) {
	// 取到所点击的删除按钮的id
	var id = $(elem).attr('id');
	// 分割id，第一部分为删除项，第二部门为remove字符串，第三部分为要删除的id后缀
	var delInfo = id.split('-');
	// 第一部分和第三部分组合生成id，删除
	$("#" + delInfo[0] + delInfo[2]).remove();
	// 根据删除的项，对应的计数器下标-1
	var tmpIndex = delInfo[0] == "contracts" ? (--contractIndex) : delInfo[0] == "education" ? (--educationIndex) : (--jobhistoryIndex);
	// 上一个移除按钮显示
	$("#" + delInfo[0] + "-remove-" + (parseInt(delInfo[2]) - 1)).show();
}

/* 清空模态框中填写的内容，模态框初始化 */
function clearWriteInfo() {
	// 清除基本信息、职位信息内容
	$("#empno").val("");
	$("#empno").parent().prev().css('color', '#333');
	$("#empno").css('border-color', '#ccc');
	$("#ename").val("");
	$("#ename").parent().prev().css('color', '#333');
	$("#ename").css('border-color', '#ccc');
	$("#birthday").val("");
	$("#birthday").parent().prev().css('color', '#333');
	$("#birthday").css('border-color', '#ccc');
	$("#age").val("");
	$("#age").parent().prev().css('color', '#333');
	$("#age").css('border-color', '#ccc');
	$("#phone").val("");
	$("#phone").parent().prev().css('color', '#333');
	$("#phone").css('border-color', '#ccc');
	$("#idcard").val("");
	$("#idcard").parent().prev().css('color', '#333');
	$("#idcard").css('border-color', '#ccc');
	$("#close").val("");
	$("#close").parent().prev().css('color', '#333');
	$("#close").css('border-color', '#ccc');
	$("#cphone").val("");
	$("#cphone").parent().prev().css('color', '#333');
	$("#cphone").css('border-color', '#ccc');
	$("#nativeaddr").val("");
	$("#nativeaddr").parent().prev().css('color', '#333');
	$("#nativeaddr").css('border-color', '#ccc');
	$("#address").val("");
	$("#address").parent().prev().css('color', '#333');
	$("#address").css('border-color', '#ccc');
	$("#dept").empty();
	$("#job").empty();
	$("#mgr").empty();
	$("#esalary").val("");
	$("#esalary").parent().prev().css('color', '#333');
	$("#esalary").css('border-color', '#ccc');
	$("#hiredate").val("");
	$("#hiredate").parent().prev().css('color', '#333');
	$("#hiredate").css('border-color', '#ccc');
	$("#password").val("");
	$("#password").parent().prev().css('color', '#333');
	$("#password").css('border-color', '#ccc');
	// 清空合同信息
	$("#contract0").val("");
	$("#contract0").parent().prev().css('color', '#333');
	$("#contract0").css('border-color', '#ccc');
	$("#startdate0").val("");
	$("#startdate0").parent().prev().css('color', '#333');
	$("#startdate0").css('border-color', '#ccc');
	$("#enddate0").val("");
	$("#enddate0").parent().prev().css('color', '#333');
	$("#enddate0").css('border-color', '#ccc');
	$("#labors").empty();
	// 清空教育信息
	$("#gschool0").val("");
	$("#gschool0").parent().prev().css('color', '#333');
	$("#gschool0").css('border-color', '#ccc');
	$("#majors0").val("");
	$("#majors0").parent().prev().css('color', '#333');
	$("#majors0").css('border-color', '#ccc');
	$("#gyear0").val("");
	$("#gyear0").parent().prev().css('color', '#333');
	$("#gyear0").css('border-color', '#ccc');
	$("#diploma0").val("");
	$("#diploma0").parent().prev().css('color', '#333');
	$("#diploma0").css('border-color', '#ccc');
	$("#educations").empty();
	// 清空工作历史信息
	$("#company0").val("");
	$("#company0").parent().prev().css('color', '#333');
	$("#company0").css('border-color', '#ccc');
	$("#job0").val("");
	$("#job0").parent().prev().css('color', '#333');
	$("#job0").css('border-color', '#ccc');
	$("#hhire0").val("");
	$("#hhire0").parent().prev().css('color', '#333');
	$("#hhire0").css('border-color', '#ccc');
	$("#hquit0").val("");
	$("#hquit0").parent().prev().css('color', '#333');
	$("#hquit0").css('border-color', '#ccc');
	$("#jobhistories").empty();
	// 清空福利信息
	$("#socac").val("");
	$("#socac").parent().prev().css('color', '#333');
	$("#socac").css('border-color', '#ccc');
	$("#socaddr").val("");
	$("#socaddr").parent().prev().css('color', '#333');
	$("#socaddr").css('border-color', '#ccc');
	$("#salaryac").val("");
	$("#salaryac").parent().prev().css('color', '#333');
	$("#salaryac").css('border-color', '#ccc');
	$("#saladdr").val("");
	$("#saladdr").parent().prev().css('color', '#333');
	$("#saladdr").css('border-color', '#ccc');
	$("#provideac").val("");
	$("#provideac").parent().prev().css('color', '#333');
	$("#provideac").css('border-color', '#ccc');
	$("#proaddr").val("");
	$("#proaddr").parent().prev().css('color', '#333');
	$("#proaddr").css('border-color', '#ccc');
	// 初始化额外信息计数器
	contractIndex = 1;
	educationIndex = 1;
	jobhistoryIndex = 1;
	// 清除只读属性
	cancelReadOnly();
	// 恢复下方按钮
	$("#cancel").text("取消");
	$("#save").show();
}

/* 添加员工按钮点击 */
function addBtnClick() {
	// 显示模态对话框，不可点击空白处关闭
	$("#header-txt").text("新增员工");
	$("#model-emp").modal({
		backdrop: 'static',
		keyboard: false
	});
	// 获取部门、职位、人员、合同信息，初始化下拉菜单的值
	setModalInfos();
	// 初始化额外信息计数器
	contractIndex = 1;
	educationIndex = 1;
	jobhistoryIndex = 1;
	// 改变当前save按钮操作状态
	saveType = "add";
}

/* 员工删除按钮点击 */
function delBtnClick() {
	// 取得选中的员工
	var selectEmps = $("#emp-table").bootstrapTable('getSelections');
	if(selectEmps.length != 1) {
		toastr.warning("请选择一个员工");
	} else {
		// 显示删除提示框
		BootstrapDialog.confirm({
			title: '删除员工',
			message: '删除操作将会丢失所有与该员工有关的资料！请谨慎操作!',
			type: BootstrapDialog.TYPE_DANGER,
			btnCancelLabel: '取消',
			btnOKLabel: '删除',
			btnOKClass: 'btn-danger',
			callback: function(result) {
				if(result) delEmp(selectEmps[0]);
			}
		});
	}
}

/* 删除员工信息 */
function delEmp(data) {
	// 发送删除请求
	$.ajax({
		type: 'delete',
		url: '/emp/del',
		contentType: 'application/json;charset=utf-8',
		data: JSON.stringify(new Array(data.empno)),
		success: function(data) {
			if(data == "1") {
				toastr.success('删除员工成功!');
				$('#emp-table').bootstrapTable("refresh", {
					url: "/emp/show"
				});
			} else {
				toastr.error('员工删除失败!');
			}
		}
	});
}

/* 初始化modal窗体内容（修改员工信息） */
function initModalData(data) {
	// 填充下拉列表内容
	setModalInfos();
	// 基本信息
	$("#ename").val(data.ename);
	// 处理下拉列表的初始值
	setSelect("gender", data.gender);
	// 处理input date
	$("#birthday").val(dateFormatter(data.birthday, 0, 0));
	$("#age").val(data.age);
	$("#phone").val(data.phone);
	$("#idcard").val(data.idcard);
	setSelect("marriage", data.marriage);
	setSelect("peoples", data.peoples);
	setSelect("blood", data.blood);
	setSelect("political", data.political);
	$("#close").val(data.close);
	$("#cphone").val(data.cphone);
	$("#nativeaddr").val(data.nativeaddr);
	$("#address").val(data.address);
	// 职位信息
	$("#empno").val(data.empno);
	setSelect("dept", data.department.dname);
	setSelect("job", data.job.jname);
	setSelect("mgr", data.mgrname);
	$("#esalary").val(data.salary);
	$("#hiredate").val(dateFormatter(data.hiredate, 0, 0));
	setSelect("estatus", data.estatus);
	// 密码默认不加载
	// 合同信息
	setSelect("contract0", data.labors[0].contract.conname);
	$("#startdate0").val(dateFormatter(data.labors[0].startdate, 0, 0));
	$("#enddate0").val(dateFormatter(data.labors[0].enddate, 0, 0));
	for(var i = 1; i < data.labors.length; i++) {
		// 插入内容
		addExtrContractClick();
		setSelect("contract" + i, data.labors[i].contract.conname);
		$("#startdate0" + i).val(dateFormatter(data.labors[i].startdate, 0, 0));
		$("#enddate0" + i).val(dateFormatter(data.labors[i].enddate, 0, 0));
	}
	// 教育背景信息
	$("#gschool0").val(data.educations[0].gschool);
	$("#majors0").val(data.educations[0].majors);
	$("#gyear0").val(dateFormatter(data.educations[0].gyear, 0, 0));
	$("#diploma0").val(data.educations[0].diploma);
	for(var i = 1; i < data.educations.length; i++) {
		addExtrEducationClick();
		$("#gschool" + i).val(data.educations[i].gschool);
		$("#majors" + i).val(data.educations[i].majors);
		$("#gyear" + i).val(dateFormatter(data.educations[i].gyear, 0, 0));
		$("#diploma" + i).val(data.educations[i].diploma);
	}
	// 工作经历
	$("#company0").val(data.jobhistories[0].company);
	$("#job0").val(data.jobhistories[0].job);
	$("#hhire0").val(dateFormatter(data.jobhistories[0].hhire, 0, 0));
	$("#hquit0").val(dateFormatter(data.jobhistories[0].hquit, 0, 0));
	for(var i = 1; i < data.jobhistories.length; i++) {
		addExtrJobhistoryClick();
		$("#company" + i).val(data.jobhistories[i].company);
		$("#job" + i).val(data.jobhistories[i].job);
		$("#hhire" + i).val(dateFormatter(data.jobhistories[i].hhire, 0, 0));
		$("#hquit" + i).val(dateFormatter(data.jobhistories[i].hquit, 0, 0));
	}
	// 福利信息
	$("#socac").val(data.card.socac);
	$("#socaddr").val(data.card.socaddr);
	$("#salaryac").val(data.card.salaryac);
	$("#saladdr").val(data.card.saladdr);
	$("#provideac").val(data.card.provideac);
	$("#proaddr").val(data.card.proaddr);

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

/* 模态框编辑按钮点击 */
function editBtnClick() {
	// 取得选中的员工
	var selectEmps = $("#emp-table").bootstrapTable('getSelections');
	if(selectEmps.length != 1) {
		toastr.warning("请选择一个员工");
	} else {
		// 初始化员工数据
		initModalData(selectEmps[0]);
		// 打开模态框
		$("#header-txt").text("修改员工信息");
		$("#model-emp").modal({
			backdrop: 'static',
			keyboard: false
		});
		// 初始化额外信息计数器
		contractIndex = selectEmps[0].labors.length;
		educationIndex = selectEmps[0].educations.length;
		jobhistoryIndex = selectEmps[0].jobhistories.length;
		console.log(contractIndex + "" + educationIndex + "" + jobhistoryIndex);
		// 改变当前save按钮操作状态
		saveType = "modify";
	}
}

/* 修改员工信息 */
function modifyEmp(data) {
	//发送保存请求
	$.ajax({
		type: 'post',
		url: '/emp/modify',
		contentType: 'application/json;charset=utf-8',
		data: data,
		success: function(data) {
			if(data == "1") {
				toastr.success('修改成功!');
				$('#emp-table').bootstrapTable("refresh", {
					url: "/emp/show"
				});
				$("#model-emp").modal('hide');
				clearWriteInfo();
			} else {
				toastr.error('修改失败!');
			}
		}
	});
}

/* 行双击打开详细信息 */
function modalDblClick(data) {
	saveType = "detail";
	// 修改按钮状态
	$("#cancel").text("确定");
	$("#save").hide();
	// 初始化个人信息
	initModalData(data);
	// 设置所有内容只读
	setReadOnly();
	// 显示模态框
	$("#header-txt").text("员工信息");
	$("#model-emp").modal({
		backdrop: 'static',
		keyboard: false
	});
}

/* 设置选项只读 */
function setReadOnly() {
	// 基本信息
	$("#empno").attr('readonly', 'readonly');
	$("#ename").attr('readonly', 'readonly');
	$("#birthday").attr('readonly', 'readonly');
	$("#gender").attr('readonly', 'readonly');
	$("#age").attr('readonly', 'readonly');
	$("#phone").attr('readonly', 'readonly');
	$("#idcard").attr('readonly', 'readonly');
	$("#marriage").attr('readonly', 'readonly');
	$("#peoples").attr('readonly', 'readonly');
	$("#blood").attr('readonly', 'readonly');
	$("#political").attr('readonly', 'readonly');
	$("#close").attr('readonly', 'readonly');
	$("#cphone").attr('readonly', 'readonly');
	$("#nativeaddr").attr('readonly', 'readonly');
	$("#address").attr('readonly', 'readonly');
	$("#dept").attr('readonly', 'readonly');
	$("#job").attr('readonly', 'readonly');
	$("#mgr").attr('readonly', 'readonly');
	$("#esalary").attr('readonly', 'readonly');
	$("#estatus").attr('readonly', 'readonly');
	$("#hiredate").attr('readonly', 'readonly');
	$("#password").attr('readonly', 'readonly');
	// 合同信息
	$("#contract-extr").hide();
	for(var i = 0; i < contractIndex; i++) {
		$("#contract" + i).attr('readonly', 'readonly');
		$("#startdate" + i).attr('readonly', 'readonly');
		$("#enddate" + i).attr('readonly', 'readonly');
		$("#contract-remove-" + i).hide();
	}
	// 教育信息
	$("#education-extr").hide();
	for(var i = 0; i < educationIndex; i++) {
		$("#gschool" + i).attr('readonly', 'readonly');
		$("#majors" + i).attr('readonly', 'readonly');
		$("#gyear" + i).attr('readonly', 'readonly');
		$("#diploma" + i).attr('readonly', 'readonly');
		$("#education-remove-" + i).hide();
	}
	// 工作历史信息
	$("#jobhistory-extr").hide();
	for(var i = 0; i < jobhistoryIndex; i++) {
		$("#company" + i).attr('readonly', 'readonly');
		$("#job" + i).attr('readonly', 'readonly');
		$("#hhire" + i).attr('readonly', 'readonly');
		$("#hquit" + i).attr('readonly', 'readonly');
		$("#jobhistory-remove-" + i).hide();
	}
	// 福利信息
	$("#socac").attr('readonly', 'readonly');
	$("#socaddr").attr('readonly', 'readonly');
	$("#salaryac").attr('readonly', 'readonly');
	$("#saladdr").attr('readonly', 'readonly');
	$("#provideac").attr('readonly', 'readonly');
	$("#proaddr").attr('readonly', 'readonly');
}

/* 取消只读 */
function cancelReadOnly() {
	// 基本信息
	$("#empno").removeAttr('readonly');
	$("#ename").removeAttr('readonly');
	$("#birthday").removeAttr('readonly');
	$("#gender").removeAttr('readonly');
	$("#age").removeAttr('readonly');
	$("#phone").removeAttr('readonly');
	$("#idcard").removeAttr('readonly');
	$("#marriage").removeAttr('readonly');
	$("#peoples").removeAttr('readonly');
	$("#blood").removeAttr('readonly');
	$("#political").removeAttr('readonly');
	$("#close").removeAttr('readonly');
	$("#cphone").removeAttr('readonly');
	$("#nativeaddr").removeAttr('readonly');
	$("#address").removeAttr('readonly');
	$("#dept").removeAttr('readonly');
	$("#job").removeAttr('readonly');
	$("#mgr").removeAttr('readonly');
	$("#esalary").removeAttr('readonly');
	$("#estatus").removeAttr('readonly');
	$("#hiredate").removeAttr('readonly');
	$("#password").removeAttr('readonly');
	// 合同信息
	$("#contract-extr").show();
	for(var i = 0; i < contractIndex; i++) {
		$("#contract" + i).removeAttr('readonly');
		$("#startdate" + i).removeAttr('readonly');
		$("#enddate" + i).removeAttr('readonly');
		$("#contract-remove-" + i).show();
	}
	// 教育信息
	$("#education-extr").show();
	for(var i = 0; i < educationIndex; i++) {
		$("#gschool" + i).removeAttr('readonly');
		$("#majors" + i).removeAttr('readonly');
		$("#gyear" + i).removeAttr('readonly');
		$("#diploma" + i).removeAttr('readonly');
		$("#education-remove-" + i).show();
	}
	// 工作历史信息
	$("#jobhistory-extr").show();
	for(var i = 0; i < jobhistoryIndex; i++) {
		$("#company" + i).removeAttr('readonly');
		$("#job" + i).removeAttr('readonly');
		$("#hhire" + i).removeAttr('readonly');
		$("#hquit" + i).removeAttr('readonly');
		$("#jobhistory-remove-" + i).show();
	}
	// 福利信息
	$("#socac").removeAttr('readonly');
	$("#socaddr").removeAttr('readonly');
	$("#salaryac").removeAttr('readonly');
	$("#saladdr").removeAttr('readonly');
	$("#provideac").removeAttr('readonly');
	$("#proaddr").removeAttr('readonly');
}

/* 模态框保存按钮点击 */
function saveBtnClick() {
	// 判断操作类型
	if(saveType == "add") {
		// 检查信息填写的完整性
		if(!checkWriteInfo("add")) {
			toastr.warning("请将信息填写完整！");
			return;
		}
		// 添加员工
		addEmp(JSON.stringify(getWriteInfo()));
	} else if(saveType == "modify") {
		if(!checkWriteInfo("modify")) {
			toastr.warning("请将信息填写完整！");
			return;
		}
		modifyEmp(JSON.stringify(getWriteInfo()));
	}
}

/* 模态框取消按钮点击 */
function cancelBtnClick() {
	if(saveType == "detail") {
		$("#model-emp").modal('hide');
		clearWriteInfo();
		return;
	}
	// 弹出取消提示
	BootstrapDialog.confirm({
		title: '取消操作',
		message: '您确定取消' + (saveType == "add" ? "添加" : "修改") + '吗!',
		type: BootstrapDialog.TYPE_DANGER,
		btnCancelLabel: '取消',
		btnOKLabel: '确定',
		btnOKClass: 'btn-danger',
		callback: function(result) {
			if(result) {
				$("#model-emp").modal('hide');
				clearWriteInfo();
			}
		}
	});
}

/* ----------------------------------------------- start --------------------------------------------- */
$(function() {
	/* 初始化table */
	initTable();
	$("#emp-table").bootstrapTable('resetView');
	// 表格高度
	//	$("#emp-table").bootstrapTable('resetView', {
	//		height: tableHeight()
	//	})

	/* 新增按钮点击事件 */
	$("#btn-add").click(addBtnClick);

	/* 删除按钮点击 */
	$("#btn-del").click(delBtnClick);

	/* 修改按钮点击 */
	$("#btn-edit").click(editBtnClick);

	/* 模态框save按钮点击 */
	$("#save").click(saveBtnClick);

	/* 生日变化，日期自动计算 */
	$("#birthday").blur(setAge);

	/* 员工号填写项查重 */
	$("#empno").change(empDistinct);

	/* 取消按钮点击 */
	$("#cancel").click(cancelBtnClick);

	/* 额外信息添加按钮点击 */
	$("#contract-extr").click(addExtrContractClick);
	$("#education-extr").click(addExtrEducationClick);
	$("#jobhistory-extr").click(addExtrJobhistoryClick);

	/* 查询按钮点击 */
	$("#btn-find").click(findBtnClick);
});

/* ----------------------------------------------- end ---------------------------------------------- */

function findBtnClick() {
	$("#search-set").multiselect();
	$("#modal-search").modal();
}
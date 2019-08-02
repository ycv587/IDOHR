var tmpData;

$(function() {
	$.ajax({
		type : 'get',
		url : '/salset/show',
		success : function(data, status) {
			tmpData = data.rows[0];
			// 初始化表单
			$("#setname").val(tmpData.setname);
			$("#cleardate").val(tmpData.cleardate);
			$("#abspropo").val(tmpData.abspropo);
			$("#levpropo").val(tmpData.levpropo);
			$("#sickpropo").val(tmpData.sickpropo);
			$("#nopropo").val(tmpData.nopropo);
			$("#wopropo").val(tmpData.wopropo);
			$("#qopropo").val(tmpData.qopropo);
			$("#merpropo").val(tmpData.merpropo);
			$("#coldage").val(tmpData.coldage);
			$("#eoldage").val(tmpData.eoldage);
			$("#cmedical").val(tmpData.cmedical);
			$("#emedical").val(tmpData.emedical);
			$("#cunemp").val(tmpData.cunemp);
			$("#eunemp").val(tmpData.eunemp);
			$("#cinjury").val(tmpData.cinjury);
			$("#einjury").val(tmpData.einjury);
			$("#cbirth").val(tmpData.cbirth);
			$("#ebirth").val(tmpData.ebirth);
			$("#caccum").val(tmpData.caccum);
			$("#eaccum").val(tmpData.eaccum);
		}
	});

	$("#save").click(function() {
		$.ajax({
			type : 'post',
			url : '/salset/modify',
			contentType : 'application/json;charset=utf-8',
			data : JSON.stringify({
				"ssetno" : tmpData.ssetno,
				"setname" : $("#setname").val(),
				"cleardate" : $("#cleardate").val(),
				"abspropo" : $("#abspropo").val(),
				"levpropo" : $("#levpropo").val(),
				"sickpropo" : $("#sickpropo").val(),
				"nopropo" : $("#nopropo").val(),
				"wopropo" : $("#wopropo").val(),
				"qopropo" : $("#qopropo").val(),
				"merpropo" : $("#merpropo").val(),
				"coldage" : $("#coldage").val(),
				"eoldage" : $("#eoldage").val(),
				"cmedical" : $("#cmedical").val(),
				"emedical" : $("#emedical").val(),
				"cunemp" : $("#cunemp").val(),
				"eunemp" : $("#eunemp").val(),
				"cinjury" : $("#cinjury").val(),
				"einjury" : $("#einjury").val(),
				"cbirth" : $("#cbirth").val(),
				"ebirth" : $("#ebirth").val(),
				"caccum" : $("#caccum").val(),
				"eaccum" : $("#eaccum").val()
			}),
			success : function(data) {
				if (data == "1") {
					toastr.success('保存成功!');
				} else {
					toastr.error('修改失败!');
				}
			}
		});
	})
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
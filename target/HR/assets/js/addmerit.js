$(function() {
	$("#add").click(function() {
		var st = timeToMs($("#starttime-add").val());
		var et = timeToMs($("#endtime-add").val());

		if($("#assname-add").val() == "") {
			toastr.warning("请填写考核名称！");
		} else if($("#starttime-add").val() == "") {
			toastr.warning("请填写考核开始时间！");
		} else if($("#endtime-add").val() == "") {
			toastr.warning("请填写考核结束时间！");
		} else if(st >= et) {
			toastr.error("考核结束时间不能提前于开始时间！");
		} else {
			$.ajax({
				type: 'put',
				url: '/merit/add',
				contentType: 'application/json;charset=utf-8',
				data: JSON.stringify({
					"assname": $("#assname-add").val(),
					"starttime": dtlocalToMs($("#starttime-add").val()),
					"endtime": dtlocalToMs($("#endtime-add").val())
				}),
				success: function(data) {
					if(data == "1") {
						toastr.success('考核发起成功!');
					} else {
						toastr.error('考核发起失败!');
					}
					/* 清空文本框内容 */
					$("#assname-add").val("");
					$("#starttime-add").val("");
					$("#endtime-add").val("");
				}
			});
		}

	})
});

/* datetime-local转毫秒 */
function dtlocalToMs(value) {
	var date = value.replace('T', ' ');
	date += ":00";
	return new Date(date).getTime();
}

/* 时间字符串转毫秒值 */
function timeToMs(datetime) {
	return new Date(datetime).getTime();
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
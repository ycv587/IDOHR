var currFile = "null";

$(function() {
	// 获取全部文件信息
	$.ajax({
			type: 'get',
			url: '/contract/findnameandno',
			success: function(data, status) {
				for(i = 0; i < data.length; i++) {
					$("#con")
						.append(
							"<div id=" +
							data[i].conno +
							" class='col-sm-1 col-sx-1 col-md-1 col-lg-1 file-block'>" +
							"<img alt='IMG' src='/assets/img/Word.ico'>" +
							"<div>" +
							(((data[i].conname).replace(
									/[\u0391-\uFFE5]/g,
									"aa").length > 20) ? (data[i].conname)
								.substr(0, 8) +
								"..." :
								(data[i].conname)) +
							"</div></div>")

				}

				$(".file-block").click(function() {
					$(".file-block").removeClass('vist');
					$(this).addClass('vist');
					currFile = $(this).attr('id');
					$.get('/contract/cge?conno=' + $(this).attr('id'), function(data, status) {});
				});
				$(".file-block").dblclick(function() {
					window.open("/other/word?conno=" + $(this).attr('id'));
				});
			}
		});

	// 上传文件按钮点击
	$("#file-upload").click(function() {
		$("#fie").click();
	});

	$("#fie").change(function() {
		var formData = new FormData();
		formData.append('file', document.getElementById("fie").files[0])
		$.ajax({
			url: '/contract/upload',
			type: 'post',
			processData: false,
			mimeType: "multipart/form-data",
			contentType: false,
			data: formData,
			success: function(data) {
				if(data == "0") {
					toastr.error("文件已存在");
				} else if(data == "-1") {
					toastr.error("上传失败");
				} else {
					toastr.success("上传成功");
					var da = data.split("---");
					$("#con").append(
							"<div id=" +
							da[0] +
							" class='col-sm-1 col-sx-1 col-md-1 col-lg-1 file-block'>" +
							"<img alt='IMG' src='/assets/img/Word.ico'>" +
							"<div>" +
							(((da[1]).replace(
									/[\u0391-\uFFE5]/g,
									"aa").length > 20) ? (da[1].conname)
								.substr(0, 16) +
								"..." :
								(da[1])) +
							"</div></div>")
				}
			}
		});
	});

	$("#file-download").click(function() {
		if(currFile == "null") {
			toastr.warning("请先选择一个文件！");
		} else {
			$("#sm").click();
		}
	})

});

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
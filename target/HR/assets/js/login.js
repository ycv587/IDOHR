$(function() {
	/* 点击登录按钮登录 */
	$("#login-btn").click(function() {
		var usrn = $("#username").val();
		var pwd = hex_sha1($("#password").val());

		if (usrn == "" || pwd == "" || usrn == "员工号/账号" || pwd == "Password") {
			$("#tips").text("账号/密码不能为空");
			$("#tips").fadeIn(0);
			$("#tips").fadeOut(2000);
		} else {
			$.post('/logVerify', {
				username : usrn,
				password : pwd
			}, function(data, status) {
				if (data == "0") {
					$("#tips").text("账号/密码错误");
					$("#tips").fadeIn(0);
					$("#tips").fadeOut(2000);
				} else {
					window.location.href = "/index";
				}
			});
		}

	});

});
var isShow = 0;
$(function() {
	$("#main-frame").css('padding', '0px');
	$("#main-frame").load("/main");

	// 点击头像
	$("#head").click(function() {
		event.stopPropagation();
		if(isShow == 0) {
			$("#head-window").css('display', 'block');
			isShow = 1;
		} else {
			$("#head-window").css('display', 'none');
			isShow = 0;
		}
	});

	$(document).click(function() {
		$("#head-window").css('display', 'none');
		isShow = 0;
	})

	// 退出登录
	$("#logout").click(function() {
		$.ajax({
			url: '/logout',
			success: function(data, status) {
				location.reload();
			}
		});
	});

	$("#mainJsp").click(function() {
		document.title = "主页 - IDOHR";
		$("#main-frame").css('overflow', 'hidden');
		$("#main-frame").css('padding', '0px');
		$("#main-frame").load("/main");
	});

	$("#emp_info").click(function() {
		document.title = "员工管理 - IDOHR";
		$("#main-frame").css('overflow', 'hidden');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/emp/showall");
	});

	$("#joblevel").click(function() {
		document.title = "请假办理 - IDOHR";
		$("#main-frame").css('overflow', 'hidden');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/joblevel/showall");
	});

	$("#jobover").click(function() {
		document.title = "加班记录 - IDOHR";
		$("#main-frame").css('overflow', 'hidden');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/jobover/showall");
	});

	$("#dept_info").click(function() {
		document.title = "部门管理 - IDOHR";
		$("#main-frame").css('overflow', 'hidden');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/dept/showall");
	});

	$("#job_info").click(function() {
		document.title = "职位管理 - IDOHR";
		$("#main-frame").css('overflow', 'hidden');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/job/showall");
	});

	$("#attend_set").click(function() {
		document.title = "考勤配置 - IDOHR";
		$("#main-frame").css('overflow', 'hidden');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/attset/showall");
	});

	$("#currday_attend").click(function() {
		document.title = "今日考勤 - IDOHR";
		$("#main-frame").css('overflow', 'hidden');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/attend/cdshowall");
	});

	$("#sign-box").click(function() {
		$("#currday_attend").click();
	})

	$("#attend_result").click(function() {
		document.title = "考勤日志 - IDOHR";
		$("#main-frame").css('overflow', 'hidden');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/attend/showall");
	});

	$("#addmerit").click(function() {
		document.title = "发起考核 - IDOHR";
		$("#main-frame").css('overflow', 'hidden');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/merit/showadd");
	});

	$("#merit").click(function() {
		document.title = "考核记录 - IDOHR";
		$("#main-frame").css('overflow', 'hidden');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/merit/showall");
	});

	$("#result").click(function() {
		document.title = "考核结果 - IDOHR";
		$("#main-frame").css('overflow', 'hidden');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/result/showall");
	});

	$("#addresult").click(function() {
		document.title = "考核评分 - IDOHR";
		$("#main-frame").css('overflow', 'hidden');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/result/addshowall");
	});

	$("#salset").click(function() {
		document.title = "薪资配置 - IDOHR";
		$("#main-frame").css('overflow', 'auto');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/salset/showall");
	});

	$("#salary").click(function() {
		document.title = "薪资记录 - IDOHR";
		$("#main-frame").css('overflow', 'hidden');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/salary/showall");
	});

	$("#contract").click(function() {
		document.title = "合同管理 - IDOHR";
		$("#main-frame").css('overflow', 'auto');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/contract/showall");
	});

	$("#message").click(function() {
		document.title = "发布公告 - IDOHR";
		$("#main-frame").css('overflow', 'hidden');
		$("#main-frame").css('padding', '10px');
		$("#main-frame").load("/other/msgshow");
	});

	/* 点击菜单项动画 */
	$('.menu-item>a').on('click', function() {
		// 二级菜单没有展开
		if($(this).next().css('display') == "none") {
			$('.menu-item').children('ul').slideUp(300);
			$(this).next('ul').slideDown(300);
			$('.menu-item').find('a').removeClass('nav-show');
			$(this).addClass('nav-show');
		} else {
			// 二级菜单已经展开时收缩
			$(this).next('ul').slideUp(300);
			$(this).removeClass('nav-show');
		}
	});

});
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>发布公告</title>
		<link rel="stylesheet" href="/assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-table.min.css">
	</head>

	<body>

		<script type="text/javascript" src="/assets/js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>

		<script type="text/javascript" charset="utf-8" src="/assets/ueditor/ueditor.config.js"></script>
		<script type="text/javascript" charset="utf-8" src="/assets/ueditor/ueditor.all.js"></script>
		<script type="text/javascript" charset="utf-8" src="/assets/ueditor/lang/zh-cn/zh-cn.js"></script>

		<script id="editor" type="text/plain" style="width: 100%; height: 100px;">
			&nbsp;&nbsp;网站已于2018年3月上线开通。<br /> &nbsp;&nbsp;经过一段时间运行，总体情况良好。网站是面向社会的一个窗口，是我们市场管理者与广大商户朋友们沟通的渠道与平台，更是企业与全体商户朋友互动交流，提供服务的一个载体。
			<br /> &nbsp;&nbsp;我们热忱欢迎广大朋友登陆网站，并对本网站建设献计献策，也期待着您通过网站对我们的工作提出意见和建议。你们的需求就是我们的追求，让我们一起来呵护这个新网站的成长，为广大商户朋友拓展市场作出我们微薄的贡献。
		</script>

		<script type="text/javascript">
			/* 计算表格高度 */
			function tableHeight() {
				return $(window).height() - 176;
			};

			$(function() {
				$("#editor").css('height', tableHeight());
				UE.getEditor('editor');
			})
		</script>

	</body>

</html>
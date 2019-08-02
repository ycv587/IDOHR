<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="/assets/css/main.css">

	</head>

	<body>
		<div id="calendar-box">
			<iframe id="calendar" src="/calendar" scrolling="auto"></iframe>
		</div>

		<div id="weather-box">
			<iframe allowtransparency="true" frameborder="0" width="720" height="98" scrolling="no" src="//tianqi.2345.com/plugin/widget/index.htm?s=2&z=3&t=1&v=0&d=4&bd=0&k=&f=ffffff&ltf=009944&htf=cc0000&q=1&e=1&a=1&c=54511&w=720&h=98&align=center"></iframe>
		</div>

		<div id="bottom-tools">

			<div id="msgs-box">
				<div id="sign-box">
					<i class="glyphicon glyphicon-calendar"> 今日打卡</i>
					<p>2 / 13</p>
				</div>

				<div id="deal-box">
					<i class="glyphicon glyphicon-list-alt"> 待办事项</i>
					<p>24 条</p>
				</div>
			</div>

			<div id="notice-box">
				<b>公 告</b>
				<p>　　网站已于2018年3月上线开通。</p>
				<p>　　经过一段时间运行，总体情况良好。网站是面向社会的一个窗口，是我们市场管理者与广大商户朋友们沟通的渠道与平台，更是企业与全体商户朋友互动交流，提供服务的一个载体。</p>
				<p>　　我们热忱欢迎广大朋友登陆网站，并对本网站建设献计献策，也期待着您通过网站对我们的工作提出意见和建议。你们的需求就是我们的追求，让我们一起来呵护这个新网站的成长，为广大商户朋友拓展市场作出我们微薄的贡献。</p>
			</div>

		</div>

		<script type="text/javascript" src="/assets/js/jquery-3.2.1.min.js"></script>
	</body>

</html>
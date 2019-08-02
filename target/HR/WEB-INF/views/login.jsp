<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>IDOHR - 用户登录</title>
		<!-- Bootstrap -->
		<link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/assets/css/login.css" />
	</head>

	<body>
		<div id="login-logo">
			<a>IDO企业人事管理系统</a>
		</div>
		<h2 class="form-heading">用户登录</h2>
		<div class="app-cam">
			<form>
				<input type="text" id="username" class="text" value="员工号/账号" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '员工号/账号';}">
				<input type="password" id="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
				<div class="submit"><input id="login-btn" type="button" value="登 录"></div>
				<div class="login-social-link">
					<a href="#" class="facebook">
						Facebook
					</a>
					<a href="#" class="twitter">
						Twitter
					</a>
				</div>
			</form>

			<div id="tips">
			</div>

		</div>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script type="text/javascript" src="/assets/js/jquery-3.2.1.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/assets/js/sha1.min.js"></script>
		<script type="text/javascript" src="/assets/js/login.js"></script>
	</body>

</html>
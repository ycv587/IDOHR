<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>首页 - IDOHR</title>
		<link rel="shortcut icon" href="/assets/img/logo_mini.png" />
		<link rel="stylesheet" href="/assets/css/index.css" />
		<link rel="stylesheet" href="/assets/css/bootfont.css" />
	</head>

	<body>
		<!-- 顶部导航 -->
		<div id="navbar">
			<!-- 左侧logo区 -->
			<div id="logo"><img src="/assets/img/logo.png" /></div>
			<div id="head"><img src="/assets/img/head.png" /></div>
			<div id="msg"><img src="/assets/img/msg.png" /></div>
			<input type="text" id="search" value="查找..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '查找...';}">
		</div>

		<!-- 退出登录窗体 -->
		<div id="head-window">
			<div><i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;个人中心</div>
			<div><i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;系统设置</div>
			<div style="margin-top:8px;width:190px;height:1px;border-bottom: 1px solid #e5e5e5;"></div>
			<div id="logout"><i class="glyphicon glyphicon-log-out"></i>&nbsp;&nbsp;退出登录</div>
		</div>

		<!-- 侧边导航 -->
		<div id="sidebar">
			<!-- 菜单列表 -->
			<ul id="menu-list">
				<!-- 首页 -->
				<li class="menu-item">
					<a id="mainJsp" href="javascript:;">
						<i class="glyphicon glyphicon-home"></i>
						<span class="nav-text1">首页</span>
					</a>
				</li>
				<!-- 人事管理 -->
				<li class="menu-item">
					<a href="javascript:;">
						<i class="glyphicon glyphicon-user"></i>
						<span class="nav-text1">人事管理</span>
						<i class="glyphicon glyphicon-menu-right nav-more"></i>
					</a>
					<ul>
						<li id="emp_info">
							<a href="javascript:;"><span class="nav-text2">员工信息</span></a>
						</li>
						<li id="joblevel">
							<a href="javascript:;"><span class="nav-text2">请假办理</span></a>
						</li>
						<li id="jobover">
							<a href="javascript:;"><span class="nav-text2">加班记录</span></a>
						</li>
					</ul>
				</li>

				<!-- 部门职位 -->
				<li class="menu-item">
					<a href="javascript:;">
						<i class="glyphicon glyphicon-globe"></i>
						<span class="nav-text1">部门职位</span>
						<i class="glyphicon glyphicon-menu-right nav-more"></i>
					</a>
					<ul>
						<li id="dept_info">
							<a href="javascript:;"><span class="nav-text2">部门信息</span></a>
						</li>
						<li id="job_info">
							<a href="javascript:;"><span class="nav-text2">职位信息</span></a>
						</li>
					</ul>
				</li>

				<!-- 考勤打卡 -->
				<li class="menu-item">
					<a href="javascript:;">
						<i class="glyphicon glyphicon-calendar"></i>
						<span class="nav-text1">考勤打卡</span>
						<i class="glyphicon glyphicon-menu-right nav-more"></i>
					</a>
					<ul>
						<li id="currday_attend">
							<a href="javascript:;"><span class="nav-text2">今日考勤</span></a>
						</li>
						<li id="attend_set">
							<a href="javascript:;"><span class="nav-text2">考勤配置</span></a>
						</li>
						<li id="attend_result">
							<a href="javascript:;"><span class="nav-text2">考勤日志</span></a>
						</li>
					</ul>
				</li>

				<!-- 薪酬福利 -->
				<li class="menu-item">
					<a href="javascript:;" style="color: white;">
						<i class="glyphicon glyphicon-usd" style="color: white;"></i>
						<span class="nav-text1" style="color: white;">薪酬福利</span>
						<i class="glyphicon glyphicon-menu-right nav-more" style="color: white;"></i>
					</a>
					<ul>
						<li id="salset">
							<a href="javascript:;"><span class="nav-text2">薪酬制度</span></a>
						</li>
						<li id="salary">
							<a href="javascript:;"><span class="nav-text2">薪资记录</span></a>
						</li>
					</ul>
				</li>

				<!-- 绩效考核 -->
				<li class="menu-item">
					<a href="javascript:;">
						<i class="glyphicon glyphicon-signal"></i>
						<span class="nav-text1">绩效考核</span>
						<i class="glyphicon glyphicon-menu-right nav-more"></i>
					</a>
					<ul>
						<li id="addmerit">
							<a href="javascript:;"><span class="nav-text2">发起考核</span></a>
						</li>
						<li id="merit">
							<a href="javascript:;"><span class="nav-text2">考核记录</span></a>
						</li>
						<li id="result">
							<a href="javascript:;"><span class="nav-text2">评分记录</span></a>
						</li>
						<li id="addresult">
							<a href="javascript:;"><span class="nav-text2">考核评分</span></a>
						</li>
					</ul>
				</li>

				<!-- 招聘配置 -->
				<li class="menu-item">
					<a href="javascript:;">
						<i class="glyphicon glyphicon-flag"></i>
						<span class="nav-text1">招聘配置</span>
						<i class="glyphicon glyphicon-menu-right nav-more"></i>
					</a>
				</li>

				<!-- 其他 -->
				<li class="menu-item">
					<a href="javascript:;">
						<i class="glyphicon glyphicon-th"></i>
						<span class="nav-text1">其他</span>
						<i class="glyphicon glyphicon-menu-right nav-more"></i>
					</a>
					<ul>
						<li id="contract">
							<a href="javascript:;"><span class="nav-text2">合同管理</span></a>
						</li>
						<li id="message">
							<a href="javascript:;"><span class="nav-text2">发布公告</span></a>
						</li>
					</ul>
				</li>
			</ul>
		</div>

		<!-- 内容区域 -->
		<div id="main-frame"></div>

		<script type="text/javascript" src="/assets/js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="/assets/js/index.js"></script>
	</body>

</html>
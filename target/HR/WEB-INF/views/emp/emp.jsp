<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>员工信息 - IDOHR</title>
		<link rel="stylesheet" href="/assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-table.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-dialog.min.css">
		<link rel="stylesheet" href="/assets/css/toastr.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-multiselect.css">
	</head>

	<body id="emp_body">
		<%-- 员工信息显示表格 --%>
		<table id="emp-table" class="table table-hover"></table>
		<%-- 工具按钮 --%>
		<div id="toolbar" class="btn-group pull-right">
			<%-- 新增按钮 --%>
			<button id="btn-add" type="button" class="btn btn-primary">
			<i class="glyphicon glyphicon-plus"></i> 新增
		</button>
			<%-- 删除按钮 --%>
			<button id="btn-del" type="button" class="btn btn-danger">
			<i class="glyphicon glyphicon-remove"></i> 删除
		</button>
			<%-- 修改按钮 --%>
			<button id="btn-edit" type="button" class="btn btn-success">
			<i class="glyphicon glyphicon-pencil"></i> 修改
		</button>
			<%-- 查询按钮 --%>
			<button id="btn-find" type="button" class="btn btn-primary">
			<i class="glyphicon glyphicon-search"></i> 查询
		</button>
		</div>
		<%-- 员工操作窗体 --%>
		<div id="model-emp" class="modal fade">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header" id="header-txt">新增员工</div>
					<%-- 窗体内容 --%>
					<div class="modal-body">
						<div class="form">
							<form class="form-horizontal">
								<%-- 基本信息提示 --%>
								<blockquote class="bs-callout-info" style="border-color: #337AB7; background-color: #F5F5F5;">
									<p>
										<strong>基本信息</strong>
									</p>
								</blockquote>
								<div class="form-group">
									<label for="ename" class="control-label col-sm-2">姓名</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" id="ename" maxlength="50">
									</div>
									<label for="gender" class="control-label col-sm-2">性别</label>
									<div class="col-sm-3">
										<select class="form-control" id="gender">
											<option>男</option>
											<option>女</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="birthday" class="control-label col-sm-2">出生日期</label>
									<div class="col-sm-4">
										<input type="date" class="form-control" id="birthday">
									</div>
									<label for="age" class="control-label col-sm-2">年龄</label>
									<div class="col-sm-3">
										<input type="number" class="form-control" id="age" readonly="readonly">
									</div>
								</div>
								<div class="form-group">
									<label for="phone" class="control-label col-sm-2">手机号码</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" id="phone" maxlength="11">
									</div>
									<label for="idcard" class="control-label col-sm-2">身份证号码</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" id="idcard" maxlength="18">
									</div>
								</div>
								<div class="form-group">
									<label for="marriage" class="control-label col-sm-2">婚姻状态</label>
									<div class="col-sm-4">
										<select class="form-control" id="marriage">
											<option>已婚</option>
											<option>未婚</option>
										</select>
									</div>
									<label for="peoples" class="control-label col-sm-2">民族</label>
									<div class="col-sm-3">
										<select class="form-control" id="peoples">
											<option>汉族</option>
											<option>满族</option>
											<option>彝族</option>
											<option>苗族</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="blood" class="control-label col-sm-2">血型</label>
									<div class="col-sm-4">
										<select class="form-control" id="blood">
											<option>A</option>
											<option>B</option>
											<option>AB</option>
											<option>O</option>
											<option>其他</option>
										</select>
									</div>
									<label for="political" class="control-label col-sm-2">政治面貌</label>
									<div class="col-sm-3">
										<select class="form-control" id="political">
											<option>群众</option>
											<option>共产党员</option>
											<option>其他党派</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="close" class="control-label col-sm-2">紧急联系人</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" id="close" maxlength="50">
									</div>
									<label for="cphone" class="control-label col-sm-2">紧急联系方式</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" id="cphone" maxlength="11">
									</div>
								</div>
								<div class="form-group">
									<label for="nativeaddr" class="control-label col-sm-2">籍贯</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="nativeaddr" maxlength="200">
									</div>
								</div>
								<div class="form-group">
									<label for="address" class="control-label col-sm-2">现住址</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="address" maxlength="200">
									</div>
								</div>
								<%-- 职位信息 --%>
								<blockquote class="bs-callout-info" style="border-color: #337AB7; background-color: #F5F5F5;">
									<p>
										<strong>职位信息</strong>
									</p>
								</blockquote>
								<div class="form-group">
									<label for="empno" class="control-label col-sm-2">员工编号</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" id="empno" maxlength="32">
									</div>
									<label for="dept" class="control-label col-sm-2">部门</label>
									<div class="col-sm-3">
										<select class="form-control" id="dept"></select>
									</div>
								</div>
								<div class="form-group">
									<label for="job" class="control-label col-sm-2">职位</label>
									<div class="col-sm-4">
										<select class="form-control" id="job"></select>
									</div>
									<label for="mgr" class="control-label col-sm-2">直属领导</label>
									<div class="col-sm-3">
										<select class="form-control" id="mgr"></select>
									</div>
								</div>
								<div class="form-group">
									<label for="esalary" class="control-label col-sm-2">薪资</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" id="esalary" maxlength="9">
									</div>
									<label for="hiredate" class="control-label col-sm-2">入职日期</label>
									<div class="col-sm-3">
										<input type="date" class="form-control" id="hiredate">
									</div>
								</div>
								<div class="form-group">
									<label for="estatus" class="control-label col-sm-2">员工状态</label>
									<div class="col-sm-4">
										<select class="form-control" id="estatus">
											<option>在职</option>
											<option>离职</option>
										</select>
									</div>
									<label for="password" class="control-label col-sm-2">登录密码</label>
									<div class="col-sm-3">
										<input type="password" placeholder="**********" class="form-control" id="password" maxlength="31">
									</div>
								</div>
								<%-- 合同信息 --%>
								<blockquote class="bs-callout-info" style="border-color: #337AB7; background-color: #F5F5F5;">
									<p>
										<strong>合同信息</strong>
									</p>
								</blockquote>
								<div class="form-group">
									<label for="contract0" class="control-label col-sm-2">劳务合同</label>
									<div class="col-sm-9">
										<select class="form-control" id="contract0"></select>
									</div>
								</div>
								<div class="form-group">
									<label for="startdate0" class="control-label col-sm-2">合同起始日</label>
									<div class="col-sm-4">
										<input type="date" class="form-control" id="startdate0">
									</div>
									<label for="enddate0" class="control-label col-sm-2">合同终止日</label>
									<div class="col-sm-3">
										<input type="date" class="form-control" id="enddate0">
									</div>
								</div>
								<div id="labors"></div>
								<div class="form-group">
									<div class="col-sm-1"></div>
									<div class="btn btn-primary col-sm-10" id="contract-extr">
										<i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;添加合同信息
									</div>
								</div>
								<%-- 教育信息 --%>
								<blockquote class="bs-callout-info" style="border-color: #337AB7; background-color: #F5F5F5;">
									<p>
										<strong>教育信息</strong>
									</p>
								</blockquote>
								<div class="form-group">
									<label for="gschool0" class="control-label col-sm-2">毕业院校</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" id="gschool0" maxlength="50">
									</div>
									<label for="majors0" class="control-label col-sm-2">所在专业</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" id="majors0" maxlength="50">
									</div>
								</div>
								<div class="form-group">
									<label for="gyear0" class="control-label col-sm-2">毕业时间</label>
									<div class="col-sm-4">
										<input type="date" class="form-control" id="gyear0">
									</div>
									<label for="diploma0" class="control-label col-sm-2">学历</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" id="diploma0" maxlength="50">
									</div>
								</div>
								<div id="educations"></div>
								<div class="form-group">
									<div class="col-sm-1"></div>
									<div class="btn btn-primary col-sm-10" id="education-extr">
										<i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;添加教育信息
									</div>
								</div>

								<%-- 工作经历 --%>
								<blockquote class="bs-callout-info" style="border-color: #337AB7; background-color: #F5F5F5;">
									<p>
										<strong>工作经历</strong>
									</p>
								</blockquote>
								<div class="form-group">
									<label for="company0" class="control-label col-sm-2">公司名称</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" id="company0" maxlength="50">
									</div>
									<label for="job0" class="control-label col-sm-2">担任职位</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" id="job0" maxlength="50">
									</div>
								</div>
								<div class="form-group">
									<label for="hhire0" class="control-label col-sm-2">入职日期</label>
									<div class="col-sm-4">
										<input type="date" class="form-control" id="hhire0">
									</div>
									<label for="hquit0" class="control-label col-sm-2">离职日期</label>
									<div class="col-sm-3">
										<input type="date" class="form-control" id="hquit0">
									</div>
								</div>
								<div id="jobhistories"></div>
								<div class="form-group">
									<div class="col-sm-1"></div>
									<div class="btn btn-primary col-sm-10" id="jobhistory-extr">
										<i class="glyphicon glyphicon-plus"></i>&nbsp;&nbsp;添加工作经历
									</div>
								</div>

								<%-- 福利信息 --%>
								<blockquote class="bs-callout-info" style="border-color: #337AB7; background-color: #F5F5F5;">
									<p>
										<strong>福利信息</strong>
									</p>
								</blockquote>
								<div class="form-group">
									<label for="socac" class="control-label col-sm-2">社保账户</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" id="socac" maxlength="20">
									</div>
									<label for="socaddr" class="control-label col-sm-2">开户行</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" id="socaddr" maxlength="100">
									</div>
								</div>
								<div class="form-group">
									<label for="salaryac" class="control-label col-sm-2">工资卡账户</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" id="salaryac" maxlength="20">
									</div>
									<label for="saladdr" class="control-label col-sm-2">开户行</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" id="saladdr" maxlength="100">
									</div>
								</div>
								<div class="form-group">
									<label for="provideac" class="control-label col-sm-2">公积金账户</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" id="provideac" maxlength="20">
									</div>
									<label for="proaddr" class="control-label col-sm-2">开户行</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" id="proaddr" maxlength="100">
									</div>
								</div>

							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" id="cancel">
						取消</button>
						<button type="button" id="save" class="btn btn-primary">保存</button>
					</div>
				</div>
			</div>
		</div>
		<%-- 查询窗体 --%>
		<div id="modal-search" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">查询</div>
					<div class="modal-body">
						<div class="form">
							<form class="form-horizontal">
								<div class="form-group">
									<label for="search-set" class="control-label col-sm-3">查询选项：</label>
									<div class="col-sm-8">
										<select id="search-set" class="form-control" multiple="multiple">
											<option id="find-empno">员工编号</option>
											<option id="find-ename">员工姓名</option>
											<option id="find-nativeaddr">籍贯</option>
											<option id="find-address">现住址</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="search-set" class="control-label col-sm-3">查询内容：</label>
									<div class="col-sm-8">
										<input class="form-control">
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
						取消</button>
						<button type="button" class="btn btn-primary">
						查询</button>
					</div>
				</div>
			</div>
		</div>

		<%-- js文件引入 --%>
		<script type="text/javascript" src="/assets/js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/assets/js/bootstrap-table.min.js"></script>
		<script type="text/javascript" src="/assets/js/bootstrap-table-zh-CN.min.js"></script>
		<script type="text/javascript" src="/assets/js/bootstrap-dialog.min.js"></script>
		<script type="text/javascript" src="/assets/js/toastr.min.js"></script>
		<script type="text/javascript" src="/assets/js/sha1.min.js"></script>
		<script type="text/javascript" src="/assets/js/bootstrap-multiselect.js"></script>
		<script type="text/javascript" src="/assets/js/bootstrap-table-export.js"></script>
		<script type="text/javascript" src="/assets/js/tableExport.js"></script>
		<script type="text/javascript" src="/assets/js/common.js"></script>
		<script type="text/javascript" src="/assets/js/emp.js"></script>
	</body>

</html>
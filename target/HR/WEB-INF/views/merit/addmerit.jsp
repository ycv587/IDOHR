<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>发起绩效考核 - IDOHR</title>
		<link rel="stylesheet" href="/assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-table.min.css">
		<link rel="stylesheet" href="/assets/css/toastr.min.css">
	</head>

	<body id="salset">
		<div style="height: 20%"></div>
		<div class="col-lg-3 col-sm-3 col-md-3"></div>
		<div class="col-lg-6 col-sm-6 col-md-6">
			<div class="form">
				<form class="form-horizontal">
					<div class="form-group" style="text-align: center; font-weight: bold; font-size: 30px;">发起绩效考核</div>
					<div class="form-group"></div>
					<div class="form-group">
						<label for="assname-add" class="control-label col-sm-3">考核名称</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="assname-add">
						</div>
					</div>
					<div class="form-group">
						<label for="starttime-add" class="control-label col-sm-3">开始时间</label>
						<div class="col-sm-8">
							<input type="datetime-local" class="form-control" id="starttime-add">
						</div>
					</div>
					<div class="form-group">
						<label for="endtime-add" class="control-label col-sm-3">结束时间</label>
						<div class="col-sm-8">
							<input type="datetime-local" class="form-control" id="endtime-add">
						</div>
					</div>
					<div class="form-group"></div>
					<div class="form-group">
						<div class="col-lg-3 col-sm-3 col-md-3"></div>
						<div class="col-lg-8 col-sm-8 col-md-8">
							<input type="button" class="btn btn-primary col-lg-8 col-sm-8 col-md-8" id="add" value="发起考核">
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-lg-3 col-sm-3 col-md-3"></div>

		<%-- js文件引入 --%>
		<script type="text/javascript" src="/assets/js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/assets/js/bootstrap-table.min.js"></script>
		<script type="text/javascript" src="/assets/js/bootstrap-table-zh-CN.min.js"></script>
		<script type="text/javascript" src="/assets/js/toastr.min.js"></script>
		<script type="text/javascript" src="/assets/js/common.js"></script>
		<script type="text/javascript" src="/assets/js/addmerit.js"></script>
	</body>

</html>
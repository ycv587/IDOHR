<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>合同管理 - IDOHR</title>
		<link rel="stylesheet" href="/assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-table.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-dialog.min.css">
		<link rel="stylesheet" href="/assets/css/toastr.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-multiselect.css">
		<link rel="stylesheet" href="/assets/css/contract.css">
	</head>

	<body>

		<div style="height: 20px"></div>
		<div class="col-lg-12 col-sm-12 col-md-12">
			<div class="form">
				<div class="form-horizontal">
					<div class="form-group">
						<div class="col-md-2 col-sm-2 col-lg-2 col-xs-2">
							<form enctype="multipart/form-data">
								<input type="file" name="file" id="fie" style="display: none">
								<input type="submit" id="ud" value="上传" style="display: none">
							</form>
							<button id="file-upload" type="button" class="btn btn-primary">
							<i class="glyphicon glyphicon-upload"></i> 添加合同
						</button>
						</div>
						<div class="col-md-2 col-sm-2 col-lg-2 col-xs-2" style="margin-left: -60px;">
							<form action="/contract/down" method="get">
								<input type="submit" value="下载" id="sm" style="display: none">
							</form>
							<button id="file-download" type="button" class="btn btn-primary">
							<i class="glyphicon glyphicon-download"></i> 下载
						</button>
						</div>
					</div>
					<div class="form-group"></div>

					<!-- 内容区 -->
					<div id="con"></div>
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
		<script type="text/javascript" src="/assets/js/common.js"></script>
		<script type="text/javascript" src="/assets/js/contract.js"></script>
	</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>考勤配置 - IDOHR</title>
		<link rel="stylesheet" href="/assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-table.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-dialog.min.css">
		<link rel="stylesheet" href="/assets/css/toastr.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-multiselect.css">
	</head>

	<body>

		<%-- 配置信息显示表格 --%>
		<table id="attset-table" class="table table-hover"></table>

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
		</div>

		<%-- 配置新增窗体：模态弹出框 --%>
		<div id="model-add" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">新建配置</div>
					<%-- 窗体内容 --%>
					<div class="modal-body">
						<div class="form">
							<form class="form-horizontal">
								<div class="form-group">
									<label for="setno-add" class="control-label col-sm-3">配置号/配置名</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="setno-add">
									</div>
								</div>
								<div class="form-group">
									<label for="attstart-add" class="control-label col-sm-3">开始时间</label>
									<div class="col-sm-8">
										<input type="time" class="form-control" id="attstart-add">
									</div>
								</div>
								<div class="form-group">
									<label for="attend-add" class="control-label col-sm-3">结束时间</label>
									<div class="col-sm-8">
										<input type="time" class="form-control" id="attend-add">
									</div>
								</div>
								<div class="form-group">
									<label for="attflag-add" class="control-label col-sm-3">是否启用</label>
									<div class="col-sm-8">
										<select id="attflag-add" class="form-control">
											<option>是</option>
											<option>否</option>
										</select>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
						取消</button>
						<button type="button" id="add" class="btn btn-primary">添加</button>
					</div>
				</div>
			</div>
		</div>

		<%-- 配置修改窗体：模态弹出框 --%>
		<div id="model-modify" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">修改配置</div>
					<%-- 窗体内容 --%>
					<div class="modal-body">
						<div class="form">
							<form class="form-horizontal">
								<div class="form-group">
									<label for="setno-modify" class="control-label col-sm-3">配置号/配置名</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" id="setno-modify">
									</div>
								</div>
								<div class="form-group">
									<label for="attstart-modify" class="control-label col-sm-3">开始时间</label>
									<div class="col-sm-8">
										<input type="time" class="form-control" id="attstart-modify">
									</div>
								</div>
								<div class="form-group">
									<label for="attend-modify" class="control-label col-sm-3">结束时间</label>
									<div class="col-sm-8">
										<input type="time" class="form-control" id="attend-modify">
									</div>
								</div>
								<div class="form-group">
									<label for="attflag-modify" class="control-label col-sm-3">是否启用</label>
									<div class="col-sm-8">
										<select id="attflag-modify" class="form-control">
											<option>是</option>
											<option>否</option>
										</select>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
						取消</button>
						<button type="button" id="modify" class="btn btn-primary">修改</button>
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
		<script type="text/javascript" src="/assets/js/attset.js"></script>

	</body>

</html>
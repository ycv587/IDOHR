<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>考核记录 - IDOHR</title>
		<link rel="stylesheet" href="/assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-table.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-dialog.min.css">
		<link rel="stylesheet" href="/assets/css/toastr.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-multiselect.css">
	</head>

	<body>

		<%-- 配置信息显示表格 --%>
		<table id="merit-table" class="table table-hover"></table>

		<%-- 工具按钮 --%>
		<div id="toolbar" class="btn-group pull-right">
			<%-- 修改按钮 --%>
			<button id="btn-edit" type="button" class="btn btn-success">
			<i class="glyphicon glyphicon-pencil"></i> 修改
		</button>
			<%-- 更换配置按钮 --%>
			<button id="btn-view" type="button" class="btn btn-primary">
			<i class="glyphicon glyphicon-search"></i> 查询
		</button>
		</div>

		<%-- 配置窗体：模态弹出框 --%>
		<div id="model-select" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">考核查询</div>
					<%-- 窗体内容 --%>
					<div class="modal-body">
						<div class="form">
							<form class="form-horizontal">
								<div class="form-group" style="text-align: center;">
									<input type="radio" name="sway" id="sw1" value="sw1"> 查询方式1：日期查询
								</div>
								<div class="form-group">
									<label for="date-start" class="control-label col-sm-3">考核日期</label>
									<div class="col-sm-8">
										<input type="datetime-local" class="form-control" id="date-start">
									</div>
								</div>
								<div class="form-group" style="text-align: center;">
									<input type="radio" name="sway" id="sw2" value="sw2"> 查询方式2：分类查询
								</div>
								<div class="form-group">
									<label for="batch-select" class="control-label col-sm-3">考核分类</label>
									<div class="col-sm-8">
										<select id="batch-select" class="form-control">
											<option id="all">全部</option>
											<option id="off">已结束</option>
											<option id="on">正在进行</option>
											<option id="start">即将开始</option>
										</select>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
						取消</button>
						<button type="button" id="select" class="btn btn-primary">查询</button>
					</div>
				</div>
			</div>
		</div>

		<%-- 考核修改窗体：模态弹出框 --%>
		<div id="model-modify" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">修改考核信息</div>
					<%-- 窗体内容 --%>
					<div class="modal-body">
						<div class="form">
							<form class="form-horizontal">
								<div class="form-group">
									<label for="assname-modify" class="control-label col-sm-2">考核名称</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="assname-modify">
									</div>
								</div>
								<div class="form-group">
									<label for="starttime-modify" class="control-label col-sm-2">开始时间</label>
									<div class="col-sm-10">
										<input type="datetime-local" class="form-control" id="starttime-modify">
									</div>
								</div>
								<div class="form-group">
									<label for="endtime-modify" class="control-label col-sm-2">结束时间</label>
									<div class="col-sm-10">
										<input type="datetime-local" class="form-control" id="endtime-modify">
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
						取消</button>
						<button type="button" id="modify" class="btn btn-primary">保存</button>
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
		<script type="text/javascript" src="/assets/js/merit.js"></script>
	</body>

</html>
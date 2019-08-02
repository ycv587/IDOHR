<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>部门信息 - IDOHR</title>
		<link rel="stylesheet" href="/assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-table.min.css">
		<link rel="stylesheet" href="/assets/css/toastr.min.css">
	</head>

	<body>
		<%-- 部门信息显示表格 --%>
		<table id="dept-table" class="table table-hover"></table>
		<%-- 工具按钮 --%>
		<div id="toolbar" class="btn-group pull-right">
			<%-- 新增按钮 --%>
			<button id="btn-add" type="button" class="btn btn-primary">
			<i class="glyphicon glyphicon-plus"></i> 新增
		</button>
			<%-- 删除按钮 --%>
			<button id="btn-del" type="button" class="btn btn-danger">
			<i class="glyphicon glyphicon-remove"></i> 合并
		</button>
			<%-- 修改按钮 --%>
			<button id="btn-edit" type="button" class="btn btn-success">
			<i class="glyphicon glyphicon-pencil"></i> 修改
		</button>
		</div>
		<%-- 部门新增窗体：模态弹出框 --%>
		<div id="model-add" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">添加部门</div>
					<%-- 窗体内容 --%>
					<div class="modal-body">
						<div class="form">
							<form class="form-horizontal">
								<div class="form-group">
									<label for="deptno-add" class="control-label col-sm-2">部门编号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="deptno-add">
									</div>
								</div>
								<div class="form-group">
									<label for="dname-add" class="control-label col-sm-2">部门名称</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="dname-add">
									</div>
								</div>
								<div class="form-group">
									<label for="location-add" class="control-label col-sm-2">部门地址</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="location-add">
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
		<%-- 部门修改窗体：模态弹出框 --%>
		<div id="model-modify" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">修改部门信息</div>
					<%-- 窗体内容 --%>
					<div class="modal-body">
						<div class="form">
							<form class="form-horizontal">
								<div class="form-group">
									<label for="deptno-modify" class="control-label col-sm-2">部门编号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="deptno-modify" disabled>
									</div>
								</div>
								<div class="form-group">
									<label for="dname-modify" class="control-label col-sm-2">部门名称</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="dname-modify">
									</div>
								</div>
								<div class="form-group">
									<label for="location-modify" class="control-label col-sm-2">部门地址</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="location-modify">
									</div>
								</div>
								<div class="form-group">
									<label for="count-modify" class="control-label col-sm-2">部门人数</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="count-modify" disabled>
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
		<%-- 部门合并模态弹出框 --%>
		<div id="modal-merge" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">部门合并</div>
					<%-- 窗体内容 --%>
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="deptno" class="control-label col-sm-4">请选择合并后的部门</label>
								<div class="col-sm-8">
									<select id="select-merge" class="form-control">
										<option id="op-first"></option>
										<option id="op-second"></option>
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
						取消</button>
						<button type="button" id="merge" class="btn btn-primary">合并</button>
					</div>
				</div>
			</div>
		</div>

		<%-- js文件引入 --%>
		<script type="text/javascript" src="/assets/js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/assets/js/bootstrap-table.min.js"></script>
		<script type="text/javascript" src="/assets/js/bootstrap-table-zh-CN.min.js"></script>
		<script type="text/javascript" src="/assets/js/toastr.min.js"></script>
		<script type="text/javascript" src="/assets/js/bootstrap-table-export.js"></script>
		<script type="text/javascript" src="/assets/js/tableExport.js"></script>
		<script type="text/javascript" src="/assets/js/dept.js"></script>
	</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>薪资配置 - IDOHR</title>
		<link rel="stylesheet" href="/assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-table.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-dialog.min.css">
		<link rel="stylesheet" href="/assets/css/toastr.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-multiselect.css">
		<link rel="stylesheet" href="/assets/css/salset.css">
	</head>

	<body>

		<div style="height: 20px"></div>
		<div class="col-lg-12 col-sm-12 col-md-12">
			<div class="form">
				<form class="form-horizontal">
					<div class="form-group" style="text-align: center; font-weight: bold; font-size: 20px;">薪资结算配置</div>
					<div class="form-group"></div>
					<div class="form-group">
						<label for="setname" class="control-label col-sm-2">配置名</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="setname" value="默认配置" readonly>
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;"></label>
						<label for="cleardate" class="control-label col-sm-2">结算日期</label>
						<div class="col-sm-3">
							<input type="number" class="form-control" id="cleardate">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">日</label>
					</div>

					<div class="form-group">
						<label for="abspropo" class="control-label col-sm-2">缺勤扣款</label>
						<div class="col-sm-3">
							<input type="number" class="form-control" id="abspropo">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">元</label>
						<label for="nopropo" class="control-label col-sm-2">普通加班</label>
						<div class="col-sm-3">
							<input type="number" class="form-control" id="nopropo">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">倍</label>
					</div>

					<div class="form-group">
						<label for="sickpropo" class="control-label col-sm-2">病假扣款</label>
						<div class="col-sm-3">
							<input type="number" class="form-control" id="sickpropo">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">元</label>

						<label for="wopropo" class="control-label col-sm-2">周末加班</label>
						<div class="col-sm-3">
							<input type="number" class="form-control" id="wopropo">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">倍</label>

					</div>

					<div class="form-group">
						<label for="levpropo" class="control-label col-sm-2">事假扣款</label>
						<div class="col-sm-3">
							<input type=number class="form-control" id="levpropo">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">元</label>

						<label for="qopropo" class="control-label col-sm-2">法定加班</label>
						<div class="col-sm-3">
							<input type="number" class="form-control" id="qopropo">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">倍</label>
					</div>

					<div class="form-group">
						<label for="merpropo" class="control-label col-sm-2">绩效基数</label>
						<div class="col-sm-3">
							<input type="number" class="form-control" id="merpropo">
						</div>
						<label class="control-label col-sm-2" style="margin-left: -80px; font-weight: normal;">*(分数/100) /次</label>
					</div>

					<div class="form-group" style="text-align: center; font-weight: bold; font-size: 20px;">五险一金配置</div>
					<div class="form-group"></div>

					<div class="form-group">
						<label for="coldage" class="control-label col-sm-2">公司养老保险</label>
						<div class="col-sm-3">
							<input type="number" class="form-control" id="coldage">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">%</label>
						<label for="eoldage" class="control-label col-sm-2">个人养老保险</label>
						<div class="col-sm-3">
							<input type=number class="form-control" id="eoldage">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">%</label>
					</div>

					<div class="form-group">
						<label for="cmedical" class="control-label col-sm-2">公司医疗保险</label>
						<div class="col-sm-3">
							<input type="number" class="form-control" id="cmedical">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">%</label>
						<label for="emedical" class="control-label col-sm-2">个人医疗保险</label>
						<div class="col-sm-3">
							<input type=number class="form-control" id="emedical">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">%</label>
					</div>

					<div class="form-group">
						<label for="cunemp" class="control-label col-sm-2">公司失业保险</label>
						<div class="col-sm-3">
							<input type="number" class="form-control" id="cunemp">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">%</label>
						<label for="eunemp" class="control-label col-sm-2">个人失业保险</label>
						<div class="col-sm-3">
							<input type=number class="form-control" id="eunemp">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">%</label>
					</div>

					<div class="form-group">
						<label for="cinjury" class="control-label col-sm-2">公司工伤保险</label>
						<div class="col-sm-3">
							<input type="number" class="form-control" id="cinjury">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">%</label>
						<label for="einjury" class="control-label col-sm-2">个人工伤保险</label>
						<div class="col-sm-3">
							<input type=number class="form-control" id="einjury">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">%</label>
					</div>

					<div class="form-group">
						<label for="cbirth" class="control-label col-sm-2">公司生育保险</label>
						<div class="col-sm-3">
							<input type="number" class="form-control" id="cbirth">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">%</label>
						<label for="ebirth" class="control-label col-sm-2">个人生育保险</label>
						<div class="col-sm-3">
							<input type=number class="form-control" id="ebirth">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">%</label>
					</div>

					<div class="form-group">
						<label for="caccum" class="control-label col-sm-2">公司公积金</label>
						<div class="col-sm-3">
							<input type="number" class="form-control" id="caccum">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">%</label>
						<label for="eaccum" class="control-label col-sm-2">个人公积金</label>
						<div class="col-sm-3">
							<input type=number class="form-control" id="eaccum">
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">%</label>
					</div>

					<div class="form-group" style="text-align: center; font-weight: bold; font-size: 20px;">个人所得税配置</div>
					<div class="form-group"></div>

					<div class="form-group">
						<label for="icstart" class="control-label col-sm-3">起征点</label>
						<div class="col-sm-3">
							<input type="number" class="form-control" id="icstart" value="3500" readonly>
						</div>
						<label class="control-label col-sm-1" style="margin-left: -70px; font-weight: normal;">元</label>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">第一级</label>
						<label class="control-label col-sm-1" style="margin-left: -30px; font-weight: normal;">不超过</label>
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" id="lv1" value="1500" readonly>&nbsp;&nbsp;元， 税率：
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" id="lv1" value="3" readonly>&nbsp;&nbsp;%， 速算扣除数：
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" id="lv1" value="0" readonly>&nbsp;&nbsp;元
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">第二级</label> &nbsp;
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="1501" readonly> &nbsp;&nbsp;至&nbsp;&nbsp;
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="4500" readonly>&nbsp;&nbsp;元， 税率：
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="10" readonly>&nbsp;&nbsp;%， 速算扣除数：
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="105" readonly>&nbsp;&nbsp;元
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">第三级</label> &nbsp;
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="4501" readonly> &nbsp;&nbsp;至&nbsp;&nbsp;
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="9000" readonly>&nbsp;&nbsp;元， 税率：
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="20" readonly>&nbsp;&nbsp;%， 速算扣除数：
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="555" readonly>&nbsp;&nbsp;元
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">第四级</label> &nbsp;
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="9001" readonly> &nbsp;&nbsp;至&nbsp;&nbsp;
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="35000" readonly>&nbsp;&nbsp;元， 税率：
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="25" readonly>&nbsp;&nbsp;%， 速算扣除数：
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="1005" readonly>&nbsp;&nbsp;元
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">第五级</label> &nbsp;
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="35001" readonly> &nbsp;&nbsp;至&nbsp;&nbsp;
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="55000" readonly>&nbsp;&nbsp;元， 税率：
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="30" readonly>&nbsp;&nbsp;%， 速算扣除数：
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="2755" readonly>&nbsp;&nbsp;元
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">第六级</label> &nbsp;
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="55001" readonly> &nbsp;&nbsp;至&nbsp;&nbsp;
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="80000" readonly>&nbsp;&nbsp;元， 税率：
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="35" readonly>&nbsp;&nbsp;%， 速算扣除数：
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="5505" readonly>&nbsp;&nbsp;元
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">第七级</label>
						<label class="control-label col-sm-1" style="margin-left: -30px; font-weight: normal;">超过&nbsp;&nbsp;</label>
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="80000" readonly>&nbsp;&nbsp;元， 税率：
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="45" readonly>&nbsp;&nbsp;%， 速算扣除数：
						<input type="text" class="form-control" style="width: 70px; display:inline-block;" value="13505" readonly>&nbsp;&nbsp;元
					</div>
					<div class="form-group"></div>
					<div class="form-group">
						<div class="col-sm-4 col-lg-4 col-md-4"></div>
						<div class="col-sm-4 col-lg-4 col-md-4">
							<input type="button" id="save" value="保存" class="form-control btn btn-primary">
						</div>
						<div class="col-sm-4 col-lg-4 col-md-4"></div>
					</div>
				</form>
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
		<script type="text/javascript" src="/assets/js/salset.js"></script>
	</body>

</html>
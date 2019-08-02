<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*,com.zhuozhengsoft.pageoffice.*"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
	poCtrl1.setServerPage("/poserver.zz"); //此行必须
	String filepath = (String)request.getSession().getAttribute("path");
	poCtrl1.setSaveFilePage("/assets/other/savefile.jsp");//如要保存文件，此行必须
	poCtrl1.addCustomToolButton("保存", "Save()", 1);
	poCtrl1.addCustomToolButton("打印", "PrintFile()", 6);
	poCtrl1.addCustomToolButton("全屏/还原", "IsFullScreen()", 4);
	poCtrl1.addCustomToolButton("关闭", "CloseFile()", 21);
	//打开文件
	poCtrl1.webOpen(filepath, OpenModeType.docNormalEdit, "张三");
%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>合同详情 - IDOHR</title>
		<link rel="stylesheet" href="/assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="/assets/css/bootstrap-table.min.css">
	</head>

	<body>
		<script type="text/javascript">
			function Save() {
				document.getElementById("PageOfficeCtrl1").WebSave();

			}

			function PrintFile() {
				document.getElementById("PageOfficeCtrl1").ShowDialog(4);

			}

			function IsFullScreen() {
				document.getElementById("PageOfficeCtrl1").FullScreen = !document.getElementById("PageOfficeCtrl1").FullScreen;

			}

			function CloseFile() {
				window.external.close();

			}

			//文档关闭前先提示用户是否保存
			function BeforeBrowserClosed() {
				if(document.getElementById("PageOfficeCtrl1").IsDirty) {
					if(confirm("提示：文档已被修改，是否继续关闭放弃保存 ？")) {
						return true;

					} else {

						return false;
					}
				}
			}
		</script>
		<div id="poCtrl" style="height:600px;width:100%;overflow:hidden;">
			<%=poCtrl1.getHtmlCode("PageOfficeCtrl1")%>
		</div>
		<script type="text/javascript" src="/assets/js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
	</body>

</html>
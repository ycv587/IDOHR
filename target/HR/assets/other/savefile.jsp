<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*"
	pageEncoding="utf-8"%>
<%
	FileSaver fs = new FileSaver(request, response);
	fs.saveToFile("D:\\eclipse-workspace\\HR\\src\\main\\webapp\\upload\\" + fs.getFileName());
	fs.close();
%>
/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-04-07 23:52:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.emp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class emp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"utf-8\" />\r\n");
      out.write("\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\t\t<title>员工信息 - IDOHR</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/assets/css/bootstrap.min.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/assets/css/bootstrap-table.min.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/assets/css/bootstrap-dialog.min.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/assets/css/toastr.min.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/assets/css/bootstrap-multiselect.css\">\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body id=\"emp_body\">\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t<table id=\"emp-table\" class=\"table table-hover\"></table>\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t<div id=\"toolbar\" class=\"btn-group pull-right\">\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t<button id=\"btn-add\" type=\"button\" class=\"btn btn-primary\">\r\n");
      out.write("\t\t\t<i class=\"glyphicon glyphicon-plus\"></i> 新增\r\n");
      out.write("\t\t</button>\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t<button id=\"btn-del\" type=\"button\" class=\"btn btn-danger\">\r\n");
      out.write("\t\t\t<i class=\"glyphicon glyphicon-remove\"></i> 删除\r\n");
      out.write("\t\t</button>\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t<button id=\"btn-edit\" type=\"button\" class=\"btn btn-success\">\r\n");
      out.write("\t\t\t<i class=\"glyphicon glyphicon-pencil\"></i> 修改\r\n");
      out.write("\t\t</button>\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t<button id=\"btn-find\" type=\"button\" class=\"btn btn-primary\">\r\n");
      out.write("\t\t\t<i class=\"glyphicon glyphicon-search\"></i> 查询\r\n");
      out.write("\t\t</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t<div id=\"model-emp\" class=\"modal fade\">\r\n");
      out.write("\t\t\t<div class=\"modal-dialog modal-lg\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-header\" id=\"header-txt\">新增员工</div>\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form\">\r\n");
      out.write("\t\t\t\t\t\t\t<form class=\"form-horizontal\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<blockquote class=\"bs-callout-info\" style=\"border-color: #337AB7; background-color: #F5F5F5;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<strong>基本信息</strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t</blockquote>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"ename\" class=\"control-label col-sm-2\">姓名</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"ename\" maxlength=\"50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"gender\" class=\"control-label col-sm-2\">性别</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" id=\"gender\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>男</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>女</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"birthday\" class=\"control-label col-sm-2\">出生日期</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"date\" class=\"form-control\" id=\"birthday\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"age\" class=\"control-label col-sm-2\">年龄</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"number\" class=\"form-control\" id=\"age\" readonly=\"readonly\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"phone\" class=\"control-label col-sm-2\">手机号码</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"phone\" maxlength=\"11\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"idcard\" class=\"control-label col-sm-2\">身份证号码</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"idcard\" maxlength=\"18\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"marriage\" class=\"control-label col-sm-2\">婚姻状态</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" id=\"marriage\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>已婚</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>未婚</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"peoples\" class=\"control-label col-sm-2\">民族</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" id=\"peoples\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>汉族</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>满族</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>彝族</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>苗族</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"blood\" class=\"control-label col-sm-2\">血型</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" id=\"blood\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>A</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>B</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>AB</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>O</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>其他</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"political\" class=\"control-label col-sm-2\">政治面貌</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" id=\"political\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>群众</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>共产党员</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>其他党派</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"close\" class=\"control-label col-sm-2\">紧急联系人</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"close\" maxlength=\"50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"cphone\" class=\"control-label col-sm-2\">紧急联系方式</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"cphone\" maxlength=\"11\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"nativeaddr\" class=\"control-label col-sm-2\">籍贯</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"nativeaddr\" maxlength=\"200\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"address\" class=\"control-label col-sm-2\">现住址</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"address\" maxlength=\"200\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<blockquote class=\"bs-callout-info\" style=\"border-color: #337AB7; background-color: #F5F5F5;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<strong>职位信息</strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t</blockquote>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"empno\" class=\"control-label col-sm-2\">员工编号</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"empno\" maxlength=\"32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"dept\" class=\"control-label col-sm-2\">部门</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" id=\"dept\"></select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"job\" class=\"control-label col-sm-2\">职位</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" id=\"job\"></select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"mgr\" class=\"control-label col-sm-2\">直属领导</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" id=\"mgr\"></select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"esalary\" class=\"control-label col-sm-2\">薪资</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"esalary\" maxlength=\"9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"hiredate\" class=\"control-label col-sm-2\">入职日期</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"date\" class=\"form-control\" id=\"hiredate\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"estatus\" class=\"control-label col-sm-2\">员工状态</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" id=\"estatus\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>在职</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option>离职</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"password\" class=\"control-label col-sm-2\">登录密码</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"password\" placeholder=\"**********\" class=\"form-control\" id=\"password\" maxlength=\"31\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<blockquote class=\"bs-callout-info\" style=\"border-color: #337AB7; background-color: #F5F5F5;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<strong>合同信息</strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t</blockquote>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"contract0\" class=\"control-label col-sm-2\">劳务合同</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" id=\"contract0\"></select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"startdate0\" class=\"control-label col-sm-2\">合同起始日</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"date\" class=\"form-control\" id=\"startdate0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"enddate0\" class=\"control-label col-sm-2\">合同终止日</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"date\" class=\"form-control\" id=\"enddate0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"labors\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-1\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"btn btn-primary col-sm-10\" id=\"contract-extr\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"glyphicon glyphicon-plus\"></i>&nbsp;&nbsp;添加合同信息\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<blockquote class=\"bs-callout-info\" style=\"border-color: #337AB7; background-color: #F5F5F5;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<strong>教育信息</strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t</blockquote>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"gschool0\" class=\"control-label col-sm-2\">毕业院校</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"gschool0\" maxlength=\"50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"majors0\" class=\"control-label col-sm-2\">所在专业</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"majors0\" maxlength=\"50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"gyear0\" class=\"control-label col-sm-2\">毕业时间</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"date\" class=\"form-control\" id=\"gyear0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"diploma0\" class=\"control-label col-sm-2\">学历</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"diploma0\" maxlength=\"50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"educations\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-1\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"btn btn-primary col-sm-10\" id=\"education-extr\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"glyphicon glyphicon-plus\"></i>&nbsp;&nbsp;添加教育信息\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<blockquote class=\"bs-callout-info\" style=\"border-color: #337AB7; background-color: #F5F5F5;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<strong>工作经历</strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t</blockquote>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"company0\" class=\"control-label col-sm-2\">公司名称</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"company0\" maxlength=\"50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"job0\" class=\"control-label col-sm-2\">担任职位</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"job0\" maxlength=\"50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"hhire0\" class=\"control-label col-sm-2\">入职日期</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"date\" class=\"form-control\" id=\"hhire0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"hquit0\" class=\"control-label col-sm-2\">离职日期</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"date\" class=\"form-control\" id=\"hquit0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"jobhistories\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-1\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"btn btn-primary col-sm-10\" id=\"jobhistory-extr\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"glyphicon glyphicon-plus\"></i>&nbsp;&nbsp;添加工作经历\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<blockquote class=\"bs-callout-info\" style=\"border-color: #337AB7; background-color: #F5F5F5;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<strong>福利信息</strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t</blockquote>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"socac\" class=\"control-label col-sm-2\">社保账户</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"socac\" maxlength=\"20\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"socaddr\" class=\"control-label col-sm-2\">开户行</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"socaddr\" maxlength=\"100\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"salaryac\" class=\"control-label col-sm-2\">工资卡账户</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"salaryac\" maxlength=\"20\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"saladdr\" class=\"control-label col-sm-2\">开户行</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"saladdr\" maxlength=\"100\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"provideac\" class=\"control-label col-sm-2\">公积金账户</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"provideac\" maxlength=\"20\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"proaddr\" class=\"control-label col-sm-2\">开户行</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"proaddr\" maxlength=\"100\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-default\" id=\"cancel\">\r\n");
      out.write("\t\t\t\t\t\t取消</button>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" id=\"save\" class=\"btn btn-primary\">保存</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t<div id=\"modal-search\" class=\"modal fade\">\r\n");
      out.write("\t\t\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-header\">查询</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form\">\r\n");
      out.write("\t\t\t\t\t\t\t<form class=\"form-horizontal\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"search-set\" class=\"control-label col-sm-3\">查询选项：</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select id=\"search-set\" class=\"form-control\" multiple=\"multiple\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option id=\"find-empno\">员工编号</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option id=\"find-ename\">员工姓名</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option id=\"find-nativeaddr\">籍贯</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option id=\"find-address\">现住址</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"search-set\" class=\"control-label col-sm-3\">查询内容：</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-sm-8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">\r\n");
      out.write("\t\t\t\t\t\t取消</button>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\">\r\n");
      out.write("\t\t\t\t\t\t查询</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/assets/js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/assets/js/bootstrap-table.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/assets/js/bootstrap-table-zh-CN.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/assets/js/bootstrap-dialog.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/assets/js/toastr.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/assets/js/sha1.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/assets/js/bootstrap-multiselect.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/assets/js/bootstrap-table-export.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/assets/js/tableExport.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/assets/js/common.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/assets/js/emp.js\"></script>\r\n");
      out.write("\t</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-04-08 00:40:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.other;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class message_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t\t<title>发布公告</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/assets/css/bootstrap.min.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/assets/css/bootstrap-table.min.css\">\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body>\r\n");
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/assets/js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"/assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\" charset=\"utf-8\" src=\"/assets/ueditor/ueditor.config.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" charset=\"utf-8\" src=\"/assets/ueditor/ueditor.all.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" charset=\"utf-8\" src=\"/assets/ueditor/lang/zh-cn/zh-cn.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t\t<script id=\"editor\" type=\"text/plain\" style=\"width: 100%; height: 100px;\">\r\n");
      out.write("\t\t\t&nbsp;&nbsp;网站已于2018年3月上线开通。<br /> &nbsp;&nbsp;经过一段时间运行，总体情况良好。网站是面向社会的一个窗口，是我们市场管理者与广大商户朋友们沟通的渠道与平台，更是企业与全体商户朋友互动交流，提供服务的一个载体。\r\n");
      out.write("\t\t\t<br /> &nbsp;&nbsp;我们热忱欢迎广大朋友登陆网站，并对本网站建设献计献策，也期待着您通过网站对我们的工作提出意见和建议。你们的需求就是我们的追求，让我们一起来呵护这个新网站的成长，为广大商户朋友拓展市场作出我们微薄的贡献。\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t/* 计算表格高度 */\r\n");
      out.write("\t\t\tfunction tableHeight() {\r\n");
      out.write("\t\t\t\treturn $(window).height() - 176;\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(function() {\r\n");
      out.write("\t\t\t\t$(\"#editor\").css('height', tableHeight());\r\n");
      out.write("\t\t\t\tUE.getEditor('editor');\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\r\n");
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

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-01-27 10:44:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_002dbooking_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/views/../common/navigation.jspf", Long.valueOf(1516830473000L));
    _jspx_dependants.put("/WEB-INF/views/../common/header.jspf", Long.valueOf(1516930818000L));
    _jspx_dependants.put("/WEB-INF/views/../common/footer.jspf", Long.valueOf(1516930818000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<head>\n");
      out.write("<title>Book-A-Car</title>\n");
      out.write("<link href=\"webjars/bootstrap/3.3.6/css/bootstrap.min.css\"\n");
      out.write("\trel=\"stylesheet\">\n");
      out.write("<link\n");
      out.write("\thref=\"webjars/jquery-ui/1.9.2/css/smoothness/jquery-ui-1.9.2.custom.css\"\n");
      out.write("\trel=\"stylesheet\">\n");
      out.write("\n");
      out.write("<style>\n");
      out.write(".footer {\n");
      out.write("\tposition: absolute;\n");
      out.write("\tbottom: 0;\n");
      out.write("\twidth: 100%;\n");
      out.write("\theight: 60px;\n");
      out.write("\tbackground-color: #f5f5f5;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<script src=\"webjars/jquery/2.1.4/jquery.min.js\"></script>\n");
      out.write("<script src=\"webjars/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"webjars/jquery-ui/1.9.2/js/jquery-ui-1.9.2.custom.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>");
      out.write('\n');
      out.write("<nav class=\"navbar navbar-default\">\n");
      out.write("\n");
      out.write("\t<ul class=\"nav navbar-nav\">\n");
      out.write("\t\t<li><a href=\"/list-bookings.do\">Bookings</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\n");
      out.write("\t<ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("\t\t<li><a href=\"/logout.do\">Logout</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\n");
      out.write("</nav>");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tvar disabledDateRanges = {};\n");
      out.write("\n");
      out.write("\tfunction DisableSpecificDates(date) {\n");
      out.write("\t\tvar currentTime = new Date();\n");
      out.write("\t\tvar string = jQuery.datepicker.formatDate('yy-mm-dd', date);\n");
      out.write("\t\tcurrentTime.setHours(0, 0, 0, 0);\n");
      out.write("\t\tvar show = true;\n");
      out.write("\t\tconsole.log(disabledDateRanges);\n");
      out.write("\t\tfor ( var key in disabledDateRanges) {\n");
      out.write("\t\t\tif (disabledDateRanges.hasOwnProperty(key)) {\n");
      out.write("\t\t\t\tvar value = disabledDateRanges[key];\n");
      out.write("\t\t\t\tvar fromDate = new Date(key);\n");
      out.write("\t\t\t\tvar toDate = new Date(value);\n");
      out.write("\t\t\t\tvar selDate = new Date(string);\n");
      out.write("\t\t\t\tif (selDate.getTime() >= fromDate.getTime()\n");
      out.write("\t\t\t\t\t\t&& selDate.getTime() <= toDate.getTime()) {\n");
      out.write("\t\t\t\t\tshow = false;\n");
      out.write("\t\t\t\t\tbreak;\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t\treturn [ show ];\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\t$(document).ready(function() {\n");
      out.write("\t\t\n");
      out.write("\t\t// TODO Fix date_ranges_excluded not being included\n");
      out.write("\t\t\n");
      out.write("\t\t$(\"#selectedCar\").blur(function(event) {\n");
      out.write("\t\t\t$.ajax({\n");
      out.write("\t\t\t\ttype: 'GET',\n");
      out.write("\t\t\t\tdata: {\n");
      out.write("\t\t\t\t\tselectedCar: $(\"#selectedCar\").val()\n");
      out.write("\t\t\t\t},\n");
      out.write("\t\t\t\theaders: {\n");
      out.write("\t\t\t\t\tAccept: \"application/jsonl charset=utf-8\",\n");
      out.write("\t\t\t\t\t\"Content-Type\": \"application/jsonl charset=utf-8\"\n");
      out.write("\t\t\t\t},\n");
      out.write("\t\t\t\tsuccess: function(exclusionRanges) {\n");
      out.write("\t\t\t\t\tdisabledDateRanges = JSON.parse(JSON.stringify(exclusionRanges));\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\t$(\"#fromDate\").datepicker({\n");
      out.write("\t\t\tbeforeShowDay : DisableSpecificDates,\n");
      out.write("\t\t\tminDate : 0,\n");
      out.write("\t\t\tonSelect : function(selected) {\n");
      out.write("\t\t\t\tvar dateSelected = new Date(selected);\n");
      out.write("\t\t\t\tdateSelected.setHours(0, 0, 0, 0);\n");
      out.write("\t\t\t\t$(\"#toDate\").datepicker(\"option\", \"minDate\", dateSelected);\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\n");
      out.write("\t\t$(\"#toDate\").datepicker({\n");
      out.write("\t\t\tbeforeShowDay : DisableSpecificDates,\n");
      out.write("\t\t\tminDate : 0,\n");
      out.write("\t\t\tonSelect : function(selected) {\n");
      out.write("\t\t\t\tvar dateSelected = new Date(selected);\n");
      out.write("\t\t\t\tdateSelected.setHours(0, 0, 0, 0);\n");
      out.write("\t\t\t\t$(\"#fromDate\").datepicker(\"option\", \"maxDate\", dateSelected);\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("\t<form action=\"/add-booking.do\" method=\"POST\">\n");
      out.write("\t\t<fieldset class=\"form-group\">\n");
      out.write("\t\t\t<label>Car</label> <select size=\"5\" id=\"selectedCar\" name=\"selectedCar\"\n");
      out.write("\t\t\t\tclass=\"step form-control\">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t</fieldset>\n");
      out.write("\t\t<fieldset class=\"form-group\">\n");
      out.write("\t\t\t<label>From</label> <input id=\"fromDate\" type=\"text\" name=\"fromDate\"\n");
      out.write("\t\t\t\tclass=\"step form-control\" />\n");
      out.write("\t\t</fieldset>\n");
      out.write("\t\t<fieldset class=\"form-group\">\n");
      out.write("\t\t\t<label>To</label> <input id=\"toDate\" type=\"text\" name=\"toDate\"\n");
      out.write("\t\t\t\tclass=\"step form-control\" />\n");
      out.write("\t\t</fieldset>\n");
      out.write("\t\t<input type=\"submit\" value=\"Book\" class=\"step btn btn-success\" />\n");
      out.write("\t</form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<footer class=\"footer\">\n");
      out.write("\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/views/add-booking.jsp(77,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/add-booking.jsp(77,4) '${cars}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${cars}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/add-booking.jsp(77,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("car");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${car.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${car.year}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${car.model}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}

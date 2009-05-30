
import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _index1 extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html");
    /* set up the intrinsic variables using the pageContext goober:
    ** session = HttpSession
    ** application = ServletContext
    ** out = JspWriter
    ** page = this
    ** config = ServletConfig
    ** all session/app beans declared in globals.jsa
    */
    PageContext pageContext = JspFactory.getDefaultFactory().getPageContext( this, request, response, null, true, JspWriter.DEFAULT_BUFFER, true);
    // Note: this is not emitted if the session directive == false
    HttpSession session = pageContext.getSession();
    int __jsp_tag_starteval;
    ServletContext application = pageContext.getServletContext();
    JspWriter out = pageContext.getOut();
    _index1 page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      {
        org.apache.struts2.views.jsp.URLTag __jsp_taghandler_1=(org.apache.struts2.views.jsp.URLTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.URLTag.class,"org.apache.struts2.views.jsp.URLTag action id");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("index");
        __jsp_taghandler_1.setId("url");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_1,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[2]);
            {
              org.apache.struts2.views.jsp.ParamTag __jsp_taghandler_2=(org.apache.struts2.views.jsp.ParamTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ParamTag.class,"org.apache.struts2.views.jsp.ParamTag name value");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("parametro.idParametro");
              __jsp_taghandler_2.setValue("idParametro");
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[3]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[4]);
      {
        org.apache.struts2.views.jsp.PropertyTag __jsp_taghandler_3=(org.apache.struts2.views.jsp.PropertyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.PropertyTag.class,"org.apache.struts2.views.jsp.PropertyTag value");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setValue("#url");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[5]);
      {
        org.apache.struts2.views.jsp.URLTag __jsp_taghandler_4=(org.apache.struts2.views.jsp.URLTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.URLTag.class,"org.apache.struts2.views.jsp.URLTag action id");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setAction("proyecto");
        __jsp_taghandler_4.setId("urlProyecto");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_4,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[6]);
            {
              org.apache.struts2.views.jsp.ParamTag __jsp_taghandler_5=(org.apache.struts2.views.jsp.ParamTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ParamTag.class,"org.apache.struts2.views.jsp.ParamTag name value");
              __jsp_taghandler_5.setParent(__jsp_taghandler_4);
              __jsp_taghandler_5.setName("parametro.idParametro");
              __jsp_taghandler_5.setValue("idProyecto");
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[7]);
          } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[8]);
      {
        org.apache.struts2.views.jsp.PropertyTag __jsp_taghandler_6=(org.apache.struts2.views.jsp.PropertyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.PropertyTag.class,"org.apache.struts2.views.jsp.PropertyTag value");
        __jsp_taghandler_6.setParent(null);
        __jsp_taghandler_6.setValue("#urlProyecto");
        __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
        if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,1);
      }
      out.write(__oracle_jsp_text[9]);

    }
    catch (Throwable e) {
      if (!(e instanceof javax.servlet.jsp.SkipPageException)){
        try {
          if (out != null) out.clear();
        }
        catch (Exception clearException) {
        }
        pageContext.handlePageException(e);
      }
    }
    finally {
      OracleJspRuntime.extraHandlePCFinally(pageContext, true);
      JspFactory.getDefaultFactory().releasePageContext(pageContext);
    }

  }
  private static final char __oracle_jsp_text[][]=new char[10][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n\"http://www.w3.org/TR/html4/loose.dtd\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<html>\n  <head>\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\"/>\n    <title>index</title>\n    \n    <script language=\"javascript\">\n        function verParametro(){\n          var frm=document.forms[0];\n          frm.action=\"parametro!list\";\n          frm.submit();\n        }\n    </script>\n    \n  </head>\n  <body>\n  <form action=\"\">\n    <table cellspacing=\"2\" cellpadding=\"3\" border=\"1\" width=\"100%\">\n      <tr>\n          <td class=\"nowrap\">\n          <!--input type=\"button\" value=\"Parametro\" onclick=\"verParametro()\"-->\n                ".toCharArray();
    __oracle_jsp_text[2] = 
    "\n                    ".toCharArray();
    __oracle_jsp_text[3] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[4] = 
    "\n                <a href=\"".toCharArray();
    __oracle_jsp_text[5] = 
    "\">Parametros</a>\n                \n                <br>\n                \n                ".toCharArray();
    __oracle_jsp_text[6] = 
    "\n                    ".toCharArray();
    __oracle_jsp_text[7] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[8] = 
    "\n                <a href=\"".toCharArray();
    __oracle_jsp_text[9] = 
    "\">Proyecto</a>\n                \n            </td>\n            \n        \n      </tr>\n     </table> \n  </form>\n  </body>\n</html>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

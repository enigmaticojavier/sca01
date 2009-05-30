package _pages._tiles;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _menu extends com.orionserver.http.OrionHttpJspPage {


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
    _menu page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      {
        org.apache.struts2.views.jsp.ui.FormTag __jsp_taghandler_1=(org.apache.struts2.views.jsp.ui.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.FormTag.class,"org.apache.struts2.views.jsp.ui.FormTag action method");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("doLogin");
        __jsp_taghandler_1.setMethod("POST");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_1,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[1]);
            {
              org.apache.struts2.views.jsp.ui.ActionErrorTag __jsp_taghandler_2=(org.apache.struts2.views.jsp.ui.ActionErrorTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.ActionErrorTag.class,"org.apache.struts2.views.jsp.ui.ActionErrorTag");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
              if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,2);
            }
            out.write(__oracle_jsp_text[2]);
            {
              org.apache.struts2.views.jsp.ui.FieldErrorTag __jsp_taghandler_3=(org.apache.struts2.views.jsp.ui.FieldErrorTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.FieldErrorTag.class,"org.apache.struts2.views.jsp.ui.FieldErrorTag");
              __jsp_taghandler_3.setParent(__jsp_taghandler_1);
              __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
              if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,2);
            }
            out.write(__oracle_jsp_text[3]);
            {
              org.apache.struts2.views.jsp.ui.TextFieldTag __jsp_taghandler_4=(org.apache.struts2.views.jsp.ui.TextFieldTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.TextFieldTag.class,"org.apache.struts2.views.jsp.ui.TextFieldTag label name value");
              __jsp_taghandler_4.setParent(__jsp_taghandler_1);
              __jsp_taghandler_4.setLabel("Usuario");
              __jsp_taghandler_4.setName("usuario");
              __jsp_taghandler_4.setValue("");
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[4]);
            {
              org.apache.struts2.views.jsp.ui.PasswordTag __jsp_taghandler_5=(org.apache.struts2.views.jsp.ui.PasswordTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.PasswordTag.class,"org.apache.struts2.views.jsp.ui.PasswordTag label name value");
              __jsp_taghandler_5.setParent(__jsp_taghandler_1);
              __jsp_taghandler_5.setLabel("Clave");
              __jsp_taghandler_5.setName("codClave");
              __jsp_taghandler_5.setValue("");
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[5]);
            {
              org.apache.struts2.views.jsp.ui.SubmitTag __jsp_taghandler_6=(org.apache.struts2.views.jsp.ui.SubmitTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.SubmitTag.class,"org.apache.struts2.views.jsp.ui.SubmitTag align value");
              __jsp_taghandler_6.setParent(__jsp_taghandler_1);
              __jsp_taghandler_6.setAlign("center");
              __jsp_taghandler_6.setValue("Ingresar");
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[6]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[7]);

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
  private static final char __oracle_jsp_text[][]=new char[8][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n\t<tr>\n\t<td>\t\t\t  \n\t        <script language=\"javascript\">\n\t\tfunction MM_openBrWindow2(theURL,winName,features) {\n\t  \t\twindow.open(theURL,winName,features);\n\t\t}\n\t        </script>\n\t   <div id=\"basic-accordian\" >\n              <!--Parent of the Accordion-->\n              <!--Start of each accordion item-->\n              <div id=\"test-header\" class=\"accordion_headings header_highlight\" ><a href=\"#0\">SCA</a></div>\n\t      <!--Heading of the accordion ( clicked to show n hide ) -->\n              <!--Prefix of heading (the DIV above this) and content (the DIV below this) to be same... eg. foo-header & foo-content-->\n               <div id=\"test-content\">\n                <!--DIV which show/hide on click of header-->\n                <!--This DIV is for inline styling like padding...-->\n                <div class=\"accordion_child\">\n                  <table width=\"100%\">\n                    <tr>\n            \t\t<!--Aqui irian mas opciones del submenu SCA-->\n                    </tr>\n                  </table>\n                </div>\n               </div>\n\t      <!--End of each accordion item-->\n              <!--Start of each accordion item-->\n              <!--Heading of the accordion ( clicked to show n hide ) -->\n              <!--Prefix of heading (the DIV above this) and content (the DIV below this) to be same... eg. foo-header & foo-content-->\n              \n              <div id=\"test1-header\" class=\"accordion_headings\"> <a href=\"#0\">Certificaciones Ambientales</a></div>\n\t       <div id=\"test1-content\">\n                <!--DIV which show/hide on click of header-->\n                <!--This DIV is for inline styling like padding...-->\n                <div class=\"accordion_child\">\n                  <table width=\"100%\">                    \n                    <tr>\n                      <td width=\"4%\">&nbsp;</td>\n                      <td width=\"96%\"><a href=\"index.php?idTipoElementoInformacion=14\">Qué son Certificaciones Ambientales</a></td>\n                    </tr>\n                    <tr>\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                    \n                    <tr>\n                      <td width=\"4%\">&nbsp;</td>\n                      <td width=\"96%\"><a href=\"index.php?idTipoElementoInformacion=10\">Normas Legales</a></td>\n                    </tr>\n                    <tr>\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                    \n                    <tr>\n                      <td width=\"4%\">&nbsp;</td>\n                      <td width=\"96%\"><a href=\"index.php?idTipoElementoInformacion=5\">Consultas</a></td>\n                    </tr>\n                    <tr>\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                    \n                    <tr>\n                      <td width=\"4%\">&nbsp;</td>\n                      <td width=\"96%\"><a href=\"index.php?idTipoElementoInformacion=12\">Estadísticas</a></td>\n                    </tr>\n                    <tr>\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                  </table>\n                </div>\n\t      </div>\t\t\t  \n             \n              <div id=\"test2-header\" class=\"accordion_headings\" ><a href=\"#0\">Contáctenos</a></div>\n\t        <!--Heading of the accordion ( clicked to show n hide ) -->\n                <!--Prefix of heading (the DIV above this) and content (the DIV below this) to be same... eg. foo-header & foo-content-->\n                <div id=\"test2-content\">\n                <!--DIV which show/hide on click of header-->\n                <!--This DIV is for inline styling like padding...-->\n                  <div class=\"accordion_child\">\n                  <table width=\"100%\">\n                    <tr>\n                      <td bgcolor=\"#F8FBFF\"><a href=\"contacto.php\" target=\"_parent\">Comentarios y Sugerencias </a></td>\n                    </tr>\n                    <tr>\n                      <td><img src=\"public/img/web/fondo_menu.jpg\" alt=\"1\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                  </table>\n                </div>\n              </div>\n\t      <!--End of each accordion item-->\n           </div>\n\t   <!--End of accordion parent-->\n           <table width=\"100%\" border=\"0\" height=\"2\">\n             <tr>\n                <td height=\"1\" bgcolor=\"#92D050\"></td>\n             </tr>\n           </table>\n           <br />\n            ".toCharArray();
    __oracle_jsp_text[1] = 
    "            \n              <tr>\n                <td height=\"34\" valign=\"middle\" class=\"login1\"><div align=\"center\"><br />\n                <span class=\"style2\">ACCESO A USUARIOS</span></div></td>\n              </tr>\n              <tr>\n                <td width=\"235\" height=\"132\" class=\"login2\">\n                <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                  <tr>\n                    <td width=\"4%\">&nbsp;</td>\n                    <td width=\"92%\">\n                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                      ".toCharArray();
    __oracle_jsp_text[2] = 
    "\n                        ".toCharArray();
    __oracle_jsp_text[3] = 
    "                      \n                      ".toCharArray();
    __oracle_jsp_text[4] = 
    "\n\t\t\t\t\t  ".toCharArray();
    __oracle_jsp_text[5] = 
    "\n                      <tr>\n                        <td colspan=\"2\">&nbsp;</td>\n                      </tr>\n                      ".toCharArray();
    __oracle_jsp_text[6] = 
    "\n                    </table>\n                    </td>\n                    <td width=\"4%\">&nbsp;</td>\n                  </tr>\n\n                </table></td>\n              </tr>\n            ".toCharArray();
    __oracle_jsp_text[7] = 
    "\n           <p>&nbsp;</p>\n           <p>&nbsp;</p>\n           <p>&nbsp;</p>\n           <p>&nbsp;</p>\n           <p><br />\n           </p>\n       </td>\n       </tr>\n</table>           ".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

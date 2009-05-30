package _pages._tiles;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _cabecera extends com.orionserver.http.OrionHttpJspPage {


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
    _cabecera page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);

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
  private static final char __oracle_jsp_text[][]=new char[1][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> \n\t  <tr align=\"left\" valign=\"top\">\n        \t<td colspan=\"6\">\n        \t<object classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" codebase=\"http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0\" width=\"1000\" height=\"138\" id=\"logo(0)\" align=\"middle\">\n\t          <param name=\"allowScriptAccess\" value=\"sameDomain\" />\n\t          <param name=\"movie\" value=\"public/swf/web/banner_sinia.swf\" />\n\t          <param name=\"quality\" value=\"high\" />\n\t          <param name=\"bgcolor\" value=\"#ffffff\" />\n\t          <embed src=\"public/swf/web/banner_sinia.swf\" quality=\"high\" bgcolor=\"#ffffff\" width=\"1000\" height=\"138\" name=\"logo(0)\" align=\"middle\" allowscriptaccess=\"sameDomain\" type=\"application/x-shockwave-flash\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" />\n\t\t</object>\n\t        </td>\n\t  </tr>\n\t <tr align=\"center\" valign=\"middle\">\n        \t<td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\" ><a href=\"index.php\" target=\"_parent\">Inicio</a></td>\n\t        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index1.php\" target=\"_parent\">Qu&eacute; es SINIA</a></td>\n\t        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index2.php\" target=\"_parent\">Antecedentes</a></td>\n\t        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index4.php\" target=\"_parent\">Objetivos</a></td>\n\t        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index3.php\" target=\"_parent\">Marco Legal</a></td>\n\t        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"contacto.php\" target=\"_parent\">Cont�ctenos</a></td>\n\t </tr>   \n</table>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

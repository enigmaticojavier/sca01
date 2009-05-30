package _pages._layout;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _mainLayout extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html;charset=ISO-8859-1");
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
    _mainLayout page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    com.evermind.server.http.JspCommonExtraWriter __ojsp_s_out = (com.evermind.server.http.JspCommonExtraWriter) out;
    try {


      __ojsp_s_out.write(__oracle_jsp_text[0]);
      out.write("");
      __ojsp_s_out.write(__oracle_jsp_text[1]);
      __ojsp_s_out.write(__oracle_jsp_text[2]);
      out.write("");
      __ojsp_s_out.write(__oracle_jsp_text[3]);
      __ojsp_s_out.write(__oracle_jsp_text[4]);
      __ojsp_s_out.write(__oracle_jsp_text[5]);
      out.write("");
      __ojsp_s_out.write(__oracle_jsp_text[6]);
      __ojsp_s_out.write(__oracle_jsp_text[7]);
      out.write("");
      __ojsp_s_out.write(__oracle_jsp_text[8]);
      __ojsp_s_out.write(__oracle_jsp_text[9]);

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
  private static final byte __oracle_jsp_text[][]=new byte[10][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\r\n<html>\r\n  <head>    \r\n    <title>MINAM - SCA</title>\r\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n\t<meta name=\"Description\" content=\"-- MINAM PERU Ministerio del Medio Ambiente (MINAM).\">\r\n\t<META NAME=\"Keywords\" CONTENT=\"PERU,  MINAM ,  Perú, economy, MINISTERIO, AMBIENTE, Statistical , Ministerio del Ambiente, estadisticas, Indicadores, Indicadores Ambientales\">\r\n\t<link href=\"../../public/css/web/template_css.css\" rel=\"stylesheet\" type=\"text/css\">\r\n\t<link href=\"../../public/css/web/acordionv2.css\" rel=\"stylesheet\" type=\"text/css\">\r\n\r\n\t<script>\r\n\tfunction MM_openBrWindow(theURL,winName,features) { //v2.0\r\n\t  window.open(theURL,winName,features);\r\n\t}\r\n\t</script>\r\n    \t\r\n    \t<script type=\"text/javascript\" src=\"../../public/js/ajax/ajax.js\"></script>\r\n  </head>\r\n  <body onload=\"new Accordian('basic-accordian',5,'header_highlight');\">\r\n    <table summary=\"Main Table for Techshelp\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"1000\">\r\n      <tr>\r\n        <td colspan=\"2\">\r\n         ".getBytes("ISO8859_1");
    __oracle_jsp_text[1] = 
    "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> \r\n\t  <tr align=\"left\" valign=\"top\">\r\n        \t<td colspan=\"6\">\r\n        \t<object classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" codebase=\"http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0\" width=\"1000\" height=\"138\" id=\"logo(0)\" align=\"middle\">\r\n\t          <param name=\"allowScriptAccess\" value=\"sameDomain\" />\r\n\t          <param name=\"movie\" value=\"../../public/swf/web/banner_sinia.swf\" />\r\n\t          <param name=\"quality\" value=\"high\" />\r\n\t          <param name=\"bgcolor\" value=\"#ffffff\" />\r\n\t          <embed src=\"../../public/swf/web/banner_sinia.swf\" quality=\"high\" bgcolor=\"#ffffff\" width=\"1000\" height=\"138\" name=\"logo(0)\" align=\"middle\" allowscriptaccess=\"sameDomain\" type=\"application/x-shockwave-flash\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" />\r\n\t\t</object>\r\n\t        </td>\r\n\t  </tr>\r\n\t <tr align=\"center\" valign=\"middle\">\r\n        \t<td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"../../public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\" ><a href=\"index.php\" target=\"_parent\">Inicio</a></td>\r\n\t        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"../../public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index1.php\" target=\"_parent\">Qu&eacute; es SINIA</a></td>\r\n\t        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"../../public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index2.php\" target=\"_parent\">Antecedentes</a></td>\r\n\t        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"../../public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index4.php\" target=\"_parent\">Objetivos</a></td>\r\n\t        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"../../public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index3.php\" target=\"_parent\">Marco Legal</a></td>\r\n\t        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"../../public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"contacto.php\" target=\"_parent\">ContÃ¡ctenos</a></td>\r\n\t </tr>   \r\n</table>".getBytes("ISO8859_1");
    __oracle_jsp_text[2] = 
    "\r\n        </td>\r\n      </tr>\r\n      <tr>\r\n        <td width=\"240\" align=\"left\" valign=\"top\">\r\n          ".getBytes("ISO8859_1");
    __oracle_jsp_text[3] = 
    "\r\n".getBytes("ISO8859_1");
    __oracle_jsp_text[4] = 
    "\r\n<link href=\"../../public/css/web/template_css.css\" rel=\"stylesheet\" type=\"text/css\">\r\n<link href=\"../../public/css/web/acordionv2.css\" rel=\"stylesheet\" type=\"text/css\">\r\n<script type=\"text/javascript\" src=\"../../public/js/web/includes/acordeon/accordian.pack.js\"></script>\r\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n\t<tr>\r\n\t<td>\t\t\t  \r\n         <script language=\"javascript\">\r\n\r\n        function MM_openBrWindow2(theURL,winName,features) {\r\n          window.open(theURL,winName,features);\r\n        }\r\n        //-->\r\n            </script>\r\n\t    <div id=\"basic-accordian\" >\r\n              <!--Parent of the Accordion-->\r\n              <!--Start of each accordion item-->\r\n              <div id=\"test-header\" class=\"accordion_headings header_highlight\" ><a href=\"#0\">SCA</a></div>\r\n\t      <!--Heading of the accordion ( clicked to show n hide ) -->\r\n              <!--Prefix of heading (the DIV above this) and content (the DIV below this) to be same... eg. foo-header & foo-content-->\r\n              <div id=\"test-content\">\r\n                <!--DIV which show/hide on click of header-->\r\n                <!--This DIV is for inline styling like padding...-->\r\n                <div class=\"accordion_child\">\r\n                  <table width=\"100%\">\r\n                    <tr>\r\n                    \r\n                    </tr>\r\n                  </table>\r\n                </div>\r\n              </div>\r\n\t\t\t  <!--End of each accordion item-->\r\n              <!--Start of each accordion item-->\r\n              <!--Heading of the accordion ( clicked to show n hide ) -->\r\n              <!--Prefix of heading (the DIV above this) and content (the DIV below this) to be same... eg. foo-header & foo-content-->\r\n\r\n              \r\n              <div id=\"test1-header\" class=\"accordion_headings\"> <a href=\"#1\">Certificaciones Ambientales</a></div>\r\n\t\t <div id=\"test1-content\">\r\n                <!--DIV which show/hide on click of header-->\r\n                <!--This DIV is for inline styling like padding...-->\r\n                <div class=\"accordion_child\">\r\n                  <table width=\"100%\">\r\n                    \r\n                    <tr>\r\n                      <td width=\"4%\">&nbsp;</td>\r\n                      <td width=\"96%\"><a href=\"index.php?idTipoElementoInformacion=14\">Qué son Certificaciones Ambientales</a></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\r\n                    </tr>\r\n                    \r\n                    <tr>\r\n                      <td width=\"4%\">&nbsp;</td>\r\n                      <td width=\"96%\"><a href=\"index.php?idTipoElementoInformacion=10\">Normas Legales</a></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\r\n                    </tr>\r\n                    \r\n                    <tr>\r\n                      <td width=\"4%\">&nbsp;</td>\r\n                      <td width=\"96%\"><a href=\"index.php?idTipoElementoInformacion=5\">Consultas</a></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\r\n                    </tr>\r\n                    \r\n                    <tr>\r\n                      <td width=\"4%\">&nbsp;</td>\r\n                      <td width=\"96%\"><a href=\"index.php?idTipoElementoInformacion=12\">Estadisticas</a></td>\r\n                    </tr>\r\n                    <tr>\r\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\r\n                    </tr>\r\n                  </table>\r\n                </div>\r\n            </div>\r\n\t\t <!--End of each accordion item-->\r\n            </div>\r\n\t  \t <!--End of accordion parent-->\r\n            <table width=\"100%\" border=\"0\" height=\"2\">\r\n              <tr>\r\n                <td height=\"1\" bgcolor=\"#92D050\"></td>\r\n              </tr>\r\n            </table>\r\n            <br />\r\n            <table width=\"235\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n              <tr>\r\n                <td height=\"34\" valign=\"middle\" class=\"login1\"><div align=\"center\"><br />\r\n                <span class=\"style2\">ACCESO A USUARIOS</span></div></td>\r\n              </tr>\r\n              <tr>\r\n                <td width=\"235\" height=\"132\" class=\"login2\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                  <tr>\r\n                    <td width=\"4%\">&nbsp;</td>\r\n                    <td width=\"92%\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                      <tr>\r\n                        <td colspan=\"2\">&nbsp;</td>\r\n                      </tr>\r\n                      <tr>\r\n                        <td width=\"27%\">Usuario: </td>\r\n                        <td width=\"73%\"><input type=\"text\" size=\"25\" value=\"\" name=\"patron2\" id=\"patron2\" /></td>\r\n                      </tr>\r\n                      <tr>\r\n                        <td colspan=\"2\">&nbsp;</td>\r\n                      </tr>\r\n                      <tr>\r\n                        <td>Clave:</td>\r\n                        <td><input type=\"text\" size=\"25\" value=\"\" name=\"patron3\" id=\"patron3\" /></td>\r\n                      </tr>\r\n                      <tr>\r\n                        <td colspan=\"2\">&nbsp;</td>\r\n                      </tr>\r\n                    </table></td>\r\n                    <td width=\"4%\">&nbsp;</td>\r\n                  </tr>\r\n                  <tr>\r\n                    <td>&nbsp;</td>\r\n                    <td><div align=\"center\">\r\n                      <input type=\"button\" name=\"Submit2\" value=\"Inicio de sesiÃ³n\" onclick=\"buscar()\" />\r\n                    </div></td>\r\n                    <td>&nbsp;</td>\r\n                  </tr>\r\n                </table></td>\r\n              </tr>\r\n            </table>\r\n            <p>&nbsp;</p>\r\n            <p>&nbsp;</p>\r\n            <p>&nbsp;</p>\r\n            <p>&nbsp;</p>\r\n            <p><br>\r\n            </p>\r\n       </td>\r\n       </tr>\r\n</table>           ".getBytes("ISO8859_1");
    __oracle_jsp_text[5] = 
    "\r\n        </td>\r\n        <td width=\"800\" valign=\"top\">\r\n          ".getBytes("ISO8859_1");
    __oracle_jsp_text[6] = 
    "<table width=\"90%\" class=\"titulo\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" height=\"36\">\r\n<tr>\r\n    <td align=\"center\" bgcolor=\"#F2FEE6\" class=\"titulo\">Bienvenidos al Sistema de Registro de Certificaciones Ambientales - SCA </td>\r\n</tr>\r\n</table>\r\n<br />\r\n<table width=\"100%\" border=\"0\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\">\r\n<tr>\r\n    <td>\r\n    </td>\r\n</tr>\r\n</table>\r\n\t\t  ".getBytes("ISO8859_1");
    __oracle_jsp_text[7] = 
    "\r\n        </td>\r\n      </tr>\r\n      <tr>\r\n        <td colspan=\"2\" align=\"left\" background=\"../../public/img/web/cool-blue_r9_c8.jpg\" valign=\"top\">        \r\n          ".getBytes("ISO8859_1");
    __oracle_jsp_text[8] = 
    "<table summary=\"Footer Table for Terms links and Top of page link\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n      <tr>\r\n        <td width=\"239\" align=\"center\" valign=\"middle\" bgcolor=\"#7DBB3B\">&nbsp;</td>\r\n        <td width=\"577\" align=\"center\" valign=\"middle\" bgcolor=\"#7DBB3B\"><a href=\"http://www.minam.gob.pe\" class=\"pie\">MINISTERIO DEL AMBIENTE</a><br />\r\n          <span class=\"style1\">Email: <a href=\"mailto:sinia@minam.gob.pe\" class=\"pie\">sinia@minam.gob.pe</a>,<br />\r\n          Teléfono:(511) 2255370 / Fax:(511) 2255369<br />\r\n          Av. Guardia Civil Nº 205 - San Borja<br />\r\n          Lima Perú</span>\r\n        </td>\r\n        <td width=\"184\" align=\"center\" valign=\"middle\" bgcolor=\"#7DBB3B\">&nbsp;</td>\r\n      </tr>\r\n</table>".getBytes("ISO8859_1");
    __oracle_jsp_text[9] = 
    "\r\n        </td>\r\n      </tr>\r\n    </table>\r\n  </body>\r\n</html>".getBytes("ISO8859_1");
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

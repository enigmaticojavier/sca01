package _pages._acae;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _acaeForm extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html; charset=ISO-8859-1");
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
    _acaeForm page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.print( request.getContextPath() );
      out.write(__oracle_jsp_text[2]);
      {
        org.apache.struts2.views.jsp.URLTag __jsp_taghandler_1=(org.apache.struts2.views.jsp.URLTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.URLTag.class,"org.apache.struts2.views.jsp.URLTag action id");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("index");
        __jsp_taghandler_1.setId("urlParametro");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_1,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[3]);
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
            out.write(__oracle_jsp_text[4]);
          } while (__jsp_taghandler_1.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[5]);
      {
        org.apache.struts2.views.jsp.PropertyTag __jsp_taghandler_3=(org.apache.struts2.views.jsp.PropertyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.PropertyTag.class,"org.apache.struts2.views.jsp.PropertyTag value");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setValue("#urlParametro");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[6]);
      out.print( request.getContextPath() );
      out.write(__oracle_jsp_text[7]);
      {
        org.apache.struts2.views.jsp.PropertyTag __jsp_taghandler_4=(org.apache.struts2.views.jsp.PropertyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.PropertyTag.class,"org.apache.struts2.views.jsp.PropertyTag value");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setValue("txtValor");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[8]);
      {
        org.apache.struts2.views.jsp.ui.FormTag __jsp_taghandler_5=(org.apache.struts2.views.jsp.ui.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.FormTag.class,"org.apache.struts2.views.jsp.ui.FormTag");
        __jsp_taghandler_5.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_5,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[9]);
            {
              org.apache.struts2.views.jsp.ui.TextFieldTag __jsp_taghandler_6=(org.apache.struts2.views.jsp.ui.TextFieldTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.TextFieldTag.class,"org.apache.struts2.views.jsp.ui.TextFieldTag label name value");
              __jsp_taghandler_6.setParent(__jsp_taghandler_5);
              __jsp_taghandler_6.setLabel("Denominación");
              __jsp_taghandler_6.setName("txtRazonSocial");
              __jsp_taghandler_6.setValue("");
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[10]);
            {
              org.apache.struts2.views.jsp.ui.SelectTag __jsp_taghandler_7=(org.apache.struts2.views.jsp.ui.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.SelectTag.class,"org.apache.struts2.views.jsp.ui.SelectTag label list listKey listValue name onchange value");
              __jsp_taghandler_7.setParent(__jsp_taghandler_5);
              __jsp_taghandler_7.setLabel("Tipo Acae");
              __jsp_taghandler_7.setList("parTipoAcae");
              __jsp_taghandler_7.setListKey("codParametro");
              __jsp_taghandler_7.setListValue("txtValor");
              __jsp_taghandler_7.setName("tipoAcae");
              __jsp_taghandler_7.setOnchange("javascript:cambiarTipoAcae()");
              __jsp_taghandler_7.setValue("tipoAcae");
              __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
              if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,2);
            }
            out.write(__oracle_jsp_text[11]);
            {
              org.apache.struts2.views.jsp.ui.SelectTag __jsp_taghandler_8=(org.apache.struts2.views.jsp.ui.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.SelectTag.class,"org.apache.struts2.views.jsp.ui.SelectTag label list listKey listValue name onchange value");
              __jsp_taghandler_8.setParent(__jsp_taghandler_5);
              __jsp_taghandler_8.setLabel("Institucion");
              __jsp_taghandler_8.setList("parInstitucion");
              __jsp_taghandler_8.setListKey("codParametro");
              __jsp_taghandler_8.setListValue("txtValor");
              __jsp_taghandler_8.setName("clsSector");
              __jsp_taghandler_8.setOnchange("javascript:cambiarInstitucion()");
              __jsp_taghandler_8.setValue("clsSector");
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[12]);
            {
              org.apache.struts2.views.jsp.ui.SelectTag __jsp_taghandler_9=(org.apache.struts2.views.jsp.ui.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.SelectTag.class,"org.apache.struts2.views.jsp.ui.SelectTag label list listKey listValue name value");
              __jsp_taghandler_9.setParent(__jsp_taghandler_5);
              __jsp_taghandler_9.setLabel("Dependencia");
              __jsp_taghandler_9.setList("parDependencia");
              __jsp_taghandler_9.setListKey("clsSubSector");
              __jsp_taghandler_9.setListValue("txtSubSector");
              __jsp_taghandler_9.setName("clsSubSector");
              __jsp_taghandler_9.setValue("clsSubSector");
              __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
              if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
            }
            out.write(__oracle_jsp_text[13]);
          } while (__jsp_taghandler_5.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[14]);

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
  private static final char __oracle_jsp_text[][]=new char[15][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n\t<title>SINIA - Sistema Nacional de Información Ambiental</title>\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n\t<meta name=\"Description\" content=\"-- MINAM PERU Ministerio del Medio Ambiente (MINAM).\">\n\t<META NAME=\"Keywords\" CONTENT=\"PERU,  MINAM ,  PerÃº, economy, MINISTERIO, AMBIENTE, Statistical , Ministerio del Ambiente, estadisticas, Indicadores, Indicadores Ambientales\">\n\n\t<link href=\"public/css/web/template_css.css\" rel=\"stylesheet\" type=\"text/css\">\n\t<link href=\"public/css/web/acordionv2.css\" rel=\"stylesheet\" type=\"text/css\">\n        <script language=\"javascript\">\n        function cambiarTipoAcae(){\n          var frm=document.forms[0];\n          frm.action=\"acaeForm!buscarInstitucionXTipoAcae\";\n          frm.submit();  \n        }\n        function cambiarInstitucion(){\n          var frm=document.forms[0];\n          frm.action=\"acaeForm!buscarDependenciaXInstitucion\";\n          frm.submit();\n        }\n        </script>\n        \n\t<script>\n\tfunction MM_openBrWindow(theURL,winName,features) { //v2.0\n\t  window.open(theURL,winName,features);\n\t}\n\t</script>\n    <script type=\"text/javascript\" src=\"public/js/web/includes/acordeon/accordian.pack.js\"></script>\n    <style type=\"text/css\">\n<!--\n.encabezado2 {\n\tcolor: #000000;\n\tfont-size: 10px;\n\tbackground-repeat: no-repeat;\n\tfont-weight:bold;\n}\nbody {\n\tmargin-left: 0px;\n\tmargin-top: 0px;\n\tmargin-right: 0px;\n\tmargin-bottom: 0px;\n}\n\n}\n.style1 {\nfont-family:\"Trebuchet MS\";\nfont-size:10px;\ncolor: #FFFFFF;\n}\n.style2 {color: #FFFFFF}\n\n-->\n    </style>\n</head>\n<body onload=\"new Accordian('basic-accordian',5,'header_highlight');\">\n\n<table summary=\"Main Table for Techshelp\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"1000\">\n  <tr>\n\n    <td align=\"left\" background=\"public/img/web/cool-blue_r1_c14.jpg\" valign=\"top\">\n\n\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> \n\t  <tr align=\"left\" valign=\"top\">\n        <td colspan=\"6\"><object classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" codebase=\"http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0\" width=\"1000\" height=\"138\" id=\"logo(0)\" align=\"middle\">\n          <param name=\"allowScriptAccess\" value=\"sameDomain\" />\n          <param name=\"movie\" value=\"public/swf/web/banner_sinia.swf\" />\n          <param name=\"quality\" value=\"high\" />\n          <param name=\"bgcolor\" value=\"#ffffff\" />\n          <embed src=\"public/swf/web/banner_sinia.swf\" quality=\"high\" bgcolor=\"#ffffff\" width=\"1000\" height=\"138\" name=\"logo(0)\" align=\"middle\" allowscriptaccess=\"sameDomain\" type=\"application/x-shockwave-flash\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" />        \n</object></td>\n\t  </tr>\n\t \t<tr align=\"center\" valign=\"middle\">\n        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\" ><a href=\"index.php\" target=\"_parent\">Inicio</a></td>\n        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index1.php\" target=\"_parent\">Qu&eacute; es SINIA</a></td>\n        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index2.php\" target=\"_parent\">Antecedentes</a></td>\n        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index4.php\" target=\"_parent\">Objetivos</a></td>\n        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index3.php\" target=\"_parent\">Marco Legal</a></td>\n        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"contacto.php\" target=\"_parent\">ContÃ¡ctenos</a></td>\n\t \t</tr>   \n</table>\n\t</td>\n  </tr>\n<!--  <tr>\n    <td align=\"left\" background=\"public/img/web/cool-blue_r3_c2.jpg\" valign=\"top\">\n\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"790\">\n      <tbody>\n\t  <tr align=\"left\" valign=\"top\">\n        <td class=\"date\" background=\"public/img/web/cool-blue_r3_c1.jpg\" valign=\"middle\" width=\"181\"></td>\n        <td height=\"32\" valign=\"middle\"><span class=\"pathway\">Home</span></td>\n      </tr>\n      </tbody>\n\t</table>\n\t</td>\n  </tr>-->\n  <tr>\n\n    <td align=\"left\" valign=\"top\">\n\t<table summary=\"Main Table for Content, Navigation and Information\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n      \n\t  <tr align=\"left\" valign=\"top\">\n        <td width=\"240\" background=\"public/img/web/cool-blue_r5_c1.jpg\">\n\t\t\t  \n              <script language=\"javascript\">\n\nfunction MM_openBrWindow2(theURL,winName,features) {\n  window.open(theURL,winName,features);\n}\n//-->\n            </script>\n\t\t\t<div id=\"basic-accordian\" >\n              <!--Parent of the Accordion-->\n              <!--Start of each accordion item-->\n              \n\t\t\t  <!--Heading of the accordion ( clicked to show n hide ) -->\n              <!--Prefix of heading (the DIV above this) and content (the DIV below this) to be same... eg. foo-header & foo-content-->                            \n              <div id=\"test1-header\" class=\"accordion_headings\"> <a href=\"#0\">SCA</a></div>\n\t\t\t  <div id=\"test1-content\">\n                <!--DIV which show/hide on click of header-->\n                <!--This DIV is for inline styling like padding...-->\n                <div class=\"accordion_child\">\n                  <table width=\"100%\">\n                    \n                    <tr>\n                      <td width=\"4%\">&nbsp;</td>\n                      <td width=\"96%\"><a href=\"".toCharArray();
    __oracle_jsp_text[2] = 
    "/acaeForm!list\">Inscripción del ACAE</a></td>\n                    </tr>\n                    <tr>\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                    \n                    <tr>\n                      <td width=\"4%\">&nbsp;</td>\n                      <td width=\"96%\"><a href=\"index.php?idTipoElementoInformacion=10\">Consulta / Modificación de Datos</a></td>\n                    </tr>\n                    <tr>\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\n                    </tr>                    \n                    <tr>\n                      <td width=\"4%\">&nbsp;</td>\n                      ".toCharArray();
    __oracle_jsp_text[3] = 
    "\n                        ".toCharArray();
    __oracle_jsp_text[4] = 
    "\n                      ".toCharArray();
    __oracle_jsp_text[5] = 
    "\n                      <td width=\"96%\"><a href=\"".toCharArray();
    __oracle_jsp_text[6] = 
    "\">Configuración de Parámetros</a></td>\n                    </tr>\n                    <tr>\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                    <tr>\n                      <td width=\"4%\">&nbsp;</td>\n                      <td width=\"96%\"><a href=\"".toCharArray();
    __oracle_jsp_text[7] = 
    "/doLogout.action\">Cerrar Sesión</a></td>\n                    </tr>\n                    <tr>\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                  </table>\n                </div>\n\t\t      </div>\n\t\t\t  \n             \n              <div id=\"test2-header\" class=\"accordion_headings\" ><a href=\"#0\">Contáctenos</a></div>\n\t\t\t  <!--Heading of the accordion ( clicked to show n hide ) -->\n              <!--Prefix of heading (the DIV above this) and content (the DIV below this) to be same... eg. foo-header & foo-content-->\n              <div id=\"test2-content\">\n                <!--DIV which show/hide on click of header-->\n                <!--This DIV is for inline styling like padding...-->\n                <div class=\"accordion_child\">\n                  <table width=\"100%\">\n                    <tr>\n                      <td bgcolor=\"#F8FBFF\"><a href=\"contacto.php\" target=\"_parent\">Comentarios y Sugerencias </a></td>\n                    </tr>\n                    <tr>\n                      <td><img src=\"public/img/web/fondo_menu.jpg\" alt=\"1\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                  </table>\n                </div>\n              </div>\n\t\t\t  <!--End of each accordion item-->\n            </div>\n\t\t\t<!--End of accordion parent-->\n            <table width=\"100%\" border=\"0\" height=\"2\">\n              <tr>\n                <td height=\"1\" bgcolor=\"#92D050\"></td>\n              </tr>\n            </table>\n            <br />\n            \n            <p>&nbsp;</p>\n            <p>&nbsp;</p>\n            <p>&nbsp;</p>\n            <p>&nbsp;</p>\n            <p><br>\n            </p></td>\n        <td width=\"579\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n\n          <tr>\n            <th width=\"100%\" align=\"center\" valign=\"top\" scope=\"col\">\n\t\t\t<br>\n            <table width=\"650\" class=\"titulo\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" height=\"36\">\n                <tr>\n                    <td align=\"center\" bgcolor=\"#F2FEE6\" class=\"titulo\">\n                    Bienvenidos al Sistema de Información de Certificaciones Ambientales - SCA</td>\n                </tr>\n            </table>\n            ".toCharArray();
    __oracle_jsp_text[8] = 
    "\n\t\n            <div id=\"div_buscar\">\n            ".toCharArray();
    __oracle_jsp_text[9] = 
    "  \n              <tr>\n                <td colspan=\"2\">1. Datos de la Institución</td>\n              </tr>\n              ".toCharArray();
    __oracle_jsp_text[10] = 
    "              \n              ".toCharArray();
    __oracle_jsp_text[11] = 
    "\n              ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n              ".toCharArray();
    __oracle_jsp_text[13] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[14] = 
    "\n            </div>\n\t</th>\n     </tr>\n    </table>\n    </td>\n    </tr>\n    </table>\n  </td>\n  </tr>\n  <tr>\n    <td align=\"left\" background=\"public/img/web/cool-blue_r9_c8.jpg\" valign=\"top\"><table summary=\"Footer Table for Terms links and Top of page link\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n      <tr>\n        <td width=\"239\" align=\"center\" valign=\"middle\" bgcolor=\"#7DBB3B\">&nbsp;</td>\n        <td width=\"577\" align=\"center\" valign=\"middle\" bgcolor=\"#7DBB3B\"><a href=\"http://www.minam.gob.pe\" class=\"pie\">MINISTERIO DEL AMBIENTE</a><br />\n          <span class=\"style1\">Email: <a href=\"mailto:sinia@minam.gob.pe\" class=\"pie\">sinia@minam.gob.pe</a>,<br />\n    Teléfono:(511)   2255370 / Fax:(511) 2255369 <br />\n    Av. Guardia Civil Nº 205 - San Borja<br />\n    Lima Perú</span></td>\n        <td width=\"184\" align=\"center\" valign=\"middle\" bgcolor=\"#7DBB3B\">&nbsp;</td>\n      </tr>\n    </table>\n    </td>\n  </tr>\n\n</table>\n</body>\n\n</html>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

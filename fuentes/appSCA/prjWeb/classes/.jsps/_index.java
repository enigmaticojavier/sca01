
import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _index extends com.orionserver.http.OrionHttpJspPage {


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
    _index page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      {
        org.apache.struts2.views.jsp.URLTag __jsp_taghandler_1=(org.apache.struts2.views.jsp.URLTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.URLTag.class,"org.apache.struts2.views.jsp.URLTag action id");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setAction("proyecto");
        __jsp_taghandler_1.setId("urlProyecto");
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
              __jsp_taghandler_2.setValue("idProyecto");
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
        __jsp_taghandler_3.setValue("#urlProyecto");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[5]);
      {
        org.apache.struts2.views.jsp.ui.FormTag __jsp_taghandler_4=(org.apache.struts2.views.jsp.ui.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.FormTag.class,"org.apache.struts2.views.jsp.ui.FormTag action method");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setAction("doLogin");
        __jsp_taghandler_4.setMethod("POST");
        __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_4,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[6]);
            {
              org.apache.struts2.views.jsp.ui.ActionErrorTag __jsp_taghandler_5=(org.apache.struts2.views.jsp.ui.ActionErrorTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.ActionErrorTag.class,"org.apache.struts2.views.jsp.ui.ActionErrorTag");
              __jsp_taghandler_5.setParent(__jsp_taghandler_4);
              __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
              if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,2);
            }
            out.write(__oracle_jsp_text[7]);
            {
              org.apache.struts2.views.jsp.ui.FieldErrorTag __jsp_taghandler_6=(org.apache.struts2.views.jsp.ui.FieldErrorTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.FieldErrorTag.class,"org.apache.struts2.views.jsp.ui.FieldErrorTag");
              __jsp_taghandler_6.setParent(__jsp_taghandler_4);
              __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
              if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,2);
            }
            out.write(__oracle_jsp_text[8]);
            {
              org.apache.struts2.views.jsp.ui.TextFieldTag __jsp_taghandler_7=(org.apache.struts2.views.jsp.ui.TextFieldTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.TextFieldTag.class,"org.apache.struts2.views.jsp.ui.TextFieldTag label name value");
              __jsp_taghandler_7.setParent(__jsp_taghandler_4);
              __jsp_taghandler_7.setLabel("Usuario");
              __jsp_taghandler_7.setName("usuario");
              __jsp_taghandler_7.setValue("");
              __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
              if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,2);
            }
            out.write(__oracle_jsp_text[9]);
            {
              org.apache.struts2.views.jsp.ui.PasswordTag __jsp_taghandler_8=(org.apache.struts2.views.jsp.ui.PasswordTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.PasswordTag.class,"org.apache.struts2.views.jsp.ui.PasswordTag label name value");
              __jsp_taghandler_8.setParent(__jsp_taghandler_4);
              __jsp_taghandler_8.setLabel("Clave");
              __jsp_taghandler_8.setName("codClave");
              __jsp_taghandler_8.setValue("");
              __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
              if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,2);
            }
            out.write(__oracle_jsp_text[10]);
            {
              org.apache.struts2.views.jsp.ui.SubmitTag __jsp_taghandler_9=(org.apache.struts2.views.jsp.ui.SubmitTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.SubmitTag.class,"org.apache.struts2.views.jsp.ui.SubmitTag align value");
              __jsp_taghandler_9.setParent(__jsp_taghandler_4);
              __jsp_taghandler_9.setAlign("center");
              __jsp_taghandler_9.setValue("Ingresar");
              __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
              if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
            }
            out.write(__oracle_jsp_text[11]);
          } while (__jsp_taghandler_4.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[12]);

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
  private static final char __oracle_jsp_text[][]=new char[13][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n\t<title>SINIA - Sistema Nacional de Información Ambiental</title>\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n\t<meta name=\"Description\" content=\"-- MINAM PERU Ministerio del Medio Ambiente (MINAM).\">\n\t<META NAME=\"Keywords\" CONTENT=\"PERU,  MINAM ,  PerÃº, economy, MINISTERIO, AMBIENTE, Statistical , Ministerio del Ambiente, estadisticas, Indicadores, Indicadores Ambientales\">\n\n\t<link href=\"public/css/web/template_css.css\" rel=\"stylesheet\" type=\"text/css\">\n\t<link href=\"public/css/web/acordionv2.css\" rel=\"stylesheet\" type=\"text/css\">\n\n\t<script>\n\tfunction MM_openBrWindow(theURL,winName,features) { //v2.0\n\t  window.open(theURL,winName,features);\n\t}\n\t</script>\n    <script type=\"text/javascript\" src=\"public/js/web/includes/acordeon/accordian.pack.js\"></script>\n    <style type=\"text/css\">\n<!--\n.encabezado2 {\n\tcolor: #000000;\n\tfont-size: 10px;\n\tbackground-repeat: no-repeat;\n\tfont-weight:bold;\n}\nbody {\n\tmargin-left: 0px;\n\tmargin-top: 0px;\n\tmargin-right: 0px;\n\tmargin-bottom: 0px;\n}\n\n}\n.style1 {\nfont-family:\"Trebuchet MS\";\nfont-size:10px;\ncolor: #FFFFFF;\n}\n.style2 {color: #FFFFFF}\n\n-->\n    </style>\n</head>\n<body onload=\"new Accordian('basic-accordian',5,'header_highlight');\">\n\n<table summary=\"Main Table for Techshelp\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"1000\">\n  <tr>\n\n    <td align=\"left\" background=\"public/img/web/cool-blue_r1_c14.jpg\" valign=\"top\">\n\n\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> \n\t  <tr align=\"left\" valign=\"top\">\n        <td colspan=\"6\"><object classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" codebase=\"http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0\" width=\"1000\" height=\"138\" id=\"logo(0)\" align=\"middle\">\n          <param name=\"allowScriptAccess\" value=\"sameDomain\" />\n          <param name=\"movie\" value=\"public/swf/web/banner_sinia.swf\" />\n          <param name=\"quality\" value=\"high\" />\n          <param name=\"bgcolor\" value=\"#ffffff\" />\n          <embed src=\"public/swf/web/banner_sinia.swf\" quality=\"high\" bgcolor=\"#ffffff\" width=\"1000\" height=\"138\" name=\"logo(0)\" align=\"middle\" allowscriptaccess=\"sameDomain\" type=\"application/x-shockwave-flash\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" />        \n</object></td>\n\t  </tr>\n\t \t<tr align=\"center\" valign=\"middle\">\n        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\" ><a href=\"index.php\" target=\"_parent\">Inicio</a></td>\n        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index1.php\" target=\"_parent\">Qu&eacute; es SINIA</a></td>\n        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index2.php\" target=\"_parent\">Antecedentes</a></td>\n        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index4.php\" target=\"_parent\">Objetivos</a></td>\n        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"index3.php\" target=\"_parent\">Marco Legal</a></td>\n        <td align=\"center\" valign=\"middle\" height=\"24\" width=\"170\" background=\"public/img/web/boton-superior-inactivo.gif\" class=\"encabezado2\"><a href=\"contacto.php\" target=\"_parent\">ContÃ¡ctenos</a></td>\n\t \t</tr>   \n</table>\n\t</td>\n  </tr>\n<!--  <tr>\n    <td align=\"left\" background=\"public/img/web/cool-blue_r3_c2.jpg\" valign=\"top\">\n\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"790\">\n      <tbody>\n\t  <tr align=\"left\" valign=\"top\">\n        <td class=\"date\" background=\"public/img/web/cool-blue_r3_c1.jpg\" valign=\"middle\" width=\"181\"></td>\n        <td height=\"32\" valign=\"middle\"><span class=\"pathway\">Home</span></td>\n      </tr>\n      </tbody>\n\t</table>\n\t</td>\n  </tr>-->\n  <tr>\n\n    <td align=\"left\" valign=\"top\">\n\t<table summary=\"Main Table for Content, Navigation and Information\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n      \n\t  <tr align=\"left\" valign=\"top\">\n        <td width=\"240\" background=\"public/img/web/cool-blue_r5_c1.jpg\">\n\t\t\t  \n              <script language=\"javascript\">\n\nfunction MM_openBrWindow2(theURL,winName,features) {\n  window.open(theURL,winName,features);\n}\n//-->\n            </script>\n\t\t\t<div id=\"basic-accordian\" >\n              <!--Parent of the Accordion-->\n              <!--Start of each accordion item-->\n              <div id=\"test-header\" class=\"accordion_headings header_highlight\" ><a href=\"#0\">SCA</a></div>\n\t\t\t  <!--Heading of the accordion ( clicked to show n hide ) -->\n              <!--Prefix of heading (the DIV above this) and content (the DIV below this) to be same... eg. foo-header & foo-content-->\n              <div id=\"test-content\">\n                <!--DIV which show/hide on click of header-->\n                <!--This DIV is for inline styling like padding...-->\n                <div class=\"accordion_child\">\n                  <table width=\"100%\">\n                    <tr>\n                     <!-- <td width=\"4%\">&nbsp;</td>\n                      <td width=\"96%\"><a href=\"index1.php\" target=\"_parent\">Qu&eacute; es SINIA</a></td>\n                    </tr>\n                    <tr>\n                      <td colspan=\"2\" background=\"public/img/web/fondo_m.gif\"><img src=\"public/img/web/fondo_menu.jpg\" alt=\"9\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                    <tr>\n                      <td>&nbsp;</td>\n                      <td><a href=\"index2.php\" target=\"_parent\">Antecedentes</a></td>\n                    </tr>\n                    <tr>\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" alt=\"8\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                    <tr>\n                      <td>&nbsp;</td>\n                      <td><a href=\"index3.php\" target=\"_parent\">Marco Legal</a></td>\n                    </tr>\n                    <tr>\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" alt=\"7\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                    <tr>\n                      <td></td>\n                      <td><a href=\"index4.php\" target=\"_parent\">Objetivos</a></td>-->\n                    </tr>\n                  </table>\n                </div>\n              </div>\n\t\t\t  <!--End of each accordion item-->\n              <!--Start of each accordion item-->\n              <!--Heading of the accordion ( clicked to show n hide ) -->\n              <!--Prefix of heading (the DIV above this) and content (the DIV below this) to be same... eg. foo-header & foo-content-->\n\n              \n              <div id=\"test1-header\" class=\"accordion_headings\"> <a href=\"#0\">Certificaciones Ambientales</a></div>\n\t\t\t  <div id=\"test1-content\">\n                <!--DIV which show/hide on click of header-->\n                <!--This DIV is for inline styling like padding...-->\n                <div class=\"accordion_child\">\n                  <table width=\"100%\">\n                    \n                    <tr>\n                      <td width=\"4%\">&nbsp;</td>\n                      <td width=\"96%\"><a href=\"index.php?idTipoElementoInformacion=14\">Qué son Certificaciones Ambientales</a></td>\n                    </tr>\n                    <tr>\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                    \n                    <tr>\n                      <td width=\"4%\">&nbsp;</td>\n                      <td width=\"96%\"><a href=\"index.php?idTipoElementoInformacion=10\">Normas Legales</a></td>\n                    </tr>\n                    <tr>\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                    \n                    <tr>\n                      <td width=\"4%\">&nbsp;</td>\n                        ".toCharArray();
    __oracle_jsp_text[2] = 
    "\n                            ".toCharArray();
    __oracle_jsp_text[3] = 
    "\n                        ".toCharArray();
    __oracle_jsp_text[4] = 
    "\n                      <td width=\"96%\"><a href=\"".toCharArray();
    __oracle_jsp_text[5] = 
    "\">ConsultasYY</a></td>\n                    </tr>\n                    <tr>\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                    \n                    <tr>\n                      <td width=\"4%\">&nbsp;</td>\n                      <td width=\"96%\"><a href=\"index.php?idTipoElementoInformacion=12\">Estadisticas</a></td>\n                    </tr>\n                    <tr>\n                      <td colspan=\"2\"><img src=\"public/img/web/fondo_menu.jpg\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                  </table>\n                </div>\n\t\t      </div>\n\t\t\t  \n             \n              <div id=\"test2-header\" class=\"accordion_headings\" ><a href=\"#0\">Contáctenos</a></div>\n\t\t\t  <!--Heading of the accordion ( clicked to show n hide ) -->\n              <!--Prefix of heading (the DIV above this) and content (the DIV below this) to be same... eg. foo-header & foo-content-->\n              <div id=\"test2-content\">\n                <!--DIV which show/hide on click of header-->\n                <!--This DIV is for inline styling like padding...-->\n                <div class=\"accordion_child\">\n                  <table width=\"100%\">\n                    <tr>\n                      <td bgcolor=\"#F8FBFF\"><a href=\"contacto.php\" target=\"_parent\">Comentarios y Sugerencias </a></td>\n                    </tr>\n                    <tr>\n                      <td><img src=\"public/img/web/fondo_menu.jpg\" alt=\"1\" width=\"220\" height=\"1\" /></td>\n                    </tr>\n                  </table>\n                </div>\n              </div>\n\t\t\t  <!--End of each accordion item-->\n            </div>\n\t\t\t<!--End of accordion parent-->\n            <table width=\"100%\" border=\"0\" height=\"2\">\n              <tr>\n                <td height=\"1\" bgcolor=\"#92D050\"></td>\n              </tr>\n            </table>\n            <br />\n            ".toCharArray();
    __oracle_jsp_text[6] = 
    "\n            \n              <tr>\n                <td height=\"34\" valign=\"middle\" class=\"login1\"><div align=\"center\"><br />\n                <span class=\"style2\">ACCESO A USUARIOS</span></div></td>\n              </tr>\n              <tr>\n                <td width=\"235\" height=\"132\" class=\"login2\">\n                <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                  <tr>\n                    <td width=\"4%\">&nbsp;</td>\n                    <td width=\"92%\">\n                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                      ".toCharArray();
    __oracle_jsp_text[7] = 
    "\n                        ".toCharArray();
    __oracle_jsp_text[8] = 
    "                      \n                      ".toCharArray();
    __oracle_jsp_text[9] = 
    "\n\t\t\t\t\t  ".toCharArray();
    __oracle_jsp_text[10] = 
    "\n                      <tr>\n                        <td colspan=\"2\">&nbsp;</td>\n                      </tr>\n                      ".toCharArray();
    __oracle_jsp_text[11] = 
    "\n                    </table>\n                    </td>\n                    <td width=\"4%\">&nbsp;</td>\n                  </tr>\n\n                </table></td>\n              </tr>\n            ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n            <p>&nbsp;</p>\n            <p>&nbsp;</p>\n            <p>&nbsp;</p>\n            <p>&nbsp;</p>\n            <p><br>\n            </p></td>\n        <td width=\"579\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n\n          <tr>\n            <th width=\"100%\" align=\"center\" valign=\"top\" scope=\"col\">\n\t\t\t<br>\n            <table width=\"650\" class=\"titulo\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\" height=\"36\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"center\" bgcolor=\"#F2FEE6\" class=\"titulo\">\n\t\t\t\t\t\tBienvenidos al Sistema de Información de Certificaciones Ambientales - SCA</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\n\t\t\t\n\t\t\t<script type=\"text/javascript\" src=\"public/js/ajax/ajax.js\"></script>\n<script language=\"javascript\">\n\nfunction buscarPagina(pagina) {\nvar i\n    for (i=0;i<document.formbusq.itembuscar.length;i++){\n       if (document.formbusq.itembuscar[i].checked)\n          break;\n    }\n\n//valor=\"http://localhost/sinia3/\";\n\nvar indice = document.formbusq.webservice.selectedIndex\nvar valor = document.formbusq.webservice.options[indice].value \n//alert (valor+'buscar2.php?itembuscar='+document.formbusq.itembuscar[i].value+'&patron='+document.formbusq.patron.value)\n// Para SINIA\n//window.location.href=\"?P=Boletines&b=boletines&mes=\"+ validacion.meses.value \ngetHTTP('carga2.php','&itembuscar='+document.formbusq.itembuscar[i].value+'&patron='+document.formbusq.patron.value+'&web='+valor+'buscar2.php'+'&weblink='+valor+'&pagina='+pagina,'div_buscar')\n// Para los Siars\n//getHTTP('buscar2.php','&itembuscar='+document.formbusq.itembuscar[i].value+'&patron='+document.formbusq.patron.value+'&web='+valor+'buscar2.php','div_buscar')\n}\n\nfunction buscar() {\nvar i\n    for (i=0;i<document.formbusq.itembuscar.length;i++){\n       if (document.formbusq.itembuscar[i].checked)\n          break;\n    }\n\n//valor=\"http://localhost/sinia3/\";\n\nvar indice = document.formbusq.webservice.selectedIndex\nvar valor = document.formbusq.webservice.options[indice].value \n//alert (valor+'buscar2.php?itembuscar='+document.formbusq.itembuscar[i].value+'&patron='+document.formbusq.patron.value)\n// Para SINIA\n//window.location.href=\"?P=Boletines&b=boletines&mes=\"+ validacion.meses.value \ngetHTTP('carga2.php','&itembuscar='+document.formbusq.itembuscar[i].value+'&patron='+document.formbusq.patron.value+'&web='+valor+'buscar2.php'+'&weblink='+valor,'div_buscar')\n// Para los Siars\n//getHTTP('buscar2.php','&itembuscar='+document.formbusq.itembuscar[i].value+'&patron='+document.formbusq.patron.value+'&web='+valor+'buscar2.php','div_buscar')\n}\n\nfunction limpiar(){\n\t      document.getElementById(\"div_buscar\").innerHTML=\"\";\n\t}\n\nfunction navegar(direccion, nueva_ventana){\n        if(direccion.toLowerCase().substring(0,3) == \"www\")\n            direccion = \"http://\" + direccion\n        if(direccion != \"\"){\n            if (nueva_ventana)\n                window.open(direccion);\n            else\n                location.href = direccion;\n        }\n    }\n//-->\n\n</script>\n<div id=\"div_buscar\">\n  <table width=\"100%\" border=\"0\">\n\n  <tr>\n    \n    \n    \n    \n    \n    \n  </tr>\n  \n</table>\n</div>\n<br/>\n\t</th>\n          </tr>\n        </table></td>\n        \t  </tr>\n    </table></td>\n  </tr>\n  <tr>\n    <td align=\"left\" background=\"public/img/web/cool-blue_r9_c8.jpg\" valign=\"top\"><table summary=\"Footer Table for Terms links and Top of page link\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n      <tr>\n        <td width=\"239\" align=\"center\" valign=\"middle\" bgcolor=\"#7DBB3B\">&nbsp;</td>\n        <td width=\"577\" align=\"center\" valign=\"middle\" bgcolor=\"#7DBB3B\"><a href=\"http://www.minam.gob.pe\" class=\"pie\">MINISTERIO DEL AMBIENTE</a><br />\n          <span class=\"style1\">Email: <a href=\"mailto:sinia@minam.gob.pe\" class=\"pie\">sinia@minam.gob.pe</a>,<br />\nTeléfono:(511)   2255370 / Fax:(511) 2255369 Â <br />\nAv. Guardia Civil NÂº 205 - San Borja<br />\nLima Perú</span></span></td>\n        <td width=\"184\" align=\"center\" valign=\"middle\" bgcolor=\"#7DBB3B\">&nbsp;</td>\n      </tr>\n    </table></td>\n  </tr>\n\n</table>\n</body>\n\n</html>\n".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

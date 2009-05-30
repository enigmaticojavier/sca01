package _pages._parametro;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _parametro extends com.orionserver.http.OrionHttpJspPage {


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
    _parametro page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      out.write(__oracle_jsp_text[2]);
      {
        org.apache.struts2.views.jsp.URLTag __jsp_taghandler_1=(org.apache.struts2.views.jsp.URLTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.URLTag.class,"org.apache.struts2.views.jsp.URLTag value");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setValue("/css/main.css");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[3]);
      {
        org.apache.struts2.views.jsp.TextTag __jsp_taghandler_2=(org.apache.struts2.views.jsp.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.TextTag.class,"org.apache.struts2.views.jsp.TextTag name");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setName("label.parametro.titulo");
        __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
        if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[4]);
      {
        org.apache.struts2.views.jsp.IfTag __jsp_taghandler_3=(org.apache.struts2.views.jsp.IfTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.IfTag.class,"org.apache.struts2.views.jsp.IfTag test");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setTest("mensajeError.codigo!=null");
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_3,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[5]);
            {
              org.apache.struts2.views.jsp.ui.LabelTag __jsp_taghandler_4=(org.apache.struts2.views.jsp.ui.LabelTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.LabelTag.class,"org.apache.struts2.views.jsp.ui.LabelTag label name");
              __jsp_taghandler_4.setParent(__jsp_taghandler_3);
              __jsp_taghandler_4.setLabel("Mensaje");
              __jsp_taghandler_4.setName("mensajeError.mensaje");
              __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
              if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,2);
            }
            out.write(__oracle_jsp_text[6]);
          } while (__jsp_taghandler_3.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[7]);
      {
        org.apache.struts2.views.jsp.TextTag __jsp_taghandler_5=(org.apache.struts2.views.jsp.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.TextTag.class,"org.apache.struts2.views.jsp.TextTag name");
        __jsp_taghandler_5.setParent(null);
        __jsp_taghandler_5.setName("label.parametro.titulo");
        __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
        if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[8]);
      {
        org.apache.struts2.views.jsp.TextTag __jsp_taghandler_6=(org.apache.struts2.views.jsp.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.TextTag.class,"org.apache.struts2.views.jsp.TextTag name");
        __jsp_taghandler_6.setParent(null);
        __jsp_taghandler_6.setName("label.parametro.titulo");
        __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
        if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,1);
      }
      out.write(__oracle_jsp_text[9]);
      {
        org.apache.struts2.views.jsp.ui.SelectTag __jsp_taghandler_7=(org.apache.struts2.views.jsp.ui.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.SelectTag.class,"org.apache.struts2.views.jsp.ui.SelectTag label list listKey listValue name onchange value");
        __jsp_taghandler_7.setParent(null);
        __jsp_taghandler_7.setLabel("Tipo de Parámetro");
        __jsp_taghandler_7.setList("tipoParametros");
        __jsp_taghandler_7.setListKey("tipParametro");
        __jsp_taghandler_7.setListValue("txtParametro");
        __jsp_taghandler_7.setName("tipParametro");
        __jsp_taghandler_7.setOnchange("javascript:cambiarTipoParametro()");
        __jsp_taghandler_7.setValue("tipParametro");
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      out.write(__oracle_jsp_text[10]);
      {
        org.displaytag.tags.TableTag __jsp_taghandler_8=(org.displaytag.tags.TableTag)OracleJspRuntime.getTagHandler(pageContext,org.displaytag.tags.TableTag.class,"org.displaytag.tags.TableTag name pagesize requestURI style class id");
        __jsp_taghandler_8.setParent(null);
        __jsp_taghandler_8.setName("parametros");
        __jsp_taghandler_8.setPagesize(10);
        __jsp_taghandler_8.setRequestURI("index");
        __jsp_taghandler_8.setStyle("width:800");
        __jsp_taghandler_8.setClass("dataTable");
        __jsp_taghandler_8.setUid("parametro");
        java.lang.Object parametro = null;
        java.lang.Integer parametro_rowNum = null;
        __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_8,__jsp_tag_starteval,out);
          do {
            parametro = (java.lang.Object) pageContext.findAttribute("parametro");
            parametro_rowNum = (java.lang.Integer) pageContext.findAttribute("parametro_rowNum");
            out.write(__oracle_jsp_text[11]);
            {
              org.displaytag.tags.ColumnTag __jsp_taghandler_9=(org.displaytag.tags.ColumnTag)OracleJspRuntime.getTagHandler(pageContext,org.displaytag.tags.ColumnTag.class,"org.displaytag.tags.ColumnTag property title style");
              __jsp_taghandler_9.setParent(__jsp_taghandler_8);
              __jsp_taghandler_9.setProperty("idParametro");
              __jsp_taghandler_9.setTitle("parametro");
              __jsp_taghandler_9.setStyle("width:1%");
              __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
              if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,2);
            }
            out.write(__oracle_jsp_text[12]);
            {
              org.displaytag.tags.ColumnTag __jsp_taghandler_10=(org.displaytag.tags.ColumnTag)OracleJspRuntime.getTagHandler(pageContext,org.displaytag.tags.ColumnTag.class,"org.displaytag.tags.ColumnTag property title style");
              __jsp_taghandler_10.setParent(__jsp_taghandler_8);
              __jsp_taghandler_10.setProperty("txtValor");
              __jsp_taghandler_10.setTitle("Valor");
              __jsp_taghandler_10.setStyle("width:35%");
              __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
              if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,2);
            }
            out.write(__oracle_jsp_text[13]);
            {
              org.displaytag.tags.ColumnTag __jsp_taghandler_11=(org.displaytag.tags.ColumnTag)OracleJspRuntime.getTagHandler(pageContext,org.displaytag.tags.ColumnTag.class,"org.displaytag.tags.ColumnTag property title style");
              __jsp_taghandler_11.setParent(__jsp_taghandler_8);
              __jsp_taghandler_11.setProperty("codParametro");
              __jsp_taghandler_11.setTitle("codParametro");
              __jsp_taghandler_11.setStyle("width:5%");
              __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
              if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,2);
            }
            out.write(__oracle_jsp_text[14]);
            {
              org.displaytag.tags.ColumnTag __jsp_taghandler_12=(org.displaytag.tags.ColumnTag)OracleJspRuntime.getTagHandler(pageContext,org.displaytag.tags.ColumnTag.class,"org.displaytag.tags.ColumnTag title href paramId paramProperty style");
              __jsp_taghandler_12.setParent(__jsp_taghandler_8);
              __jsp_taghandler_12.setTitle("Ver Detalle");
              __jsp_taghandler_12.setHref("parametro!input");
              __jsp_taghandler_12.setParamId("idParametro");
              __jsp_taghandler_12.setParamProperty("idParametro");
              __jsp_taghandler_12.setStyle("width:5%");
              __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_12,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[15]);
                } while (__jsp_taghandler_12.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,2);
            }
            out.write(__oracle_jsp_text[16]);
            {
              org.displaytag.tags.ColumnTag __jsp_taghandler_13=(org.displaytag.tags.ColumnTag)OracleJspRuntime.getTagHandler(pageContext,org.displaytag.tags.ColumnTag.class,"org.displaytag.tags.ColumnTag title href paramId paramProperty style");
              __jsp_taghandler_13.setParent(__jsp_taghandler_8);
              __jsp_taghandler_13.setTitle("Eliminar");
              __jsp_taghandler_13.setHref("parametro!delete");
              __jsp_taghandler_13.setParamId("parametro.idParametro");
              __jsp_taghandler_13.setParamProperty("idParametro");
              __jsp_taghandler_13.setStyle("width:5%");
              __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_13,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[17]);
                } while (__jsp_taghandler_13.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,2);
            }
            out.write(__oracle_jsp_text[18]);
            {
              org.apache.struts2.views.jsp.URLTag __jsp_taghandler_14=(org.apache.struts2.views.jsp.URLTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.URLTag.class,"org.apache.struts2.views.jsp.URLTag action id");
              __jsp_taghandler_14.setParent(__jsp_taghandler_8);
              __jsp_taghandler_14.setAction("parametro!input");
              __jsp_taghandler_14.setId("url");
              __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_14,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[19]);
                  {
                    org.apache.struts2.views.jsp.ParamTag __jsp_taghandler_15=(org.apache.struts2.views.jsp.ParamTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ParamTag.class,"org.apache.struts2.views.jsp.ParamTag name value");
                    __jsp_taghandler_15.setParent(__jsp_taghandler_14);
                    __jsp_taghandler_15.setName("parametro.idParametro");
                    __jsp_taghandler_15.setValue("idParametro");
                    __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
                    if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,3);
                  }
                  out.write(__oracle_jsp_text[20]);
                } while (__jsp_taghandler_14.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,2);
            }
            out.write(__oracle_jsp_text[21]);
            {
              org.apache.struts2.views.jsp.PropertyTag __jsp_taghandler_16=(org.apache.struts2.views.jsp.PropertyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.PropertyTag.class,"org.apache.struts2.views.jsp.PropertyTag value");
              __jsp_taghandler_16.setParent(__jsp_taghandler_8);
              __jsp_taghandler_16.setValue("#url");
              __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
              if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,2);
            }
            out.write(__oracle_jsp_text[22]);
            {
              org.apache.struts2.views.jsp.URLTag __jsp_taghandler_17=(org.apache.struts2.views.jsp.URLTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.URLTag.class,"org.apache.struts2.views.jsp.URLTag action id");
              __jsp_taghandler_17.setParent(__jsp_taghandler_8);
              __jsp_taghandler_17.setAction("parametro!delete.action");
              __jsp_taghandler_17.setId("url");
              __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_17,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[23]);
                  {
                    org.apache.struts2.views.jsp.ParamTag __jsp_taghandler_18=(org.apache.struts2.views.jsp.ParamTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ParamTag.class,"org.apache.struts2.views.jsp.ParamTag name value");
                    __jsp_taghandler_18.setParent(__jsp_taghandler_17);
                    __jsp_taghandler_18.setName("parametro.idParametro");
                    __jsp_taghandler_18.setValue("idParametro");
                    __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
                    if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,3);
                  }
                  out.write(__oracle_jsp_text[24]);
                } while (__jsp_taghandler_17.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,2);
            }
            out.write(__oracle_jsp_text[25]);
            {
              org.apache.struts2.views.jsp.PropertyTag __jsp_taghandler_19=(org.apache.struts2.views.jsp.PropertyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.PropertyTag.class,"org.apache.struts2.views.jsp.PropertyTag value");
              __jsp_taghandler_19.setParent(__jsp_taghandler_8);
              __jsp_taghandler_19.setValue("#url");
              __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
              if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,2);
            }
            out.write(__oracle_jsp_text[26]);
          } while (__jsp_taghandler_8.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,1);
      }
      out.write(__oracle_jsp_text[27]);
      {
        org.apache.struts2.views.jsp.ui.ActionMessageTag __jsp_taghandler_20=(org.apache.struts2.views.jsp.ui.ActionMessageTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.ActionMessageTag.class,"org.apache.struts2.views.jsp.ui.ActionMessageTag");
        __jsp_taghandler_20.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
        if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,1);
      }
      out.write(__oracle_jsp_text[28]);

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
  private static final char __oracle_jsp_text[][]=new char[29][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<html>\n<head>\n    <link href=\"".toCharArray();
    __oracle_jsp_text[3] = 
    "\" rel=\"stylesheet\" type=\"text/css\"/>\n    <LINK HREF=\"styles/displaytagsca.css\" REL=\"stylesheet\" TYPE=\"text/css\">\n    <title>".toCharArray();
    __oracle_jsp_text[4] = 
    "</title>\n    <script language=\"javascript\">\n        function cambiarTipoParametro(){\n          var frm=document.forms[0];\n          frm.action=\"index\";\n          frm.submit();\n        }\n        function nuevoParametro(){\n          var frm=document.forms[0];\n          frm.action=\"parametro!input\";\n          frm.submit();\n        }\n    </script>\n</head>\n<body align=\"center\" leftmargin=\"0\" topmargin=\"0\" width=\"500\">\n    \n    ".toCharArray();
    __oracle_jsp_text[5] = 
    "\n    <div class=\"titleDiv\">\n    ".toCharArray();
    __oracle_jsp_text[6] = 
    "\n    </div>\n    ".toCharArray();
    __oracle_jsp_text[7] = 
    "\n    <!--div class=\"titleDiv\">".toCharArray();
    __oracle_jsp_text[8] = 
    "</div-->\n    <h1 align=\"left\">".toCharArray();
    __oracle_jsp_text[9] = 
    "</h1>\n    <form action=\"\">\n    ".toCharArray();
    __oracle_jsp_text[10] = 
    "\n    <br/>\n    \n    <br/>\n        ".toCharArray();
    __oracle_jsp_text[11] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[13] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[14] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[15] = 
    "Detalle".toCharArray();
    __oracle_jsp_text[16] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[17] = 
    "Eliminar".toCharArray();
    __oracle_jsp_text[18] = 
    "\n            <!--paramIs es una propiedad del action -->\n            <td class=\"nowrap\">\n                ".toCharArray();
    __oracle_jsp_text[19] = 
    "\n                    ".toCharArray();
    __oracle_jsp_text[20] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[21] = 
    "\n                <a href=\"".toCharArray();
    __oracle_jsp_text[22] = 
    "\">Edit</a>\n            </td>    \n            <td class=\"nowrap\">    \n                &nbsp;&nbsp;&nbsp;\n                ".toCharArray();
    __oracle_jsp_text[23] = 
    "\n                    ".toCharArray();
    __oracle_jsp_text[24] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[25] = 
    "\n                <a href=\"".toCharArray();
    __oracle_jsp_text[26] = 
    "\">Delete</a>\n            </td>\n            \n        ".toCharArray();
    __oracle_jsp_text[27] = 
    "\n        <a href=\"javascript:nuevoParametro()\">Nuevo Parametro</a>\n        ".toCharArray();
    __oracle_jsp_text[28] = 
    "\n        \n    </form>\n</body>\n</html>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

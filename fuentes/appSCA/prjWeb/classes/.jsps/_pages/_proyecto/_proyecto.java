package _pages._proyecto;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _proyecto extends com.orionserver.http.OrionHttpJspPage {


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
    _proyecto page = this;
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
        __jsp_taghandler_2.setName("label.proyecto.titulo");
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
        __jsp_taghandler_6.setName("label.proyecto.titulo");
        __jsp_tag_starteval=__jsp_taghandler_6.doStartTag();
        if (__jsp_taghandler_6.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_6,1);
      }
      out.write(__oracle_jsp_text[9]);
      {
        org.apache.struts2.views.jsp.ui.TextFieldTag __jsp_taghandler_7=(org.apache.struts2.views.jsp.ui.TextFieldTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.TextFieldTag.class,"org.apache.struts2.views.jsp.ui.TextFieldTag label name size value");
        __jsp_taghandler_7.setParent(null);
        __jsp_taghandler_7.setLabel("%{getText('label.proyecto.txtDescripcion')}");
        __jsp_taghandler_7.setName("txtDescripcion");
        __jsp_taghandler_7.setSize("40");
        __jsp_taghandler_7.setValue("%{txtDescripcion}");
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      out.write(__oracle_jsp_text[10]);
      {
        org.apache.struts2.views.jsp.ui.SelectTag __jsp_taghandler_8=(org.apache.struts2.views.jsp.ui.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.SelectTag.class,"org.apache.struts2.views.jsp.ui.SelectTag label list listKey listValue name value");
        __jsp_taghandler_8.setParent(null);
        __jsp_taghandler_8.setLabel("Departamento");
        __jsp_taghandler_8.setList("ubiDepartamentos");
        __jsp_taghandler_8.setListKey("ubigeoId");
        __jsp_taghandler_8.setListValue("txtDescripcion");
        __jsp_taghandler_8.setName("ubigeoId");
        __jsp_taghandler_8.setValue("ubigeoId");
        __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
        if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,1);
      }
      out.write(__oracle_jsp_text[11]);
      {
        org.apache.struts2.views.jsp.ui.SelectTag __jsp_taghandler_9=(org.apache.struts2.views.jsp.ui.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.SelectTag.class,"org.apache.struts2.views.jsp.ui.SelectTag label list listKey listValue name value");
        __jsp_taghandler_9.setParent(null);
        __jsp_taghandler_9.setLabel("Categoria del Proyecto");
        __jsp_taghandler_9.setList("parCategProy");
        __jsp_taghandler_9.setListKey("codParametro");
        __jsp_taghandler_9.setListValue("txtValor");
        __jsp_taghandler_9.setName("clsTipificacion");
        __jsp_taghandler_9.setValue("clsTipificacion");
        __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
        if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,1);
      }
      out.write(__oracle_jsp_text[12]);
      {
        org.apache.struts2.views.jsp.ui.TextFieldTag __jsp_taghandler_10=(org.apache.struts2.views.jsp.ui.TextFieldTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.TextFieldTag.class,"org.apache.struts2.views.jsp.ui.TextFieldTag label name size value");
        __jsp_taghandler_10.setParent(null);
        __jsp_taghandler_10.setLabel("%{getText('label.proyecto.fchExpedienteDesde')}");
        __jsp_taghandler_10.setName("fchExpedienteDesde");
        __jsp_taghandler_10.setSize("10");
        __jsp_taghandler_10.setValue("%{fchExpedienteDesde}");
        __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_10,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[13]);
            {
              org.apache.struts2.views.jsp.ParamTag __jsp_taghandler_11=(org.apache.struts2.views.jsp.ParamTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ParamTag.class,"org.apache.struts2.views.jsp.ParamTag name");
              __jsp_taghandler_11.setParent(__jsp_taghandler_10);
              __jsp_taghandler_11.setName("value");
              __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_11,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[14]);
                  {
                    org.apache.struts2.views.jsp.DateTag __jsp_taghandler_12=(org.apache.struts2.views.jsp.DateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.DateTag.class,"org.apache.struts2.views.jsp.DateTag format name");
                    __jsp_taghandler_12.setParent(__jsp_taghandler_11);
                    __jsp_taghandler_12.setFormat("dd/MM/yyyy");
                    __jsp_taghandler_12.setName("fchExpedienteDesde");
                    __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
                    if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,3);
                  }
                  out.write(__oracle_jsp_text[15]);
                } while (__jsp_taghandler_11.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,2);
            }
            out.write(__oracle_jsp_text[16]);
          } while (__jsp_taghandler_10.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,1);
      }
      out.write(__oracle_jsp_text[17]);
      {
        org.apache.struts2.views.jsp.ui.TextFieldTag __jsp_taghandler_13=(org.apache.struts2.views.jsp.ui.TextFieldTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.TextFieldTag.class,"org.apache.struts2.views.jsp.ui.TextFieldTag label name size value");
        __jsp_taghandler_13.setParent(null);
        __jsp_taghandler_13.setLabel("%{getText('label.proyecto.fchExpedienteHasta')}");
        __jsp_taghandler_13.setName("fchExpedienteHasta");
        __jsp_taghandler_13.setSize("10");
        __jsp_taghandler_13.setValue("%{fchExpedienteHasta}");
        __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_13,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[18]);
            {
              org.apache.struts2.views.jsp.ParamTag __jsp_taghandler_14=(org.apache.struts2.views.jsp.ParamTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ParamTag.class,"org.apache.struts2.views.jsp.ParamTag name");
              __jsp_taghandler_14.setParent(__jsp_taghandler_13);
              __jsp_taghandler_14.setName("value");
              __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_14,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[19]);
                  {
                    org.apache.struts2.views.jsp.DateTag __jsp_taghandler_15=(org.apache.struts2.views.jsp.DateTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.DateTag.class,"org.apache.struts2.views.jsp.DateTag format name");
                    __jsp_taghandler_15.setParent(__jsp_taghandler_14);
                    __jsp_taghandler_15.setFormat("dd/MM/yyyy");
                    __jsp_taghandler_15.setName("fchExpedienteHasta");
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
          } while (__jsp_taghandler_13.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_13.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_13,1);
      }
      out.write(__oracle_jsp_text[22]);
      {
        org.apache.struts2.views.jsp.ui.SelectTag __jsp_taghandler_16=(org.apache.struts2.views.jsp.ui.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.SelectTag.class,"org.apache.struts2.views.jsp.ui.SelectTag label list listKey listValue name value");
        __jsp_taghandler_16.setParent(null);
        __jsp_taghandler_16.setLabel("Estado del Tramite");
        __jsp_taghandler_16.setList("parEstadoTramite");
        __jsp_taghandler_16.setListKey("codParametro");
        __jsp_taghandler_16.setListValue("txtValor");
        __jsp_taghandler_16.setName("estadoTramite");
        __jsp_taghandler_16.setValue("estadoTramite");
        __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
        if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,1);
      }
      out.write(__oracle_jsp_text[23]);
      {
        org.apache.struts2.views.jsp.ui.SelectTag __jsp_taghandler_17=(org.apache.struts2.views.jsp.ui.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.SelectTag.class,"org.apache.struts2.views.jsp.ui.SelectTag label list listKey listValue name onchange value");
        __jsp_taghandler_17.setParent(null);
        __jsp_taghandler_17.setLabel("Tipo Acae");
        __jsp_taghandler_17.setList("parTipoAcae");
        __jsp_taghandler_17.setListKey("codParametro");
        __jsp_taghandler_17.setListValue("txtValor");
        __jsp_taghandler_17.setName("tipoAcae");
        __jsp_taghandler_17.setOnchange("javascript:cambiarTipoAcae()");
        __jsp_taghandler_17.setValue("tipoAcae");
        __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
        if (__jsp_taghandler_17.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_17,1);
      }
      out.write(__oracle_jsp_text[24]);
      {
        org.apache.struts2.views.jsp.ui.SelectTag __jsp_taghandler_18=(org.apache.struts2.views.jsp.ui.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.SelectTag.class,"org.apache.struts2.views.jsp.ui.SelectTag label list listKey listValue name onchange value");
        __jsp_taghandler_18.setParent(null);
        __jsp_taghandler_18.setLabel("Institucion");
        __jsp_taghandler_18.setList("parInstitucion");
        __jsp_taghandler_18.setListKey("codParametro");
        __jsp_taghandler_18.setListValue("txtValor");
        __jsp_taghandler_18.setName("clsSector");
        __jsp_taghandler_18.setOnchange("javascript:cambiarInstitucion()");
        __jsp_taghandler_18.setValue("clsSector");
        __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
        if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,1);
      }
      out.write(__oracle_jsp_text[25]);
      {
        org.apache.struts2.views.jsp.ui.SelectTag __jsp_taghandler_19=(org.apache.struts2.views.jsp.ui.SelectTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.SelectTag.class,"org.apache.struts2.views.jsp.ui.SelectTag label list listKey listValue name value");
        __jsp_taghandler_19.setParent(null);
        __jsp_taghandler_19.setLabel("Dependencia");
        __jsp_taghandler_19.setList("parDependencia");
        __jsp_taghandler_19.setListKey("clsSubSector");
        __jsp_taghandler_19.setListValue("txtSubSector");
        __jsp_taghandler_19.setName("clsSubSector");
        __jsp_taghandler_19.setValue("clsSubSector");
        __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
        if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,1);
      }
      out.write(__oracle_jsp_text[26]);
      {
        org.apache.struts2.views.jsp.ui.SubmitTag __jsp_taghandler_20=(org.apache.struts2.views.jsp.ui.SubmitTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.SubmitTag.class,"org.apache.struts2.views.jsp.ui.SubmitTag onclick value");
        __jsp_taghandler_20.setParent(null);
        __jsp_taghandler_20.setOnclick("buscarProyecto()");
        __jsp_taghandler_20.setValue("%{getText('button.label.submit')}");
        __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
        if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,1);
      }
      out.write(__oracle_jsp_text[27]);
      {
        org.displaytag.tags.TableTag __jsp_taghandler_21=(org.displaytag.tags.TableTag)OracleJspRuntime.getTagHandler(pageContext,org.displaytag.tags.TableTag.class,"org.displaytag.tags.TableTag name pagesize requestURI style class id");
        __jsp_taghandler_21.setParent(null);
        __jsp_taghandler_21.setName("proyectos");
        __jsp_taghandler_21.setPagesize(10);
        __jsp_taghandler_21.setRequestURI("index");
        __jsp_taghandler_21.setStyle("width:800");
        __jsp_taghandler_21.setClass("dataTable");
        __jsp_taghandler_21.setUid("parametro");
        java.lang.Object parametro = null;
        java.lang.Integer parametro_rowNum = null;
        __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_21,__jsp_tag_starteval,out);
          do {
            parametro = (java.lang.Object) pageContext.findAttribute("parametro");
            parametro_rowNum = (java.lang.Integer) pageContext.findAttribute("parametro_rowNum");
            out.write(__oracle_jsp_text[28]);
            {
              org.displaytag.tags.ColumnTag __jsp_taghandler_22=(org.displaytag.tags.ColumnTag)OracleJspRuntime.getTagHandler(pageContext,org.displaytag.tags.ColumnTag.class,"org.displaytag.tags.ColumnTag property title style");
              __jsp_taghandler_22.setParent(__jsp_taghandler_21);
              __jsp_taghandler_22.setProperty("pryId");
              __jsp_taghandler_22.setTitle("proyecto.pryId");
              __jsp_taghandler_22.setStyle("width:1%");
              __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
              if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,2);
            }
            out.write(__oracle_jsp_text[29]);
            {
              org.displaytag.tags.ColumnTag __jsp_taghandler_23=(org.displaytag.tags.ColumnTag)OracleJspRuntime.getTagHandler(pageContext,org.displaytag.tags.ColumnTag.class,"org.displaytag.tags.ColumnTag property title style");
              __jsp_taghandler_23.setParent(__jsp_taghandler_21);
              __jsp_taghandler_23.setProperty("txtDescripcion");
              __jsp_taghandler_23.setTitle("proyecto.txtDescripcion");
              __jsp_taghandler_23.setStyle("width:35%");
              __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
              if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,2);
            }
            out.write(__oracle_jsp_text[30]);
            {
              org.displaytag.tags.ColumnTag __jsp_taghandler_24=(org.displaytag.tags.ColumnTag)OracleJspRuntime.getTagHandler(pageContext,org.displaytag.tags.ColumnTag.class,"org.displaytag.tags.ColumnTag property title style");
              __jsp_taghandler_24.setParent(__jsp_taghandler_21);
              __jsp_taghandler_24.setProperty("clsTipificacion");
              __jsp_taghandler_24.setTitle("proyecto.clsTipificacion");
              __jsp_taghandler_24.setStyle("width:35%");
              __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
              if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,2);
            }
            out.write(__oracle_jsp_text[31]);
            {
              org.displaytag.tags.ColumnTag __jsp_taghandler_25=(org.displaytag.tags.ColumnTag)OracleJspRuntime.getTagHandler(pageContext,org.displaytag.tags.ColumnTag.class,"org.displaytag.tags.ColumnTag property title style");
              __jsp_taghandler_25.setParent(__jsp_taghandler_21);
              __jsp_taghandler_25.setProperty("personaId");
              __jsp_taghandler_25.setTitle("proyecto.personaId");
              __jsp_taghandler_25.setStyle("width:35%");
              __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
              if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,2);
            }
            out.write(__oracle_jsp_text[32]);
            {
              org.displaytag.tags.ColumnTag __jsp_taghandler_26=(org.displaytag.tags.ColumnTag)OracleJspRuntime.getTagHandler(pageContext,org.displaytag.tags.ColumnTag.class,"org.displaytag.tags.ColumnTag property title style");
              __jsp_taghandler_26.setParent(__jsp_taghandler_21);
              __jsp_taghandler_26.setProperty("fchExpediente");
              __jsp_taghandler_26.setTitle("proyecto.fchExpediente");
              __jsp_taghandler_26.setStyle("width:35%");
              __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
              if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,2);
            }
            out.write(__oracle_jsp_text[33]);
            {
              org.displaytag.tags.ColumnTag __jsp_taghandler_27=(org.displaytag.tags.ColumnTag)OracleJspRuntime.getTagHandler(pageContext,org.displaytag.tags.ColumnTag.class,"org.displaytag.tags.ColumnTag property title style");
              __jsp_taghandler_27.setParent(__jsp_taghandler_21);
              __jsp_taghandler_27.setProperty("ubigeoId");
              __jsp_taghandler_27.setTitle("proyecto.ubigeoId");
              __jsp_taghandler_27.setStyle("width:35%");
              __jsp_tag_starteval=__jsp_taghandler_27.doStartTag();
              if (__jsp_taghandler_27.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_27,2);
            }
            out.write(__oracle_jsp_text[34]);
            {
              org.displaytag.tags.ColumnTag __jsp_taghandler_28=(org.displaytag.tags.ColumnTag)OracleJspRuntime.getTagHandler(pageContext,org.displaytag.tags.ColumnTag.class,"org.displaytag.tags.ColumnTag property title style");
              __jsp_taghandler_28.setParent(__jsp_taghandler_21);
              __jsp_taghandler_28.setProperty("ubigeoId");
              __jsp_taghandler_28.setTitle("proyecto.estado");
              __jsp_taghandler_28.setStyle("width:5%");
              __jsp_tag_starteval=__jsp_taghandler_28.doStartTag();
              if (__jsp_taghandler_28.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_28,2);
            }
            out.write(__oracle_jsp_text[35]);
            {
              org.displaytag.tags.ColumnTag __jsp_taghandler_29=(org.displaytag.tags.ColumnTag)OracleJspRuntime.getTagHandler(pageContext,org.displaytag.tags.ColumnTag.class,"org.displaytag.tags.ColumnTag title href paramId paramProperty style");
              __jsp_taghandler_29.setParent(__jsp_taghandler_21);
              __jsp_taghandler_29.setTitle("Ver Detalle");
              __jsp_taghandler_29.setHref("proyecto!input");
              __jsp_taghandler_29.setParamId("pryId");
              __jsp_taghandler_29.setParamProperty("pryId");
              __jsp_taghandler_29.setStyle("width:5%");
              __jsp_tag_starteval=__jsp_taghandler_29.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_29,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[36]);
                } while (__jsp_taghandler_29.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_29.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_29,2);
            }
            out.write(__oracle_jsp_text[37]);
          } while (__jsp_taghandler_21.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,1);
      }
      out.write(__oracle_jsp_text[38]);
      {
        org.apache.struts2.views.jsp.ui.ActionMessageTag __jsp_taghandler_30=(org.apache.struts2.views.jsp.ui.ActionMessageTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.ActionMessageTag.class,"org.apache.struts2.views.jsp.ui.ActionMessageTag");
        __jsp_taghandler_30.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_30.doStartTag();
        if (__jsp_taghandler_30.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_30,1);
      }
      out.write(__oracle_jsp_text[39]);

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
  private static final char __oracle_jsp_text[][]=new char[40][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n<html>\n<head>\n    <link href=\"".toCharArray();
    __oracle_jsp_text[3] = 
    "\" rel=\"stylesheet\" type=\"text/css\"/>\n    <LINK HREF=\"styles/displaytagsca.css\" REL=\"stylesheet\" TYPE=\"text/css\">\n    <!--LINK HREF=\"styles/fecha.css\" REL=\"stylesheet\" TYPE=\"text/css\"-->\n    <!--LINK HREF=\"styles/DatePicker.css\" REL=\"stylesheet\" TYPE=\"text/css\"-->\n    <!--script src=\"script/fecha.js\"></script-->\n    <!--script src=\"script/DatePicker.js\"></script-->\n    <title>".toCharArray();
    __oracle_jsp_text[4] = 
    "</title>\n    <script language=\"javascript\">\n        function cambiarTipoAcae(){\n          var frm=document.forms[0];\n          frm.action=\"proyecto!buscarInstitucionXTipoAcae\";\n          frm.submit();  \n        }\n        function cambiarInstitucion(){\n          var frm=document.forms[0];\n          frm.action=\"proyecto!buscarDependenciaXInstitucion\";\n          frm.submit();\n        }\n        function buscarProyecto(){\n          //var valid = validar();  \n          //alert(valid);\n          //if (valid){\n              var frm=document.forms[0];\n              frm.action=\"proyecto!buscarProyecto.action\";\n              frm.submit();  \n          //}    \n        }\n        function validar(){\n          alert('jaj');  \n          var obj = document.getElementById('fchExpedienteDesde');\n          if (!validaFecha(obj)){\n             alert('jaj111');              \n             return false;\n          }\n          alert('jaj1');  \n          obj = document.getElementById('fchExpedienteHasta');\n          if (!validaFecha(obj)){\n             return false;\n          }\n          return true;  \n        }\n        function validaFecha(fld) {\n            var RegExPattern = /^((((0?[1-9]|[12]\\d|3[01])[\\.\\-\\/](0?[13578]|1[02])[\\.\\-\\/]((1[6-9]|[2-9]\\d)?\\d{2}))|((0?[1-9]|[12]\\d|30)[\\.\\-\\/](0?[13456789]|1[012])[\\.\\-\\/]((1[6-9]|[2-9]\\d)?\\d{2}))|((0?[1-9]|1\\d|2[0-8])[\\.\\-\\/]0?2[\\.\\-\\/]((1[6-9]|[2-9]\\d)?\\d{2}))|(29[\\.\\-\\/]0?2[\\.\\-\\/]((1[6-9]|[2-9]\\d)?(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00)|00)))|(((0[1-9]|[12]\\d|3[01])(0[13578]|1[02])((1[6-9]|[2-9]\\d)?\\d{2}))|((0[1-9]|[12]\\d|30)(0[13456789]|1[012])((1[6-9]|[2-9]\\d)?\\d{2}))|((0[1-9]|1\\d|2[0-8])02((1[6-9]|[2-9]\\d)?\\d{2}))|(2902((1[6-9]|[2-9]\\d)?(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00)|00))))$/;\n            var errorMessage = 'Fecha no valida';\n            if ((fld.value.match(RegExPattern)) && (fld.value!='')) {\n                return true;\n            } else {\n                alert(errorMessage);\n                fld.focus();\n                return false;\n            } \n        }\n    </script>\n</head>\n<body align=\"center\" leftmargin=\"0\" topmargin=\"0\" width=\"500\">\n    \n    \n    \n    ".toCharArray();
    __oracle_jsp_text[5] = 
    "\n    <div class=\"titleDiv\">\n    ".toCharArray();
    __oracle_jsp_text[6] = 
    "\n    </div>\n    ".toCharArray();
    __oracle_jsp_text[7] = 
    "\n    <!--div class=\"titleDiv\">".toCharArray();
    __oracle_jsp_text[8] = 
    "</div-->\n    <h1 align=\"left\">".toCharArray();
    __oracle_jsp_text[9] = 
    "</h1>\n    \n        <form >\n                <div>\n                <table>\n                ".toCharArray();
    __oracle_jsp_text[10] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[11] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[12] = 
    "\n                </table>\n                </div>\n                <div>\n                <!--s:label label=\"Fecha de Presentacion\" /-->\n                ".toCharArray();
    __oracle_jsp_text[13] = 
    "\n                   ".toCharArray();
    __oracle_jsp_text[14] = 
    "\n                     ".toCharArray();
    __oracle_jsp_text[15] = 
    "\n                   ".toCharArray();
    __oracle_jsp_text[16] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[17] = 
    "\n                <!--input type=button value=\"select\" onclick=\"displayDatePicker('fchExpedienteDesde', this);\"-->\n                \n                ".toCharArray();
    __oracle_jsp_text[18] = 
    "\n                   ".toCharArray();
    __oracle_jsp_text[19] = 
    "\n                     ".toCharArray();
    __oracle_jsp_text[20] = 
    "\n                   ".toCharArray();
    __oracle_jsp_text[21] = 
    "\n                ".toCharArray();
    __oracle_jsp_text[22] = 
    "\n                \n                </div>\n                <div>\n                ".toCharArray();
    __oracle_jsp_text[23] = 
    "\n                </div>\n                <div>\n                ".toCharArray();
    __oracle_jsp_text[24] = 
    "\n                </div>\n                <div>\n                ".toCharArray();
    __oracle_jsp_text[25] = 
    "\n                </div>\n                <div>\n                ".toCharArray();
    __oracle_jsp_text[26] = 
    "\n                </div>\n                \n                ".toCharArray();
    __oracle_jsp_text[27] = 
    "\n        \n        \n        ".toCharArray();
    __oracle_jsp_text[28] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[29] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[30] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[31] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[32] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[33] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[34] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[35] = 
    "\n            ".toCharArray();
    __oracle_jsp_text[36] = 
    "Detalle".toCharArray();
    __oracle_jsp_text[37] = 
    "\n            <!--paramId es una propiedad del action -->\n        ".toCharArray();
    __oracle_jsp_text[38] = 
    "\n        \n        ".toCharArray();
    __oracle_jsp_text[39] = 
    "\n        \n    </form>\n</body>\n</html>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

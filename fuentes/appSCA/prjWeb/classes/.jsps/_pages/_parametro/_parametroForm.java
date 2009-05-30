package _pages._parametro;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _parametroForm extends com.orionserver.http.OrionHttpJspPage {


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
    _parametroForm page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      {
        org.apache.struts2.views.jsp.IfTag __jsp_taghandler_1=(org.apache.struts2.views.jsp.IfTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.IfTag.class,"org.apache.struts2.views.jsp.IfTag test");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setTest("parametro==null || parametro.idParametro == null");
        __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_1,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[2]);
            {
              org.apache.struts2.views.jsp.SetTag __jsp_taghandler_2=(org.apache.struts2.views.jsp.SetTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.SetTag.class,"org.apache.struts2.views.jsp.SetTag name value");
              __jsp_taghandler_2.setParent(__jsp_taghandler_1);
              __jsp_taghandler_2.setName("title");
              __jsp_taghandler_2.setValue("%{'Nuevo Parametro'}");
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
        org.apache.struts2.views.jsp.ElseTag __jsp_taghandler_3=(org.apache.struts2.views.jsp.ElseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ElseTag.class,"org.apache.struts2.views.jsp.ElseTag");
        __jsp_taghandler_3.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_3,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[5]);
            {
              org.apache.struts2.views.jsp.SetTag __jsp_taghandler_4=(org.apache.struts2.views.jsp.SetTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.SetTag.class,"org.apache.struts2.views.jsp.SetTag name value");
              __jsp_taghandler_4.setParent(__jsp_taghandler_3);
              __jsp_taghandler_4.setName("title");
              __jsp_taghandler_4.setValue("%{'Actualización Parametro'}");
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
        org.apache.struts2.views.jsp.URLTag __jsp_taghandler_5=(org.apache.struts2.views.jsp.URLTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.URLTag.class,"org.apache.struts2.views.jsp.URLTag value");
        __jsp_taghandler_5.setParent(null);
        __jsp_taghandler_5.setValue("/css/main.css");
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
        org.apache.struts2.views.jsp.TextTag __jsp_taghandler_7=(org.apache.struts2.views.jsp.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.TextTag.class,"org.apache.struts2.views.jsp.TextTag name");
        __jsp_taghandler_7.setParent(null);
        __jsp_taghandler_7.setName("label.parametro.titulo");
        __jsp_tag_starteval=__jsp_taghandler_7.doStartTag();
        if (__jsp_taghandler_7.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_7,1);
      }
      out.write(__oracle_jsp_text[10]);
      {
        org.apache.struts2.views.jsp.TextTag __jsp_taghandler_8=(org.apache.struts2.views.jsp.TextTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.TextTag.class,"org.apache.struts2.views.jsp.TextTag name");
        __jsp_taghandler_8.setParent(null);
        __jsp_taghandler_8.setName("label.parametro.titulo");
        __jsp_tag_starteval=__jsp_taghandler_8.doStartTag();
        if (__jsp_taghandler_8.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_8,1);
      }
      out.write(__oracle_jsp_text[11]);
      {
        org.apache.struts2.views.jsp.PropertyTag __jsp_taghandler_9=(org.apache.struts2.views.jsp.PropertyTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.PropertyTag.class,"org.apache.struts2.views.jsp.PropertyTag value");
        __jsp_taghandler_9.setParent(null);
        __jsp_taghandler_9.setValue("#title");
        __jsp_tag_starteval=__jsp_taghandler_9.doStartTag();
        if (__jsp_taghandler_9.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_9,1);
      }
      out.write(__oracle_jsp_text[12]);
      {
        org.apache.struts2.views.jsp.ui.ActionErrorTag __jsp_taghandler_10=(org.apache.struts2.views.jsp.ui.ActionErrorTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.ActionErrorTag.class,"org.apache.struts2.views.jsp.ui.ActionErrorTag");
        __jsp_taghandler_10.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_10.doStartTag();
        if (__jsp_taghandler_10.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_10,1);
      }
      out.write(__oracle_jsp_text[13]);
      {
        org.apache.struts2.views.jsp.ui.ActionMessageTag __jsp_taghandler_11=(org.apache.struts2.views.jsp.ui.ActionMessageTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.ActionMessageTag.class,"org.apache.struts2.views.jsp.ui.ActionMessageTag");
        __jsp_taghandler_11.setParent(null);
        __jsp_tag_starteval=__jsp_taghandler_11.doStartTag();
        if (__jsp_taghandler_11.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_11,1);
      }
      out.write(__oracle_jsp_text[14]);
      {
        org.apache.struts2.views.jsp.ui.FormTag __jsp_taghandler_12=(org.apache.struts2.views.jsp.ui.FormTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.FormTag.class,"org.apache.struts2.views.jsp.ui.FormTag action method");
        __jsp_taghandler_12.setParent(null);
        __jsp_taghandler_12.setAction("parametro!save.action");
        __jsp_taghandler_12.setMethod("post");
        __jsp_tag_starteval=__jsp_taghandler_12.doStartTag();
        if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
        {
          out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_12,__jsp_tag_starteval,out);
          do {
            out.write(__oracle_jsp_text[15]);
            {
              org.apache.struts2.views.jsp.IfTag __jsp_taghandler_13=(org.apache.struts2.views.jsp.IfTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.IfTag.class,"org.apache.struts2.views.jsp.IfTag test");
              __jsp_taghandler_13.setParent(__jsp_taghandler_12);
              __jsp_taghandler_13.setTest("parametro==null || parametro.idParametro == null");
              __jsp_tag_starteval=__jsp_taghandler_13.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_13,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[16]);
                  {
                    org.apache.struts2.views.jsp.ui.TextFieldTag __jsp_taghandler_14=(org.apache.struts2.views.jsp.ui.TextFieldTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.TextFieldTag.class,"org.apache.struts2.views.jsp.ui.TextFieldTag disabled label name size value");
                    __jsp_taghandler_14.setParent(__jsp_taghandler_13);
                    __jsp_taghandler_14.setDisabled("true");
                    __jsp_taghandler_14.setLabel("%{getText('label.parametro.idParametro')}");
                    __jsp_taghandler_14.setName("parametro.idParametro");
                    __jsp_taghandler_14.setSize("20");
                    __jsp_taghandler_14.setValue("%{parametro.idParametro}");
                    __jsp_tag_starteval=__jsp_taghandler_14.doStartTag();
                    if (__jsp_taghandler_14.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_14,3);
                  }
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
              org.apache.struts2.views.jsp.ElseTag __jsp_taghandler_15=(org.apache.struts2.views.jsp.ElseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ElseTag.class,"org.apache.struts2.views.jsp.ElseTag");
              __jsp_taghandler_15.setParent(__jsp_taghandler_12);
              __jsp_tag_starteval=__jsp_taghandler_15.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_15,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[19]);
                  {
                    org.apache.struts2.views.jsp.ui.TextFieldTag __jsp_taghandler_16=(org.apache.struts2.views.jsp.ui.TextFieldTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.TextFieldTag.class,"org.apache.struts2.views.jsp.ui.TextFieldTag disabled label name size value");
                    __jsp_taghandler_16.setParent(__jsp_taghandler_15);
                    __jsp_taghandler_16.setDisabled("false");
                    __jsp_taghandler_16.setLabel("%{getText('label.parametro.idParametro')}");
                    __jsp_taghandler_16.setName("parametro.idParametro");
                    __jsp_taghandler_16.setSize("20");
                    __jsp_taghandler_16.setValue("%{parametro.idParametro}");
                    __jsp_tag_starteval=__jsp_taghandler_16.doStartTag();
                    if (__jsp_taghandler_16.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_16,3);
                  }
                  out.write(__oracle_jsp_text[20]);
                } while (__jsp_taghandler_15.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_15.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_15,2);
            }
            out.write(__oracle_jsp_text[21]);
            {
              org.apache.struts2.views.jsp.IfTag __jsp_taghandler_17=(org.apache.struts2.views.jsp.IfTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.IfTag.class,"org.apache.struts2.views.jsp.IfTag test");
              __jsp_taghandler_17.setParent(__jsp_taghandler_12);
              __jsp_taghandler_17.setTest("parametro==null || parametro.idParametro == null");
              __jsp_tag_starteval=__jsp_taghandler_17.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_17,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[22]);
                  {
                    org.apache.struts2.views.jsp.ui.TextFieldTag __jsp_taghandler_18=(org.apache.struts2.views.jsp.ui.TextFieldTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.TextFieldTag.class,"org.apache.struts2.views.jsp.ui.TextFieldTag label name readonly size value");
                    __jsp_taghandler_18.setParent(__jsp_taghandler_17);
                    __jsp_taghandler_18.setLabel("%{getText('label.parametro.tipParametro')}");
                    __jsp_taghandler_18.setName("parametro.tipParametro");
                    __jsp_taghandler_18.setReadonly("true");
                    __jsp_taghandler_18.setSize("40");
                    __jsp_taghandler_18.setValue("%{parametro.tipParametro}");
                    __jsp_tag_starteval=__jsp_taghandler_18.doStartTag();
                    if (__jsp_taghandler_18.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_18,3);
                  }
                  out.write(__oracle_jsp_text[23]);
                  {
                    org.apache.struts2.views.jsp.ui.TextFieldTag __jsp_taghandler_19=(org.apache.struts2.views.jsp.ui.TextFieldTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.TextFieldTag.class,"org.apache.struts2.views.jsp.ui.TextFieldTag label name readonly size value");
                    __jsp_taghandler_19.setParent(__jsp_taghandler_17);
                    __jsp_taghandler_19.setLabel("%{getText('label.parametro.txtParametro')}");
                    __jsp_taghandler_19.setName("parametro.txtParametro");
                    __jsp_taghandler_19.setReadonly("true");
                    __jsp_taghandler_19.setSize("40");
                    __jsp_taghandler_19.setValue("%{parametro.txtParametro}");
                    __jsp_tag_starteval=__jsp_taghandler_19.doStartTag();
                    if (__jsp_taghandler_19.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_19,3);
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
              org.apache.struts2.views.jsp.ElseTag __jsp_taghandler_20=(org.apache.struts2.views.jsp.ElseTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ElseTag.class,"org.apache.struts2.views.jsp.ElseTag");
              __jsp_taghandler_20.setParent(__jsp_taghandler_12);
              __jsp_tag_starteval=__jsp_taghandler_20.doStartTag();
              if (OracleJspRuntime.checkStartBodyTagEval(__jsp_tag_starteval))
              {
                out=OracleJspRuntime.pushBodyIfNeeded(pageContext,__jsp_taghandler_20,__jsp_tag_starteval,out);
                do {
                  out.write(__oracle_jsp_text[26]);
                  {
                    org.apache.struts2.views.jsp.ui.TextFieldTag __jsp_taghandler_21=(org.apache.struts2.views.jsp.ui.TextFieldTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.TextFieldTag.class,"org.apache.struts2.views.jsp.ui.TextFieldTag label name readonly size value");
                    __jsp_taghandler_21.setParent(__jsp_taghandler_20);
                    __jsp_taghandler_21.setLabel("%{getText('label.parametro.tipParametro')}");
                    __jsp_taghandler_21.setName("parametro.tipParametro");
                    __jsp_taghandler_21.setReadonly("true");
                    __jsp_taghandler_21.setSize("40");
                    __jsp_taghandler_21.setValue("%{parametro.tipParametro}");
                    __jsp_tag_starteval=__jsp_taghandler_21.doStartTag();
                    if (__jsp_taghandler_21.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_21,3);
                  }
                  out.write(__oracle_jsp_text[27]);
                  {
                    org.apache.struts2.views.jsp.ui.TextFieldTag __jsp_taghandler_22=(org.apache.struts2.views.jsp.ui.TextFieldTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.TextFieldTag.class,"org.apache.struts2.views.jsp.ui.TextFieldTag label name readonly size value");
                    __jsp_taghandler_22.setParent(__jsp_taghandler_20);
                    __jsp_taghandler_22.setLabel("%{getText('label.parametro.txtParametro')}");
                    __jsp_taghandler_22.setName("parametro.txtParametro");
                    __jsp_taghandler_22.setReadonly("true");
                    __jsp_taghandler_22.setSize("40");
                    __jsp_taghandler_22.setValue("%{parametro.txtParametro}");
                    __jsp_tag_starteval=__jsp_taghandler_22.doStartTag();
                    if (__jsp_taghandler_22.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                    OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_22,3);
                  }
                  out.write(__oracle_jsp_text[28]);
                } while (__jsp_taghandler_20.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
              }
              if (__jsp_taghandler_20.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_20,2);
            }
            out.write(__oracle_jsp_text[29]);
            {
              org.apache.struts2.views.jsp.ui.TextFieldTag __jsp_taghandler_23=(org.apache.struts2.views.jsp.ui.TextFieldTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.TextFieldTag.class,"org.apache.struts2.views.jsp.ui.TextFieldTag label name size value");
              __jsp_taghandler_23.setParent(__jsp_taghandler_12);
              __jsp_taghandler_23.setLabel("%{getText('label.parametro.codParametro')}");
              __jsp_taghandler_23.setName("parametro.codParametro");
              __jsp_taghandler_23.setSize("40");
              __jsp_taghandler_23.setValue("%{parametro.codParametro}");
              __jsp_tag_starteval=__jsp_taghandler_23.doStartTag();
              if (__jsp_taghandler_23.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_23,2);
            }
            out.write(__oracle_jsp_text[30]);
            {
              org.apache.struts2.views.jsp.ui.TextFieldTag __jsp_taghandler_24=(org.apache.struts2.views.jsp.ui.TextFieldTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.TextFieldTag.class,"org.apache.struts2.views.jsp.ui.TextFieldTag label name size value");
              __jsp_taghandler_24.setParent(__jsp_taghandler_12);
              __jsp_taghandler_24.setLabel("%{getText('label.parametro.txtValor')}");
              __jsp_taghandler_24.setName("parametro.txtValor");
              __jsp_taghandler_24.setSize("40");
              __jsp_taghandler_24.setValue("%{parametro.txtValor}");
              __jsp_tag_starteval=__jsp_taghandler_24.doStartTag();
              if (__jsp_taghandler_24.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_24,2);
            }
            out.write(__oracle_jsp_text[31]);
            {
              org.apache.struts2.views.jsp.ui.SubmitTag __jsp_taghandler_25=(org.apache.struts2.views.jsp.ui.SubmitTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.SubmitTag.class,"org.apache.struts2.views.jsp.ui.SubmitTag value");
              __jsp_taghandler_25.setParent(__jsp_taghandler_12);
              __jsp_taghandler_25.setValue("%{getText('button.label.submit')}");
              __jsp_tag_starteval=__jsp_taghandler_25.doStartTag();
              if (__jsp_taghandler_25.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_25,2);
            }
            out.write(__oracle_jsp_text[32]);
            {
              org.apache.struts2.views.jsp.ui.SubmitTag __jsp_taghandler_26=(org.apache.struts2.views.jsp.ui.SubmitTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.struts2.views.jsp.ui.SubmitTag.class,"org.apache.struts2.views.jsp.ui.SubmitTag name value");
              __jsp_taghandler_26.setParent(__jsp_taghandler_12);
              __jsp_taghandler_26.setName("redirect-action:index");
              __jsp_taghandler_26.setValue("%{getText('button.label.cancel')}");
              __jsp_tag_starteval=__jsp_taghandler_26.doStartTag();
              if (__jsp_taghandler_26.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_26,2);
            }
            out.write(__oracle_jsp_text[33]);
          } while (__jsp_taghandler_12.doAfterBody()==javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
          out=OracleJspRuntime.popBodyIfNeeded(pageContext,out);
        }
        if (__jsp_taghandler_12.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
          return;
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_12,1);
      }
      out.write(__oracle_jsp_text[34]);

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
  private static final char __oracle_jsp_text[][]=new char[35][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n".toCharArray();
    __oracle_jsp_text[2] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[3] = 
    "\n".toCharArray();
    __oracle_jsp_text[4] = 
    "\n".toCharArray();
    __oracle_jsp_text[5] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[6] = 
    "\n".toCharArray();
    __oracle_jsp_text[7] = 
    "\n<html>\n<head>\n    <link href=\"".toCharArray();
    __oracle_jsp_text[8] = 
    "\" rel=\"stylesheet\" type=\"text/css\"/>\n    <LINK HREF=\"styles/displaytagsca.css\" REL=\"stylesheet\" TYPE=\"text/css\">\n    <title>".toCharArray();
    __oracle_jsp_text[9] = 
    "</title>\n</head>\n<body>\n<!--div class=\"titleDiv\">".toCharArray();
    __oracle_jsp_text[10] = 
    "</div-->\n <h1>".toCharArray();
    __oracle_jsp_text[11] = 
    "</h1>\n<h1>".toCharArray();
    __oracle_jsp_text[12] = 
    "</h1>\n\n".toCharArray();
    __oracle_jsp_text[13] = 
    "\n".toCharArray();
    __oracle_jsp_text[14] = 
    "\n".toCharArray();
    __oracle_jsp_text[15] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[16] = 
    "\n        ".toCharArray();
    __oracle_jsp_text[17] = 
    "    \n    ".toCharArray();
    __oracle_jsp_text[18] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[19] = 
    "\n        ".toCharArray();
    __oracle_jsp_text[20] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[21] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[22] = 
    "\n        ".toCharArray();
    __oracle_jsp_text[23] = 
    "\n        ".toCharArray();
    __oracle_jsp_text[24] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[25] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[26] = 
    "\n        ".toCharArray();
    __oracle_jsp_text[27] = 
    "\n        ".toCharArray();
    __oracle_jsp_text[28] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[29] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[30] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[31] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[32] = 
    "\n    ".toCharArray();
    __oracle_jsp_text[33] = 
    "\n".toCharArray();
    __oracle_jsp_text[34] = 
    "\n</body>\n</html>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

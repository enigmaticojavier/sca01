package _pages._tiles;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _mainTiles extends com.orionserver.http.OrionHttpJspPage {


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
    _mainTiles page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      {
        org.apache.tiles.jsp.taglib.GetAsStringTag __jsp_taghandler_1=(org.apache.tiles.jsp.taglib.GetAsStringTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.tiles.jsp.taglib.GetAsStringTag.class,"org.apache.tiles.jsp.taglib.GetAsStringTag name");
        __jsp_taghandler_1.setParent(null);
        __jsp_taghandler_1.setName("title");
        try {
          __jsp_tag_starteval=__jsp_taghandler_1.doStartTag();
          if (__jsp_taghandler_1.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
        } catch (Throwable th) {
          __jsp_taghandler_1.doCatch(th);
        } finally {
          __jsp_taghandler_1.doFinally();
        }
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_1,1);
      }
      out.write(__oracle_jsp_text[2]);
      {
        org.apache.tiles.jsp.taglib.InsertAttributeTag __jsp_taghandler_2=(org.apache.tiles.jsp.taglib.InsertAttributeTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.tiles.jsp.taglib.InsertAttributeTag.class,"org.apache.tiles.jsp.taglib.InsertAttributeTag name");
        __jsp_taghandler_2.setParent(null);
        __jsp_taghandler_2.setName("header");
        try {
          __jsp_tag_starteval=__jsp_taghandler_2.doStartTag();
          if (__jsp_taghandler_2.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
        } catch (Throwable th) {
          __jsp_taghandler_2.doCatch(th);
        } finally {
          __jsp_taghandler_2.doFinally();
        }
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_2,1);
      }
      out.write(__oracle_jsp_text[3]);
      {
        org.apache.tiles.jsp.taglib.InsertAttributeTag __jsp_taghandler_3=(org.apache.tiles.jsp.taglib.InsertAttributeTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.tiles.jsp.taglib.InsertAttributeTag.class,"org.apache.tiles.jsp.taglib.InsertAttributeTag name");
        __jsp_taghandler_3.setParent(null);
        __jsp_taghandler_3.setName("menu");
        try {
          __jsp_tag_starteval=__jsp_taghandler_3.doStartTag();
          if (__jsp_taghandler_3.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
        } catch (Throwable th) {
          __jsp_taghandler_3.doCatch(th);
        } finally {
          __jsp_taghandler_3.doFinally();
        }
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_3,1);
      }
      out.write(__oracle_jsp_text[4]);
      {
        org.apache.tiles.jsp.taglib.InsertAttributeTag __jsp_taghandler_4=(org.apache.tiles.jsp.taglib.InsertAttributeTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.tiles.jsp.taglib.InsertAttributeTag.class,"org.apache.tiles.jsp.taglib.InsertAttributeTag name");
        __jsp_taghandler_4.setParent(null);
        __jsp_taghandler_4.setName("body");
        try {
          __jsp_tag_starteval=__jsp_taghandler_4.doStartTag();
          if (__jsp_taghandler_4.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
        } catch (Throwable th) {
          __jsp_taghandler_4.doCatch(th);
        } finally {
          __jsp_taghandler_4.doFinally();
        }
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_4,1);
      }
      out.write(__oracle_jsp_text[5]);
      {
        org.apache.tiles.jsp.taglib.InsertAttributeTag __jsp_taghandler_5=(org.apache.tiles.jsp.taglib.InsertAttributeTag)OracleJspRuntime.getTagHandler(pageContext,org.apache.tiles.jsp.taglib.InsertAttributeTag.class,"org.apache.tiles.jsp.taglib.InsertAttributeTag name");
        __jsp_taghandler_5.setParent(null);
        __jsp_taghandler_5.setName("footer");
        try {
          __jsp_tag_starteval=__jsp_taghandler_5.doStartTag();
          if (__jsp_taghandler_5.doEndTag()==javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
        } catch (Throwable th) {
          __jsp_taghandler_5.doCatch(th);
        } finally {
          __jsp_taghandler_5.doFinally();
        }
        OracleJspRuntime.releaseTagHandler(pageContext,__jsp_taghandler_5,1);
      }
      out.write(__oracle_jsp_text[6]);

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
  private static final char __oracle_jsp_text[][]=new char[7][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<html>\n  <head>\n    <title>".toCharArray();
    __oracle_jsp_text[2] = 
    "</title>\n  </head>\n  <body>\n        <table>\n      <tr>\n        <td colspan=\"2\">\n          ".toCharArray();
    __oracle_jsp_text[3] = 
    "\n        </td>\n      </tr>\n      <tr>\n        <td>\n          ".toCharArray();
    __oracle_jsp_text[4] = 
    "\n        </td>\n        <td>\n          ".toCharArray();
    __oracle_jsp_text[5] = 
    "\n        </td>\n      </tr>\n      <tr>\n        <td colspan=\"2\">\n          ".toCharArray();
    __oracle_jsp_text[6] = 
    "\n        </td>\n      </tr>\n    </table>\n  </body>\n</html>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

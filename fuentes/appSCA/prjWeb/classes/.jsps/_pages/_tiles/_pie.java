package _pages._tiles;

import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _pie extends com.orionserver.http.OrionHttpJspPage {


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
    _pie page = this;
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
    "<table summary=\"Footer Table for Terms links and Top of page link\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n      <tr>\n        <td width=\"239\" align=\"center\" valign=\"middle\" bgcolor=\"#7DBB3B\">&nbsp;</td>\n        <td width=\"577\" align=\"center\" valign=\"middle\" bgcolor=\"#7DBB3B\"><a href=\"http://www.minam.gob.pe\" class=\"pie\">MINISTERIO DEL AMBIENTE</a><br />\n          <span class=\"style1\">Email: <a href=\"mailto:sinia@minam.gob.pe\" class=\"pie\">sinia@minam.gob.pe</a>,<br />\n          Tel�fono:(511) 2255370 / Fax:(511) 2255369<br />\n          Av. Guardia Civil N� 205 - San Borja<br />\n          Lima Per�</span>\n        </td>\n        <td width=\"184\" align=\"center\" valign=\"middle\" bgcolor=\"#7DBB3B\">&nbsp;</td>\n      </tr>\n</table>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}

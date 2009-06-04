package gob.pe.minam.sca.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.io.File;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;


public class AuthenticationInterceptor implements Interceptor {
 
  static Logger log = Logger.getLogger("AuthenticationInterceptor.class");
    
  public void destroy() {
  }
 
  public void init() {
  }
 
  /*
  public String intercept(ActionInvocation actionInvocation) throws Exception {
    Map session = actionInvocation.getInvocationContext().getSession();
    if (session.get("usuario") != null) {
      return Action.LOGIN;
    } else {
      return actionInvocation.invoke();
    }
  }
  */
  
   public String intercept(ActionInvocation invocation) throws Exception { 
        log.info("[AuthenticationInterceptor.intercept][Ini]");
        HttpServletRequest request = ServletActionContext.getRequest();
        ServletContext sc = ServletActionContext.getServletContext();
        Enumeration e = request.getParameterNames();
        while(e.hasMoreElements())
        {
           String s_clave = e.nextElement().toString();
           String s_aux = request.getParameter(s_clave);
           System.out.println("<br>El parámetro:<B>" + s_clave + "</B>value<B>" + s_aux + "</B>");
        }
        StringBuffer returnUrl = new StringBuffer(request.getRequestURL());
        System.out.println("---->"+returnUrl.toString());
        String result = returnUrl.toString().trim();
        System.out.println("<----"+result);
        //request.setCookies(new Cookie[] {
        StringBuffer returnUrlResult = new StringBuffer(result);
        invocation.getStack().set("returnURL", returnUrlResult);    
        log.info("[AuthenticationInterceptor.intercept][Fin]");
        return invocation.invoke();  
   } 
    
    
    
   
}
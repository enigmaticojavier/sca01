/***********************************************************************
 * Module:  FiltroDescarga.java
 * Author:  Danny Espíritu
 * Purpose: FiltroDescarga
 ***********************************************************************/
package gob.mimdes.sime.filtro;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


public class FiltroDescarga implements Filter{
  
    static Logger log = Logger.getLogger("FiltroDescarga.class");
    private ServletConfig config;
    private ServletContext sc;

    public void doFilter(ServletRequest req, ServletResponse res,   
            FilterChain chain) throws IOException, ServletException {   
  
        try{
            log.info("[FiltroDescarga.doFilter][Ini]");
            HttpServletRequest request = (HttpServletRequest) req;   
            HttpServletResponse response = (HttpServletResponse) res; 
            final ServletOutputStream out = response.getOutputStream(); 
            File file = new File(request.getParameter("file"));
            BufferedInputStream is = new BufferedInputStream(new FileInputStream(file));
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition","attachment;filename="+file.getName());
            byte[] buf = new byte[4 * 1024]; // 4K buffer
            int bytesRead;
            while ((bytesRead = is.read(buf)) != -1) {
            out.write(buf, 0, bytesRead);
            }
            is.close();
            out.close(); 
            response.sendRedirect(request.getContextPath() + "/pages/upload/tmp.jsp");
            log.info("[FiltroDescarga.doFilter][Fin]");
        }catch(Exception ex){
            System.out.println("ex " + ex);  
            ex.printStackTrace();
        }  
    }   
    public void init(FilterConfig config) throws ServletException {   
        log.info("[FiltroDescarga.init][Ini]");
        String parametroFiltro = config.getInitParameter("parametroFiltroDescarga");   
        log.info("[FiltroDescarga.init][Ini]");
    }   
    public void destroy() {   
        //add code to release any resource   
    }

    public void setConfig(ServletConfig config) {
        this.config = config;
    }

    public ServletConfig getConfig() {
        return config;
    }

    public void setSc(ServletContext sc) {
        this.sc = sc;
    }

    public ServletContext getSc() {
        return sc;
    }
}

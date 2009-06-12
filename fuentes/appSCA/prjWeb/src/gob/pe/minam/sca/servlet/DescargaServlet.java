package gob.pe.minam.sca.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class DescargaServlet extends HttpServlet
{
    static Logger log = Logger.getLogger("DescargaServlet.class");
    private ServletConfig config;
    private ServletContext sc;
    
    public void init (ServletConfig config) throws ServletException
    {
              this.config = config;
              // El objeto de configuración proporciona parámetros de inicialización al servlet
    }
    public void destroy() { }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        servicio(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        servicio(request, response);
    }

    public void servicio(HttpServletRequest request, ServletResponse response) throws ServletException, IOException
    {
      try{
          log.info("[DescargaServlet.servicio][Ini]");
          log.info("[DescargaServlet.servicio][Fin]");
      }catch(Exception ex){
          System.out.println("ex " + ex);  
      }   
    }

    public String getServletInfo(){
        return "";
    } 
    
    public ServletConfig getServletConfig (){
        return config;
    } 

} // Fin de la clase
package gob.pe.minam.sca.servlet;

import gob.pe.minam.sca.ds.ProyectoResumenDS;

import gob.pe.minam.sca.pojo.Proyecto;
import gob.pe.minam.sca.vo.ProyectoReporteVo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.sql.Connection;

import java.sql.DriverManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperManager;
import net.sf.jasperreports.engine.JasperPrint;

import net.sf.jasperreports.engine.export.JRPdfExporter;

import net.sf.jasperreports.engine.export.JRPdfExporterParameter;

public class ReportServlet extends HttpServlet {
    private static final String CONTENT_TYPE_PDF = "application/pdf";
    private ServletConfig servletConfig=null;


    public void init() throws ServletException {
    }
    
    public final void init(ServletConfig servletConfig) throws ServletException
    {
        super.init(servletConfig);
        this.servletConfig = servletConfig;
    }

    //Process the HTTP Get request
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        runReport(request, response);
    }

    //Process the HTTP Post request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        runReport(request, response);
    }

    public void runReport(HttpServletRequest request, HttpServletResponse response) {
        //String rutaRpteProyectoResumen = "/reportes/rpProyectoResumen1.jasper";
        String rutaRpteProyectoResumen = "/reportes/reportnada2.jasper";
        //String rutaSubRpteProyectoResumenFiltro =  "/reportes/rpProyectoResumenDetalle1.jasper";
        String rutaSubRpteProyectoResumenFiltro =  "/reportes/subreportnada1.jasper";
         
        java.sql.Connection conn = null;
        InputStream reportStream = null;
        OutputStream outstream = null;
        byte[] buffer = null;
        int BUF_SIZE = 512;
        try {
            String clsTipificacion = request.getParameter("clsTipificacion");
            String estadoTramite = request.getParameter("estadoTramite");
            String tipoPersoneria = request.getParameter("tipoPersoneria");
            String proponente = request.getParameter("proponente");
            String tipoAcae = request.getParameter("tipoAcae");
            String clsSector = request.getParameter("clsSector");
            String clsSubSector = request.getParameter("clsSubSector");
            String codDepartamento = request.getParameter("codDepartamento");
            String codProvincia = request.getParameter("codProvincia");
            String codDistrito = request.getParameter("codDistrito");
            String tipoDoc = request.getParameter("tipoDoc");
            String ano = request.getParameter("anoPeriodo");
            
            System.out.println("--------------------------------------------------------------->");
            System.out.println("ReportServlet.clsTipificacion-->"+clsTipificacion);
            System.out.println("ReportServlet.estadoTramite-->"+estadoTramite);
            System.out.println("ReportServlet.tipoPersoneria-->"+tipoPersoneria);
            System.out.println("ReportServlet.proponente-->"+proponente);
            System.out.println("ReportServlet.tipoAcae-->"+tipoAcae);
            System.out.println("ReportServlet.clsSector-->"+clsSector);
            System.out.println("ReportServlet.clsSubSector-->"+clsSubSector);
            System.out.println("ReportServlet.codDepartamento-->"+codDepartamento);
            System.out.println("ReportServlet.codProvincia-->"+codProvincia);
            System.out.println("ReportServlet.codDistrito-->"+codDistrito);
            System.out.println("ReportServlet.tipoDoc-->"+tipoDoc);
            System.out.println("ReportServlet.anoPeriodo-->"+ano);
            System.out.println("--------------------------------------------------------------->");
            
            ano=ano.equals("TODOS") ? "0" : ano;
            List lstProyectoResumen = Proyecto.buscarRankingReporte(clsTipificacion,
                                                                    estadoTramite, 
                                                                    tipoPersoneria, 
                                                                    proponente, tipoAcae, 
                                                                    clsSector, clsSubSector, 
                                                                    codDepartamento, 
                                                                    codProvincia, codDistrito, 
                                                                    ano, tipoDoc);
            
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:BDRIMAC";
            conn = DriverManager.getConnection(url,"sca", "sca");
            ProyectoReporteVo proyectoReporteVo = new ProyectoReporteVo();
            proyectoReporteVo.setClsTipificacion((clsTipificacion==null || clsTipificacion.equals("0"))?null:clsTipificacion);
            proyectoReporteVo.setEstadoTramite((estadoTramite==null || estadoTramite.equals("0"))?null:estadoTramite);
            proyectoReporteVo.setTipoPersoneria((tipoPersoneria==null || tipoPersoneria.equals("0"))?null:tipoPersoneria);
            proyectoReporteVo.setProponente((proponente==null || proponente.equals("0"))?null:proponente);
            proyectoReporteVo.setTipoAcae((tipoAcae==null || tipoAcae.equals("0"))?null:tipoAcae);
            proyectoReporteVo.setClsSector((clsSector==null || clsSector.equals("0"))?null:clsSector);
            proyectoReporteVo.setClsSubSector((clsSubSector==null || clsSubSector.equals("0"))?null:clsSubSector);
            proyectoReporteVo.setCodDepartamento((codDepartamento==null || codDepartamento.equals("0"))?null:codDepartamento);
            proyectoReporteVo.setCodProvincia((codProvincia==null || codProvincia.equals("0"))?null:codProvincia);
            proyectoReporteVo.setCodDistrito((codDistrito==null || codDistrito.equals("0"))?null:codDistrito);
            proyectoReporteVo.setTipoDoc((tipoDoc==null || tipoDoc.equals("0"))?null:tipoDoc);
            proyectoReporteVo.setAnoPeriodo(ano==null||ano.equals("0")?null:ano);
            
            System.out.println("seteando fuente lstProyectoResumen-->"+lstProyectoResumen);
            proyectoReporteVo.setLstResumen(lstProyectoResumen);
            reportStream = this.servletConfig.getServletContext().getResourceAsStream(rutaRpteProyectoResumen);
            List lstDatosReporte = new ArrayList();
            lstDatosReporte.add(proyectoReporteVo);
            ProyectoResumenDS proyectoResumenDS = new ProyectoResumenDS(lstDatosReporte);
            Map parametros = new HashMap();
            parametros.put("rutaSubRpteProyectoResumenFiltro",rutaSubRpteProyectoResumenFiltro);
            System.out.println("-------------------------->lstProyectoResumen.size"+lstProyectoResumen.size());
            //JasperPrint print = JasperFillManager.fillReport(reportStream, parametros, proyectoResumenDS); 
            /*
            System.setProperty( "jasper.reports.compile.class.path", 
                                 request.getRealPath("/WEB-INF/lib/jasperreports-3.0.0.jar") + 
                                 System.getProperty("path.separator") + 
                                 request.getRealPath("/WEB-INF/classes/") 
                                 );
            */
            System.out.println("***************Estableciendo carpeta a compilar **************");
            //System.setProperty( "jasper.reports.compile.temp", request.getRealPath("/reportes/") ); 
            
            System.out.println("***************XXXX **************");
            JasperPrint print = JasperFillManager.fillReport(reportStream, parametros, proyectoResumenDS);   
            System.out.println("***************XXXX1 **************");
            outstream = response.getOutputStream(); 
            JasperManager.printReportToPdfStream(print, outstream);
            response.addHeader("Cache-Control", "No-cache; No-store; Must-revalidate; Proxy-revalidate");
            System.out.println("***************XXXX2 **************");
            response.addDateHeader( "Expires", 1L); 
            response.addHeader("Pragma", "No-cache");
            response.setContentType(CONTENT_TYPE_PDF);
            JRPdfExporter exporterPDF = new JRPdfExporter(); 
            exporterPDF.setParameter(JRPdfExporterParameter.JASPER_PRINT, print); 
            exporterPDF.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, outstream); 
            exporterPDF.exportReport();
            outstream.flush();
        } catch(Throwable e) {
            e.printStackTrace();
        }finally{
            try{
                if(conn != null){
                    conn.close();
                }
            } catch (Throwable ex2) {
                System.out.println("*************MENSAJE ERROR = " + ex2.getMessage());
                System.out.println("*************CAUSA ERROR = " + ex2.getMessage());
            }
        
        }
    }

    public void destroy() {
    
    }
}
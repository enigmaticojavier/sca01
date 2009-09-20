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
        String rutaRpteProyectoResumen = "/reportes/rpProyectoResumen.jasper";
        String rutaSubRpteProyectoResumenFiltro =  "/reportes/rpProyectoResumenDetalle.jasper";
        //String rutaSubRpteProyectoResumenFiltro =  "/reportes/subreportnada1.jasper";
         
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
            String ano = request.getParameter("anoPeriodo");
            String tipoDoc = request.getParameter("tipoDoc");
            
            String txtClsTipificacion = request.getParameter("txtClsTipificacion");
            String txtEstadoTramite = request.getParameter("txtEstadoTramite");
            String txtTipoPersoneria = request.getParameter("txtTipoPersoneria");
            String txtProponente = request.getParameter("txtProponente");
            String txtTipoAcae = request.getParameter("txtTipoAcae");
            String txtClsSector = request.getParameter("txtClsSector");
            String txtClsSubSector = request.getParameter("txtClsSubSector");
            String txtCodDepartamento = request.getParameter("txtCodDepartamento");
            String txtCodProvincia = request.getParameter("txtCodProvincia");
            String txtCodDistrito = request.getParameter("txtCodDistrito");
            String txtAnoPeriodo = request.getParameter("txtAnoPeriodo");
            String txtTipoDoc = request.getParameter("txtTipoDoc");
            
            
            //txtClsTipificacion="+txtClsTipificacion+"&txtEstadoTramite="+txtEstadoTramite+"&txtProponente="+txtProponente+"&txtTipoAcae="+txtTipoAcae+"&txtClsSector="+txtClsSector+"&txtClsSubSector="+txtClsSubSector+"&txtCodDepartamento="+txtCodDepartamento+"&txtCodProvincia="+txtCodProvincia+"&txtCodDistrito="+txtCodDistrito+"&txtAnoPeriodo="+txtAnoPeriodo+"&txtTipoDoc
            
            
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
            
            
            ProyectoReporteVo proyectoReporteVo = new ProyectoReporteVo();
            proyectoReporteVo.setClsTipificacion((clsTipificacion==null || clsTipificacion.equals("0"))?null:txtClsTipificacion);
            proyectoReporteVo.setEstadoTramite((estadoTramite==null || estadoTramite.equals("0"))?null:txtEstadoTramite);
            proyectoReporteVo.setTipoPersoneria((tipoPersoneria==null || tipoPersoneria.equals("0"))?null:txtTipoPersoneria);
            proyectoReporteVo.setProponente((proponente==null || proponente.equals("0"))?null:txtProponente);
            proyectoReporteVo.setTipoAcae((tipoAcae==null || tipoAcae.equals("0"))?null:txtTipoAcae);
            proyectoReporteVo.setClsSector((clsSector==null || clsSector.equals("0"))?null:txtClsSector);
            proyectoReporteVo.setClsSubSector((clsSubSector==null || clsSubSector.equals("0"))?null:txtClsSubSector);
            proyectoReporteVo.setCodDepartamento((codDepartamento==null || codDepartamento.equals("0"))?null:txtCodDepartamento);
            proyectoReporteVo.setCodProvincia((codProvincia==null || codProvincia.equals("0"))?null:txtCodProvincia);
            proyectoReporteVo.setCodDistrito((codDistrito==null || codDistrito.equals("0"))?null:txtCodDistrito);
            proyectoReporteVo.setTipoDoc((tipoDoc==null || tipoDoc.equals("0"))?null:txtTipoDoc);
            proyectoReporteVo.setAnoPeriodo(ano==null||ano.equals("0")?null:txtAnoPeriodo);
            
            proyectoReporteVo.setLstResumen(lstProyectoResumen);
            reportStream = this.servletConfig.getServletContext().getResourceAsStream(rutaRpteProyectoResumen);
            List lstDatosReporte = new ArrayList();
            lstDatosReporte.add(proyectoReporteVo);
            ProyectoResumenDS proyectoResumenDS = new ProyectoResumenDS(lstDatosReporte);
            Map parametros = new HashMap();
            parametros.put("rutaSubRpteProyectoResumenFiltro",rutaSubRpteProyectoResumenFiltro);
            JasperPrint print = JasperFillManager.fillReport(reportStream, parametros, proyectoResumenDS);   
            outstream = response.getOutputStream(); 
            JasperManager.printReportToPdfStream(print, outstream);
            response.addHeader("Cache-Control", "No-cache; No-store; Must-revalidate; Proxy-revalidate");
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
        }
    }

    public void destroy() {
    
    }
}
package gob.pe.minam.sca.action;

import com.opensymphony.xwork2.Preparable;

import gob.pe.minam.sca.framework.AccionSoporte;
import gob.pe.minam.sca.framework.ConstantesSistema;
import gob.pe.minam.sca.pojo.ControlEnvio;
import gob.pe.minam.sca.pojo.Expediente;
import gob.pe.minam.sca.pojo.ExpedienteDocumento;
import gob.pe.minam.sca.pojo.Parametro;
import gob.pe.minam.sca.pojo.Periodo;
import gob.pe.minam.sca.util.ExcelGenerador;
import gob.pe.minam.sca.util.Utilitarios;
import gob.pe.minam.sca.util.bean.BeanRetorno;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;


public class AdjuntoAction extends AccionSoporte implements Preparable {
    
    static Logger log = Logger.getLogger("AdjuntoAction.class");
    private String periodoSeleccionado;
    private ControlEnvio controlEnvio;
    private List expedienteDocumento;
    private List parPeriodos;
    
    // Adjunto
    private File archAdjunto;//The actual file
    private String archAdjuntoContentType; //The content type of the file
    private String archAdjuntoFileName; //The uploaded file name
    
    public void prepare() throws Exception {
        try{
            log.info("[AdjuntoAction.prepare][Ini]");
            /*Tipo de Acae*/
            Parametro par = new Parametro();
            /*Periodo*/
            Periodo per = new Periodo();
            this.parPeriodos=per.listarPeriodoReporte();
            this.parPeriodos=this.parPeriodos==null?new ArrayList():this.parPeriodos;
            if (this.periodoSeleccionado==null){
                if (this.parPeriodos.size()>0)
                    this.periodoSeleccionado = ((Periodo)this.parPeriodos.get(0)).getPeriodo();
                else
                    this.periodoSeleccionado = "";
                log.info("Periodo " + this.periodoSeleccionado);
            }
            log.info("[AdjuntoAction.prepare][Fin]");
        }catch(Exception ex){
            ex.printStackTrace();
        }  
    }
    
    public String list(){
      try{
        log.info("[AdjuntoAction.list][Ini]");
        Expediente exp = new Expediente();
        String tmpPeriodo=this.periodoSeleccionado.substring(0,4) + this.periodoSeleccionado.substring(5,7);
        log.info("tmpPeriodo"+tmpPeriodo);
        ExpedienteDocumento expdoc = new ExpedienteDocumento();
        int personaId=3;
        this.expedienteDocumento=expdoc.buscarExpDocXPry(tmpPeriodo,personaId);
        setearEstado(this.controlEnvio);
        log.info("[AdjuntoAction.list][Fin]");
        return SUCCESS;
      }catch(Exception ex){
        ex.printStackTrace();
      }  
      return SUCCESS;
    }
    
    private void setearEstado(ControlEnvio controlEnvio){
        
    }
    
    public String cargaArchivoAdjunto(){
        try {
            log.info("[AdjuntoAction.cargaArchivoProponente][Ini]");
            this.periodoSeleccionado=getParameterValue("periodoSeleccionado");
            String tmpPeriodo=this.periodoSeleccionado.substring(0,4) + this.periodoSeleccionado.substring(5,7);
            log.info("PeriodoSeleccionado-->"+this.periodoSeleccionado+"tmpPeriodo-->"+tmpPeriodo);
            boolean copiado=false;
            BeanRetorno beanRetLectExcel=null;
            ControlEnvio cntrEnvio=new ControlEnvio();
            this.controlEnvio=cntrEnvio.obtenerControlEnvioXPeriodo(tmpPeriodo);
            log.info(this.controlEnvio==null?"this.controlEnvio Read":"this.controlEnvio Read"+this.controlEnvio.getPeriodo());
            int personaId=3;
            String carpeta = "";
            Parametro par=new Parametro();
            List l = par.buscarParametroXTipoParametro(ConstantesSistema.CARPETA_TEMPORAL);
            if (l!=null && l.size()>0){
                carpeta = ((Parametro)l.get(0)).getTxtValor();
                if (this.archAdjunto!=null){
                    String extension=Utilitarios.obtenerExtensionArchivo(archAdjuntoFileName);
                    String nombreArchivo = carpeta + "\\" + archAdjuntoFileName;
                    log.info("nombreArchivo-->"+nombreArchivo);
                    File theFile = new File(nombreArchivo);
                    try{
                        copiado=false;
                        FileUtils.copyFile(archAdjunto, theFile);
                        copiado=true;
                    }catch(FileNotFoundException e){
                        e.printStackTrace();
                        this.setearMensajeError("1","Archivo No existe");
                    }    
                    // Procesar Archivo
                    if (copiado){
                        try{
                           ExcelGenerador xls = new ExcelGenerador();
                           beanRetLectExcel = xls.leerArchivo(personaId,9,false,nombreArchivo);
                        }catch(Exception e){
                            e.printStackTrace();
                            this.setearMensajeError("1","Error en la lectura del Archivo");
                        }
                        if (beanRetLectExcel.getCodError()==ConstantesSistema.CONST_RETORNO_EXITO){
                            if (controlEnvio==null){
                                log.info("INSERT CONTROL ENVIO");
                                controlEnvio=new ControlEnvio();
                                controlEnvio.setPersonaId(3);
                                controlEnvio.setPeriodo(tmpPeriodo);
                                controlEnvio.setEstEnvioPro(ConstantesSistema.ENVIO_ENVIADO_OK);
                                controlEnvio.setFchEnvioPro(new Date());
                            }else{
                                log.info("update CONTROL ENVIO");
                                controlEnvio.setEstEnvioPro(ConstantesSistema.ENVIO_ENVIADO_OK);
                                controlEnvio.setFchEnvioPro(new Date());
                            }
                            log.info("this.controlEnvioSENT-->"+this.controlEnvio.getPeriodo());
                            cntrEnvio.guardarControlEnvio(controlEnvio);
                        }else{
                            this.setearMensajeError("1","Error en la lectura del Archivo " + beanRetLectExcel.getDscError());
                            log.error("Error en la lectura del Archivo " + beanRetLectExcel.getDscError());
                        }
                    }
                }else{
                    log.info("Archivo Proponente Nulo");
                    this.setearMensajeError("1","Archivo no Existe");
                    log.error("Archivo no Existe");
                }
            }else{
                this.setearMensajeError("1","Carpeta Temporal no configurada");
                log.error("Carpeta Temporal no configurada");
            }
            setearEstado(this.controlEnvio);
            log.info("[AdjuntoAction.cargaArchivoProponente][Fin]");
       } catch (Exception e) {
           e.printStackTrace();
           log.error("Error en la carga del Archivo");
           this.setearMensajeError("1","Error en la carga del Archivo");
           return SUCCESS;
       }
       return SUCCESS;
    }

    public void setPeriodoSeleccionado(String periodoSeleccionado) {
        this.periodoSeleccionado = periodoSeleccionado;
    }

    public String getPeriodoSeleccionado() {
        return periodoSeleccionado;
    }

    public void setControlEnvio(ControlEnvio controlEnvio) {
        this.controlEnvio = controlEnvio;
    }

    public ControlEnvio getControlEnvio() {
        return controlEnvio;
    }

    public void setExpedienteDocumento(List expedienteDocumento) {
        this.expedienteDocumento = expedienteDocumento;
    }

    public List getExpedienteDocumento() {
        return expedienteDocumento;
    }

    public void setParPeriodos(List parPeriodos) {
        this.parPeriodos = parPeriodos;
    }

    public List getParPeriodos() {
        return parPeriodos;
    }

    public void setArchAdjunto(File archAdjunto) {
        this.archAdjunto = archAdjunto;
    }

    public File getArchAdjunto() {
        return archAdjunto;
    }

    public void setArchAdjuntoContentType(String archAdjuntoContentType) {
        this.archAdjuntoContentType = archAdjuntoContentType;
    }

    public String getArchAdjuntoContentType() {
        return archAdjuntoContentType;
    }

    public void setArchAdjuntoFileName(String archAdjuntoFileName) {
        this.archAdjuntoFileName = archAdjuntoFileName;
    }

    public String getArchAdjuntoFileName() {
        return archAdjuntoFileName;
    }
}


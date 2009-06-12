package gob.pe.minam.sca.action;

import java.util.Date;
import java.io.File;
import com.opensymphony.xwork2.ActionSupport;

import gob.pe.minam.sca.framework.AccionSoporte;

import gob.pe.minam.sca.framework.ConstantesSistema;
import gob.pe.minam.sca.pojo.ControlEnvio;
import gob.pe.minam.sca.pojo.Parametro;
import gob.pe.minam.sca.pojo.Periodo;
import gob.pe.minam.sca.util.Utilitarios;

import java.io.FileNotFoundException;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class ArchivoAction extends AccionSoporte{ 
  
    static Logger log = Logger.getLogger("ArchivoAction.class");
   
    // Proponente
    private File archProponente;//The actual file
    private String archProponenteContentType; //The content type of the file
    private String archProponenteFileName; //The uploaded file name
    // Proyecto
    private File archProyecto;//The actual file
    private String archProyectoContentType; //The content type of the file
    private String archProyectoFileName; //The uploaded file name
    // Expediente
    private File archExpediente;//The actual file
    private String archExpedienteContentType; //The content type of the file
    private String archExpedienteFileName; //The uploaded file name
    
    private String periodo;
    private List periodos;
    
    private String estadoCarga;
    private String estadoCargaProponente;
    private String estadoCargaProyecto;
    private String estadoCargaExpediente;
    
    public String cargaArchivo(){
        try {
            log.info("[ArchivoAction.cargaArchivo][Ini]");
            Periodo periodo = new Periodo();
            this.periodos=periodo.listarPeriodoReporte();
            if (this.periodos!=null && this.periodos.size()>0){
                this.periodo=((Periodo)this.periodos.get(0)).getPeriodo();
                log.info("Periodo-->"+periodo);
            }
            actualizarFlujoEnvio();
            log.info("[ArchivoAction.cargaArchivo][Fin]");
        } catch (Exception e) {
            e.printStackTrace();
            this.setearMensajeError("1",e.getMessage());
            return INPUT;
        }
        return INPUT;
    }
    
    public String cargaArchivoProponente(){
        try {
            log.info("[ArchivoAction.cargaArchivoProponente][Ini]");
            log.info("Periodo-->"+periodo);
            String carpeta = "";
            Parametro par=new Parametro();
            List l = par.buscarParametroXTipoParametro(ConstantesSistema.CARPETA_TEMPORAL);
            if (l!=null && l.size()>0){
                carpeta = (String)l.get(0);
                if (archProponente!=null){
                    String extension=Utilitarios.obtenerExtensionArchivo(archProponenteFileName);
                    String nombreArchivo = carpeta+archProponenteFileName;
                    log.info("nombreArchivo-->"+nombreArchivo);
                    File theFile = new File(nombreArchivo);
                    FileUtils.copyFile(archProponente, theFile);
                    // Procesar Archivo
                    try{
                            
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    actualizarFlujoEnvio();
                }else{
                    log.info("Proponente Nulo");
                }
            }else{
                this.setearMensajeError("1","Carpeta Temporal no configurada");
                log.error("Carpeta Temporal no configurada");
            }
           actualizarFlujoEnvio();
           log.info("[ArchivoAction.cargaArchivoProponente][Fin]");
       } catch (FileNotFoundException e) {
           e.printStackTrace();
           this.setearMensajeError("1","Archivo No existe");
           return INPUT;
       } catch (Exception e) {
           e.printStackTrace();
           this.setearMensajeError("1",e.getMessage());
           return INPUT;
       }
       return SUCCESS;
    }
    
    public String cargaArchivoProyecto(){
        try {
            log.info("[ArchivoAction.cargaArchivoProyecto][Ini]");
            String nombre = "";
            if (archProyecto!=null){
                String extension=Utilitarios.obtenerExtensionArchivo(archProyectoFileName);
                String fullFileName = "c:/upload/"+archProyectoFileName;
                File theFile = new File(fullFileName);
                FileUtils.copyFile(archProyecto, theFile);
            }else{
                System.out.println("Proyecto Nulo");
            }
            actualizarFlujoEnvio();
            log.info("[ArchivoAction.cargaArchivoProyecto][Fin]");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            addActionError("Archivo No existe");
            this.setearMensajeError("1","Archivo No existe");
            return INPUT;
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());
            this.setearMensajeError("1",e.getMessage());
            return INPUT;
        }
        return SUCCESS;
    }
   
    public String cargaArchivoExpediente(){
         try {
             log.info("[ArchivoAction.cargaArchivoExpediente][Ini]");
             actualizarFlujoEnvio();
             String nombre = "";
             if (archExpediente!=null){
                 String extension=Utilitarios.obtenerExtensionArchivo(archExpedienteFileName);
                 String fullFileName = "c:/upload/"+archProponenteFileName;
                 File theFile = new File(fullFileName);
                 FileUtils.copyFile(archExpediente, theFile);
             }else{
                 System.out.println("Proyecto Nulo");
             }
             actualizarFlujoEnvio();
             log.info("[ArchivoAction.cargaArchivoExpediente][Fin]");
         } catch (FileNotFoundException e) {
             e.printStackTrace();
             addActionError("Archivo No existe");
             this.setearMensajeError("1","Archivo No existe");
             return INPUT;
         } catch (Exception e) {
             e.printStackTrace();
             addActionError(e.getMessage());
             this.setearMensajeError("1",e.getMessage());
             return INPUT;
         }
         return SUCCESS;
    }
    
    private void actualizarFlujoEnvio() throws Exception{
        log.info("Periodo-->"+periodo);
        ControlEnvio controlEnvio=new ControlEnvio();
        controlEnvio=controlEnvio.obtenerControlEnvioXPeriodo(this.periodo);
        setearEstado(controlEnvio);
    }
    
    private void setearEstado(ControlEnvio controlEnvio){
        String tmpEnvPro=controlEnvio.getFlgEnvioPro()!=null && !controlEnvio.getFlgEnvioPro().equals("")?controlEnvio.getFlgEnvioPro():ConstantesSistema.ENVIO_NO_ENVIADO;
        String tmpEnvPry=controlEnvio.getFlgEnvioPry()!=null && !controlEnvio.getFlgEnvioPry().equals("")?controlEnvio.getFlgEnvioPry():ConstantesSistema.ENVIO_NO_ENVIADO;
        String tmpEnvExp=controlEnvio.getFlgEnvioExp()!=null && !controlEnvio.getFlgEnvioExp().equals("")?controlEnvio.getFlgEnvioExp():ConstantesSistema.ENVIO_NO_ENVIADO;
        if (controlEnvio==null){
            this.setEstadoCargaProponente("true");
            this.setEstadoCargaProyecto("false");
            this.setEstadoCargaExpediente("false");
        }else{
            // Expediente procesando
            if (!tmpEnvExp.equals(ConstantesSistema.ENVIO_NO_ENVIADO)){
                this.setEstadoCargaProponente("true");
                this.setEstadoCargaProyecto("true");
                this.setEstadoCargaExpediente("true");
            // Expediente no procesado y Proyecto procesado OK
            }else if (tmpEnvPry.equals(ConstantesSistema.ENVIO_ENVIADO_OK) ){
                this.setEstadoCargaProponente("true");
                this.setEstadoCargaProyecto("true");
                this.setEstadoCargaExpediente("true");    
            // Expediente no procesado y Proyecto procesando
            }else if (!tmpEnvPry.equals(ConstantesSistema.ENVIO_NO_ENVIADO) ){
                this.setEstadoCargaProponente("true");
                this.setEstadoCargaProyecto("true");
                this.setEstadoCargaExpediente("false");
            // Expediente no procesado Proyecto no procesado y Proponente OK
            }else if (tmpEnvPro.equals(ConstantesSistema.ENVIO_ENVIADO_OK) ){
                this.setEstadoCargaProponente("true");
                this.setEstadoCargaProyecto("true");
                this.setEstadoCargaExpediente("false");    
            // Expediente no procesado Proyecto no procesado y Proponente procesando
            }else if (!tmpEnvPro.equals(ConstantesSistema.ENVIO_NO_ENVIADO) ){
                this.setEstadoCargaProponente("true");
                this.setEstadoCargaProyecto("false");
                this.setEstadoCargaExpediente("false");
            }else{
                this.setEstadoCargaProponente("true");
                this.setEstadoCargaProyecto("false");
                this.setEstadoCargaExpediente("false");
            }
        }
    }
   
    public void setArchProponente(File archProponente) {
        this.archProponente = archProponente;
    }

    public File getArchProponente() {
        return archProponente;
    }

    public void setArchProponenteContentType(String archProponenteContentType) {
        this.archProponenteContentType = archProponenteContentType;
    }

    public String getArchProponenteContentType() {
        return archProponenteContentType;
    }

    public void setArchProponenteFileName(String archProponenteFileName) {
        this.archProponenteFileName = archProponenteFileName;
    }

    public String getArchProponenteFileName() {
        return archProponenteFileName;
    }

    public void setArchProyecto(File archProyecto) {
        this.archProyecto = archProyecto;
    }

    public File getArchProyecto() {
        return archProyecto;
    }

    public void setArchProyectoContentType(String archProyectoContentType) {
        this.archProyectoContentType = archProyectoContentType;
    }

    public String getArchProyectoContentType() {
        return archProyectoContentType;
    }

    public void setArchProyectoFileName(String archProyectoFileName) {
        this.archProyectoFileName = archProyectoFileName;
    }

    public String getArchProyectoFileName() {
        return archProyectoFileName;
    }

    public void setArchExpediente(File archExpediente) {
        this.archExpediente = archExpediente;
    }

    public File getArchExpediente() {
        return archExpediente;
    }

    public void setArchExpedienteContentType(String archExpedienteContentType) {
        this.archExpedienteContentType = archExpedienteContentType;
    }

    public String getArchExpedienteContentType() {
        return archExpedienteContentType;
    }

    public void setArchExpedienteFileName(String archExpedienteFileName) {
        this.archExpedienteFileName = archExpedienteFileName;
    }

    public String getArchExpedienteFileName() {
        return archExpedienteFileName;
    }

    public void setEstadoCarga(String estadoCarga) {
        this.estadoCarga = estadoCarga;
    }

    public String getEstadoCarga() {
        return estadoCarga;
    }

    public void setEstadoCargaProponente(String estadoCargaProponente) {
        this.estadoCargaProponente = estadoCargaProponente;
    }

    public String getEstadoCargaProponente() {
        return estadoCargaProponente;
    }

    public void setEstadoCargaProyecto(String estadoCargaProyecto) {
        this.estadoCargaProyecto = estadoCargaProyecto;
    }

    public String getEstadoCargaProyecto() {
        return estadoCargaProyecto;
    }

    public void setEstadoCargaExpediente(String estadoCargaExpediente) {
        this.estadoCargaExpediente = estadoCargaExpediente;
    }

    public String getEstadoCargaExpediente() {
        return estadoCargaExpediente;
    }
}

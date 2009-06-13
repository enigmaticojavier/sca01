package gob.pe.minam.sca.action;

import com.opensymphony.xwork2.Preparable;

import gob.pe.minam.sca.framework.AccionSoporte;
import gob.pe.minam.sca.framework.ConstantesSistema;
import gob.pe.minam.sca.pojo.ControlEnvio;
import gob.pe.minam.sca.pojo.Expediente;
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


public class UploadAction extends AccionSoporte implements Preparable {
    
    static Logger log = Logger.getLogger("UploadAction.class");
    private String periodoSeleccionado;
    private ControlEnvio controlEnvio;
    private List parPeriodos;
    private String estadoCargaProponente;
    private String estadoCargaProyecto;
    private String estadoCargaExpediente;
    
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
    
    public void prepare() throws Exception {
        try{
            log.info("[UploadAction.prepare][Ini]");
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
            log.info("[UploadAction.prepare][Fin]");
        }catch(Exception ex){
            ex.printStackTrace();
        }  
    }
    
    public String list(){
      try{
        log.info("[UploadAction.list][Ini]");
        Expediente exp = new Expediente();
        String tmpPeriodo=this.periodoSeleccionado.substring(0,4) + this.periodoSeleccionado.substring(5,7);
        log.info("tmpPeriodo"+tmpPeriodo);
        ControlEnvio contEnv=new ControlEnvio();
        this.controlEnvio=contEnv.obtenerControlEnvioXPeriodo(tmpPeriodo);
        setearEstado(this.controlEnvio);
        log.info("[UploadAction.list][Fin]");
        return SUCCESS;
      }catch(Exception ex){
        ex.printStackTrace();
      }  
      return SUCCESS;
    }
    
    private void setearEstado(ControlEnvio controlEnvio){
        String tmpEnvPro=controlEnvio!=null && controlEnvio.getEstEnvioPro()!=null && !controlEnvio.getEstEnvioPro().equals("")?controlEnvio.getEstEnvioPro():ConstantesSistema.ENVIO_NO_ENVIADO;
        String tmpEnvPry=controlEnvio!=null && controlEnvio.getEstEnvioPry()!=null && !controlEnvio.getEstEnvioPry().equals("")?controlEnvio.getEstEnvioPry():ConstantesSistema.ENVIO_NO_ENVIADO;
        String tmpEnvExp=controlEnvio!=null && controlEnvio.getEstEnvioExp()!=null && !controlEnvio.getEstEnvioExp().equals("")?controlEnvio.getEstEnvioExp():ConstantesSistema.ENVIO_NO_ENVIADO;
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
    
    public String cargaArchivoProponente(){
        try {
            log.info("[UploadAction.cargaArchivoProponente][Ini]");
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
                if (this.archProponente!=null){
                    String extension=Utilitarios.obtenerExtensionArchivo(archProponenteFileName);
                    String nombreArchivo = carpeta + "\\" + archProponenteFileName;
                    log.info("nombreArchivo-->"+nombreArchivo);
                    File theFile = new File(nombreArchivo);
                    try{
                        copiado=false;
                        FileUtils.copyFile(archProponente, theFile);
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
            log.info("[UploadAction.cargaArchivoProponente][Fin]");
       } catch (Exception e) {
           e.printStackTrace();
           log.error("Error en la carga del Archivo");
           this.setearMensajeError("1","Error en la carga del Archivo");
           return SUCCESS;
       }
       return SUCCESS;
    }
    
    public String cargaArchivoProyecto(){
        try {
            log.info("[UploadAction.cargaArchivoProyecto][Ini]");
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
                if (this.archProyecto!=null){
                    String extension=Utilitarios.obtenerExtensionArchivo(archProyectoFileName);
                    String nombreArchivo = carpeta + "\\" + archProyectoFileName;
                    log.info("nombreArchivo-->"+nombreArchivo);
                    File theFile = new File(nombreArchivo);
                    try{
                        copiado=false;
                        FileUtils.copyFile(archProyecto, theFile);
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
                                log.info("NULAZO");
                                controlEnvio=new ControlEnvio();
                                controlEnvio.setPersonaId(3);
                                controlEnvio.setPeriodo(tmpPeriodo);
                                controlEnvio.setEstEnvioPry(ConstantesSistema.ENVIO_ENVIADO_OK);
                                controlEnvio.setFchEnvioPry(new Date());
                            }else{
                                controlEnvio.setEstEnvioPry(ConstantesSistema.ENVIO_ENVIADO_OK);
                                controlEnvio.setFchEnvioPry(new Date());
                            }
                            log.info("this.controlEnvioSENT-->"+this.controlEnvio.getPeriodo());
                            cntrEnvio.guardarControlEnvio(controlEnvio);
                        }else{
                            this.setearMensajeError("1","Error en la lectura del Archivo " + beanRetLectExcel.getDscError());
                            log.error("Error en la lectura del Archivo " + beanRetLectExcel.getDscError());
                        }
                    }
                }else{
                    log.info("Archivo Proyecto Nulo");
                    this.setearMensajeError("1","Archivo no Existe");
                    log.error("Archivo no Existe");
                }
            }else{
                this.setearMensajeError("1","Carpeta Temporal no configurada");
                log.error("Carpeta Temporal no configurada");
            }
            setearEstado(this.controlEnvio);
            log.info("[UploadAction.cargaArchivoProyecto][Fin]");
       } catch (Exception e) {
           e.printStackTrace();
           log.error("Error en la carga del Archivo");
           this.setearMensajeError("1","Error en la carga del Archivo");
           return SUCCESS;
       }
       return SUCCESS;
    }
    
    public String cargaArchivoExpediente(){
        try {
            log.info("[UploadAction.cargaArchivoExpediente][Ini]");
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
                if (this.archExpediente!=null){
                    String extension=Utilitarios.obtenerExtensionArchivo(archExpedienteFileName);
                    String nombreArchivo = carpeta + "\\" + archExpedienteFileName;
                    log.info("nombreArchivo-->"+nombreArchivo);
                    File theFile = new File(nombreArchivo);
                    try{
                        copiado=false;
                        FileUtils.copyFile(archExpediente, theFile);
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
                                log.info("NULAZO");
                                controlEnvio=new ControlEnvio();
                                controlEnvio.setPersonaId(3);
                                controlEnvio.setPeriodo(tmpPeriodo);
                                controlEnvio.setEstEnvioExp(ConstantesSistema.ENVIO_ENVIADO_OK);
                                controlEnvio.setFchEnvioExp(new Date());
                            }else{
                                controlEnvio.setEstEnvioExp(ConstantesSistema.ENVIO_ENVIADO_OK);
                                controlEnvio.setFchEnvioExp(new Date());
                            }
                            log.info("this.controlEnvioSENT-->"+this.controlEnvio.getPeriodo());
                            cntrEnvio.guardarControlEnvio(controlEnvio);
                        }else{
                            this.setearMensajeError("1","Error en la lectura del Archivo " + beanRetLectExcel.getDscError());
                            log.error("Error en la lectura del Archivo " + beanRetLectExcel.getDscError());
                        }
                    }
                }else{
                    log.info("Archivo Expediente Nulo");
                    this.setearMensajeError("1","Archivo no Existe");
                    log.error("Archivo no Existe");
                }
            }else{
                this.setearMensajeError("1","Carpeta Temporal no configurada");
                log.error("Carpeta Temporal no configurada");
            }
            setearEstado(this.controlEnvio);
            log.info("[UploadAction.cargaArchivoExpediente][Fin]");
       } catch (Exception e) {
           e.printStackTrace();
           log.error("Error en la carga del Archivo");
           this.setearMensajeError("1","Error en la carga del Archivo");
           return SUCCESS;
       }
       return SUCCESS;
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

    public void setPeriodoSeleccionado(String periodoSeleccionado) {
        this.periodoSeleccionado = periodoSeleccionado;
    }

    public String getPeriodoSeleccionado() {
        return periodoSeleccionado;
    }
    
    public void setParPeriodos(List parPeriodos) {
        this.parPeriodos = parPeriodos;
    }

    public List getParPeriodos() {
        return parPeriodos;
    }

    public void setControlEnvio(ControlEnvio controlEnvio) {
        this.controlEnvio = controlEnvio;
    }

    public ControlEnvio getControlEnvio() {
        return controlEnvio;
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
}


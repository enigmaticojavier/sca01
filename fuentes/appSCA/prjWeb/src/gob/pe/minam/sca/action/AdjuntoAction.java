package gob.pe.minam.sca.action;

import com.opensymphony.xwork2.Preparable;

import gob.pe.minam.sca.framework.AccionSoporte;
import gob.pe.minam.sca.framework.ConstantesSistema;
import gob.pe.minam.sca.pojo.Acae;
import gob.pe.minam.sca.pojo.ControlEnvio;
import gob.pe.minam.sca.pojo.Documento;
import gob.pe.minam.sca.pojo.Expediente;
import gob.pe.minam.sca.pojo.ExpedienteDocumento;
import gob.pe.minam.sca.pojo.ImagenDocumento;
import gob.pe.minam.sca.pojo.Parametro;
import gob.pe.minam.sca.pojo.Periodo;
import gob.pe.minam.sca.pojo.Usuario;
import gob.pe.minam.sca.util.excel.ExcelGenerador;
import gob.pe.minam.sca.util.Utilitarios;
import gob.pe.minam.sca.util.bean.BeanRetorno;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;


public class AdjuntoAction extends AccionSoporte implements Preparable {
    
    static Logger log = Logger.getLogger("AdjuntoAction.class");
    private String periodoSeleccionado;
    private int docId;
    private int personaId;
    private ControlEnvio controlEnvio;
    private ImagenDocumento imagenDocumento;
    private List expedienteDocumentos;
    private List parPeriodos;
    private Acae acae;
    
    // Adjunto
    private File archAdjunto;//The actual file
    private String archAdjuntoContentType; //The content type of the file
    private String archAdjuntoFileName; //The uploaded file name
    
    public void prepare() throws Exception {
        try{
            log.info("[AdjuntoAction.prepare][Ini]");
            this.acae=new Acae();
            this.personaId=((Usuario)this.getVarSession("Usuario")).getPersonaId().intValue();
            this.acae.setPersonaId(this.personaId);
            this.acae = Acae.getAcaeByKey(this.acae);
            /*Tipo de Acae*/
            Parametro par = new Parametro();
            /*Periodo*/
            Periodo per = new Periodo();
            int nroDias=Integer.parseInt(((Parametro)par.buscarParametroXTipoParametro("PLZ").get(0)).getTxtValor());
            this.parPeriodos=per.listarPeriodoReporte(nroDias);
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
        this.acae=new Acae();
        this.personaId=((Usuario)this.getVarSession("Usuario")).getPersonaId().intValue();
        this.acae.setPersonaId(this.personaId);
        this.acae = Acae.getAcaeByKey(this.acae);
        this.expedienteDocumentos=expdoc.buscarExpDocPeriodoPersona(tmpPeriodo,personaId);
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
            this.acae=new Acae();
            this.personaId=((Usuario)this.getVarSession("Usuario")).getPersonaId().intValue();
            this.acae.setPersonaId(this.personaId);
            this.acae = Acae.getAcaeByKey(this.acae);
            log.info("PeriodoSeleccionado-->"+this.periodoSeleccionado+"tmpPeriodo-->"+tmpPeriodo+"-->personaId"+this.personaId);
            boolean copiado=false;
            BeanRetorno beanRetLectExcel=null;
            ControlEnvio cntrEnvio=new ControlEnvio();
            this.controlEnvio=cntrEnvio.obtenerControlEnvioXPeriodo(tmpPeriodo,this.personaId);
            log.info(this.controlEnvio==null?"this.controlEnvio Read":"this.controlEnvio Read"+this.controlEnvio.getPeriodo());
            
            String carpeta = "";
            Parametro par=new Parametro();
            List l = par.buscarParametroXTipoParametro(ConstantesSistema.CARPETA_IMAGENES);
            if (l!=null && l.size()>0){
                carpeta = ((Parametro)l.get(0)).getTxtValor();
                if (this.archAdjunto!=null){
                    String extension=Utilitarios.obtenerExtensionArchivo(archAdjuntoFileName);
                    String nombreArchivo = carpeta + "\\" + Utilitarios.formatoFechaActual() + "_" + archAdjuntoFileName;
                    log.info("nombreArchivo-->"+nombreArchivo);
                    File theFile = new File(nombreArchivo);
                    try{
                        copiado=false;
                        FileUtils.copyFile(archAdjunto, theFile);
                        copiado=true;
                    }catch(FileNotFoundException e){
                        e.printStackTrace();
                        this.setearMensajeError("1","Archivo No existe");
                    }catch(IOException e){
                        e.printStackTrace();
                        this.setearMensajeError("1","Archivo/Ruta No existe " + nombreArchivo);
                    }
                    // Procesar Archivo
                    if (copiado){
                        // Actualizar Archivo Imagen
                        this.docId=Integer.parseInt(getParameterValue("docId").equals("")?"0":getParameterValue("docId"));
                        this.imagenDocumento=new ImagenDocumento();
                        Documento doc = new Documento();
                        doc.setDocId(this.docId);
                        this.imagenDocumento.setDocumento(doc);
                        this.imagenDocumento.setTxtNomArchivo(archAdjuntoFileName);
                        this.imagenDocumento.setTxtRutaImagen(nombreArchivo);
                        ImagenDocumento imaDoc = new ImagenDocumento();
                        imaDoc.grabarImagenDocumento(this.imagenDocumento);
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
            
            ExpedienteDocumento expdoc = new ExpedienteDocumento();
            this.expedienteDocumentos=expdoc.buscarExpDocPeriodoPersona(tmpPeriodo,personaId);
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

    public void setExpedienteDocumentos(List expedienteDocumentos) {
        this.expedienteDocumentos = expedienteDocumentos;
    }

    public List getExpedienteDocumentos() {
        return expedienteDocumentos;
    }

    public void setImagenDocumento(ImagenDocumento imagenDocumento) {
        this.imagenDocumento = imagenDocumento;
    }

    public ImagenDocumento getImagenDocumento() {
        return imagenDocumento;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public int getDocId() {
        return docId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setAcae(Acae acae) {
        this.acae = acae;
    }

    public Acae getAcae() {
        return acae;
    }
}


package gob.pe.minam.sca.action;

import com.opensymphony.xwork2.Preparable;

import gob.pe.minam.sca.framework.AccionSoporte;
import gob.pe.minam.sca.pojo.Parametro;
import gob.pe.minam.sca.pojo.Proyecto;
import gob.pe.minam.sca.pojo.SubSector;

import gob.pe.minam.sca.pojo.Ubigeo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

public class ProyectoAction extends AccionSoporte implements Preparable {
    static Logger log = Logger.getLogger("ProyectoAction.class");
    /*Parámetros Búsqueda*/
    private Integer pryId;
    private String txtDescripcion; /*nombreProyecto*/
    private String ubigeoId; /*departamento*/
    private String clsTipificacion; /*categoria*/
    private Date fchExpedienteDesde; /*Fecha de Presentación Desde*/
    private Date fchExpedienteHasta; /*Fecha de Presentación Desde*/
    private String estadoTramite; /*Estado Tramite*/
    private String tipoAcae;
    private String clsSector; /*Institución*/
    private String clsSubSector; /*Dependencia*/
    private String ubigeoSeleccionado;
    
    private Proyecto proyecto;
    private List proyectos;
    private List ubiDepartamentos;
    private List parCategProy;
    private List parEstadoTramite;
    private List parTipoAcae;
    private List parInstitucion;
    private List parDependencia;
    
    public void prepare() throws Exception {
        try{
            log.info("[ProyectoAction.prepare][Ini]");
            llenaParametrosIniciales();
            log.info("pryId "+this.pryId);
            log.info("[ProyectoAction.prepare][Fin]");
        }catch(Exception ex){
            ex.printStackTrace();
        }  
    }
    
    public String input() {
        try{
            log.info("[ProyectoAction.input][Ini]");
            String tmpTipParametro=this.getParameterValue("tipParametro");
            log.info("[ProyectoAction.input][Fin]");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return INPUT;
    }
    
    public String list(){
      try{
        log.info("[ProyectoAction.list][Ini]");
        Parametro par = new Parametro();
        SubSector sub = new SubSector();
        List lstIns = new ArrayList();
        List lstDep = new ArrayList();
        par.setCodParametro(COMBO_COD_ALL);
        par.setTxtValor(COMBO_TXT_ALL);
        lstIns.add(par);
        this.parInstitucion=lstIns;
        sub.setClsSubSector(COMBO_COD_ALL);
        sub.setTxtSubSector(COMBO_TXT_ALL);
        lstDep.add(sub);
        this.parDependencia=lstDep;
        this.setVarSession("mensajeError",null);
        log.info("[ProyectoAction.list][Fin]");
        return SUCCESS;
      }catch(Exception ex){
        ex.printStackTrace();
      }  
      return SUCCESS;
    }
    
    private void llenaParametrosIniciales(){
      try{
          log.info("[ProyectoAction.llenaParametrosIniciales][Ini]");
          Parametro pr = new Parametro(); 
          Ubigeo ubigeo = new Ubigeo();
          /*Departamentos*/          
          ubigeo.setUbigeoId(COMBO_COD_ALL);
          ubigeo.setTxtDescripcion(COMBO_TXT_ALL);
          this.ubiDepartamentos=ubigeo.listarDepartamento();
          ubiDepartamentos.add(ubigeo);
          if (this.ubigeoId==null) ubigeoId=COMBO_COD_ALL;
          /*Categoria del Proyecto*/
          List lstCatPry=pr.buscarParametroXTipoParametro("IGA");
          Parametro par = new Parametro();
          par.setCodParametro(COMBO_COD_OTROS);
          par.setTxtValor(COMBO_TXT_OTROS);
          lstCatPry.add(par);
          par = new Parametro();
          par.setCodParametro(COMBO_COD_ALL);
          par.setTxtValor(COMBO_TXT_ALL);
          lstCatPry.add(par);
          if (this.clsTipificacion==null) clsTipificacion=COMBO_COD_ALL;
          this.parCategProy=lstCatPry;
          /*Estado del Trámite*/
          List lstEstTra = pr.buscarParametroXTipoParametro("EST");
          lstEstTra.add(par);
          if (estadoTramite==null) estadoTramite=COMBO_COD_ALL;
          this.parEstadoTramite=lstEstTra;
          /*Tipo de Acae*/
          List lstTipAcae = pr.buscarParametroXTipoParametro("TAC");
          lstTipAcae.add(par);
          if (this.tipoAcae==null) tipoAcae=COMBO_COD_ALL;
          this.parTipoAcae=lstTipAcae;
          log.info("[ProyectoAction.llenaParametrosIniciales][Fin]");
      }catch(Exception ex){
          ex.printStackTrace();
      }                  
    }
    
    public String buscarInstitucionXTipoAcae(){
      try{
          log.info("[ProyectoAction.buscarInstitucionXTipoAcae][Ini]");
          Parametro par = new Parametro(); 
          SubSector sub = new SubSector();
          List lstIns = new ArrayList();
          List lstDep = new ArrayList();
          if (this.tipoAcae!=null){
              log.info("this.tipoAcae " + this.tipoAcae);
              if (!this.tipoAcae.equals(COMBO_COD_ALL)){
                  lstIns=par.buscarParametroXTipoParametro(this.tipoAcae);
                  if (lstIns==null) lstIns = new ArrayList();
                  par.setCodParametro(COMBO_COD_ALL);
                  par.setTxtValor(COMBO_TXT_ALL);
                  lstIns.add(par);
                  this.parInstitucion=lstIns;
                  this.clsSector=COMBO_COD_ALL;
              }else{
                  par.setCodParametro(COMBO_COD_ALL);
                  par.setTxtValor(COMBO_TXT_ALL);
                  lstIns.add(par);
                  this.parInstitucion=lstIns;
                  this.clsSector=COMBO_COD_ALL;
              }
              sub.setClsSubSector(COMBO_COD_ALL);
              sub.setTxtSubSector(COMBO_TXT_ALL);
              lstDep.add(sub);
              this.parDependencia=lstDep;
              this.clsSubSector=COMBO_COD_ALL;
          }else{
              this.parInstitucion=new ArrayList();
          }   
          log.info("[ProyectoAction.buscarInstitucionXTipoAcae][Fin]");
      }catch(Exception ex){
        ex.printStackTrace();
      } 
      return SUCCESS;
    }
    
    public String buscarDependenciaXInstitucion(){
      try{
          log.info("[ProyectoAction.buscarDependenciaXInstitucion][Ini]");
          Parametro par = new Parametro(); 
          SubSector sub = new SubSector();
          List lstIns = new ArrayList();
          List lstDep = new ArrayList();
          lstIns=par.buscarParametroXTipoParametro(this.tipoAcae);
          if (lstIns==null) lstIns = new ArrayList();
          par.setCodParametro(COMBO_COD_ALL);
          par.setTxtValor(COMBO_TXT_ALL);
          lstIns.add(par);
          this.parInstitucion=lstIns;
          if (this.clsSector!=null){
              log.info("this.clsSector " + this.clsSector);
              if (!this.clsSector.equals(COMBO_COD_ALL)){
                  lstDep=sub.buscarSubsectorXSector(this.clsSector);
                  if (lstDep==null) lstDep=new ArrayList();
              }
              sub.setClsSubSector(COMBO_COD_ALL);
              sub.setTxtSubSector(COMBO_TXT_ALL);
              lstDep.add(sub);
              this.parDependencia=lstDep;
              this.clsSubSector=COMBO_COD_ALL;
          }else{
              this.parDependencia=new ArrayList();
          }
          log.info("[ProyectoAction.buscarDependenciaXInstitucion][Fin]");
      }catch(Exception ex){
        ex.printStackTrace();
      } 
      return SUCCESS;
    }
    
    public String buscarProyecto(){
        try{
            log.info("[ProyectoAction.buscarProyecto][Ini]");
            log.info("tipoAcae-->"+this.tipoAcae+"-->clsSector-->"+this.clsSector+"-->clsSubSector-->"+this.clsSubSector);
            Parametro par = new Parametro();
            SubSector sub = new SubSector();
            List lstIns = new ArrayList();
            List lstDep = new ArrayList();
            /*Institucion*/
            if (this.tipoAcae==null) {
               this.tipoAcae=COMBO_COD_ALL;
               this.clsSector=COMBO_COD_ALL;
               this.clsSubSector=COMBO_COD_ALL;
            }
            if (!this.tipoAcae.equals(COMBO_COD_ALL)){
              lstIns=par.buscarParametroXTipoParametro(this.tipoAcae);
            }
            if (lstIns==null) lstIns = new ArrayList();
            par.setCodParametro(COMBO_COD_ALL);
            par.setTxtValor(COMBO_TXT_ALL);
            lstIns.add(par);
            this.parInstitucion=lstIns;
            /*Dependencia*/
            if (this.clsSector==null) {
               this.clsSector=COMBO_COD_ALL;
               this.clsSubSector=COMBO_COD_ALL;
            }
            if (!this.clsSector.equals(COMBO_COD_ALL)){
             lstDep=sub.buscarSubsectorXSector(this.clsSector) ;
            }
            sub.setClsSubSector(COMBO_COD_ALL);
            sub.setTxtSubSector(COMBO_TXT_ALL);
            lstDep.add(sub);
            this.parDependencia=lstDep;
            this.proyectos=Proyecto.buscarProyecto(this.txtDescripcion,this.ubigeoId,this.clsTipificacion,this.fchExpedienteDesde,this.fchExpedienteHasta,this.estadoTramite, this.tipoAcae, this.clsSector,this.clsSubSector);  
            log.info(this.proyectos==null?"this.proyectos.size=0":"this.proyectos.size="+this.proyectos.size());
            log.info("[ProyectoAction.buscarProyecto][Fin]");
        }catch(Exception ex){
          ex.printStackTrace();
        } 
        return SUCCESS;  
    }
    
    public void setTxtDescripcion(String txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public String getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setUbigeoId(String ubigeoId) {
        this.ubigeoId = ubigeoId;
    }

    public String getUbigeoId() {
        return ubigeoId;
    }

    public void setClsTipificacion(String clsTipificacion) {
        this.clsTipificacion = clsTipificacion;
    }

    public String getClsTipificacion() {
        return clsTipificacion;
    }

    public void setFchExpedienteDesde(Date fchExpedienteDesde) {
        this.fchExpedienteDesde = fchExpedienteDesde;
    }

    public Date getFchExpedienteDesde() {
        return fchExpedienteDesde;
    }

    public void setFchExpedienteHasta(Date fchExpedienteHasta) {
        this.fchExpedienteHasta = fchExpedienteHasta;
    }

    public Date getFchExpedienteHasta() {
        return fchExpedienteHasta;
    }

    public void setEstadoTramite(String estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    public String getEstadoTramite() {
        return estadoTramite;
    }

    public void setTipoAcae(String tipoAcae) {
        this.tipoAcae = tipoAcae;
    }

    public String getTipoAcae() {
        return tipoAcae;
    }

    public void setClsSector(String clsSector) {
        this.clsSector = clsSector;
    }

    public String getClsSector() {
        return clsSector;
    }

    public void setClsSubSector(String clsSubSector) {
        this.clsSubSector = clsSubSector;
    }

    public String getClsSubSector() {
        return clsSubSector;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyectos(List proyectos) {
        this.proyectos = proyectos;
    }

    public List getProyectos() {
        return proyectos;
    }

    public void setUbiDepartamentos(List ubiDepartamentos) {
        this.ubiDepartamentos = ubiDepartamentos;
    }

    public List getUbiDepartamentos() {
        return ubiDepartamentos;
    }

    public void setParCategProy(List parCategProy) {
        this.parCategProy = parCategProy;
    }

    public List getParCategProy() {
        return parCategProy;
    }

    public void setParEstadoTramite(List parEstadoTramite) {
        this.parEstadoTramite = parEstadoTramite;
    }

    public List getParEstadoTramite() {
        return parEstadoTramite;
    }

    public void setParTipoAcae(List parTipoAcae) {
        this.parTipoAcae = parTipoAcae;
    }

    public List getParTipoAcae() {
        return parTipoAcae;
    }

    public void setParInstitucion(List parInstitucion) {
        this.parInstitucion = parInstitucion;
    }

    public List getParInstitucion() {
        return parInstitucion;
    }

    public void setParDependencia(List parDependencia) {
        this.parDependencia = parDependencia;
    }

    public List getParDependencia() {
        return parDependencia;
    }

    public void setUbigeoSeleccionado(String ubigeoSeleccionado) {
        this.ubigeoSeleccionado = ubigeoSeleccionado;
    }

    public String getUbigeoSeleccionado() {
        return ubigeoSeleccionado;
    }
}

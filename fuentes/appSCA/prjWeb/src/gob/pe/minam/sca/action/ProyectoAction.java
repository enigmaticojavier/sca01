package gob.pe.minam.sca.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

import gob.pe.minam.sca.framework.AccionSoporte;
import gob.pe.minam.sca.pojo.Parametro;
import gob.pe.minam.sca.pojo.Proyecto;
import gob.pe.minam.sca.pojo.SubSector;

import gob.pe.minam.sca.pojo.Ubigeo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ProyectoAction extends AccionSoporte implements Preparable {
    
    /*Parámetros Búsqueda*/
    private String txtDescripcion; /*nombreProyecto*/
    private String ubigeoId; /*departamento*/
    private String clsTipificacion; /*categoria*/
    private Date fchExpedienteDesde; /*Fecha de Presentación Desde*/
    private Date fchExpedienteHasta; /*Fecha de Presentación Desde*/
    private String estadoTramite; /*Estado Tramite*/
    private String tipoAcae;
    private String clsSector; /*Institución*/
    private String clsSubSector; /*Dependencia*/
    
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
            System.out.println("ParametroAction.prepare---------------------------------------------->");
            llenaParametrosIniciales();
            System.out.println("ParametroAction.prepare<-----------------------------------------");
        }catch(Exception ex){
            ex.printStackTrace();
        }  
    }
    
    public String input() {
        System.out.println("-------------->ParametroAction.input");
        try{
            String tmpTipParametro=getParameterValue("tipParametro");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("<--------------ParametroAction.input");
        return INPUT;
    }
    
    public String list(){
      System.out.println("ParametroAction.List---->");
      try{
        Parametro pr = new Parametro();
        SubSector sb = new SubSector();
        /*Institucion*/
        if (this.parTipoAcae!=null && this.parTipoAcae.size()>0){
         this.parInstitucion=pr.buscarParametroXTipoParametro(((Parametro)this.parTipoAcae.get(0)).getCodParametro());
        }else{
          this.parInstitucion=new ArrayList();
        }   
        /*Dependencia*/
        if (this.parInstitucion!=null && this.parInstitucion.size()>0){
         this.parDependencia=sb.buscarSubsectorXSector(((Parametro)this.parInstitucion.get(0)).getCodParametro()) ;
        }else{
         this.parDependencia=new ArrayList();
        }
        
        this.setVarSession("mensajeError",null);
        System.out.println("ParametroAction.List<----");
        return SUCCESS;
      }catch(Exception ex){
        ex.printStackTrace();
      }  
      return SUCCESS;
    }
    
    private void llenaParametrosIniciales(){
      try{
          Parametro pr = new Parametro(); 
          SubSector sb = new SubSector();
          Ubigeo ubi = new Ubigeo();
          /*Departamentos*/
          this.ubiDepartamentos=ubi.listarDepartamento();
          /*Categoria del Proyecto*/
          this.parCategProy=pr.buscarParametroXTipoParametro("IGA");
          /*Estado del Trámite*/
          this.parEstadoTramite=pr.buscarParametroXTipoParametro("EST");
          /*Tipo de Acae*/
          this.parTipoAcae=pr.buscarParametroXTipoParametro("TAC");
      }catch(Exception ex){
          ex.printStackTrace();
      }                  
    }
    
    public String buscarInstitucionXTipoAcae(){
      try{
          System.out.println("buscarInstitucionXTipoAcae Ini");
          Parametro pr = new Parametro(); 
          SubSector sb = new SubSector();
          if (this.tipoAcae!=null){
              System.out.println("this.parInstitucion " + this.tipoAcae);
              this.parInstitucion=pr.buscarParametroXTipoParametro(this.tipoAcae);
              if (this.parInstitucion!=null && this.parInstitucion.size()>0){
                  this.parDependencia=sb.buscarSubsectorXSector(((Parametro)this.parInstitucion.get(0)).getCodParametro()) ;
              }else{
                  this.parInstitucion=new ArrayList();
              }
          }else{
              this.parInstitucion=new ArrayList();
          }   
          System.out.println("buscarInstitucionXTipoAcae Fin");
      }catch(Exception ex){
        ex.printStackTrace();
      } 
      return SUCCESS;
    }
    
    public String buscarDependenciaXInstitucion(){
      try{
          Parametro pr = new Parametro();
          SubSector sb = new SubSector();
          this.parInstitucion=pr.buscarParametroXTipoParametro(this.tipoAcae);
          if (this.clsSector!=null){
              System.out.println("this.clsSector " + this.clsSector);
              this.parDependencia=sb.buscarSubsectorXSector(this.clsSector) ;
              if (this.parDependencia!=null && this.parDependencia.size()>0){
              }else{
                 this.parDependencia=new ArrayList();
              }  
          }else{
              this.parDependencia=new ArrayList();
          }
      }catch(Exception ex){
        ex.printStackTrace();
      } 
      return SUCCESS;
    }
    
    public String buscarProyecto(){
        try{
            System.out.println("tipoAcae-->"+this.tipoAcae+"-->clsSector-->"+this.clsSector+"-->clsSubSector-->"+this.clsSubSector);
            Parametro pr = new Parametro();
            SubSector sb = new SubSector();
            /*Institucion*/
            if (this.tipoAcae!=null){
              this.parInstitucion=pr.buscarParametroXTipoParametro(this.tipoAcae);
            }else{
              this.parInstitucion=new ArrayList();
            }   
            /*Dependencia*/
            if (this.parInstitucion!=null && this.parInstitucion.size()>0){
             this.parDependencia=sb.buscarSubsectorXSector(this.clsSector) ;
            }else{
             this.parDependencia=new ArrayList();
            }
            this.proyectos=Proyecto.buscarProyecto(this.txtDescripcion,this.ubigeoId,this.clsTipificacion,this.fchExpedienteDesde,this.fchExpedienteHasta,this.estadoTramite,this.clsSector,this.clsSubSector);  
        }catch(Exception ex){
          ex.printStackTrace();
        } 
        return SUCCESS;  
    }
    
    public String getParameterValue(String param) {
      Object varr = ActionContext.getContext().getParameters().get(param);
      if (varr == null) return "";
      return ((String[]) varr)[0];
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
}

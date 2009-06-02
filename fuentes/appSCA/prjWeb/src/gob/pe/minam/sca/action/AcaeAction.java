package gob.pe.minam.sca.action;

import java.util.List;

import gob.pe.minam.sca.framework.ConstantesSistema;
import gob.pe.minam.sca.framework.exception.NegocioException;
import gob.pe.minam.sca.pojo.Parametro;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import gob.pe.minam.sca.pojo.Persona;
import gob.pe.minam.sca.pojo.SubSector;

import gob.pe.minam.sca.pojo.Ubigeo;

import java.util.ArrayList;

public class AcaeAction extends ActionSupport  implements Preparable {
	
    private String tipoAcae;
    private String ubigeoId; /*departamento*/
    private String clsSector; /*Institución*/
    private String clsSubSector; /*Dependencia*/
    private List parTipoAcae;
    private List parInstitucion;
    private List parDependencia;
    private List ubiDepartamentos;
    private Persona persona;    
    
    /**
    private String txtRazonSocial;

    public String getTxtRazonSocial() {
            return txtRazonSocial;
    }

    public void setTxtRazonSocial(String txtRazonSocial) {
            this.txtRazonSocial = txtRazonSocial;
    }
    **/

    /**
     * 
     */
    private static final long serialVersionUID = -8873103128650016222L;

    public void prepare() throws Exception {
        try {
            System.out.println("Inicio prepare");
            llenaParametrosIniciales();
            System.out.println("Fin prepare");
            
        }catch (Exception ex){
                 ex.printStackTrace();
        }
    }
    
    public void llenaParametrosIniciales() {            
        System.out.println("Inicio llenaParametrosIniciales");
        try {
            Parametro pr = new Parametro();
            Ubigeo ubi = new Ubigeo();
            /*Departamentos*/
            this.ubiDepartamentos=ubi.listarDepartamento();
            /*Tipo de Acae*/
             System.out.println("Buscando tipo Acae");
            this.parTipoAcae=pr.buscarParametroXTipoParametro(ConstantesSistema.TIPO_ACAE);
        } catch (Exception ex) {
             ex.printStackTrace();
        }
        System.out.println("Fin llenaParametrosIniciales");
    }
    
    public String list() throws NegocioException {
        try{
          Parametro pr = new Parametro();
          SubSector sb = new SubSector();
          /*Institucion*/
          if (this.parTipoAcae!=null && this.parTipoAcae.size()>0){
            System.out.println("-->this.parTipoAcae.size()"+parTipoAcae.size());
            System.out.println("-->this.parTipoAcae.get(0)"+this.parTipoAcae.get(0));
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
          
          //this.setVarSession("mensajeError",null);
          System.out.println("ParametroAction.List<----");
          //return SUCCESS;
        } catch(Exception ex){
              ex.printStackTrace();
        }
        return SUCCESS;
    }
    
    
    public String buscarInstitucionXTipoAcae(){
      try{
          System.out.println("buscarInstitucionXTipoAcae Ini");
          Parametro pr = new Parametro(); 
          SubSector sb = new SubSector();
          if (this.tipoAcae!=null){
              System.out.println("this.parInstitucion " + this.tipoAcae);
              System.out.println("===>this.parTipoAcae.size()"+this.parTipoAcae.size());
              System.out.println("===>this.parTipoAcae.get(0)"+this.parTipoAcae.get(0));
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
              System.out.println("this.parTipoAcae.size()"+this.parTipoAcae.size());
              
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

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setUbigeoId(String ubigeoId) {
        this.ubigeoId = ubigeoId;
    }

    public String getUbigeoId() {
        return ubigeoId;
    }

    public void setUbiDepartamentos(List ubiDepartamentos) {
        this.ubiDepartamentos = ubiDepartamentos;
    }

    public List getUbiDepartamentos() {
        return ubiDepartamentos;
    }
}

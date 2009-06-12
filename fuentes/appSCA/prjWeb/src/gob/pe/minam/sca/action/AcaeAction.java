package gob.pe.minam.sca.action;

import gob.pe.minam.sca.pojo.Acae;

import gob.pe.minam.sca.pojo.Usuario;

import java.util.List;

import gob.pe.minam.sca.framework.ConstantesSistema;
import gob.pe.minam.sca.framework.exception.NegocioException;
import gob.pe.minam.sca.pojo.Parametro;

import com.opensymphony.xwork2.ActionSupport;
import gob.pe.minam.sca.pojo.Persona;
import gob.pe.minam.sca.pojo.SubSector;

import gob.pe.minam.sca.pojo.Ubigeo;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class AcaeAction extends ActionSupport  {
    static Logger log = Logger.getLogger("AcaeAction.class");
    public static String COMBO_TXT_SELECCIONAR="SELECCIONAR";
    public static String COMBO_COD_SELECCIONAR="0";	
    private String tipoAcae;
    private String ubigeoId; /*departamento*/
    private String codDepartamento;
    private String codProvincia;
    private String codDistrito;
    private String clsSector; /*Institución*/
    private String clsSubSector; /*Dependencia*/
    private List parTipoAcae;
    private List parInstitucion;
    private List parDependencia;
    private List ubiDepartamentos;
    private List ubiProvincia;
    private List ubiDistrito;
    
    private Persona persona;
    private Acae acae; 
    private Usuario usuario;
    private String codClave2;

    private static final long serialVersionUID = -8873103128650016222L;
   
    public void llenaParametrosIniciales() {            
        log.info("Inicio llenaParametrosIniciales");
        try {
            Parametro pr = new Parametro();
            Ubigeo ubigeo = new Ubigeo();
            /*Departamentos*/
            List lstDepa=ubigeo.listarDepartamento();             
            this.ubiDepartamentos=lstDepa;
                        
            /*Tipo de Acae*/
            log.info("Buscando tipo Acae");
            this.parTipoAcae=pr.buscarParametroXTipoParametro(ConstantesSistema.TIPO_ACAE);
        } catch (Exception ex) {
             ex.printStackTrace();
        }
        log.info("Fin llenaParametrosIniciales");
    }
    public String list() throws NegocioException {
        
        try{
            llenaParametrosIniciales();
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
          
          //Departamento
          Ubigeo ubigeo = new Ubigeo();
          if (this.codDepartamento!=null) {
               ubigeo.setCodDepartamento(this.getCodDepartamento().substring(0,2));
               if (this.codProvincia!=null) {
                   ubigeo.setCodProvincia(this.codProvincia.substring(2,4));
               }
           } else {
               ubigeo.setCodDepartamento("01");            
               ubigeo.setCodProvincia("02");    
           }            
           this.ubiProvincia = ubigeo.listarProvincia(ubigeo);            
           this.ubiDistrito = ubigeo.listarDistrito(ubigeo);
          System.out.println("ParametroAction.List<----");
          //return SUCCESS;
        } catch(Exception ex){
              ex.printStackTrace();
        }
        return SUCCESS;
    }
    public String doCrearAcae(){
              
        try {        
            Integer personaId =  this.persona.getNextItem();
            this.persona.setPersonaId(personaId);            
            this.acae.setPersonaId(personaId);
            this.usuario.setPersonaId(personaId);
            this.acae.setTipAcae(this.tipoAcae);
            this.acae.setClsSector(this.clsSector);
            this.acae.setClsSubSector(this.clsSubSector);
            this.persona.setUbigeoId(this.codDistrito);
            System.out.println("acae.getTipAcae()="+this.tipoAcae);
            System.out.println("acae.getClsSector()="+this.clsSector);
            System.out.println("acae.getClsSubSector()="+this.clsSubSector);
            System.out.println("this.codDistrito="+this.codDistrito);
            persona.insertPersona(this.persona);
            acae.insertAcae(this.acae);
            usuario.insertUsuario(this.usuario);            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return "creado";
    }
    public String doCargarParametros(){
        try {
            llenaParametrosIniciales();
            buscarInstitucionXTipoAcae();
            buscarDependenciaXInstitucion(); 
            log.info("codDepartamento="+this.codDepartamento);
            if (this.codDepartamento!=null && !this.codDepartamento.equals("0")){
                buscarProvincia();
            }
                        
        }  catch (Exception ex) {
             ex.printStackTrace();
        }
        return SUCCESS;
    }
    
    public void buscarProvincia(){
        try {                    
            log.info("this.getCodDepartamento()"+this.getCodDepartamento());
            
            if (this.getCodDepartamento()!=null) {
                Ubigeo ubigeo = new Ubigeo();
                ubigeo.setUbigeoId(this.getCodDepartamento());
                this.codDepartamento = this.getCodDepartamento();
                log.info("codDepartamento="+codDepartamento);
                ubigeo.setCodDepartamento(this.getCodDepartamento().substring(0,2));
                this.ubiProvincia = ubigeo.listarProvincia(ubigeo);
                ubiProvincia.add(ubigeo);            
                log.info("saliendo");
                 if (ubiProvincia!=null) {
                     buscarDistrito(ubigeo);
                 }
            }
            
        }catch (Exception ex) {
             ex.printStackTrace();
        }        
    }
    public void buscarDistrito(Ubigeo ubigeo){
        try {
        if (codProvincia!=null) { 
            String codProvincia = this.codProvincia.substring(2,4);
            System.out.println("codProvincia="+codProvincia);
            ubigeo.setCodProvincia(codProvincia);            
            this.ubiDistrito = ubigeo.listarDistrito(ubigeo);
            System.out.println("ubidistrito="+ubiDistrito.size());
        }          
        }catch (Exception ex) {
             ex.printStackTrace();
        } 
    }
    
    public void buscarInstitucionXTipoAcae(){
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
      
    }
    
    public void buscarDependenciaXInstitucion(){
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

    public void setUbiProvincia(List ubiProvincia) {
        this.ubiProvincia = ubiProvincia;
    }

    public List getUbiProvincia() {
        return ubiProvincia;
    }

    public void setUbiDistrito(List ubiDistrito) {
        this.ubiDistrito = ubiDistrito;
    }

    public List getUbiDistrito() {
        return ubiDistrito;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setCodDistrito(String codDistrito) {
        this.codDistrito = codDistrito;
    }

    public String getCodDistrito() {
        return codDistrito;
    }

    public void setAcae(Acae acae) {
        this.acae = acae;
    }

    public Acae getAcae() {
        return acae;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setCodClave2(String codClave2) {
        this.codClave2 = codClave2;
    }

    public String getCodClave2() {
        return codClave2;
    }

    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getCodDepartamento() {
        return codDepartamento;
    }
}

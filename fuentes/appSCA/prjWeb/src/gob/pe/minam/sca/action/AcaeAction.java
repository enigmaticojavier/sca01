package gob.pe.minam.sca.action;

import gob.pe.minam.sca.pojo.Acae;

import gob.pe.minam.sca.pojo.Usuario;

import java.util.List;

import gob.pe.minam.sca.framework.ConstantesSistema;
import gob.pe.minam.sca.framework.exception.NegocioException;
import gob.pe.minam.sca.pojo.Parametro;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.pojo.Persona;
import gob.pe.minam.sca.pojo.SubSector;

import gob.pe.minam.sca.pojo.Ubigeo;

import java.util.ArrayList;

public class AcaeAction extends ActionSupport  implements Preparable {
    public static String COMBO_TXT_SELECCIONAR="SELECCIONAR";
    public static String COMBO_COD_SELECCIONAR="0";	
    private String tipoAcae;
    private String ubigeoId; /*departamento*/
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
            Ubigeo ubigeo = new Ubigeo();
            /*Departamentos*/
            List lstDepa=ubigeo.listarDepartamento();            
            ubigeo.setUbigeoId(COMBO_COD_SELECCIONAR);
            ubigeo.setTxtDescripcion(COMBO_TXT_SELECCIONAR);
            lstDepa.add(ubigeo);            
            this.ubiDepartamentos=lstDepa;
            if (this.ubigeoId==null) ubigeoId=COMBO_COD_SELECCIONAR;
            //buscarProvincia();
            this.ubiProvincia = new ArrayList();
            if (this.codProvincia==null) ubiProvincia.add(ubigeo);
            this.ubiDistrito = new ArrayList();
            if (this.codDistrito==null) ubiDistrito.add(ubigeo);
            /*Tipo de Acae*/
             System.out.println("Buscando tipo Acae");
            this.parTipoAcae=pr.buscarParametroXTipoParametro(ConstantesSistema.TIPO_ACAE);
        } catch (Exception ex) {
             ex.printStackTrace();
        }
        System.out.println("Fin llenaParametrosIniciales");
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
            System.out.println("acae.getTipAcae()="+this.tipoAcae);
            System.out.println("acae.getClsSector()="+this.clsSector);
            System.out.println("acae.getClsSubSector()="+this.clsSubSector);
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
            buscarInstitucionXTipoAcae();
            buscarDependenciaXInstitucion();
            if (!this.ubigeoId.equals(COMBO_COD_SELECCIONAR)){
                buscarProvincia();    
            }
          
            
        }  catch (Exception ex) {
             ex.printStackTrace();
        }
        return SUCCESS;
    }
    
    public void buscarProvincia(){
        try {                    
            System.out.println("ubigeoId="+getUbigeoId());
            Ubigeo ubigeo = new Ubigeo();
            List lstUbigeo = new ArrayList();
            ubigeo.setUbigeoId(COMBO_COD_SELECCIONAR);
            ubigeo.setTxtDescripcion(COMBO_TXT_SELECCIONAR);
            if (!this.ubigeoId.equals(COMBO_COD_SELECCIONAR)){
                String codDepartamento = this.ubigeoId.substring(0,2);
                System.out.println("codDepartamento="+codDepartamento);
                ubigeo.setCodDepartamento(codDepartamento);                                
                lstUbigeo = ubigeo.listarProvincia(ubigeo);
                lstUbigeo.add(ubigeo);
                this.ubiProvincia = lstUbigeo;
                buscarDistrito(ubigeo);
                //this.codProvincia=COMBO_COD_SELECCIONAR;
            } else {
                lstUbigeo.add(ubigeo);
                this.ubiProvincia = lstUbigeo;
                this.codProvincia=COMBO_COD_SELECCIONAR;
            }
            
            /**
            ubigeo.setUbigeoId(COMBO_COD_SELECCIONAR);
            ubigeo.setTxtDescripcion(COMBO_TXT_SELECCIONAR);
            if (ubigeoId!=null) {
                String ubigeo2 = this.ubigeoId.substring(0,2);
                System.out.println("ubigeo2="+ubigeo2);
                ubigeo.setCodDepartamento(ubigeo2);
                this.ubiProvincia = ubigeo.listarProvincia(ubigeo);
                ubiProvincia.add(ubigeo);
                //this.codProvincia=COMBO_COD_SELECCIONAR;
                System.out.println("saliendo");
                 if (ubiProvincia!=null) {
                     buscarDistrito(ubigeo);
                 }
            }
            **/
        }catch (Exception ex) {
             ex.printStackTrace();
        }        
    }
    public void buscarDistrito(Ubigeo ubigeo){
        try {
        if (codProvincia!=null && !codProvincia.equals(this.COMBO_COD_SELECCIONAR)) { 
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
}
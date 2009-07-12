package gob.pe.minam.sca.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.pojo.Acae;

import gob.pe.minam.sca.pojo.Persona;

import gob.pe.minam.sca.pojo.Usuario;

import java.util.List;

import org.apache.log4j.Logger;

public class AcaeModificaAction extends AcaeAction {
    static Logger log = Logger.getLogger("AcaeAction.class");
    private List acaes;
    private boolean buscar=false;
    
    public String doMuestra(){
        return "busqueda";
    }
    public String doBuscarAcae() throws DAOException {       
        
        if (this.acae.getTxtRazonSocial()!=null ) {
            log.info("acae="+this.acae.getTxtRazonSocial());
            acae.setTxtRazonSocial(this.acae.getTxtRazonSocial().trim().toUpperCase());
            acaes = acae.getAcaeByNombre(acae);
            this.buscar=true;
        } else {
            addActionError("Debe ingresar nombre de ACAE.");
        }
               
        return "busqueda";
    }
    
    public String doBuscarDatos() {
        String personaId=this.getParameterValue("personaId");
        log.info("personaId="+personaId);
        acae = new Acae();
        persona = new Persona();
        usuario= new Usuario();
        acae.setPersonaId(new Integer(personaId));
        persona.setPersonaId(new Integer(personaId));
        usuario.setPersonaId(new Integer(personaId));
        try {
            this.acae = acae.getAcaeBusqueda(acae);
            if (this.acae!=null) {
                this.llenaParametrosIniciales();
                this.tipoAcae = acae.getTipAcae();
                this.clsSector = acae.getClsSector();
                //this.clsSubSector = acae.getClsSubSector();
                this.persona.setTxtRazonSocial(acae.getTxtRazonSocial());
                this.persona.setTxtDomicilio(acae.getTxtDomicilio());
                this.codDepartamento= acae.getUbigeo().getCodDepartamento();
                this.codProvincia = acae.getUbigeo().getCodProvincia();
                this.codDistrito = acae.getUbigeo().getCodDistrito();
                this.persona.setTelefono(acae.getTelefono());
                this.persona.setFax(acae.getFax());                
                this.persona.setTxtEmail(acae.getTxtEmail());
                this.usuario.setUsuario(acae.getUsuario().getUsuario());
                this.usuario.setCodClave(acae.getUsuario().getCodClave());
                this.buscarInstitucionXTipoAcae();
                //this.buscarDependenciaXInstitucion();
                this.buscarProvincia();
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
    
    public String doActualizarAcae(){
        
        try {
        log.info("personaId="+this.persona.getPersonaId());
        
        this.acae.setPersonaId(this.persona.getPersonaId());
        this.usuario.setPersonaId(this.persona.getPersonaId());
        
        this.acae.setTipAcae(this.tipoAcae);
        this.acae.setClsSector(this.clsSector);
        //this.acae.setClsSubSector(this.clsSubSector);
        this.persona.setUbigeoId(this.codDistrito);
        
        acae.updateAcae(acae);
        persona.updatePersona(persona);
        usuario.updateUsuario(usuario);
        
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return "modificado";
    }
    public String getParameterValue(String param) {
      Object varr = ActionContext.getContext().getParameters().get(param);
      if (varr == null) return "";
      return ((String[]) varr)[0];
    }
    public void setAcae(Acae acae) {
        this.acae = acae;
    }

    public Acae getAcae() {
        return acae;
    }

    public void setAcaes(List acaes) {
        this.acaes = acaes;
    }

    public List getAcaes() {
        return acaes;
    }

    public void setBuscar(boolean buscar) {
        this.buscar = buscar;
    }

    public boolean isBuscar() {
        return buscar;
    }
}

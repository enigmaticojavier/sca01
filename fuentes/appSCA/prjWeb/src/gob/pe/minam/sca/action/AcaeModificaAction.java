package gob.pe.minam.sca.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.pojo.Acae;

import java.util.List;

import org.apache.log4j.Logger;

public class AcaeModificaAction extends ActionSupport {
    static Logger log = Logger.getLogger("AcaeAction.class");
    private Acae acae = new Acae();    
    private List acaes;
    
    public String doMuestra(){
        return SUCCESS;
    }
    public String doBuscarAcae() throws DAOException {       
        
        if (this.acae.getTxtRazonSocial()!=null && !this.acae.getTxtRazonSocial().equals("")) {
            log.info("acae="+this.acae.getTxtRazonSocial());
            acae.setTxtRazonSocial(this.acae.getTxtRazonSocial().toUpperCase());
            acaes = acae.getAcaeByNombre(acae);    
        }
        
        if (acaes!=null) {
            log.info("acaes="+acaes);            
        }        
        return SUCCESS;
    }
    
    public String doBuscarDatos() {
        String personaId=this.getParameterValue("personaId");
        log.info("personaId="+personaId);
        acae.setPersonaId(new Integer(personaId));
        try {
            this.acae = acae.getAcaeBusqueda(acae);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return "verBusqueda";
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
}

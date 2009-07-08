/**
 * 
 */
package gob.pe.minam.sca.action;

import java.util.Map;

import gob.pe.minam.sca.framework.ConstantesSistema;
import gob.pe.minam.sca.pojo.Acae;
import gob.pe.minam.sca.pojo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.log4j.Logger;

/**
 * @author Dante
 *
 */
public class LoginAction extends ActionSupport {
    static Logger log = Logger.getLogger("LoginAction.class");		
    private static final long serialVersionUID = 506117110998025792L;
    private String usuario=null;
    private String codClave=null;
    private String txtValor=null;
    private Acae acae = new Acae();
	
    public String getUsuario() {
            return usuario;
    }
    public void setUsuario(String usuario) {
            this.usuario = usuario;
    }
    public String getCodClave() {
            return codClave;
    }
    public void setCodClave(String codClave) {
            this.codClave = codClave;
    }
            
    public String getTxtValor() {
            return txtValor;
    }
    public void setTxtValor(String txtValor) {
            this.txtValor = txtValor;
    }
    
    public Acae getAcae() {
            return acae;
    }
    public void setAcae(Acae acae) {
            this.acae = acae;
    }
    public String execute() throws Exception {
        
	String sReturn="";
	Usuario usuario = new Usuario();
	usuario.setUsuario(getUsuario().toUpperCase());
        usuario.setCodClave(getCodClave().toUpperCase());
        log.info("usuario="+getUsuario());
        log.info("clave="+getCodClave());
        
        usuario = Usuario.getUsuarioByKey(usuario);
                
        if (usuario!= null) {
            this.setTxtValor(usuario.getTxtValor());
            if (usuario.getTipUsuario().equals(ConstantesSistema.TIPO_USUARIO_ADM)){
                sReturn = "ADM";
                this.ponerSesion(usuario);
            } else if (usuario.getTipUsuario().equals(ConstantesSistema.TIPO_USUARIO_ACAE)){				
                acae.setPersonaId(usuario.getPersonaId());
                acae = Acae.getAcaeByKey(acae);                
                sReturn = "ACA";
                this.ponerSesion(usuario);
            }			
        } else {
            addActionError("Usuario o Clave no v�lidos.");
            return ERROR;
        }
	return sReturn;		
    }
	
    public void ponerSesion(Usuario usuario){
        Map session = ActionContext.getContext().getSession();
	session.put("Usuario", usuario);
    }
   
}

/**
 * 
 */
package gob.pe.minam.sca.action;

import gob.pe.minam.sca.framework.ConstantesSistema;
import gob.pe.minam.sca.pojo.Usuario;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Dante
 *
 */
public class LoginAction extends ActionSupport {
		
	private static final long serialVersionUID = 506117110998025792L;
	private String usuario=null;
	private String codClave=null;
	private String txtValor=null;
	
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
	public String execute() throws Exception {
        
		String sReturn="";
		Usuario usuario = new Usuario();
		usuario.setUsuario(getUsuario().toUpperCase());
        usuario.setCodClave(getCodClave().toUpperCase());
        System.out.println("usuario="+getUsuario());
        System.out.println("clave="+getCodClave());
        
        usuario = Usuario.getUsuarioByKey(usuario);
                
        if (usuario!= null) {
        	this.setTxtValor(usuario.getTxtValor());
			if (usuario.getTipUsuario().equals(ConstantesSistema.TIPO_USUARIO_ADM)){
				sReturn = "ADM";
			} else if (usuario.getTipUsuario().equals(ConstantesSistema.TIPO_USUARIO_ACAE)){
				sReturn = "ACA";
			}        	
		} else {
			addActionError("Usuario o Clave no válidos.");
			return ERROR;
		}
		return sReturn;		
	}
   
}

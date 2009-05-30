package gob.pe.minam.sca.pojo;
/***********************************************************************
 * Module:  Usuario.java
 * Author:  Dante Antiporta
 * Purpose: Defines the Class Usuario
 ***********************************************************************/

import gob.pe.minam.sca.data.ProyectoService;
import gob.pe.minam.sca.data.dao.UsuarioDao;



/** Maestro de usuarios (En la implementacion solo se creara uno por cada ACAE)
 * 
 * */
public class Usuario {

   private String usuario;
   private Integer personaId; 
   private String codClave;
   private String tipUsuario;
   private String txtValor;
   
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Integer getPersonaId() {
		return personaId;
	}
	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}	
	public String getCodClave() {
		return codClave;
	}
	public void setCodClave(String codClave) {
		this.codClave = codClave;
	}
	public String getTipUsuario() {
		return tipUsuario;
	}
	public void setTipUsuario(String tipUsuario) {
		this.tipUsuario = tipUsuario;
	}
		
	public String getTxtValor() {
		return txtValor;
	}
	public void setTxtValor(String txtValor) {
		this.txtValor = txtValor;
	}
	public static Usuario getUsuarioByKey(Usuario usuario){
		ProyectoService proyectoService = ProyectoService.getInstance();
		UsuarioDao usuarioDao = proyectoService.getUsuarioDao();		
		return usuarioDao.getUsuarioByKey(usuario);
	}
   
}
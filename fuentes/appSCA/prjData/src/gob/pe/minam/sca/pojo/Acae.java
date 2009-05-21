package gob.pe.minam.sca.pojo;

import gob.pe.minam.sca.data.ProyectoService;
import gob.pe.minam.sca.data.dao.AcaeDao;
import gob.pe.minam.sca.data.dao.UsuarioDao;
import gob.pe.minam.sca.framework.DateUtil;

import java.util.List;

public class Acae extends Persona {
	
	/** @pdOid 3b51f217-98c6-4002-a386-5a881cb21a49 */
   private java.lang.String tipAcae;
   /** @pdOid b660a22b-788f-4a39-8173-e4b05499a326 */
   private java.lang.String clsSector;
   /** @pdOid e6fd48bc-fb1e-44b6-9ac8-1be15cf36bd4 */
   private java.lang.String clsSubSector;
   
   private java.lang.String tipDocumentoGer;
   /** @pdOid eccca16c-8343-468b-a476-90d8c9717c67 */
   private java.lang.String codDocumentoGer;
   /** @pdOid 085398c2-b81c-4116-9de0-f829118c1955 */
   private java.lang.String txtApellidosNombres;
   /** @pdOid 233919f8-5896-40ee-9a7c-164701ca217d */
   private java.lang.String txtCargo;
   /** @pdOid 25e9e7e0-6f89-43d6-8cc3-dbc70b11d757 */
   private java.lang.String telefonoGer;
   private String txtValor;
   private String txtSubSector;
   private String fechaActual = DateUtil.fechaActualString();
   
   public List<Expediente> expediente;

	public java.lang.String getTipAcae() {
		return tipAcae;
	}
	
	public void setTipAcae(java.lang.String tipAcae) {
		this.tipAcae = tipAcae;
	}
	
	public java.lang.String getTipDocumentoGer() {
		return tipDocumentoGer;
	}
	
	public void setTipDocumentoGer(java.lang.String tipDocumentoGer) {
		this.tipDocumentoGer = tipDocumentoGer;
	}
	
	public java.lang.String getCodDocumentoGer() {
		return codDocumentoGer;
	}
	
	public void setCodDocumentoGer(java.lang.String codDocumentoGer) {
		this.codDocumentoGer = codDocumentoGer;
	}
	
	public java.lang.String getTxtApellidosNombres() {
		return txtApellidosNombres;
	}
	
	public void setTxtApellidosNombres(java.lang.String txtApellidosNombres) {
		this.txtApellidosNombres = txtApellidosNombres;
	}
	
	public java.lang.String getTxtCargo() {
		return txtCargo;
	}
	
	public void setTxtCargo(java.lang.String txtCargo) {
		this.txtCargo = txtCargo;
	}
	
	public java.lang.String getTelefonoGer() {
		return telefonoGer;
	}
	
	public void setTelefonoGer(java.lang.String telefonoGer) {
		this.telefonoGer = telefonoGer;
	}
	
	public String getTxtValor() {
		return txtValor;
	}
	
	public void setTxtValor(String txtValor) {
		this.txtValor = txtValor;
	}
	
	public String getTxtSubSector() {
		return txtSubSector;
	}
	
	public void setTxtSubSector(String txtSubSector) {
		this.txtSubSector = txtSubSector;
	}
	
	public List<Expediente> getExpediente() {
		return expediente;
	}
	
	public void setExpediente(List<Expediente> expediente) {
		this.expediente = expediente;
	}

	public java.lang.String getClsSector() {
		return clsSector;
	}

	public void setClsSector(java.lang.String clsSector) {
		this.clsSector = clsSector;
	}

	public java.lang.String getClsSubSector() {
		return clsSubSector;
	}

	public void setClsSubSector(java.lang.String clsSubSector) {
		this.clsSubSector = clsSubSector;
	}
	
	public String getFechaActual() {
		return fechaActual;
	}

	public static Acae getAcaeByKey(Acae acae){
		ProyectoService proyectoService = ProyectoService.getInstance();
		AcaeDao acaeDao = proyectoService.getAcaeDao(); 
		return acaeDao.getAcaeByKey(acae);
	}
	   
}

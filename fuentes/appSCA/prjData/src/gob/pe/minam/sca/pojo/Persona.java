package gob.pe.minam.sca.pojo;

/***********************************************************************
 * Module:  Persona.java
 * Author:  JORGE
 * Purpose: Defines the Class Persona
 ***********************************************************************/

import java.util.*;

/** Maestro de personas
 * 
 * @pdOid f5e02575-75bf-40fc-9ad4-e7b3af9b7f68 */
public class Persona {
   /** @pdOid 3d88dbcb-87af-4a58-ae34-1b835bdc885d */
   private int personaId;
   /** @pdOid 32ba6b62-3dd1-4e4a-a9f1-3cfb88ad1b16 */
   private String tipDocumentoPer;
   /** @pdOid fbb05f3b-a14e-47e5-8d06-a6ba8f0c4d60 */
   private String numDocumentoPer;
   /** @pdOid fe2b0dcf-5e82-44de-a8af-564d7c535c4e */
   private String tipPersona;
   /** @pdOid bdc06b32-e0a3-47f0-9032-8a8b48cb5332 */
   private String txtRazonSocial;
   /** @pdOid 3dc9fe35-053d-40ac-a404-ea3300691597 */
   private String txtDomicilio;
   /** @pdOid 5e813c04-a7e5-4f79-9c8d-47e04c79974f */
   private String telefono;
   /** @pdOid 403f50cf-e5f2-476b-a390-e5efbf7e3f24 */
   private String txtEmail;
   /** @pdOid 75e794b2-f524-4c1d-9c7d-0b5db4986946 */
   private String fax;
      
   /** @pdOid 90e22fa9-7b4c-4542-8c93-53056e5bd89d
       @pdRoleInfo migr=yes name=DocumentoPersona assc=Association14 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public List<DocumentoPersona> documentoPersona;
   /** @pdOid 4e6fa3e4-dd86-4bf2-9294-8e8e05f4b98f
       @pdRoleInfo migr=yes name=Usuario assc=Association19 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.List<Usuario> usuario;

   public int getPersonaId() {
	return personaId;
	}

   public void setPersonaId(int personaId) {
	this.personaId = personaId;
	}

   public String getTipDocumentoPer() {
	return tipDocumentoPer;
	}

   public void setTipDocumentoPer(String tipDocumentoPer) {
	this.tipDocumentoPer = tipDocumentoPer;
	}

   public String getNumDocumentoPer() {
	   return numDocumentoPer;
   }
   
   public void setNumDocumentoPer(String numDocumentoPer) {
	this.numDocumentoPer = numDocumentoPer;
   }

   public String getTipPersona() {
	  return tipPersona;
   }
	public void setTipPersona(String tipPersona) {
		this.tipPersona = tipPersona;
	}
	public String getTxtRazonSocial() {
		return txtRazonSocial;
	}
	public void setTxtRazonSocial(String txtRazonSocial) {
		this.txtRazonSocial = txtRazonSocial;
	}
	public String getTxtDomicilio() {
		return txtDomicilio;
	}
	public void setTxtDomicilio(String txtDomicilio) {
		this.txtDomicilio = txtDomicilio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTxtEmail() {
		return txtEmail;
	}
	public void setTxtEmail(String txtEmail) {
		this.txtEmail = txtEmail;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public List<DocumentoPersona> getDocumentoPersona() {
		return documentoPersona;
	}
	public void setDocumentoPersona(List<DocumentoPersona> documentoPersona) {
		this.documentoPersona = documentoPersona;
	}
	public java.util.List<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(java.util.List<Usuario> usuario) {
		this.usuario = usuario;
	}
   
}
package gob.pe.minam.sca.pojo;

/***********************************************************************
 * Module:  Persona.java
 * Author:  JORGE
 * Purpose: Defines the Class Persona
 ***********************************************************************/

import gob.pe.minam.sca.data.ProyectoService;

import gob.pe.minam.sca.data.dao.PersonaDao;
import gob.pe.minam.sca.framework.exception.DAOException;

import java.util.*;

/** Maestro de personas
 * 
 * @pdOid f5e02575-75bf-40fc-9ad4-e7b3af9b7f68 */
public class Persona {
   /** @pdOid 3d88dbcb-87af-4a58-ae34-1b835bdc885d */
   protected Integer personaId;
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
   private String ubigeoId;
   private Usuario usuario;
   private Ubigeo ubigeo;
   private String txtWeb;
   
   /** @pdOid 90e22fa9-7b4c-4542-8c93-53056e5bd89d
       @pdRoleInfo migr=yes name=DocumentoPersona assc=Association14 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public List<DocumentoPersona> documentoPersona;
   

   public Integer getPersonaId() {
	return personaId;
   }

   public void setPersonaId(Integer personaId) {
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
    public java.lang.String getTxtWeb() {
            return txtWeb;
    }

    public void setTxtWeb(java.lang.String txtWeb) {
            this.txtWeb = txtWeb;
    }
    public List<DocumentoPersona> getDocumentoPersona() {
            return documentoPersona;
    }
    public void setDocumentoPersona(List<DocumentoPersona> documentoPersona) {
            this.documentoPersona = documentoPersona;
    }

    public void setUbigeoId(String ubigeoId) {
        this.ubigeoId = ubigeoId;
    }

    public String getUbigeoId() {
        return ubigeoId;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }
    
        
    public static Persona getPersonaByKey(Persona persona){
        ProyectoService proyectoService = ProyectoService.getInstance();
        PersonaDao personaDao = proyectoService.getPersonaDao();
        return personaDao.getPersonaByKey(persona);
    }
    
    public static Integer getNextItem() {
           ProyectoService proyectoService = ProyectoService.getInstance();
           PersonaDao personaDao = proyectoService.getPersonaDao();
           return personaDao.getNextItem();
       }

    public static void insertPersona(Persona persona) throws DAOException {
       ProyectoService proyectoService = ProyectoService.getInstance();
       PersonaDao personaDao = proyectoService.getPersonaDao();
       personaDao.insertPersona(persona);
    }
    
    public static void updatePersona(Persona persona) throws DAOException {
        ProyectoService proyectoService = ProyectoService.getInstance();
        PersonaDao personaDao = proyectoService.getPersonaDao();
        personaDao.updatePersona(persona);
    }
    
    public List selectProponenteByTipDoc(String tipDoc) throws DAOException {
        ProyectoService proyectoService = ProyectoService.getInstance();
        PersonaDao personaDao = proyectoService.getPersonaDao();
        return personaDao.selectProponenteByTipDoc(tipDoc);
    }
}

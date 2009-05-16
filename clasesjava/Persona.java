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
   private java.lang.String tipDocumentoPer;
   /** @pdOid fbb05f3b-a14e-47e5-8d06-a6ba8f0c4d60 */
   private java.lang.String numDocumentoPer;
   /** @pdOid fe2b0dcf-5e82-44de-a8af-564d7c535c4e */
   private java.lang.String tipPersona;
   /** @pdOid bdc06b32-e0a3-47f0-9032-8a8b48cb5332 */
   private java.lang.String txtRazonSocial;
   /** @pdOid 3dc9fe35-053d-40ac-a404-ea3300691597 */
   private java.lang.String txtDomicilio;
   /** @pdOid 5e813c04-a7e5-4f79-9c8d-47e04c79974f */
   private java.lang.String telefono;
   /** @pdOid 403f50cf-e5f2-476b-a390-e5efbf7e3f24 */
   private java.lang.String txtEmail;
   /** @pdOid 75e794b2-f524-4c1d-9c7d-0b5db4986946 */
   private java.lang.String fax;
   
   /** @pdOid 90e22fa9-7b4c-4542-8c93-53056e5bd89d
       @pdRoleInfo migr=yes name=DocumentoPersona assc=Association14 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<DocumentoPersona> documentoPersona;
   /** @pdOid 4e6fa3e4-dd86-4bf2-9294-8e8e05f4b98f
       @pdRoleInfo migr=yes name=Usuario assc=Association19 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Usuario> usuario;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<DocumentoPersona> getDocumentoPersona() {
      if (documentoPersona == null)
         documentoPersona = new java.util.HashSet<DocumentoPersona>();
      return documentoPersona;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorDocumentoPersona() {
      if (documentoPersona == null)
         documentoPersona = new java.util.HashSet<DocumentoPersona>();
      return documentoPersona.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newDocumentoPersona */
   public void setDocumentoPersona(java.util.Collection<DocumentoPersona> newDocumentoPersona) {
      removeAllDocumentoPersona();
      for (java.util.Iterator iter = newDocumentoPersona.iterator(); iter.hasNext();)
         addDocumentoPersona((DocumentoPersona)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newDocumentoPersona */
   public void addDocumentoPersona(DocumentoPersona newDocumentoPersona) {
      if (newDocumentoPersona == null)
         return;
      if (this.documentoPersona == null)
         this.documentoPersona = new java.util.HashSet<DocumentoPersona>();
      if (!this.documentoPersona.contains(newDocumentoPersona))
         this.documentoPersona.add(newDocumentoPersona);
   }
   
   /** @pdGenerated default remove
     * @param oldDocumentoPersona */
   public void removeDocumentoPersona(DocumentoPersona oldDocumentoPersona) {
      if (oldDocumentoPersona == null)
         return;
      if (this.documentoPersona != null)
         if (this.documentoPersona.contains(oldDocumentoPersona))
            this.documentoPersona.remove(oldDocumentoPersona);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllDocumentoPersona() {
      if (documentoPersona != null)
         documentoPersona.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Usuario> getUsuario() {
      if (usuario == null)
         usuario = new java.util.HashSet<Usuario>();
      return usuario;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorUsuario() {
      if (usuario == null)
         usuario = new java.util.HashSet<Usuario>();
      return usuario.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUsuario */
   public void setUsuario(java.util.Collection<Usuario> newUsuario) {
      removeAllUsuario();
      for (java.util.Iterator iter = newUsuario.iterator(); iter.hasNext();)
         addUsuario((Usuario)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUsuario */
   public void addUsuario(Usuario newUsuario) {
      if (newUsuario == null)
         return;
      if (this.usuario == null)
         this.usuario = new java.util.HashSet<Usuario>();
      if (!this.usuario.contains(newUsuario))
         this.usuario.add(newUsuario);
   }
   
   /** @pdGenerated default remove
     * @param oldUsuario */
   public void removeUsuario(Usuario oldUsuario) {
      if (oldUsuario == null)
         return;
      if (this.usuario != null)
         if (this.usuario.contains(oldUsuario))
            this.usuario.remove(oldUsuario);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllUsuario() {
      if (usuario != null)
         usuario.clear();
   }

}
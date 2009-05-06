/***********************************************************************
 * Module:  Documento.java
 * Author:  JORGE
 * Purpose: Defines the Class Documento
 ***********************************************************************/

import java.util.*;

/** Documentos que el proponente presenta o la ACAE expide
 * 
 * @pdOid 85363f55-53e2-4391-a237-43f9a7de2215 */
public class Documento {
   /** @pdOid 0624957c-0ac1-43fe-9630-b5c4ab7924dc */
   private int DocId;
   /** @pdOid e0f3fade-45d8-4138-8604-9a0669caf1a5 */
   private Char(3) TipoDocumento;
   /** @pdOid 96d87b81-6d2e-476a-9abe-2837008d3f7d */
   private String(50) CodDocumento;
   /** @pdOid 9d3ebf49-9609-4d0e-ba74-ca1fd459d51e */
   private java.util.Date FchExpedicion;
   /** @pdOid 85469e3e-16e4-4a2b-b987-ecaff8b278f8 */
   private java.util.Date FchPresentacion;
   
   /** @pdOid d146dd05-e9a7-4869-ab39-47b44cf4cb6f
       @pdRoleInfo migr=yes name=DocumentoPersona assc=Association17 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<DocumentoPersona> documentoPersona;
   /** @pdOid cb04c9e9-f942-4a95-aa4a-ca96497084d8
       @pdRoleInfo migr=yes name=ImagenDocumento assc=Association11 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<ImagenDocumento> imagenDocumento;
   /** @pdOid c4968b93-bea0-48df-864d-a2fc366379ff
       @pdRoleInfo migr=yes name=ExpedienteDocumento assc=Association18 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<ExpedienteDocumento> expedienteDocumento;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<ImagenDocumento> getImagenDocumento() {
      if (imagenDocumento == null)
         imagenDocumento = new java.util.HashSet<ImagenDocumento>();
      return imagenDocumento;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorImagenDocumento() {
      if (imagenDocumento == null)
         imagenDocumento = new java.util.HashSet<ImagenDocumento>();
      return imagenDocumento.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newImagenDocumento */
   public void setImagenDocumento(java.util.Collection<ImagenDocumento> newImagenDocumento) {
      removeAllImagenDocumento();
      for (java.util.Iterator iter = newImagenDocumento.iterator(); iter.hasNext();)
         addImagenDocumento((ImagenDocumento)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newImagenDocumento */
   public void addImagenDocumento(ImagenDocumento newImagenDocumento) {
      if (newImagenDocumento == null)
         return;
      if (this.imagenDocumento == null)
         this.imagenDocumento = new java.util.HashSet<ImagenDocumento>();
      if (!this.imagenDocumento.contains(newImagenDocumento))
         this.imagenDocumento.add(newImagenDocumento);
   }
   
   /** @pdGenerated default remove
     * @param oldImagenDocumento */
   public void removeImagenDocumento(ImagenDocumento oldImagenDocumento) {
      if (oldImagenDocumento == null)
         return;
      if (this.imagenDocumento != null)
         if (this.imagenDocumento.contains(oldImagenDocumento))
            this.imagenDocumento.remove(oldImagenDocumento);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllImagenDocumento() {
      if (imagenDocumento != null)
         imagenDocumento.clear();
   }
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
   public java.util.Collection<ExpedienteDocumento> getExpedienteDocumento() {
      if (expedienteDocumento == null)
         expedienteDocumento = new java.util.HashSet<ExpedienteDocumento>();
      return expedienteDocumento;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorExpedienteDocumento() {
      if (expedienteDocumento == null)
         expedienteDocumento = new java.util.HashSet<ExpedienteDocumento>();
      return expedienteDocumento.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newExpedienteDocumento */
   public void setExpedienteDocumento(java.util.Collection<ExpedienteDocumento> newExpedienteDocumento) {
      removeAllExpedienteDocumento();
      for (java.util.Iterator iter = newExpedienteDocumento.iterator(); iter.hasNext();)
         addExpedienteDocumento((ExpedienteDocumento)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newExpedienteDocumento */
   public void addExpedienteDocumento(ExpedienteDocumento newExpedienteDocumento) {
      if (newExpedienteDocumento == null)
         return;
      if (this.expedienteDocumento == null)
         this.expedienteDocumento = new java.util.HashSet<ExpedienteDocumento>();
      if (!this.expedienteDocumento.contains(newExpedienteDocumento))
         this.expedienteDocumento.add(newExpedienteDocumento);
   }
   
   /** @pdGenerated default remove
     * @param oldExpedienteDocumento */
   public void removeExpedienteDocumento(ExpedienteDocumento oldExpedienteDocumento) {
      if (oldExpedienteDocumento == null)
         return;
      if (this.expedienteDocumento != null)
         if (this.expedienteDocumento.contains(oldExpedienteDocumento))
            this.expedienteDocumento.remove(oldExpedienteDocumento);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllExpedienteDocumento() {
      if (expedienteDocumento != null)
         expedienteDocumento.clear();
   }

}
/***********************************************************************
 * Module:  ExpedientePaso.java
 * Author:  JORGE
 * Purpose: Defines the Class ExpedientePaso
 ***********************************************************************/

import java.util.*;

/** Secuencia de pasos por cada expediente o tramite
 * 
 * @pdOid 44665cf2-cf28-48f6-8a68-025448bcdc41 */
public class ExpedientePaso {
   /** @pdOid 6c7a3373-f58f-4ef9-ac27-bd6c91c64072 */
   private int nsecuencia;
   /** @pdOid a6c3caa7-9944-439f-8a40-42164a658cbd */
   private java.lang.String tipPaso;
   /** @pdOid 70ece057-2fdc-4cb9-ad67-0303d1767cbc */
   private java.util.Date fchPaso;
   /** @pdOid 1ec4e8cc-5c41-4f60-943c-2ae6a633ba2b */
   private java.lang.String periodo;
   
   /** @pdOid cb37e7af-4058-4590-ba00-2c2948684066
       @pdRoleInfo migr=yes name=ExpedienteDocumento assc=Association15 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<ExpedienteDocumento> expedienteDocumento;
   
   
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
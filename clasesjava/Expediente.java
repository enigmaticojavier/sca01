/***********************************************************************
 * Module:  Expediente.java
 * Author:  JORGE
 * Purpose: Defines the Class Expediente
 ***********************************************************************/

import java.util.*;

/** Expediente o tramite
 * 
 * @pdOid 97540528-83b8-4245-80e3-3f0ad345ba18 */
public class Expediente {
   /** @pdOid 11552150-49a0-41a4-ba16-1280623e89d3 */
   private int expId;
   /** @pdOid 0091b489-80b5-404d-95a7-f01b26b8cf20 */
   private java.lang.String numExpediente;
   /** @pdOid d83d8be2-1714-473b-9cd9-a40a1ac6e1e8 */
   private java.util.Date fchExpediente;
   /** @pdOid 5eeb0ddd-a701-4f1a-82d6-ecbab7bfa21c */
   private java.lang.String tipTramite;
   /** @pdOid c15755c6-bcf6-4ec9-84f0-015c6abe019a */
   private java.lang.String clsTipificacion;
   /** @pdOid fa4aa651-3545-4600-af38-bba40e46acc3 */
   private java.lang.String periodo;
   
   /** @pdOid 6a0587b6-9cd3-40d9-8a7b-c3e547f05750
       @pdRoleInfo migr=yes name=ExpedientePaso assc=Association10 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<ExpedientePaso> expedientePaso;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<ExpedientePaso> getExpedientePaso() {
      if (expedientePaso == null)
         expedientePaso = new java.util.HashSet<ExpedientePaso>();
      return expedientePaso;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorExpedientePaso() {
      if (expedientePaso == null)
         expedientePaso = new java.util.HashSet<ExpedientePaso>();
      return expedientePaso.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newExpedientePaso */
   public void setExpedientePaso(java.util.Collection<ExpedientePaso> newExpedientePaso) {
      removeAllExpedientePaso();
      for (java.util.Iterator iter = newExpedientePaso.iterator(); iter.hasNext();)
         addExpedientePaso((ExpedientePaso)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newExpedientePaso */
   public void addExpedientePaso(ExpedientePaso newExpedientePaso) {
      if (newExpedientePaso == null)
         return;
      if (this.expedientePaso == null)
         this.expedientePaso = new java.util.HashSet<ExpedientePaso>();
      if (!this.expedientePaso.contains(newExpedientePaso))
         this.expedientePaso.add(newExpedientePaso);
   }
   
   /** @pdGenerated default remove
     * @param oldExpedientePaso */
   public void removeExpedientePaso(ExpedientePaso oldExpedientePaso) {
      if (oldExpedientePaso == null)
         return;
      if (this.expedientePaso != null)
         if (this.expedientePaso.contains(oldExpedientePaso))
            this.expedientePaso.remove(oldExpedientePaso);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllExpedientePaso() {
      if (expedientePaso != null)
         expedientePaso.clear();
   }

}
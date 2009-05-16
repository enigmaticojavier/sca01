/***********************************************************************
 * Module:  Proyecto.java
 * Author:  JORGE
 * Purpose: Defines the Class Proyecto
 ***********************************************************************/

import java.util.*;

/** Maestro de proyectos o actividades que requieren certificacion ambiental
 * 
 * @pdOid fc53b83a-6006-474d-9240-bec92475f020 */
public class Proyecto {
   /** @pdOid 491eccf5-7b61-48ff-b7b6-77b0925bb7ea */
   private int pryId;
   /** @pdOid 6c159c92-47d3-497b-ae27-9a1e2472dc95 */
   private java.lang.String codProyecto;
   /** @pdOid 8d220e5d-a3b9-454f-900c-7295d09af56c */
   private java.lang.String txtCoordenadas;
   /** @pdOid cfc98976-921e-4d97-ba9b-98de2c57fe92 */
   private java.lang.String clsTipificacion;
   /** @pdOid 0c013a06-596a-43bd-b597-2f6ee7ff6f58 */
   private java.lang.String txtDescripcion;
   /** @pdOid 3838d1c6-e1c0-4cbf-9bc7-80b69a83ce71 */
   private java.lang.Double mnInversion;
   /** @pdOid 3340f8fd-b8bc-4644-bec5-51650446be5d */
   private java.lang.String clsSector;
   /** @pdOid d81e3797-c641-4fec-9c83-27eccb4c3866 */
   private java.lang.String clsSubSector;
   /** @pdOid 25d4f5aa-08b1-4386-b4cb-30f6ecae8e3e */
   private java.util.Date fchExpediente;
   /** @pdOid 1ccc5ee0-fa7b-4da8-b8b0-7eb5154593c5 */
   private java.lang.String periodo;
   
   /** @pdOid 2f94451f-3215-4470-85c6-16020ed4a6a1
       @pdRoleInfo migr=yes name=Expediente assc=Association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Expediente> expediente;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Expediente> getExpediente() {
      if (expediente == null)
         expediente = new java.util.HashSet<Expediente>();
      return expediente;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorExpediente() {
      if (expediente == null)
         expediente = new java.util.HashSet<Expediente>();
      return expediente.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newExpediente */
   public void setExpediente(java.util.Collection<Expediente> newExpediente) {
      removeAllExpediente();
      for (java.util.Iterator iter = newExpediente.iterator(); iter.hasNext();)
         addExpediente((Expediente)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newExpediente */
   public void addExpediente(Expediente newExpediente) {
      if (newExpediente == null)
         return;
      if (this.expediente == null)
         this.expediente = new java.util.HashSet<Expediente>();
      if (!this.expediente.contains(newExpediente))
         this.expediente.add(newExpediente);
   }
   
   /** @pdGenerated default remove
     * @param oldExpediente */
   public void removeExpediente(Expediente oldExpediente) {
      if (oldExpediente == null)
         return;
      if (this.expediente != null)
         if (this.expediente.contains(oldExpediente))
            this.expediente.remove(oldExpediente);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllExpediente() {
      if (expediente != null)
         expediente.clear();
   }

}
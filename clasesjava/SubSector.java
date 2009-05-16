/***********************************************************************
 * Module:  SubSector.java
 * Author:  JORGE
 * Purpose: Defines the Class SubSector
 ***********************************************************************/

import java.util.*;

/** Subclasificacion de las autoridades sectoriales
 * 
 * @pdOid 42929a34-81f3-4010-a385-ec560e2c7fbb */
public class SubSector {
   /** @pdOid 5ef52846-5d6f-46c8-83aa-c7466ec6cb61 */
   private java.lang.String clsSector;
   /** @pdOid e6fd48bc-fb1e-44b6-9ac8-1be15cf36bd4 */
   private java.lang.String clsSubSector;
   /** @pdOid cc16585f-e314-4465-9dba-e73f91d5a5e5 */
   private java.lang.String tipSubSector;
   /** @pdOid bbbe34ba-d10c-42b4-acdf-082b545ef960 */
   private java.lang.String txtSubSector;
   
   /** @pdOid f89b21ab-50af-47ef-894a-f7341c8c8987
       @pdRoleInfo migr=yes name=Acae assc=Association20 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Acae> acae;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Acae> getAcae() {
      if (acae == null)
         acae = new java.util.HashSet<Acae>();
      return acae;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAcae() {
      if (acae == null)
         acae = new java.util.HashSet<Acae>();
      return acae.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAcae */
   public void setAcae(java.util.Collection<Acae> newAcae) {
      removeAllAcae();
      for (java.util.Iterator iter = newAcae.iterator(); iter.hasNext();)
         addAcae((Acae)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAcae */
   public void addAcae(Acae newAcae) {
      if (newAcae == null)
         return;
      if (this.acae == null)
         this.acae = new java.util.HashSet<Acae>();
      if (!this.acae.contains(newAcae))
         this.acae.add(newAcae);
   }
   
   /** @pdGenerated default remove
     * @param oldAcae */
   public void removeAcae(Acae oldAcae) {
      if (oldAcae == null)
         return;
      if (this.acae != null)
         if (this.acae.contains(oldAcae))
            this.acae.remove(oldAcae);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAcae() {
      if (acae != null)
         acae.clear();
   }

}
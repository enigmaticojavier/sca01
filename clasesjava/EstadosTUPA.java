/***********************************************************************
 * Module:  EstadosTUPA.java
 * Author:  JORGE
 * Purpose: Defines the Class EstadosTUPA
 ***********************************************************************/

import java.util.*;

/** Maestro de secuencia de pasos del procedimiento indicando los cambios de estado del expediente o tramite
 * 
 * @pdOid 42e3b66e-60e5-416c-b5a9-211576c574d5 */
public class EstadosTUPA {
   /** @pdOid 09915781-9e3b-4255-a73c-22bc92e923e8 */
   private java.lang.String tipTramite;
   /** @pdOid fe55150c-d1bc-485d-9346-47b1a564f7a5 */
   private int numSecuencia;
   /** @pdOid b239afa2-3458-4e3c-b886-d932b647e464 */
   private java.lang.String tipPaso;
   /** @pdOid 1736fe63-52a2-45f9-86e4-912dee6bfd5f */
   private java.lang.String tipEstadoTramite;
   
   /** @pdRoleInfo migr=no name=EstadosTUPADoc assc=association21 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<EstadosTUPADoc> estadostupadocs;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<EstadosTUPADoc> getEstadostupadocs() {
      if (estadostupadocs == null)
         estadostupadocs = new java.util.HashSet<EstadosTUPADoc>();
      return estadostupadocs;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorEstadostupadocs() {
      if (estadostupadocs == null)
         estadostupadocs = new java.util.HashSet<EstadosTUPADoc>();
      return estadostupadocs.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newEstadostupadocs */
   public void setEstadostupadocs(java.util.Collection<EstadosTUPADoc> newEstadostupadocs) {
      removeAllEstadostupadocs();
      for (java.util.Iterator iter = newEstadostupadocs.iterator(); iter.hasNext();)
         addEstadostupadocs((EstadosTUPADoc)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newEstadosTUPADoc */
   public void addEstadostupadocs(EstadosTUPADoc newEstadosTUPADoc) {
      if (newEstadosTUPADoc == null)
         return;
      if (this.estadostupadocs == null)
         this.estadostupadocs = new java.util.HashSet<EstadosTUPADoc>();
      if (!this.estadostupadocs.contains(newEstadosTUPADoc))
         this.estadostupadocs.add(newEstadosTUPADoc);
   }
   
   /** @pdGenerated default remove
     * @param oldEstadosTUPADoc */
   public void removeEstadostupadocs(EstadosTUPADoc oldEstadosTUPADoc) {
      if (oldEstadosTUPADoc == null)
         return;
      if (this.estadostupadocs != null)
         if (this.estadostupadocs.contains(oldEstadosTUPADoc))
            this.estadostupadocs.remove(oldEstadosTUPADoc);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllEstadostupadocs() {
      if (estadostupadocs != null)
         estadostupadocs.clear();
   }

}
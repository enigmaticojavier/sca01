/***********************************************************************
 * Module:  Proponente.java
 * Author:  JORGE
 * Purpose: Defines the Class Proponente
 ***********************************************************************/

import java.util.*;

/** Personas juridicas que presentan las solicitudes de certificacion ambiental para sus proyectos
 * 
 * @pdOid ab8fe531-22e6-4d93-87e1-bae0dc703587 */
public class Proponente extends Persona {
   /** @pdOid da17a2fd-0069-4c14-8dc6-5b638e89d664 */
   private java.lang.String tipoDocumentoRL;
   /** @pdOid 85633116-5eb5-414f-9bb3-fe132246d5c7 */
   private java.lang.String codDocumentoRL;
   /** @pdOid 236345b9-1a79-4215-b8af-dcda6ec63bb6 */
   private java.lang.String txtNombresRL;
   /** @pdOid 97d3c1f8-5024-4258-aafa-b1221c6f1791 */
   private java.lang.String periodo;
   
   /** @pdOid 70eb95c1-8e05-43be-9b40-b8a61b18a1e5
       @pdRoleInfo migr=yes name=Proyecto assc=Association7 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Proyecto> proyecto;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Proyecto> getProyecto() {
      if (proyecto == null)
         proyecto = new java.util.HashSet<Proyecto>();
      return proyecto;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProyecto() {
      if (proyecto == null)
         proyecto = new java.util.HashSet<Proyecto>();
      return proyecto.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProyecto */
   public void setProyecto(java.util.Collection<Proyecto> newProyecto) {
      removeAllProyecto();
      for (java.util.Iterator iter = newProyecto.iterator(); iter.hasNext();)
         addProyecto((Proyecto)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProyecto */
   public void addProyecto(Proyecto newProyecto) {
      if (newProyecto == null)
         return;
      if (this.proyecto == null)
         this.proyecto = new java.util.HashSet<Proyecto>();
      if (!this.proyecto.contains(newProyecto))
         this.proyecto.add(newProyecto);
   }
   
   /** @pdGenerated default remove
     * @param oldProyecto */
   public void removeProyecto(Proyecto oldProyecto) {
      if (oldProyecto == null)
         return;
      if (this.proyecto != null)
         if (this.proyecto.contains(oldProyecto))
            this.proyecto.remove(oldProyecto);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProyecto() {
      if (proyecto != null)
         proyecto.clear();
   }

}
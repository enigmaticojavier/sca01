/***********************************************************************
 * Module:  Ubigeo.java
 * Author:  JORGE
 * Purpose: Defines the Class Ubigeo
 ***********************************************************************/

import java.util.*;

/** Ubicaciones geograficas
 * 
 * @pdOid ddaeb218-05b7-43b7-9b7a-f1e5ec4f2e7d */
public class Ubigeo {
   /** @pdOid e580793b-3504-4c85-983f-90746941673b */
   private java.lang.String ubigeoId;
   /** @pdOid 20084e87-2f7a-49b1-9f07-948bf8779028 */
   private java.lang.String txtDescripcion;
   /** @pdOid 4bc94f19-3fe1-462e-bcc2-04a7ea416e70 */
   private java.lang.String txtDescripcionLarga;
   
   /** @pdOid aa785665-033a-4632-8413-7aea62a3b77a
       @pdRoleInfo migr=yes name=Persona assc=Association16 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Persona> persona;
   /** @pdOid 3cdcec8b-e89c-4477-8927-b0ece3759d5a
       @pdRoleInfo migr=yes name=Proyecto assc=Association13 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Proyecto> proyecto;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Persona> getPersona() {
      if (persona == null)
         persona = new java.util.HashSet<Persona>();
      return persona;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPersona() {
      if (persona == null)
         persona = new java.util.HashSet<Persona>();
      return persona.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPersona */
   public void setPersona(java.util.Collection<Persona> newPersona) {
      removeAllPersona();
      for (java.util.Iterator iter = newPersona.iterator(); iter.hasNext();)
         addPersona((Persona)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPersona */
   public void addPersona(Persona newPersona) {
      if (newPersona == null)
         return;
      if (this.persona == null)
         this.persona = new java.util.HashSet<Persona>();
      if (!this.persona.contains(newPersona))
         this.persona.add(newPersona);
   }
   
   /** @pdGenerated default remove
     * @param oldPersona */
   public void removePersona(Persona oldPersona) {
      if (oldPersona == null)
         return;
      if (this.persona != null)
         if (this.persona.contains(oldPersona))
            this.persona.remove(oldPersona);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPersona() {
      if (persona != null)
         persona.clear();
   }
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
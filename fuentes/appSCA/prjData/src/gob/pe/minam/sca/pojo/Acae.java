package gob.pe.minam.sca.pojo;

public class Acae extends Persona {
	
	/** @pdOid 3b51f217-98c6-4002-a386-5a881cb21a49 */
	   private java.lang.String tipAcae;
	   /** @pdOid b660a22b-788f-4a39-8173-e4b05499a326 */
	   private java.lang.String tipDocumentoGer;
	   /** @pdOid eccca16c-8343-468b-a476-90d8c9717c67 */
	   private java.lang.String codDocumentoGer;
	   /** @pdOid 085398c2-b81c-4116-9de0-f829118c1955 */
	   private java.lang.String txtApellidosNombres;
	   /** @pdOid 233919f8-5896-40ee-9a7c-164701ca217d */
	   private java.lang.String txtCargo;
	   /** @pdOid 25e9e7e0-6f89-43d6-8cc3-dbc70b11d757 */
	   private java.lang.String telefonoGer;
	   
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

 package gob.pe.minam.sca.pojo;
/***********************************************************************
 * Module:  Proyecto.java
 * Author:  Danny Espíritu
 * Purpose: Define Clase Proyecto
 ***********************************************************************/

import gob.pe.minam.sca.data.ProyectoService;
import gob.pe.minam.sca.data.dao.ProyectoDao;
import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.framework.exception.NegocioException;

import java.io.Serializable;

import java.util.Date;

import java.util.List;


/** Maestro de proyectos o actividades que requieren certificacion ambiental
 */
public class Proyecto implements Serializable{
   
   private Integer pryId;
   private String ubigeoId;
   private Integer personaId;
   private String txtCoordenadas;
   private String clsTipificacion;
   private String txtDescripcion;
   private double mnInversion;
   private String clsSector;
   private String clsSubSector;
   private Date fchExpediente;
   private Proponente proponente;
   private Ubigeo ubigeo;
   
   /*added*/
   private String dscClsTipificacion;
   private String dscClsSector;
   private String dscClsSubSector;
   private String estadoTramite;

   void Proyecto(){
   } 

    public void setTxtCoordenadas(String txtCoordenadas) {
        this.txtCoordenadas = txtCoordenadas;
    }

    public String getTxtCoordenadas() {
        return txtCoordenadas;
    }

    public void setClsTipificacion(String clsTipificacion) {
        this.clsTipificacion = clsTipificacion;
    }

    public String getClsTipificacion() {
        return clsTipificacion;
    }

    public void setTxtDescripcion(String txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public String getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setMnInversion(double mnInversion) {
        this.mnInversion = mnInversion;
    }

    public double getMnInversion() {
        return mnInversion;
    }

    public void setClsSector(String clsSector) {
        this.clsSector = clsSector;
    }

    public String getClsSector() {
        return clsSector;
    }

    public void setClsSubSector(String clsSubSector) {
        this.clsSubSector = clsSubSector;
    }

    public String getClsSubSector() {
        return clsSubSector;
    }

    public void setFchExpediente(Date fchExpediente) {
        this.fchExpediente = fchExpediente;
    }

    public Date getFchExpediente() {
        return fchExpediente;
    }

    public void setUbigeoId(String ubigeoId) {
        this.ubigeoId = ubigeoId;
    }

    public String getUbigeoId() {
        return ubigeoId;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }
    
    public void setPryId(Integer pryId) {
        this.pryId = pryId;
    }

    public Integer getPryId() {
        return pryId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public Integer getPersonaId() {
        return personaId;
    }
    
    public void setDscClsTipificacion(String dscClsTipificacion) {
        this.dscClsTipificacion = dscClsTipificacion;
    }

    public String getDscClsTipificacion() {
        return dscClsTipificacion;
    }
    
    public void setProponente(Proponente proponente) {
        this.proponente = proponente;
    }

    public Proponente getProponente() {
        return proponente;
    }
    
    public void setDscClsSector(String dscClsSector) {
        this.dscClsSector = dscClsSector;
    }

    public String getDscClsSector() {
        return dscClsSector;
    }

    public void setDscClsSubSector(String dscClsSubSector) {
        this.dscClsSubSector = dscClsSubSector;
    }

    public String getDscClsSubSector() {
        return dscClsSubSector;
    }
    
    public void setEstadoTramite(String estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    public String getEstadoTramite() {
        return estadoTramite;
    }
    
    public static List buscarProyecto(String txtDescripcion,/*nombreProyecto*/ String ubigeoId, /*departamento*/
                                      String clsTipificacion,/*categoria*/ Date fchExpedienteDesde, /*Fecha de Presentación Desde*/
                                      Date fchExpedienteHasta,/*Fecha de Presentación Desde*/ String estadoTramite, /*Estado Tramite*/
                                      String tipoAcae, String clsSector, /*Institución*/ String clsSubSector /*Dependencia*/) throws NegocioException{
       try{  
         ProyectoDao proyectoDao = ProyectoService.getInstance().getProyectoDao();
         return proyectoDao.buscarProyecto( txtDescripcion, ubigeoId, clsTipificacion, fchExpedienteDesde,
                                            fchExpedienteHasta, estadoTramite, 
                                            tipoAcae, clsSector, clsSubSector);
       }catch(DAOException ex){
         throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
       }catch(Exception ex){
         throw new NegocioException(ex.toString(),"Error producido en Pojo");
       }
    }
    
    public static Proyecto obtenerProyecto(Integer pryId) throws NegocioException{
       try{
         ProyectoDao proyectoDao = ProyectoService.getInstance().getProyectoDao();
         Proyecto pry = proyectoDao.ObtenerProyecto(pryId);
         SubSector sub = new SubSector();
         sub = sub.buscarSubsector(pry.getClsSector(),pry.getClsSubSector());
         pry.setDscClsSector(sub.getDscClsSector());
         pry.setDscClsSubSector(sub.getTxtSubSector());
         return pry;
       }catch(DAOException ex){
         throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
       }catch(Exception ex){
         throw new NegocioException(ex.toString(),"Error producido en Pojo");
       }
    }

}

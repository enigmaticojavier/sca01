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
   
   private int pryId;
   private String ubigeoId;
   private int personaId;
   private String txtCoordenadas;
   private String clsTipificacion;
   private String txtDescripcion;
   private double mnInversion;
   private String clsSector;
   private String clsSubSector;
   private Date fchExpediente;
   private Persona persona;
   
   /*added*/
   private String dscTipificacion;

   void Proyecto(int pryId, String ubigeoId, int personaId, 
                 String txtCoordenadas, String clsTipificacion, String txtDescripcion, 
                 double mnInversion, String clsSector, String clsSubSector){
     this.pryId=pryId;
     this.ubigeoId=ubigeoId;
     this.personaId=personaId;
     this.txtCoordenadas=txtCoordenadas;
     this.clsTipificacion=clsTipificacion;
     this.txtDescripcion=txtDescripcion;
     this.mnInversion=mnInversion; 
     this.clsSector=clsSector; 
     this.clsSubSector=clsSubSector;
   } 

    public void setPryId(int pryId) {
        this.pryId = pryId;
    }

    public int getPryId() {
        return pryId;
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

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public int getPersonaId() {
        return personaId;
    }
    
    public void setDscTipificacion(String dscTipificacion) {
        this.dscTipificacion = dscTipificacion;
    }

    public String getDscTipificacion() {
        return dscTipificacion;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }
    
    public static List buscarProyecto(String txtDescripcion,/*nombreProyecto*/ String ubigeoId, /*departamento*/
                                      String clsTipificacion,/*categoria*/ Date fchExpedienteDesde, /*Fecha de Presentación Desde*/
                                      Date fchExpedienteHasta,/*Fecha de Presentación Desde*/ String estadoTramite, /*Estado Tramite*/
                                      String clsSector, /*Institución*/ String clsSubSector /*Dependencia*/) throws NegocioException{
       try{  
         ProyectoDao proyectoDao = ProyectoService.getInstance().getProyectoDao();
         return proyectoDao.buscarProyecto( txtDescripcion, ubigeoId, clsTipificacion, fchExpedienteDesde,
                                            fchExpedienteHasta, estadoTramite, 
                                            clsSector, clsSubSector);
       }catch(DAOException ex){
         throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
       }catch(Exception ex){
         throw new NegocioException(ex.toString(),"Error producido en Pojo");
       }
    }

}

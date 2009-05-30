/***********************************************************************
 * Module:  Proyecto.java
 * Author:  Danny Espíritu
 * Purpose: Define Clase Ubigeo
 ***********************************************************************/
package gob.pe.minam.sca.pojo;

import gob.pe.minam.sca.data.ProyectoService;
import gob.pe.minam.sca.data.dao.ParametroDao;
import gob.pe.minam.sca.data.dao.UbigeoDao;
import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.framework.exception.NegocioException;

import java.io.Serializable;

import java.util.List;

public class Ubigeo implements Serializable{
    String ubigeoId;
    String txtDescripcion;
    String txtDescripcionLarga;
    
    public Ubigeo() {
    }

    public void setUbigeoId(String ubigeoId) {
        this.ubigeoId = ubigeoId;
    }

    public String getUbigeoId() {
        return ubigeoId;
    }

    public void setTxtDescripcion(String txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public String getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcionLarga(String txtDescripcionLarga) {
        this.txtDescripcionLarga = txtDescripcionLarga;
    }

    public String getTxtDescripcionLarga() {
        return txtDescripcionLarga;
    }
    
    public static List listarDepartamento() throws NegocioException{
       try{  
         UbigeoDao ubigeoDao = ProyectoService.getInstance().getUbigeoDao();
         return ubigeoDao.listarDepartamento();
       }catch(DAOException ex){
         throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
       }catch(Exception ex){
         throw new NegocioException(ex.toString(),"Error producido en Pojo");
       }
    }
}

/***********************************************************************
 * Module:  Parametro.java
 * Author:  Danny Espíritu
 * Purpose: Define la Clase Parametro
 ***********************************************************************/
package gob.pe.minam.sca.pojo;
import gob.pe.minam.sca.data.ProyectoService;
import gob.pe.minam.sca.data.dao.ParametroDao;

import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.framework.exception.NegocioException;

import java.io.Serializable;

import java.util.*;

public class Parametro implements Serializable{
    private Integer idParametro;
    private String tipParametro;
    private String txtParametro;
    private String codParametro;
    private String txtValor;
    
    public void Parametro(Integer idParametro, String tipParametro, String txtParametro,
                          String codParametro, String txtValor){
      this.idParametro=idParametro;
      this.tipParametro=tipParametro;
      this.txtParametro=txtParametro;
      this.codParametro=codParametro;
      this.txtValor=txtValor;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setTipParametro(String tipParametro) {
        this.tipParametro = tipParametro;
    }

    public String getTipParametro() {
        return tipParametro;
    }

    public void setTxtParametro(String txtParametro) {
        this.txtParametro = txtParametro;
    }

    public String getTxtParametro() {
        return txtParametro;
    }

    public void setCodParametro(String codParametro) {
        this.codParametro = codParametro;
    }

    public String getCodParametro() {
        return codParametro;
    }

    public void setTxtValor(String txtValor) {
        this.txtValor = txtValor;
    }

    public String getTxtValor() {
        return txtValor;
    }
    
    public static Parametro obtenerParametro(int idParametro) throws NegocioException{
       try{  
         
         ParametroDao parametroDao = ProyectoService.getInstance().getParametroDao();
         return parametroDao.getParametro(idParametro);
       }catch(DAOException ex){
         throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
       }catch(Exception ex){
         throw new NegocioException(ex.toString(),"Error producido en Pojo");
       }
    }
    
    public static List listarTipoParametro() throws NegocioException{
       try{  
         ParametroDao parametroDao = ProyectoService.getInstance().getParametroDao();
         return parametroDao.listarTipoParametro();
       }catch(DAOException ex){
         throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
       }catch(Exception ex){
         throw new NegocioException(ex.toString(),"Error producido en Pojo");
       }
    }
    
    public static List buscarParametroXTipoParametro(String tipParametro) throws NegocioException{
       try{  
         ParametroDao parametroDao = ProyectoService.getInstance().getParametroDao();
         return parametroDao.findParametroXTipoParametro(tipParametro);
       }catch(DAOException ex){
         throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
       }catch(Exception ex){
         throw new NegocioException(ex.toString(),"Error producido en Pojo");
       }
    }
    
    public static Parametro buscarParametroXParametro(String tipParametro, String codParametro) throws NegocioException{
       try{  
         ParametroDao parametroDao = ProyectoService.getInstance().getParametroDao();
         return parametroDao.findParametroXParametro(tipParametro,codParametro);
       }catch(DAOException ex){
         throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
       }catch(Exception ex){
         throw new NegocioException(ex.toString(),"Error producido en Pojo");
       }
    }
    
    
    public static void insertParametro(Parametro parametro) throws NegocioException{
        try{  
          ParametroDao parametroDao = ProyectoService.getInstance().getParametroDao();
          parametroDao.insertParametro(parametro);
        }catch(DAOException ex){
          throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
        }catch(Exception ex){
          throw new NegocioException(ex.toString(),"Error producido en Pojo");
        }
    }
    
    public static void updateParametro(Parametro parametro) throws NegocioException{
        try{  
          ParametroDao parametroDao = ProyectoService.getInstance().getParametroDao();
          parametroDao.updateParametro(parametro);
        }catch(DAOException ex){
          throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
        }catch(Exception ex){
          throw new NegocioException(ex.toString(),"Error producido en Pojo");
        }
    }
    
    public static void deleteParametro(int idParametro) throws NegocioException{
        try{  
          ParametroDao parametroDao = ProyectoService.getInstance().getParametroDao();
          parametroDao.deleteParametro(idParametro);
        }catch(DAOException ex){
          throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
        }catch(Exception ex){
          throw new NegocioException(ex.toString(),"Error producido en Pojo");
        }
    }
    
}

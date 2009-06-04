/***********************************************************************
 * Module:  Proyecto.java
 * Author:  Danny Espíritu
 * Purpose: Define Clase SubSector
 ***********************************************************************/

package gob.pe.minam.sca.pojo;

import gob.pe.minam.sca.data.ProyectoService;
import gob.pe.minam.sca.data.dao.ParametroDao;
import gob.pe.minam.sca.data.dao.SubSectorDao;
import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.framework.exception.NegocioException;

import java.io.Serializable;

import java.util.List;

public class SubSector implements Serializable{
    private String clsSector;
    private String clsSubSector;
    private String tipSubSector;
    private String txtSubSector;
    /*added*/
    private String dscClsSector;
    
    public SubSector() {
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

    public void setTipSubSector(String tipSubSector) {
        this.tipSubSector = tipSubSector;
    }

    public String getTipSubSector() {
        return tipSubSector;
    }

    public void setTxtSubSector(String txtSubSector) {
        this.txtSubSector = txtSubSector;
    }

    public String getTxtSubSector() {
        return txtSubSector;
    }
    
    public void setDscClsSector(String dscClsSector) {
        this.dscClsSector = dscClsSector;
    }

    public String getDscClsSector() {
        return dscClsSector;
    }
    
    public static List buscarSubsectorXSector(String sector) throws NegocioException{
       try{  
         SubSectorDao subSectorDao = ProyectoService.getInstance().getSubSectorDao();
         return subSectorDao.buscarSubSectorXSector(sector);
       }catch(DAOException ex){
         throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
       }catch(Exception ex){
         throw new NegocioException(ex.toString(),"Error producido en Pojo");
       }
    }
    
    public static SubSector buscarSubsector(String sector, String subsector) throws NegocioException{
       try{  
         SubSector s = new SubSector();
         s.setClsSector(sector);
         s.setClsSubSector(subsector);
         SubSectorDao subSectorDao = ProyectoService.getInstance().getSubSectorDao();
         return subSectorDao.obtenerSubsector(s);
       }catch(DAOException ex){
         throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
       }catch(Exception ex){
         throw new NegocioException(ex.toString(),"Error producido en Pojo");
       }
    }

}

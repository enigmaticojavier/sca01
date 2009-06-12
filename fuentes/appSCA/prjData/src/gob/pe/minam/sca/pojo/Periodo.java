package gob.pe.minam.sca.pojo;

import gob.pe.minam.sca.data.ProyectoService;
import gob.pe.minam.sca.data.dao.PeriodoDao;
import gob.pe.minam.sca.data.dao.ProyectoDao;
import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.framework.exception.NegocioException;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class Periodo implements Serializable {
    private int anio;
    private int mes;
    private int perActual;
    private int estado;
    private String periodo;

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getAnio() {
        return anio;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getMes() {
        return mes;
    }

    public void setPerActual(int perActual) {
        this.perActual = perActual;
    }

    public int getPerActual() {
        return perActual;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }
    
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return periodo;
    }
    
    public List listarPeriodo() throws NegocioException{
       try{  
         PeriodoDao periodoDao = ProyectoService.getInstance().getPeriodoDao();
         return periodoDao.listarPeriodo();
       }catch(DAOException ex){
         throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
       }catch(Exception ex){
         throw new NegocioException(ex.toString(),"Error producido en Pojo");
       }
    }
    
    public List listarPeriodoReporte() throws NegocioException{
       try{  
         PeriodoDao periodoDao = ProyectoService.getInstance().getPeriodoDao();
         return periodoDao.listarPeriodoReporte();
       }catch(DAOException ex){
         throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
       }catch(Exception ex){
         throw new NegocioException(ex.toString(),"Error producido en Pojo");
       }
    }

    
}

package gob.pe.minam.sca.pojo;

import gob.pe.minam.sca.data.ProyectoService;
import gob.pe.minam.sca.data.dao.ControlEnvioDao;
import gob.pe.minam.sca.data.dao.ExpedienteDao;
import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.framework.exception.NegocioException;

import java.util.Date;

public class ControlEnvio {
    String periodo;
    int personaId;
    String flgEnvioPro;
    Date fchEnvioPro;
    String flgEnvioPry;
    Date fchEnvioPry;
    String flgEnvioExp;
    Date fchEnvioExp;
        
    public ControlEnvio() {
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setFlgEnvioPro(String flgEnvioPro) {
        this.flgEnvioPro = flgEnvioPro;
    }

    public String getFlgEnvioPro() {
        return flgEnvioPro;
    }

    public void setFchEnvioPro(Date fchEnvioPro) {
        this.fchEnvioPro = fchEnvioPro;
    }

    public Date getFchEnvioPro() {
        return fchEnvioPro;
    }

    public void setFlgEnvioPry(String flgEnvioPry) {
        this.flgEnvioPry = flgEnvioPry;
    }

    public String getFlgEnvioPry() {
        return flgEnvioPry;
    }

    public void setFchEnvioPry(Date fchEnvioPry) {
        this.fchEnvioPry = fchEnvioPry;
    }

    public Date getFchEnvioPry() {
        return fchEnvioPry;
    }

    public void setFlgEnvioExp(String flgEnvioExp) {
        this.flgEnvioExp = flgEnvioExp;
    }

    public String getFlgEnvioExp() {
        return flgEnvioExp;
    }

    public void setFchEnvioExp(Date fchEnvioExp) {
        this.fchEnvioExp = fchEnvioExp;
    }

    public Date getFchEnvioExp() {
        return fchEnvioExp;
    }
    
    public ControlEnvio obtenerControlEnvioXPeriodo(String periodo) throws NegocioException{
        try{
          ControlEnvioDao controlEnvioDao = ProyectoService.getInstance().getControlEnvioDao();
          return controlEnvioDao.obtenerControlEnvioXPeriodo(periodo);
        }catch(DAOException ex){
          throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
        }catch(Exception ex){
          throw new NegocioException(ex.toString(),"Error producido en Pojo");
        }    
    }
    
}

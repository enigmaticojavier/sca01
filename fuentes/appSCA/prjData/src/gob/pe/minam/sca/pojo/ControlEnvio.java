package gob.pe.minam.sca.pojo;

import gob.pe.minam.sca.data.ProyectoService;
import gob.pe.minam.sca.data.dao.ControlEnvioDao;
import gob.pe.minam.sca.data.dao.ExpedienteDao;
import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.framework.exception.NegocioException;

import java.util.Date;

public class ControlEnvio {
    private String periodo;
    private int personaId;
    private String estEnvioPro;
    private Date fchEnvioPro;
    private String estEnvioPry;
    private Date fchEnvioPry;
    private String estEnvioExp;
    private Date fchEnvioExp;
        
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

    public void setFchEnvioPro(Date fchEnvioPro) {
        this.fchEnvioPro = fchEnvioPro;
    }

    public Date getFchEnvioPro() {
        return fchEnvioPro;
    }

    public void setFchEnvioPry(Date fchEnvioPry) {
        this.fchEnvioPry = fchEnvioPry;
    }

    public Date getFchEnvioPry() {
        return fchEnvioPry;
    }

    public void setFchEnvioExp(Date fchEnvioExp) {
        this.fchEnvioExp = fchEnvioExp;
    }

    public Date getFchEnvioExp() {
        return fchEnvioExp;
    }
    
    public void setEstEnvioPro(String estEnvioPro) {
        this.estEnvioPro = estEnvioPro;
    }

    public String getEstEnvioPro() {
        return estEnvioPro;
    }

    public void setEstEnvioPry(String estEnvioPry) {
        this.estEnvioPry = estEnvioPry;
    }

    public String getEstEnvioPry() {
        return estEnvioPry;
    }

    public void setEstEnvioExp(String estEnvioExp) {
        this.estEnvioExp = estEnvioExp;
    }

    public String getEstEnvioExp() {
        return estEnvioExp;
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
    
    public void guardarControlEnvio(ControlEnvio controlEnvio) throws NegocioException{
        try{
            System.out.println("periodo1-->" + controlEnvio.getPeriodo());
            ControlEnvioDao controlEnvioDao = ProyectoService.getInstance().getControlEnvioDao();
            boolean existe = controlEnvioDao.existeControlEnvio(controlEnvio.getPeriodo());
            System.out.println("periodo2-->" + controlEnvio.getPeriodo());
            System.out.println("existe-->" + existe  );
            if (existe){
                controlEnvioDao.updateControlEnvio(controlEnvio);            
            }else{
                controlEnvioDao.insertControlEnvio(controlEnvio);
            }
        }catch(DAOException ex){
          throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
        }catch(Exception ex){
          throw new NegocioException(ex.toString(),"Error producido en Pojo");
        }
    }
    
}

/***********************************************************************
 * Module:  Expediente.java
 * Author:  Danny Espíritu
 * Purpose: Define Clase Expediente
 ***********************************************************************/
package gob.pe.minam.sca.pojo;

import gob.pe.minam.sca.data.ProyectoService;
import gob.pe.minam.sca.data.dao.ExpedienteDao;
import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.framework.exception.NegocioException;

import gob.pe.minam.sca.vo.EstadisticaVo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Expediente {
    private Integer expId;
    private Integer pryId;
    private Integer personaId;
    private String numExpediente;
    private Date fchExpediente;
    private String tipTramite;
    private String clsTipificacion;
    
    private Proyecto proyecto;
    private Acae acae;
     
    public Expediente() {
    }

    public void setExpId(Integer expId) {
        this.expId = expId;
    }

    public Integer getExpId() {
        return expId;
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

    public void setNumExpediente(String numExpediente) {
        this.numExpediente = numExpediente;
    }

    public String getNumExpediente() {
        return numExpediente;
    }

    public void setFchExpediente(Date fchExpediente) {
        this.fchExpediente = fchExpediente;
    }

    public Date getFchExpediente() {
        return fchExpediente;
    }

    public void setTipTramite(String tipTramite) {
        this.tipTramite = tipTramite;
    }

    public String getTipTramite() {
        return tipTramite;
    }

    public void setClsTipificacion(String clsTipificacion) {
        this.clsTipificacion = clsTipificacion;
    }

    public String getClsTipificacion() {
        return clsTipificacion;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setAcae(Acae acae) {
        this.acae = acae;
    }

    public Acae getAcae() {
        return acae;
    }
    
    public List listarEstadistica(String tipAcae, String periodo) throws NegocioException{
        try{
            int evaluacion,aprobado, desaprobado, anulado, desistido, todos;
            evaluacion=aprobado=desaprobado=anulado=desistido=todos=0;
            ExpedienteDao expedienteDao = ProyectoService.getInstance().getExpedienteDao();
            List lstEstadistica = expedienteDao.listarEstadistica(tipAcae, periodo);
            String tmpClsSector="", tmpClsTipificacion="", tmpDscClsSector="", tmpDscClsTipificacion="", tmpActividad="";
            EstadisticaVo estRes = null;
            List lstEstRes = new ArrayList();
            for (int i=0;i<lstEstadistica.size();i++){
                EstadisticaVo est = (EstadisticaVo)lstEstadistica.get(i);
                if (i==0){
                    tmpClsSector=est.getClsSector();
                    tmpClsTipificacion=est.getClsTipificacion();
                    tmpDscClsSector=est.getDscClsSector();
                    tmpDscClsTipificacion=est.getDscClsTipificacion();
                    tmpActividad=est.getActividad();
                }
                System.out.println("tmpClsSector " + tmpClsSector + " tmpClsTipificacion " + tmpClsTipificacion + " tmpDscClsSector " + tmpDscClsSector + " tmpDscClsTipificacion " + tmpDscClsTipificacion);
                System.out.println("est.getClsSector() " + est.getClsSector() + " est.getClsTipificacion() " + est.getClsTipificacion() + " est.getTipEstadoTramite() " + est.getTipEstadoTramite());
                if ( tmpClsSector.equals(est.getClsSector()) && tmpClsTipificacion.equals(est.getClsTipificacion()) ){
                    if (est.getTipEstadoTramite().equals("EVA")){
                        evaluacion+=est.getContExp(); 
                    }else if (est.getTipEstadoTramite().equals("APR")){
                        aprobado+=est.getContExp();
                    }else if (est.getTipEstadoTramite().equals("NAP")){
                        desaprobado+=est.getContExp();
                    }else if (est.getTipEstadoTramite().equals("ANU")){
                        anulado+=est.getContExp();
                    }else if (est.getTipEstadoTramite().equals("DES")){
                        desistido+=est.getContExp();
                    }
                }else{
                    estRes = new EstadisticaVo();
                    estRes.setClsSector(tmpClsSector);
                    estRes.setClsTipificacion(tmpClsTipificacion);
                    estRes.setDscClsSector(tmpDscClsSector);
                    estRes.setDscClsTipificacion(tmpDscClsTipificacion);
                    estRes.setActividad(tmpActividad);
                    estRes.setEvaluacion(evaluacion);
                    estRes.setAprobado(aprobado);
                    estRes.setDesaprobado(desaprobado);
                    estRes.setAnulado(anulado);
                    estRes.setDesistido(desistido);
                    System.out.println("Insertando1----->");
                    estRes.setTotal(estRes.getEvaluacion()+estRes.getAprobado()+estRes.getDesaprobado()+estRes.getAnulado()+estRes.getDesistido());
                    lstEstRes.add(estRes);
                    tmpClsSector=est.getClsSector();
                    tmpClsTipificacion=est.getClsTipificacion();
                    tmpDscClsSector=est.getDscClsSector();
                    tmpDscClsTipificacion=est.getDscClsTipificacion();
                    evaluacion=aprobado=desaprobado=anulado=desistido=todos=0; 
                    if (est.getTipEstadoTramite().equals("EVA")){
                        evaluacion+=est.getContExp(); 
                    }else if (est.getTipEstadoTramite().equals("APR")){
                        aprobado+=est.getContExp();
                    }else if (est.getTipEstadoTramite().equals("NAP")){
                        desaprobado+=est.getContExp();
                    }else if (est.getTipEstadoTramite().equals("ANU")){
                        anulado+=est.getContExp();
                    }else if (est.getTipEstadoTramite().equals("DES")){
                        desistido+=est.getContExp();
                    }
                }
                if ( (i==0 && i==lstEstadistica.size()-1) || i==lstEstadistica.size()-1 ){
                    estRes = new EstadisticaVo();
                    estRes.setClsSector(tmpClsSector);
                    estRes.setClsTipificacion(tmpClsTipificacion);
                    estRes.setDscClsSector(tmpDscClsSector);
                    estRes.setDscClsTipificacion(tmpDscClsTipificacion);
                    estRes.setActividad(tmpActividad);
                    estRes.setEvaluacion(evaluacion);
                    estRes.setAprobado(aprobado);
                    estRes.setDesaprobado(desaprobado);
                    estRes.setAnulado(anulado);
                    estRes.setDesistido(desistido);
                    estRes.setTotal(estRes.getEvaluacion()+estRes.getAprobado()+estRes.getDesaprobado()+estRes.getAnulado()+estRes.getDesistido());
                    System.out.println("Insertando2----->");
                    lstEstRes.add(estRes);
                }
            }
            todos=evaluacion+aprobado+desaprobado+anulado+desistido;
            return lstEstRes;
        }catch(DAOException ex){
          throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
        }catch(Exception ex){
          throw new NegocioException(ex.toString(),"Error producido en Pojo");
        }    
    }
    
}

package gob.pe.minam.sca.pojo;

import java.util.Date;

public class Expediente {
    private Integer expId;
    private Integer pryId;
    private Integer personaId;
    private String numExpediente;
    private Date fchExpediente;
    private String tipTramite;
    private String clsTipificacion;
     
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
}

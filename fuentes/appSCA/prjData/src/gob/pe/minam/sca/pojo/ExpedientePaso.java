/***********************************************************************
 * Module:  Proyecto.java
 * Author:  Danny Espíritu
 * Purpose: Define Clase ExpedientePaso
 ***********************************************************************/
package gob.pe.minam.sca.pojo;

import java.util.Date;

public class ExpedientePaso {
   private Integer nsecuencia;
   private String tipPaso;
   private Date fchPaso;
   private String periodo;
   private Expediente expediente;
   
   //added
    private String dscTipPaso;

    public void setTipPaso(String tipPaso) {
        this.tipPaso = tipPaso;
    }

    public String getTipPaso() {
        return tipPaso;
    }

    public void setFchPaso(Date fchPaso) {
        this.fchPaso = fchPaso;
    }

    public Date getFchPaso() {
        return fchPaso;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setNsecuencia(Integer nsecuencia) {
        this.nsecuencia = nsecuencia;
    }

    public Integer getNsecuencia() {
        return nsecuencia;
    }

    public void setDscTipPaso(String dscTipPaso) {
        this.dscTipPaso = dscTipPaso;
    }

    public String getDscTipPaso() {
        return dscTipPaso;
    }
}

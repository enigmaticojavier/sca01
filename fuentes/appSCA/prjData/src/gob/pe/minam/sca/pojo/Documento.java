/***********************************************************************
 * Module:  Proyecto.java
 * Author:  Danny Espíritu
 * Purpose: Define Clase Documento
 ***********************************************************************/
package gob.pe.minam.sca.pojo;
import java.util.*;
public class Documento {
    public Documento() {
    }
    private Integer docId;
    private String tipoDocumento;
    private String codDocumento;
    private Date fchExpedicion;
    private Date fchPresentacion;
    private String periodo;
    private String dscTipoDocumento;
    private List lstImagenDocumento;
    
    
    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setCodDocumento(String codDocumento) {
        this.codDocumento = codDocumento;
    }

    public String getCodDocumento() {
        return codDocumento;
    }

    public void setFchExpedicion(Date fchExpedicion) {
        this.fchExpedicion = fchExpedicion;
    }

    public Date getFchExpedicion() {
        return fchExpedicion;
    }

    public void setFchPresentacion(Date fchPresentacion) {
        this.fchPresentacion = fchPresentacion;
    }

    public Date getFchPresentacion() {
        return fchPresentacion;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setDscTipoDocumento(String dscTipoDocumento) {
        this.dscTipoDocumento = dscTipoDocumento;
    }

    public String getDscTipoDocumento() {
        return dscTipoDocumento;
    }

    public void setLstImagenDocumento(List lstImagenDocumento) {
        this.lstImagenDocumento = lstImagenDocumento;
    }

    public List getLstImagenDocumento() {
        return lstImagenDocumento;
    }
}

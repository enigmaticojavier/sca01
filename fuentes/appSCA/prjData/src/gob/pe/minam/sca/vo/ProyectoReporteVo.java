package gob.pe.minam.sca.vo;

import java.io.Serializable;

import java.util.List;

public class ProyectoReporteVo implements Serializable {
    
    private String clsTipificacion;
    private String estadoTramite;
    private String tipoPersoneria;
    private String proponente;
    private String tipoAcae;
    private String clsSector;
    private String clsSubSector;
    private String codDepartamento;
    private String codProvincia;
    private String codDistrito;
    private String tipoDoc;
    private String anoPeriodo;
    
    
    private List lstResumen;
    
    public ProyectoReporteVo() {
    }

    public void setLstResumen(List lstResumen) {
        this.lstResumen = lstResumen;
    }

    public List getLstResumen() {
        return lstResumen;
    }

    public void setClsTipificacion(String clsTipificacion) {
        this.clsTipificacion = clsTipificacion;
    }

    public String getClsTipificacion() {
        return clsTipificacion;
    }

    public void setEstadoTramite(String estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    public String getEstadoTramite() {
        return estadoTramite;
    }

    public void setTipoPersoneria(String tipoPersoneria) {
        this.tipoPersoneria = tipoPersoneria;
    }

    public String getTipoPersoneria() {
        return tipoPersoneria;
    }

    public void setProponente(String proponente) {
        this.proponente = proponente;
    }

    public String getProponente() {
        return proponente;
    }

    public void setTipoAcae(String tipoAcae) {
        this.tipoAcae = tipoAcae;
    }

    public String getTipoAcae() {
        return tipoAcae;
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

    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setCodDistrito(String codDistrito) {
        this.codDistrito = codDistrito;
    }

    public String getCodDistrito() {
        return codDistrito;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }


    public void setAnoPeriodo(String anoPeriodo) {
        this.anoPeriodo = anoPeriodo;
    }

    public String getAnoPeriodo() {
        return anoPeriodo;
    }
}

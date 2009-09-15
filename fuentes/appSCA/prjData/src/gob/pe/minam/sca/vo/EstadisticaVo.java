package gob.pe.minam.sca.vo;

import java.io.Serializable;

public class EstadisticaVo implements Serializable{
    private String tipAcae;
    private String periodo;
    private String clsSector;
    private String clsTipificacion;
    private String dscClsSector; /*Sector*/
    private String dscClsTipificacion; /*Tipo Estudio*/
    private String tipEstadoTramite;
    private int contExp;
    private int evaluacion;
    private int aprobado;
    private int desaprobado;
    private int anulado;
    private int desistido;
    private int total;
    private String actividad;

    public void setClsSector(String clsSector) {
        this.clsSector = clsSector;
    }

    public String getClsSector() {
        return clsSector;
    }

    public void setClsTipificacion(String clsTipificacion) {
        this.clsTipificacion = clsTipificacion;
    }

    public String getClsTipificacion() {
        return clsTipificacion;
    }

    public void setDscClsSector(String dscClsSector) {
        this.dscClsSector = dscClsSector;
    }

    public String getDscClsSector() {
        return dscClsSector;
    }

    public void setDscClsTipificacion(String dscClsTipificacion) {
        this.dscClsTipificacion = dscClsTipificacion;
    }

    public String getDscClsTipificacion() {
        return dscClsTipificacion;
    }

    public void setEvaluacion(int evaluacion) {
        this.evaluacion = evaluacion;
    }

    public int getEvaluacion() {
        return evaluacion;
    }

    public void setAprobado(int aprobado) {
        this.aprobado = aprobado;
    }

    public int getAprobado() {
        return aprobado;
    }

    public void setDesaprobado(int desaprobado) {
        this.desaprobado = desaprobado;
    }

    public int getDesaprobado() {
        return desaprobado;
    }

    public void setAnulado(int anulado) {
        this.anulado = anulado;
    }

    public int getAnulado() {
        return anulado;
    }

    public void setDesistido(int desistido) {
        this.desistido = desistido;
    }

    public int getDesistido() {
        return desistido;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setTipEstadoTramite(String tipEstadoTramite) {
        this.tipEstadoTramite = tipEstadoTramite;
    }

    public String getTipEstadoTramite() {
        return tipEstadoTramite;
    }

    public void setContExp(int contExp) {
        this.contExp = contExp;
    }

    public int getContExp() {
        return contExp;
    }

    public void setTipAcae(String tipAcae) {
        this.tipAcae = tipAcae;
    }

    public String getTipAcae() {
        return tipAcae;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getActividad() {
        return actividad;
    }
}

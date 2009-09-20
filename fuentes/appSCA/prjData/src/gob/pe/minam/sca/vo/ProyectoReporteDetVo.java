package gob.pe.minam.sca.vo;

import java.io.Serializable;

public class ProyectoReporteDetVo implements Serializable {
    private int contador;
    private String razonSocial;
    
    
    public ProyectoReporteDetVo() {
    }
    
    public ProyectoReporteDetVo(int contador, String razonSocial) {
        this.contador = contador;
        this.razonSocial = razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }
}

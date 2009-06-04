package gob.pe.minam.sca.pojo;

import java.io.Serializable;

public class Proponente implements Serializable{
    private Persona persona;
    private String tipoDocumentoRl;
    private String codDocumentoRl;
    private String txtNombresRl;
    private String periodo;
    
    public Proponente() {
    }

    public void setTipoDocumentoRl(String tipoDocumentoRl) {
        this.tipoDocumentoRl = tipoDocumentoRl;
    }

    public String getTipoDocumentoRl() {
        return tipoDocumentoRl;
    }

    public void setCodDocumentoRl(String codDocumentoRl) {
        this.codDocumentoRl = codDocumentoRl;
    }

    public String getCodDocumentoRl() {
        return codDocumentoRl;
    }

    public void setTxtNombresRl(String txtNombresRl) {
        this.txtNombresRl = txtNombresRl;
    }

    public String getTxtNombresRl() {
        return txtNombresRl;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }
}

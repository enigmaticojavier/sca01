package gob.pe.minam.sca.util.bean;

import java.io.InputStream;

import java.io.Serializable;

import java.util.Iterator;
import java.util.List;

public class BeanRetornoData implements Serializable {
    
    private int codError;
    private String dscError;

    public void setCodError(int codError) {
        this.codError = codError;
    }

    public int getCodError() {
        return codError;
    }

    public void setDscError(String dscError) {
        this.dscError = dscError;
    }

    public String getDscError() {
        return dscError;
    }
}

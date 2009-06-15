package gob.pe.minam.sca.util.bean;

import java.io.InputStream;

import java.io.Serializable;

import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class BeanRetorno implements Serializable {
    
    private int codError;
    private String dscError;
    private List lstError;
    private List lstData;
    private String texto;
    private InputStream inputStream;
    private HSSFWorkbook workBook;
    private Iterator<HSSFRow> rows;
    
    public BeanRetorno() {
    }

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

    public void setLstError(List lstError) {
        this.lstError = lstError;
    }

    public List getLstError() {
        return lstError;
    }

    public void setLstData(List lstData) {
        this.lstData = lstData;
    }

    public List getLstData() {
        return lstData;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setWorkBook(HSSFWorkbook workBook) {
        this.workBook = workBook;
    }

    public HSSFWorkbook getWorkBook() {
        return workBook;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setRows(Iterator<HSSFRow> rows) {
        this.rows = rows;
    }

    public Iterator<HSSFRow> getRows() {
        return rows;
    }
}

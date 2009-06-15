/***********************************************************************
 * Module:  ExcelGenerador.java
 * Author:  Danny Espíritu
 * Purpose: ExcelGenerador
 ***********************************************************************/
package gob.pe.minam.sca.util.excel;

import gob.pe.minam.sca.framework.ConstantesSistema;
import gob.pe.minam.sca.util.bean.BeanRetorno;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.FormulaEvaluator;


/**
 * @author Danny Espíritu
 * @version 1
 */
public class ExcelGenerador{
    
    static Logger log = Logger.getLogger("ExcelGenerador.class");
    /*Por defecto no lee fila encabezado empieza en fila 1*/
    private boolean leerEncabezado=false;
    /*Por defecto no verifica columna imprescindible en el archivo excel por lo tanto columnaProceso=0*/
    private boolean veriColProceso=false;
    private int columnaProceso=0;
    
    public ExcelGenerador() {
    }
    
    /*
     * 
     */
    public ExcelGenerador(boolean leerEncabezado, boolean veriColProceso, int columnaProceso){
        this.leerEncabezado=leerEncabezado;
        this.veriColProceso=veriColProceso; 
        this.columnaProceso=columnaProceso;
    }
    
    /**
     * Lectura del Archivo Excel
     * @param workBook Libro del Archivo Excel 
     * @param cell Celda del Archivo Excel
     * @return
     */
    public Object[] leerCelda(HSSFWorkbook workBook, HSSFCell cell){
        Object[] obj = new Object[2]; // col0 tipo col1 valor 
        if (cell!=null){
            switch (cell.getCellType())
            {
                case HSSFCell.CELL_TYPE_NUMERIC:
                {
                    // cell type numeric.
                    obj[0] = HSSFCell.CELL_TYPE_NUMERIC;
                    obj[1] = cell.getNumericCellValue();
                    break;
                }
                case HSSFCell.CELL_TYPE_STRING :
                {
                    // cell type string.
                    HSSFRichTextString richTextString = cell.getRichStringCellValue ();
                    obj[0] = HSSFCell.CELL_TYPE_STRING; 
                    obj[1] = richTextString.getString ();
                    break;
                }
                case HSSFCell.CELL_TYPE_FORMULA :
                {
                    
                    FormulaEvaluator evaluator = workBook.getCreationHelper().createFormulaEvaluator();
                    switch (evaluator.evaluateInCell(cell).getCellType()) {
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            obj[0] = HSSFCell.CELL_TYPE_BOOLEAN;
                            obj[1] = cell.getBooleanCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            obj[0] = HSSFCell.CELL_TYPE_NUMERIC;
                            obj[1] = cell.getNumericCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_STRING:
                            obj[0] = HSSFCell.CELL_TYPE_STRING;
                            obj[1] = cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_BLANK:
                            obj[0] = HSSFCell.CELL_TYPE_BLANK;
                            obj[1] = null;
                            break;
                        case HSSFCell.CELL_TYPE_ERROR:
                            log.error("Celda del Archivo contiene un campo tipificado como error");
                            obj[0] = null;
                            obj[1] = null;
                            break;
                    }
                    break;
                }
                case HSSFCell.CELL_TYPE_BLANK:{
                    obj[0] = HSSFCell.CELL_TYPE_BLANK;
                    obj[1] = null;
                    break;
                }
                case HSSFCell.CELL_TYPE_ERROR:{
                    log.error("Error");
                    obj[0] = null;
                    obj[1] = null;
                    break;
                }
                default :
                {
                    obj[0] = null;
                    obj[1] = null;
                    log.error("Tipo no soportado " + cell.getCellType());
                    break;
                }
            }
        }else{
            log.error("Celda es nula verifique que se está enviando el archivo correcto");
        }
        return obj;
    }
    
    /*
    public BeanRetorno leerArchivo (int personaId, int columnaProceso, String rutaArchivo) throws Exception{
        int i=0;
        int filaComienzo=retornaFilaComienzo();
        boolean columnaPresente=false;
        BeanRetorno beanRetorno = new BeanRetorno();
        InputStream inputStream = null;
        List lstBeanRet = new ArrayList();
        try
        {
            inputStream = new FileInputStream (rutaArchivo);
        }
        catch (FileNotFoundException e)
        {
            beanRetorno.setCodError(ConstantesSistema.CONST_RETORNO_ERROR_MSG);
            beanRetorno.setDscError("Archivo no encontrado.");
            e.printStackTrace ();
            return beanRetorno;
        }

        POIFSFileSystem fileSystem = null;
        try
        {
            fileSystem = new POIFSFileSystem (inputStream);
        }
        catch (IOException e)
        {
            beanRetorno.setCodError(ConstantesSistema.CONST_RETORNO_ERROR_MSG);
            beanRetorno.setDscError("Archivo no es un Formato de Excel válido");
            e.printStackTrace ();
            return beanRetorno;
        }
        try{
            HSSFWorkbook      workBook = new HSSFWorkbook (fileSystem);
            HSSFSheet         sheet    = workBook.getSheetAt (0);
            Iterator<HSSFRow> rows     = sheet.rowIterator();
            Object[] objLectura = null;
            String valor="";
            HSSFCell cell = null;
            
            log.info("HSSFCell.CELL_TYPE_BLANK-->"+HSSFCell.CELL_TYPE_BLANK);
            log.info("HSSFCell.CELL_TYPE_BOOLEAN-->"+HSSFCell.CELL_TYPE_BOOLEAN);
            log.info("HSSFCell.CELL_TYPE_STRING-->"+HSSFCell.CELL_TYPE_STRING);
            log.info("HSSFCell.CELL_TYPE_NUMERIC-->"+HSSFCell.CELL_TYPE_NUMERIC);
            log.info("HSSFCell.CELL_TYPE_FORMULA-->"+HSSFCell.CELL_TYPE_FORMULA);
            
            int fila=0;
            if (rows.hasNext ()){
                while (rows.hasNext ())
                {
                    HSSFRow row = rows.next ();
                    fila++;
                    if (fila>filaComienzo){
                        // La numeracion de las columnas empieza en cero
                        columnaPresente=true;
                        cell = row.getCell(columnaProceso-1);
                        if (cell==null && columnaPresente){
                            beanRetorno.setCodError(ConstantesSistema.CONST_RETORNO_ERROR_MSG);
                            beanRetorno.setDscError("Columna " + columnaProceso  + " es obligatoria y no presenta valor en la fila " + fila + ", verifique!!");
                            return beanRetorno;
                        } 
                        objLectura = leerCelda(workBook, cell);
                        if (objLectura[0].toString().equals(""+HSSFCell.CELL_TYPE_NUMERIC)){
                           valor = "" + ((Double)objLectura[1]).intValue();
                        }else if (objLectura[0].toString().toString().equals(""+HSSFCell.CELL_TYPE_STRING)){
                           valor = (String)objLectura[1];
                        }
                        log.info("valor-->" + valor);
                        // Procesar Informacion Enviada
                    }   
                }
                beanRetorno.setLstData(lstBeanRet);
                beanRetorno.setCodError(ConstantesSistema.CONST_RETORNO_EXITO);
            }else{
                beanRetorno.setCodError(ConstantesSistema.CONST_RETORNO_ERROR_MSG);
                beanRetorno.setDscError("Archivo no presenta Filas");
            }
        }
        catch (Exception e)
        {
            beanRetorno.setCodError(ConstantesSistema.CONST_RETORNO_ERROR_MSG);
            beanRetorno.setDscError("Error en la lectura del Archivo");
            e.printStackTrace();
            return beanRetorno;
        }
        return beanRetorno;
    }
    */
    
    public BeanRetorno leerArchivo(String rutaArchivo) throws Exception{
        BeanRetorno beanRetorno = new BeanRetorno();
        try{
            beanRetorno=leerCabecera(rutaArchivo);
            if (beanRetorno.getCodError()==ConstantesSistema.CONST_RETORNO_EXITO){
                beanRetorno=leerDetalle(beanRetorno.getRows(), beanRetorno.getWorkBook());
            }else{
                beanRetorno.setWorkBook(null);
                beanRetorno.setRows(null);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return beanRetorno;
    }
     
    public BeanRetorno leerCabecera(String rutaArchivo) throws Exception
    {
        BeanRetorno beanRetorno = new BeanRetorno();
        InputStream inputStream = null;
        List lstBeanRet = new ArrayList();
        try
        {
            inputStream = new FileInputStream (rutaArchivo);
        }
        catch (FileNotFoundException e)
        {
            beanRetorno.setCodError(ConstantesSistema.CONST_RETORNO_ERROR_MSG);
            beanRetorno.setDscError("Archivo no encontrado.");
            e.printStackTrace ();
            return beanRetorno;
        }

        POIFSFileSystem fileSystem = null;
        try
        {
            fileSystem = new POIFSFileSystem (inputStream);
        }
        catch (IOException e)
        {
            beanRetorno.setCodError(ConstantesSistema.CONST_RETORNO_ERROR_MSG);
            beanRetorno.setDscError("Archivo no es un Formato de Excel válido");
            e.printStackTrace ();
            return beanRetorno;
        }
        try{
            HSSFWorkbook      workBook = new HSSFWorkbook (fileSystem);
            HSSFSheet         sheet    = workBook.getSheetAt(0);
            Iterator<HSSFRow> rows     = sheet.rowIterator();
            if (rows.hasNext ()){
                beanRetorno.setWorkBook(workBook);
                beanRetorno.setRows(rows);
                beanRetorno.setLstData(lstBeanRet);
                beanRetorno.setCodError(ConstantesSistema.CONST_RETORNO_EXITO);
            }else{
                beanRetorno.setCodError(ConstantesSistema.CONST_RETORNO_ERROR_MSG);
                beanRetorno.setDscError("Archivo no presenta Filas");
            }
        }
        catch (Exception e)
        {
            beanRetorno.setCodError(ConstantesSistema.CONST_RETORNO_ERROR_MSG);
            beanRetorno.setDscError("Error en la lectura del Archivo");
            e.printStackTrace();
            return beanRetorno;
        }
        return beanRetorno;
    }
    
    public BeanRetorno leerDetalle(Iterator<HSSFRow> rows, HSSFWorkbook workBook) throws Exception{
        int fila=0;
        HSSFCell cell=null;
        int filaComienzo=retornaFilaComienzo();
        BeanRetorno beanRetorno = new BeanRetorno();
        Object[] objLectura = null;
        List lstBeanRet = new ArrayList();
        String valor="";
        while (rows.hasNext ())
        {
            HSSFRow row = rows.next ();
            fila++;
            if (fila>filaComienzo){
                // La numeracion de las columnas empieza en cero
                cell = row.getCell(columnaProceso-1);
                if (this.veriColProceso && this.columnaProceso!=0){
                    if (cell==null){
                        beanRetorno.setCodError(ConstantesSistema.CONST_RETORNO_ERROR_MSG);
                        beanRetorno.setDscError("Columna " + columnaProceso  + " es obligatoria y no presenta valor en la fila " + fila + ", verifique!!");
                        return beanRetorno;
                    } 
                }
                objLectura = leerCelda(workBook, cell);
                if (objLectura[0].toString().equals(""+HSSFCell.CELL_TYPE_NUMERIC)){
                   valor = "" + ((Double)objLectura[1]).intValue();
                }else if (objLectura[0].toString().toString().equals(""+HSSFCell.CELL_TYPE_STRING)){
                   valor = (String)objLectura[1];
                }
                lstBeanRet.add(valor);
            }   
        }
        beanRetorno.setWorkBook(null);
        beanRetorno.setRows(null);
        beanRetorno.setLstData(lstBeanRet);
        beanRetorno.setCodError(ConstantesSistema.CONST_RETORNO_EXITO); 
        return beanRetorno;
    }
    
    public static void main(String arg[]){
        ExcelGenerador excel = new ExcelGenerador();
        try{
            excel.leerArchivo("C:\\software\\java\\eclipsewin32\\wsSCA\\upload\\PROPONENTE_DE.xls");
            //excel.leerArchivo(1,8,"C:\\software\\java\\eclipsewin32\\wsSCA\\upload\\PROYECTO_DE.xls");
        }catch(Exception ex){
            ex.printStackTrace();        
        }
    }

    public void setLeerEncabezado(boolean leerEncabezado) {
        this.leerEncabezado = leerEncabezado;
    }

    public boolean isLeerEncabezado() {
        return leerEncabezado;
    }
    
    private int retornaFilaComienzo(){
        int filaComienzo=0;//Leer Detalle desde la primera fila
        if (isLeerEncabezado()) filaComienzo=0;//Leer Detalle desde la primera fila
        else filaComienzo=1;//Leer Detalle desde la segunda fila
        return filaComienzo;
    }

    public void setColumnaProceso(int columnaProceso) {
        this.columnaProceso = columnaProceso;
    }

    public int getColumnaProceso() {
        return columnaProceso;
    }
}

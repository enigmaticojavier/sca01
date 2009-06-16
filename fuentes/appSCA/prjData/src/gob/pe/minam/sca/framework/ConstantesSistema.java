package gob.pe.minam.sca.framework;
/***********************************************************************
 * Module:  ConstantesSistema.java
 * Author:  Dante Antiporta
 * Purpose: Defines the Class ConstantesSistema
 ***********************************************************************/

public class ConstantesSistema {
	
    public final static int CONST_RETORNO_EXITO = 1;
    public final static int CONST_RETORNO_ERROR_MSG = -1;
    public final static int CONST_RETORNO_ERROR_LST = -2;
    
    public final static String TIPO_USUARIO_ADM = "ADM";
    public final static String TIPO_USUARIO_ACAE = "ACA";
    public final static String COD_PARAMETRO_MIN = "MIN";
    public final static String COD_PARAMETRO_GRE = "GRE";
    public final static String COD_PARAMETRO_GLO = "GLO";
    public final static String TIPO_ACAE = "TAC";
    
    public final static String ENVIO_NO_ENVIADO    = "NNN";
    public final static String ENVIO_ENVIADO_OK    = "EOK";
    public final static String ENVIO_ENVIADO_ERROR = "ERR";
    public final static String ENVIO_REENVIADO     = "ROK";
    
    public final static String CARPETA_TEMPORAL="TMP";	
    public final static String CARPETA_IMAGENES="DIR";
    
    public final static int TAMANO_MENSAJE_ERROR = 60;
    public final static int COLUMNA_PROCESO_PROPONENTE = 12;
    public final static int COLUMNA_PROCESO_PROYECTO = 12;
    public final static int COLUMNA_PROCESO_EXPEDIENTE = 11;
    public final static String PROC_CARGA_PROPONENTE = "USP_001_CARGA_PROPONENTE";
    public final static String PROC_CARGA_PROYECTO = "USP_002_CARGA_PROYECTO";
    public final static String PROC_CARGA_EXPEDIENTE = "USP_003_CARGA_EXPEDIENTE";
     
}

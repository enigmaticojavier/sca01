package gob.pe.minam.sca.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.log4j.Logger;

public class Utilitarios {
    
    static Logger log = Logger.getLogger("Utilitarios.class");
    
    public Utilitarios() {
    }
    
    public static String obtenerExtensionArchivo(String rutaCompleta){
      String extension="";
      try{
        if (rutaCompleta!=null){
            if (!rutaCompleta.equals("") && rutaCompleta.length()>3) 
               extension=rutaCompleta.substring(rutaCompleta.length()-3,rutaCompleta.length());
            else
               log.error("[Utilitarios][Error] Ruta no v�lida");
        }
      }catch(Exception ex){
        log.error("[Utilitarios][Error] Error obteniendo Ruta" + ex.toString());
      }
      return extension;
    }
    
    public static String formatoFechaActual(){
        DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();    
        return formatter.format(date);
    }
}

package gob.pe.minam.sca;



import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import gob.pe.minam.sca.pojo.Parametro;

import gob.pe.minam.sca.pojo.Proyecto;

import java.util.Date;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.List;


public class Prueba {

  public static void main(String args[]){
    Proyecto p= new Proyecto();
    try{
        DateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = myDateFormat.parse("01/05/1994");
        Date d2 = myDateFormat.parse("01/05/1995");
      List l = p.buscarProyecto("PROY","020106","CA3",d1,d2,"Est","EYM","EYM1");
      //List l = p.buscarProyecto("PROY","020106","CA3",null,null,"Est","EYM","EYM1");
      System.out.println("tam"+l.size());
      for (int i=0;i<l.size();i++){
          System.out.println("Hi " + ((Proyecto)l.get(0)).getPryId() );
      }
    }catch(Exception ex){
      ex.printStackTrace(); 
    }    
  }  
}

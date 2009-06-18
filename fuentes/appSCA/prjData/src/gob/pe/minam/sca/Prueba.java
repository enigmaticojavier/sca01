package gob.pe.minam.sca;


import gob.pe.minam.sca.pojo.Acae;

import gob.pe.minam.sca.framework.ConstantesSistema;
import gob.pe.minam.sca.pojo.ControlEnvio;

import gob.pe.minam.sca.pojo.Expediente;
import gob.pe.minam.sca.pojo.ExpedienteDocumento;
import gob.pe.minam.sca.pojo.ImagenDocumento;
import gob.pe.minam.sca.pojo.Parametro;

import gob.pe.minam.sca.pojo.Periodo;
import gob.pe.minam.sca.pojo.Persona;
import gob.pe.minam.sca.pojo.Proyecto;

import gob.pe.minam.sca.pojo.SubSector;

import gob.pe.minam.sca.pojo.Ubigeo;
import gob.pe.minam.sca.vo.EstadisticaVo;

import java.util.ArrayList;
import java.util.Date;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.List;


public class Prueba {

  public static void main(String args[]){
    Proyecto p= new Proyecto();
    Persona persona =  new Persona();
    Persona persona2;
    Ubigeo ubigeo = new Ubigeo();
    Acae acae = new Acae();
    Acae acae2;
    try{
        Integer id = new Integer(0);
        persona.setPersonaId(id);
        persona2 = persona.getPersonaByKey(persona);
        System.out.println("persona2="+persona2);        
        List lstDpto = ubigeo.listarDepartamento();
        System.out.println("lstDpto"+lstDpto.size());
        acae.setTxtRazonSocial("AMBIENTE");
        List lstPersonas = acae.getAcaeByNombre(acae);
        System.out.println("lstPersonas"+lstPersonas.size());
        acae.setPersonaId(new Integer(1));
        acae2 = acae.getAcaeBusqueda(acae);
        System.out.println("acae2="+acae2);
        
        
      }catch(Throwable ex){
        ex.printStackTrace();
        System.out.println("Error-->"+ex.toString());
      }
      String query="";
      query=query.substring(0,query.length()-1);
      System.out.println(query);
  }  
  
}

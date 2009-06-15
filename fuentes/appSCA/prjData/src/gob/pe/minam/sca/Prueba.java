package gob.pe.minam.sca;

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
    
    try{
        Integer id = new Integer(0);
        persona.setPersonaId(id);
        persona2 = persona.getPersonaByKey(persona);
        System.out.println("persona2="+persona2);
        persona.setTxtRazonSocial("BARRICK");
        List lstDpto = ubigeo.listarDepartamento();
        System.out.println("lstDpto"+lstDpto.size());
        List lstPersonas = persona.getPersonaByNombre(persona);
        System.out.println("lstPersonas"+lstPersonas.size());
        DateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = myDateFormat.parse("01/05/1994");
        Date d2 = myDateFormat.parse("01/05/1995");
        List l = p.buscarProyecto("PROY","020106","CA3",d1,d2,"Est","MIN","EYM","EYM1");
        //List l = p.buscarProyecto("PROY","020106","CA3",null,null,"Est","EYM","EYM1");
        System.out.println("tam"+l.size());
        for (int i=0;i<l.size();i++){
          System.out.println("Hi " + ((Proyecto)l.get(0)).getPryId() );
        }      
        Parametro pr = new Parametro();
        pr =  pr.buscarParametroXParametro("TAC","EYM");
        System.out.println(pr.getCodParametro());
        System.out.println(pr.getTxtValor());
        
        SubSector su = new SubSector();
        su =  su.buscarSubsector("EYM","EYM1");
        System.out.println(su.getTxtSubSector());
        
        ExpedienteDocumento ed = new ExpedienteDocumento();
        l=ed.buscarExpDocXPry(1);
        System.out.println("ExpedienteDocumento--------------->");
        for (int i=0;i<l.size();i++){
          System.out.println("ExpedienteDocumento expId" + ((ExpedienteDocumento)l.get(i)).getExpedientePaso().getExpediente().getExpId() );  
          System.out.println("ExpedienteDocumento paso" + ((ExpedienteDocumento)l.get(i)).getExpedientePaso().getNsecuencia() );  
          try{
            System.out.println("ExpedienteDocumento docId" + ((ExpedienteDocumento)l.get(i)).getDocumento().getDocId() );
          }catch(Exception ex){
            ex.printStackTrace();
          }  
        } 
        ImagenDocumento ima = new ImagenDocumento();
        l = ima.buscarImgXDoc(1);
        System.out.println("ImagenDocumento--------------->");
        for (int i=0;i<l.size();i++){
          System.out.println("expId" + ((ImagenDocumento)l.get(i)).getDocumento());  
          System.out.println("TxtRutaImagen" + ((ImagenDocumento)l.get(i)).getTxtRutaImagen() );  
        }
        Expediente ex = new Expediente();
        l = ex.listarEstadistica("1","1");
        System.out.println("Estadistica--------------->");
        for (int i=0;l!=null && i<l.size();i++){
            System.out.println("Sector" + ((EstadisticaVo)l.get(i)).getDscClsSector() + " Tip " + ((EstadisticaVo)l.get(i)).getClsTipificacion());  
            System.out.println("Desaprobado" + ((EstadisticaVo)l.get(i)).getDesaprobado() + "Desis" + ((EstadisticaVo)l.get(i)).getDesistido());  
            System.out.println("Eva" + ((EstadisticaVo)l.get(i)).getEvaluacion() + "Aprob" + ((EstadisticaVo)l.get(i)).getAprobado() );  
            System.out.println("Anu" + ((EstadisticaVo)l.get(i)).getAnulado() + "Tot" + ((EstadisticaVo)l.get(i)).getTotal() );  
        }
        String periodo="2009-05";
        System.out.println( periodo.substring(0,4));
        System.out.println( periodo.substring(5,7));
        String tmpPeriodo=periodo.substring(0,4) + periodo.substring(5,7);
        
        String name="prueba.txt";
        String extension = name.substring(name.length()-3,name.length());
        System.out.println(extension);
        
        System.out.println("Existe");
        ControlEnvio controlEnvio=new ControlEnvio();
        controlEnvio.setPersonaId(3);
        controlEnvio.setPeriodo("200906");
        controlEnvio.setEstEnvioPro(ConstantesSistema.ENVIO_ENVIADO_OK);
        controlEnvio.setFchEnvioExp(new Date());
        controlEnvio.guardarControlEnvio(controlEnvio);
        
        System.out.println("StringBuffer");
        StringBuffer variable = new StringBuffer(60);
        System.out.println("variable-->"+variable+1);
        
    }catch(Exception ex){
      ex.printStackTrace(); 
    }    
      try{
        Periodo periodo1 = new Periodo();
        List l =periodo1.listarPeriodoReporte();
        for (int i=0;i<l.size();i++){
          System.out.println("Periodo " + ((Periodo)l.get(i)).getPeriodo() );  
        }
        
        ControlEnvio controlEnvio=new ControlEnvio();
        controlEnvio=controlEnvio.obtenerControlEnvioXPeriodo("200912");
        if (controlEnvio==null){
            System.out.println("Nulo");
        }else{
            System.out.println("PeriodoXX-->"+controlEnvio.getPeriodo());
        }    
        
        ExpedienteDocumento expdoc=new ExpedienteDocumento();
        l = expdoc.buscarExpDocPeriodoPersona("200905",4);
        for (int i=0;i<l.size();i++){
            System.out.println("TIPPASO " + ((ExpedienteDocumento)l.get(i)).getExpedientePaso().getTipPaso() );  
        }
        
      }catch(Throwable ex){
        ex.printStackTrace();
        System.out.println("Error-->"+ex.toString());
      }
  }  
  
}

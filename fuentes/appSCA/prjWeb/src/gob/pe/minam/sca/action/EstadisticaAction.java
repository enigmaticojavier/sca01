package gob.pe.minam.sca.action;

import com.opensymphony.xwork2.Preparable;

import gob.pe.minam.sca.framework.AccionSoporte;
import gob.pe.minam.sca.pojo.Expediente;
import gob.pe.minam.sca.pojo.Parametro;
import gob.pe.minam.sca.pojo.Periodo;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;


public class EstadisticaAction extends AccionSoporte implements Preparable {
    
    static Logger log = Logger.getLogger("EstadisticaAction.class");
    private String periodo;
    private String tipAcae;
    private List parPeriodos;
    private List parTipoAcae;
    private List estadisticas;

    public void setParPeriodos(List parPeriodos) {
        this.parPeriodos = parPeriodos;
    }

    public List getParPeriodos() {
        return parPeriodos;
    }

    public void setParTipoAcae(List parTipoAcae) {
        this.parTipoAcae = parTipoAcae;
    }

    public List getParTipoAcae() {
        return parTipoAcae;
    }

    public void setEstadisticas(List estadisticas) {
        this.estadisticas = estadisticas;
    }

    public List getEstadisticas() {
        return estadisticas;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return periodo;
    }
    
    public void prepare() throws Exception {
        try{
            log.info("[EstadisticaAction.prepare][Ini]");
            /*Tipo de Acae*/
            Parametro par = new Parametro();
            this.parTipoAcae=par.buscarParametroXTipoParametro("TAC");
            /*Periodo*/
            Periodo per = new Periodo();
            this.parPeriodos=per.listarPeriodo();
            this.parPeriodos=this.parPeriodos==null?new ArrayList():this.parPeriodos;
            if (this.periodo==null){
                DateFormat formatter = new SimpleDateFormat("yyyy-MM"); 
                Date date = new Date();    
                this.periodo = formatter.format(date);
                log.info("Periodo " + this.periodo);
            }
            log.info("[EstadisticaAction.prepare][Fin]");
        }catch(Exception ex){
            ex.printStackTrace();
        }  
    }
    
    public String list(){
      try{
        log.info("[EstadisticaAction.list][Ini]");
        Expediente exp = new Expediente();
        String tmpPeriodo=this.periodo.substring(0,4) + this.periodo.substring(5,7);
        log.info("this.tipAcae " + this.tipAcae + "tmpPeriodo"+tmpPeriodo);
        this.estadisticas = exp.listarEstadistica(this.tipAcae,tmpPeriodo);
        log.info("[EstadisticaAction.list][Fin]");
        return SUCCESS;
      }catch(Exception ex){
        ex.printStackTrace();
      }  
      return SUCCESS;
    }

    public void setTipAcae(String tipAcae) {
        this.tipAcae = tipAcae;
    }

    public String getTipAcae() {
        return tipAcae;
    }
}


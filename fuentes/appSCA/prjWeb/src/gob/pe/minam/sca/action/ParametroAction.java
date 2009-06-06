package gob.pe.minam.sca.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

import gob.pe.minam.sca.framework.AccionSoporte;
import gob.pe.minam.sca.framework.MensajeError;
import gob.pe.minam.sca.pojo.Parametro;

import java.util.List;

import org.apache.log4j.Logger;


public class ParametroAction extends AccionSoporte implements Preparable {
    static Logger log = Logger.getLogger("ProyectoAction.class");
    
    private String tipParametro;
    private Parametro parametro;
    private List parametros;
    private List tipoParametros;
    
    public void prepare() throws Exception {
        try{
            log.info("[ParametroAction.prepare][Ini]");
            llenaTipoParametros();
            /*Before inserting, updating*/
            if (this.parametro!=null && this.parametro.getIdParametro()!=null){
               log.info("this.parametro.getIdParametro()-->"+this.parametro.getIdParametro());
               this.parametro=parametro.obtenerParametro(this.parametro.getIdParametro().intValue());
            }
            String tmpTipParametro=getParameterValue("tipParametro");
            log.info("tmpTipParametro"+tmpTipParametro);
            /*Select Tipo Parametro*/
            
            if (tmpTipParametro==null || tmpTipParametro.equals("")){
                tmpTipParametro=(String)this.getVarSession("tipParametro"); 
                if (tmpTipParametro==null){
                    log.info("---No existe tmpTipParametro en el session -------------->");
                    this.tipParametro=((Parametro)this.tipoParametros.get(0)).getTipParametro();
                    this.parametros=parametro.buscarParametroXTipoParametro(this.tipParametro);
                    this.setVarSession("tipParametro",this.tipParametro);
                }else{
                    log.info("---Si existe tmpTipParametro en el session -------------->");
                    this.tipParametro=tmpTipParametro;
                    this.parametros=parametro.buscarParametroXTipoParametro(this.tipParametro);
                    if (!(this.parametros!=null && this.parametros.size()>0)){
                        this.tipParametro=((Parametro)this.tipoParametros.get(0)).getTipParametro();
                        this.parametros=parametro.buscarParametroXTipoParametro(this.tipParametro);
                    }
                    this.setVarSession("tipParametro",this.tipParametro);
                }    
                //}
            }else{
                log.info("---Si existe tmpTipParametro en el request -------------->");
                this.tipParametro=tmpTipParametro;
                this.parametros=parametro.buscarParametroXTipoParametro(this.tipParametro);
                this.setVarSession("tipParametro",this.tipParametro);
                if (this.parametros!=null && this.parametros.size()>0){
                    this.tipParametro=((Parametro)this.tipoParametros.get(0)).getTipParametro();
                    this.parametros=parametro.buscarParametroXTipoParametro(this.tipParametro);
                }
            }
            log.info("tmpTipParametro-->"+tmpTipParametro + " this.tipParametro" + this.tipParametro);
            log.info("[ParametroAction.prepare][Fin]");
        }catch(Exception ex){
            ex.printStackTrace();
        }  
    }
    
    public String input() {
        try{
            log.info("[ParametroAction.input][Inicio]");
            String tmpTipParametro=getParameterValue("tipParametro");
            /*Set the update form*/
            if (tmpTipParametro.equals("")){
                String parIdParametro=getParameterValue("idParametro");
                log.info("update parIdParametro " + parIdParametro);
                int idParametro=parIdParametro.equals("")?0:Integer.parseInt(parIdParametro);
                this.parametro=parametro.obtenerParametro(idParametro);
            /*Set the insert form*/
            }else{
                log.info("insert tmpTipParametro " + tmpTipParametro);
                this.tipParametro=tmpTipParametro;
                this.parametro=new Parametro();
                this.parametro.setTipParametro(this.tipParametro);
                this.parametro.setTxtParametro(obtenerTipoParametros(this.tipParametro));
            }
            this.setVarSession("tipParametro",this.tipParametro);
            log.info("[ParametroAction.input][Fin]");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return INPUT;
    }
    
    public String doSave() {
        try{
            log.info("[ParametroAction.doSave][Inicio]");
            if (this.parametro.getIdParametro()==null){
               parametro.insertParametro(this.parametro);
            }else{
               parametro.updateParametro(this.parametro);
            }
            this.setearMensajeError("1",this.MSGSUCCESS);
            this.setVarSession("tipParametro",this.parametro.getTipParametro());
            log.info("[ParametroAction.doSave][Fin]");
        }catch(Exception ex){
            ex.printStackTrace();
            this.setearMensajeError("0",this.MSGERROR + ex.toString());
        }
        return SUCCESS;
    }
    
    public String delete() {
        try{
            log.info("[ParametroAction.delete][Inicio]");
            parametro.deleteParametro(this.parametro.getIdParametro());
            this.setearMensajeError("1",this.MSGSUCCESS);
            this.setVarSession("tipParametro",this.parametro.getTipParametro());
            log.info("[ParametroAction.delete][Fin]");
        }catch(Exception ex){
            ex.printStackTrace();
            this.setearMensajeError("0",this.MSGERROR + ex.toString());
        }
        return SUCCESS;
    }
    
    public String list(){
      try{
        log.info("[ParametroAction.list][Inicio]");
        llenaTipoParametros();
        Parametro pr = new Parametro(); 
        this.tipParametro=(String)this.getVarSession("tipParametro");
        log.info(" session " + (String)this.getVarSession("tipParametro"));
        this.parametros=pr.buscarParametroXTipoParametro(this.tipParametro);
        this.setMensajeError((MensajeError)this.getVarSession("mensajeError"));
        this.setVarSession("mensajeError",null);
        log.info("[ParametroAction.list][Fin]");
        return SUCCESS;
      }catch(Exception ex){
        ex.printStackTrace();
      }  
      return SUCCESS;
    }
    
    public void setTipParametro(String tipParametro) {
        this.tipParametro = tipParametro;
    }

    public String getTipParametro() {
        return tipParametro;
    }

    public void setParametro(Parametro parametro) {
        this.parametro = parametro;
    }

    public Parametro getParametro() {
        return parametro;
    }

    public List getParametros() {
        return parametros;
    }

    public List getTipoParametros() {
        return tipoParametros;
    }
    
    private void llenaTipoParametros(){
      try{
          Parametro pr = new Parametro(); 
          this.tipoParametros= pr.listarTipoParametro();
      }catch(Exception ex){
          ex.printStackTrace();
      }                  
    }
    
    private String obtenerTipoParametros(String tipParametro){
      String tmpTxtParametro="";
      try{
         Parametro par=null; 
         for (int i=0;i<this.tipoParametros.size();i++){
             par=(Parametro)this.tipoParametros.get(i);
             if (par.getTipParametro().equals(tipParametro)){
                tmpTxtParametro=par.getTxtParametro();    
             }
         }
      }catch(Exception ex){
         ex.printStackTrace();
      }
      return tmpTxtParametro;
    }
    
    public String getParameterValue(String param) {
      Object varr = ActionContext.getContext().getParameters().get(param);
      if (varr == null) return "";
      return ((String[]) varr)[0];
    }

}

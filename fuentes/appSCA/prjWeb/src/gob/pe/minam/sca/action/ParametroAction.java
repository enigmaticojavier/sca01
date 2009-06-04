package gob.pe.minam.sca.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

import gob.pe.minam.sca.framework.AccionSoporte;
import gob.pe.minam.sca.framework.MensajeError;
import gob.pe.minam.sca.pojo.Parametro;

import java.util.List;

import org.apache.log4j.Logger;


public class ParametroAction extends AccionSoporte implements Preparable {
    static Logger log = Logger.getLogger("ParametroAction.class");
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
               System.out.println("this.parametro.getIdParametro()-->"+this.parametro.getIdParametro());
               this.parametro=parametro.obtenerParametro(this.parametro.getIdParametro());
            }
            String tmpTipParametro=getParameterValue("tipParametro");
            log.info("tmpTipParametro " + tmpTipParametro);
            /*Select Tipo Parametro*/
            if (tmpTipParametro==null || tmpTipParametro.equals("")){
                log.info("No existe tmpTipParametro en el request ");
                tmpTipParametro=(String)this.getVarSession("tipParametro"); 
                if (tmpTipParametro==null){
                    log.info("No existe tmpTipParametro en el session");
                    this.tipParametro=((Parametro)this.tipoParametros.get(0)).getTipParametro();
                    this.parametros=parametro.buscarParametroXTipoParametro(this.tipParametro);
                    this.setVarSession("tipParametro",this.tipParametro);
                }else{
                    log.info("Si existe tmpTipParametro en el session");
                    this.tipParametro=tmpTipParametro;
                    this.parametros=parametro.buscarParametroXTipoParametro(this.tipParametro);
                    if (!(this.parametros!=null && this.parametros.size()>0)){
                        this.tipParametro=((Parametro)this.tipoParametros.get(0)).getTipParametro();
                        this.parametros=parametro.buscarParametroXTipoParametro(this.tipParametro);
                    }
                    this.setVarSession("tipParametro",this.tipParametro);
                }    
            }else{
                log.info("Si existe tmpTipParametro en el request");
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
            log.info("[ParametroAction.input][Ini]");
            String tmpTipParametro=getParameterValue("tipParametro");
            /*Set the update form*/
            if (tmpTipParametro.equals("")){
                String parIdParametro=getParameterValue("idParametro");
                log.info("Updating parIdParametro " + parIdParametro);
                int idParametro=parIdParametro.equals("")?0:Integer.parseInt(parIdParametro);
                this.parametro=parametro.obtenerParametro(idParametro);
            /*Set the insert form*/
            }else{
                log.info("Inserting tmpTipParametro " + tmpTipParametro);
                this.tipParametro=tmpTipParametro;
                this.parametro=new Parametro();
                this.parametro.setTipParametro(this.tipParametro);
                this.parametro.setTxtParametro(obtenerTipoParametros(this.tipParametro));
            }
            this.setVarSession("tipParametro",this.tipParametro);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        log.info("[ParametroAction.input][Fin]");
        return INPUT;
    }
    
    public String doSave() {
        log.info("[ParametroAction.save][Ini]");
        try{
            this.parametro.setCodParametro(this.parametro.getCodParametro().toUpperCase());
            this.parametro.setTxtValor(this.parametro.getTxtValor().toUpperCase());
            if (this.parametro.getIdParametro()==null){
               parametro.insertParametro(this.parametro);
            }else{
               parametro.updateParametro(this.parametro);
            }
            this.setearMensajeError("1",this.MSGSUCCESS);
            this.setVarSession("tipParametro",this.parametro.getTipParametro());
        }catch(Exception ex){
            ex.printStackTrace();
            this.setearMensajeError("0",this.MSGERROR + ex.toString());
        }
        log.info("[ParametroAction.save][Fin]");
        return SUCCESS;
    }
    
    public String delete() {
        log.info("[ParametroAction.delete][Ini]");
        try{
            parametro.deleteParametro(this.parametro.getIdParametro());
            this.setearMensajeError("1",this.MSGSUCCESS);
            this.setVarSession("tipParametro",this.parametro.getTipParametro());
        }catch(Exception ex){
            ex.printStackTrace();
            this.setearMensajeError("0",this.MSGERROR + ex.toString());
        }
        log.info("[ParametroAction.delete][Fin]");
        return SUCCESS;
    }
    
    public String list(){
      log.info("[ParametroAction.list][Ini]");
      try{
        llenaTipoParametros();
        System.out.println("this.tipParametro " + this.tipParametro);
        Parametro pr = new Parametro(); 
        this.tipParametro=(String)this.getVarSession("tipParametro");
        System.out.println(" session " + (String)this.getVarSession("tipParametro"));
        //--->Borrar
        //this.tipParametro="GLO";
        //<--Borrar  
        this.parametros=pr.buscarParametroXTipoParametro(this.tipParametro);
        this.setMensajeError((MensajeError)this.getVarSession("mensajeError"));
        this.setVarSession("mensajeError",null);
      }catch(Exception ex){
        ex.printStackTrace();
      }  
      log.info("[ParametroAction.list][Fin]");
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

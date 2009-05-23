package gob.pe.minam.sca.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

import gob.pe.minam.sca.framework.AccionSoporte;
import gob.pe.minam.sca.framework.MensajeError;
import gob.pe.minam.sca.pojo.Parametro;

import java.util.List;


public class ParametroAction extends AccionSoporte implements Preparable {
    
    private String tipParametro;
    private Parametro parametro;
    private List parametros;
    private List tipoParametros;
    
    public void prepare() throws Exception {
        try{
            System.out.println("ParametroAction.prepare---------------------------------------------->");
            llenaTipoParametros();
            /*Before inserting, updating*/
            if (this.parametro!=null && this.parametro.getIdParametro()!=null){
               System.out.println("this.parametro.getIdParametro()-->"+this.parametro.getIdParametro());
               this.parametro=parametro.obtenerParametro(this.parametro.getIdParametro());
            }
            String tmpTipParametro=getParameterValue("tipParametro");
            System.out.println("Select tmpTipParametro"+tmpTipParametro);
            /*Select Tipo Parametro*/
            
            if (tmpTipParametro==null || tmpTipParametro.equals("")){
                System.out.println("---No existe tmpTipParametro en el request -------------->");
                tmpTipParametro=(String)this.getVarSession("tipParametro"); 
                if (tmpTipParametro==null){
                    System.out.println("---No existe tmpTipParametro en el session -------------->");
                    this.tipParametro=((Parametro)this.tipoParametros.get(0)).getTipParametro();
                    this.parametros=parametro.buscarParametroXTipoParametro(this.tipParametro);
                    this.setVarSession("tipParametro",this.tipParametro);
                }else{
                    System.out.println("---Si existe tmpTipParametro en el session -------------->");
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
                System.out.println("---Si existe tmpTipParametro en el request -------------->");
                this.tipParametro=tmpTipParametro;
                this.parametros=parametro.buscarParametroXTipoParametro(this.tipParametro);
                this.setVarSession("tipParametro",this.tipParametro);
                if (this.parametros!=null && this.parametros.size()>0){
                    this.tipParametro=((Parametro)this.tipoParametros.get(0)).getTipParametro();
                    this.parametros=parametro.buscarParametroXTipoParametro(this.tipParametro);
                }
            }
            System.out.println("tmpTipParametro-->"+tmpTipParametro + " this.tipParametro" + this.tipParametro);
            System.out.println("ParametroAction.prepare<-----------------------------------------");
        }catch(Exception ex){
            ex.printStackTrace();
        }  
    }
    
    public String input() {
        System.out.println("-------------->ParametroAction.input");
        try{
            String tmpTipParametro=getParameterValue("tipParametro");
            /*Set the update form*/
            if (tmpTipParametro.equals("")){
                String parIdParametro=getParameterValue("idParametro");
                System.out.println("update parIdParametro " + parIdParametro);
                int idParametro=parIdParametro.equals("")?0:Integer.parseInt(parIdParametro);
                this.parametro=parametro.obtenerParametro(idParametro);
            /*Set the insert form*/
            }else{
                System.out.println("insert tmpTipParametro " + tmpTipParametro);
                this.tipParametro=tmpTipParametro;
                this.parametro=new Parametro();
                this.parametro.setTipParametro(this.tipParametro);
                this.parametro.setTxtParametro(obtenerTipoParametros(this.tipParametro));
            }
            this.setVarSession("tipParametro",this.tipParametro);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("<--------------ParametroAction.input");
        return INPUT;
    }
    
    public String doSave() {
        System.out.println("----------------------->ParametroAction.save");
        try{
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
        System.out.println("<-----------------------ParametroAction.save");
        return SUCCESS;
    }
    
    public String delete() {
        System.out.println("ParametroAction.delete -->" + this.parametro.getIdParametro());
        try{
            parametro.deleteParametro(this.parametro.getIdParametro());
            this.setearMensajeError("1",this.MSGSUCCESS);
            this.setVarSession("tipParametro",this.parametro.getTipParametro());
        }catch(Exception ex){
            ex.printStackTrace();
            this.setearMensajeError("0",this.MSGERROR + ex.toString());
        }
        return SUCCESS;
    }
    
    public String list(){
      System.out.println("ParametroAction.List---->");
      try{
        llenaTipoParametros();
        System.out.println("this.tipParametro " + this.tipParametro);
        Parametro pr = new Parametro(); 
        this.tipParametro=(String)this.getVarSession("tipParametro");
        System.out.println(" session " + (String)this.getVarSession("tipParametro"));
        this.parametros=pr.buscarParametroXTipoParametro(this.tipParametro);
        this.setMensajeError((MensajeError)this.getVarSession("mensajeError"));
        //this.setVarSession("tipParametro",this.tipParametro);
        this.setVarSession("mensajeError",null);
        System.out.println("ParametroAction.List<----");
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

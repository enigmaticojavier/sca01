package gob.pe.minam.sca.action;

import gob.pe.minam.sca.pojo.Parametro;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import gob.pe.minam.sca.framework.exception.NegocioException;

import java.util.ArrayList;

   
public class ParametroAction extends ActionSupport implements Preparable {
    
    private String tipParametro;
    private Parametro parametro;
    private List parametros;
    private List tipoParametros;
    
    public void prepare() throws Exception {
        try{
          System.out.println("ParametroAction.prepare");
          llenaTipoParametros();
          if (this.tipParametro==null){
             System.out.println("ParametroAction.prepare nulo"); 
             if (this.tipoParametros==null || this.tipoParametros.size()==0){
                this.tipoParametros=new ArrayList();
             }else{
                this.tipParametro=((Parametro)this.tipoParametros.get(0)).getTipParametro();
                this.parametros=parametro.buscarTipoParametroXParametroId(this.tipParametro);
             }   
          }else{
             System.out.println("ParametroAction.prepare this.tipParametro " + this.tipParametro); 
             this.parametros=parametro.buscarTipoParametroXParametroId(this.tipParametro);
          }
          if (this.parametro!=null){
             System.out.println("this.parametro.getIdParametro()-->"+this.parametro.getIdParametro());
             this.parametro=parametro.obtenerParametro(this.parametro);
          }
        }catch(Exception ex){
          ex.printStackTrace();
        }  
    }
    
    public String save() {
        System.out.println("ParametroAction.save");
        try{
            if (this.parametro.getIdParametro()==null){
               parametro.insertParametro(this.parametro);
            }else{
               System.out.println("this.parametro.getIdParametro()-->"+this.parametro.getIdParametro());
               parametro.updateParametro(this.parametro);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return SUCCESS;
    }
    
    public String delete() {
        System.out.println("ParametroAction.delete");
        try{
            if (this.parametro.getIdParametro()==null){
               parametro.deleteParametro(this.parametro);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return SUCCESS;
    }
    
    public String list(){
      try{
        System.out.println("ParametroAction.List");
        llenaTipoParametros();
        Parametro pr = new Parametro(); 
        System.out.println("this.tipParametro--> " +  this.tipParametro);
        this.tipParametro=this.tipParametro==null?"SEC":this.tipParametro;
        this.parametros=pr.buscarTipoParametroXParametroId(this.tipParametro);
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

    
}

package gob.pe.minam.sca.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Preparable;

import gob.pe.minam.sca.framework.AccionSoporte;
import gob.pe.minam.sca.pojo.ExpedienteDocumento;
import gob.pe.minam.sca.pojo.Proyecto;

import gob.pe.minam.sca.pojo.Usuario;

import java.util.List;

import java.util.Map;

import org.apache.log4j.Logger;


public class ProyectoExpedienteAction extends AccionSoporte implements Preparable {
    
    static Logger log = Logger.getLogger("ProyectoExpedienteAction.class");
    Proyecto proyecto;
    private Integer pryId;
    
    private List expedienteDocumentos;    

    public void prepare() throws Exception {
        try{
            log.info("[ExpedienteProyectoAction.prepare][Ini]");
            log.info("[ExpedienteProyectoAction.prepare][Fin]");
        }catch(Exception ex){
            ex.printStackTrace();
        }  
    }
    
    public String input() {
        try{
            log.info("[ExpedienteProyectoAction.input][Ini]");
            boolean acceso;
            Map session = ActionContext.getContext().getSession();
            Usuario usuario =  (Usuario)session.get("Usuario");
            if (usuario!=null && usuario.getTipUsuario().equals("ACA")){
                acceso=true;
            }else{
                acceso=false;
            }
            Integer tmpPryId=Integer.valueOf(this.getParameterValue("pryId"));
            System.out.println(tmpPryId);
            Proyecto pry = new Proyecto();
            log.info("tmpPryId"+tmpPryId);
            this.proyecto=pry.obtenerProyecto(tmpPryId);
            log.info("resultado"+this.proyecto.getPryId());
            ExpedienteDocumento ed = new ExpedienteDocumento();
            this.expedienteDocumentos = ed.buscarExpDocXPry(tmpPryId,acceso);
            log.info("[ExpedienteProyectoAction.input][Fin]");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return INPUT;
    }
    
    public String list(){
      try{
        log.info("[ExpedienteProyectoAction.list][Ini]");
        Integer tmpPryId=Integer.valueOf(this.getParameterValue("pryId"));
        log.info("tmpPryId " + tmpPryId);
        ExpedienteDocumento ed = new ExpedienteDocumento();
        this.expedienteDocumentos = ed.buscarExpDocXPry(tmpPryId, true);
        log.info("[ExpedienteProyectoAction.list][Fin]");
        return SUCCESS;
      }catch(Exception ex){
        ex.printStackTrace();
      }  
      return SUCCESS;
    }

    public void setPryId(Integer pryId) {
        this.pryId = pryId;
    }

    public Integer getPryId() {
        return pryId;
    }

    public void setExpedienteDocumentos(List expedienteDocumentos) {
        this.expedienteDocumentos = expedienteDocumentos;
    }

    public List getExpedienteDocumentos() {
        return expedienteDocumentos;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }
}

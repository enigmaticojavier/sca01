package gob.pe.minam.sca.framework;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class AccionSoporte extends ActionSupport {
    MensajeError mensajeError;
    public static String MSGSUCCESS="Operación realizada correctamente";
    public static String MSGERROR="Ocurrió un Error";
    public static String COMBO_TXT_ALL="TODOS";
    public static String COMBO_COD_ALL="0";
    public static String COMBO_TXT_OTROS="OTROS";
    public static String COMBO_COD_OTROS="-1";
    
    public void setMensajeError(MensajeError mensajeError) {
        this.mensajeError = mensajeError;
    }

    public MensajeError getMensajeError() {
        return mensajeError;
    }
    
    public void setearMensajeError(String codigo, String mensaje){
        this.mensajeError=new MensajeError();
        this.mensajeError.setCodigo(codigo);
        this.mensajeError.setMensaje(mensaje);
        Map mapSession = ActionContext.getContext().getSession();
        mapSession.put("mensajeError",this.mensajeError);
    }
    
    public Map getSession(){
        Map mapSession = ActionContext.getContext().getSession();
        return mapSession;
    }
    
    public void setVarSession(String key,Object value){
        Map mapSession = ActionContext.getContext().getSession();
        mapSession.put(key, value);
    }
    
    public String getParameterValue(String param) {
      Object varr = ActionContext.getContext().getParameters().get(param);
      if (varr == null) return "";
      return ((String[]) varr)[0];
    }

    public Object getVarSession(String key){
        Object value;
        Map mapSession = ActionContext.getContext().getSession();
        value=mapSession.get(key);
        return value;
    }
    
}

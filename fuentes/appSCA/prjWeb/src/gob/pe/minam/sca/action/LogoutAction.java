package gob.pe.minam.sca.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5042955742023629981L;

	public String execute() throws Exception { 
	    Map session = ActionContext.getContext().getSession();
	    session.remove("Usuario");
            session.clear();
            System.gc();
	    return SUCCESS;
	    }

}

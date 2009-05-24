package gob.pe.minam.sca.action;

import java.util.ArrayList;
import java.util.List;

import gob.pe.minam.sca.framework.ConstantesSistema;
import gob.pe.minam.sca.framework.exception.NegocioException;
import gob.pe.minam.sca.pojo.Acae;
import gob.pe.minam.sca.pojo.Parametro;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class AcaeAction extends ActionSupport implements Preparable {
	
	private Acae acae;
	private Parametro parametro;
	private String tipParametro;
	private List lstTipoAcae = new ArrayList(0);
	private List lstInstitucion = new ArrayList(0);
	private String txtRazonSocial;
	
	public String getTipParametro() {
		return tipParametro;
	}

	public void setTipParametro(String tipParametro) {
		this.tipParametro = tipParametro;
	}

	public Acae getAcae() {
		return acae;
	}

	public void setAcae(Acae acae) {
		this.acae = acae;
	}

	public Parametro getParametro() {
		return parametro;
	}

	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}

	public List getLstTipoAcae() {
		return lstTipoAcae;
	}

	public void setLstTipoAcae(List lstTipoAcae) {
		this.lstTipoAcae = lstTipoAcae;
	}

	public List getLstInstitucion() {
		return lstInstitucion;
	}

	public void setLstInstitucion(List lstInstitucion) {
		this.lstInstitucion = lstInstitucion;
	}

	public String getTxtRazonSocial() {
		return txtRazonSocial;
	}

	public void setTxtRazonSocial(String txtRazonSocial) {
		this.txtRazonSocial = txtRazonSocial;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8873103128650016222L;

	public void prepare() throws Exception {
		try {
			cargarTipoAcae();
		}catch (Exception ex){
			 ex.printStackTrace();
		}
	}
	
	public void cargarTipoAcae() throws NegocioException {
		//this.lstTipoAcae = Parametro.buscarTipoParametroXParametroId(ConstantesSistema.TIPO_USUARIO_ACAE);		
	}
	
	public void cargarInstitucion(){
		if (this.lstInstitucion!=null) {
			for (int i=0;i<lstInstitucion.size();i++){
				
			}
		}
	}
}

package gob.pe.minam.sca.ds;

import gob.pe.minam.sca.pojo.Proyecto;

import gob.pe.minam.sca.vo.ProyectoReporteDetVo;
import gob.pe.minam.sca.vo.ProyectoReporteVo;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ProyectoResumenDS implements JRDataSource{
    private Object valorActual;
    private Iterator itrListaReporte;
    private boolean irSiguiente = true;  
    
    public ProyectoResumenDS(List listaDatosReporte)
    {    
      super();
      this.itrListaReporte = listaDatosReporte.iterator();
    }
    
    public boolean next() throws JRException {          
          valorActual = itrListaReporte.hasNext() ? itrListaReporte.next() : null;
          irSiguiente = (valorActual != null);
          return irSiguiente;
    }
      
    public Object getFieldValue(JRField campo) throws JRException {
        Object valor = null;
        System.out.println("----->campo a analizar-->INI-->"+campo.getName());
        ProyectoReporteVo proyectoReporteVo =  (ProyectoReporteVo)valorActual;
        if ("clsTipificacion".equals(campo.getName())){
           valor = proyectoReporteVo.getClsTipificacion();
        }else if("estadoTramite".equals(campo.getName())){
            valor = proyectoReporteVo.getEstadoTramite();
        }else if("tipoPersoneria".equals(campo.getName())){
            valor = proyectoReporteVo.getTipoPersoneria();
        }else if("proponente".equals(campo.getName())){
            valor = proyectoReporteVo.getProponente();
        }else if("tipoAcae".equals(campo.getName())){
            valor = proyectoReporteVo.getTipoAcae();
        }else if("clsSector".equals(campo.getName())){
            valor = proyectoReporteVo.getClsSector();
        }else if("clsSubSector".equals(campo.getName())){
            valor = proyectoReporteVo.getClsSubSector();
        }else if("codDepartamento".equals(campo.getName())){
            valor = proyectoReporteVo.getCodDepartamento();
        }else if("codProvincia".equals(campo.getName())){
            valor = proyectoReporteVo.getCodProvincia();
        }else if("codDistrito".equals(campo.getName())){
            valor = proyectoReporteVo.getCodDistrito();
        }else if("anoPeriodo".equals(campo.getName())){
            valor = proyectoReporteVo.getAnoPeriodo();
            System.out.println("ano-->"+valor);
        }else if("tipoDoc".equals(campo.getName())){
            valor = proyectoReporteVo.getTipoDoc();
        } else if ("lstProyectoResumen".equals(campo.getName())) {
           valor = new JRBeanCollectionDataSource(proyectoReporteVo.getLstResumen());
        }
        System.out.println("----->campo a analizar-->FIN-->"+campo.getName());
        return valor;
    }

}

/***********************************************************/
/* File Name: ProyectoSqlMapDao.java                   */
/* Descripcion: Interfase para las clases Dao de Ibatis    */
/* Fecha: Mayo 2009                               	  */
/* Autor: Danny Espíritu                                 */
/***********************************************************/
package gob.pe.minam.sca.data.daosql;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import com.ibatis.sqlmap.client.SqlMapException;


import gob.pe.minam.sca.data.BaseSqlMapDao;

import gob.pe.minam.sca.data.dao.ProyectoDao;

import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.pojo.Persona;
import gob.pe.minam.sca.pojo.Proponente;
import gob.pe.minam.sca.pojo.Proyecto;

import gob.pe.minam.sca.pojo.Ubigeo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Date;

import java.util.Set;

import org.apache.commons.beanutils.DynaBean;

/**
 * @author Danny Espíritu
 * @version 1.0
 */

public class ProyectoSqlMapDao extends BaseSqlMapDao implements ProyectoDao {

  public ProyectoSqlMapDao(DaoManager daoManager){
    super(daoManager);
  }

    public List buscarProyecto (String txtDescripcion, String ubigeoId,
                                String clsTipificacion, Date fchExpedienteDesde, 
                                Date fchExpedienteHasta, String estadoTramite, 
                                String tipoAcae, String clsSector, String clsSubSector) throws DAOException{
        try{
          Map map = new HashMap(); 
          map.put("p_cDescripcion",txtDescripcion);
          map.put("p_cUbigeoId",ubigeoId);
          map.put("p_cClsTipificacion",clsTipificacion);
          map.put("p_dFchExpedienteDesde",fchExpedienteDesde);
          map.put("p_dFchExpedienteHasta",fchExpedienteHasta);
          map.put("p_cEstadoTramite",estadoTramite);
          map.put("p_cTipoAcae",tipoAcae);
          map.put("p_cClsSector",clsSector);
          map.put("p_cClsSubSector",clsSubSector);
          System.out.println("txtDescripcion"+txtDescripcion);
          System.out.println("ubigeoId"+ubigeoId);
          System.out.println("clsTipificacion"+clsTipificacion);
          System.out.println("fchExpedienteDesde"+fchExpedienteDesde);
          System.out.println("fchExpedienteHasta"+fchExpedienteHasta);
          System.out.println("clsSector"+clsSector);
          System.out.println("clsSubSector"+clsSubSector);
          queryForObject("PQ_PROYECTO.BUSCAR", map);
          List rsProyecto=(List)map.get("p_rsProyecto");
          Iterator itProyecto = rsProyecto.iterator();
          List lstProyecto = new ArrayList();
          DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
          while (itProyecto.hasNext()){
                DynaBean bean = (DynaBean)itProyecto.next();
                Proyecto pr = new Proyecto();
                pr.setPryId(Integer.parseInt((String)bean.get("PRYID")));
                pr.setTxtDescripcion((String)bean.get("TXTDESCRIPCION"));
                if (bean.get("PERSONAID")!=null){
                    Proponente prop = new Proponente();
                    Persona p=new Persona();
                    pr.setPersonaId(Integer.parseInt((String)bean.get("PERSONAID")));
                    p.setTxtRazonSocial((String)bean.get("TXTRAZONSOCIAL"));
                    prop.setPersona(p);
                    pr.setProponente(prop);
                    
                }  
                if (bean.get("FCHEXPEDIENTE")!=null){
                    pr.setFchExpediente(df.parse((String)bean.get("FCHEXPEDIENTE")));
                }    
                Ubigeo ubigeo = new Ubigeo();
                ubigeo.setUbigeoId((String)bean.get("UBIGEOID"));
                ubigeo.setTxtDescripcion((String)bean.get("DSCUBIGEO"));
                pr.setUbigeo(ubigeo);
                pr.setClsTipificacion((String)bean.get("CLSTIPIFICACION"));
                pr.setDscClsTipificacion((String)bean.get("DSCTIPIFICACION"));
                pr.setEstadoTramite((String)bean.get("ESTTRAM"));
                lstProyecto.add(pr);
          }
          return lstProyecto;
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Eliminación de Proyecto");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Eliminación de Proyecto presenta problemas");
        }catch(Exception ex){
          ex.printStackTrace();  
          throw new DAOException(ex.toString(),"Error producido en la Eliminación de Proyecto");
        }        
    }
    
    public Proyecto ObtenerProyecto(Integer prjId) throws DAOException{
        try{
          return (Proyecto)queryForObject("ObtenerProyecto",prjId);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Eliminación de Proyecto");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Eliminación de Proyecto presenta problemas");
        }catch(Exception ex){
          ex.printStackTrace();  
          throw new DAOException(ex.toString(),"Error producido en la Eliminación de Proyecto");
        }
    }
    
  
}
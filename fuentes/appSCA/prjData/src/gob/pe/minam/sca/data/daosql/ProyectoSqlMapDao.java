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
import gob.pe.minam.sca.pojo.Proyecto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Danny Espíritu
 * @version 1.0
 */

public class ProyectoSqlMapDao extends BaseSqlMapDao implements ProyectoDao {

  public ProyectoSqlMapDao(DaoManager daoManager){
    super(daoManager);
  }

  public Proyecto getProyecto(Proyecto proyecto) throws DAOException{
    try{
      return (Proyecto) queryForObject("getProyectoByKey", proyecto);
    }catch(SqlMapException ex){
      throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtención de Curso");
    }catch(DaoException ex){
      throw new DAOException(ex.toString(),"Error producido en BD : Obtención de Curso presenta problemas");
    }catch(Exception ex){
      throw new DAOException(ex.toString(),"Error producido en la Carga de Obtención de Curso ");
    }
  }

  public void insertProyecto(Proyecto proyecto) throws DAOException{
    try{
      Map map = new HashMap(); 
      queryForObject("PATT_CURSO.SAV", map);
    }catch(SqlMapException ex){
      throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Inserción de Curso");
    }catch(DaoException ex){
      throw new DAOException(ex.toString(),"Error producido en BD : Inserción de Curso presenta problemas");
    }catch(Exception ex){
      throw new DAOException(ex.toString(),"Error producido en la Inserción de Curso");
    }
  }

  public void deleteProyecto(Proyecto proyecto) throws DAOException{
    try{
      Map map = new HashMap(); 
      queryForObject("PATT_CURSO.DEL", map);
    }catch(SqlMapException ex){
      throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Eliminación de Curso");
    }catch(DaoException ex){
      throw new DAOException(ex.toString(),"Error producido en BD : Eliminación de Curso presenta problemas");
    }catch(Exception ex){
      throw new DAOException(ex.toString(),"Error producido en la Eliminación de Curso");
    }
  }
  
}
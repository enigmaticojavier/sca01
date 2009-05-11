/***********************************************************/
/* File Name: ProyectoSqlMapDao.java                   */
/* Descripcion: Interfase para las clases Dao de Ibatis    */
/* Fecha: Mayo 2009                               	  */
/* Autor: Danny Esp�ritu                                 */
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
 * @author Danny Esp�ritu
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
      throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtenci�n de Curso");
    }catch(DaoException ex){
      throw new DAOException(ex.toString(),"Error producido en BD : Obtenci�n de Curso presenta problemas");
    }catch(Exception ex){
      throw new DAOException(ex.toString(),"Error producido en la Carga de Obtenci�n de Curso ");
    }
  }

  public void insertProyecto(Proyecto proyecto) throws DAOException{
    try{
      Map map = new HashMap(); 
      queryForObject("PATT_CURSO.SAV", map);
    }catch(SqlMapException ex){
      throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Inserci�n de Curso");
    }catch(DaoException ex){
      throw new DAOException(ex.toString(),"Error producido en BD : Inserci�n de Curso presenta problemas");
    }catch(Exception ex){
      throw new DAOException(ex.toString(),"Error producido en la Inserci�n de Curso");
    }
  }

  public void deleteProyecto(Proyecto proyecto) throws DAOException{
    try{
      Map map = new HashMap(); 
      queryForObject("PATT_CURSO.DEL", map);
    }catch(SqlMapException ex){
      throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Eliminaci�n de Curso");
    }catch(DaoException ex){
      throw new DAOException(ex.toString(),"Error producido en BD : Eliminaci�n de Curso presenta problemas");
    }catch(Exception ex){
      throw new DAOException(ex.toString(),"Error producido en la Eliminaci�n de Curso");
    }
  }
  
}
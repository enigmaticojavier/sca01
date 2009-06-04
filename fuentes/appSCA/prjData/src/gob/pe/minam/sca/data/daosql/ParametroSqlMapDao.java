/***********************************************************/
/* File Name: ParametroSqlMapDao.java                   */
/* Descripcion: Interfase para las clases Dao de Ibatis    */
/* Fecha: Mayo 2009                               	  */
/* Autor: Danny Espíritu                                 */
/***********************************************************/
package gob.pe.minam.sca.data.daosql;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import com.ibatis.sqlmap.client.SqlMapException;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.ParametroDao;
import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.pojo.Parametro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Danny Espíritu
 * @version 1.0
 */

public class ParametroSqlMapDao extends BaseSqlMapDao implements ParametroDao {

  public ParametroSqlMapDao(DaoManager daoManager){
    super(daoManager);
  }

  public Parametro getParametro(Integer idParametro) throws DAOException{
    try{
      return (Parametro) queryForObject("getParametroByKey", idParametro);
    }catch(SqlMapException ex){
      throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtención de Curso");
    }catch(DaoException ex){
      throw new DAOException(ex.toString(),"Error producido en BD : Obtención de Curso presenta problemas");
    }catch(Exception ex){
      throw new DAOException(ex.toString(),"Error producido en la Carga de Obtención de Curso ");
    }
  }

  public void insertParametro(Parametro parametro) throws DAOException{
    try{
      insert("insertParametro", parametro);
    }catch(SqlMapException ex){
      throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Inserción de Curso");
    }catch(DaoException ex){
      throw new DAOException(ex.toString(),"Error producido en BD : Inserción de Curso presenta problemas");
    }catch(Exception ex){
      throw new DAOException(ex.toString(),"Error producido en la Inserción de Curso");
    }
  }
  
    public void updateParametro(Parametro parametro) throws DAOException{
      try{
        update("updateParametro", parametro);
      }catch(SqlMapException ex){
        throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Inserción de Curso");
      }catch(DaoException ex){
        throw new DAOException(ex.toString(),"Error producido en BD : Inserción de Curso presenta problemas");
      }catch(Exception ex){
        throw new DAOException(ex.toString(),"Error producido en la Inserción de Curso");
      }
    }

    public void deleteParametro(Integer idParametro) throws DAOException{
        try{
          delete("deleteParametro", idParametro);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Eliminación de Curso");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Eliminación de Curso presenta problemas");
        }catch(Exception ex){
          throw new DAOException(ex.toString(),"Error producido en la Eliminación de Curso");
        }
    }
    
    public List listarTipoParametro() throws DAOException{
      try{
        return queryForList("selectTipoParametro",0);
      }catch(SqlMapException ex){
        throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtención de Curso");
      }catch(DaoException ex){
        throw new DAOException(ex.toString(),"Error producido en BD : Obtención de Curso presenta problemas");
      }catch(Exception ex){
        throw new DAOException(ex.toString(),"Error producido en la Carga de Obtención de Curso ");
      }
    }
    
    public List findParametroXTipoParametro(String tipParametro) throws DAOException{
        try{
          return queryForList("findParametroXTipoParametro",tipParametro);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtención de Parametro");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Obtención de Parametro presenta problemas");
        }catch(Exception ex){
          throw new DAOException(ex.toString(),"Error producido en la Carga de Obtención de Parametro ");
        }  
    }
    
    public Parametro findParametroXParametro(String tipParametro, String codParametro) throws DAOException{
        try{
            Parametro p = new Parametro();
            p.setTipParametro(tipParametro);
            p.setCodParametro(codParametro);
            return (Parametro) queryForObject("findParametroXParametro", p);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtención de Parametro");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Obtención de Parametro presenta problemas");
        }catch(Exception ex){
          throw new DAOException(ex.toString(),"Error producido en la Carga de Obtención de Parametro ");
        }  
    }
    
    
  
}
/***********************************************************/
/* File Name: UbigeoSqlMapDao.java                   */
/* Descripcion: Interfase para las clases Dao de Ibatis    */
/* Fecha: Mayo 2009                               	  */
/* Autor: Danny Espíritu                                 */
/***********************************************************/
package gob.pe.minam.sca.data.daosql;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import com.ibatis.sqlmap.client.SqlMapException;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.UbigeoDao;
import gob.pe.minam.sca.framework.exception.DAOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Danny Espíritu
 * @version 1.0
 */

public class UbigeoSqlMapDao extends BaseSqlMapDao implements UbigeoDao {

    public UbigeoSqlMapDao(DaoManager daoManager){
        super(daoManager);
    }

    public List listarDepartamento() throws DAOException{
      try{
        return queryForList("selectDepartamento",0);
      }catch(SqlMapException ex){
        throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtención de Ubigeo");
      }catch(DaoException ex){
        throw new DAOException(ex.toString(),"Error producido en BD : Obtención de Ubigeo presenta problemas");
      }catch(Exception ex){
        throw new DAOException(ex.toString(),"Error producido en la Carga de Obtención de Ubigeo ");
      }
    }
    
}
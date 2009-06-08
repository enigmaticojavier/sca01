/***********************************************************/
/* File Name: UbigeoSqlMapDao.java                   */
/* Descripcion: Interfase para las clases Dao de Ibatis    */
/* Fecha: Mayo 2009                               	  */
/* Autor: Danny Esp�ritu                                 */
/***********************************************************/
package gob.pe.minam.sca.data.daosql;
import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import com.ibatis.sqlmap.client.SqlMapException;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.UbigeoDao;
import gob.pe.minam.sca.framework.exception.DAOException;

import gob.pe.minam.sca.pojo.Ubigeo;

import java.util.List;


/**
 * @author Danny Esp�ritu
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
         throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtenci�n de Ubigeo");
       }catch(DaoException ex){
         throw new DAOException(ex.toString(),"Error producido en BD : Obtenci�n de Ubigeo presenta problemas");
       }catch(Exception ex){
         throw new DAOException(ex.toString(),"Error producido en la Carga de Obtenci�n de Ubigeo ");
       }
     }

    
     public List listarProvincia(Ubigeo ubigeo) throws DAOException {        
         try{
             return (List)queryForList("selectProvincia",ubigeo); 
         }catch(SqlMapException ex){
           throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtenci�n de Ubigeo");
         }catch(DaoException ex){
           throw new DAOException(ex.toString(),"Error producido en BD : Obtenci�n de Ubigeo presenta problemas");
         }catch(Exception ex){
           throw new DAOException(ex.toString(),"Error producido en la Carga de Obtenci�n de Ubigeo ");
         }
     }

     public List listarDistrito(Ubigeo ubigeo) {
         return (List)queryForList("selectDistrito",ubigeo);
     }
 }
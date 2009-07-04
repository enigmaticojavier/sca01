package gob.pe.minam.sca.data.daosql;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import com.ibatis.sqlmap.client.SqlMapException;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.PeriodoDao;
import gob.pe.minam.sca.framework.exception.DAOException;

import java.util.List;

public class PeriodoSqlMapDao extends BaseSqlMapDao implements PeriodoDao{
    public PeriodoSqlMapDao(DaoManager daoManager){
      super(daoManager);
    }
    public List listarPeriodo() throws DAOException{
        try{
          return queryForList("SelectAllPeriodo",0);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtenci�n de Estadistica");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Obtenci�n de Estadistica presenta problemas");
        }catch(Exception ex){
          throw new DAOException(ex.toString(),"Error producido en la Carga de Obtenci�n de Estadistica ");
        }  
    }
    public List listarPeriodoReporte(int nroDias) throws DAOException{
        try{
          return queryForList("SelectPeriodoReporte",nroDias);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtenci�n de Estadistica");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Obtenci�n de Estadistica presenta problemas");
        }catch(Exception ex){
          throw new DAOException(ex.toString(),"Error producido en la Carga de Obtenci�n de Estadistica ");
        }  
    }
}

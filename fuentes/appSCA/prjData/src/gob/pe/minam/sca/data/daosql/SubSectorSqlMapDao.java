package gob.pe.minam.sca.data.daosql;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.sqlmap.client.SqlMapException;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.SubSectorDao;

import gob.pe.minam.sca.framework.exception.DAOException;

import gob.pe.minam.sca.pojo.SubSector;

import java.util.List;

public class SubSectorSqlMapDao  extends BaseSqlMapDao implements SubSectorDao  {
    
    public SubSectorSqlMapDao(DaoManager daoManager){
        super(daoManager);
    }
    
    public List buscarSubSectorXSector(String sector) throws DAOException{
        try{
          return queryForList("SelectSubsectorBySector",sector);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtención de SubSector");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Obtención de SubSector presenta problemas");
        }catch(Exception ex){
          throw new DAOException(ex.toString(),"Error producido en la Carga de Obtención de SubSector ");
        }  
    }
    
    public SubSector obtenerSubsector(SubSector subSector) throws DAOException{
        try{
          return (SubSector)queryForObject("ObtenerSubsector",subSector);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtención de SubSector");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Obtención de SubSector presenta problemas");
        }catch(Exception ex){
          throw new DAOException(ex.toString(),"Error producido en la Carga de Obtención de SubSector ");
        }  
    }
    
}

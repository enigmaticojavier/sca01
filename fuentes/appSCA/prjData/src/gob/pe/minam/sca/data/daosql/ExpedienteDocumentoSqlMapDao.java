package gob.pe.minam.sca.data.daosql;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.sqlmap.client.SqlMapException;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.ExpedienteDocumentoDao;
import gob.pe.minam.sca.framework.exception.DAOException;

import java.util.List;

public class ExpedienteDocumentoSqlMapDao extends BaseSqlMapDao implements ExpedienteDocumentoDao{
    public ExpedienteDocumentoSqlMapDao(DaoManager daoManager){
      super(daoManager);
    }
    public List buscarExDocXProy (Integer pryId) throws DAOException{
        try{
          return queryForList("BUSCAREXPDOCXPRY",pryId);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la ImagenDocumento de Proyecto");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Eliminación de ImagenDocumento presenta problemas");
        }catch(Exception ex){
          ex.printStackTrace();  
          throw new DAOException(ex.toString(),"Error producido en la Eliminación de ImagenDocumento");
        }      
    }
}

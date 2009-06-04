package gob.pe.minam.sca.data.daosql;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import com.ibatis.sqlmap.client.SqlMapException;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.ImagenDocumentoDao;
import gob.pe.minam.sca.framework.exception.DAOException;

import java.util.List;

public class ImagenDocumentoSqlMapDao extends BaseSqlMapDao implements ImagenDocumentoDao{
    public ImagenDocumentoSqlMapDao(DaoManager daoManager){
      super(daoManager);
    }
    public List buscarImgXDoc(Integer docId) throws DAOException{
        try{
          return queryForList("BUSCARIMAGENXDOC",docId);  
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

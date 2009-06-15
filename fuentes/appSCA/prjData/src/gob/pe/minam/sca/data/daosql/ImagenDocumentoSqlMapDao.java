package gob.pe.minam.sca.data.daosql;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapException;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.ImagenDocumentoDao;
import gob.pe.minam.sca.framework.exception.DAOException;

import gob.pe.minam.sca.pojo.ImagenDocumento;
import gob.pe.minam.sca.pojo.Parametro;

import java.util.List;

public class ImagenDocumentoSqlMapDao extends BaseSqlMapDao implements ImagenDocumentoDao{
    public ImagenDocumentoSqlMapDao(DaoManager daoManager){
      super(daoManager);
    }
    
    public void insertImagenDocumento(ImagenDocumento imagenDocumento) throws DAOException{
        try{
          insert("insertImagenDocumento", imagenDocumento);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Inserción de ImagenDocumento");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Inserción de ImagenDocumento presenta problemas");
        }catch(Exception ex){
          throw new DAOException(ex.toString(),"Error producido en la Inserción de ImagenDocumento");
        }
    }
    
    public void updateImagenDocumento(ImagenDocumento imagenDocumento) throws DAOException{
        try{
            update("updateImagenDocumento", imagenDocumento);
        }catch(SqlMapException ex){
            throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Inserción de ImagenDocumento");
        }catch(DaoException ex){
            throw new DAOException(ex.toString(),"Error producido en BD : Inserción de ImagenDocumento presenta problemas");
        }catch(Exception ex){
            throw new DAOException(ex.toString(),"Error producido en la Inserción de ImagenDocumento");
        }
    }

    public List buscarImgXDoc(Integer docId) throws DAOException{
        try{
          return queryForList("BuscarImagenXDoc",docId);  
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la ImagenDocumento de Proyecto");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Eliminación de ImagenDocumento presenta problemas");
        }catch(Exception ex){
          ex.printStackTrace();  
          throw new DAOException(ex.toString(),"Error producido en la Eliminación de ImagenDocumento");
        }      
    }
    
    public boolean existeImagenDocumento(int docId) throws DAOException{
        try{
          int cont = ((Integer)queryForObject("ExisteImagenDocumento",docId)).intValue();
          if (cont>0) return true;
          else return false;
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Inserción de ControlEnvio");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Inserción de ControlEnvio presenta problemas");
        }catch(Exception ex){
          throw new DAOException(ex.toString(),"Error producido en la Inserción de ControlEnvio");
        }
    }
    
}

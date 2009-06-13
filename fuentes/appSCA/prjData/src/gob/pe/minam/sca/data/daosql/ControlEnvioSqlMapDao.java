package gob.pe.minam.sca.data.daosql;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.sqlmap.client.SqlMapException;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.ControlEnvioDao;
import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.pojo.ControlEnvio;


public class ControlEnvioSqlMapDao extends BaseSqlMapDao implements ControlEnvioDao {
    public ControlEnvioSqlMapDao(DaoManager daoManager){
      super(daoManager);
    }    
    
    public ControlEnvio obtenerControlEnvioXPeriodo(String periodo) throws DAOException{
        try{
          return (ControlEnvio)queryForObject("SelectControlEnvio",periodo);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtención de Control Envio");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Obtención de Control Envio presenta problemas");
        }catch(Exception ex){
          throw new DAOException(ex.toString(),"Error producido en la Carga de Obtención de Control Envio");
        } 
    }
    
    public boolean existeControlEnvio(String periodo) throws DAOException{
        try{
          int cont = ((Integer)queryForObject("existeControlEnvio",periodo)).intValue();
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
    
    public void insertControlEnvio(ControlEnvio controlEnvio) throws DAOException{
        try{
          insert("insertControlEnvio", controlEnvio);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Inserción de ControlEnvio");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Inserción de ControlEnvio presenta problemas");
        }catch(Exception ex){
          throw new DAOException(ex.toString(),"Error producido en la Inserción de ControlEnvio");
        }
    }
    
    public void updateControlEnvio(ControlEnvio controlEnvio) throws DAOException{
        try{
          update("updateControlEnvio", controlEnvio);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Inserción de ControlEnvio");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Inserción de ControlEnvio presenta problemas");
        }catch(Exception ex){
          throw new DAOException(ex.toString(),"Error producido en la Inserción de ControlEnvio");
        }
    }
}
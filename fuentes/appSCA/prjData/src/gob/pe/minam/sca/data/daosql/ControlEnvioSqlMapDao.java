package gob.pe.minam.sca.data.daosql;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.sqlmap.client.SqlMapException;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.ControlEnvioDao;
import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.pojo.ControlEnvio;
import gob.pe.minam.sca.pojo.Persona;
import gob.pe.minam.sca.pojo.Proponente;
import gob.pe.minam.sca.pojo.Proyecto;
import gob.pe.minam.sca.pojo.Ubigeo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.DynaBean;


public class ControlEnvioSqlMapDao extends BaseSqlMapDao implements ControlEnvioDao {
    public ControlEnvioSqlMapDao(DaoManager daoManager){
      super(daoManager);
    }    
    
    public ControlEnvio obtenerControlEnvioXPeriodo(String periodo, int personaId) throws DAOException{
        try{
            ControlEnvio cntEnv = new ControlEnvio();
            cntEnv.setPeriodo(periodo);
            cntEnv.setPersonaId(personaId);
            return (ControlEnvio)queryForObject("SelectControlEnvio",cntEnv);
        }catch(SqlMapException ex){
            throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtención de Control Envio");
        }catch(DaoException ex){
            throw new DAOException(ex.toString(),"Error producido en BD : Obtención de Control Envio presenta problemas");
        }catch(Exception ex){
            throw new DAOException(ex.toString(),"Error producido en la Carga de Obtención de Control Envio");
        } 
    }
    
    public boolean existeControlEnvio(String periodo, int personaId) throws DAOException{
        try{
            ControlEnvio cntEnv = new ControlEnvio();
            cntEnv.setPeriodo(periodo);
            cntEnv.setPersonaId(personaId);
            int cont = ((Integer)queryForObject("existeControlEnvio",cntEnv)).intValue();
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
    
    public void controlEnvioLimpiaTabla(String tipoArchivo, int numAcae, String periodo) throws DAOException{
        try{
          Map map = new HashMap();
          map.put("as_archivo",tipoArchivo);
          map.put("al_numacae",numAcae);
          map.put("as_periodo",periodo);
          queryForObject("USP_000_LIMPIA_TABLAT", map);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar controlEnvioLimpiaTabla");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : controlEnvioLimpiaTabla presenta problemas");
        }catch(Exception ex){
          ex.printStackTrace();  
          throw new DAOException(ex.toString(),"Error producido en controlEnvioLimpiaTabla");
        }        
    }
}
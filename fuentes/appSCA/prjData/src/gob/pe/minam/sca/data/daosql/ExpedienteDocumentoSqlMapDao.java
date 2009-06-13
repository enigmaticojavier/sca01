package gob.pe.minam.sca.data.daosql;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.sqlmap.client.SqlMapException;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.ExpedienteDocumentoDao;
import gob.pe.minam.sca.framework.exception.DAOException;

import gob.pe.minam.sca.pojo.Expediente;
import gob.pe.minam.sca.pojo.ExpedienteDocumento;

import gob.pe.minam.sca.pojo.ExpedientePaso;

import java.util.List;

public class ExpedienteDocumentoSqlMapDao extends BaseSqlMapDao implements ExpedienteDocumentoDao{
    public ExpedienteDocumentoSqlMapDao(DaoManager daoManager){
      super(daoManager);
    }
    
    public List buscarExDocXProy (Integer pryId) throws DAOException{
        try{
          return queryForList("BuscarExpDocXPry",pryId);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la ExpedienteDocumento de Proyecto");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Eliminación de ExpedienteDocumento presenta problemas");
        }catch(Exception ex){
          ex.printStackTrace();  
          throw new DAOException(ex.toString(),"Error producido en la Eliminación de ExpedienteDocumento");
        }      
    }
    
    public List buscarExDocXPeriodoPersona(String periodo, int personaId) throws DAOException{
        try{
          ExpedienteDocumento expdoc=new ExpedienteDocumento();
          ExpedientePaso exppas = new ExpedientePaso();
          Expediente exp = new Expediente();
          exppas.setPeriodo(periodo);
          exp.setPersonaId(personaId);
          exppas.setExpediente(exp);
          expdoc.setExpedientePaso(exppas);
          return queryForList("BuscarExpDocXPeriodoPersonaId",expdoc);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la ExpedienteDocumento de Proyecto");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Eliminación de ExpedienteDocumento presenta problemas");
        }catch(Exception ex){
          ex.printStackTrace();  
          throw new DAOException(ex.toString(),"Error producido en la Eliminación de ExpedienteDocumento");
        }      
    }
    
}

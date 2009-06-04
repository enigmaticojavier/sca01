package gob.pe.minam.sca.data.daosql;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import com.ibatis.sqlmap.client.SqlMapException;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.ExpedienteDao;
import gob.pe.minam.sca.framework.exception.DAOException;

import gob.pe.minam.sca.vo.EstadisticaVo;

import java.util.List;

public class ExpedienteSqlMapDao extends BaseSqlMapDao implements ExpedienteDao {
    public ExpedienteSqlMapDao(DaoManager daoManager){
      super(daoManager);
    }    
    public List listarEstadistica(String tipAcae, String periodo) throws DAOException{
        try{
          EstadisticaVo est=new EstadisticaVo();
          est.setPeriodo(periodo);
          est.setTipAcae(tipAcae);
          return queryForList("ListarEstadistica",est);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Obtención de Estadistica");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Obtención de Estadistica presenta problemas");
        }catch(Exception ex){
          throw new DAOException(ex.toString(),"Error producido en la Carga de Obtención de Estadistica ");
        } 
    }
}

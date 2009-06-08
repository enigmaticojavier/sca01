package gob.pe.minam.sca.data.daosql;

import java.util.List;

import com.ibatis.dao.client.DaoManager;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.AcaeDao;
import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.framework.exception.NegocioException;
import gob.pe.minam.sca.pojo.Acae;

public class AcaeSqlMapDao extends BaseSqlMapDao implements AcaeDao {
	
   public AcaeSqlMapDao(DaoManager daoManager) {
        super(daoManager);
   }
	  
   public Acae getAcaeByKey(Acae acae) throws DAOException {
        return (Acae) queryForObject("getAcaeByKey", acae);
   }

   public List getAcae(Acae acae) throws DAOException {
	return (List) queryForList("getAcae", acae);
   }
   
   public void insertAcae(Acae acae) throws DAOException {
        insert("insertAcae", acae);
   }
   
   public void updateAcae(Acae acae) throws DAOException {
        update("updateAcae", acae);
   }
   
   public void deleteAcae(Acae acae) throws DAOException {
        delete("deleteAcae", acae);
   }

}

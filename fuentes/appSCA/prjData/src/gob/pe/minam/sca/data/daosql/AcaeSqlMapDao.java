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

   public List<Acae> getAcae(Acae acae) throws DAOException {
	   return (List<Acae>) queryForList("getAcae", acae);
   }
   
   public Object insertAcae(Acae acae) throws DAOException {
	   return (Object) insert("insertAcae", acae);
   }
   
   public int updateAcae(Acae acae) throws DAOException {
	   return update("updateAcae", acae);
   }
   
   public void deleteAcae(Acae acae) throws DAOException {
	   delete("deleteAcae", acae);
   }

}

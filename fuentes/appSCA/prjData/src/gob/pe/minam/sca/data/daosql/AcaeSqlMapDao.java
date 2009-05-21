package gob.pe.minam.sca.data.daosql;

import java.util.List;

import com.ibatis.dao.client.DaoManager;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.AcaeDao;
import gob.pe.minam.sca.pojo.Acae;

public class AcaeSqlMapDao extends BaseSqlMapDao implements AcaeDao {
	
   public AcaeSqlMapDao(DaoManager daoManager) {
		    super(daoManager);
   }
	  
   public Acae getAcaeByKey(Acae acae) {
	    return (Acae) queryForObject("getAcaeByKey", acae);
   }

   public List getAcae(Acae acae) {
	   return (List) queryForList("getAcae", acae);
   }
   
   public Acae insertAcae(Acae acae) {
	   return (Acae) queryForObject("insertAcae", acae);
   }
   
   public Acae updateAcae(Acae acae) {
	   return (Acae) queryForObject("updateAcae", acae);
   }
   
   public void deleteAcae(Acae acae) {
	   queryForObject("deleteAcae", acae);
   }

}

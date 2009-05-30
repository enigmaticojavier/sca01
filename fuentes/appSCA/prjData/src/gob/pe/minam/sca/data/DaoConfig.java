package gob.pe.minam.sca.data;

import com.ibatis.common.resources.Resources;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoManagerBuilder;
import java.io.Reader;


public class DaoConfig{

  private static final DaoManager daoManager;

  static {
    try {
      String resource = "gob/pe/minam/sca/data/Dao.xml";
      Reader reader = Resources.getResourceAsReader(resource);
      daoManager = DaoManagerBuilder.buildDaoManager(reader);
    } catch (Exception ex){
      throw new RuntimeException("No se puede inicializar DaoConfig.  Causa: " + ex.toString());
    }
  }

  public static DaoManager getDaomanager(){
    return daoManager;
  }

}
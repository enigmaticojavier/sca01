/***********************************************************/
/* File Name: ProyectoService.java                         */
/* Descripcion: Codigo ejemplo de clase service manejo de  */
/*              Dao de Ibatis (Implementa Singleton)       */
/* Fecha: Mayo 2009                               	   */
/* Autor: Danny Espíritu                                   */
/***********************************************************/
package gob.pe.minam.sca.data;

import com.ibatis.dao.client.DaoManager;

import gob.pe.minam.sca.data.DaoConfig;
import gob.pe.minam.sca.data.dao.AcaeDao;
import gob.pe.minam.sca.data.dao.ParametroDao;
import gob.pe.minam.sca.data.dao.ProyectoDao;
import gob.pe.minam.sca.data.dao.UsuarioDao;

/**
 * @author Danny Espíritu
 * @author Dante Antiporta
 * @version 1.1 - 14/05/2009
 * @version 1.0 - 10/05/2009
 */

public class ProyectoService {

  /* Constants */

  private static ProyectoService instance = new ProyectoService();

  /* Private Fields */

  private DaoManager daoManager = DaoConfig.getDaomanager();
  private ProyectoDao  proyectoDao;
  private ParametroDao parametroDao;
  private UsuarioDao usuarioDao;
  private AcaeDao acaeDao;
  
  /* Constructors */

  public ProyectoService() {
    proyectoDao   = 	 (ProyectoDao)daoManager.getDao(ProyectoDao.class);
    parametroDao  = 	 (ParametroDao)daoManager.getDao(ParametroDao.class);
    usuarioDao  = 	 (UsuarioDao)daoManager.getDao(UsuarioDao.class);
    acaeDao  = 	 (AcaeDao)daoManager.getDao(AcaeDao.class);
  }

  /* Get Instance */

  public static ProyectoService getInstance() {
    if (instance == null)
    {
      instance = new ProyectoService();
    }
    return instance;
  }

  /* Public Methods */

  public ProyectoDao getProyectoDao() {
    return proyectoDao;
  }
  
  public ParametroDao getParametroDao() {
    return parametroDao;
  }
  
  public UsuarioDao getUsuarioDao() {
	return usuarioDao;
  }
  
  public AcaeDao getAcaeDao() {
	return acaeDao;
  }  
  
}
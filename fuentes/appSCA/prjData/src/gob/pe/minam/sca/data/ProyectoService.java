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
import gob.pe.minam.sca.data.dao.ControlEnvioDao;
import gob.pe.minam.sca.data.dao.ExpedienteDao;
import gob.pe.minam.sca.data.dao.ExpedienteDocumentoDao;
import gob.pe.minam.sca.data.dao.ImagenDocumentoDao;
import gob.pe.minam.sca.data.dao.ParametroDao;
import gob.pe.minam.sca.data.dao.PeriodoDao;
import gob.pe.minam.sca.data.dao.PersonaDao;
import gob.pe.minam.sca.data.dao.ProyectoDao;
import gob.pe.minam.sca.data.dao.SubSectorDao;
import gob.pe.minam.sca.data.dao.UbigeoDao;
import gob.pe.minam.sca.data.dao.UsuarioDao;

/**
 * @author Danny Espíritu
 * @version 1.0
 */

public class ProyectoService {

  /* Constants */
  private static ProyectoService instance = new ProyectoService();

  /* Private Fields */
  private DaoManager daoManager = DaoConfig.getDaomanager();
  private ProyectoDao  proyectoDao;
  private ParametroDao parametroDao;
  private UbigeoDao ubigeoDao;
  private SubSectorDao subSectorDao;
  private ExpedienteDocumentoDao expedienteDocumentoDao;
  private ImagenDocumentoDao imagenDocumentoDao;
  private AcaeDao acaeDao;
  private UsuarioDao usuarioDao;
  private ExpedienteDao expedienteDao;
  private PeriodoDao periodoDao;
  private PersonaDao personaDao;
  private ControlEnvioDao controlEnvioDao;
  
  /* Constructors */

  public ProyectoService() {
    proyectoDao            = (ProyectoDao)daoManager.getDao(ProyectoDao.class);
    parametroDao           = (ParametroDao)daoManager.getDao(ParametroDao.class);
    subSectorDao           = (SubSectorDao)daoManager.getDao(SubSectorDao.class);
    ubigeoDao              = (UbigeoDao)daoManager.getDao(UbigeoDao.class);
    expedienteDocumentoDao = (ExpedienteDocumentoDao)daoManager.getDao(ExpedienteDocumentoDao.class);
    imagenDocumentoDao     = (ImagenDocumentoDao)daoManager.getDao(ImagenDocumentoDao.class);
    expedienteDao          = (ExpedienteDao)daoManager.getDao(ExpedienteDao.class);
    periodoDao             = (PeriodoDao)daoManager.getDao(PeriodoDao.class);
    acaeDao                = (AcaeDao)daoManager.getDao(AcaeDao.class);
    usuarioDao             = (UsuarioDao)daoManager.getDao(UsuarioDao.class);
    controlEnvioDao        = (ControlEnvioDao)daoManager.getDao(ControlEnvioDao.class);
    personaDao             = (PersonaDao)daoManager.getDao(PersonaDao.class);
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

  public ExpedienteDocumentoDao getExpedienteDocumentoDao() {
    return expedienteDocumentoDao;
  }

  public ImagenDocumentoDao getImagenDocumentoDao() {
    return imagenDocumentoDao;
  }

  public UbigeoDao getUbigeoDao() {
    return ubigeoDao;
  }
  
  public SubSectorDao getSubSectorDao() {
    return subSectorDao;
  }
   
  public AcaeDao getAcaeDao() {
    return acaeDao;
  }

  public UsuarioDao getUsuarioDao() {
    return usuarioDao;
  }
  
  public ExpedienteDao getExpedienteDao(){
    return expedienteDao;
  }
  
    public PeriodoDao getPeriodoDao(){
      return periodoDao;
    }
	
    public ControlEnvioDao getControlEnvioDao() {
	  
        return controlEnvioDao;
    }
    
    public PersonaDao getPersonaDao() {
        return personaDao;
    }
}

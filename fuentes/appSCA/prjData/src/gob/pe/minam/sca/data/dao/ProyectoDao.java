/***********************************************************/
/* File Name: ProyectoDao.java                           */
/* Descripción: Interfase para las clases Dao de Ibatis  */
/* Fecha: Mayo 2009                               	 */
/* Autor: Danny Espíritu                                 */
/***********************************************************/
package gob.pe.minam.sca.data.dao;

import gob.pe.minam.sca.framework.exception.DAOException;

import gob.pe.minam.sca.pojo.Proyecto;

import java.util.Date;
import java.util.List;

/**
 * @author Danny Espíritu
 * @version 1.0
 */

public interface ProyectoDao {
  
  public List buscarProyecto (String txtDescripcion, String ubigeoId,
                              String clsTipificacion, String fchExpedienteDesde, 
                              String fchExpedienteHasta, String estadoTramite, 
                              String tipoAcae, String clsSector, String clsSubSector) throws DAOException;

  public Proyecto ObtenerProyecto(Integer prjId) throws DAOException;
  
  public List buscarRanking(String clsTipificacion,/*categoria*/ String estadoTramite, /*Estado Tramite*/
                               String tipoPersoneria, String proponente,
                               String tipoAcae, String clsSector, /*Institución*/ String clsSubSector, /*Dependencia*/
                               String codDepartamento, String codProvincia, String codDistrito, 
                               String anoPresentacion, String tipDocTramite) throws DAOException;
                               
  public List buscarRankingDetalle(String clsTipificacion,/*categoria*/ String estadoTramite, /*Estado Tramite*/
                                  String proponente, String tipoAcae, String clsSector, /*Institución*/ String clsSubSector, /*Dependencia*/
                                  String codDepartamento, String codProvincia, String codDistrito, 
                                  String anoPresentacion, String tipDocTramite, String ordenRanking) throws DAOException;
                                      
  public List buscarRankingReporte( String clsTipificacion,/*categoria*/ String estadoTramite, /*Estado Tramite*/
                                    String tipoPersoneria, String proponente,
                                    String tipoAcae, String clsSector, /*Institución*/ String clsSubSector, /*Dependencia*/
                                    String codDepartamento, String codProvincia, String codDistrito, 
                                    String anoPresentacion, String tipDocTramite) throws DAOException;
  
}
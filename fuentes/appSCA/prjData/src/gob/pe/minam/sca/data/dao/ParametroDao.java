/***********************************************************/
/* File Name: ProyectoDao.java                           */
/* Descripci�n: Interfase para las clases Dao de Ibatis  */
/* Fecha: Mayo 2009                               	 */
/* Autor: Danny Esp�ritu                                 */
/***********************************************************/
package gob.pe.minam.sca.data.dao;

import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.pojo.Parametro;

import java.util.List;

/**
 * @author Danny Esp�ritu
 * @version 1.0
 */

public interface ParametroDao {

  public Parametro getParametro(Integer idParametro) throws DAOException;

  public void insertParametro(Parametro parametro) throws DAOException;
  
  public void updateParametro(Parametro parametro) throws DAOException;

  public void deleteParametro(Integer idParametro) throws DAOException;
  
  public List listarTipoParametro() throws DAOException;
  
  public List findParametroXTipoParametro(String tipParametro) throws DAOException;
  
}
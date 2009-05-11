/***********************************************************/
/* File Name: ProyectoDao.java                           */
/* Descripci�n: Interfase para las clases Dao de Ibatis  */
/* Fecha: Mayo 2009                               	 */
/* Autor: Danny Esp�ritu                                 */
/***********************************************************/
package gob.pe.minam.sca.data.dao;

import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.pojo.Proyecto;

/**
 * @author Danny Esp�ritu
 * @version 1.0
 */

public interface ProyectoDao {

  public Proyecto getProyecto(Proyecto proyecto) throws DAOException;

  public void insertProyecto(Proyecto proyecto) throws DAOException;

  public void deleteProyecto(Proyecto proyecto) throws DAOException;
  
}
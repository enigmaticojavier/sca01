/***********************************************************/
/* File Name: UbigeoDao.java                           */
/* Descripción: Interfase para las clases Dao de Ibatis  */
/* Fecha: Mayo 2009                               	 */
/* Autor: Danny Espíritu                                 */
/***********************************************************/
package gob.pe.minam.sca.data.dao;

import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.pojo.Parametro;

import java.util.List;

/**
 * @author Danny Espíritu
 * @version 1.0
 */

public interface UbigeoDao {

  public List listarDepartamento() throws DAOException;
  
}
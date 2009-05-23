/***********************************************************/
/* File Name: AcaeDao.java                           */
/* Descripción: Interfase para las clases Dao de Ibatis  */
/* Fecha: Mayo 2009                               	 */
/* Autor: Dante Antiporta                                 */
/***********************************************************/
package gob.pe.minam.sca.data.dao;

import java.util.List;

import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.pojo.Acae;

public interface AcaeDao {

	  public Acae getAcaeByKey(Acae acae) throws DAOException;

	  public List<Acae> getAcae(Acae acae) throws DAOException;

	  public Object insertAcae(Acae acae) throws DAOException;

	  public int updateAcae(Acae acae) throws DAOException;

	  public void deleteAcae(Acae acae) throws DAOException;

}
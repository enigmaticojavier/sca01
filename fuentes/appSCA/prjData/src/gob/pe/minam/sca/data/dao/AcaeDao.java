/***********************************************************/
/* File Name: UsuarioDao.java                           */
/* Descripción: Interfase para las clases Dao de Ibatis  */
/* Fecha: Mayo 2009                               	 */
/* Autor: Dante Antiporta                                 */
/***********************************************************/
package gob.pe.minam.sca.data.dao;

import java.util.List;

import gob.pe.minam.sca.pojo.Acae;

public interface AcaeDao {

	  public Acae getAcaeByKey(Acae acae);

	  public List getAcae(Acae acae);

	  public Acae insertAcae(Acae acae);

	  public Acae updateAcae(Acae acae);

	  public void deleteAcae(Acae acae);

}
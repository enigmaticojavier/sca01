/***********************************************************/
/* File Name: ExpedienteDao.java                           */
/* Descripción: Interfase para las clases Dao de Ibatis  */
/* Fecha: Mayo 2009                               	 */
/* Autor: Danny Espíritu                                 */
/***********************************************************/
package gob.pe.minam.sca.data.dao;

import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.vo.EstadisticaVo;

import java.util.List;

public interface ExpedienteDao {
    public List listarEstadistica(String tipAcae, String periodo) throws DAOException;
}

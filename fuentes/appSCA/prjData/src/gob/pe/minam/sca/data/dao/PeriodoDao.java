/***********************************************************/
/* File Name: ExpedienteDao.java                           */
/* Descripción: Interfase para las clases Dao de Ibatis  */
/* Fecha: Mayo 2009                               	 */
/* Autor: Danny Espíritu                                 */
/***********************************************************/
package gob.pe.minam.sca.data.dao;

import gob.pe.minam.sca.framework.exception.DAOException;

import java.util.List;

public interface PeriodoDao {
    public List listarPeriodo() throws DAOException;
    public List listarPeriodoReporte(int nroDias) throws DAOException;
}

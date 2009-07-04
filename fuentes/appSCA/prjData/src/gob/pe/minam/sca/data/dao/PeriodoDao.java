/***********************************************************/
/* File Name: ExpedienteDao.java                           */
/* Descripci�n: Interfase para las clases Dao de Ibatis  */
/* Fecha: Mayo 2009                               	 */
/* Autor: Danny Esp�ritu                                 */
/***********************************************************/
package gob.pe.minam.sca.data.dao;

import gob.pe.minam.sca.framework.exception.DAOException;

import java.util.List;

public interface PeriodoDao {
    public List listarPeriodo() throws DAOException;
    public List listarPeriodoReporte(int nroDias) throws DAOException;
}

/***********************************************************/
/* File Name: ControlEnvioDao.java                           */
/* Descripci�n: Interfase para las clases Dao de Ibatis  */
/* Fecha: Mayo 2009                               	 */
/* Autor: Danny Esp�ritu                                 */
/***********************************************************/
package gob.pe.minam.sca.data.dao;

import gob.pe.minam.sca.framework.exception.DAOException;

import gob.pe.minam.sca.pojo.ControlEnvio;

public interface ControlEnvioDao{
    public ControlEnvio obtenerControlEnvioXPeriodo(String periodo) throws DAOException;
}

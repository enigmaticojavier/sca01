/***********************************************************/
/* File Name: ControlEnvioDao.java                           */
/* Descripción: Interfase para las clases Dao de Ibatis  */
/* Fecha: Mayo 2009                               	 */
/* Autor: Danny Espíritu                                 */
/***********************************************************/
package gob.pe.minam.sca.data.dao;

import gob.pe.minam.sca.framework.exception.DAOException;

import gob.pe.minam.sca.pojo.ControlEnvio;

public interface ControlEnvioDao{
    public ControlEnvio obtenerControlEnvioXPeriodo(String periodo, int personaId) throws DAOException;
    public void insertControlEnvio(ControlEnvio controlEnvio) throws DAOException;
    public void updateControlEnvio(ControlEnvio controlEnvio) throws DAOException;
    public boolean existeControlEnvio(String periodo, int personaId) throws DAOException;
    public void controlEnvioLimpiaTabla(String tipoArchivo, int numAcae, String periodo) throws DAOException;
}

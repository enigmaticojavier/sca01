/***********************************************************/
/* File Name: UbigeoDao.java                           */
/* Descripci�n: Interfase para las clases Dao de Ibatis  */
/* Fecha: Mayo 2009                               	 */
/* Autor: Danny Esp�ritu                                 */
/***********************************************************/
package gob.pe.minam.sca.data.dao;

import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.pojo.Parametro;

import gob.pe.minam.sca.pojo.Ubigeo;

import java.util.List;

/**
 * @author Danny Esp�ritu
 * @version 1.0
 */

 public interface UbigeoDao {

   public List listarDepartamento() throws DAOException;
   
   public List listarProvincia(Ubigeo ubigeo) throws DAOException;
   
   public List listarDistrito(Ubigeo ubigeo) throws DAOException;
 }
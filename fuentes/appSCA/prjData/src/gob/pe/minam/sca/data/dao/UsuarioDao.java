/***********************************************************/
/* File Name: UsuarioDao.java                           */
/* Descripción: Interfase para las clases Dao de Ibatis  */
/* Fecha: Mayo 2009                               	 */
/* Autor: Dante Antiporta                                 */
/***********************************************************/
package gob.pe.minam.sca.data.dao;

import java.util.List;

import gob.pe.minam.sca.pojo.Usuario;

public interface UsuarioDao {

      public Usuario getUsuarioByKey(Usuario usuario);

      public List getUsuario(Usuario usuario);

      public void insertUsuario(Usuario usuario);

      public void updateUsuario(Usuario usuario);

      public void deleteUsuario(Usuario usuario);

}
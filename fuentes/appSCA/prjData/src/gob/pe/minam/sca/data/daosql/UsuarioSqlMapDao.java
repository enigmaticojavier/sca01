package gob.pe.minam.sca.data.daosql;

import java.util.List;

import com.ibatis.dao.client.DaoManager;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.UsuarioDao;
import gob.pe.minam.sca.pojo.Usuario;

public class UsuarioSqlMapDao extends BaseSqlMapDao implements UsuarioDao {
	
   public UsuarioSqlMapDao(DaoManager daoManager) {
		    super(daoManager);
	}
	  
   public Usuario getUsuarioByKey(Usuario usuario) {
	    return (Usuario) queryForObject("getUsuarioByKey", usuario);
      }

  public List getUsuario(Usuario usuario) {
    return (List) queryForList("getUsuario", usuario);
  }

    public void insertUsuario(Usuario usuario) {
        insert("insertUsuario", usuario);
    }

    public void updateUsuario(Usuario usuario) {
        update("updateUsuario", usuario);
    }

    public void deleteUsuario(Usuario usuario) {
    }
}

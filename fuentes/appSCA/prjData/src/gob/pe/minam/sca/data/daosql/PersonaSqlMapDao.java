package gob.pe.minam.sca.data.daosql;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import com.ibatis.sqlmap.client.SqlMapException;

import gob.pe.minam.sca.data.BaseSqlMapDao;
import gob.pe.minam.sca.data.dao.PersonaDao;

import gob.pe.minam.sca.framework.ConstantesSistema;
import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.pojo.Persona;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonaSqlMapDao  extends BaseSqlMapDao implements PersonaDao {
    
    public PersonaSqlMapDao (DaoManager daoManager) {
        super(daoManager);
    }
   
    public Integer getNextItem() {
        return (Integer) queryForObject("getNextItem",0);
    }

    public Persona getPersonaByKey(Persona persona) {
        return (Persona) queryForObject("getPersonaByKey", persona);
    }
    
    public void insertPersona(Persona persona)  {
        insert("insertPersona", persona);
    }

    public void updatePersona(Persona persona) {
        update("updatePersona", persona);
    }
    
    public List selectProponenteByTipDoc(String tipDoc){
        Map map = new HashMap();
        if (tipDoc.equals(ConstantesSistema.TIP_PER_PJ)){
            map.put("ruc","1");
            map.put("noruc",null);
        }else if (tipDoc.equals(ConstantesSistema.TIP_PER_PN)){
            map.put("ruc",null);
            map.put("noruc","1");
        }else{
            map.put("ruc",null);
            map.put("noruc",null);
        }
        return queryForList("selectProponenteByTipDoc", map);
    }
}

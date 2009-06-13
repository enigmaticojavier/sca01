package gob.pe.minam.sca.data.dao;

import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.pojo.Persona;

import java.util.List;

public interface PersonaDao {
    
   public Integer getNextItem();
    
    public Persona getPersonaByKey(Persona persona);
    
    public void insertPersona(Persona persona) ;
    
    public void updatePersona(Persona persona) throws DAOException;
    
    public List getPersonaByNombre(Persona persona);
}


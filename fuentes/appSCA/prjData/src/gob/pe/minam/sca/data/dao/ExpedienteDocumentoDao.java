package gob.pe.minam.sca.data.dao;

import gob.pe.minam.sca.framework.exception.DAOException;

import java.util.List;

public interface ExpedienteDocumentoDao {
    public List buscarExDocXProy (Integer pryId) throws DAOException;
    public List buscarExDocXPeriodoPersona(String periodo, int personaId) throws DAOException;
}

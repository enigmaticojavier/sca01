package gob.pe.minam.sca.data.dao;

import gob.pe.minam.sca.framework.exception.DAOException;

import java.util.List;

public interface ImagenDocumentoDao {
    public List buscarImgXDoc (Integer docId) throws DAOException;
}

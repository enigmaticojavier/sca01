package gob.pe.minam.sca.data.dao;

import gob.pe.minam.sca.framework.exception.DAOException;

import gob.pe.minam.sca.pojo.ImagenDocumento;

import java.util.List;

public interface ImagenDocumentoDao {
    public void insertImagenDocumento(ImagenDocumento imagenDocumento) throws DAOException;
    public void updateImagenDocumento(ImagenDocumento imagenDocumento) throws DAOException;
    public boolean existeImagenDocumento(int docId) throws DAOException;
    public List buscarImgXDoc (Integer docId) throws DAOException;
}

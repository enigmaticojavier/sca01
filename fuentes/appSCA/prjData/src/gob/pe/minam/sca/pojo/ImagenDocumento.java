/***********************************************************************
 * Module:  Proyecto.java
 * Author:  Danny Esp�ritu
 * Purpose: Define Clase ImagenDocumento
 ***********************************************************************/
package gob.pe.minam.sca.pojo;

import gob.pe.minam.sca.data.ProyectoService;
import gob.pe.minam.sca.data.dao.ExpedienteDocumentoDao;
import gob.pe.minam.sca.data.dao.ImagenDocumentoDao;
import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.framework.exception.NegocioException;

import java.util.List;

public class ImagenDocumento {
    private Integer nsecuencia;
    private String txtRutaImagen;
    private String txtNomArchivo;
    private Documento documento;
      
    public ImagenDocumento() {
    }

    public void setNsecuencia(Integer nsecuencia) {
        this.nsecuencia = nsecuencia;
    }

    public Integer getNsecuencia() {
        return nsecuencia;
    }

    public void setTxtRutaImagen(String txtRutaImagen) {
        this.txtRutaImagen = txtRutaImagen;
    }

    public String getTxtRutaImagen() {
        return txtRutaImagen;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Documento getDocumento() {
        return documento;
    }
    
    public void setTxtNomArchivo(String txtNomArchivo) {
        this.txtNomArchivo = txtNomArchivo;
    }

    public String getTxtNomArchivo() {
        return txtNomArchivo;
    }
    
    public static List buscarImgXDoc(Integer docId) throws NegocioException{
       try{  
         ImagenDocumentoDao imagenDocumentoDao = ProyectoService.getInstance().getImagenDocumentoDao();
         return imagenDocumentoDao.buscarImgXDoc(docId);
       }catch(DAOException ex){
         throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
       }catch(Exception ex){
         throw new NegocioException(ex.toString(),"Error producido en Pojo");
       }
    }
    
    public static void grabarImagenDocumento(ImagenDocumento imagenDocumento) throws NegocioException{
       try{  
         ImagenDocumentoDao imagenDocumentoDao = ProyectoService.getInstance().getImagenDocumentoDao();
         System.out.println("docId-->"+imagenDocumento.getDocumento().getDocId());
         boolean existe = imagenDocumentoDao.existeImagenDocumento(imagenDocumento.getDocumento().getDocId());
         System.out.println("existe-->"+existe);
         if (existe){
             imagenDocumentoDao.updateImagenDocumento(imagenDocumento);
         }else{
             imagenDocumentoDao.insertImagenDocumento(imagenDocumento);
         }
       }catch(DAOException ex){
         throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
       }catch(Exception ex){
         throw new NegocioException(ex.toString(),"Error producido en Pojo");
       }
    }
    
}

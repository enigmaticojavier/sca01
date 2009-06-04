/***********************************************************************
 * Module:  Proyecto.java
 * Author:  Danny Espíritu
 * Purpose: Define Clase ExpedienteDocumento
 ***********************************************************************/
package gob.pe.minam.sca.pojo;

import gob.pe.minam.sca.data.ProyectoService;
import gob.pe.minam.sca.data.dao.ExpedienteDocumentoDao;
import gob.pe.minam.sca.data.dao.ImagenDocumentoDao;
import gob.pe.minam.sca.data.dao.ProyectoDao;
import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.framework.exception.NegocioException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpedienteDocumento {
    
    private Integer nSecuenciadoc;
    private ExpedientePaso expedientePaso;
    private Documento documento;
    
    public ExpedienteDocumento() {
        this.expedientePaso=new ExpedientePaso();
        this.documento=new Documento();
    }

    public void setNSecuenciadoc(Integer nSecuenciadoc) {
        this.nSecuenciadoc = nSecuenciadoc;
    }

    public Integer getNSecuenciadoc() {
        return nSecuenciadoc;
    }

    public void setExpedientePaso(ExpedientePaso expedientePaso) {
        this.expedientePaso = expedientePaso;
    }

    public ExpedientePaso getExpedientePaso() {
        return expedientePaso;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Documento getDocumento() {
        return documento;
    }
    
    public static List buscarExpDocXPry(Integer pryId) throws NegocioException{
       try{  
         System.out.println("pryId " + pryId);
         ExpedienteDocumentoDao expedienteDocumentoDao= ProyectoService.getInstance().getExpedienteDocumentoDao();
         List lstExpDoc = expedienteDocumentoDao.buscarExDocXProy(pryId);
         List lstExpDocIma=new ArrayList();
         for (int i=0;i<lstExpDoc.size();i++){
             ExpedienteDocumento expDoc = (ExpedienteDocumento)lstExpDoc.get(i);
             ImagenDocumentoDao imagenDocumentoDao = ProyectoService.getInstance().getImagenDocumentoDao();
             expDoc.getDocumento().setLstImagenDocumento(imagenDocumentoDao.buscarImgXDoc(expDoc.getDocumento().getDocId()));
             lstExpDocIma.add(expDoc);
         }
         return lstExpDocIma;
       }catch(DAOException ex){
         throw new NegocioException(ex.toString(),ex.getCodigoMensajeUsuario());
       }catch(Exception ex){
         throw new NegocioException(ex.toString(),"Error producido en Pojo");
       }
    }

}

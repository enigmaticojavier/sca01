/***********************************************************/
/* File Name: ProyectoSqlMapDao.java                   */
/* Descripcion: Interfase para las clases Dao de Ibatis    */
/* Fecha: Mayo 2009                               	  */
/* Autor: Danny Espíritu                                 */
/***********************************************************/
package gob.pe.minam.sca.data.daosql;

import com.ibatis.dao.client.DaoException;
import com.ibatis.dao.client.DaoManager;

import com.ibatis.sqlmap.client.SqlMapException;


import gob.pe.minam.sca.data.BaseSqlMapDao;

import gob.pe.minam.sca.data.dao.ProyectoDao;

import gob.pe.minam.sca.framework.exception.DAOException;
import gob.pe.minam.sca.pojo.Persona;
import gob.pe.minam.sca.pojo.Proponente;
import gob.pe.minam.sca.pojo.Proyecto;

import gob.pe.minam.sca.pojo.Ubigeo;

import gob.pe.minam.sca.util.Utilitarios;

import gob.pe.minam.sca.vo.ProyectoReporteDetVo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Date;

import java.util.Set;

import org.apache.commons.beanutils.DynaBean;

/**
 * @author Danny Espíritu
 * @version 1.0
 */

public class ProyectoSqlMapDao extends BaseSqlMapDao implements ProyectoDao {

  public ProyectoSqlMapDao(DaoManager daoManager){
    super(daoManager);
  }

    public List buscarProyecto (String txtDescripcion, String ubigeoId,
                                String clsTipificacion, String fchExpedienteDesde, 
                                String fchExpedienteHasta, String estadoTramite, 
                                String tipoAcae, String clsSector, String clsSubSector) throws DAOException{
        try{
          Map map = new HashMap(); 
          map.put("p_cDescripcion",txtDescripcion);
          map.put("p_cUbigeoId",ubigeoId);
          map.put("p_cClsTipificacion",clsTipificacion);
          map.put("p_dFchExpedienteDesde",Utilitarios.convierteTextoAFecha(fchExpedienteDesde));
          map.put("p_dFchExpedienteHasta",Utilitarios.convierteTextoAFecha(fchExpedienteHasta));
          map.put("p_cEstadoTramite",estadoTramite);
          map.put("p_cTipoAcae",tipoAcae);
          map.put("p_cClsSector",clsSector);
          map.put("p_cClsSubSector",Integer.parseInt(clsSubSector));
          System.out.println("txtDescripcion"+txtDescripcion);
          System.out.println("ubigeoId"+ubigeoId);
          System.out.println("clsTipificacion"+clsTipificacion);
          System.out.println("fchExpedienteDesde"+fchExpedienteDesde);
          System.out.println("fchExpedienteHasta"+fchExpedienteHasta);
          System.out.println("estadoTramite"+estadoTramite);
          System.out.println("tipoAcae"+tipoAcae);
          System.out.println("clsSector"+clsSector);
          System.out.println("clsSubSector"+clsSubSector);
          queryForObject("PQ_PROYECTO.BUSCAR", map);
          List rsProyecto=(List)map.get("p_rsProyecto");
          Iterator itProyecto = rsProyecto.iterator();
          List lstProyecto = new ArrayList();
          DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
          while (itProyecto.hasNext()){
                DynaBean bean = (DynaBean)itProyecto.next();
                Proyecto pr = new Proyecto();
                pr.setPryId(Integer.parseInt((String)bean.get("PRYID")));
                pr.setTxtDescripcion((String)bean.get("TXTDESCRIPCION"));
                if (bean.get("PERSONAID")!=null){
                    Proponente prop = new Proponente();
                    Persona p=new Persona();
                    pr.setPersonaId(Integer.parseInt((String)bean.get("PERSONAID")));
                    p.setTxtRazonSocial((String)bean.get("TXTRAZONSOCIAL"));
                    prop.setPersona(p);
                    pr.setProponente(prop);
                    
                }  
                if (bean.get("FCHEXPEDIENTE")!=null){
                    pr.setFchExpediente(df.parse((String)bean.get("FCHEXPEDIENTE")));
                }    
                Ubigeo ubigeo = new Ubigeo();
                ubigeo.setUbigeoId((String)bean.get("UBIGEOID"));
                ubigeo.setTxtDescripcion((String)bean.get("DSCUBIGEO"));
                pr.setUbigeo(ubigeo);
                pr.setClsTipificacion((String)bean.get("CLSTIPIFICACION"));
                pr.setDscClsTipificacion((String)bean.get("DSCTIPIFICACION"));
                pr.setEstadoTramite((String)bean.get("ESTTRAM"));
                //agregando columnas
                pr.setClsSector((String)bean.get("CLSSECTOR"));
                pr.setTipoAcae((String)bean.get("TIPOACAE"));
                pr.setInstitucion((String)bean.get("INSTITUCION"));
                pr.setActividad((String)bean.get("ACTIVIDAD"));
                lstProyecto.add(pr);
          }
          return lstProyecto;
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Eliminación de Proyecto");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Eliminación de Proyecto presenta problemas");
        }catch(Exception ex){
          ex.printStackTrace();  
          throw new DAOException(ex.toString(),"Error producido en la Eliminación de Proyecto");
        }        
    }
    
    public Proyecto ObtenerProyecto(Integer prjId) throws DAOException{
        try{
          return (Proyecto)queryForObject("ObtenerProyecto",prjId);
        }catch(SqlMapException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Eliminación de Proyecto");
        }catch(DaoException ex){
          throw new DAOException(ex.toString(),"Error producido en BD : Eliminación de Proyecto presenta problemas");
        }catch(Exception ex){
          ex.printStackTrace();  
          throw new DAOException(ex.toString(),"Error producido en la Eliminación de Proyecto");
        }
    }
    
    public List buscarRanking(String clsTipificacion,/*categoria*/ String estadoTramite, /*Estado Tramite*/
                                  String tipoPersoneria, String proponente,
                                  String tipoAcae, String clsSector, /*Institución*/ String clsSubSector, /*Dependencia*/
                                  String codDepartamento, String codProvincia, String codDistrito, 
                                  String anoPresentacion, String tipDocTramite) throws DAOException{
            try{
                String codDpto="";
                String codProv="";
                String codDist="";
                Map map = new HashMap(); 
                codDpto=codDepartamento==null || codDepartamento.equals("0")?"0":codDepartamento.substring(0,2);
                codProv=codProvincia==null || codProvincia.equals("0")?"0":codProvincia.substring(2,4);
                codDist=codDistrito==null || codDistrito.equals("0")?"0":codDistrito.substring(4,6);
                map.put("p_cClsTipificacion",clsTipificacion);
                map.put("p_cEstadoTramite",estadoTramite);
                map.put("p_cTipoPersoneria",tipoPersoneria);
                map.put("p_cProponente",proponente);
                map.put("p_cTipoAcae",tipoAcae);
                map.put("p_cClsSector",clsSector);
                map.put("p_cClsSubSector",Integer.parseInt(clsSubSector));
                map.put("p_cCodDepartamento",codDpto);
                map.put("p_cCodProvincia",codProv);
                map.put("p_cCodDistrito",codDist);
                map.put("p_cAnoPresentacion",anoPresentacion);
                map.put("p_cTipDocTramite",tipDocTramite);
                System.out.println("clsTipificacion"+clsTipificacion);
                System.out.println("estadoTramite"+estadoTramite);
                System.out.println("tipoPersoneria"+tipoPersoneria);
                System.out.println("proponente"+proponente);
                System.out.println("tipoAcae"+tipoAcae);
                System.out.println("clsSector"+clsSector);
                System.out.println("clsSubSector"+clsSubSector);
                System.out.println("codDepartamento"+codDepartamento+"-->codDpto"+codDpto);
                System.out.println("codProvincia"+codProvincia+"-->codProv"+codProv);
                System.out.println("codDistrito"+codDistrito+"-->codDist"+codDist);
                System.out.println("anoPresentacion"+anoPresentacion);
                System.out.println("tipDocTramite"+tipDocTramite);
                queryForObject("PQ_PROYECTO.RANKING", map);
                List rsProyecto=(List)map.get("p_rsProyecto");
                Iterator itProyecto = rsProyecto.iterator();
                List lstProyecto = new ArrayList();
                DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
                while (itProyecto.hasNext()){
                    DynaBean bean = (DynaBean)itProyecto.next();
                    Proyecto pr = new Proyecto();
                    Proponente propo = new Proponente();
                    Persona per = new Persona();
                    per.setPersonaId(Integer.parseInt((String)bean.get("PERSONAID")));
                    per.setTxtRazonSocial((String)bean.get("TXTRAZONSOCIAL"));
                    propo.setPersona(per);
                    pr.setProponente(propo);
                    pr.setContador(Integer.parseInt((String)bean.get("CNT")));
                    lstProyecto.add(pr);    
                }
                return lstProyecto;
            }catch(SqlMapException ex){
              throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Eliminación de Proyecto");
            }catch(DaoException ex){
              throw new DAOException(ex.toString(),"Error producido en BD : Eliminación de Proyecto presenta problemas");
            }catch(Exception ex){
              ex.printStackTrace();  
              throw new DAOException(ex.toString(),"Error producido en la Eliminación de Proyecto");
            } 
        }
        
        public List buscarRankingReporte(String clsTipificacion,/*categoria*/ String estadoTramite, /*Estado Tramite*/
                                          String tipoPersoneria, String proponente,
                                          String tipoAcae, String clsSector, /*Institución*/ String clsSubSector, /*Dependencia*/
                                          String codDepartamento, String codProvincia, String codDistrito, 
                                          String anoPresentacion, String tipDocTramite) throws DAOException{
            try{
                String codDpto="";
                String codProv="";
                String codDist="";
                Map map = new HashMap(); 
                codDpto=codDepartamento==null || codDepartamento.equals("0")?"0":codDepartamento.substring(0,2);
                codProv=codProvincia==null || codProvincia.equals("0")?"0":codProvincia.substring(2,4);
                codDist=codDistrito==null || codDistrito.equals("0")?"0":codDistrito.substring(4,6);
                map.put("p_cClsTipificacion",clsTipificacion);
                map.put("p_cEstadoTramite",estadoTramite);
                map.put("p_cTipoPersoneria",tipoPersoneria);
                map.put("p_cProponente",proponente);
                map.put("p_cTipoAcae",tipoAcae);
                map.put("p_cClsSector",clsSector);
                map.put("p_cClsSubSector",Integer.parseInt(clsSubSector!=null?clsSubSector:"0"));
                map.put("p_cCodDepartamento",codDpto);
                map.put("p_cCodProvincia",codProv);
                map.put("p_cCodDistrito",codDist);
                map.put("p_cAnoPresentacion",anoPresentacion);
                map.put("p_cTipDocTramite",tipDocTramite);
                System.out.println("clsTipificacion"+clsTipificacion);
                System.out.println("estadoTramite"+estadoTramite);
                System.out.println("tipoPersoneria"+tipoPersoneria);
                System.out.println("proponente"+proponente);
                System.out.println("tipoAcae"+tipoAcae);
                System.out.println("clsSector"+clsSector);
                System.out.println("clsSubSector"+clsSubSector);
                System.out.println("codDepartamento"+codDepartamento);
                System.out.println("codProvincia"+codProvincia);
                System.out.println("codDistrito"+codDistrito);
                System.out.println("anoPresentacion"+anoPresentacion);
                System.out.println("tipDocTramite"+tipDocTramite);
                queryForObject("PQ_PROYECTO.RANKING", map);
                List rsProyecto=(List)map.get("p_rsProyecto");
                Iterator itProyecto = rsProyecto.iterator();
                List lstProyecto = new ArrayList();
                DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
                while (itProyecto.hasNext()){
                    DynaBean bean = (DynaBean)itProyecto.next();
                    ProyectoReporteDetVo proyectoReporteDetVo = new ProyectoReporteDetVo();
                    proyectoReporteDetVo.setContador(Integer.parseInt((String)bean.get("CNT")));
                    proyectoReporteDetVo.setRazonSocial((String)bean.get("TXTRAZONSOCIAL"));
                    lstProyecto.add(proyectoReporteDetVo);    
                }
                return lstProyecto;
            }catch(SqlMapException ex){
              throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Eliminación de Proyecto");
            }catch(DaoException ex){
              throw new DAOException(ex.toString(),"Error producido en BD : Eliminación de Proyecto presenta problemas");
            }catch(Exception ex){
              ex.printStackTrace();  
              throw new DAOException(ex.toString(),"Error producido en la Eliminación de Proyecto");
            } 
        }
        
        public List buscarRankingDetalle(String clsTipificacion,/*categoria*/ String estadoTramite, /*Estado Tramite*/
                                         String proponente, String tipoAcae, String clsSector, /*Institución*/ String clsSubSector, /*Dependencia*/
                                         String codDepartamento, String codProvincia, String codDistrito, 
                                         String anoPresentacion, String tipDocTramite,String ordenRanking) throws DAOException{
            try{
                String codDpto="";
                String codProv="";
                String codDist="";
                Map map = new HashMap(); 
                codDpto=codDepartamento==null || codDepartamento.equals("0")?"0":codDepartamento.substring(0,2);
                codProv=codProvincia==null || codProvincia.equals("0")?"0":codProvincia.substring(2,4);
                codDist=codDistrito==null || codDistrito.equals("0")?"0":codDistrito.substring(4,6);
                map.put("p_cClsTipificacion",clsTipificacion);
                map.put("p_cEstadoTramite",estadoTramite);
                map.put("p_cProponente",proponente);
                map.put("p_cTipoAcae",tipoAcae);
                map.put("p_cClsSector",clsSector);
                map.put("p_cClsSubSector",Integer.parseInt(clsSubSector));
                map.put("p_cCodDepartamento",codDpto);
                map.put("p_cCodProvincia",codProv);
                map.put("p_cCodDistrito",codDist);
                map.put("p_cAnoPresentacion",anoPresentacion);
                map.put("p_cTipDocTramite",tipDocTramite);
                map.put("p_cOrdenRanking",ordenRanking);
                System.out.println("clsTipificacion"+clsTipificacion);
                System.out.println("estadoTramite"+estadoTramite);
                System.out.println("proponente"+proponente);
                System.out.println("tipoAcae"+tipoAcae);
                System.out.println("clsSector"+clsSector);
                System.out.println("clsSubSector"+clsSubSector);
                System.out.println("codDepartamento"+codDepartamento);
                System.out.println("codProvincia"+codProvincia);
                System.out.println("codDistrito"+codDistrito);
                System.out.println("anoPresentacion"+anoPresentacion);
                System.out.println("tipDocTramite"+tipDocTramite);
                System.out.println("ordenRanking"+ordenRanking);
                queryForObject("PQ_PROYECTO.RANKING_DETALLE", map);
                List rsProyecto=(List)map.get("p_rsProyecto");
                Iterator itProyecto = rsProyecto.iterator();
                List lstProyecto = new ArrayList();
                DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
                while (itProyecto.hasNext()){
                    DynaBean bean = (DynaBean)itProyecto.next();
                    Proyecto pr = new Proyecto();
                    pr.setPryId(Integer.parseInt((String)bean.get("PRYID")));
                    pr.setTxtDescripcion((String)bean.get("TXTDESCRIPCION"));
                    if (bean.get("PERSONAID")!=null){
                        Proponente prop = new Proponente();
                        Persona p=new Persona();
                        pr.setPersonaId(Integer.parseInt((String)bean.get("PERSONAID")));
                        p.setTxtRazonSocial((String)bean.get("TXTRAZONSOCIAL"));
                        prop.setPersona(p);
                        pr.setProponente(prop);
                    }  
                    if (bean.get("FCHEXPEDIENTE")!=null){
                        pr.setFchExpediente(df.parse((String)bean.get("FCHEXPEDIENTE")));
                    }    
                    Ubigeo ubigeo = new Ubigeo();
                    ubigeo.setUbigeoId((String)bean.get("UBIGEOID"));
                    ubigeo.setTxtDescripcion((String)bean.get("DSCUBIGEO"));
                    pr.setUbigeo(ubigeo);
                    pr.setClsTipificacion((String)bean.get("CLSTIPIFICACION"));
                    pr.setDscClsTipificacion((String)bean.get("DSCTIPIFICACION"));
                    pr.setEstadoTramite((String)bean.get("ESTTRAM"));
                    lstProyecto.add(pr);
                }
                return lstProyecto;    
            }catch(SqlMapException ex){
              throw new DAOException(ex.toString(),"Error producido en BD : No se puede ejecutar la Eliminación de Proyecto");
            }catch(DaoException ex){
              throw new DAOException(ex.toString(),"Error producido en BD : Eliminación de Proyecto presenta problemas");
            }catch(Exception ex){
              ex.printStackTrace();  
              throw new DAOException(ex.toString(),"Error producido en la Eliminación de Proyecto");
            } 
        }
     
  
}
package gob.pe.minam.sca.action;

import com.opensymphony.xwork2.Preparable;

import gob.pe.minam.sca.framework.AccionSoporte;

import gob.pe.minam.sca.framework.ConstantesSistema;
import gob.pe.minam.sca.pojo.Acae;
import gob.pe.minam.sca.pojo.Parametro;
import gob.pe.minam.sca.pojo.Periodo;
import gob.pe.minam.sca.pojo.Persona;
import gob.pe.minam.sca.pojo.Proyecto;
import gob.pe.minam.sca.pojo.Ubigeo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class RankingAction extends AccionSoporte implements Preparable {
    static Logger log = Logger.getLogger("RankingAction.class");

    private static final String rutaRpteProyectoResumen = "/reportes/rpProyectoResumen.jasper";
    private static final String rutaSubRpteProyectoResumenFiltro = "/reportes/rpProyectoResumenDetalle.jasper";


    private String panel;
    private String ordenRanking;
    
    private String idAgrupacion;
    private String txtAgrupacion;
    
    private String clsTipificacion; /*categoria*/
    private String estadoTramite; /*Estado Tramite*/
    private String tipoPersoneria;
    private String proponente;
    private String tipoAcae;
    private String clsSector; /*Institución*/
    private String clsSubSector; /*Dependencia*/

    private String codDepartamento;
    private String codProvincia;
    private String codDistrito;
    private String anoPeriodo;
    private String tipoDoc;

    private String dscProponente;
    private String hidClsTipificacion; /*categoria*/
    private String hidEstadoTramite; /*Estado Tramite*/
    private String hidProponente;
    private String hidTipoAcae;
    private String hidClsSector; /*Institución*/
    private String hidClsSubSector; /*Dependencia*/
    private String hidCodDepartamento;
    private String hidCodProvincia;
    private String hidCodDistrito;
    private String hidAnoPeriodo;
    private String hidTipoDoc;

    private List selOrdenRanking;
    private List selTipoPersoneria;
    private List selProponente;
    private List selAnoPeriodo;
    private List parCategProy;
    private List parEstadoTramite;
    private List parTipoDoc;
    private List parTipoAcae;
    private List parInstitucion;
    private List parDependencia;
    private List ubiDepartamentos;
    private List ubiProvincia;
    private List ubiDistrito;
    private List proyectos;
    private List proyectosResumen;
    
    private boolean showMsgFind;

    public void prepare() throws Exception {
        try {
            log.info("[" + this.getClass().getName() + ".prepare][Ini]");
            log.info("[" + this.getClass().getName() + ".prepare][Fin]");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String input() {
        try {
            log.info("[RankingAction.input][Ini]");
            String ano = 
                this.anoPeriodo.equals(COMBO_TXT_ALL) ? "0" : this.anoPeriodo;
            int orden = 0;
            if (this.ordenRanking.equals(ConstantesSistema.ORD_CAT_PROY)){
                orden=1;
            }else if (this.ordenRanking.equals(ConstantesSistema.ORD_EST_TRAM)){
                orden=2;
            }else if (this.ordenRanking.equals(ConstantesSistema.ORD_EMP_PROP)){
                orden=3;
            }else if (this.ordenRanking.equals(ConstantesSistema.ORD_TIP_ACAE)){
                orden=4;
            }else if (this.ordenRanking.equals(ConstantesSistema.ORD_ACAE)){
                orden=5;
            }else if (this.ordenRanking.equals(ConstantesSistema.ORD_DEPEN)){
                orden=6;
            }
            this.proyectos = 
                    Proyecto.buscarRankingDetalle(this.clsTipificacion, 
                                                  this.estadoTramite, 
                                                  this.tipoPersoneria, 
                                                  this.proponente, 
                                                  this.tipoAcae, 
                                                  this.clsSector, 
                                                  this.clsSubSector, 
                                                  this.codDepartamento, 
                                                  this.codProvincia, 
                                                  this.codDistrito, ano, 
                                                  this.tipoDoc,
                                                  orden,
                                                  this.idAgrupacion
                                                  );
            System.out.println("this.idAgrupacion-->" + this.idAgrupacion + "-->orden" + orden);
            System.out.println(this.proyectos.size());
            log.info("[RankingAction.input][Fin]");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return INPUT;
    }

    public String list() {
        try {
            log.info("[" + this.getClass().getName() + ".list][Ini]");
            llenaParametrosIniciales();
            // Institucion Dependencia Nulos
            Parametro parAll = new Parametro();
            parAll.setCodParametro(COMBO_COD_ALL);
            parAll.setTxtValor(COMBO_TXT_ALL);
            Acae acaeAll = new Acae();
            acaeAll.setPersonaId(Integer.parseInt(COMBO_COD_ALL));
            acaeAll.setTxtRazonSocial(COMBO_TXT_ALL);
            this.parInstitucion = new ArrayList();
            this.parInstitucion.add(parAll);
            this.parDependencia = new ArrayList();
            this.parDependencia.add(acaeAll);
            // Prov Dist Nulos
            Ubigeo ubiAll = new Ubigeo();
            ubiAll.setCodDepartamento(COMBO_COD_ALL);
            ubiAll.setCodProvincia(COMBO_COD_ALL);
            ubiAll.setCodDistrito(COMBO_COD_ALL);
            ubiAll.setTxtDescripcion(COMBO_TXT_ALL);
            this.ubiProvincia = new ArrayList();
            this.ubiProvincia.add(ubiAll);
            this.ubiDistrito = new ArrayList();
            this.ubiDistrito.add(ubiAll);
            this.codProvincia = COMBO_COD_ALL;
            this.codDistrito = COMBO_COD_ALL;

            // Panel de Entrada
            this.setVarSession("panel", "panel1");
            this.setVarSession("mensajeError", null);
            this.showMsgFind=false;
            log.info("[" + this.getClass().getName() + ".list][Fin]");
            return SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SUCCESS;
    }

    public String buscarInstitucionXTipoAcae() {
        try {
            log.info("[" + this.getClass().getName() + 
                     ".buscarInstitucionXTipoAcae][Ini]");
            llenaParametrosIniciales();
            setearProvincia();
            setearDistrito();
            this.clsSector = COMBO_COD_ALL;
            this.clsSubSector = COMBO_COD_ALL;
            setearInstitucionXTipoAcae();
            setearDependenciaXInstitucion();
            this.setVarSession("panel", "panel1");
            log.info("[" + this.getClass().getName() + 
                     ".buscarInstitucionXTipoAcae][Fin]");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SUCCESS;
    }

    public void setearInstitucionXTipoAcae() throws Exception {
        Parametro par = new Parametro();
        Acae acae = new Acae();
        List lstIns = new ArrayList();
        List lstDep = new ArrayList();
        if (this.tipoAcae != null && !this.tipoAcae.equals(COMBO_COD_ALL)) {
            log.info("this.tipoAcae " + this.tipoAcae);
            lstIns = par.buscarParametroXTipoParametro(this.tipoAcae);
            if (lstIns == null)
                lstIns = new ArrayList();
            par.setCodParametro(COMBO_COD_ALL);
            par.setTxtValor(COMBO_TXT_ALL);
            lstIns.add(par);
            this.parInstitucion = lstIns;
            if (this.clsSector == null)
                this.clsSector = COMBO_COD_ALL;
            acae.setPersonaId(Integer.parseInt(COMBO_COD_ALL));
            acae.setTxtRazonSocial(COMBO_TXT_ALL);
            lstDep.add(acae);
            this.parDependencia = lstDep;
            if (this.clsSubSector == null)
                this.clsSubSector = COMBO_COD_ALL;
        } else {
            par.setCodParametro(COMBO_COD_ALL);
            par.setTxtValor(COMBO_TXT_ALL);
            lstIns.add(par);
            this.parInstitucion = lstIns;
            lstDep.add(par);
            this.parDependencia = lstDep;
            this.clsSector = COMBO_COD_ALL;
            this.clsSubSector = COMBO_COD_ALL;
        }
    }

    public String buscarDependenciaXInstitucion() {
        try {
            log.info("[" + this.getClass().getName() + 
                     ".buscarDependenciaXInstitucion][Ini]");
            llenaParametrosIniciales();
            setearProvincia();
            setearDistrito();
            this.clsSubSector = COMBO_COD_ALL;
            setearDependenciaXInstitucion();
            this.setVarSession("panel", "panel1");
            log.info("[" + this.getClass().getName() + 
                     ".buscarDependenciaXInstitucion][Fin]");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SUCCESS;
    }

    public void setearDependenciaXInstitucion() throws Exception {
        Parametro par = new Parametro();
        Acae acae = new Acae();
        List lstIns = new ArrayList();
        List lstDep = new ArrayList();
        lstIns = par.buscarParametroXTipoParametro(this.tipoAcae);
        if (lstIns == null)
            lstIns = new ArrayList();
        par.setCodParametro(COMBO_COD_ALL);
        par.setTxtValor(COMBO_TXT_ALL);
        lstIns.add(par);
        this.parInstitucion = lstIns;
        if (this.clsSector != null) {
            log.info("this.tipoAcae " + this.tipoAcae + "this.clsSector " + 
                     this.clsSector);
            if (!this.clsSector.equals(COMBO_COD_ALL)) {
                lstDep = acae.listarDependencia(this.tipoAcae, this.clsSector);
                //lstDep=sub.buscarSubsectorXSector(this.clsSector);
                if (lstDep == null)
                    lstDep = new ArrayList();
            }
            acae.setPersonaId(Integer.parseInt(COMBO_COD_ALL));
            acae.setTxtRazonSocial(COMBO_TXT_ALL);
            lstDep.add(acae);
            this.parDependencia = lstDep;
            if (this.clsSubSector == null)
                this.clsSubSector = COMBO_COD_ALL;
        } else {
            this.parDependencia = new ArrayList();
        }
    }


    public String buscarProvXDpto() {
        try {
            log.info("[" + this.getClass().getName() + 
                     ".buscarProvXDpto][Ini]");
            llenaParametrosIniciales();
            setearInstitucionXTipoAcae();
            setearDependenciaXInstitucion();
            this.codProvincia = COMBO_COD_ALL;
            this.codDistrito = COMBO_COD_ALL;
            setearProvincia();
            this.setVarSession("panel", "panel2");
            log.info("[" + this.getClass().getName() + 
                     ".buscarProvXDpto][Fin]");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SUCCESS;
    }

    private void setearProvincia() throws Exception {
        Ubigeo ubigeo = new Ubigeo();
        Ubigeo ubiAll = new Ubigeo();
        ubiAll.setCodProvincia(COMBO_COD_ALL);
        ubiAll.setCodDistrito(COMBO_COD_ALL);
        ubiAll.setTxtDescripcion(COMBO_TXT_ALL);
        if (this.getCodDepartamento() != null && 
            !this.getCodDepartamento().equals(COMBO_COD_ALL)) {
            log.info("setearProvincia-->codDepartamento=" + this.codDepartamento);
            ubigeo.setCodDepartamento(this.getCodDepartamento().substring(0, 
                                                                          2));
            this.ubiProvincia = ubigeo.listarProvincia(ubigeo);
            this.ubiProvincia.add(ubiAll);
            if (this.codProvincia == null)
                this.codProvincia = COMBO_COD_ALL;
            this.ubiDistrito = new ArrayList();
            this.ubiDistrito.add(ubiAll);
            if (this.codDistrito == null)
                this.codDistrito = COMBO_COD_ALL;
        } else {
            this.ubiProvincia = new ArrayList();
            this.ubiProvincia.add(ubiAll);
            this.setCodProvincia(COMBO_COD_ALL);
            this.ubiDistrito = new ArrayList();
            this.ubiDistrito.add(ubiAll);
            this.setCodDistrito(COMBO_COD_ALL);
        }
    }

    public String buscarDistXProv() {
        try {
            log.info("[" + this.getClass().getName() + 
                     ".buscarDistXProv][Ini]");
            llenaParametrosIniciales();
            setearInstitucionXTipoAcae();
            setearDependenciaXInstitucion();
            setearProvincia();
            log.info("this.getCodProvincia()" + this.getCodProvincia());
            if (this.codDistrito == null)
                this.codDistrito = COMBO_COD_ALL;
            setearDistrito();
            System.out.println("1-->this.codDepartamento-->" + 
                               this.codDepartamento + 
                               "-->this.codProvincia-->" + this.codProvincia + 
                               "-->this.codDistrito-->" + this.codDistrito);
            this.setVarSession("panel", "panel2");
            log.info("[" + this.getClass().getName() + 
                     ".buscarDistXProv][Fin]");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SUCCESS;
    }

    private void setearDistrito() throws Exception {
        Ubigeo ubigeo = new Ubigeo();
        Ubigeo ubiAll = new Ubigeo();
        ubiAll.setCodDistrito(COMBO_COD_ALL);
        ubiAll.setTxtDescripcion(COMBO_TXT_ALL);
        if (this.getCodProvincia() != null && 
            !this.getCodProvincia().equals(COMBO_COD_ALL)) {
            String codDpto = this.codProvincia.substring(0, 2);
            String codProv = this.codProvincia.substring(2, 4);
            System.out.println("codDpto=" + codDpto + "-->codProv" + codProv);
            ubigeo.setCodDepartamento(codDpto);
            ubigeo.setCodProvincia(codProv);
            Ubigeo ubiNulo = new Ubigeo();
            ubiNulo.setCodDistrito(COMBO_COD_ALL);
            ubiNulo.setTxtDescripcion(COMBO_TXT_ALL);
            this.ubiDistrito = ubigeo.listarDistrito(ubigeo);
            this.ubiDistrito.add(ubiNulo);
        } else {
            this.ubiDistrito = new ArrayList();
            this.ubiDistrito.add(ubiAll);
            this.setCodDistrito(COMBO_COD_ALL);
        }
    }

    public String buscarProponente() {
        try {
            log.info("[" + this.getClass().getName() + 
                     ".buscarProponente][Ini]");
            llenaParametrosIniciales();
            setearInstitucionXTipoAcae();
            setearDependenciaXInstitucion();
            setearProvincia();
            setearDistrito();
            Persona perTodos = new Persona();
            perTodos.setPersonaId(Integer.parseInt(COMBO_COD_ALL));
            perTodos.setTxtRazonSocial(COMBO_TXT_ALL);
            Persona persona = new Persona();
            this.selProponente = 
                    persona.selectProponenteByTipDoc(this.tipoPersoneria);
            this.selProponente.add(perTodos);
            this.setVarSession("panel", "panel1");
            log.info("[" + this.getClass().getName() + 
                     ".buscarProponente][Fin]");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SUCCESS;
    }

    private void llenaParametrosIniciales() {
        try {
            log.info("[" + this.getClass().getName() + 
                     ".llenaParametrosIniciales][Ini]");
            Parametro pr = new Parametro();
            Ubigeo ubi = new Ubigeo();
            Parametro parAll = new Parametro();
            Parametro parOth = new Parametro();
            parOth.setCodParametro(COMBO_COD_OTROS);
            parOth.setTxtValor(COMBO_TXT_OTROS);
            parAll.setCodParametro(COMBO_COD_ALL);
            parAll.setTxtValor(COMBO_TXT_ALL);
            Ubigeo ubiAll = new Ubigeo();
            ubiAll.setCodDepartamento(COMBO_COD_ALL);
            ubiAll.setTxtDescripcion(COMBO_TXT_ALL);
            Persona personaAll = new Persona();
            personaAll.setPersonaId(Integer.parseInt(COMBO_COD_ALL));
            personaAll.setTxtRazonSocial(COMBO_TXT_ALL);

            /*Orden*/
            selOrdenRanking = new ArrayList();
            Parametro cmb = new Parametro();
            cmb.setCodParametro(ConstantesSistema.ORD_CAT_PROY);
            cmb.setTxtValor("Categoría del Proyecto");
            selOrdenRanking.add(cmb);
            cmb = new Parametro();
            cmb.setCodParametro(ConstantesSistema.ORD_EST_TRAM);
            cmb.setTxtValor("Estado del Trámite");
            selOrdenRanking.add(cmb);
            cmb = new Parametro();
            cmb.setCodParametro(ConstantesSistema.ORD_EMP_PROP);
            cmb.setTxtValor("Empresa Proponente");
            selOrdenRanking.add(cmb);
            cmb = new Parametro();
            cmb.setCodParametro(ConstantesSistema.ORD_TIP_ACAE);
            cmb.setTxtValor("Tipo de ACAE");
            selOrdenRanking.add(cmb);
            cmb = new Parametro();
            cmb.setCodParametro(ConstantesSistema.ORD_ACAE);
            cmb.setTxtValor("ACAE");
            selOrdenRanking.add(cmb);
            cmb = new Parametro();
            cmb.setCodParametro(ConstantesSistema.ORD_DEPEN);
            cmb.setTxtValor("Dependencia");
            selOrdenRanking.add(cmb);
            if (this.ordenRanking == null)
                this.ordenRanking = ConstantesSistema.ORD_CAT_PROY;

            /*Categoria del Proyecto*/
            List lstCatPry = pr.buscarParametroXTipoParametro("IGA");
            lstCatPry.add(parOth);
            lstCatPry.add(parAll);
            this.parCategProy = lstCatPry;
            if (this.clsTipificacion == null)
                clsTipificacion = COMBO_COD_ALL;

            /*Estado del Trámite*/
            List lstEstTra = pr.buscarParametroXTipoParametro("EST");
            lstEstTra.add(parAll);
            this.parEstadoTramite = lstEstTra;
            if (this.estadoTramite == null)
                this.estadoTramite = COMBO_COD_ALL;

            /*Tipo de Personeria*/
            selTipoPersoneria = new ArrayList();
            cmb = new Parametro();
            cmb.setCodParametro(ConstantesSistema.TIP_PER_PN);
            cmb.setTxtValor("Persona Natural");
            selTipoPersoneria.add(cmb);
            cmb = new Parametro();
            cmb.setCodParametro(ConstantesSistema.TIP_PER_PJ);
            cmb.setTxtValor("Persona Jurídica");
            selTipoPersoneria.add(cmb);
            cmb = new Parametro();
            cmb.setCodParametro(COMBO_COD_ALL);
            cmb.setTxtValor(COMBO_TXT_ALL);
            selTipoPersoneria.add(cmb);
            if (this.tipoPersoneria == null)
                tipoPersoneria = COMBO_COD_ALL;

            // Proponente
            List lstProponente = new ArrayList();
            if (this.tipoPersoneria.equals(COMBO_COD_ALL)) {
                Persona persona = new Persona();
                lstProponente = 
                        persona.selectProponenteByTipDoc(COMBO_COD_ALL);
                lstProponente.add(personaAll);
                if (this.proponente == null)
                    this.proponente = COMBO_COD_ALL;
            } else if (this.tipoPersoneria.equals(ConstantesSistema.TIP_PER_PN) || 
                       this.tipoPersoneria.equals(ConstantesSistema.TIP_PER_PJ)) {
                Persona persona = new Persona();
                lstProponente = 
                        persona.selectProponenteByTipDoc(this.tipoPersoneria);
                lstProponente.add(personaAll);
                if (this.proponente == null)
                    this.proponente = COMBO_COD_ALL;
            } else {
                lstProponente.add(personaAll);
                this.proponente = COMBO_COD_ALL;
            }
            this.selProponente = lstProponente;

            /*Tipo de Acae*/
            List lstTipAcae = pr.buscarParametroXTipoParametro("TAC");
            lstTipAcae.add(parAll);
            this.parTipoAcae = lstTipAcae;
            if (this.tipoAcae == null)
                this.tipoAcae = COMBO_COD_ALL;

            /*Departamentos*/
            this.ubiDepartamentos = ubi.listarDepartamento();
            this.ubiDepartamentos.add(ubiAll);
            if (this.codDepartamento == null)
                this.codDepartamento = COMBO_COD_ALL;

            /*Año de presentación*/
            Periodo periodo = new Periodo();
            List lstanoPeriodo = periodo.listarAnoPeriodo();
            Periodo anoPer = new Periodo();
            anoPer.setPeriodo(COMBO_TXT_ALL);
            lstanoPeriodo.add(anoPer);
            this.selAnoPeriodo = lstanoPeriodo;
            if (this.anoPeriodo == null)
                this.anoPeriodo = COMBO_TXT_ALL;

            /*Tipo Documento Trámite*/
            List lstTipoDocTramite = pr.buscarParametroXTipoParametro("DOC");
            lstTipoDocTramite.add(parAll);
            this.parTipoDoc = lstTipoDocTramite;
            if (this.tipoDoc == null)
                this.tipoDoc = COMBO_COD_ALL;

            log.info("[" + this.getClass().getName() + 
                     ".llenaParametrosIniciales][Fin]");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String buscarRanking() {
        try {
            log.info("[" + this.getClass().getName() + ".buscarRanking][Ini]");
            llenaParametrosIniciales();
            setearProvincia();
            setearDistrito();
            setearInstitucionXTipoAcae();
            setearDependenciaXInstitucion();
            log.info("tipoAcae-->" + this.tipoAcae + "-->clsSector-->" + 
                     this.clsSector + "-->clsSubSector-->" + 
                     this.clsSubSector);
            String ano = 
                this.anoPeriodo.equals(COMBO_TXT_ALL) ? "0" : this.anoPeriodo;
            int orden = 0;
            if (this.ordenRanking.equals(ConstantesSistema.ORD_CAT_PROY)){
                orden=1;
                this.txtAgrupacion="Categoría del Proyecto";
            }else if (this.ordenRanking.equals(ConstantesSistema.ORD_EST_TRAM)){
                orden=2;
                this.txtAgrupacion="Estado del Trámite";
            }else if (this.ordenRanking.equals(ConstantesSistema.ORD_EMP_PROP)){
                orden=3;
                this.txtAgrupacion="Empresa Proponente";
            }else if (this.ordenRanking.equals(ConstantesSistema.ORD_TIP_ACAE)){
                orden=4;
                this.txtAgrupacion="Tipo Acae";
            }else if (this.ordenRanking.equals(ConstantesSistema.ORD_ACAE)){
                orden=5;
                this.txtAgrupacion="ACAE";
            }else if (this.ordenRanking.equals(ConstantesSistema.ORD_DEPEN)){
                orden=6;    
                this.txtAgrupacion="Dependencia";
            }
            
            this.proyectosResumen = 
                    Proyecto.buscarRanking(this.clsTipificacion, 
                                           this.estadoTramite, 
                                           this.tipoPersoneria, 
                                           this.proponente, this.tipoAcae, 
                                           this.clsSector, this.clsSubSector, 
                                           this.codDepartamento, 
                                           this.codProvincia, this.codDistrito, 
                                           ano, this.tipoDoc,orden);
            this.hidClsTipificacion = this.clsTipificacion;
            this.hidEstadoTramite = this.estadoTramite;
            this.hidProponente = this.proponente;
            this.hidTipoAcae = this.tipoAcae;
            this.hidClsSector = this.clsSector;
            this.hidClsSubSector = this.clsSubSector;
            this.hidCodDepartamento = this.codDepartamento;
            this.hidCodProvincia = this.codProvincia;
            this.hidCodDistrito = this.codDistrito;
            this.hidAnoPeriodo = this.anoPeriodo;
            this.hidTipoDoc = this.tipoDoc;

            this.showMsgFind=true;
            log.info(this.proyectosResumen == null ? 
                     "this.proyectosResumen.size=0" : 
                     "this.proyectosResumen.size=" + 
                     this.proyectosResumen.size());
            log.info("[ProyectoAction.buscarProyecto][Fin]");
            log.info("[" + this.getClass().getName() + ".buscarRanking][Fin]");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SUCCESS;
    }

    public String mostrarReporte() {
        try {
            System.out.println("mostrarReporte--------------------------------------------------------------->");
            System.out.println("mostrarReporte---------------------------------------------------------------fin>");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "reporte";
    }


    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setCodDistrito(String codDistrito) {
        this.codDistrito = codDistrito;
    }

    public String getCodDistrito() {
        return codDistrito;
    }

    public void setUbiDepartamentos(List ubiDepartamentos) {
        this.ubiDepartamentos = ubiDepartamentos;
    }

    public List getUbiDepartamentos() {
        return ubiDepartamentos;
    }

    public void setUbiProvincia(List ubiProvincia) {
        this.ubiProvincia = ubiProvincia;
    }

    public List getUbiProvincia() {
        return ubiProvincia;
    }

    public void setUbiDistrito(List ubiDistrito) {
        this.ubiDistrito = ubiDistrito;
    }

    public List getUbiDistrito() {
        return ubiDistrito;
    }

    public void setParCategProy(List parCategProy) {
        this.parCategProy = parCategProy;
    }

    public List getParCategProy() {
        return parCategProy;
    }

    public void setParEstadoTramite(List parEstadoTramite) {
        this.parEstadoTramite = parEstadoTramite;
    }

    public List getParEstadoTramite() {
        return parEstadoTramite;
    }

    public void setParTipoAcae(List parTipoAcae) {
        this.parTipoAcae = parTipoAcae;
    }

    public List getParTipoAcae() {
        return parTipoAcae;
    }

    public void setParInstitucion(List parInstitucion) {
        this.parInstitucion = parInstitucion;
    }

    public List getParInstitucion() {
        return parInstitucion;
    }

    public void setParDependencia(List parDependencia) {
        this.parDependencia = parDependencia;
    }

    public List getParDependencia() {
        return parDependencia;
    }

    public void setTipoAcae(String tipoAcae) {
        this.tipoAcae = tipoAcae;
    }

    public String getTipoAcae() {
        return tipoAcae;
    }

    public void setClsSector(String clsSector) {
        this.clsSector = clsSector;
    }

    public String getClsSector() {
        return clsSector;
    }

    public void setClsSubSector(String clsSubSector) {
        this.clsSubSector = clsSubSector;
    }

    public String getClsSubSector() {
        return clsSubSector;
    }

    public void setOrdenRanking(String ordenRanking) {
        this.ordenRanking = ordenRanking;
    }

    public String getOrdenRanking() {
        return ordenRanking;
    }

    public void setSelOrdenRanking(List selOrdenRanking) {
        this.selOrdenRanking = selOrdenRanking;
    }

    public List getSelOrdenRanking() {
        return selOrdenRanking;
    }

    public void setClsTipificacion(String clsTipificacion) {
        this.clsTipificacion = clsTipificacion;
    }

    public String getClsTipificacion() {
        return clsTipificacion;
    }

    public void setEstadoTramite(String estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    public String getEstadoTramite() {
        return estadoTramite;
    }

    public void setSelTipoPersoneria(List selTipoPersoneria) {
        this.selTipoPersoneria = selTipoPersoneria;
    }

    public List getSelTipoPersoneria() {
        return selTipoPersoneria;
    }

    public void setTipoPersoneria(String tipoPersoneria) {
        this.tipoPersoneria = tipoPersoneria;
    }

    public String getTipoPersoneria() {
        return tipoPersoneria;
    }

    public void setParTipoDoc(List parTipoDoc) {
        this.parTipoDoc = parTipoDoc;
    }

    public List getParTipoDoc() {
        return parTipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setSelProponente(List selProponente) {
        this.selProponente = selProponente;
    }

    public List getSelProponente() {
        return selProponente;
    }

    public void setProponente(String proponente) {
        this.proponente = proponente;
    }

    public String getProponente() {
        return proponente;
    }

    public void setAnoPeriodo(String anoPeriodo) {
        this.anoPeriodo = anoPeriodo;
    }

    public String getAnoPeriodo() {
        return anoPeriodo;
    }

    public void setSelAnoPeriodo(List selAnoPeriodo) {
        this.selAnoPeriodo = selAnoPeriodo;
    }

    public List getSelAnoPeriodo() {
        return selAnoPeriodo;
    }

    public void setPanel(String panel) {
        this.panel = panel;
    }

    public String getPanel() {
        return panel;
    }

    public void setProyectos(List proyectos) {
        this.proyectos = proyectos;
    }

    public List getProyectos() {
        return proyectos;
    }

    public void setHidClsTipificacion(String hidClsTipificacion) {
        this.hidClsTipificacion = hidClsTipificacion;
    }

    public String getHidClsTipificacion() {
        return hidClsTipificacion;
    }

    public void setHidEstadoTramite(String hidEstadoTramite) {
        this.hidEstadoTramite = hidEstadoTramite;
    }

    public String getHidEstadoTramite() {
        return hidEstadoTramite;
    }

    public void setHidProponente(String hidProponente) {
        this.hidProponente = hidProponente;
    }

    public String getHidProponente() {
        return hidProponente;
    }

    public void setHidTipoAcae(String hidTipoAcae) {
        this.hidTipoAcae = hidTipoAcae;
    }

    public String getHidTipoAcae() {
        return hidTipoAcae;
    }

    public void setHidClsSector(String hidClsSector) {
        this.hidClsSector = hidClsSector;
    }

    public String getHidClsSector() {
        return hidClsSector;
    }

    public void setHidClsSubSector(String hidClsSubSector) {
        this.hidClsSubSector = hidClsSubSector;
    }

    public String getHidClsSubSector() {
        return hidClsSubSector;
    }

    public void setHidCodDepartamento(String hidCodDepartamento) {
        this.hidCodDepartamento = hidCodDepartamento;
    }

    public String getHidCodDepartamento() {
        return hidCodDepartamento;
    }

    public void setHidCodProvincia(String hidCodProvincia) {
        this.hidCodProvincia = hidCodProvincia;
    }

    public String getHidCodProvincia() {
        return hidCodProvincia;
    }

    public void setHidCodDistrito(String hidCodDistrito) {
        this.hidCodDistrito = hidCodDistrito;
    }

    public String getHidCodDistrito() {
        return hidCodDistrito;
    }

    public void setHidAnoPeriodo(String hidAnoPeriodo) {
        this.hidAnoPeriodo = hidAnoPeriodo;
    }

    public String getHidAnoPeriodo() {
        return hidAnoPeriodo;
    }

    public void setHidTipoDoc(String hidTipoDoc) {
        this.hidTipoDoc = hidTipoDoc;
    }

    public String getHidTipoDoc() {
        return hidTipoDoc;
    }

    public void setProyectosResumen(List proyectosResumen) {
        this.proyectosResumen = proyectosResumen;
    }

    public List getProyectosResumen() {
        return proyectosResumen;
    }

    public void setDscProponente(String dscProponente) {
        this.dscProponente = dscProponente;
    }

    public String getDscProponente() {
        return dscProponente;
    }

    public void setShowMsgFind(boolean showMsgFind) {
        this.showMsgFind = showMsgFind;
    }

    public boolean isShowMsgFind() {
        return showMsgFind;
    }

    public void setTxtAgrupacion(String txtAgrupacion) {
        this.txtAgrupacion = txtAgrupacion;
    }

    public String getTxtAgrupacion() {
        return txtAgrupacion;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    public Logger getLog() {
        return log;
    }

    public void setIdAgrupacion(String idAgrupacion) {
        this.idAgrupacion = idAgrupacion;
    }

    public String getIdAgrupacion() {
        return idAgrupacion;
    }
}

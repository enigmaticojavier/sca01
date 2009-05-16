/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     16/05/2009 12:38:52 p.m.                     */
/*==============================================================*/


ALTER TABLE ACAE
   DROP CONSTRAINT FK_ACAE_ASSOCIATI_SUBSECTO;

ALTER TABLE ACAE
   DROP CONSTRAINT FK_ACAE_GENERALIZ_PERSONA;

ALTER TABLE CONSULTOR
   DROP CONSTRAINT FK_CONSULTO_GENERALIZ_PERSONA;

ALTER TABLE CONTROLENVIO
   DROP CONSTRAINT FK_CONTROLE_ASSOCIATI_ACAE;

ALTER TABLE DOCUMENTOPERSONA
   DROP CONSTRAINT FK_DOCUMENT_ASSOCIATI_PERSONA;

ALTER TABLE DOCUMENTOPERSONA
   DROP CONSTRAINT FK_DOCUMENT_ASSOCIATI_DOCUMENT;

ALTER TABLE EIA
   DROP CONSTRAINT FK_EIA_GENERALIZ_DOCUMENT;

ALTER TABLE ESTADOSTUPADOC
   DROP CONSTRAINT FK_ESTADOST_ASSOCIATI_ESTADOST;

ALTER TABLE EXPEDIENTE
   DROP CONSTRAINT FK_EXPEDIEN_ASSOCIATI_PROYECTO;

ALTER TABLE EXPEDIENTE
   DROP CONSTRAINT FK_EXPEDIEN_ASSOCIATI_ACAE;

ALTER TABLE EXPEDIENTEDOCUMENTO
   DROP CONSTRAINT FK_EXPEDIEN_ASSOCIATI_EXPEDIEN;

ALTER TABLE EXPEDIENTEDOCUMENTO
   DROP CONSTRAINT FK_EXPEDIEN_ASSOCIATI_DOCUMENT;

ALTER TABLE EXPEDIENTEPASO
   DROP CONSTRAINT FK_EXPEDIEN_ASSOCIATI_EXPEDIE2;

ALTER TABLE IMAGENDOCUMENTO
   DROP CONSTRAINT FK_IMAGENDO_ASSOCIATI_DOCUMENT;

ALTER TABLE PERSONA
   DROP CONSTRAINT FK_PERSONA_ASSOCIATI_UBIGEO;

ALTER TABLE PROPONENTE
   DROP CONSTRAINT FK_PROPONEN_GENERALIZ_PERSONA;

ALTER TABLE PROYECTO
   DROP CONSTRAINT FK_PROYECTO_ASSOCIATI_UBIGEO;

ALTER TABLE PROYECTO
   DROP CONSTRAINT FK_PROYECTO_ASSOCIATI_PROPONEN;

ALTER TABLE RESOLUCION
   DROP CONSTRAINT FK_RESOLUCI_GENERALIZ_DOCUMENT;

ALTER TABLE USUARIO
   DROP CONSTRAINT FK_USUARIO_ASSOCIATI_PERSONA;

DROP TABLE ACAE CASCADE CONSTRAINTS;

DROP TABLE CONTROL_ARCHIVOS CASCADE CONSTRAINTS;

DROP TABLE CONSULTOR CASCADE CONSTRAINTS;

DROP TABLE CONTROLENVIO CASCADE CONSTRAINTS;

DROP TABLE DOCUMENTO CASCADE CONSTRAINTS;

DROP TABLE DOCUMENTOPERSONA CASCADE CONSTRAINTS;

DROP TABLE EIA CASCADE CONSTRAINTS;

DROP TABLE ESTADOSTUPA CASCADE CONSTRAINTS;

DROP TABLE ESTADOSTUPADOC CASCADE CONSTRAINTS;

DROP TABLE EXPEDIENTE CASCADE CONSTRAINTS;

DROP TABLE EXPEDIENTEDOCUMENTO CASCADE CONSTRAINTS;

DROP TABLE EXPEDIENTEPASO CASCADE CONSTRAINTS;

DROP TABLE IMAGENDOCUMENTO CASCADE CONSTRAINTS;

DROP TABLE PARAMETRO CASCADE CONSTRAINTS;

DROP TABLE PERSONA CASCADE CONSTRAINTS;

DROP TABLE PROPONENTE CASCADE CONSTRAINTS;

DROP TABLE PROYECTO CASCADE CONSTRAINTS;

DROP TABLE RESOLUCION CASCADE CONSTRAINTS;

DROP TABLE SUBSECTOR CASCADE CONSTRAINTS;

DROP TABLE TEXPEDIENTE CASCADE CONSTRAINTS;

DROP TABLE TPROPONENTE CASCADE CONSTRAINTS;

DROP TABLE TPROYECTO CASCADE CONSTRAINTS;

DROP TABLE UBIGEO CASCADE CONSTRAINTS;

DROP TABLE USUARIO CASCADE CONSTRAINTS;

/*==============================================================*/
/* Table: ACAE                                                  */
/*==============================================================*/
CREATE TABLE ACAE  (
   PERSONAID            INTEGER                         NOT NULL,
   CLSSECTOR            VARCHAR2(3)                     NOT NULL,
   CLSSUBSECTOR         VARCHAR2(4)                     NOT NULL,
   TIPACAE              VARCHAR2(3),
   TIPDOCUMENTOGER      VARCHAR2(3),
   CODDOCUMENTOGER      VARCHAR2(50),
   TXTAPELLIDOSNOMBRES  VARCHAR2(1000),
   TXTCARGO             VARCHAR2(255),
   TELEFONOGER          VARCHAR2(50),
   CONSTRAINT PK_ACAE PRIMARY KEY (PERSONAID)
);

COMMENT ON TABLE ACAE IS
'Autoridades sectoriales que expiden las certificaciones ambientales (con resolucion)';

/*==============================================================*/
/* Table: CONTROL_ARCHIVOS                                      */
/*==============================================================*/
CREATE TABLE CONTROL_ARCHIVOS  (
   PERSONAID            INTEGER                         NOT NULL,
   CODARCHIVO           VARCHAR2(3)                     NOT NULL,
   CODPERIODO           VARCHAR2(6)                     NOT NULL,
   FCHENVIO             DATE,
   NUMREGISTROS         INTEGER,
   CONSTRAINT PK_CONTROL_ARCHIVOS PRIMARY KEY (PERSONAID, CODARCHIVO, CODPERIODO)
);

/*==============================================================*/
/* Table: CONSULTOR                                             */
/*==============================================================*/
CREATE TABLE CONSULTOR  (
   PERSONAID            INTEGER                         NOT NULL,
   CONSTRAINT PK_CONSULTOR PRIMARY KEY (PERSONAID)
);

COMMENT ON TABLE CONSULTOR IS
'Personas juridicas habilitados por las ACAE para que elaboren los IGAs';

/*==============================================================*/
/* Table: CONTROLENVIO                                          */
/*==============================================================*/
CREATE TABLE CONTROLENVIO  (
   TIPARCHIVO           VARCHAR2(3)                     NOT NULL,
   PERIODO              VARCHAR2(254)                   NOT NULL,
   PERSONAID            INTEGER                         NOT NULL,
   TIPSITUACION         VARCHAR2(3),
   CONSTRAINT PK_CONTROLENVIO PRIMARY KEY (TIPARCHIVO, PERIODO, PERSONAID)
);

/*==============================================================*/
/* Table: DOCUMENTO                                             */
/*==============================================================*/
CREATE TABLE DOCUMENTO  (
   DOCID                INTEGER                         NOT NULL,
   TIPODOCUMENTO        VARCHAR2(3),
   CODDOCUMENTO         VARCHAR2(50),
   FCHEXPEDICION        DATE,
   FCHPRESENTACION      DATE,
   PERIODO              VARCHAR2(6),
   CONSTRAINT PK_DOCUMENTO PRIMARY KEY (DOCID)
);

COMMENT ON TABLE DOCUMENTO IS
'Documentos que el proponente presenta o la ACAE expide';

/*==============================================================*/
/* Table: DOCUMENTOPERSONA                                      */
/*==============================================================*/
CREATE TABLE DOCUMENTOPERSONA  (
   DOCID                INTEGER                         NOT NULL,
   PERSONAID            INTEGER                         NOT NULL,
   TIPODOCPERSONA       VARCHAR2(3)                     NOT NULL,
   CONSTRAINT PK_DOCUMENTOPERSONA PRIMARY KEY (DOCID, PERSONAID, TIPODOCPERSONA)
);

/*==============================================================*/
/* Table: EIA                                                   */
/*==============================================================*/
CREATE TABLE EIA  (
   DOCID                INTEGER                         NOT NULL,
   TXTRESUMEN           VARCHAR2(1000),
   CONSTRAINT PK_EIA PRIMARY KEY (DOCID)
);

COMMENT ON TABLE EIA IS
'Documento Instrumento de Gestion Ambiental (IGA) o estudio de impacto ambiental';

/*==============================================================*/
/* Table: ESTADOSTUPA                                           */
/*==============================================================*/
CREATE TABLE ESTADOSTUPA  (
   TIPTRAMITE           VARCHAR2(3)                     NOT NULL,
   NUMSECUENCIA         INTEGER                         NOT NULL,
   TIPPASO              VARCHAR2(3)                     NOT NULL,
   TIPESTADOTRAMITE     VARCHAR2(3),
   CONSTRAINT PK_ESTADOSTUPA PRIMARY KEY (TIPTRAMITE, NUMSECUENCIA)
);

COMMENT ON TABLE ESTADOSTUPA IS
'Maestro de secuencia de pasos del procedimiento indicando los cambios de estado del expediente o tramite';

/*==============================================================*/
/* Table: ESTADOSTUPADOC                                        */
/*==============================================================*/
CREATE TABLE ESTADOSTUPADOC  (
   TIPTRAMITE           VARCHAR2(3)                     NOT NULL,
   NUMSECUENCIA         INTEGER                         NOT NULL,
   TIPDOCUMENTO         VARCHAR2(3)                     NOT NULL,
   CONSTRAINT PK_ESTADOSTUPADOC PRIMARY KEY (TIPTRAMITE, NUMSECUENCIA, TIPDOCUMENTO)
);

COMMENT ON TABLE ESTADOSTUPADOC IS
'Configuración de Documentos cuya copia digitalizada debe adjuntarse por transaccion.';

/*==============================================================*/
/* Table: EXPEDIENTE                                            */
/*==============================================================*/
CREATE TABLE EXPEDIENTE  (
   EXPID                INTEGER                         NOT NULL,
   PRYID                INTEGER                         NOT NULL,
   PERSONAID            INTEGER                         NOT NULL,
   NUMEXPEDIENTE        VARCHAR2(50),
   FCHEXPEDIENTE        DATE,
   TIPTRAMITE           VARCHAR2(3),
   CLSTIPIFICACION      VARCHAR2(4),
   PERIODO              VARCHAR2(6),
   CONSTRAINT PK_EXPEDIENTE PRIMARY KEY (EXPID)
);

COMMENT ON TABLE EXPEDIENTE IS
'Expediente o tramite';

/*==============================================================*/
/* Table: EXPEDIENTEDOCUMENTO                                   */
/*==============================================================*/
CREATE TABLE EXPEDIENTEDOCUMENTO  (
   EXPID                INTEGER                         NOT NULL,
   NSECUENCIA           INTEGER                         NOT NULL,
   NSECUENCIADOC        INTEGER                         NOT NULL,
   DOCID                INTEGER                         NOT NULL,
   CONSTRAINT PK_EXPEDIENTEDOCUMENTO PRIMARY KEY (EXPID, NSECUENCIA, NSECUENCIADOC)
);

COMMENT ON TABLE EXPEDIENTEDOCUMENTO IS
'Vincula cada paso del tramite con uno o mas documentos';

/*==============================================================*/
/* Table: EXPEDIENTEPASO                                        */
/*==============================================================*/
CREATE TABLE EXPEDIENTEPASO  (
   EXPID                INTEGER                         NOT NULL,
   NSECUENCIA           INTEGER                         NOT NULL,
   TIPPASO              VARCHAR2(3),
   FCHPASO              DATE,
   PERIODO              VARCHAR2(6),
   CONSTRAINT PK_EXPEDIENTEPASO PRIMARY KEY (EXPID, NSECUENCIA)
);

COMMENT ON TABLE EXPEDIENTEPASO IS
'Secuencia de pasos por cada expediente o tramite';

/*==============================================================*/
/* Table: IMAGENDOCUMENTO                                       */
/*==============================================================*/
CREATE TABLE IMAGENDOCUMENTO  (
   NSECUENCIA           INTEGER                         NOT NULL,
   DOCID                INTEGER                         NOT NULL,
   TXTRUTAIMAGEN        VARCHAR2(1000),
   CONSTRAINT PK_IMAGENDOCUMENTO PRIMARY KEY (NSECUENCIA)
);

COMMENT ON TABLE IMAGENDOCUMENTO IS
'Para almacenar las rutas y nombres de los documentos adjuntos que se va a cargar';

/*==============================================================*/
/* Table: PARAMETRO                                             */
/*==============================================================*/
CREATE TABLE PARAMETRO  (
   IDPARAMETRO          INTEGER                         NOT NULL,
   CODPARAMETRO         VARCHAR2(6),
   TIPPARAMETRO         VARCHAR2(3),
   TXTPARAMETRO         VARCHAR2(255),
   TXTVALOR             VARCHAR2(255),
   CONSTRAINT PK_PARAMETRO PRIMARY KEY (IDPARAMETRO)
);

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
CREATE TABLE PERSONA  (
   PERSONAID            INTEGER                         NOT NULL,
   UBIGEOID             VARCHAR2(6),
   TIPDOCUMENTOPER      VARCHAR2(3),
   NUMDOCUMENTOPER      VARCHAR2(50),
   TIPPERSONA           VARCHAR2(3),
   TXTRAZONSOCIAL       VARCHAR2(255),
   TXTDOMICILIO         VARCHAR2(255),
   TELEFONO             VARCHAR2(50),
   TXTEMAIL             VARCHAR2(50),
   FAX                  VARCHAR2(50),
   CONSTRAINT PK_PERSONA PRIMARY KEY (PERSONAID)
);

COMMENT ON TABLE PERSONA IS
'Maestro de personas';

/*==============================================================*/
/* Table: PROPONENTE                                            */
/*==============================================================*/
CREATE TABLE PROPONENTE  (
   PERSONAID            INTEGER                         NOT NULL,
   TIPODOCUMENTORL      VARCHAR2(3),
   CODDOCUMENTORL       VARCHAR2(50),
   TXTNOMBRESRL         VARCHAR2(255),
   PERIODO              VARCHAR2(6),
   CONSTRAINT PK_PROPONENTE PRIMARY KEY (PERSONAID)
);

COMMENT ON TABLE PROPONENTE IS
'Personas juridicas que presentan las solicitudes de certificacion ambiental para sus proyectos';

/*==============================================================*/
/* Table: PROYECTO                                              */
/*==============================================================*/
CREATE TABLE PROYECTO  (
   PRYID                INTEGER                         NOT NULL,
   UBIGEOID             VARCHAR2(6),
   PERSONAID            INTEGER                         NOT NULL,
   CODPROYECTO          VARCHAR2(50),
   TXTCOORDENADAS       VARCHAR2(1000),
   CLSTIPIFICACION      VARCHAR2(4),
   TXTDESCRIPCION       VARCHAR2(1000),
   MNINVERSION          NUMBER,
   CLSSECTOR            VARCHAR2(4),
   CLSSUBSECTOR         VARCHAR2(4),
   FCHEXPEDIENTE        DATE,
   PERIODO              VARCHAR2(6),
   CONSTRAINT PK_PROYECTO PRIMARY KEY (PRYID)
);

COMMENT ON TABLE PROYECTO IS
'Maestro de proyectos o actividades que requieren certificacion ambiental';

/*==============================================================*/
/* Table: RESOLUCION                                            */
/*==============================================================*/
CREATE TABLE RESOLUCION  (
   DOCID                INTEGER                         NOT NULL,
   TIPRESOLUCION        VARCHAR2(3),
   FCHPUBLICACION       DATE,
   FCHVIGENCIA          DATE,
   RESUMEN              VARCHAR2(1000),
   CONSTRAINT PK_RESOLUCION PRIMARY KEY (DOCID)
);

COMMENT ON TABLE RESOLUCION IS
'Documento Resolucion';

/*==============================================================*/
/* Table: SUBSECTOR                                             */
/*==============================================================*/
CREATE TABLE SUBSECTOR  (
   CLSSECTOR            VARCHAR2(3)                     NOT NULL,
   CLSSUBSECTOR         VARCHAR2(4)                     NOT NULL,
   TIPSUBSECTOR         VARCHAR2(3),
   TXTSUBSECTOR         VARCHAR2(255),
   CONSTRAINT PK_SUBSECTOR PRIMARY KEY (CLSSECTOR, CLSSUBSECTOR)
);

COMMENT ON TABLE SUBSECTOR IS
'Subclasificacion de las autoridades sectoriales';

/*==============================================================*/
/* Table: TEXPEDIENTE                                           */
/*==============================================================*/
CREATE TABLE TEXPEDIENTE  (
   NUMACAE              INTEGER                         NOT NULL,
   CODPROY              VARCHAR2(6)                     NOT NULL,
   NUMEXPD              VARCHAR2(10)                    NOT NULL,
   TIPTRAN              VARCHAR2(3)                     NOT NULL,
   PERIODO              VARCHAR2(6)                     NOT NULL,
   FCHTRAN              DATE,
   NUMRESL              VARCHAR2(50),
   FCHRESL              DATE,
   DSCBIGA              VARCHAR2(1000),
   NUMITAM              VARCHAR2(50),
   CONSTRAINT PK_TEXPEDIENTE PRIMARY KEY (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO)
);

/*==============================================================*/
/* Table: TPROPONENTE                                           */
/*==============================================================*/
CREATE TABLE TPROPONENTE  (
   NUMACAE              INTEGER                         NOT NULL,
   RUCPROP              VARCHAR2(11)                    NOT NULL,
   PERIODO              VARCHAR2(6)                     NOT NULL,
   RAZSOCI              VARCHAR2(255),
   TIPDORL              VARCHAR2(3),
   NUMDORL              VARCHAR2(50),
   NOMBRRL              VARCHAR2(255),
   DOMPROP              VARCHAR2(255),
   UBIGEOG              VARCHAR2(6),
   CONSTRAINT PK_TPROPONENTE PRIMARY KEY (NUMACAE, RUCPROP, PERIODO)
);

/*==============================================================*/
/* Table: TPROYECTO                                             */
/*==============================================================*/
CREATE TABLE TPROYECTO  (
   NUMACAE              INTEGER                         NOT NULL,
   CODPROY              VARCHAR2(6)                     NOT NULL,
   PERIODO              VARCHAR2(6)                     NOT NULL,
   NOMPROY              VARCHAR2(255)                   NOT NULL,
   TIPOCAT              VARCHAR2(3),
   RUCPROP              VARCHAR2(11),
   TMPVIDA              INTEGER,
   TSECTOR              VARCHAR2(3),
   TSUBSEC              VARCHAR2(4),
   UBIGEOG              VARCHAR2(6),
   FCHPRES              DATE,
   CONSTRAINT PK_TPROYECTO PRIMARY KEY (NUMACAE, CODPROY, PERIODO)
);

/*==============================================================*/
/* Table: UBIGEO                                                */
/*==============================================================*/
CREATE TABLE UBIGEO  (
   UBIGEOID             VARCHAR2(6)                     NOT NULL,
   TXTDESCRIPCION       VARCHAR2(255),
   TXTDESCRIPCIONLARGA  VARCHAR2(255),
   CONSTRAINT PK_UBIGEO PRIMARY KEY (UBIGEOID)
);

COMMENT ON TABLE UBIGEO IS
'Ubicaciones geograficas';

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
CREATE TABLE USUARIO  (
   USUARIO              VARCHAR2(50)                    NOT NULL,
   PERSONAID            INTEGER                         NOT NULL,
   CODCLAVE             VARCHAR2(50),
   TIPUSUARIO           VARCHAR2(3),
   CONSTRAINT PK_USUARIO PRIMARY KEY (USUARIO)
);

COMMENT ON TABLE USUARIO IS
'Maestro de usuarios (En la implementacion solo se creara uno por cada ACAE)';

ALTER TABLE ACAE
   ADD CONSTRAINT FK_ACAE_ASSOCIATI_SUBSECTO FOREIGN KEY (CLSSECTOR, CLSSUBSECTOR)
      REFERENCES SUBSECTOR (CLSSECTOR, CLSSUBSECTOR);

ALTER TABLE ACAE
   ADD CONSTRAINT FK_ACAE_GENERALIZ_PERSONA FOREIGN KEY (PERSONAID)
      REFERENCES PERSONA (PERSONAID);

ALTER TABLE CONSULTOR
   ADD CONSTRAINT FK_CONSULTO_GENERALIZ_PERSONA FOREIGN KEY (PERSONAID)
      REFERENCES PERSONA (PERSONAID);

ALTER TABLE CONTROLENVIO
   ADD CONSTRAINT FK_CONTROLE_ASSOCIATI_ACAE FOREIGN KEY (PERSONAID)
      REFERENCES ACAE (PERSONAID);

ALTER TABLE DOCUMENTOPERSONA
   ADD CONSTRAINT FK_DOCUMENT_ASSOCIATI_PERSONA FOREIGN KEY (PERSONAID)
      REFERENCES PERSONA (PERSONAID);

ALTER TABLE DOCUMENTOPERSONA
   ADD CONSTRAINT FK_DOCUMENT_ASSOCIATI_DOCUMENT FOREIGN KEY (DOCID)
      REFERENCES DOCUMENTO (DOCID);

ALTER TABLE EIA
   ADD CONSTRAINT FK_EIA_GENERALIZ_DOCUMENT FOREIGN KEY (DOCID)
      REFERENCES DOCUMENTO (DOCID);

ALTER TABLE ESTADOSTUPADOC
   ADD CONSTRAINT FK_ESTADOST_ASSOCIATI_ESTADOST FOREIGN KEY (TIPTRAMITE, NUMSECUENCIA)
      REFERENCES ESTADOSTUPA (TIPTRAMITE, NUMSECUENCIA);

ALTER TABLE EXPEDIENTE
   ADD CONSTRAINT FK_EXPEDIEN_ASSOCIATI_PROYECTO FOREIGN KEY (PRYID)
      REFERENCES PROYECTO (PRYID);

ALTER TABLE EXPEDIENTE
   ADD CONSTRAINT FK_EXPEDIEN_ASSOCIATI_ACAE FOREIGN KEY (PERSONAID)
      REFERENCES ACAE (PERSONAID);

ALTER TABLE EXPEDIENTEDOCUMENTO
   ADD CONSTRAINT FK_EXPEDIEN_ASSOCIATI_EXPEDIEN FOREIGN KEY (EXPID, NSECUENCIA)
      REFERENCES EXPEDIENTEPASO (EXPID, NSECUENCIA);

ALTER TABLE EXPEDIENTEDOCUMENTO
   ADD CONSTRAINT FK_EXPEDIEN_ASSOCIATI_DOCUMENT FOREIGN KEY (DOCID)
      REFERENCES DOCUMENTO (DOCID);

ALTER TABLE EXPEDIENTEPASO
   ADD CONSTRAINT FK_EXPEDIEN_ASSOCIATI_EXPEDIE2 FOREIGN KEY (EXPID)
      REFERENCES EXPEDIENTE (EXPID);

ALTER TABLE IMAGENDOCUMENTO
   ADD CONSTRAINT FK_IMAGENDO_ASSOCIATI_DOCUMENT FOREIGN KEY (DOCID)
      REFERENCES DOCUMENTO (DOCID);

ALTER TABLE PERSONA
   ADD CONSTRAINT FK_PERSONA_ASSOCIATI_UBIGEO FOREIGN KEY (UBIGEOID)
      REFERENCES UBIGEO (UBIGEOID);

ALTER TABLE PROPONENTE
   ADD CONSTRAINT FK_PROPONEN_GENERALIZ_PERSONA FOREIGN KEY (PERSONAID)
      REFERENCES PERSONA (PERSONAID);

ALTER TABLE PROYECTO
   ADD CONSTRAINT FK_PROYECTO_ASSOCIATI_UBIGEO FOREIGN KEY (UBIGEOID)
      REFERENCES UBIGEO (UBIGEOID);

ALTER TABLE PROYECTO
   ADD CONSTRAINT FK_PROYECTO_ASSOCIATI_PROPONEN FOREIGN KEY (PERSONAID)
      REFERENCES PROPONENTE (PERSONAID);

ALTER TABLE RESOLUCION
   ADD CONSTRAINT FK_RESOLUCI_GENERALIZ_DOCUMENT FOREIGN KEY (DOCID)
      REFERENCES DOCUMENTO (DOCID);

ALTER TABLE USUARIO
   ADD CONSTRAINT FK_USUARIO_ASSOCIATI_PERSONA FOREIGN KEY (PERSONAID)
      REFERENCES PERSONA (PERSONAID);


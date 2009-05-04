/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     03/05/2009 10:16:52 p.m.                     */
/*==============================================================*/


ALTER TABLE ACAE
   DROP CONSTRAINT FK_ACAE_ASSOCIATI_SUBSECTO;

ALTER TABLE ACAE
   DROP CONSTRAINT FK_ACAE_GENERALIZ_PERSONA;

ALTER TABLE CONSULTOR
   DROP CONSTRAINT FK_CONSULTO_GENERALIZ_PERSONA;

ALTER TABLE DOCUMENTOPERSONA
   DROP CONSTRAINT FK_DOCUMENT_ASSOCIATI_PERSONA;

ALTER TABLE DOCUMENTOPERSONA
   DROP CONSTRAINT FK_DOCUMENT_ASSOCIATI_DOCUMENT;

ALTER TABLE EIA
   DROP CONSTRAINT FK_EIA_GENERALIZ_DOCUMENT;

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

DROP TABLE CONSULTOR CASCADE CONSTRAINTS;

DROP TABLE DOCUMENTO CASCADE CONSTRAINTS;

DROP TABLE DOCUMENTOPERSONA CASCADE CONSTRAINTS;

DROP TABLE EIA CASCADE CONSTRAINTS;

DROP TABLE ESTADOSTUPA CASCADE CONSTRAINTS;

DROP TABLE EXPEDIENTE CASCADE CONSTRAINTS;

DROP TABLE EXPEDIENTEDOCUMENTO CASCADE CONSTRAINTS;

DROP TABLE EXPEDIENTEPASO CASCADE CONSTRAINTS;

DROP TABLE IMAGENDOCUMENTO CASCADE CONSTRAINTS;

DROP TABLE PARAMETROS CASCADE CONSTRAINTS;

DROP TABLE PERSONA CASCADE CONSTRAINTS;

DROP TABLE PROPONENTE CASCADE CONSTRAINTS;

DROP TABLE PROYECTO CASCADE CONSTRAINTS;

DROP TABLE RESOLUCION CASCADE CONSTRAINTS;

DROP TABLE SUBSECTOR CASCADE CONSTRAINTS;

DROP TABLE UBIGEO CASCADE CONSTRAINTS;

DROP TABLE USUARIO CASCADE CONSTRAINTS;

/*==============================================================*/
/* Table: ACAE                                                  */
/*==============================================================*/
CREATE TABLE ACAE  (
   PERSONAID            INTEGER                         NOT NULL,
   CLSSECTOR            CHAR(3)                         NOT NULL,
   CLSSUBSECTOR         CHAR(4)                         NOT NULL,
   TIPDOCUMENTOGER      CHAR(3),
   CODDOCUMENTOGER      VARCHAR2(50),
   TXTAPELLIDOSNOMBRES  VARCHAR2(1000),
   TXTCARGO             VARCHAR2(255),
   TELEFONOGER          VARCHAR2(50),
   CONSTRAINT PK_ACAE PRIMARY KEY (PERSONAID)
);

COMMENT ON TABLE ACAE IS
'Autoridades sectoriales que expiden las certificaciones ambientales (con resolucion)';

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
/* Table: DOCUMENTO                                             */
/*==============================================================*/
CREATE TABLE DOCUMENTO  (
   DOCID                INTEGER                         NOT NULL,
   TIPODOCUMENTO        CHAR(3),
   CODDOCUMENTO         VARCHAR2(50),
   FCHEXPEDICION        DATE,
   FCHPRESENTACION      DATE,
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
   TIPODOCPERSONA       CHAR(3)                         NOT NULL,
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
   TIPTRAMITE           CHAR(3)                         NOT NULL,
   NUMSECUENCIA         INTEGER                         NOT NULL,
   TIPPASO              CHAR(3)                         NOT NULL,
   TIPESTADOTRAMITE     CHAR(3),
   CONSTRAINT PK_ESTADOSTUPA PRIMARY KEY (TIPTRAMITE, NUMSECUENCIA)
);

COMMENT ON TABLE ESTADOSTUPA IS
'Maestro de secuencia de pasos del procedimiento indicando los cambios de estado del expediente o tramite';

/*==============================================================*/
/* Table: EXPEDIENTE                                            */
/*==============================================================*/
CREATE TABLE EXPEDIENTE  (
   EXPID                INTEGER                         NOT NULL,
   PRYID                INTEGER                         NOT NULL,
   PERSONAID            INTEGER                         NOT NULL,
   NUMEXPEDIENTE        VARCHAR2(50),
   FCHEXPEDIENTE        DATE,
   TIPTRAMITE           CHAR(3),
   CLSTIPIFICACION      CHAR(4),
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
   TIPPASO              CHAR(3),
   FCHPASO              DATE,
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
/* Table: PARAMETROS                                            */
/*==============================================================*/
CREATE TABLE PARAMETROS  (
   IDPARAMETRO          INTEGER                         NOT NULL,
   CODPARAMETRO         CHAR(3)                         NOT NULL,
   TIPPARAMETRO         CHAR(3),
   TXTPARAMETRO         VARCHAR2(255),
   TXTVALOR             VARCHAR2(255),
   CONSTRAINT PK_PARAMETROS PRIMARY KEY (IDPARAMETRO, CODPARAMETRO)
);

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
CREATE TABLE PERSONA  (
   PERSONAID            INTEGER                         NOT NULL,
   UBIGEOID             VARCHAR2(6),
   TIPOPERSONA          CHAR(3),
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
   TIPODOCUMENTORL      CHAR(3),
   CODDOCUMENTORL       VARCHAR2(50),
   TXTNOMBRESRL         VARCHAR2(255),
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
   TXTCOORDENADAS       VARCHAR2(1000),
   CLSTIPIFICACION      CHAR(4),
   TXTDESCRIPCION       VARCHAR2(1000),
   MNINVERSION          BINARY_DOUBLE,
   CLSSECTOR            CHAR(4),
   CLSSUBSECTOR         CHAR(4),
   FCHEXPEDIENTE        DATE,
   CONSTRAINT PK_PROYECTO PRIMARY KEY (PRYID)
);

COMMENT ON TABLE PROYECTO IS
'Maestro de proyectos o actividades que requieren certificacion ambiental';

/*==============================================================*/
/* Table: RESOLUCION                                            */
/*==============================================================*/
CREATE TABLE RESOLUCION  (
   DOCID                INTEGER                         NOT NULL,
   TIPRESOLUCION        CHAR(3),
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
   CLSSECTOR            CHAR(3)                         NOT NULL,
   CLSSUBSECTOR         CHAR(4)                         NOT NULL,
   TIPSUBSECTOR         CHAR(3),
   TXTSUBSECTOR         VARCHAR2(255),
   CONSTRAINT PK_SUBSECTOR PRIMARY KEY (CLSSECTOR, CLSSUBSECTOR)
);

COMMENT ON TABLE SUBSECTOR IS
'Subclasificacion de las autoridades sectoriales';

/*==============================================================*/
/* Table: UBIGEO                                                */
/*==============================================================*/
CREATE TABLE UBIGEO  (
   UBIGEOID             VARCHAR2(6)                     NOT NULL,
   TXTDESCRIPCION       VARCHAR2(255),
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
   TIPUSUARIO           CHAR(3),
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

ALTER TABLE DOCUMENTOPERSONA
   ADD CONSTRAINT FK_DOCUMENT_ASSOCIATI_PERSONA FOREIGN KEY (PERSONAID)
      REFERENCES PERSONA (PERSONAID);

ALTER TABLE DOCUMENTOPERSONA
   ADD CONSTRAINT FK_DOCUMENT_ASSOCIATI_DOCUMENT FOREIGN KEY (DOCID)
      REFERENCES DOCUMENTO (DOCID);

ALTER TABLE EIA
   ADD CONSTRAINT FK_EIA_GENERALIZ_DOCUMENT FOREIGN KEY (DOCID)
      REFERENCES DOCUMENTO (DOCID);

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


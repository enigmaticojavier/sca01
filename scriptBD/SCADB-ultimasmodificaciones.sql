/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     12/06/2009 04:46:18 p.m.                     */
/*==============================================================*/


ALTER TABLE ACAE
   DROP CONSTRAINT FK_ACAE_ASSOCIATI_SUBSECTO;

ALTER TABLE ACAE
   DROP CONSTRAINT FK_ACAE_GENERALIZ_PERSONA;

ALTER TABLE CONTROLENVIO
   DROP CONSTRAINT FK_CONTROLE_ASSOCIATI_ACAE;

ALTER TABLE EXPEDIENTE
   DROP CONSTRAINT FK_EXPEDIEN_ASSOCIATI_PROYECTO;

ALTER TABLE EXPEDIENTE
   DROP CONSTRAINT FK_EXPEDIEN_ASSOCIATI_ACAE;

ALTER TABLE PROYECTO
   DROP CONSTRAINT FK_PROYECTO_ASSOCIATI_UBIGEO;

ALTER TABLE PROYECTO
   DROP CONSTRAINT FK_PROYECTO_ASSOCIATI_PROPONEN;

ALTER TABLE ACAE
   DROP PRIMARY KEY CASCADE;

DROP TABLE TMP_ACAE CASCADE CONSTRAINTS;

RENAME ACAE TO TMP_ACAE;

ALTER TABLE CONTROLENVIO
   DROP PRIMARY KEY CASCADE;

DROP TABLE TMP_CONTROLENVIO CASCADE CONSTRAINTS;

RENAME CONTROLENVIO TO TMP_CONTROLENVIO;

ALTER TABLE PROYECTO
   DROP PRIMARY KEY CASCADE;

DROP TABLE TMP_PROYECTO CASCADE CONSTRAINTS;

RENAME PROYECTO TO TMP_PROYECTO;

ALTER TABLE SUBSECTOR
   DROP PRIMARY KEY CASCADE;

DROP TABLE TMP_SUBSECTOR CASCADE CONSTRAINTS;

RENAME SUBSECTOR TO TMP_SUBSECTOR;

/*==============================================================*/
/* Table: ACAE                                                  */
/*==============================================================*/
CREATE TABLE ACAE  (
   PERSONAID            INTEGER                         NOT NULL,
   CLSSECTOR            VARCHAR2(6)                     NOT NULL,
   CLSSUBSECTOR         VARCHAR2(6)                     NOT NULL,
   TIPACAE              VARCHAR2(6),
   TIPDOCUMENTOGER      VARCHAR2(6),
   CODDOCUMENTOGER      VARCHAR2(50),
   TXTAPELLIDOSNOMBRES  VARCHAR2(1000),
   TXTCARGO             VARCHAR2(255),
   TELEFONOGER          VARCHAR2(50),
   CONSTRAINT PK_ACAE PRIMARY KEY (PERSONAID)
);

COMMENT ON TABLE ACAE IS
'Autoridades sectoriales que expiden las certificaciones ambientales (con resolucion)';

INSERT INTO ACAE (PERSONAID, CLSSECTOR, CLSSUBSECTOR, TIPACAE, TIPDOCUMENTOGER, CODDOCUMENTOGER, TXTAPELLIDOSNOMBRES, TXTCARGO, TELEFONOGER)
SELECT PERSONAID, CLSSECTOR, CLSSUBSECTOR, TIPACAE, TIPDOCUMENTOGER, CODDOCUMENTOGER, TXTAPELLIDOSNOMBRES, TXTCARGO, TELEFONOGER
FROM TMP_ACAE;

/*==============================================================*/
/* Table: CONTROLENVIO                                          */
/*==============================================================*/
CREATE TABLE CONTROLENVIO  (
   PERSONAID            INTEGER                         NOT NULL,
   PERIODO              VARCHAR2(6)                     NOT NULL,
   ESTENVIOPRY          VARCHAR2(6),
   FCHENVIOPRY          DATE,
   ESTENVIOPRO          VARCHAR2(6),
   FCHENVIOPRO          DATE,
   ESTENVIOEXP          VARCHAR2(6),
   FCHENVIOEXP          DATE,
   CONSTRAINT PK_CONTROLENVIO PRIMARY KEY (PERIODO)
);

INSERT INTO CONTROLENVIO (PERSONAID, PERIODO, FCHENVIOPRY, FCHENVIOPRO, FCHENVIOEXP)
SELECT PERSONAID, PERIODO, FCHENVIOPRY, FCHENVIOPRO, FCHENVIOEXP
FROM TMP_CONTROLENVIO;

ALTER TABLE IMAGENDOCUMENTO ADD TXTNOMARCHIVO VARCHAR2(255);

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
   CLSSECTOR            VARCHAR2(6),
   CLSSUBSECTOR         VARCHAR2(6),
   FCHEXPEDIENTE        DATE,
   PERIODO              VARCHAR2(6),
   CONSTRAINT PK_PROYECTO PRIMARY KEY (PRYID)
);

COMMENT ON TABLE PROYECTO IS
'Maestro de proyectos o actividades que requieren certificacion ambiental';

INSERT INTO PROYECTO (PRYID, UBIGEOID, PERSONAID, CODPROYECTO, TXTCOORDENADAS, CLSTIPIFICACION, TXTDESCRIPCION, MNINVERSION, CLSSECTOR, CLSSUBSECTOR, FCHEXPEDIENTE, PERIODO)
SELECT PRYID, UBIGEOID, PERSONAID, CODPROYECTO, TXTCOORDENADAS, CLSTIPIFICACION, TXTDESCRIPCION, MNINVERSION, CLSSECTOR, CLSSUBSECTOR, FCHEXPEDIENTE, PERIODO
FROM TMP_PROYECTO;

/*==============================================================*/
/* Table: SUBSECTOR                                             */
/*==============================================================*/
CREATE TABLE SUBSECTOR  (
   CLSSECTOR            VARCHAR2(6)                     NOT NULL,
   CLSSUBSECTOR         VARCHAR2(6)                     NOT NULL,
   TIPSUBSECTOR         VARCHAR2(6),
   TXTSUBSECTOR         VARCHAR2(255),
   CONSTRAINT PK_SUBSECTOR PRIMARY KEY (CLSSECTOR, CLSSUBSECTOR)
);

COMMENT ON TABLE SUBSECTOR IS
'Subclasificacion de las autoridades sectoriales';

INSERT INTO SUBSECTOR (CLSSECTOR, CLSSUBSECTOR, TIPSUBSECTOR, TXTSUBSECTOR)
SELECT CLSSECTOR, CLSSUBSECTOR, TIPSUBSECTOR, TXTSUBSECTOR
FROM TMP_SUBSECTOR;

/*==============================================================*/
/* View: VPROYECTOESTADO                                        */
/*==============================================================*/
CREATE OR REPLACE VIEW VPROYECTOESTADO AS
SELECT EX.PRYID, EP.*, ET.TIPESTADOTRAMITE 
FROM EXPEDIENTEPASO EP, 
		 ESTADOSTUPA ET,
     EXPEDIENTE EX
WHERE (EP.EXPID, EP.NSECUENCIA) IN
        (SELECT A.EXPID, MAX(NSECUENCIA)
        	FROM EXPEDIENTEPASO A
        	GROUP BY A.EXPID) AND
       EP.TIPPASO = ET.TIPPASO AND
       EX.EXPID		= EP.EXPID 
WITH READ ONLY;

 COMMENT ON TABLE VPROYECTOESTADO IS
'Estados de cada Proyecto (en verdad es la situaci�n del tr�mite de solicitud de certificaci�n ambiental de los proyectos)';

ALTER TABLE ACAE
   ADD CONSTRAINT FK_ACAE_ASSOCIATI_SUBSECTO FOREIGN KEY (CLSSECTOR, CLSSUBSECTOR)
      REFERENCES SUBSECTOR (CLSSECTOR, CLSSUBSECTOR);

ALTER TABLE ACAE
   ADD CONSTRAINT FK_ACAE_GENERALIZ_PERSONA FOREIGN KEY (PERSONAID)
      REFERENCES PERSONA (PERSONAID);

ALTER TABLE CONTROLENVIO
   ADD CONSTRAINT FK_CONTROLE_ASSOCIATI_ACAE FOREIGN KEY (PERSONAID)
      REFERENCES ACAE (PERSONAID);

ALTER TABLE EXPEDIENTE
   ADD CONSTRAINT FK_EXPEDIEN_ASSOCIATI_PROYECTO FOREIGN KEY (PRYID)
      REFERENCES PROYECTO (PRYID);

ALTER TABLE EXPEDIENTE
   ADD CONSTRAINT FK_EXPEDIEN_ASSOCIATI_ACAE FOREIGN KEY (PERSONAID)
      REFERENCES ACAE (PERSONAID);

ALTER TABLE PROYECTO
   ADD CONSTRAINT FK_PROYECTO_ASSOCIATI_UBIGEO FOREIGN KEY (UBIGEOID)
      REFERENCES UBIGEO (UBIGEOID);

ALTER TABLE PROYECTO
   ADD CONSTRAINT FK_PROYECTO_ASSOCIATI_PROPONEN FOREIGN KEY (PERSONAID)
      REFERENCES PROPONENTE (PERSONAID);

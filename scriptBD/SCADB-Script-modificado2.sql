/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     13/05/2009 10:25:24 p.m.                     */
/*==============================================================*/


ALTER TABLE ACAE
   DROP CONSTRAINT FK_ACAE_ASSOCIATI_SUBSECTO;

ALTER TABLE ACAE
   DROP CONSTRAINT FK_ACAE_GENERALIZ_PERSONA;

ALTER TABLE EXPEDIENTE
   DROP CONSTRAINT FK_EXPEDIEN_ASSOCIATI_ACAE;

ALTER TABLE ACAE
   DROP PRIMARY KEY CASCADE;

DROP TABLE TMP_ACAE CASCADE CONSTRAINTS;

RENAME ACAE TO TMP_ACAE;

/*==============================================================*/
/* Table: ACAE                                                  */
/*==============================================================*/
CREATE TABLE ACAE  (
   PERSONAID            INTEGER                         NOT NULL,
   TIPACAE              VARCHAR2(3),
   CLSSECTOR            VARCHAR2(3)                     NOT NULL,
   CLSSUBSECTOR         VARCHAR2(4)                     NOT NULL,
   TIPDOCUMENTOGER      VARCHAR2(3),
   CODDOCUMENTOGER      VARCHAR2(50),
   TXTAPELLIDOSNOMBRES  VARCHAR2(1000),
   TXTCARGO             VARCHAR2(255),
   TELEFONOGER          VARCHAR2(50),
   CONSTRAINT PK_ACAE PRIMARY KEY (PERSONAID)
);

COMMENT ON TABLE ACAE IS
'Autoridades sectoriales que expiden las certificaciones ambientales (con resolucion)';

INSERT INTO ACAE (PERSONAID, CLSSECTOR, CLSSUBSECTOR, TIPDOCUMENTOGER, CODDOCUMENTOGER, TXTAPELLIDOSNOMBRES, TXTCARGO, TELEFONOGER)
SELECT PERSONAID, CLSSECTOR, CLSSUBSECTOR, TIPDOCUMENTOGER, CODDOCUMENTOGER, TXTAPELLIDOSNOMBRES, TXTCARGO, TELEFONOGER
FROM TMP_ACAE;

ALTER TABLE ACAE
   ADD CONSTRAINT FK_ACAE_ASSOCIATI_SUBSECTO FOREIGN KEY (CLSSECTOR, CLSSUBSECTOR)
      REFERENCES SUBSECTOR (CLSSECTOR, CLSSUBSECTOR);

ALTER TABLE ACAE
   ADD CONSTRAINT FK_ACAE_GENERALIZ_PERSONA FOREIGN KEY (PERSONAID)
      REFERENCES PERSONA (PERSONAID);

ALTER TABLE EXPEDIENTE
   ADD CONSTRAINT FK_EXPEDIEN_ASSOCIATI_ACAE FOREIGN KEY (PERSONAID)
      REFERENCES ACAE (PERSONAID);

----------------------------
ALTER TABLE PARAMETROS
   DROP PRIMARY KEY CASCADE;

DROP TABLE TMP_PARAMETROS CASCADE CONSTRAINTS;

RENAME PARAMETROS TO TMP_PARAMETROS;

/*==============================================================*/
/* Table: PARAMETROS                                            */
/*==============================================================*/
CREATE TABLE PARAMETROS  (
   IDPARAMETRO          INTEGER                         NOT NULL,
   CODPARAMETRO         VARCHAR2(6)                     NOT NULL,
   TIPPARAMETRO         VARCHAR2(3),
   TXTPARAMETRO         VARCHAR2(255),
   TXTVALOR             VARCHAR2(255),
   CONSTRAINT PK_PARAMETROS PRIMARY KEY (IDPARAMETRO)
);

INSERT INTO PARAMETROS (IDPARAMETRO, CODPARAMETRO, TIPPARAMETRO, TXTPARAMETRO, TXTVALOR)
SELECT IDPARAMETRO, CODPARAMETRO, TIPPARAMETRO, TXTPARAMETRO, TXTVALOR
FROM TMP_PARAMETROS;

ALTER TABLE TEXPEDIENTE ADD NUMITAM VARCHAR2(50);

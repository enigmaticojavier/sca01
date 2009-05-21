/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     21/05/2009 09:15:08 a.m.                     */
/*==============================================================*/


ALTER TABLE CONTROLENVIO
   DROP CONSTRAINT FK_CONTROLE_ASSOCIATI_ACAE;

ALTER TABLE CONTROLENVIO
   DROP PRIMARY KEY CASCADE;

DROP TABLE TMP_CONTROLENVIO CASCADE CONSTRAINTS;

RENAME CONTROLENVIO TO TMP_CONTROLENVIO;

/*==============================================================*/
/* Table: CONTROLENVIO                                          */
/*==============================================================*/
CREATE TABLE CONTROLENVIO  (
   PERIODO              VARCHAR2(254)                   NOT NULL,
   PERSONAID            INTEGER                         NOT NULL,
   FLGENVIOPRY          VARCHAR2(6),
   FCHENVIOPRY          DATE,
   FLGENVIOPRO          VARCHAR2(254),
   FCHENVIOPRO          DATE,
   FLGENVIOEXP          VARCHAR2(254),
   FCHENVIOEXP          DATE,
   CONSTRAINT PK_CONTROLENVIO PRIMARY KEY (PERIODO, PERSONAID)
);

--WARNING: THE FOLLOWING INSERT ORDER WILL NOT RESTORE COLUMNS: NUMREGISTROS
INSERT INTO CONTROLENVIO (PERIODO, PERSONAID, FLGENVIOPRY, FCHENVIOPRY)
SELECT PERIODO, PERSONAID, TIPSITUACION, FCHENVIO
FROM TMP_CONTROLENVIO;

/*==============================================================*/
/* Table: TCATALOGOTIPOS                                        */
/*==============================================================*/
CREATE TABLE TCATALOGOTIPOS  (
   NUMID                INTEGER                         NOT NULL,
   TABLA                VARCHAR2(30),
   COLUMNA              VARCHAR2(30),
   TIPPARAMETRO         VARCHAR2(3),
   CONSTRAINT PK_TCATALOGOTIPOS PRIMARY KEY (NUMID)
);

ALTER TABLE CONTROLENVIO
   ADD CONSTRAINT FK_CONTROLE_ASSOCIATI_ACAE FOREIGN KEY (PERSONAID)
      REFERENCES ACAE (PERSONAID);


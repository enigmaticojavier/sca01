/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     16/05/2009 12:35:20 p.m.                     */
/*==============================================================*/


ALTER TABLE PARAMETROS
   DROP PRIMARY KEY CASCADE;

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

RENAME PARAMETROS TO PARAMETRO;

ALTER TABLE PARAMETRO
   ADD CONSTRAINT PK_PARAMETRO PRIMARY KEY (IDPARAMETRO);

ALTER TABLE PERSONA 
   RENAME COLUMN TIPOPERSONA TO TIPPERSONA;

ALTER TABLE CONTROLENVIO
   ADD CONSTRAINT FK_CONTROLE_ASSOCIATI_ACAE FOREIGN KEY (PERSONAID)
      REFERENCES ACAE (PERSONAID);


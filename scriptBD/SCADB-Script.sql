/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     01/05/2009 12:44:35 p.m.                     */
/*==============================================================*/


alter table Acae
   drop constraint FK_ACAE_ASSOCIATI_SUBSECTO;

alter table Acae
   drop constraint FK_ACAE_GENERALIZ_PERSONA;

alter table Consultor
   drop constraint FK_CONSULTO_GENERALIZ_PERSONA;

alter table DocumentoPersona
   drop constraint FK_DOCUMENT_ASSOCIATI_PERSONA;

alter table DocumentoPersona
   drop constraint FK_DOCUMENT_ASSOCIATI_DOCUMENT;

alter table Eia
   drop constraint FK_EIA_GENERALIZ_DOCUMENT;

alter table Expediente
   drop constraint FK_EXPEDIEN_ASSOCIATI_PROYECTO;

alter table Expediente
   drop constraint FK_EXPEDIEN_ASSOCIATI_ACAE;

alter table ExpedienteDocumento
   drop constraint FK_EXPEDIEN_ASSOCIATI_EXPEDIEN;

alter table ExpedienteDocumento
   drop constraint FK_EXPEDIEN_ASSOCIATI_DOCUMENT;

alter table ExpedientePaso
   drop constraint FK_EXPEDIEN_ASSOCIATI_EXPEDIE2;

alter table ImagenDocumento
   drop constraint FK_IMAGENDO_ASSOCIATI_DOCUMENT;

alter table Persona
   drop constraint FK_PERSONA_ASSOCIATI_UBIGEO;

alter table Proponente
   drop constraint FK_PROPONEN_GENERALIZ_PERSONA;

alter table Proyecto
   drop constraint FK_PROYECTO_ASSOCIATI_UBIGEO;

alter table Proyecto
   drop constraint FK_PROYECTO_ASSOCIATI_PROPONEN;

alter table Resolucion
   drop constraint FK_RESOLUCI_GENERALIZ_DOCUMENT;

alter table Usuario
   drop constraint FK_USUARIO_ASSOCIATI_PERSONA;

drop table Acae cascade constraints;

drop table Consultor cascade constraints;

drop table Documento cascade constraints;

drop table DocumentoPersona cascade constraints;

drop table Eia cascade constraints;

drop table EstadosTUPA cascade constraints;

drop table Expediente cascade constraints;

drop table ExpedienteDocumento cascade constraints;

drop table ExpedientePaso cascade constraints;

drop table ImagenDocumento cascade constraints;

drop table Parametros cascade constraints;

drop table Persona cascade constraints;

drop table Proponente cascade constraints;

drop table Proyecto cascade constraints;

drop table Resolucion cascade constraints;

drop table SubSector cascade constraints;

drop table Ubigeo cascade constraints;

drop table Usuario cascade constraints;

/*==============================================================*/
/* Table: Acae                                                */
/*==============================================================*/
create table Acae  (
   PersonaId          INTEGER                         not null,
   ClsSector          CHAR(3)                         not null,
   ClsSubSector       CHAR(4)                         not null,
   TipDocumentoGer    CHAR(3),
   CodDocumentoGer    VARCHAR2(50),
   TxtApellidosNombres VARCHAR2(1000),
   TxtCargo           VARCHAR2(255),
   constraint PK_ACAE primary key (PersonaId)
);

/*==============================================================*/
/* Table: Consultor                                           */
/*==============================================================*/
create table Consultor  (
   PersonaId          INTEGER                         not null,
   constraint PK_CONSULTOR primary key (PersonaId)
);

/*==============================================================*/
/* Table: Documento                                           */
/*==============================================================*/
create table Documento  (
   DocId              INTEGER                         not null,
   TipoDocumento      CHAR(3),
   CodDocumento       VARCHAR2(50),
   FchExpedicion      DATE,
   FchPresentacion    DATE,
   constraint PK_DOCUMENTO primary key (DocId)
);

/*==============================================================*/
/* Table: DocumentoPersona                                    */
/*==============================================================*/
create table DocumentoPersona  (
   DocId              INTEGER                         not null,
   PersonaId          INTEGER                         not null,
   TipoDocPersona     CHAR(3)                         not null,
   constraint PK_DOCUMENTOPERSONA primary key (DocId, PersonaId, TipoDocPersona)
);

/*==============================================================*/
/* Table: Eia                                                 */
/*==============================================================*/
create table Eia  (
   DocId              INTEGER                         not null,
   TxtResumen         VARCHAR2(1000),
   constraint PK_EIA primary key (DocId)
);

/*==============================================================*/
/* Table: EstadosTUPA                                         */
/*==============================================================*/
create table EstadosTUPA  (
   TipTramite         CHAR(3)                         not null,
   NumSecuencia       INTEGER                         not null,
   TipPaso            CHAR(3)                         not null,
   TipEstadoTramite   CHAR(3),
   constraint PK_ESTADOSTUPA primary key (TipTramite, NumSecuencia)
);

/*==============================================================*/
/* Table: Expediente                                          */
/*==============================================================*/
create table Expediente  (
   ExpId              INTEGER                         not null,
   PryId              INTEGER                         not null,
   PersonaId          INTEGER                         not null,
   NumExpediente      VARCHAR2(50),
   FchExpediente      DATE,
   TipTramite         CHAR(3),
   ClsTipificacion    CHAR(4),
   constraint PK_EXPEDIENTE primary key (ExpId)
);

/*==============================================================*/
/* Table: ExpedienteDocumento                                 */
/*==============================================================*/
create table ExpedienteDocumento  (
   ExpId              INTEGER                         not null,
   Nsecuencia         INTEGER                         not null,
   NSecuenciadoc      INTEGER                         not null,
   DocId              INTEGER                         not null,
   constraint PK_EXPEDIENTEDOCUMENTO primary key (ExpId, Nsecuencia, NSecuenciadoc)
);

/*==============================================================*/
/* Table: ExpedientePaso                                      */
/*==============================================================*/
create table ExpedientePaso  (
   ExpId              INTEGER                         not null,
   Nsecuencia         INTEGER                         not null,
   TipPaso            CHAR(3),
   FchPaso            DATE,
   constraint PK_EXPEDIENTEPASO primary key (ExpId, Nsecuencia)
);

/*==============================================================*/
/* Table: ImagenDocumento                                     */
/*==============================================================*/
create table ImagenDocumento  (
   Nsecuencia         INTEGER                         not null,
   DocId              INTEGER                         not null,
   TxtRutaImagen      VARCHAR2(1000),
   constraint PK_IMAGENDOCUMENTO primary key (Nsecuencia)
);

/*==============================================================*/
/* Table: Parametros                                          */
/*==============================================================*/
create table Parametros  (
   IdParametro        INTEGER                         not null,
   CodParametro       CHAR(3)                         not null,
   TipParametro       CHAR(3),
   TxtParametro       VARCHAR2(255),
   TxtValor           VARCHAR2(255),
   constraint PK_PARAMETROS primary key (IdParametro, CodParametro)
);

/*==============================================================*/
/* Table: Persona                                             */
/*==============================================================*/
create table Persona  (
   PersonaId          INTEGER                         not null,
   UbigeoId           VARCHAR2(6),
   TipoPersona        CHAR(3),
   TxtRazonSocial     VARCHAR2(255),
   TxtDomicilio       VARCHAR2(255),
   Telefono           VARCHAR2(50),
   TxtEmail           VARCHAR2(50),
   Fax                VARCHAR2(50),
   constraint PK_PERSONA primary key (PersonaId)
);

/*==============================================================*/
/* Table: Proponente                                          */
/*==============================================================*/
create table Proponente  (
   PersonaId          INTEGER                         not null,
   TipoDocumentoRL    CHAR(3),
   CodDocumentoRL     VARCHAR2(50),
   TxtNombresRL       VARCHAR2(255),
   constraint PK_PROPONENTE primary key (PersonaId)
);

/*==============================================================*/
/* Table: Proyecto                                            */
/*==============================================================*/
create table Proyecto  (
   PryId              INTEGER                         not null,
   UbigeoId           VARCHAR2(6),
   PersonaId          INTEGER                         not null,
   TxtCoordenadas     VARCHAR2(1000),
   ClsTipificacion    CHAR(4),
   TxtDescripcion     VARCHAR2(1000),
   MnInversion        BINARY_DOUBLE,
   ClsSector          CHAR(4),
   ClsSubSector       CHAR(4),
   FchExpediente      DATE,
   constraint PK_PROYECTO primary key (PryId)
);

/*==============================================================*/
/* Table: Resolucion                                          */
/*==============================================================*/
create table Resolucion  (
   DocId              INTEGER                         not null,
   TipResolucion      CHAR(3),
   FchPublicacion     DATE,
   FchVigencia        DATE,
   Resumen            VARCHAR2(1000),
   constraint PK_RESOLUCION primary key (DocId)
);

/*==============================================================*/
/* Table: SubSector                                           */
/*==============================================================*/
create table SubSector  (
   ClsSector          CHAR(3)                         not null,
   ClsSubSector       CHAR(4)                         not null,
   TxtSubSector       VARCHAR2(255),
   constraint PK_SUBSECTOR primary key (ClsSector, ClsSubSector)
);

/*==============================================================*/
/* Table: Ubigeo                                              */
/*==============================================================*/
create table Ubigeo  (
   UbigeoId           VARCHAR2(6)                     not null,
   TxtDescripcion     VARCHAR2(255),
   constraint PK_UBIGEO primary key (UbigeoId)
);

/*==============================================================*/
/* Table: Usuario                                             */
/*==============================================================*/
create table Usuario  (
   Usuario            VARCHAR2(50)                    not null,
   PersonaId          INTEGER                         not null,
   CodClave           VARCHAR2(50),
   TipUsuario         CHAR(3),
   constraint PK_USUARIO primary key (Usuario)
);

alter table Acae
   add constraint FK_ACAE_ASSOCIATI_SUBSECTO foreign key (ClsSector, ClsSubSector)
      references SubSector (ClsSector, ClsSubSector);

alter table Acae
   add constraint FK_ACAE_GENERALIZ_PERSONA foreign key (PersonaId)
      references Persona (PersonaId);

alter table Consultor
   add constraint FK_CONSULTO_GENERALIZ_PERSONA foreign key (PersonaId)
      references Persona (PersonaId);

alter table DocumentoPersona
   add constraint FK_DOCUMENT_ASSOCIATI_PERSONA foreign key (PersonaId)
      references Persona (PersonaId);

alter table DocumentoPersona
   add constraint FK_DOCUMENT_ASSOCIATI_DOCUMENT foreign key (DocId)
      references Documento (DocId);

alter table Eia
   add constraint FK_EIA_GENERALIZ_DOCUMENT foreign key (DocId)
      references Documento (DocId);

alter table Expediente
   add constraint FK_EXPEDIEN_ASSOCIATI_PROYECTO foreign key (PryId)
      references Proyecto (PryId);

alter table Expediente
   add constraint FK_EXPEDIEN_ASSOCIATI_ACAE foreign key (PersonaId)
      references Acae (PersonaId);

alter table ExpedienteDocumento
   add constraint FK_EXPEDIEN_ASSOCIATI_EXPEDIEN foreign key (ExpId, Nsecuencia)
      references ExpedientePaso (ExpId, Nsecuencia);

alter table ExpedienteDocumento
   add constraint FK_EXPEDIEN_ASSOCIATI_DOCUMENT foreign key (DocId)
      references Documento (DocId);

alter table ExpedientePaso
   add constraint FK_EXPEDIEN_ASSOCIATI_EXPEDIE2 foreign key (ExpId)
      references Expediente (ExpId);

alter table ImagenDocumento
   add constraint FK_IMAGENDO_ASSOCIATI_DOCUMENT foreign key (DocId)
      references Documento (DocId);

alter table Persona
   add constraint FK_PERSONA_ASSOCIATI_UBIGEO foreign key (UbigeoId)
      references Ubigeo (UbigeoId);

alter table Proponente
   add constraint FK_PROPONEN_GENERALIZ_PERSONA foreign key (PersonaId)
      references Persona (PersonaId);

alter table Proyecto
   add constraint FK_PROYECTO_ASSOCIATI_UBIGEO foreign key (UbigeoId)
      references Ubigeo (UbigeoId);

alter table Proyecto
   add constraint FK_PROYECTO_ASSOCIATI_PROPONEN foreign key (PersonaId)
      references Proponente (PersonaId);

alter table Resolucion
   add constraint FK_RESOLUCI_GENERALIZ_DOCUMENT foreign key (DocId)
      references Documento (DocId);

alter table Usuario
   add constraint FK_USUARIO_ASSOCIATI_PERSONA foreign key (PersonaId)
      references Persona (PersonaId);


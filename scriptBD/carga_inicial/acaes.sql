prompt PL/SQL Developer import file
prompt Created on Miércoles, 27 de Mayo de 2009 by JORGE
set feedback off
set define off
prompt Disabling triggers for PERSONA...
alter table PERSONA disable all triggers;
prompt Disabling triggers for ACAE...
alter table ACAE disable all triggers;
prompt Disabling foreign key constraints for PERSONA...
alter table PERSONA disable constraint FK_PERSONA_ASSOCIATI_UBIGEO;
prompt Disabling foreign key constraints for ACAE...
alter table ACAE disable constraint FK_ACAE_ASSOCIATI_SUBSECTO;
alter table ACAE disable constraint FK_ACAE_GENERALIZ_PERSONA;

prompt Loading PERSONA...
insert into PERSONA (PERSONAID, UBIGEOID, TIPDOCUMENTOPER, NUMDOCUMENTOPER, TIPPERSONA, TXTRAZONSOCIAL, TXTDOMICILIO, TELEFONO, TXTEMAIL, FAX)
values (3, '150101', 'RUC', '20131368829', 'ACA', 'MINEM - DIRECCION GENERAL DE ASUNTOS AMBIENTALES ENERGETICOS', 'AV. LAS ARTES NRO. 260 URB. SAN BORJA ', '4750065', null, null);
insert into PERSONA (PERSONAID, UBIGEOID, TIPDOCUMENTOPER, NUMDOCUMENTOPER, TIPPERSONA, TXTRAZONSOCIAL, TXTDOMICILIO, TELEFONO, TXTEMAIL, FAX)
values (4, '150101', 'RUC', '20131368829', 'ACA', 'MINEM - DIRECCION GENERAL DE ASUNTOS AMBIENTALES MINEROS', 'AV. LAS ARTES NRO. 260 URB. SAN BORJA ', '4750065', null, null);
insert into PERSONA (PERSONAID, UBIGEOID, TIPDOCUMENTOPER, NUMDOCUMENTOPER, TIPPERSONA, TXTRAZONSOCIAL, TXTDOMICILIO, TELEFONO, TXTEMAIL, FAX)
values (5, '150101', 'RUC', '20504794637', 'ACA', 'PRODUCE - DIRECCION GENERAL DE ASUNTOS AMBIENTALES DE INDUSTRIA', 'CAL. UNO OESTE NRO. 60 URB. CORPAC', '4151111', null, null);
prompt 3 records loaded
prompt Loading ACAE...
insert into ACAE (PERSONAID, CLSSECTOR, CLSSUBSECTOR, TIPACAE, TIPDOCUMENTOGER, CODDOCUMENTOGER, TXTAPELLIDOSNOMBRES, TXTCARGO, TELEFONOGER)
values (3, 'EYM', 'EYM1', 'MIN', null, null, null, 'DIRECTOR', null);
insert into ACAE (PERSONAID, CLSSECTOR, CLSSUBSECTOR, TIPACAE, TIPDOCUMENTOGER, CODDOCUMENTOGER, TXTAPELLIDOSNOMBRES, TXTCARGO, TELEFONOGER)
values (4, 'EYM', 'EYM2', 'MIN', null, null, null, 'DIRECTOR', null);
insert into ACAE (PERSONAID, CLSSECTOR, CLSSUBSECTOR, TIPACAE, TIPDOCUMENTOGER, CODDOCUMENTOGER, TXTAPELLIDOSNOMBRES, TXTCARGO, TELEFONOGER)
values (5, 'PRO', 'PRO1', 'MIN', null, null, null, 'DIRECTOR', null);
prompt 3 records loaded
prompt Enabling foreign key constraints for PERSONA...
alter table PERSONA enable constraint FK_PERSONA_ASSOCIATI_UBIGEO;
prompt Enabling foreign key constraints for ACAE...
alter table ACAE enable constraint FK_ACAE_ASSOCIATI_SUBSECTO;
alter table ACAE enable constraint FK_ACAE_GENERALIZ_PERSONA;
prompt Enabling triggers for PERSONA...
alter table PERSONA enable all triggers;
prompt Enabling triggers for ACAE...
alter table ACAE enable all triggers;
set feedback on
set define on
prompt Done.

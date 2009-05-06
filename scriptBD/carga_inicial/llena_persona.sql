prompt PL/SQL Developer import file
prompt Created on Martes, 05 de Mayo de 2009 by JORGE
set feedback off
set define off
prompt Disabling triggers for PERSONA...
alter table PERSONA disable all triggers;
prompt Disabling foreign key constraints for PERSONA...
alter table PERSONA disable constraint FK_PERSONA_ASSOCIATI_UBIGEO;
prompt Deleting PERSONA...
delete from PERSONA;
prompt Loading PERSONA...
insert into PERSONA (PERSONAID, UBIGEOID, TIPOPERSONA, TXTRAZONSOCIAL, TXTDOMICILIO, TELEFONO, TXTEMAIL, FAX, TIPDOCUMENTOPER, NUMDOCUMENTOPER)
values (1, '150101', 'ACA', 'OFICINA DE MEDIO AMBIENTE', 'PASEO DE LA REPUBLICA 3329', '51-1-6230000', 'wanaya@vivienda.gob.pe', null, 'RUC', '20504743307');
insert into PERSONA (PERSONAID, UBIGEOID, TIPOPERSONA, TXTRAZONSOCIAL, TXTDOMICILIO, TELEFONO, TXTEMAIL, FAX, TIPDOCUMENTOPER, NUMDOCUMENTOPER)
values (2, '150101', 'PRO', 'MINERA BARRICK MISQUICHILCA', 'AV. VICTOR ANDRES BELAUNDE No 171, 2do PISO', '51 1 612 4100', null, '51 1 612 4110' || chr(10) || '', 'RUC', '20209133394');
insert into PERSONA (PERSONAID, UBIGEOID, TIPOPERSONA, TXTRAZONSOCIAL, TXTDOMICILIO, TELEFONO, TXTEMAIL, FAX, TIPDOCUMENTOPER, NUMDOCUMENTOPER)
values (0, '150101', 'ACA', 'MINISTERIO DEL AMBIENTE', 'AV. GUARDIA CIVIL NRO. 205 URB. CORPAC', null, 'mchavez@minam.gob.pe', null, 'RUC', '20492966658');
prompt 3 records loaded
prompt Enabling foreign key constraints for PERSONA...
alter table PERSONA enable constraint FK_PERSONA_ASSOCIATI_UBIGEO;
prompt Enabling triggers for PERSONA...
alter table PERSONA enable all triggers;
set feedback on
set define on
prompt Done.

prompt PL/SQL Developer import file
prompt Created on Martes, 05 de Mayo de 2009 by JORGE
set feedback off
set define off
prompt Disabling triggers for ACAE...
alter table ACAE disable all triggers;
prompt Disabling foreign key constraints for ACAE...
alter table ACAE disable constraint FK_ACAE_ASSOCIATI_SUBSECTO;
alter table ACAE disable constraint FK_ACAE_GENERALIZ_PERSONA;
prompt Deleting ACAE...
delete from ACAE;
prompt Loading ACAE...
insert into ACAE (PERSONAID, CLSSECTOR, CLSSUBSECTOR, TIPDOCUMENTOGER, CODDOCUMENTOGER, TXTAPELLIDOSNOMBRES, TXTCARGO, TELEFONOGER)
values (1, 'VCS', 'VCS2', null, null, 'CAMPOS CAMPOS JORGE S.', 'ANALISTA', null);
prompt 1 records loaded
prompt Enabling foreign key constraints for ACAE...
alter table ACAE enable constraint FK_ACAE_ASSOCIATI_SUBSECTO;
alter table ACAE enable constraint FK_ACAE_GENERALIZ_PERSONA;
prompt Enabling triggers for ACAE...
alter table ACAE enable all triggers;
set feedback on
set define on
prompt Done.

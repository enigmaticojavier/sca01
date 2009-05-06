prompt PL/SQL Developer import file
prompt Created on Martes, 05 de Mayo de 2009 by JORGE
set feedback off
set define off
prompt Disabling triggers for USUARIO...
alter table USUARIO disable all triggers;
prompt Disabling foreign key constraints for USUARIO...
alter table USUARIO disable constraint FK_USUARIO_ASSOCIATI_PERSONA;
prompt Deleting USUARIO...
delete from USUARIO;
prompt Loading USUARIO...
insert into USUARIO (USUARIO, PERSONAID, CODCLAVE, TIPUSUARIO)
values ('JCAMPOS', 1, 'JORGE', 'ACA');
insert into USUARIO (USUARIO, PERSONAID, CODCLAVE, TIPUSUARIO)
values ('DANTIPORTA', 0, 'DANTE', 'ADM');
prompt 2 records loaded
prompt Enabling foreign key constraints for USUARIO...
alter table USUARIO enable constraint FK_USUARIO_ASSOCIATI_PERSONA;
prompt Enabling triggers for USUARIO...
alter table USUARIO enable all triggers;
set feedback on
set define on
prompt Done.

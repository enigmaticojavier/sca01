prompt PL/SQL Developer import file
prompt Created on Martes, 05 de Mayo de 2009 by JORGE
set feedback off
set define off
prompt Disabling triggers for PROPONENTE...
alter table PROPONENTE disable all triggers;
prompt Disabling foreign key constraints for PROPONENTE...
alter table PROPONENTE disable constraint FK_PROPONEN_GENERALIZ_PERSONA;
prompt Deleting PROPONENTE...
delete from PROPONENTE;
prompt Loading PROPONENTE...
insert into PROPONENTE (PERSONAID, TIPODOCUMENTORL, CODDOCUMENTORL, TXTNOMBRESRL)
values (2, 'CEX', '000076379', 'WAGNER DARRELL EDWARD');
prompt 1 records loaded
prompt Enabling foreign key constraints for PROPONENTE...
alter table PROPONENTE enable constraint FK_PROPONEN_GENERALIZ_PERSONA;
prompt Enabling triggers for PROPONENTE...
alter table PROPONENTE enable all triggers;
set feedback on
set define on
prompt Done.

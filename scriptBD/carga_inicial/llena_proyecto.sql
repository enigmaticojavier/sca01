prompt PL/SQL Developer import file
prompt Created on Martes, 05 de Mayo de 2009 by JORGE
set feedback off
set define off
prompt Disabling triggers for PROYECTO...
alter table PROYECTO disable all triggers;
prompt Disabling foreign key constraints for PROYECTO...
alter table PROYECTO disable constraint FK_PROYECTO_ASSOCIATI_PROPONEN;
alter table PROYECTO disable constraint FK_PROYECTO_ASSOCIATI_UBIGEO;
prompt Deleting PROYECTO...
delete from PROYECTO;
prompt Loading PROYECTO...
insert into PROYECTO (PRYID, UBIGEOID, PERSONAID, TXTCOORDENADAS, CLSTIPIFICACION, TXTDESCRIPCION, MNINVERSION, CLSSECTOR, CLSSUBSECTOR, FCHEXPEDIENTE)
values (1, '020106', 2, null, 'CA3 ', 'PROYECTO PIERINA', null, 'EYM ', 'EYM1', to_date('01-05-1995', 'dd-mm-yyyy'));
prompt 1 records loaded
prompt Enabling foreign key constraints for PROYECTO...
alter table PROYECTO enable constraint FK_PROYECTO_ASSOCIATI_PROPONEN;
alter table PROYECTO enable constraint FK_PROYECTO_ASSOCIATI_UBIGEO;
prompt Enabling triggers for PROYECTO...
alter table PROYECTO enable all triggers;
set feedback on
set define on
prompt Done.

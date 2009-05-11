prompt PL/SQL Developer import file
prompt Created on Lunes, 11 de Mayo de 2009 by JORGE
set feedback off
set define off
prompt Disabling triggers for ESTADOSTUPADOC...
alter table ESTADOSTUPADOC disable all triggers;
prompt Disabling foreign key constraints for ESTADOSTUPADOC...
alter table ESTADOSTUPADOC disable constraint FK_ESTADOST_ASSOCIATI_ESTADOST;
prompt Deleting ESTADOSTUPADOC...
delete from ESTADOSTUPADOC;
prompt Loading ESTADOSTUPADOC...
insert into ESTADOSTUPADOC (TIPTRAMITE, NUMSECUENCIA, TIPDOCUMENTO)
values ('SCA', 7, 'ITA');
insert into ESTADOSTUPADOC (TIPTRAMITE, NUMSECUENCIA, TIPDOCUMENTO)
values ('SCA', 8, 'EIA');
insert into ESTADOSTUPADOC (TIPTRAMITE, NUMSECUENCIA, TIPDOCUMENTO)
values ('SCA', 8, 'RES');
insert into ESTADOSTUPADOC (TIPTRAMITE, NUMSECUENCIA, TIPDOCUMENTO)
values ('SCA', 9, 'RES');
prompt 4 records loaded
prompt Enabling foreign key constraints for ESTADOSTUPADOC...
alter table ESTADOSTUPADOC enable constraint FK_ESTADOST_ASSOCIATI_ESTADOST;
prompt Enabling triggers for ESTADOSTUPADOC...
alter table ESTADOSTUPADOC enable all triggers;
set feedback on
set define on
prompt Done.

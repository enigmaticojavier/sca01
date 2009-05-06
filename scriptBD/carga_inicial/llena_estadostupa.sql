prompt PL/SQL Developer import file
prompt Created on Martes, 05 de Mayo de 2009 by JORGE
set feedback off
set define off
prompt Disabling triggers for ESTADOSTUPA...
alter table ESTADOSTUPA disable all triggers;
prompt Deleting ESTADOSTUPA...
delete from ESTADOSTUPA;
prompt Loading ESTADOSTUPA...
insert into ESTADOSTUPA (TIPTRAMITE, NUMSECUENCIA, TIPPASO, TIPESTADOTRAMITE)
values ('SCA', 1, 'PSC', 'EVA');
insert into ESTADOSTUPA (TIPTRAMITE, NUMSECUENCIA, TIPPASO, TIPESTADOTRAMITE)
values ('SCA', 2, 'CLS', 'EVA');
insert into ESTADOSTUPA (TIPTRAMITE, NUMSECUENCIA, TIPPASO, TIPESTADOTRAMITE)
values ('SCA', 3, 'PSI', 'EVA');
insert into ESTADOSTUPA (TIPTRAMITE, NUMSECUENCIA, TIPPASO, TIPESTADOTRAMITE)
values ('SCA', 4, 'EVA', 'EVA');
insert into ESTADOSTUPA (TIPTRAMITE, NUMSECUENCIA, TIPPASO, TIPESTADOTRAMITE)
values ('SCA', 5, 'OBS', 'OBS');
insert into ESTADOSTUPA (TIPTRAMITE, NUMSECUENCIA, TIPPASO, TIPESTADOTRAMITE)
values ('SCA', 6, 'LOB', 'EVA');
insert into ESTADOSTUPA (TIPTRAMITE, NUMSECUENCIA, TIPPASO, TIPESTADOTRAMITE)
values ('SCA', 7, 'ITA', 'EVA');
insert into ESTADOSTUPA (TIPTRAMITE, NUMSECUENCIA, TIPPASO, TIPESTADOTRAMITE)
values ('SCA', 8, 'RDE', 'NAP');
insert into ESTADOSTUPA (TIPTRAMITE, NUMSECUENCIA, TIPPASO, TIPESTADOTRAMITE)
values ('SCA', 9, 'RAP', 'APR');
insert into ESTADOSTUPA (TIPTRAMITE, NUMSECUENCIA, TIPPASO, TIPESTADOTRAMITE)
values ('SDE', 1, 'DES', 'DES');
prompt 10 records loaded
prompt Enabling triggers for ESTADOSTUPA...
alter table ESTADOSTUPA enable all triggers;
set feedback on
set define on
prompt Done.

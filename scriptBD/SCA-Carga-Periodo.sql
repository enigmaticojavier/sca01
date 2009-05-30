prompt PL/SQL Developer import file
prompt Created on Sábado, 30 de Mayo de 2009 by Dante
set feedback off
set define off
prompt Disabling triggers for PERIODO...
alter table PERIODO disable all triggers;
prompt Deleting PERIODO...
delete from PERIODO;
commit;
prompt Loading PERIODO...
insert into PERIODO (ANIO, MES, PERACTUAL, ESTADO)
values (2009, 1, 1, 1);
insert into PERIODO (ANIO, MES, PERACTUAL, ESTADO)
values (2009, 2, 1, 1);
insert into PERIODO (ANIO, MES, PERACTUAL, ESTADO)
values (2009, 3, 1, 1);
insert into PERIODO (ANIO, MES, PERACTUAL, ESTADO)
values (2009, 4, 1, 1);
insert into PERIODO (ANIO, MES, PERACTUAL, ESTADO)
values (2009, 5, 1, 1);
insert into PERIODO (ANIO, MES, PERACTUAL, ESTADO)
values (2009, 6, 1, 1);
insert into PERIODO (ANIO, MES, PERACTUAL, ESTADO)
values (2009, 7, 1, 1);
insert into PERIODO (ANIO, MES, PERACTUAL, ESTADO)
values (2009, 8, 1, 1);
insert into PERIODO (ANIO, MES, PERACTUAL, ESTADO)
values (2009, 9, 1, 1);
insert into PERIODO (ANIO, MES, PERACTUAL, ESTADO)
values (2009, 10, 1, 1);
insert into PERIODO (ANIO, MES, PERACTUAL, ESTADO)
values (2009, 11, 1, 1);
insert into PERIODO (ANIO, MES, PERACTUAL, ESTADO)
values (2009, 12, 1, 1);
commit;
prompt 12 records loaded
prompt Enabling triggers for PERIODO...
alter table PERIODO enable all triggers;
set feedback on
set define on
prompt Done.

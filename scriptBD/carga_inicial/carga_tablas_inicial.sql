prompt PL/SQL Developer import file
prompt Created on Mi�rcoles, 27 de Mayo de 2009 by JORGE
set feedback off
set define off
prompt Disabling triggers for TEXPEDIENTE...
alter table TEXPEDIENTE disable all triggers;
prompt Disabling triggers for TPROPONENTE...
alter table TPROPONENTE disable all triggers;
prompt Disabling triggers for TPROYECTO...
alter table TPROYECTO disable all triggers;
prompt Deleting TPROYECTO...
delete from TPROYECTO;
prompt Deleting TPROPONENTE...
delete from TPROPONENTE;
prompt Deleting TEXPEDIENTE...
delete from TEXPEDIENTE;
prompt Loading TEXPEDIENTE...
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '838', '838', 'CLS', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '01-PRODUCE', to_date('01-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '839', '839', 'CLS', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '02-PRODUCE', to_date('02-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '840', '840', 'PSI', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), ' ', null, 'Descripci�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '840', '840', 'RAP', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '03-PRODUCE', to_date('03-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '841', '841', 'PSI', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), ' ', null, 'Descripci�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '841', '841', 'RAP', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '04-PRODUCE', to_date('04-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '842', '842', 'PSI', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), ' ', null, 'Descripci�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '842', '842', 'RAP', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '05-PRODUCE', to_date('05-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '843', '843', 'PSI', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), ' ', null, 'Descripci�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '843', '843', 'RAP', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '06-PRODUCE', to_date('06-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '844', '844', 'PSI', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), ' ', null, 'Descripci�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '844', '844', 'RAP', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '07-PRODUCE', to_date('07-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '845', '845', 'PSI', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), ' ', null, 'Descripci�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '845', '845', 'RAP', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '08-PRODUCE', to_date('08-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '846', '846', 'PSI', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), ' ', null, 'Descripci�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '846', '846', 'RAP', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '09-PRODUCE', to_date('09-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '847', '847', 'PSI', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), ' ', null, 'Descripci�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '847', '847', 'RAP', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '10-PRODUCE', to_date('10-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '848', '848', 'PSI', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), ' ', null, 'Descripci�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '848', '848', 'RAP', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '11-PRODUCE', to_date('11-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '849', '849', 'PSI', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), ' ', null, 'Descripci�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '849', '849', 'RAP', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '12-PRODUCE', to_date('12-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '850', '850', 'PSI', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), ' ', null, 'Descripci�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '850', '850', 'RAP', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '13-PRODUCE', to_date('13-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '851', '851', 'PSI', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), ' ', null, 'Descripci�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '851', '851', 'RAP', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '14-PRODUCE', to_date('14-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '852', '852', 'PSI', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), ' ', null, 'Descripci�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '852', '852', 'RAP', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '15-PRODUCE', to_date('15-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '853', '853', 'PSI', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), ' ', null, 'Descripci�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (5, '853', '853', 'RAP', '200905', to_date('31-03-2009', 'dd-mm-yyyy'), '16-PRODUCE', to_date('16-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (1, '003', '3', 'PSC', '200901', to_date('03-01-2009', 'dd-mm-yyyy'), null, null, null, null);
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (1, '020', '20', 'ITA', '200901', to_date('05-01-2009', 'dd-mm-yyyy'), null, null, null, '20');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (1, '2021', '2021', 'RAP', '200901', to_date('10-01-2009', 'dd-mm-yyyy'), '020-00001', to_date('11-01-2009', 'dd-mm-yyyy'), 'ESTUDIO DE IMPACTO AMBIENTAL CARRETERA DESDE LA MINA HACIA HUARAZ', null);
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '185423', '185423', 'PSI', '200905', to_date('23-01-2009', 'dd-mm-yyyy'), ' ', null, 'Definici�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '181431', '181431', 'PSI', '200905', to_date('21-08-2008', 'dd-mm-yyyy'), ' ', null, 'Definici�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '181566', '181566', 'PSI', '200905', to_date('27-08-2008', 'dd-mm-yyyy'), ' ', null, 'Definici�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '182414', '182414', 'PSI', '200905', to_date('25-09-2008', 'dd-mm-yyyy'), ' ', null, 'Definici�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '182602', '182602', 'PSI', '200905', to_date('03-10-2008', 'dd-mm-yyyy'), ' ', null, 'Definici�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '182858', '182858', 'PSI', '200905', to_date('10-10-2008', 'dd-mm-yyyy'), ' ', null, 'Definici�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '185423', '185423', 'RAP', '200905', to_date('17-03-2009', 'dd-mm-yyyy'), '010-2009-MEM-AAM', to_date('17-03-2009', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '181431', '181431', 'RAP', '200905', to_date('16-09-2008', 'dd-mm-yyyy'), '229-2008-MEM-AAM', to_date('16-09-2008', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '181566', '181566', 'RAP', '200905', to_date('17-09-2008', 'dd-mm-yyyy'), '012-2008-MEM-AAM', to_date('17-09-2008', 'dd-mm-yyyy'), ' ', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '182414', '182414', 'RAP', '200905', to_date('03-12-2008', 'dd-mm-yyyy'), '029-2008-MEM-AAM', to_date('03-12-2008', 'dd-mm-yyyy'), 'Constancia de aprobaci�n autom�tica', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '182602', '182602', 'RAP', '200905', to_date('13-10-2008', 'dd-mm-yyyy'), '015-2008-MEM-AAM', to_date('13-10-2008', 'dd-mm-yyyy'), 'Constancia de aprobaci�n autom�tica', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '182858', '182858', 'RAP', '200905', to_date('31-10-2008', 'dd-mm-yyyy'), '022-2008-MEM-AAM', to_date('31-10-2008', 'dd-mm-yyyy'), 'Constancia de aprobaci�n autom�tica', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '175091', '175091', 'PSI', '200905', to_date('15-01-2008', 'dd-mm-yyyy'), ' ', null, 'Definici�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '174418', '174418', 'PSI', '200905', to_date('14-12-2007', 'dd-mm-yyyy'), ' ', null, 'Definici�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '170416', '170416', 'PSI', '200905', to_date('09-07-2007', 'dd-mm-yyyy'), ' ', null, 'Definici�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '175091', '175091', 'RAP', '200905', to_date('13-06-2008', 'dd-mm-yyyy'), '142-2008-MEM-AAM', to_date('13-06-2008', 'dd-mm-yyyy'), 'Resoluci�n Directoral', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '174418', '174418', 'RAP', '200905', to_date('14-01-2009', 'dd-mm-yyyy'), '005-2009-MEM-AAM', to_date('14-01-2009', 'dd-mm-yyyy'), 'Resoluci�n Directoral', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (4, '170416', '170416', 'RAP', '200905', to_date('04-07-2008', 'dd-mm-yyyy'), '163-2008-MEM-AAM', to_date('04-07-2008', 'dd-mm-yyyy'), 'Resoluci�n Directoral', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (3, '151142', '151142', 'PSI', '200905', to_date('17-01-2005', 'dd-mm-yyyy'), ' ', null, 'Definici�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (3, '151142', '151142', 'RAP', '200905', to_date('15-12-2005', 'dd-mm-yyyy'), '402-2005-MEM/AAE ', to_date('15-12-2005', 'dd-mm-yyyy'), 'Resoluci�n Directoral', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (3, '161587', '161587', 'PSI', '200905', to_date('27-06-2006', 'dd-mm-yyyy'), ' ', null, 'Definici�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (3, '161587', '161587', 'RAP', '200905', to_date('15-12-2006', 'dd-mm-yyyy'), '789-2006-MEM/AAE', to_date('15-12-2006', 'dd-mm-yyyy'), 'Resoluci�n Directoral', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (3, '173322', '173322', 'PSI', '200905', to_date('07-11-2007', 'dd-mm-yyyy'), ' ', null, 'Definici�n breve', ' ');
insert into TEXPEDIENTE (NUMACAE, CODPROY, NUMEXPD, TIPTRAN, PERIODO, FCHTRAN, NUMRESL, FCHRESL, DSCBIGA, NUMITAM)
values (3, '173322', '173322', 'RAP', '200905', to_date('26-09-2008', 'dd-mm-yyyy'), '394-2008-MEM/AAE ', to_date('26-09-2008', 'dd-mm-yyyy'), 'Resoluci�n Directoral', ' ');
prompt 57 records loaded
prompt Loading TPROPONENTE...
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (3, '20433819544', '200905', 'ANGLO AMERICAN EXPLORATION PERU S.A.', 'DNI', '08235764', 'NORMAND SPARKS ENRIQUE', 'CAL. LOS LAURELES NRO. 399 LIMA LIMA SAN ISIDRO', '150131');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (3, '20513417676', '200905', 'MINERA SANTA ELISA S.A.C.', 'DNI', '08121337', 'MEDINA INGA DE BROPHY EMILSEN', 'CAL. 31 NRO. 226 URB. CORPAC LIMA - LIMA - SAN ISIDRO', '150131');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (3, '20462014181', '200905', 'MINERA SOLITARIO PERU S.A.C.', 'DNI', '08726817', 'CROVETTO YANEZ ANTONIO', 'JR. EL BUCARE NRO. 573 URB. CAMACHO LIMA - LIMA - LA MOLINA', '150114');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (3, '20251805858', '200905', 'COMPA�IA MINERA AURIFERA DEL SUR S.A.', 'DNI', '09178445', 'RAMIREZ GASTON ROE JOSE MIGUEL', 'AV. GRAL. TRINIDAD MORAN NRO. 821 LIMA-LIMA - LINCE', '150116');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (3, '20100056802', '200905', 'COMPA�IA MINERA CONDESTABLE S.A.', 'DNI', '07829885', 'TROVARELLI VECCHIO RICARDO JUAN', 'CAL. VICTOR ANDRES BELAUNDE NRO. 147  RES. SAN  ISIDRO LIMA - LIMA- SAN ISIDRO', '150131');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (3, '20512962735', '200905', 'MINERA SILLUSTANI S.A.', 'DNI', '07223997', 'MILLA VILLAFANA CARLOS ALBERTO', 'CAL. LAS BEGONIAS NRO. 441 INT 242 URB. JARDIN  LIMA - LIMA - SAN ISIDRO', '150131');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (3, '20507828915', '200905', 'GOLD FIELDS LA CIMA S.A.', 'DNI', '09339522', 'KRUGER SAYAN JUAN LUIS ALFREDO', 'AV. VIA PRINCIPAL NRO. 155 INT. 1401 LIMA-LIMA - SAN ISIDRO', '150131');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (3, '20100025591', '200905', 'EMPRESA ADMINISTRADORA CHUNGAR S.A.C.', 'DNI', '09148222', 'DE BERNARDIS CUGLIEVAN JOSE', 'AV. GREGORIO ESCOBEDO NRO. 710 LIMA- LIMA - JESUS MAR�A', '150113');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (3, '20100017572', '200905', 'SOCIEDAD MINERA EL BROCAL S.A.A.', 'DNI', '07852453', 'CRUZ RAMIREZ YSAAC RAUL', 'AV. JAVIER PRADO OESTE NRO. 2173 LIMA - LIMA - SAN ISIDRO', '150131');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (3, '20100176450', '200905', 'REPSOL YPF COMERCIAL DEL PERU S.A.', 'CEX', '116699', 'PRIETO GRANDAL JOSE MANUEL ', 'AV. VICTOR A. BELAUNDE NRO. 147 INT. 301 C.C.CAMINO REAL LIMA - LIMA - SAN ISIDRO', '150131');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (3, '20100153832', '200905', 'GRA�A Y MONTERO PETROLERA S.A.', 'DNI', '8254231', 'DULANTO SWAYNE FRANCISCO JAVIER ', 'AV. P DE LA REPUBLICA NRO. 4675 LIMA - LIMA - SURQUILLO', '150141');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (3, '20504311342', '200905', 'PLUSPETROL NORTE S.A.', 'PAS', '14470060', 'DE DIEGO CLAUDIO MARTIN', 'AV. REPUBLICA DE PANAMA NRO. 3055 LIMA - LIMA - SAN ISIDRO', '150131');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (1, '20100110513', '200901', 'COMPA�IA MINERA MILPO S.A.A.', null, null, null, 'AV. SN.BORJA NORTE NRO. 523 ', '150130');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (1, '20331898008', '200901', 'LUZ DEL SUR S.A.A.', null, null, null, 'AV. CANAVAL Y MOREYRA NRO. 380 ', '150131');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (1, '20516397072', '200901', 'CONSORCIO COSAPI - DHMONT', null, null, null, 'AV. ANGAMOS ESTE NRO. 1648 INT. 205', '150141');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (5, '20312372895', '200905', 'YURA S.A.', 'DNI', '09186797', 'RODRIGUEZ RODRIGUEZ VITO M', 'AV. REPUBLICA DE PANAMA NRO. 2461 URB. SANTA CATALINA LIMA - LIMA - LA VICTORIA', '150115');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (5, '20370146994', '200905', 'CORPORACION ACEROS AREQUIPA S.A.', 'CEX', '000133011', 'BLAY CEBOLLERO PEDRO ', 'CAL. JACINTO IBANEZ NRO. 111 Z.I. PARQUE INDUSTRIAL AREQUIPA - AREQUIPA - AREQUIPA', '040101');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (5, '20103732981', '200905', 'MAQUINARIAS Y VEHICULOS IQUITOS S.A', 'DNI', '05372850 ', 'CASTILLO CANANI VICTOR ARTURO JESUS ', 'JR. PROSPERO NRO. 374 LORETO - MAYNAS - IQUITOS', '160101');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (5, '20100132916', '200905', 'CERAMICOS PERUANOS S A', 'DNI', '41929766', 'ISLA QUISPE LILIANA OLGA', 'AV. REPUBLICA DE PANAMA NRO. 3563 INT. 501 URB. EL PALOMAR LIMA - LIMA - SAN ISIDRO', '150131');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (5, '20493508645', '200905', 'HONDA SELVA DEL PERU S.A.', 'CEX', '531033 ', 'KAJI NOBUYUKI ', 'CAR. IQUITOS NAUTA KM. 5.5 CARRETERA IQUITOS NAUTA LORETO - MAYNAS - SAN JUAN BAUTISTA', '160113');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (5, '20515602993', '200905', 'IMPORT EXPORT LAM S.A.C.', 'DNI', '09586561', 'AMPUERO MEZA LIBORIO ', 'SECTOR 2 MZA. F LOTE. 24 GRU. 18 LIMA - LIMA - VILLA EL SALVADOR', '150142');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (5, '20101026001', '200905', 'CERAMICA LIMA S.A.', 'DNI', '07275002 ', 'BELMONT CASSINELLI AUGUSTO ', 'AV. ALFREDO MENDIOLA NRO. 1465 URB. LA MILLA LIMA - LIMA - SAN MARTIN DE PORRES', '150135');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (5, '20100073723', '200905', 'CORPORACION PERUANA DE PRODUCTOS QUIMICOS S.A', 'DNI', '09751408', 'SCHENONE HUAMAN BRUNO RAFAEL ', 'JR. CHAMAYA NRO. 276 Z.I. I2 LIMA - LIMA - BRE�A', '150105');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (5, '20486438500', '200905', 'CIMESA SOCIEDAD COMERCIAL DE RESPONSABILIDAD LIMITADA', 'DNI', '20435374 ', 'VILLALVA TORPOCO CESAR AUGUSTO', 'CAR. CENTRAL KM. 21 JUNIN - CONCEPCION - CONCEPCION', '120201');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (5, '20191338856', '200905', 'PTC  S.A.C.', 'CEX', '000174524 ', 'TEBALDI TULLIO LUIGI ', 'AV. ALFONSO UGARTE NRO. 1855 URB. SANTA CLARA LIMA - LIMA - ATE', '150103');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (5, '20100005566', '200905', 'REACTIVOS NACIONALES S.A.', 'DNI', '10554913 ', 'BRAVO MONZON LUIS ENRIQUE ', 'AV. AV. NESTOR GAMBETTA NRO. 6448 Z.I. KM 5.2 CARR. A VENTANILLA PROV. CONST. DEL CALLAO - PROV. CONST. DEL CALLAO - CALLAO', '070101');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (5, '20513229675', '200905', 'CALCIOS DEL PACIFICO SUR S.A - CALSUR', 'DNI', '07794470', 'CARRILLO ULLOA RICARDO ENRIQUE ', 'AV. JAVIER PRADO OESTE NRO. 951 URB. EL ROSARIO LIMA - LIMA - SAN ISIDRO', '150131');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (5, '20419387658', '200905', 'CEMENTOS PACASMAYO S.A.A.', 'DNI', '09137017 ', 'ABRAM CABALLERINO LINO ALFREDO ', 'CAL. LA COLONIA NRO. 150 URB. EL VIVERO LIMA - LIMA - SANTIAGO DE SURCO', '150140');
insert into TPROPONENTE (NUMACAE, RUCPROP, PERIODO, RAZSOCI, TIPDORL, NUMDORL, NOMBRRL, DOMPROP, UBIGEOG)
values (5, '20492938794', '200905', 'CORPORACION TEXTIL DEL SUR S.A.C.', 'DNI', '42722640 ', 'ABREGU ANAMPA ROLANDO VALENTIN', 'CAL. 31 NRO. 165 INT. 102 URB. MARISCAL CASTILLA LIMA - LIMA - SAN BORJA', '150130');
prompt 29 records loaded
prompt Loading TPROYECTO...
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (1, '003', '200901', 'EXPLOTACI�N MINA MILPO III', 'CA2', '20100110513', null, 'VCS', 'VCS2', '190100', to_date('03-01-2009', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (1, '020', '200901', 'CONSTRUCCION DE OBRAS ELECTRICAS', 'CA3', '20331898008', null, 'VCS', 'VCS2', '150501', to_date('05-01-2009', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (1, '2021', '200901', 'CARRETERA DESDE LA MINA HACIA HUARAZ', 'CA3', '20516397072', null, 'VCS', 'VCS2', '020101', to_date('10-01-2009', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '838', '200905', 'INSTALACION DEL REEMPLAZO DE UNA MAQUINA DE ENSACADO MANUAL POR UNA NUEVA ENSACADORA ROTATIVA DE CEMENTO DENTRO DE LAS INSTALACIONES DE LA PLANTA PRINCIPAL DE CEMENTO', 'CA0', '20312372895', 0, 'PRO', 'PRO1', '040128', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '840', '200905', 'ENSAMBLAJE, PRUEBA, COMERCIALIZACION Y MANTENIMIENTO DE BICICLETAS Y TRIMOTOS.', 'CA4', '20103732981', 0, 'PRO', 'PRO1', '160101', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '841', '200905', 'FABRICACION Y COMERCIALIZACION DE LADRILLOS DE ARCILLA', 'CA4', '20100132916', 0, 'PRO', 'PRO1', '150106', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '842', '200905', 'Fabrica el chasis y sistema de transmisi�n que conjuntamente con los otros componentes permiten ensamblar los veh�culos de tres ruedas (motocar). ', 'CA4', '20493508645', 0, 'PRO', 'PRO1', '160101', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '843', '200905', 'FABRICACION Y ENSAMBLAJE DE EQUIOS MOVIES DENOMINADOS TRIMOVIL (MOTOCARS), MOTOCICLETAS LINEALES Y SEMI REMOLQUES.', 'CA4', '20515602993', 0, 'PRO', 'PRO1', '150142', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '844', '200905', 'PRODUCCION DE REVESTIMIENTOS,  CERAMICOS,  PISOS Y AZULEJOS.', 'CA4', '20101026001', 0, 'PRO', 'PRO1', '150132', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '845', '200905', 'FABRICACION DE PINTURAS', 'CA4', '20100073723', 0, 'PRO', 'PRO1', '150105', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '846', '200905', 'FABRICACION DE REMOLQUES Y SEMIREMOLQUES DE CISTERNA, BARANDA, PLATAFORMA.', 'CA4', '20486438500', 0, 'PRO', 'PRO1', '120201', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '847', '200905', 'PRODUCCION DE CARBONATO DE CALCIO, BENTONITA, BARITINA, ADITIVO DE CONTROL LIGCO, ADITIVO MIL-PAC, ESTABILIZADOR CLAY-TOL, PROTECTOMAGIC, DETERGENTE MD, TERRA-RATE,E STABILIZADOR NEW DRILL', 'CA4', '20191338856', 0, 'PRO', 'PRO1', '150103', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '848', '200905', 'FABRICACION DE DIVERSOS PRODUCTOS DE ACERODESTINADOS A LA INDUSTRIA DE LA CONSTRUCCION, MINERIA, METALMECANICA, ETC.. AMPLIACION DE CAPACIDAD DE LA NAVE INDUSTRIAL PLANTA N� 1', 'CA1', '20370146994', 0, 'PRO', 'PRO1', '040101', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '849', '200905', 'PROY PLANTA PILOTO DE BISULFURO Y NASH. PARQUE INDUSTRIALOQUENDO DENTRO DE INSTALACIONES DE RENASA. PRODUCCION DE BISULFURO DE CARBONO Y SULFHIDRATO DE SODIO', 'CA1', '20100005566', 0, 'PRO', 'PRO1', '070106', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '850', '200905', 'PROYECTO DE EXPLORACIONES MINERAS EN CONCESION CORIBENI. FABRICACION Y COMERCIALIZACION PRODUCTOS DE ACERO. PROYECTO CORIBENI ', 'CA1', '20370146994', 0, 'PRO', 'PRO1', '080902', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '851', '200905', 'PROY EXPLOTACION DE CONCHUELAS "CONCESIONES DIANA 1 Y DIANA 2". ', 'CA3', '20513229675', 0, 'PRO', 'PRO1', '040305', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '852', '200905', 'EIA "CANTERA DE PUZOLANA" ', 'CA3', '20419387658', 0, 'PRO', 'PRO1', '061309', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '853', '200905', 'TEJIDO DE PUNTO, TE�IDO Y ACABADO DE TELA (TEJEDURIA Y TINTORERIA), PRESTARA SERVICIOS A TERCEROS DE TEJIDO DE HILO DE ALGOD�N, POLIESTER, LYCRA Y TE�IDO. ', 'CA3', '20492938794', 0, 'PRO', 'PRO1', '150119', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (5, '839', '200905', 'PROY AUMENTO DE POTENCIA DE HORNO ELECTRICO DE ARCO DE ACERIA N� DE LA PLANTA N� 02. PANAMERICANA SUR KM 240, PARACAS, PISCO, ICA ACTIVID EMPRESA: PRODUCCION DE ACEROS, OBJETIVO PROY EFICIENCIA, CONFIABILIDAD Y SOSTENIBILIDAD EN EL SISTEMA DE OPERA', 'CA0', '20370146994', 0, 'PRO', 'PRO1', '110505', to_date('31-12-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (3, '151142', '200905', 'Ducto de Transferencia de GLP de Refiner�a La Pampilla S.A. al Terminal de Almacenamiento de Repsol YPF Comercial del Per� S.A.', 'CA3', '20100176450', 0, 'EYM', 'EYM1', '070106', to_date('17-01-2005', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (3, '161587', '200905', 'Proyecto Perforaci�n de Pozos en el Lote V. Piura', 'CA3', '20100153832', 0, 'EYM', 'EYM1', '200705', to_date('27-06-2006', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (3, '173322', '200905', 'Proyecto de Perforaci�n de 20 Pozos de Desarrollo y Construcci�n de Facilidades de Producci�n en los Yacimientos: Carmen Noreste, Huayuri Norte, Huayuri Sur, Shiviyacu Noreste, Dorissa, Jibarito y Capahuari Sur - Lote 1AB', 'CA3', '20504311342', 0, 'EYM', 'EYM1', '160304', to_date('07-11-2007', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (4, '185423', '200905', 'Proyecto de Exploraci�n Chispipaya Modificatoria de la Declaraci�n de Impacto Ambiental', 'CA1', '20433819544', 0, 'EYM', 'EYM2', '230402', to_date('23-01-2009', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (4, '181431', '200905', 'Proyecto de Exploraci�n Vilcoro', 'CA1', '20513417676', 0, 'EYM', 'EYM2', '131001', to_date('21-08-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (4, '181566', '200905', 'Prospecto Cajatambo', 'CA1', '20462014181', 0, 'EYM', 'EYM2', '150301', to_date('27-08-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (4, '182414', '200905', 'Proyecto de Exploraci�n La Gringa', 'CA1', '20251805858', 0, 'EYM', 'EYM2', '130902', to_date('25-09-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (4, '182602', '200905', 'Proyecto de Exploraci�n San Marcos', 'CA1', '20100056802', 0, 'EYM', 'EYM2', '150509', to_date('03-10-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (4, '182858', '200905', 'Proyecto de Exploraci�n Koripata -  Quillapata', 'CA1', '20512962735', 0, 'EYM', 'EYM2', '090113', to_date('10-10-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (4, '175091', '200905', 'Modificaci�n del EIA del Proyecto Cerro Corona - Actualizaci�n de Optimizaci�n', 'CA3', '20507828915', 0, 'EYM', 'EYM2', '060703', to_date('15-01-2008', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (4, '174418', '200905', 'Ampliaci�n de Operacones Minero-Metal�rgicas a 4200 TMSD - Animon', 'CA3', '20100025591', 0, 'EYM', 'EYM2', '190104', to_date('14-12-2007', 'dd-mm-yyyy'));
insert into TPROYECTO (NUMACAE, CODPROY, PERIODO, NOMPROY, TIPOCAT, RUCPROP, TMPVIDA, TSECTOR, TSUBSEC, UBIGEOG, FCHPRES)
values (4, '170416', '200905', 'Reinicio de operaciones de la mina Marcapunta Norte', 'CA3', '20100017572', 0, 'EYM', 'EYM2', '190111', to_date('09-07-2007', 'dd-mm-yyyy'));
prompt 31 records loaded
prompt Enabling triggers for TEXPEDIENTE...
alter table TEXPEDIENTE enable all triggers;
prompt Enabling triggers for TPROPONENTE...
alter table TPROPONENTE enable all triggers;
prompt Enabling triggers for TPROYECTO...
alter table TPROYECTO enable all triggers;
set feedback on
set define on
prompt Done.

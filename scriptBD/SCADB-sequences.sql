---------------------------------------------------
-- Export file for user SCA                      --
-- Created by JORGE on 23/05/2009, 11:40:32 p.m. --
---------------------------------------------------

spool SCADB-sequences.log

prompt
prompt Creating sequence SQ_DOCUMENTO
prompt ==============================
prompt
create sequence SCA.SQ_DOCUMENTO
minvalue 1
maxvalue 999999999999999999999999999
start with 4
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_EXPEDIENTE
prompt ===============================
prompt
create sequence SCA.SQ_EXPEDIENTE
minvalue 1
maxvalue 999999999999999999999999999
start with 4
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_PERSONA
prompt ============================
prompt
create sequence SCA.SQ_PERSONA
minvalue 3
maxvalue 999999999999999999999999999
start with 42
increment by 1
nocache;

prompt
prompt Creating sequence SQ_PROYECTO
prompt =============================
prompt
create sequence SCA.SQ_PROYECTO
minvalue 1
maxvalue 999999999999999999999999999
start with 32
increment by 1
cache 20;


spool off

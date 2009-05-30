-- Create table
create table PERIODO
(
  ANIO      NUMBER(4) not null,
  MES       NUMBER(2) not null,
  PERACTUAL NUMBER(1),
  ESTADO    NUMBER(1)
)
tablespace TBSCA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table PERIODO
  is 'Maestro de periodos';
-- Create/Recreate primary, unique and foreign key constraints 
alter table PERIODO
  add constraint PK_PERIODO primary key (ANIO, MES)
  using index 
  tablespace TBSCA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

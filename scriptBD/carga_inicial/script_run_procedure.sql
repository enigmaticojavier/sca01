-- Created on 28/05/2009 by VAIO 
declare 
  -- Local variables here
  VARIABLE integer;
begin
  -- Test statements here
  usp_001_carga_proponente(
3, '200005', VARIABLE) ;
DBMS_OUTPUT.put_line(VARIABLE);
usp_001_carga_proponente(
4, '200005', VARIABLE) ;
DBMS_OUTPUT.put_line(VARIABLE);
usp_001_carga_proponente(
5, '200005', VARIABLE); 
DBMS_OUTPUT.put_line(VARIABLE);
usp_002_carga_proyecto(
3, '200005', VARIABLE) ;
DBMS_OUTPUT.put_line(VARIABLE);
usp_002_carga_proyecto(
4, '200005', VARIABLE) ;
DBMS_OUTPUT.put_line(VARIABLE);
usp_002_carga_proyecto(
5, '200005', VARIABLE); 
DBMS_OUTPUT.put_line(VARIABLE);
usp_003_carga_expediente(
3, '200005', VARIABLE) ;
DBMS_OUTPUT.put_line(VARIABLE);
usp_003_carga_expediente(
4, '200005', VARIABLE) ;
DBMS_OUTPUT.put_line(VARIABLE);
usp_003_carga_expediente(
3, '200005', VARIABLE);
DBMS_OUTPUT.put_line(VARIABLE);
end;



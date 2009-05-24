create or replace package PQ_PROYECTO is
  TYPE curType IS REF CURSOR;
  PROCEDURE BUSCAR(p_rsProyecto          OUT curType,
                   p_cDescripcion        VARCHAR2,
                   p_cUbigeoId           VARCHAR2,
                   p_cClsTipificacion    VARCHAR2,
                   p_dFchExpedienteDesde DATE,
                   p_dFchExpedienteHasta DATE,
                   p_cEstadoTramite      VARCHAR2,
                   p_cClsSector          VARCHAR2,
                   p_cClsSubSector       VARCHAR2);
  FUNCTION PARAMETRO_BUSCAR(p_cTipParametro VARCHAR2,
                            p_cCodParametro VARCHAR2) RETURN VARCHAR2;
end PQ_PROYECTO;
/
create or replace package body PQ_PROYECTO is

  PROCEDURE BUSCAR(p_rsProyecto          OUT curType,
                   p_cDescripcion        VARCHAR2,
                   p_cUbigeoId           VARCHAR2,
                   p_cClsTipificacion    VARCHAR2,
                   p_dFchExpedienteDesde DATE,
                   p_dFchExpedienteHasta DATE,
                   p_cEstadoTramite      VARCHAR2,
                   p_cClsSector          VARCHAR2,
                   p_cClsSubSector       VARCHAR2) IS
    nDescripcion     NUMBER(1);
    nUbigeoId        NUMBER(1);
    nClsTipificacion NUMBER(1);
    nFchExpediente   NUMBER(1);
    nEstadoTramite   NUMBER(1);
    nClsSector       NUMBER(1);
    nClsSubSector    NUMBER(1);
    cont             integer;
  BEGIN
    IF p_cDescripcion IS NULL THEN
      nDescripcion := 0;
    ELSE
      nDescripcion := 1;
    END IF;
    IF p_cUbigeoId IS NULL THEN
      nUbigeoId := 0;
    ELSE
      nUbigeoId := 1;
    END IF;
    IF p_cClsTipificacion IS NULL THEN
      nClsTipificacion := 0;
    ELSE
      nClsTipificacion := 1;
    END IF;
    IF p_dFchExpedienteDesde IS NULL AND p_dFchExpedienteHasta IS NULL THEN
      nFchExpediente := 0;
    ELSE
      nFchExpediente := 1;
    END IF;
    IF p_cEstadoTramite IS NULL THEN
      nEstadoTramite := 0;
    ELSE
      nEstadoTramite := 1;
    END IF;
    IF p_cClsSector IS NULL THEN
      nClsSector := 0;
    ELSE
      nClsSector := 1;
    END IF;
    IF p_cClsSubSector IS NULL THEN
      nClsSubSector := 0;
    ELSE
      nClsSubSector := 1;
    END IF;
  
    select count(*)
      into cont
      from proyecto
     where fchexpediente between p_dFchExpedienteDesde and
           p_dFchExpedienteHasta;
  
    insert into prueba1
      (campo1, campo2, campo3)
    values
      (p_dFchExpedienteDesde, p_dFchExpedienteHasta, cont);
    -- 1 true
    commit;
  
    open p_rsProyecto for
      select pryid,
             txtdescripcion,
             pr.ubigeoid,
             clstipificacion,
             PARAMETRO_BUSCAR('IGA', clstipificacion) dsctipificacion,
             pr.personaid personaid,
             pe.txtrazonsocial,
             --PARAMETRO_BUSCAR(clstipificacion,),
             TO_CHAR(fchexpediente,'dd/mm/yyyy') fchexpediente
        from proyecto pr, persona pe
       where pr.personaid = pe.personaid(+)
         and (nDescripcion = 0 or
             txtdescripcion like '%' || UPPER(p_cDescripcion) || '%') --'PRJ'
         and (nUbigeoId = 0 or
             substr(pr.ubigeoid, 0, 2) = substr(p_cUbigeoId, 0, 2)) --'150000'
         and (nClsTipificacion = 0 or clstipificacion = p_cClsTipificacion) --'CA2'
         and (nFchExpediente = 0 or
             (fchexpediente between p_dFchExpedienteDesde and
             p_dFchExpedienteHasta))
         and (nEstadoTramite = 0 or p_cEstadoTramite = p_cEstadoTramite)
         and (nClsSector = 0 or clssector = p_cClsSector) --'AGR' 
         and (nClsSubSector = 0 or clssubsector = p_cClsSubSector); --'AGR1';
  END BUSCAR;

  FUNCTION PARAMETRO_BUSCAR(p_cTipParametro VARCHAR2,
                            p_cCodParametro VARCHAR2) RETURN VARCHAR2 IS
    cDscParam PARAMETRO.TXTVALOR%TYPE;
  BEGIN
    BEGIN
      SELECT TXTVALOR
        INTO cDscParam
        FROM PARAMETRO
       WHERE CODPARAMETRO = p_cCodParametro
         AND TIPPARAMETRO = p_cTipParametro;
    EXCEPTION
      WHEN OTHERS THEN
        cDscParam := '';
    END;
    RETURN cDscParam;
  END PARAMETRO_BUSCAR;

END;
/

create or replace package PQ_PROYECTO is
  TYPE curType IS REF CURSOR;
  PROCEDURE BUSCAR(p_rsProyecto          OUT curType,
                   p_cDescripcion        VARCHAR2,
                   p_cUbigeoId           VARCHAR2,
                   p_cClsTipificacion    VARCHAR2,
                   p_dFchExpedienteDesde DATE,
                   p_dFchExpedienteHasta DATE,
                   p_cEstadoTramite      VARCHAR2,
                   p_cTipoAcae           VARCHAR2,
                   p_cClsSector          VARCHAR2,
                   p_cClsSubSector       NUMBER);
  FUNCTION PARAMETRO_BUSCAR(p_cTipParametro VARCHAR2,
                            p_cCodParametro VARCHAR2) RETURN VARCHAR2;
  FUNCTION GETESTADOTRAMITE(p_cPryId VARCHAR2) RETURN VARCHAR2;
  FUNCTION GETESTADOTRAMITETXT(p_cPryId VARCHAR2) RETURN VARCHAR2;
  FUNCTION GETDEPARTAMENTO(p_cUbigeoid VARCHAR2) RETURN VARCHAR2;

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
                   p_cTipoAcae           VARCHAR2,
                   p_cClsSector          VARCHAR2,
                   p_cClsSubSector       NUMBER) IS
    nDescripcion     NUMBER(1);
    nUbigeoId        NUMBER(1);
    nClsTipificacion NUMBER(1);
    nFchExpediente   NUMBER(1);
    nEstadoTramite   NUMBER(1);
    nTipoAcae        NUMBER(1);
    nClsSector       NUMBER(1);
    nClsSubSector    NUMBER(1);
  BEGIN
    IF p_cDescripcion IS NULL THEN
      nDescripcion := 0;
    ELSE
      nDescripcion := 1;
    END IF;
    IF p_cUbigeoId IS NULL OR p_cUbigeoId = '0' THEN
      nUbigeoId := 0;
    ELSE
      nUbigeoId := 1;
    END IF;
    IF p_cClsTipificacion IS NULL OR p_cClsTipificacion = '0' THEN
      nClsTipificacion := 0;
    ELSE
      IF p_cClsTipificacion = '-1' THEN
         nClsTipificacion := -1;
      ELSE
         nClsTipificacion := 1;
      END IF;
    END IF;
    IF p_dFchExpedienteDesde IS NULL AND p_dFchExpedienteHasta IS NULL THEN
      nFchExpediente := 0;
    ELSE
      nFchExpediente := 1;
    END IF;
    IF p_cEstadoTramite IS NULL OR p_cEstadoTramite = '0' THEN
      nEstadoTramite := 0;
    ELSE
      nEstadoTramite := 1;
    END IF;
    IF p_cTipoAcae IS NULL OR p_cTipoAcae = '0' THEN
      nTipoAcae := 0;
    ELSE
      nTipoAcae := 1;
    END IF;
    IF p_cClsSector IS NULL OR p_cClsSector = '0' THEN
      nClsSector := 0;
    ELSE
      nClsSector := 1;
    END IF;
    IF p_cClsSubSector IS NULL OR p_cClsSubSector = 0 THEN
      nClsSubSector := 0;
    ELSE
      nClsSubSector := 1;
    END IF;
    IF nTipoAcae = 1 AND nClsSector = 0 AND nClsSubSector = 0 THEN
      open p_rsProyecto for
        select pryid,
               UPPER(pr.txtdescripcion) AS txtdescripcion,
               u.ubigeoid,
               GETDEPARTAMENTO(u.ubigeoid) DSCUBIGEO,
               clstipificacion,
               PARAMETRO_BUSCAR('IGA', clstipificacion) dsctipificacion,
               pr.personaid personaid,
               pe.txtrazonsocial,
               TO_CHAR(fchexpediente, 'dd/mm/yyyy') fchexpediente,
               GETESTADOTRAMITETXT(pryid) esttram
          from proyecto pr, persona pe, ubigeo u
         where pr.personaid = pe.personaid(+)
           and pr.ubigeoid = u.ubigeoid(+)
           and (nDescripcion = 0 or
               UPPER(pr.txtdescripcion) like '%' || UPPER(p_cDescripcion) || '%') --'PRJ'
           and (nUbigeoId = 0 or
               substr(pr.ubigeoid, 0, 2) = substr(p_cUbigeoId, 0, 2)) --'150000'
           and (nClsTipificacion = 0 or
               clstipificacion = p_cClsTipificacion) --'CA2'
           and (nFchExpediente = 0 or
               (fchexpediente between p_dFchExpedienteDesde and
               p_dFchExpedienteHasta))
           and (nEstadoTramite = 0 or
               GETESTADOTRAMITE(pryid) = p_cEstadoTramite)
           and clssector in
               (select codparametro
                  from parametro ins
                 where ins.tipparametro = p_cTipoAcae);
    ELSE
      IF nClsTipificacion=-1 THEN
         open p_rsProyecto for
          select pryid,
               UPPER(pr.txtdescripcion) AS txtdescripcion,
                 u.ubigeoid,
                 GETDEPARTAMENTO(u.ubigeoid) DSCUBIGEO,
                 clstipificacion,
                 PARAMETRO_BUSCAR('IGA', clstipificacion) dsctipificacion,
                 pr.personaid personaid,
                 pe.txtrazonsocial,
                 TO_CHAR(fchexpediente, 'dd/mm/yyyy') fchexpediente,
                 GETESTADOTRAMITETXT(pryid) esttram
            from proyecto pr, persona pe, ubigeo u
           where pr.personaid = pe.personaid(+)
             and pr.ubigeoid = u.ubigeoid(+)
             and (nDescripcion = 0 or
                 UPPER(pr.txtdescripcion) like '%' || UPPER(p_cDescripcion) || '%') --'PRJ'
             and (nUbigeoId = 0 or
                 substr(pr.ubigeoid, 0, 2) = substr(p_cUbigeoId, 0, 2)) --'150000'
             and clstipificacion NOT IN('CA0','CA1','CA2','CA3')
             and (nFchExpediente = 0 or
                 (fchexpediente between p_dFchExpedienteDesde and
                 p_dFchExpedienteHasta))
             and (nEstadoTramite = 0 or
                 GETESTADOTRAMITE(pryid) = p_cEstadoTramite)
             and (nClsSector = 0 or clssector = p_cClsSector) --'AGR'
             --and (nClsSubSector = 0 or clssubsector = p_cClsSubSector); --'AGR1';
             and (nClsSubSector = 0 or pr.pryid in (
                                                    select proyecto.pryid 
                                                    from expediente, proyecto
                                                    where expediente.pryid = proyecto.pryid
                                                    and expediente.personaid=p_cClsSubSector) 
                                                    );
      ELSE
         open p_rsProyecto for
          select pryid,
               UPPER(pr.txtdescripcion) AS txtdescripcion,
                 u.ubigeoid,
                 GETDEPARTAMENTO(u.ubigeoid) DSCUBIGEO,
                 clstipificacion,
                 PARAMETRO_BUSCAR('IGA', clstipificacion) dsctipificacion,
                 pr.personaid personaid,
                 pe.txtrazonsocial,
                 TO_CHAR(fchexpediente, 'dd/mm/yyyy') fchexpediente,
                 GETESTADOTRAMITETXT(pryid) esttram
            from proyecto pr, persona pe, ubigeo u
           where pr.personaid = pe.personaid(+)
             and pr.ubigeoid = u.ubigeoid(+)
             and (nDescripcion = 0 or
                 UPPER(pr.txtdescripcion) like '%' || UPPER(p_cDescripcion) || '%') --'PRJ'
             and (nUbigeoId = 0 or
                 substr(pr.ubigeoid, 0, 2) = substr(p_cUbigeoId, 0, 2)) --'150000'
             and (nClsTipificacion = 0 or
                 clstipificacion = p_cClsTipificacion) --'CA2'
             and (nFchExpediente = 0 or
                 (fchexpediente between p_dFchExpedienteDesde and
                 p_dFchExpedienteHasta))
             and (nEstadoTramite = 0 or
                 GETESTADOTRAMITE(pryid) = p_cEstadoTramite)
             and (nClsSector = 0 or clssector = p_cClsSector) --'AGR'
             --and (nClsSubSector = 0 or clssubsector = p_cClsSubSector) --'AGR1';
             and (nClsSubSector = 0 or pr.pryid in (
                                      select proyecto.pryid 
                                      from expediente, proyecto
                                      where expediente.pryid = proyecto.pryid
                                      and expediente.personaid=p_cClsSubSector) 
                                      );
      END IF;
    END IF;
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
  FUNCTION GETESTADOTRAMITE(p_cPryId VARCHAR2) RETURN VARCHAR2 IS
    c_TipEstTram estadostupa.tipestadotramite%TYPE;
  BEGIN
    BEGIN
      select et.tipestadotramite
        into c_TipEstTram
        from expediente e, expedientepaso ep, estadostupa et
       where e.expid = ep.expid
         and e.tiptramite = et.tiptramite
         and ep.tippaso = et.tippaso
         and (ep.expid, ep.nsecuencia) in
             (select ep.expid, max(ep.nsecuencia)
                from expedientepaso ep, expediente e
               where ep.expid = e.expid
                 and e.pryid = p_cPryId
               group by e.tiptramite, ep.expid);
    EXCEPTION
      WHEN OTHERS THEN
        c_TipEstTram := '';
    END;
    RETURN c_TipEstTram;
  END;
  FUNCTION GETESTADOTRAMITETXT(p_cPryId VARCHAR2) RETURN VARCHAR2 IS
    c_TipEstTram parametro.txtvalor%TYPE;
  BEGIN
    BEGIN
      select par.txtvalor
        into c_TipEstTram
        from expediente e, expedientepaso ep, estadostupa et, parametro par
       where e.expid = ep.expid
         and e.tiptramite = et.tiptramite
         and ep.tippaso = et.tippaso
         and et.tipestadotramite=par.codparametro
         and par.tipparametro='EST'
         and (ep.expid, ep.nsecuencia) in
             (select ep.expid, max(ep.nsecuencia)
                from expedientepaso ep, expediente e
               where ep.expid = e.expid
                 and e.pryid = p_cPryId
               group by e.tiptramite, ep.expid);
    EXCEPTION
      WHEN OTHERS THEN
        c_TipEstTram := '';
    END;
    RETURN c_TipEstTram;
  END;
  FUNCTION GETDEPARTAMENTO(p_cUbigeoid VARCHAR2) RETURN VARCHAR2 IS
    c_TxtDescripcion ubigeo.txtdescripcion%TYPE;
  BEGIN
    BEGIN
      select u.txtdescripcion
        into c_TxtDescripcion
        from ubigeo u
        where u.ubigeoid=substr(p_cUbigeoid,0,2)||'0000';
    EXCEPTION
      WHEN OTHERS THEN
        c_TxtDescripcion:= '';
    END;
    RETURN c_TxtDescripcion;
  END;
END;
/

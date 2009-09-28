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
  PROCEDURE RANKING(p_rsProyecto       OUT curType,
                    p_cClsTipificacion VARCHAR2,
                    p_cEstadoTramite   VARCHAR2,
                    p_cTipoPersoneria  VARCHAR2,
                    p_cProponente      VARCHAR2,
                    p_cTipoAcae        VARCHAR2,
                    p_cClsSector       VARCHAR2,
                    p_cClsSubSector    NUMBER,
                    p_cCodDepartamento VARCHAR2,
                    p_cCodProvincia    VARCHAR2,
                    p_cCodDistrito     VARCHAR2,
                    p_cAnoPresentacion VARCHAR2,
                    p_cTipDocTramite   VARCHAR2,
                    p_nOrdenRanking    NUMBER);
  PROCEDURE RANKING_DETALLE(p_rsProyecto       OUT curType,
                            p_cClsTipificacion VARCHAR2, -- categoria proyecto
                            p_cEstadoTramite   VARCHAR2,
                            p_cTipoPersoneria  VARCHAR2,
                            p_cProponente      VARCHAR2,
                            p_cTipoAcae        VARCHAR2,
                            p_cClsSector       VARCHAR2,
                            p_cClsSubSector    NUMBER,
                            p_cCodDepartamento VARCHAR2,
                            p_cCodProvincia    VARCHAR2,
                            p_cCodDistrito     VARCHAR2,
                            p_cAnoPresentacion VARCHAR2,
                            p_cTipDocTramite   VARCHAR2,
                            p_nOrdenRanking    NUMBER,
                            p_cIdAgrupacion    VARCHAR2);
  FUNCTION PARAMETRO_BUSCAR(p_cTipParametro VARCHAR2,
                            p_cCodParametro VARCHAR2) RETURN VARCHAR2;
  FUNCTION GETESTADOTRAMITE(p_cPryId VARCHAR2) RETURN VARCHAR2;
  FUNCTION GETESTADOTRAMITETXT(p_cPryId VARCHAR2) RETURN VARCHAR2;
  FUNCTION GETDEPARTAMENTO(p_cUbigeoid VARCHAR2) RETURN VARCHAR2;
  FUNCTION GETDEPENDENCIA(p_cProyectoId NUMBER) RETURN VARCHAR2;
  FUNCTION GETTXTDEPENDENCIA(p_cProyectoId NUMBER) RETURN VARCHAR2;
  FUNCTION GETTIPOACAE(p_cCodParametro VARCHAR2) RETURN VARCHAR2;

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
               GETESTADOTRAMITETXT(pryid) esttram,
               pr.clssector,
               p1.txtvalor tipoacae,
               PARAMETRO_BUSCAR(p1.codparametro, pr.clssector) institucion,
               PARAMETRO_BUSCAR('ACT', substr(pr.codproyecto, 0, 3)) actividad
          from persona pe, ubigeo u, proyecto pr
         inner join parametro p1 on p1.tipparametro = 'TAC'
                                and p1.codparametro = p_cTipoAcae --TIPO ACAE SELECIONADA
         inner join parametro p2 on p1.codparametro = p2.tipparametro
                                and p2.codparametro = pr.clssector
         where pr.personaid = pe.personaid
           and pr.ubigeoid = u.ubigeoid
           and (nDescripcion = 0 or UPPER(pr.txtdescripcion) like
               '%' || UPPER(p_cDescripcion) || '%') --'PRJ'
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
      IF nClsTipificacion = -1 THEN
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
                 GETESTADOTRAMITETXT(pryid) esttram,
                 pr.clssector,
                 p1.txtvalor tipoacae,
                 PARAMETRO_BUSCAR(p1.codparametro, pr.clssector) institucion,
                 PARAMETRO_BUSCAR('ACT', substr(pr.codproyecto, 0, 3)) actividad
            from persona pe, ubigeo u, proyecto pr
           inner join parametro p1 on p1.tipparametro = 'TAC'
                                  and p1.codparametro = p_cTipoAcae --TIPO ACAE SELECIONADA
           inner join parametro p2 on p1.codparametro = p2.tipparametro
                                  and p2.codparametro = pr.clssector
           where pr.personaid = pe.personaid
             and pr.ubigeoid = u.ubigeoid
             and (nDescripcion = 0 or UPPER(pr.txtdescripcion) like
                 '%' || UPPER(p_cDescripcion) || '%') --'PRJ'
             and (nUbigeoId = 0 or
                 substr(pr.ubigeoid, 0, 2) = substr(p_cUbigeoId, 0, 2)) --'150000'
             and clstipificacion NOT IN ('CA0', 'CA1', 'CA2', 'CA3')
             and (nFchExpediente = 0 or
                 (fchexpediente between p_dFchExpedienteDesde and
                 p_dFchExpedienteHasta))
             and (nEstadoTramite = 0 or
                 GETESTADOTRAMITE(pryid) = p_cEstadoTramite)
             and (nClsSector = 0 or clssector = p_cClsSector) --'AGR'
                --and (nClsSubSector = 0 or clssubsector = p_cClsSubSector); --'AGR1';
             and (nClsSubSector = 0 or
                 pr.pryid in
                 (select proyecto.pryid
                     from expediente, proyecto
                    where expediente.pryid = proyecto.pryid
                      and expediente.personaid = p_cClsSubSector));
      ELSE
        open p_rsProyecto for
        
          select p1.codparametro,
                 pryid,
                 UPPER(pr.txtdescripcion) AS txtdescripcion,
                 u.ubigeoid,
                 GETDEPARTAMENTO(u.ubigeoid) DSCUBIGEO,
                 clstipificacion,
                 PARAMETRO_BUSCAR('IGA', clstipificacion) dsctipificacion,
                 pr.personaid personaid,
                 pe.txtrazonsocial,
                 TO_CHAR(fchexpediente, 'dd/mm/yyyy') fchexpediente,
                 GETESTADOTRAMITETXT(pryid) esttram,
                 pr.clssector,
                 p1.txtvalor tipoacae,
                 PARAMETRO_BUSCAR(p1.codparametro, pr.clssector) institucion,
                 PARAMETRO_BUSCAR('ACT', substr(pr.codproyecto, 0, 3)) actividad
            from persona pe, ubigeo u, proyecto pr
           inner join parametro p1 on p1.tipparametro = 'TAC'
           inner join parametro p2 on p1.codparametro = p2.tipparametro
                                  and p2.codparametro = pr.clssector
           where pr.personaid = pe.personaid
             and pr.ubigeoid = u.ubigeoid
             and (nDescripcion = 0 or UPPER(pr.txtdescripcion) like
                 '%' || UPPER(p_cDescripcion) || '%') --'PRJ'
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
             and (nClsSubSector = 0 or
                 pr.pryid in
                 (select proyecto.pryid
                     from expediente, proyecto
                    where expediente.pryid = proyecto.pryid
                      and expediente.personaid = p_cClsSubSector));
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
         and et.tipestadotramite = par.codparametro
         and par.tipparametro = 'EST'
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
       where u.ubigeoid = substr(p_cUbigeoid, 0, 2) || '0000';
    EXCEPTION
      WHEN OTHERS THEN
        c_TxtDescripcion := '';
    END;
    RETURN c_TxtDescripcion;
  END;

  FUNCTION GETTXTDEPENDENCIA(p_cProyectoId NUMBER) RETURN VARCHAR2 IS
    cTxtRazonSocial PERSONA.TXTRAZONSOCIAL%TYPE;
  BEGIN
    BEGIN
      SELECT PERSONA.TXTRAZONSOCIAL
        INTO cTxtRazonSocial
        from expediente, proyecto, PERSONA
       where expediente.pryid = proyecto.pryid
         AND expediente.personaid = PERSONA.PERSONAID
         and proyecto.pryid = p_cProyectoId;
    EXCEPTION
      WHEN OTHERS THEN
        cTxtRazonSocial := '';
    END;
    RETURN cTxtRazonSocial;
  END;

  FUNCTION GETDEPENDENCIA(p_cProyectoId NUMBER) RETURN VARCHAR2 IS
    c_PersonaId PERSONA.PERSONAID%TYPE;
  BEGIN
    BEGIN
      /*
      SELECT PERSONA.TXTRAZONSOCIAL
        INTO c_TxtRazonSocial
        FROM ACAE, PERSONA
       WHERE ACAE.PERSONAID = PERSONA.PERSONAID
         AND TIPACAE = p_cTipoAcae
         AND CLSSECTOR = p_cClsSector
         AND PERSONA.PERSONAID = p_nPersonaid;
      */
      select expediente.personaid
        into c_PersonaId
        from expediente, proyecto
       where expediente.pryid = proyecto.pryid
         and proyecto.pryid = p_cProyectoId;
    EXCEPTION
      WHEN OTHERS THEN
        c_PersonaId := '';
    END;
    RETURN c_PersonaId;
  END;

  FUNCTION GETTIPOACAE(p_cCodParametro VARCHAR2) RETURN VARCHAR2 IS
    c_TipParametro PARAMETRO.TIPPARAMETRO%TYPE;
  BEGIN
    BEGIN
      SELECT TIPPARAMETRO
        INTO c_TipParametro
        FROM PARAMETRO
       WHERE CODPARAMETRO = p_cCodParametro
         AND TIPPARAMETRO IN
             (SELECT CODPARAMETRO FROM PARAMETRO WHERE TIPPARAMETRO = 'TAC');
    EXCEPTION
      WHEN OTHERS THEN
        c_TipParametro := '';
    END;
    RETURN c_TipParametro;
  END;

  PROCEDURE RANKING(p_rsProyecto       OUT curType,
                    p_cClsTipificacion VARCHAR2, -- categoria proyecto
                    p_cEstadoTramite   VARCHAR2,
                    p_cTipoPersoneria  VARCHAR2,
                    p_cProponente      VARCHAR2,
                    p_cTipoAcae        VARCHAR2,
                    p_cClsSector       VARCHAR2,
                    p_cClsSubSector    NUMBER,
                    p_cCodDepartamento VARCHAR2,
                    p_cCodProvincia    VARCHAR2,
                    p_cCodDistrito     VARCHAR2,
                    p_cAnoPresentacion VARCHAR2,
                    p_cTipDocTramite   VARCHAR2,
                    p_nOrdenRanking    NUMBER) IS
    nClsTipificacion NUMBER(1);
    nEstadoTramite   NUMBER(1);
    nTipoPersoneria  NUMBER(1);
    nProponente      NUMBER(1);
    nTipoAcae        NUMBER(1);
    nClsSector       NUMBER(1);
    nClsSubSector    NUMBER(1);
    nCodDepartamento NUMBER(1);
    nCodProvincia    NUMBER(1);
    nCodDistrito     NUMBER(1);
    nAnoPresentacion NUMBER(1);
    nTipDocTramite   NUMBER(1);
    cUbigeo          VARCHAR2(6);
    nUbigeo          NUMBER(1);
    /*
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
    */
  BEGIN
    IF p_cClsTipificacion IS NULL OR p_cClsTipificacion = '0' THEN
      nClsTipificacion := 0;
    ELSE
      IF p_cClsTipificacion = '-1' THEN
        nClsTipificacion := -1;
      ELSE
        nClsTipificacion := 1;
      END IF;
    END IF;
    IF p_cEstadoTramite IS NULL OR p_cEstadoTramite = '0' THEN
      nEstadoTramite := 0;
    ELSE
      nEstadoTramite := 1;
    END IF;
    /* nTipoPersoneria 0 TODO 1 PJ 2 PN */
    IF p_cTipoPersoneria IS NULL OR p_cTipoPersoneria = '0' THEN
      nTipoPersoneria := 0;
    ELSIF p_cTipoPersoneria = 'PJ' THEN
      nTipoPersoneria := 1;
    ELSIF p_cTipoPersoneria = 'PN' THEN
      nTipoPersoneria := 2;
    END IF;
    IF p_cProponente IS NULL OR p_cProponente = '0' THEN
      nProponente := 0;
    ELSE
      nProponente := 1;
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
    IF p_cCodDepartamento IS NULL OR p_cCodDepartamento = 0 THEN
      nCodDepartamento := 0;
    ELSE
      nCodDepartamento := 1;
    END IF;
    IF p_cCodProvincia IS NULL OR p_cCodProvincia = 0 THEN
      nCodProvincia := 0;
    ELSE
      nCodProvincia := 1;
    END IF;
    IF p_cCodDistrito IS NULL OR p_cCodDistrito = 0 THEN
      nCodDistrito := 0;
    ELSE
      nCodDistrito := 1;
    END IF;
    IF nCodDepartamento = 1 AND nCodProvincia = 1 AND nCodDistrito = 1 THEN
      cUbigeo := p_cCodDepartamento || p_cCodProvincia || p_cCodDistrito;
      nUbigeo := 6;
    ELSIF nCodDepartamento = 1 AND nCodProvincia = 1 AND nCodDistrito = 0 THEN
      cUbigeo := p_cCodDepartamento || p_cCodProvincia;
      nUbigeo := 4;
    ELSIF nCodDepartamento = 1 AND nCodProvincia = 0 AND nCodDistrito = 0 THEN
      cUbigeo := p_cCodDepartamento;
      nUbigeo := 2;
    ELSE
      nUbigeo := 0;
    END IF;
    IF p_cAnoPresentacion IS NULL OR p_cAnoPresentacion = 0 THEN
      nAnoPresentacion := 0;
    ELSE
      nAnoPresentacion := 1;
    END IF;
    IF p_cTipDocTramite IS NULL OR p_cTipDocTramite = '0' THEN
      nTipDocTramite := 0;
    ELSE
      nTipDocTramite := 1;
    END IF;
  
    /*SI SELECCIONA SOLO TIPO ACAE FILTRAR SOLO INSTITUCIONES DEL TIPO DE ACAE */
    --IF (nTipoAcae = 1 AND nClsSector = 0 AND nClsSubSector = 0) AND (nTipoPersoneria=1 AND   THEN
    IF (nTipoAcae = 1 AND nClsSector = 0 AND nClsSubSector = 0) THEN
      -- PJ
      IF nTipoPersoneria = 1 AND nProponente = 0 THEN
        open p_rsProyecto for
        
          select --pr.personaid, 
          --pe.txtrazonsocial, 
           decode(p_nOrdenRanking,
                  1,
                  clstipificacion,
                  decode(p_nOrdenRanking,
                         2,
                         GETESTADOTRAMITETXT(pryid),
                         decode(p_nOrdenRanking,
                                3,
                                '' || pr.personaid,
                                decode(p_nOrdenRanking,
                                       4,
                                       GETTIPOACAE(pr.clssector),
                                       decode(p_nOrdenRanking,
                                              5,
                                              pr.clssector,
                                              decode(p_nOrdenRanking,
                                                     6,
                                                     GETDEPENDENCIA(pr.pryid),
                                                     '')))))) ID,
           decode(p_nOrdenRanking,
                  1,
                  PARAMETRO_BUSCAR('IGA', clstipificacion),
                  decode(p_nOrdenRanking,
                         2,
                         GETESTADOTRAMITETXT(pryid),
                         decode(p_nOrdenRanking,
                                3,
                                pe.txtrazonsocial,
                                decode(p_nOrdenRanking,
                                       4,
                                       PARAMETRO_BUSCAR('TAC',
                                                        GETTIPOACAE(pr.clssector)),
                                       decode(p_nOrdenRanking,
                                              5,
                                              PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                               pr.clssector),
                                              decode(p_nOrdenRanking,
                                                     6,
                                                     GETTXTDEPENDENCIA(pr.pryid),
                                                     '')))))) TXT,
           count(*) cnt
            from proyecto pr, persona pe, ubigeo u
           where pr.personaid = pe.personaid(+)
             and pr.ubigeoid = u.ubigeoid(+)
             and ((nClsTipificacion = '-1' and
                 clstipificacion NOT IN ('CA0', 'CA1', 'CA2', 'CA3')) or
                 (nClsTipificacion = 0) or
                 (nClsTipificacion = 1 and
                 clstipificacion = p_cClsTipificacion))
             and (nEstadoTramite = 0 or
                 GETESTADOTRAMITE(pryid) = p_cEstadoTramite)
             and pr.personaid in
                 (select personaid
                    from persona
                   where tippersona = 'PRO'
                     and tipdocumentoper = 'RUC')
             and clssector in
                 (select ins.codparametro
                    from parametro ins
                   where ins.tipparametro in
                         (select codparametro
                            from parametro tac
                           where tac.tipparametro = 'TAC')
                     and ins.tipparametro = p_cTipoAcae)
             and (nUbigeo = 0 or substr(pr.ubigeoid, 0, nUbigeo) = cUbigeo)
             and (nAnoPresentacion = 0 or
                 to_char(fchexpediente, 'YYYY') = p_cAnoPresentacion)
             and (nTipDocTramite = 0 or
                 pryid in
                 (select distinct expediente.pryid
                     from expediente, expedientedocumento, documento
                    where expediente.expid = expedientedocumento.expid
                      and expedientedocumento.docid = documento.docid
                      and documento.tipodocumento = p_cTipDocTramite))
          --group by pr.personaid, pe.txtrazonsocial;
           group by decode(p_nOrdenRanking,
                           1,
                           clstipificacion,
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         '' || pr.personaid,
                                         decode(p_nOrdenRanking,
                                                4,
                                                GETTIPOACAE(pr.clssector),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       pr.clssector,
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETDEPENDENCIA(PR.PRYID),
                                                              '')))))),
                    decode(p_nOrdenRanking,
                           1,
                           PARAMETRO_BUSCAR('IGA', clstipificacion),
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         pe.txtrazonsocial,
                                         decode(p_nOrdenRanking,
                                                4,
                                                PARAMETRO_BUSCAR('TAC',
                                                                 GETTIPOACAE(pr.clssector)),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                                        pr.clssector),
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETTXTDEPENDENCIA(PR.PRYID),
                                                              ''))))));
        -- PN
      ELSIF nTipoPersoneria = 2 AND nProponente = 0 THEN
        open p_rsProyecto for
          select decode(p_nOrdenRanking,
                        1,
                        clstipificacion,
                        decode(p_nOrdenRanking,
                               2,
                               GETESTADOTRAMITETXT(pryid),
                               decode(p_nOrdenRanking,
                                      3,
                                      '' || pr.personaid,
                                      decode(p_nOrdenRanking,
                                             4,
                                             GETTIPOACAE(pr.clssector),
                                             decode(p_nOrdenRanking,
                                                    5,
                                                    pr.clssector,
                                                    decode(p_nOrdenRanking,
                                                           6,
                                                           GETDEPENDENCIA(pr.pryid),
                                                           '')))))) ID,
                 decode(p_nOrdenRanking,
                        1,
                        PARAMETRO_BUSCAR('IGA', clstipificacion),
                        decode(p_nOrdenRanking,
                               2,
                               GETESTADOTRAMITETXT(pryid),
                               decode(p_nOrdenRanking,
                                      3,
                                      pe.txtrazonsocial,
                                      decode(p_nOrdenRanking,
                                             4,
                                             PARAMETRO_BUSCAR('TAC',
                                                              GETTIPOACAE(pr.clssector)),
                                             decode(p_nOrdenRanking,
                                                    5,
                                                    PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                                     pr.clssector),
                                                    decode(p_nOrdenRanking,
                                                           6,
                                                           GETTXTDEPENDENCIA(pr.pryid),
                                                           '')))))) TXT,
                 count(*) cnt
            from proyecto pr, persona pe, ubigeo u
           where pr.personaid = pe.personaid(+)
             and pr.ubigeoid = u.ubigeoid(+)
             and ((nClsTipificacion = '-1' and
                 clstipificacion NOT IN ('CA0', 'CA1', 'CA2', 'CA3')) or
                 (nClsTipificacion = 0) or
                 (nClsTipificacion = 1 and
                 clstipificacion = p_cClsTipificacion))
             and (nEstadoTramite = 0 or
                 GETESTADOTRAMITE(pryid) = p_cEstadoTramite)
             and pr.personaid in
                 (select personaid
                    from persona
                   where tippersona = 'PRO'
                     and tipdocumentoper <> 'RUC')
             and clssector in
                 (select ins.codparametro
                    from parametro ins
                   where ins.tipparametro in
                         (select codparametro
                            from parametro tac
                           where tac.tipparametro = 'TAC')
                     and ins.tipparametro = p_cTipoAcae)
             and (nUbigeo = 0 or substr(pr.ubigeoid, 0, nUbigeo) = cUbigeo)
             and (nAnoPresentacion = 0 or
                 to_char(fchexpediente, 'YYYY') = p_cAnoPresentacion)
             and (nTipDocTramite = 0 or
                 pryid in
                 (select distinct expediente.pryid
                     from expediente, expedientedocumento, documento
                    where expediente.expid = expedientedocumento.expid
                      and expedientedocumento.docid = documento.docid
                      and documento.tipodocumento = p_cTipDocTramite))
           group by decode(p_nOrdenRanking,
                           1,
                           clstipificacion,
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         '' || pr.personaid,
                                         decode(p_nOrdenRanking,
                                                4,
                                                GETTIPOACAE(pr.clssector),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       pr.clssector,
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETDEPENDENCIA(pr.pryid),
                                                              '')))))),
                    decode(p_nOrdenRanking,
                           1,
                           PARAMETRO_BUSCAR('IGA', clstipificacion),
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         pe.txtrazonsocial,
                                         decode(p_nOrdenRanking,
                                                4,
                                                PARAMETRO_BUSCAR('TAC',
                                                                 GETTIPOACAE(pr.clssector)),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                                        pr.clssector),
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETTXTDEPENDENCIA(pr.pryid),
                                                              ''))))));
        -- TODOS
      ELSIF nTipoPersoneria = 0 AND nProponente = 0 THEN
        open p_rsProyecto for
          select decode(p_nOrdenRanking,
                        1,
                        clstipificacion,
                        decode(p_nOrdenRanking,
                               2,
                               GETESTADOTRAMITETXT(pryid),
                               decode(p_nOrdenRanking,
                                      3,
                                      '' || pr.personaid,
                                      decode(p_nOrdenRanking,
                                             4,
                                             GETTIPOACAE(pr.clssector),
                                             decode(p_nOrdenRanking,
                                                    5,
                                                    pr.clssector,
                                                    decode(p_nOrdenRanking,
                                                           6,
                                                           GETDEPENDENCIA(pr.pryid),
                                                           '')))))) ID,
                 decode(p_nOrdenRanking,
                        1,
                        PARAMETRO_BUSCAR('IGA', clstipificacion),
                        decode(p_nOrdenRanking,
                               2,
                               GETESTADOTRAMITETXT(pryid),
                               decode(p_nOrdenRanking,
                                      3,
                                      pe.txtrazonsocial,
                                      decode(p_nOrdenRanking,
                                             4,
                                             PARAMETRO_BUSCAR('TAC',
                                                              GETTIPOACAE(pr.clssector)),
                                             decode(p_nOrdenRanking,
                                                    5,
                                                    PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                                     pr.clssector),
                                                    decode(p_nOrdenRanking,
                                                           6,
                                                           GETTXTDEPENDENCIA(pr.pryid),
                                                           '')))))) TXT,
                 count(*) cnt
            from proyecto pr, persona pe, ubigeo u
           where pr.personaid = pe.personaid(+)
             and pr.ubigeoid = u.ubigeoid(+)
             and ((nClsTipificacion = '-1' and
                 clstipificacion NOT IN ('CA0', 'CA1', 'CA2', 'CA3')) or
                 (nClsTipificacion = 0) or
                 (nClsTipificacion = 1 and
                 clstipificacion = p_cClsTipificacion))
             and (nEstadoTramite = 0 or
                 GETESTADOTRAMITE(pryid) = p_cEstadoTramite)
             and clssector in
                 (select ins.codparametro
                    from parametro ins
                   where ins.tipparametro in
                         (select codparametro
                            from parametro tac
                           where tac.tipparametro = 'TAC')
                     and ins.tipparametro = p_cTipoAcae)
             and (nUbigeo = 0 or substr(pr.ubigeoid, 0, nUbigeo) = cUbigeo)
             and (nAnoPresentacion = 0 or
                 to_char(fchexpediente, 'YYYY') = p_cAnoPresentacion)
             and (nTipDocTramite = 0 or
                 pryid in
                 (select distinct expediente.pryid
                     from expediente, expedientedocumento, documento
                    where expediente.expid = expedientedocumento.expid
                      and expedientedocumento.docid = documento.docid
                      and documento.tipodocumento = p_cTipDocTramite))
           group by decode(p_nOrdenRanking,
                           1,
                           clstipificacion,
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         '' || pr.personaid,
                                         decode(p_nOrdenRanking,
                                                4,
                                                GETTIPOACAE(pr.clssector),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       pr.clssector,
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETDEPENDENCIA(pr.pryid),
                                                              '')))))),
                    decode(p_nOrdenRanking,
                           1,
                           PARAMETRO_BUSCAR('IGA', clstipificacion),
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         pe.txtrazonsocial,
                                         decode(p_nOrdenRanking,
                                                4,
                                                PARAMETRO_BUSCAR('TAC',
                                                                 GETTIPOACAE(pr.clssector)),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                                        pr.clssector),
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETTXTDEPENDENCIA(pr.pryid),
                                                              ''))))));
        -- PROPONENTE ESPECIFICO
      ELSIF nProponente = 1 THEN
        open p_rsProyecto for
          select decode(p_nOrdenRanking,
                        1,
                        clstipificacion,
                        decode(p_nOrdenRanking,
                               2,
                               GETESTADOTRAMITETXT(pryid),
                               decode(p_nOrdenRanking,
                                      3,
                                      '' || pr.personaid,
                                      decode(p_nOrdenRanking,
                                             4,
                                             GETTIPOACAE(pr.clssector),
                                             decode(p_nOrdenRanking,
                                                    5,
                                                    pr.clssector,
                                                    decode(p_nOrdenRanking,
                                                           6,
                                                           GETDEPENDENCIA(pr.pryid),
                                                           '')))))) ID,
                 decode(p_nOrdenRanking,
                        1,
                        PARAMETRO_BUSCAR('IGA', clstipificacion),
                        decode(p_nOrdenRanking,
                               2,
                               GETESTADOTRAMITETXT(pryid),
                               decode(p_nOrdenRanking,
                                      3,
                                      pe.txtrazonsocial,
                                      decode(p_nOrdenRanking,
                                             4,
                                             PARAMETRO_BUSCAR('TAC',
                                                              GETTIPOACAE(pr.clssector)),
                                             decode(p_nOrdenRanking,
                                                    5,
                                                    PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                                     pr.clssector),
                                                    decode(p_nOrdenRanking,
                                                           6,
                                                           GETTXTDEPENDENCIA(pr.pryid),
                                                           '')))))) TXT,
                 count(*) cnt
            from proyecto pr, persona pe, ubigeo u
           where pr.personaid = pe.personaid(+)
             and pr.ubigeoid = u.ubigeoid(+)
             and ((nClsTipificacion = '-1' and
                 clstipificacion NOT IN ('CA0', 'CA1', 'CA2', 'CA3')) or
                 (nClsTipificacion = 0) or
                 (nClsTipificacion = 1 and
                 clstipificacion = p_cClsTipificacion))
             and (nEstadoTramite = 0 or
                 GETESTADOTRAMITE(pryid) = p_cEstadoTramite)
             and pr.personaid = p_cProponente
             and clssector in
                 (select ins.codparametro
                    from parametro ins
                   where ins.tipparametro in
                         (select codparametro
                            from parametro tac
                           where tac.tipparametro = 'TAC')
                     and ins.tipparametro = p_cTipoAcae)
             and (nUbigeo = 0 or substr(pr.ubigeoid, 0, nUbigeo) = cUbigeo)
             and (nAnoPresentacion = 0 or
                 to_char(fchexpediente, 'YYYY') = p_cAnoPresentacion)
             and (nTipDocTramite = 0 or
                 pryid in
                 (select distinct expediente.pryid
                     from expediente, expedientedocumento, documento
                    where expediente.expid = expedientedocumento.expid
                      and expedientedocumento.docid = documento.docid
                      and documento.tipodocumento = p_cTipDocTramite))
           group by decode(p_nOrdenRanking,
                           1,
                           clstipificacion,
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         '' || pr.personaid,
                                         decode(p_nOrdenRanking,
                                                4,
                                                GETTIPOACAE(pr.clssector),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       pr.clssector,
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETDEPENDENCIA(pr.pryid),
                                                              '')))))),
                    decode(p_nOrdenRanking,
                           1,
                           PARAMETRO_BUSCAR('IGA', clstipificacion),
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         pe.txtrazonsocial,
                                         decode(p_nOrdenRanking,
                                                4,
                                                PARAMETRO_BUSCAR('TAC',
                                                                 GETTIPOACAE(pr.clssector)),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                                        pr.clssector),
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETTXTDEPENDENCIA(pr.pryid),
                                                              ''))))));
      END IF;
    ELSE
      IF nTipoPersoneria = 1 AND nProponente = 0 THEN
        open p_rsProyecto for
          select decode(p_nOrdenRanking,
                        1,
                        clstipificacion,
                        decode(p_nOrdenRanking,
                               2,
                               GETESTADOTRAMITETXT(pryid),
                               decode(p_nOrdenRanking,
                                      3,
                                      '' || pr.personaid,
                                      decode(p_nOrdenRanking,
                                             4,
                                             GETTIPOACAE(pr.clssector),
                                             decode(p_nOrdenRanking,
                                                    5,
                                                    pr.clssector,
                                                    decode(p_nOrdenRanking,
                                                           6,
                                                           GETDEPENDENCIA(pr.pryid),
                                                           '')))))) ID,
                 decode(p_nOrdenRanking,
                        1,
                        PARAMETRO_BUSCAR('IGA', clstipificacion),
                        decode(p_nOrdenRanking,
                               2,
                               GETESTADOTRAMITETXT(pryid),
                               decode(p_nOrdenRanking,
                                      3,
                                      pe.txtrazonsocial,
                                      decode(p_nOrdenRanking,
                                             4,
                                             PARAMETRO_BUSCAR('TAC',
                                                              GETTIPOACAE(pr.clssector)),
                                             decode(p_nOrdenRanking,
                                                    5,
                                                    PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                                     pr.clssector),
                                                    decode(p_nOrdenRanking,
                                                           6,
                                                           GETTXTDEPENDENCIA(pr.pryid),
                                                           '')))))) TXT,
                 count(*) cnt
            from proyecto pr, persona pe, ubigeo u
           where pr.personaid = pe.personaid(+)
             and pr.ubigeoid = u.ubigeoid(+)
             and ((nClsTipificacion = '-1' and
                 clstipificacion NOT IN ('CA0', 'CA1', 'CA2', 'CA3')) or
                 (nClsTipificacion = 0) or
                 (nClsTipificacion = 1 and
                 clstipificacion = p_cClsTipificacion))
             and (nEstadoTramite = 0 or
                 GETESTADOTRAMITE(pryid) = p_cEstadoTramite)
             and pr.personaid in
                 (select personaid
                    from persona
                   where tippersona = 'PRO'
                     and tipdocumentoper = 'RUC')
             and (nClsSector = 0 or clssector = p_cClsSector)
             and (nClsSubSector = 0 or
                 pr.pryid in
                 (select proyecto.pryid
                     from expediente, proyecto
                    where expediente.pryid = proyecto.pryid
                      and expediente.personaid = p_cClsSubSector))
             and (nUbigeo = 0 or substr(pr.ubigeoid, 0, nUbigeo) = cUbigeo)
             and (nAnoPresentacion = 0 or
                 to_char(fchexpediente, 'YYYY') = p_cAnoPresentacion)
             and (nTipDocTramite = 0 or
                 pryid in
                 (select distinct expediente.pryid
                     from expediente, expedientedocumento, documento
                    where expediente.expid = expedientedocumento.expid
                      and expedientedocumento.docid = documento.docid
                      and documento.tipodocumento = p_cTipDocTramite))
           group by decode(p_nOrdenRanking,
                           1,
                           clstipificacion,
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         '' || pr.personaid,
                                         decode(p_nOrdenRanking,
                                                4,
                                                GETTIPOACAE(pr.clssector),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       pr.clssector,
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETDEPENDENCIA(pr.pryid),
                                                              '')))))),
                    decode(p_nOrdenRanking,
                           1,
                           PARAMETRO_BUSCAR('IGA', clstipificacion),
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         pe.txtrazonsocial,
                                         decode(p_nOrdenRanking,
                                                4,
                                                PARAMETRO_BUSCAR('TAC',
                                                                 GETTIPOACAE(pr.clssector)),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                                        pr.clssector),
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETTXTDEPENDENCIA(pr.pryid),
                                                              ''))))));
      ELSIF nTipoPersoneria = 2 AND nProponente = 0 THEN
        open p_rsProyecto for
          select decode(p_nOrdenRanking,
                        1,
                        clstipificacion,
                        decode(p_nOrdenRanking,
                               2,
                               GETESTADOTRAMITETXT(pryid),
                               decode(p_nOrdenRanking,
                                      3,
                                      '' || pr.personaid,
                                      decode(p_nOrdenRanking,
                                             4,
                                             GETTIPOACAE(pr.clssector),
                                             decode(p_nOrdenRanking,
                                                    5,
                                                    pr.clssector,
                                                    decode(p_nOrdenRanking,
                                                           6,
                                                           GETDEPENDENCIA(pr.pryid),
                                                           '')))))) ID,
                 decode(p_nOrdenRanking,
                        1,
                        PARAMETRO_BUSCAR('IGA', clstipificacion),
                        decode(p_nOrdenRanking,
                               2,
                               GETESTADOTRAMITETXT(pryid),
                               decode(p_nOrdenRanking,
                                      3,
                                      pe.txtrazonsocial,
                                      decode(p_nOrdenRanking,
                                             4,
                                             PARAMETRO_BUSCAR('TAC',
                                                              GETTIPOACAE(pr.clssector)),
                                             decode(p_nOrdenRanking,
                                                    5,
                                                    PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                                     pr.clssector),
                                                    decode(p_nOrdenRanking,
                                                           6,
                                                           GETTXTDEPENDENCIA(pr.pryid),
                                                           '')))))) TXT,
                 count(*) cnt
            from proyecto pr, persona pe, ubigeo u
           where pr.personaid = pe.personaid(+)
             and pr.ubigeoid = u.ubigeoid(+)
             and ((nClsTipificacion = '-1' and
                 clstipificacion NOT IN ('CA0', 'CA1', 'CA2', 'CA3')) or
                 (nClsTipificacion = 0) or
                 (nClsTipificacion = 1 and
                 clstipificacion = p_cClsTipificacion))
             and (nEstadoTramite = 0 or
                 GETESTADOTRAMITE(pryid) = p_cEstadoTramite)
             and pr.personaid in
                 (select personaid
                    from persona
                   where tippersona = 'PRO'
                     and tipdocumentoper <> 'RUC')
             and (nClsSector = 0 or clssector = p_cClsSector)
             and (nClsSubSector = 0 or
                 pr.pryid in
                 (select proyecto.pryid
                     from expediente, proyecto
                    where expediente.pryid = proyecto.pryid
                      and expediente.personaid = p_cClsSubSector))
             and (nUbigeo = 0 or substr(pr.ubigeoid, 0, nUbigeo) = cUbigeo)
             and (nAnoPresentacion = 0 or
                 to_char(fchexpediente, 'YYYY') = p_cAnoPresentacion)
             and (nTipDocTramite = 0 or
                 pryid in
                 (select distinct expediente.pryid
                     from expediente, expedientedocumento, documento
                    where expediente.expid = expedientedocumento.expid
                      and expedientedocumento.docid = documento.docid
                      and documento.tipodocumento = p_cTipDocTramite))
           group by decode(p_nOrdenRanking,
                           1,
                           clstipificacion,
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         '' || pr.personaid,
                                         decode(p_nOrdenRanking,
                                                4,
                                                GETTIPOACAE(pr.clssector),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       pr.clssector,
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETDEPENDENCIA(pr.pryid),
                                                              '')))))),
                    decode(p_nOrdenRanking,
                           1,
                           PARAMETRO_BUSCAR('IGA', clstipificacion),
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         pe.txtrazonsocial,
                                         decode(p_nOrdenRanking,
                                                4,
                                                PARAMETRO_BUSCAR('TAC',
                                                                 GETTIPOACAE(pr.clssector)),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                                        pr.clssector),
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETTXTDEPENDENCIA(pr.pryid),
                                                              ''))))));
      ELSIF nTipoPersoneria = 0 AND nProponente = 0 THEN
        open p_rsProyecto for
          select decode(p_nOrdenRanking,
                        1,
                        clstipificacion,
                        decode(p_nOrdenRanking,
                               2,
                               GETESTADOTRAMITETXT(pryid),
                               decode(p_nOrdenRanking,
                                      3,
                                      '' || pr.personaid,
                                      decode(p_nOrdenRanking,
                                             4,
                                             GETTIPOACAE(pr.clssector),
                                             decode(p_nOrdenRanking,
                                                    5,
                                                    pr.clssector,
                                                    decode(p_nOrdenRanking,
                                                           6,
                                                           GETDEPENDENCIA(pr.pryid),
                                                           '')))))) ID,
                 decode(p_nOrdenRanking,
                        1,
                        PARAMETRO_BUSCAR('IGA', clstipificacion),
                        decode(p_nOrdenRanking,
                               2,
                               GETESTADOTRAMITETXT(pryid),
                               decode(p_nOrdenRanking,
                                      3,
                                      pe.txtrazonsocial,
                                      decode(p_nOrdenRanking,
                                             4,
                                             PARAMETRO_BUSCAR('TAC',
                                                              GETTIPOACAE(pr.clssector)),
                                             decode(p_nOrdenRanking,
                                                    5,
                                                    PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                                     pr.clssector),
                                                    decode(p_nOrdenRanking,
                                                           6,
                                                           GETTXTDEPENDENCIA(pr.pryid),
                                                           '')))))) TXT,
                 count(*) cnt
            from proyecto pr, persona pe, ubigeo u
           where pr.personaid = pe.personaid(+)
             and pr.ubigeoid = u.ubigeoid(+)
             and ((nClsTipificacion = '-1' and
                 clstipificacion NOT IN ('CA0', 'CA1', 'CA2', 'CA3')) or
                 (nClsTipificacion = 0) or
                 (nClsTipificacion = 1 and
                 clstipificacion = p_cClsTipificacion))
             and (nEstadoTramite = 0 or
                 GETESTADOTRAMITE(pryid) = p_cEstadoTramite)
             and (nClsSector = 0 or clssector = p_cClsSector)
             and (nClsSubSector = 0 or
                 pr.pryid in
                 (select proyecto.pryid
                     from expediente, proyecto
                    where expediente.pryid = proyecto.pryid
                      and expediente.personaid = p_cClsSubSector))
             and (nUbigeo = 0 or substr(pr.ubigeoid, 0, nUbigeo) = cUbigeo)
             and (nAnoPresentacion = 0 or
                 to_char(fchexpediente, 'YYYY') = p_cAnoPresentacion)
             and (nTipDocTramite = 0 or
                 pryid in
                 (select distinct expediente.pryid
                     from expediente, expedientedocumento, documento
                    where expediente.expid = expedientedocumento.expid
                      and expedientedocumento.docid = documento.docid
                      and documento.tipodocumento = p_cTipDocTramite))
           group by decode(p_nOrdenRanking,
                           1,
                           clstipificacion,
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         '' || pr.personaid,
                                         decode(p_nOrdenRanking,
                                                4,
                                                GETTIPOACAE(pr.clssector),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       pr.clssector,
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETDEPENDENCIA(pr.pryid),
                                                              '')))))),
                    decode(p_nOrdenRanking,
                           1,
                           PARAMETRO_BUSCAR('IGA', clstipificacion),
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         pe.txtrazonsocial,
                                         decode(p_nOrdenRanking,
                                                4,
                                                PARAMETRO_BUSCAR('TAC',
                                                                 GETTIPOACAE(pr.clssector)),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                                        pr.clssector),
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETTXTDEPENDENCIA(pr.pryid),
                                                              ''))))));
      ELSIF nProponente = 1 THEN
        open p_rsProyecto for
          select decode(p_nOrdenRanking,
                        1,
                        clstipificacion,
                        decode(p_nOrdenRanking,
                               2,
                               GETESTADOTRAMITETXT(pryid),
                               decode(p_nOrdenRanking,
                                      3,
                                      '' || pr.personaid,
                                      decode(p_nOrdenRanking,
                                             4,
                                             GETTIPOACAE(pr.clssector),
                                             decode(p_nOrdenRanking,
                                                    5,
                                                    pr.clssector,
                                                    decode(p_nOrdenRanking,
                                                           6,
                                                           GETDEPENDENCIA(pr.pryid),
                                                           '')))))) ID,
                 decode(p_nOrdenRanking,
                        1,
                        PARAMETRO_BUSCAR('IGA', clstipificacion),
                        decode(p_nOrdenRanking,
                               2,
                               GETESTADOTRAMITETXT(pryid),
                               decode(p_nOrdenRanking,
                                      3,
                                      pe.txtrazonsocial,
                                      decode(p_nOrdenRanking,
                                             4,
                                             PARAMETRO_BUSCAR('TAC',
                                                              GETTIPOACAE(pr.clssector)),
                                             decode(p_nOrdenRanking,
                                                    5,
                                                    PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                                     pr.clssector),
                                                    decode(p_nOrdenRanking,
                                                           6,
                                                           GETTXTDEPENDENCIA(pr.pryid),
                                                           '')))))) TXT,
                 count(*) cnt
            from proyecto pr, persona pe, ubigeo u
           where pr.personaid = pe.personaid(+)
             and pr.ubigeoid = u.ubigeoid(+)
             and ((nClsTipificacion = '-1' and
                 clstipificacion NOT IN ('CA0', 'CA1', 'CA2', 'CA3')) or
                 (nClsTipificacion = 0) or
                 (nClsTipificacion = 1 and
                 clstipificacion = p_cClsTipificacion))
             and (nEstadoTramite = 0 or
                 GETESTADOTRAMITE(pryid) = p_cEstadoTramite)
             and pr.personaid = p_cProponente
             and (nClsSector = 0 or clssector = p_cClsSector)
             and (nClsSubSector = 0 or
                 pr.pryid in
                 (select proyecto.pryid
                     from expediente, proyecto
                    where expediente.pryid = proyecto.pryid
                      and expediente.personaid = p_cClsSubSector))
             and (nUbigeo = 0 or substr(pr.ubigeoid, 0, nUbigeo) = cUbigeo)
             and (nAnoPresentacion = 0 or
                 to_char(fchexpediente, 'YYYY') = p_cAnoPresentacion)
             and (nTipDocTramite = 0 or
                 pryid in
                 (select distinct expediente.pryid
                     from expediente, expedientedocumento, documento
                    where expediente.expid = expedientedocumento.expid
                      and expedientedocumento.docid = documento.docid
                      and documento.tipodocumento = p_cTipDocTramite))
           group by decode(p_nOrdenRanking,
                           1,
                           clstipificacion,
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         '' || pr.personaid,
                                         decode(p_nOrdenRanking,
                                                4,
                                                GETTIPOACAE(pr.clssector),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       pr.clssector,
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETDEPENDENCIA(pr.pryid),
                                                              '')))))),
                    decode(p_nOrdenRanking,
                           1,
                           PARAMETRO_BUSCAR('IGA', clstipificacion),
                           decode(p_nOrdenRanking,
                                  2,
                                  GETESTADOTRAMITETXT(pryid),
                                  decode(p_nOrdenRanking,
                                         3,
                                         pe.txtrazonsocial,
                                         decode(p_nOrdenRanking,
                                                4,
                                                PARAMETRO_BUSCAR('TAC',
                                                                 GETTIPOACAE(pr.clssector)),
                                                decode(p_nOrdenRanking,
                                                       5,
                                                       PARAMETRO_BUSCAR(GETTIPOACAE(pr.clssector),
                                                                        pr.clssector),
                                                       decode(p_nOrdenRanking,
                                                              6,
                                                              GETTXTDEPENDENCIA(pr.pryid),
                                                              ''))))));
      END IF;
    END IF;
  END RANKING;

  PROCEDURE RANKING_DETALLE(p_rsProyecto       OUT curType,
                            p_cClsTipificacion VARCHAR2, -- categoria proyecto
                            p_cEstadoTramite   VARCHAR2,
                            p_cTipoPersoneria  VARCHAR2,
                            p_cProponente      VARCHAR2,
                            p_cTipoAcae        VARCHAR2,
                            p_cClsSector       VARCHAR2,
                            p_cClsSubSector    NUMBER,
                            p_cCodDepartamento VARCHAR2,
                            p_cCodProvincia    VARCHAR2,
                            p_cCodDistrito     VARCHAR2,
                            p_cAnoPresentacion VARCHAR2,
                            p_cTipDocTramite   VARCHAR2,
                            p_nOrdenRanking    NUMBER,
                            p_cIdAgrupacion    VARCHAR2) IS
    nClsTipificacion NUMBER(1);
    nEstadoTramite   NUMBER(1);
    nTipoPersoneria  NUMBER(1);
    nProponente      NUMBER(1);
    nTipoAcae        NUMBER(1);
    nClsSector       NUMBER(1);
    nClsSubSector    NUMBER(1);
    nCodDepartamento NUMBER(1);
    nCodProvincia    NUMBER(1);
    nCodDistrito     NUMBER(1);
    nAnoPresentacion NUMBER(1);
    nTipDocTramite   NUMBER(1);
    cUbigeo          VARCHAR2(6);
    nUbigeo          NUMBER(1);
  BEGIN
    IF p_cClsTipificacion IS NULL OR p_cClsTipificacion = '0' THEN
      nClsTipificacion := 0;
    ELSE
      IF p_cClsTipificacion = '-1' THEN
        nClsTipificacion := -1;
      ELSE
        nClsTipificacion := 1;
      END IF;
    END IF;
    IF p_cEstadoTramite IS NULL OR p_cEstadoTramite = '0' THEN
      nEstadoTramite := 0;
    ELSE
      nEstadoTramite := 1;
    END IF;
    /* nTipoPersoneria 0 TODO 1 PJ 2 PN */
    IF p_cTipoPersoneria IS NULL OR p_cTipoPersoneria = '0' THEN
      nTipoPersoneria := 0;
    ELSIF p_cTipoPersoneria = 'PJ' THEN
      nTipoPersoneria := 1;
    ELSIF p_cTipoPersoneria = 'PN' THEN
      nTipoPersoneria := 2;
    END IF;
    IF p_cProponente IS NULL OR p_cProponente = '0' THEN
      nProponente := 0;
    ELSE
      nProponente := 1;
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
    IF p_cCodDepartamento IS NULL OR p_cCodDepartamento = 0 THEN
      nCodDepartamento := 0;
    ELSE
      nCodDepartamento := 1;
    END IF;
    IF p_cCodProvincia IS NULL OR p_cCodProvincia = 0 THEN
      nCodProvincia := 0;
    ELSE
      nCodProvincia := 1;
    END IF;
    IF p_cCodDistrito IS NULL OR p_cCodDistrito = 0 THEN
      nCodDistrito := 0;
    ELSE
      nCodDistrito := 1;
    END IF;
    IF nCodDepartamento = 1 AND nCodProvincia = 1 AND nCodDistrito = 1 THEN
      cUbigeo := p_cCodDepartamento || p_cCodProvincia || p_cCodDistrito;
      nUbigeo := 6;
    ELSIF nCodDepartamento = 1 AND nCodProvincia = 1 AND nCodDistrito = 0 THEN
      cUbigeo := p_cCodDepartamento || p_cCodProvincia;
      nUbigeo := 4;
    ELSIF nCodDepartamento = 1 AND nCodProvincia = 0 AND nCodDistrito = 0 THEN
      cUbigeo := p_cCodDepartamento;
      nUbigeo := 2;
    ELSE
      nUbigeo := 0;
    END IF;
    IF p_cAnoPresentacion IS NULL OR p_cAnoPresentacion = 0 THEN
      nAnoPresentacion := 0;
    ELSE
      nAnoPresentacion := 1;
    END IF;
    IF p_cTipDocTramite IS NULL OR p_cTipDocTramite = '0' THEN
      nTipDocTramite := 0;
    ELSE
      nTipDocTramite := 1;
    END IF;
  
    /*SI SELECCIONA SOLO TIPO ACAE FILTRAR SOLO INSTITUCIONES DEL TIPO DE ACAE */
    --IF (nTipoAcae = 1 AND nClsSector = 0 AND nClsSubSector = 0) AND (nTipoPersoneria=1 AND   THEN
    IF (nTipoAcae = 1 AND nClsSector = 0 AND nClsSubSector = 0) THEN
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
               GETESTADOTRAMITETXT(pryid) esttram,
               PARAMETRO_BUSCAR('ACT', substr(pr.codproyecto, 0, 3)) actividad
          from proyecto pr, persona pe, ubigeo u
         where pr.personaid = pe.personaid(+)
           and pr.ubigeoid = u.ubigeoid(+)
           and ((nClsTipificacion = '-1' and
               clstipificacion NOT IN ('CA0', 'CA1', 'CA2', 'CA3')) or
               (nClsTipificacion = 0) or
               (nClsTipificacion = 1 and
               clstipificacion = p_cClsTipificacion))
           and (nEstadoTramite = 0 or
               GETESTADOTRAMITE(pryid) = p_cEstadoTramite)
           and (nProponente = 0 or pr.personaid = p_cProponente)
           and clssector in
               (select ins.codparametro
                  from parametro ins
                 where ins.tipparametro in
                       (select codparametro
                          from parametro tac
                         where tac.tipparametro = 'TAC')
                   and ins.tipparametro = p_cTipoAcae)
           and (nUbigeo = 0 or substr(pr.ubigeoid, 0, nUbigeo) = cUbigeo)
           and (nAnoPresentacion = 0 or
               to_char(fchexpediente, 'YYYY') = p_cAnoPresentacion)
           and (nTipDocTramite = 0 or
               pryid in
               (select distinct expediente.pryid
                   from expediente, expedientedocumento, documento
                  where expediente.expid = expedientedocumento.expid
                    and expedientedocumento.docid = documento.docid
                    and documento.tipodocumento = p_cTipDocTramite))
              
           and decode(p_nOrdenRanking,
                      1,
                      clstipificacion,
                      decode(p_nOrdenRanking,
                             2,
                             GETESTADOTRAMITETXT(pryid),
                             decode(p_nOrdenRanking,
                                    3,
                                    '' || pr.personaid,
                                    decode(p_nOrdenRanking,
                                           4,
                                           GETTIPOACAE(pr.clssector),
                                           decode(p_nOrdenRanking,
                                                  5,
                                                  pr.clssector,
                                                  decode(p_nOrdenRanking,
                                                         6,
                                                         GETDEPENDENCIA(pr.pryid),
                                                         '')))))) =
               p_cIdAgrupacion
         order by p_nOrdenRanking;
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
               GETESTADOTRAMITETXT(pryid) esttram,
               PARAMETRO_BUSCAR('ACT', substr(pr.codproyecto, 0, 3)) actividad
          from proyecto pr, persona pe, ubigeo u
         where pr.personaid = pe.personaid(+)
           and pr.ubigeoid = u.ubigeoid(+)
           and ((nClsTipificacion = '-1' and
               clstipificacion NOT IN ('CA0', 'CA1', 'CA2', 'CA3')) or
               (nClsTipificacion = 0) or
               (nClsTipificacion = 1 and
               clstipificacion = p_cClsTipificacion))
           and (nEstadoTramite = 0 or
               GETESTADOTRAMITE(pryid) = p_cEstadoTramite)
           and (nProponente = 0 or pr.personaid = p_cProponente)
           and (nClsSector = 0 or clssector = p_cClsSector)
           and (nClsSubSector = 0 or
               pr.pryid in
               (select proyecto.pryid
                   from expediente, proyecto
                  where expediente.pryid = proyecto.pryid
                    and expediente.personaid = p_cClsSubSector))
           and (nUbigeo = 0 or substr(pr.ubigeoid, 0, nUbigeo) = cUbigeo)
           and (nAnoPresentacion = 0 or
               to_char(fchexpediente, 'YYYY') = p_cAnoPresentacion)
           and (nTipDocTramite = 0 or
               pryid in
               (select distinct expediente.pryid
                   from expediente, expedientedocumento, documento
                  where expediente.expid = expedientedocumento.expid
                    and expedientedocumento.docid = documento.docid
                    and documento.tipodocumento = p_cTipDocTramite))
           and decode(p_nOrdenRanking,
                      1,
                      clstipificacion,
                      decode(p_nOrdenRanking,
                             2,
                             GETESTADOTRAMITETXT(pryid),
                             decode(p_nOrdenRanking,
                                    3,
                                    '' || pr.personaid,
                                    decode(p_nOrdenRanking,
                                           4,
                                           GETTIPOACAE(pr.clssector),
                                           decode(p_nOrdenRanking,
                                                  5,
                                                  pr.clssector,
                                                  decode(p_nOrdenRanking,
                                                         6,
                                                         GETDEPENDENCIA(pr.pryid),
                                                         '')))))) =
               p_cIdAgrupacion;
    END IF;
  END RANKING_DETALLE;
END;
/

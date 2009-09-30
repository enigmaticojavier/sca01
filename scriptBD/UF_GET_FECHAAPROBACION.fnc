CREATE OR REPLACE FUNCTION UF_GET_FECHAAPROBACION(an_pryid NUMBER) RETURN DATE
IS rdt_fecha DATE;
BEGIN
DECLARE
ls_paso_aprob	VARCHAR2(6);
ls_tippaso		VARCHAR2(6);
ldt_fchpaso		DATE;

  BEGIN
    SELECT MAX(CODPARAMETRO)
      INTO ls_paso_aprob
    FROM PARAMETRO
    WHERE TIPPARAMETRO = 'TRX' AND
          TXTVALOR LIKE '%RESOLUCION DE APROBACIÓN%';

		BEGIN
      SELECT t.fchpaso,
             t.tippaso
        INTO ldt_fchpaso,
             ls_tippaso
        FROM VPROYECTOESTADO t, expediente u
       WHERE t.expid = u.expid AND
             u.pryid = an_pryid AND ---3489
             u.tiptramite = 'SCA';

      EXCEPTION WHEN NO_DATA_FOUND THEN
      	ldt_fchpaso := NULL;
        ls_tippaso := 'XXX';
     END;


    IF ls_tippaso = ls_paso_aprob THEN
      rdt_fecha := ldt_fchpaso;
    ELSE
      rdt_fecha := NULL;
    END IF;

  END;

RETURN rdt_fecha;
END;
/

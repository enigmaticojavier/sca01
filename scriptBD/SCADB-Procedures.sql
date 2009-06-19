---------------------------------------------------
-- Export file for user SCA2                     --
-- Created by JORGE on 19/06/2009, 01:59:50 a.m. --
---------------------------------------------------

spool 3PROCS-VIEW-TRIG.log

prompt
prompt Creating view VPROYECTOESTADO
prompt =============================
prompt
CREATE OR REPLACE VIEW VPROYECTOESTADO AS
SELECT EX.PRYID, EP."EXPID",EP."NSECUENCIA",EP."TIPPASO",EP."FCHPASO",EP."PERIODO", ET.TIPESTADOTRAMITE
FROM EXPEDIENTEPASO EP,
		 ESTADOSTUPA ET,
     EXPEDIENTE EX
WHERE (EP.EXPID, EP.NSECUENCIA) IN
        (SELECT A.EXPID, MAX(NSECUENCIA)
        	FROM EXPEDIENTEPASO A
        	GROUP BY A.EXPID) AND
       EP.TIPPASO = ET.TIPPASO AND
       EX.EXPID		= EP.EXPID
WITH READ ONLY;

prompt
prompt Creating package PQ_PROYECTO
prompt ============================
prompt
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
                   p_cClsSubSector       VARCHAR2);
  FUNCTION PARAMETRO_BUSCAR(p_cTipParametro VARCHAR2,
                            p_cCodParametro VARCHAR2) RETURN VARCHAR2;
  FUNCTION GETESTADOTRAMITE(p_cPryId VARCHAR2) RETURN VARCHAR2;
  FUNCTION GETESTADOTRAMITETXT(p_cPryId VARCHAR2) RETURN VARCHAR2;
  FUNCTION GETDEPARTAMENTO(p_cUbigeoid VARCHAR2) RETURN VARCHAR2;

end PQ_PROYECTO;
/

prompt
prompt Creating procedure USP_000_LIMPIA_TABLAT
prompt ========================================
prompt
CREATE OR REPLACE PROCEDURE USP_000_LIMPIA_TABLAT (as_archivo	varchar2, al_numacae	INTEGER, as_periodo	VARCHAR2)
IS
BEGIN
---PRP
---PRY
---EXP
--- Para el parámetro as_archivo, puedes pasar el valor de codparametro que corresponde
	IF as_archivo = 'PRP' THEN
  	DELETE TPROPONENTE WHERE numacae = al_numacae AND periodo = as_periodo;
  END IF;

	IF as_archivo = 'PRY' THEN
  	DELETE TPROYECTO WHERE numacae = al_numacae AND periodo = as_periodo;
  END IF;

	IF as_archivo = 'EXP' THEN
  	DELETE TPROYECTO WHERE numacae = al_numacae AND periodo = as_periodo;
  END IF;

	COMMIT;
END;
/

prompt
prompt Creating procedure USP_001_CARGA_INFO
prompt =====================================
prompt
CREATE OR REPLACE PROCEDURE USP_001_CARGA_INFO IS
BEGIN
DECLARE
lnidpersona		INTEGER;
lnpryid				INTEGER;
lexpid				INTEGER;
lnumsecuencia	INTEGER;
lniddocumento	INTEGER;
lexisteexp		INTEGER;
CURSOR ctproponente IS SELECT * FROM SCA1.Tproponente WHERE numacae = 1 AND periodo = '200901';
CURSOR ctproyecto IS SELECT * FROM SCA1.Tproyecto WHERE numacae = 1 AND periodo = '200901';
CURSOR ctexpediente IS SELECT * FROM SCA1.Texpediente WHERE numacae = 1 AND periodo = '200901' ORDER BY numexpd, fchtran ASC;

BEGIN

    FOR cu_proponente IN ctproponente LOOP
      lnidpersona := SCA1.sq_persona.nextval;

      INSERT INTO SCA1.persona
        (personaid,
        ubigeoid,
        tipopersona,
        txtrazonsocial,
        txtdomicilio,
        telefono,
        txtemail,
        fax,
        tipdocumentoper,
        numdocumentoper)
      VALUES (lnidpersona,
            cu_proponente.ubigeog,
            'PRO',
            cu_proponente.razsoci,
            cu_proponente.domprop,
            NULL,
            NULL,
            NULL,
            'RUC',
            cu_proponente.rucprop);
      ---proponente
      INSERT INTO SCA1.proponente
        (personaid,
        tipodocumentorl,
        coddocumentorl,
        txtnombresrl,
        periodo)
      VALUES (lnidpersona,
            cu_proponente.tipdorl,
            cu_proponente.numdorl,
            cu_proponente.nombrrl,
            cu_proponente.periodo);

    END LOOP;
    --------------------------------------------------------
    ---SELECT numacae, codproy, periodo, nomproy, tipocat, rucprop, tmpvida, tsector, tsubsec, ubigeog, fchpres FROM tproyecto;

    ---proyecto


    FOR cu_proyecto IN ctproyecto LOOP

      SELECT personaid
        INTO lnidpersona
        FROM SCA1.persona
       WHERE tipdocumentoper = 'RUC' AND numdocumentoper = cu_proyecto.rucprop;

      IF lnidpersona > 0 THEN
        lnpryid := SCA1.SQ_PROYECTO.NEXTVAL;
        INSERT INTO SCA1.proyecto
          (pryid,
          codproyecto,
          ubigeoid,
          personaid,
          txtcoordenadas,
          clstipificacion,
          txtdescripcion,
          mninversion,
          clssector,
          clssubsector,
          fchexpediente,
          periodo)
        VALUES (lnpryid,
              cu_proyecto.codproy,
              cu_proyecto.ubigeog,
              lnidpersona,
              NULL,
              cu_proyecto.tipocat,
              cu_proyecto.nomproy,
              NULL,
              cu_proyecto.tsector,
              cu_proyecto.tsubsec,
              cu_proyecto.fchpres,
              cu_proyecto.periodo);
      END IF;

    END LOOP;
    ---expediente
    ---tablas EXPEDIENTE, EXPEDIENTEPASO Y EXPEDIENTEDOCUMENTO.
    ---SELECT numacae, codproy, numexpd, tiptran, periodo, fchtran, numresl, fchresl, dscbiga FROM texpediente

    ---expediente
/*    SELECT MAX(expid)
      INTO lexpid
      FROM SCA1.expediente;

    lexpid := NVL(lexpid, 0);

    INSERT INTO SCA1.expediente
      (expid,
      pryid,
      personaid,
      numexpediente,
      fchexpediente,
      tiptramite,
      clstipificacion,
      periodo)
    SELECT ROWNUM + lexpid,
          (SELECT pryid FROM SCA1.proyecto WHERE codproyecto = v.codproy), ---codproyecto debe estar relacionado a la ACAE
          v.numacae,
          v.numexpd,
          MIN(v.fchtran),
          'SCA1',
          NULL,
          v.periodo
     FROM SCA1.texpediente v
    WHERE v.numacae = 1 AND
          v.numexpd NOT IN (SELECT numexpediente FROM SCA1.expediente WHERE numacae = v.numacae)
    GROUP BY v.codproy, v.numacae, v.numexpd, v.periodo;*/

    ---fin solo expediente
    FOR cu_expediente IN ctexpediente LOOP

			SELECT pryid
        INTO lnpryid
        FROM SCA1.proyecto
       WHERE codproyecto = cu_expediente.codproy;
			---debe existir el proyecto...

      SELECT COUNT(1)
        INTO lexisteexp
       FROM SCA1.expediente
      WHERE personaid = 1 AND numexpediente = cu_expediente.numexpd;

			IF lexisteexp >= 0 THEN
      	lexpid := SCA1.SQ_EXPEDIENTE.NEXTVAL;
        INSERT INTO SCA1.expediente
          (expid,
          pryid,
          personaid,
          numexpediente,
          fchexpediente,
          tiptramite,
          clstipificacion,
          periodo)
        VALUES (lexpid,
              lnpryid, ---codproyecto debe estar relacionado a la ACAE
              cu_expediente.numacae,
              cu_expediente.numexpd,
              cu_expediente.fchtran,
              'SCA1',
              NULL,
              cu_expediente.periodo) ;
			ELSE
      	SELECT expid
        	INTO lexpid
       		FROM SCA1.expediente
      	 WHERE personaid = 1 AND numexpediente = cu_expediente.numexpd;
      END IF;

      ---expedientepaso
      SELECT m.numsecuencia
        INTO lnumsecuencia
        FROM SCA1.estadostupa m
       WHERE m.tiptramite = 'SCA1' AND m.tippaso = cu_expediente.tiptran;

      INSERT INTO expedientepaso
        (expid, nsecuencia, tippaso, fchpaso, periodo)
      VALUES (lexpid,
            lnumsecuencia,
            cu_expediente.tiptran,
            cu_expediente.fchtran,
            cu_expediente.periodo);

      ---documento
      IF cu_expediente.tiptran IN ('RDE', 'RAP', 'ITA') THEN

    /*		SELECT lniddocumento = MAX(documentoid)
          FROM SCA1.documento;

        lniddocumento := NVL(lniddocumento) + 1;*/

        IF cu_expediente.tiptran IN ('RDE', 'RAP') THEN
          lniddocumento := SCA1.sq_documento.nextval;

          INSERT INTO documento
            (docid, tipodocumento, coddocumento, fchexpedicion, fchpresentacion, periodo)
          VALUES (lniddocumento,
                'RES',
                cu_expediente.numresl,
                cu_expediente.fchresl,
                cu_expediente.fchresl,
                cu_expediente.periodo );
          ---expedientedocumento
          INSERT INTO expedientedocumento
          (expid, nsecuencia, nsecuenciadoc, docid)
          VALUES (lexpid,
                lnumsecuencia,
                1,
              lniddocumento);

          ---resolucion
          INSERT INTO resolucion
            (docid, tipresolucion, fchpublicacion, fchvigencia, resumen)
          VALUES (lniddocumento,
                CASE WHEN cu_expediente.tiptran = 'RDE' THEN 'RCD' ELSE 'RCA' END,
                cu_expediente.fchtran,
                cu_expediente.fchtran,
                NULL );

        END IF;

        IF cu_expediente.tiptran = 'RAP' THEN
          lniddocumento := SCA1.sq_documento.nextval;
          INSERT INTO documento
            (docid, tipodocumento, coddocumento, fchexpedicion, fchpresentacion, periodo)
          VALUES (lniddocumento,
                'EIA',
                cu_expediente.numexpd,
                cu_expediente.fchtran,
                cu_expediente.fchtran,
                cu_expediente.periodo);

          INSERT INTO expedientedocumento
            (expid, nsecuencia, nsecuenciadoc, docid)
          VALUES (lexpid,
                lnumsecuencia,
                2,
                lniddocumento);

          ---eia
          INSERT INTO eia
            (docid, txtresumen)
          VALUES (lniddocumento,
                cu_expediente.dscbiga);

        END IF;

        IF cu_expediente.tiptran = 'ITA' THEN
          lniddocumento := SCA1.sq_documento.nextval;
          INSERT INTO documento
            (docid, tipodocumento, coddocumento, fchexpedicion, fchpresentacion, periodo)
          VALUES (lniddocumento,
                'ITA',
                cu_expediente.NUMITAM,  ---nuevo campo
                cu_expediente.fchtran,
                cu_expediente.fchtran,
                cu_expediente.periodo);

          INSERT INTO expedientedocumento
            (expid, nsecuencia, nsecuenciadoc, docid)
          VALUES (lexpid,
                lnumsecuencia,
                1,
                lniddocumento);
        END IF;

        ---expedientedocumento
    ----------------falta
     END IF;

    END LOOP;

END;

END;
/

prompt
prompt Creating procedure USP_001_CARGA_PROPONENTE
prompt ===========================================
prompt
CREATE OR REPLACE PROCEDURE USP_001_CARGA_PROPONENTE(al_acae IN INTEGER, as_periodo IN VARCHAR2, al_error OUT INT) IS
BEGIN
/*Carga el archivo de proponentes*/
DECLARE
lnidpersona		INTEGER;
CURSOR ctproponente IS
SELECT * FROM Tproponente
	WHERE numacae = al_acae AND
  			periodo = as_periodo AND
        rucprop NOT IN (SELECT numdocumentoper FROM persona WHERE tipdocumentoper = 'RUC' AND tippersona = 'PRO');

BEGIN
		
    FOR cu_proponente IN ctproponente LOOP
---      SELECT NVL(MAX(personaid), 0) + 1 INTO lnidpersona FROM persona;
			SELECT SQ_PERSONA.NEXTVAL INTO lnidpersona FROM DUAL;
/*			SELECT COUNT(1) FROM SCA1.persona a
      WHERE a.tipdocumentoper = 'RUC' AND
      			a.numdocumentoper = cu_proponente.rucprop*/
      BEGIN
        INSERT INTO persona
          (personaid,
          ubigeoid,
          tippersona,
          txtrazonsocial,
          txtdomicilio,
          telefono,
          txtemail,
          fax,
          tipdocumentoper,
          numdocumentoper)
        VALUES (lnidpersona,
              cu_proponente.ubigeog,
              'PRO',
              cu_proponente.razsoci,
              cu_proponente.domprop,
              cu_proponente.telefon,
              cu_proponente.correoe,
              cu_proponente.telefax,
              'RUC',
              cu_proponente.rucprop);
        EXCEPTION
        WHEN OTHERS THEN
        	al_error := -2;
          RETURN;

       END;
      ---proponente
      BEGIN
        INSERT INTO proponente
          (personaid,
          tipodocumentorl,
          coddocumentorl,
          txtnombresrl,
          periodo)
        VALUES (lnidpersona,
              cu_proponente.tipdorl,
              cu_proponente.numdorl,
              cu_proponente.nombrrl,
              cu_proponente.periodo);
        EXCEPTION
        WHEN OTHERS THEN
        	al_error := -2;
          RETURN;

      END;

    END LOOP;

		COMMIT;
END;

END;
/

prompt
prompt Creating procedure USP_002_VERIFICA_TPROYECTO
prompt =============================================
prompt
CREATE OR REPLACE PROCEDURE usp_002_verifica_tproyecto(al_acae IN INTEGER, as_periodo IN VARCHAR2, al_error OUT INT)
/*Verifica si proyecto que se quiere enviar ya existe*/
IS
BEGIN
  DECLARE
  lcontador		INTEGER;

  CURSOR cu_tproyecto IS
  SELECT s.* FROM TPROYECTO s
  WHERE s.numacae = al_acae AND
  			s.periodo = as_periodo;

	BEGIN
    FOR ltproyecto IN cu_tproyecto LOOP
      SELECT COUNT(1)
        INTO lcontador
        FROM proyecto t,
        		 persona u
       WHERE t.personaid = u.personaid AND
       			 t.codproyecto = ltproyecto.codproy AND
       			 u.numdocumentoper = ltproyecto.rucprop AND
             u.tippersona = 'PRO';

      IF lcontador > 0 THEN
        al_error := 1;
        RETURN;
      END IF;

    END LOOP;
		al_error := 0;
	END;

END;
/

prompt
prompt Creating procedure USP_002_CARGA_PROYECTO
prompt =========================================
prompt
CREATE OR REPLACE PROCEDURE USP_002_CARGA_PROYECTO(al_acae IN INTEGER, as_periodo IN VARCHAR2, al_error OUT INT) IS
BEGIN
/*Carga el archivo de proyectos*/
DECLARE
lnidpersona		INTEGER;
lnpryid				INTEGER;
CURSOR ctproyecto IS SELECT * FROM Tproyecto WHERE numacae = al_acae AND periodo = as_periodo;

BEGIN
		USP_002_VERIFICA_TPROYECTO(al_acae, as_periodo, al_error);

		IF al_error < 0 THEN
    	RETURN; ---ya existe proyecto
    END IF;

    FOR cu_proyecto IN ctproyecto LOOP

      SELECT personaid
        INTO lnidpersona
        FROM persona
       WHERE tipdocumentoper = 'RUC' AND numdocumentoper = cu_proyecto.rucprop;

      IF lnidpersona > 0 THEN
      	BEGIN
          SELECT SQ_PROYECTO.NEXTVAL INTO lnpryid FROM DUAL;
          ---SELECT NVL(MAX(pryid), 0) + 1 INTO lnpryid FROM proyecto;

          INSERT INTO proyecto
            (pryid,
            codproyecto,
            ubigeoid,
            personaid,
            txtcoordenadas,
            clstipificacion,
            txtdescripcion,
            mninversion,
            clssector,
            clssubsector,
            fchexpediente,
            periodo)
          VALUES (lnpryid,
                cu_proyecto.codproy,
                cu_proyecto.ubigeog,
                lnidpersona,
                NULL,
                cu_proyecto.tipocat,
                cu_proyecto.nomproy,
                NULL,
                cu_proyecto.tsector,
                cu_proyecto.tsubsec,
                cu_proyecto.fchpres,
                cu_proyecto.periodo);

        EXCEPTION
        WHEN OTHERS THEN
        	al_error := -2; ---error de base de datos
          RETURN;
        END;
      ELSE
      	al_error := -3; ---proponente no existe
        RETURN;
      END IF;

    END LOOP;

		COMMIT;
END;

END;
/

prompt
prompt Creating procedure USP_003_ELIMINA_TRANSACCIONES
prompt ================================================
prompt
CREATE OR REPLACE PROCEDURE USP_003_ELIMINA_TRANSACCIONES(al_acae IN INTEGER, as_periodo IN VARCHAR2, al_error OUT INT) IS
BEGIN
/*Elimina las transacciones enviadas en el periodo*/
	al_error := 0;

  BEGIN
    DELETE EXPEDIENTEDOCUMENTO
     WHERE (expid, nsecuencia) IN (SELECT a.expid, nsecuencia
                                        FROM EXPEDIENTEPASO a,
                                             EXPEDIENTE b
                                       WHERE a.expid = b.expid AND
                                             b.personaid = al_acae AND
                                             a.Periodo = as_periodo); ---se ejecuta el trigger que borra todos los docs
     EXCEPTION
     WHEN OTHERS THEN
     	al_error := -2; ---error de base de datos
      RETURN;
	END;

  BEGIN
	DELETE expedientepaso
   WHERE expid IN (SELECT expid FROM expediente WHERE personaid = al_acae) AND
   			 periodo = as_periodo;

   EXCEPTION
     WHEN OTHERS THEN
     	al_error := -2; ---error de base de datos
      RETURN;
	END;

END;
/

prompt
prompt Creating procedure USP_003_CARGA_EXPEDIENTE
prompt ===========================================
prompt
CREATE OR REPLACE PROCEDURE USP_003_CARGA_EXPEDIENTE(al_acae IN INTEGER, as_periodo IN VARCHAR2, al_error OUT INT) IS
BEGIN
/*Carga el archivo de expedientes*/
DECLARE
lnpryid				INTEGER;
lexisteexp		INTEGER;
lexpid				INTEGER;
lnumsecuencia	INTEGER;
lniddocumento	INTEGER;
lnsecuenciadoc INTEGER;
CURSOR ctexpediente IS SELECT * FROM Texpediente WHERE numacae = al_acae AND periodo = as_periodo ORDER BY numexpd, fchtran ASC;
CURSOR cttransaccion IS SELECT tipdocumento FROM estadostupadoc WHERE tiptramite = 'SCA' AND numsecuencia = lnumsecuencia;

BEGIN

		USP_003_ELIMINA_TRANSACCIONES(al_acae, as_periodo, al_error);
		IF al_error < 0 THEN
    	RETURN; ---error de BD eliminando las transacciones
    END IF;

    FOR cu_expediente IN ctexpediente LOOP

			SELECT pryid
        INTO lnpryid
        FROM proyecto
       WHERE codproyecto = cu_expediente.codproy;

      lnpryid := NVL(lnpryid, 0);
      IF lnpryid <= 0 THEN
      	al_error := -4; --- proyecto no existe
        RETURN;
      END IF;
			---debe existir el proyecto...

      SELECT COUNT(1)
        INTO lexisteexp
       FROM expediente
      WHERE personaid = al_acae AND numexpediente = cu_expediente.numexpd;

			IF lexisteexp = 0 THEN
      	SELECT SQ_EXPEDIENTE.nextval INTO lexpid FROM dual;
        ---SELECT NVL(MAX(expid), 0) + 1 INTO lexpid FROM EXPEDIENTE;

        BEGIN
          INSERT INTO expediente
            (expid,
            pryid,
            personaid,
            numexpediente,
            fchexpediente,
            tiptramite,
            clstipificacion,
            periodo)
          VALUES (lexpid,
                lnpryid, ---codproyecto debe estar relacionado a la ACAE
                cu_expediente.numacae,
                cu_expediente.numexpd,
                cu_expediente.fchtran,
                'SCA',
                NULL,
                cu_expediente.periodo) ;
          EXCEPTION
          WHEN OTHERS THEN
          	al_error:= -2 ; ---Error de Base de datos
            RETURN;

        END;
			ELSE
      	SELECT expid
        	INTO lexpid
       		FROM expediente
      	 WHERE personaid = al_acae AND numexpediente = cu_expediente.numexpd;
      END IF;

			lnumsecuencia := 0;
      ---expedientepaso
      SELECT m.numsecuencia
        INTO lnumsecuencia
        FROM estadostupa m
       WHERE m.tiptramite = 'SCA' AND m.tippaso = cu_expediente.tiptran;

			IF lnumsecuencia <= 0 THEN
      	al_error := -5; ---no existe secuencia para la transacción.
        RETURN;
      END IF;

      BEGIN
        INSERT INTO expedientepaso
          (expid, nsecuencia, tippaso, fchpaso, periodo)
        VALUES (lexpid,
              lnumsecuencia,
              cu_expediente.tiptran,
              cu_expediente.fchtran,
              cu_expediente.periodo);
        EXCEPTION
        WHEN OTHERS THEN
        	al_error := -2; ---error de BD
			END;

      ---documento
      FOR cu_docspedidos IN cttransaccion LOOP
      
          SELECT sq_documento.nextval INTO lniddocumento FROM dual;
          
					BEGIN
            INSERT INTO documento
              (docid, tipodocumento, coddocumento, fchexpedicion, fchpresentacion, periodo)
            VALUES (lniddocumento,
                  cu_docspedidos.tipdocumento,
                  CASE cu_docspedidos.tipdocumento WHEN 'RES' THEN cu_expediente.numresl WHEN 'ITA' THEN cu_expediente.NUMITAM ELSE cu_expediente.numexpd END, ---aquí tendría que variar si entra un nuevo tipo de documento.
                  CASE cu_docspedidos.tipdocumento WHEN 'RES' THEN cu_expediente.fchresl ELSE cu_expediente.fchtran END, ---aquí tendría que variar si entra un nuevo tipo de documento.
                  CASE cu_docspedidos.tipdocumento WHEN 'RES' THEN cu_expediente.fchresl ELSE cu_expediente.fchtran END, ---aquí tendría que variar si entra un nuevo tipo de documento.
                  cu_expediente.periodo );

            EXCEPTION
            WHEN OTHERS THEN
            	al_error := -2; ---error de BD
          END;
          ---expedientedocumento
          BEGIN
          	
          	SELECT MAX(nsecuenciadoc)
              INTO lnsecuenciadoc
              FROM expedientedocumento
             WHERE expid = lexpid AND
             			 nsecuencia = lnumsecuencia;
                    
            lnsecuenciadoc := NVL(lnsecuenciadoc, 0) + 1; --no habrá concurrencia si un usuario x ACAE-dependencia
            
            INSERT INTO expedientedocumento
            (expid, nsecuencia, nsecuenciadoc, docid)
            VALUES (lexpid,
                  lnumsecuencia,
                  lnsecuenciadoc,
                lniddocumento);

            EXCEPTION
            WHEN OTHERS THEN
            	al_error := -2; ---error de BD
					END;
          
          IF cu_docspedidos.tipdocumento = 'RES' THEN          
            BEGIN
              INSERT INTO resolucion
                (docid, tipresolucion, fchpublicacion, fchvigencia, resumen)
              VALUES (lniddocumento,
                    CASE WHEN cu_expediente.tiptran = 'RDE' THEN 'RCD' ELSE 'RCA' END, ---regla de negocio
                    cu_expediente.fchtran,
                    cu_expediente.fchtran,
                    NULL );

              EXCEPTION
              WHEN OTHERS THEN
                al_error := -2; ---error de BD
            END;
					END IF;
          
          ---eia
          IF cu_docspedidos.tipdocumento = 'EIA' THEN
            BEGIN
              INSERT INTO eia
                (docid, txtresumen)
              VALUES (lniddocumento,
                    cu_expediente.dscbiga);

              EXCEPTION
              WHEN OTHERS THEN
                al_error := -2; ---error de BD
            END;
          END IF;    
       END LOOP;                        	
/*     ******************** 
      IF cu_expediente.tiptran IN ('RDE', 'RAP', 'ITA') THEN

    \*		SELECT lniddocumento = MAX(documentoid)
          FROM documento;

        lniddocumento := NVL(lniddocumento) + 1;*\

        IF cu_expediente.tiptran IN ('RDE', 'RAP') THEN
          SELECT SCA1.sq_documento.nextval INTO lniddocumento FROM dual;
					---SELECT NVL(MAX(docid), 0) + 1 INTO lniddocumento FROM SCA1.documento;

					BEGIN
            INSERT INTO SCA1.documento
              (docid, tipodocumento, coddocumento, fchexpedicion, fchpresentacion, periodo)
            VALUES (lniddocumento,
                  'RES',
                  cu_expediente.numresl,
                  cu_expediente.fchresl,
                  cu_expediente.fchresl,
                  cu_expediente.periodo );

            EXCEPTION
            WHEN OTHERS THEN
            	al_error := -2; ---error de BD
          END;

          ---expedientedocumento
          BEGIN
            INSERT INTO SCA1.expedientedocumento
            (expid, nsecuencia, nsecuenciadoc, docid)
            VALUES (lexpid,
                  lnumsecuencia,
                  3,
                lniddocumento);

            EXCEPTION
            WHEN OTHERS THEN
            	al_error := -2; ---error de BD
					END;

          ---resolucion
          BEGIN
            INSERT INTO SCA1.resolucion
              (docid, tipresolucion, fchpublicacion, fchvigencia, resumen)
            VALUES (lniddocumento,
                  CASE WHEN cu_expediente.tiptran = 'RDE' THEN 'RCD' ELSE 'RCA' END, ---regla de negocio
                  cu_expediente.fchtran,
                  cu_expediente.fchtran,
                  NULL );

            EXCEPTION
            WHEN OTHERS THEN
            	al_error := -2; ---error de BD
          END;

        END IF;

        IF cu_expediente.tiptran = 'RAP' THEN
          ---lniddocumento := SCA1.sq_documento.currval + 1;
---          SELECT NVL(MAX(docid), 0) + 1 INTO lniddocumento FROM SCA1.documento;
          SELECT SCA1.sq_documento.nextval INTO lniddocumento FROM dual;
          
          BEGIN
            INSERT INTO SCA1.documento
              (docid, tipodocumento, coddocumento, fchexpedicion, fchpresentacion, periodo)
            VALUES (lniddocumento,
                  'EIA',
                  cu_expediente.numexpd,
                  cu_expediente.fchtran,
                  cu_expediente.fchtran,
                  cu_expediente.periodo);

            EXCEPTION
            WHEN OTHERS THEN
            	al_error := -2; ---error de BD
          END;

          BEGIN
            INSERT INTO SCA1.expedientedocumento
              (expid, nsecuencia, nsecuenciadoc, docid)
            VALUES (lexpid,
                  lnumsecuencia,
                  2,
                  lniddocumento);

            EXCEPTION
            WHEN OTHERS THEN
            	al_error := -2; ---error de BD
          END;**

          ---eia
          BEGIN
            INSERT INTO SCA1.eia
              (docid, txtresumen)
            VALUES (lniddocumento,
                  cu_expediente.dscbiga);

            EXCEPTION
            WHEN OTHERS THEN
            	al_error := -2; ---error de BD
          END;

        END IF;

        IF cu_expediente.tiptran = 'ITA' THEN
---	        SELECT NVL(MAX(docid), 0) + 1 INTO lniddocumento FROM SCA1.documento;
      ---    lniddocumento := SCA1.sq_documento.currval + 1;
          SELECT SCA1.sq_documento.nextval INTO lniddocumento FROM dual;

          BEGIN
            INSERT INTO SCA1.documento
              (docid, tipodocumento, coddocumento, fchexpedicion, fchpresentacion, periodo)
            VALUES (lniddocumento,
                  'ITA',
                  cu_expediente.NUMITAM,  ---nuevo campo
                  cu_expediente.fchtran,
                  cu_expediente.fchtran,
                  cu_expediente.periodo);
            EXCEPTION
            WHEN OTHERS THEN
            	al_error := -2; ---error de BD
          END;

					BEGIN
            INSERT INTO SCA1.expedientedocumento
              (expid, nsecuencia, nsecuenciadoc, docid)
            VALUES (lexpid,
                  lnumsecuencia,
                  1,
                  lniddocumento);
            EXCEPTION
            WHEN OTHERS THEN
            	al_error := -2; ---error de BD
          END;
        END IF;

        ---expedientedocumento
    ----------------falta
     END IF;*/

    END LOOP;
    COMMIT;

END;

END;
/

prompt
prompt Creating package body PQ_PROYECTO
prompt =================================
prompt
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
                   p_cClsSubSector       VARCHAR2) IS
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
    IF p_cClsSubSector IS NULL OR p_cClsSubSector = '0' THEN
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
             and (nClsSubSector = 0 or clssubsector = p_cClsSubSector); --'AGR1';
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
             and (nClsSubSector = 0 or clssubsector = p_cClsSubSector); --'AGR1';
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

prompt
prompt Creating trigger TDEXPEDIENTEDOCUMENTO
prompt ======================================
prompt
CREATE OR REPLACE TRIGGER tDExpedienteDocumento AFTER DELETE ON expedientedocumento FOR EACH ROW
BEGIN
	DECLARE
/*  lnextval	INTEGER;*/
  BEGIN
		DELETE imagendocumento
     WHERE docid = :old.docid;

    DELETE eia
     WHERE docid = :old.docid;

    DELETE resolucion
     WHERE docid = :old.docid;

    DELETE documento
     WHERE docid = :old.docid;

  END;
END;
/

prompt
prompt Creating trigger TIUEXPEDIENTE
prompt ==============================
prompt
create or replace trigger TIUEXPEDIENTE
  after INSERT OR UPDATE on expediente  
  for each row
declare
  lclssector		proyecto.clssector%TYPE;
  lclssubsector	proyecto.clssubsector%TYPE;
BEGIN

	SELECT t.clssector, t.clssubsector
    INTO lclssector, lclssubsector
  	FROM ACAE t
   WHERE t.personaid = :new.personaid;
   
  UPDATE PROYECTO
     SET clssector 		= lclssector,
     		 clssubsector = lclssubsector
   WHERE pryid = :new.pryid;
  
end TIUEXPEDIENTE;
/


spool off

---------------------------------------------------
-- Export file for user SCA                      --
-- Created by JORGE on 23/05/2009, 05:37:37 p.m. --
---------------------------------------------------

spool procedures.log

prompt
prompt Creating procedure USP_001_CARGA_PROPONENTE
prompt ===========================================
prompt
CREATE OR REPLACE PROCEDURE SCA.USP_001_CARGA_PROPONENTE(al_acae IN INTEGER, as_periodo IN VARCHAR2, al_error OUT INT) IS
BEGIN
/*Carga el archivo de proponentes*/
DECLARE
lnidpersona		INTEGER;
CURSOR ctproponente IS 
SELECT * FROM SCA.Tproponente 
	WHERE numacae = al_acae AND 
  			periodo = as_periodo AND
        rucprop NOT IN (SELECT numdocumentoper FROM sca.persona WHERE tipdocumentoper = 'RUC' AND tippersona = 'PRO');

BEGIN

    FOR cu_proponente IN ctproponente LOOP
      SELECT NVL(MAX(personaid), 0) + 1 INTO lnidpersona FROM sca.persona;

/*			SELECT COUNT(1) FROM sca.persona a
      WHERE a.tipdocumentoper = 'RUC' AND
      			a.numdocumentoper = cu_proponente.rucprop*/
      BEGIN
        INSERT INTO sca.persona
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
              NULL,
              NULL,
              NULL,
              'RUC',
              cu_proponente.rucprop);
        EXCEPTION
        WHEN OTHERS THEN
        	al_error := -2;
          RETURN;      
        
       END;
      ---proponente
      BEGIN
        INSERT INTO sca.proponente
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

END;

END;
/

prompt
prompt Creating procedure USP_002_VERIFICA_TPROYECTO
prompt =============================================
prompt
CREATE OR REPLACE PROCEDURE SCA.usp_002_verifica_tproyecto(al_acae IN INTEGER, as_periodo IN VARCHAR2, al_error OUT INT)
/*Verifica si proyecto que se quiere enviar ya existe*/
IS
BEGIN
  DECLARE
  lcontador		INTEGER;
  
  CURSOR cu_tproyecto IS
  SELECT s.* FROM SCA.TPROYECTO s
  WHERE s.numacae = al_acae AND
  			s.periodo = as_periodo;

	BEGIN
    FOR ltproyecto IN cu_tproyecto LOOP
      SELECT COUNT(1)
        INTO lcontador
        FROM sca.proyecto t,
        		 sca.persona u
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
CREATE OR REPLACE PROCEDURE SCA.USP_002_CARGA_PROYECTO(al_acae IN INTEGER, as_periodo IN VARCHAR2, al_error OUT INT) IS
BEGIN
/*Carga el archivo de proyectos*/
DECLARE
lnidpersona		INTEGER;
lnpryid				INTEGER;
CURSOR ctproyecto IS SELECT * FROM SCA.Tproyecto WHERE numacae = al_acae AND periodo = as_periodo;

BEGIN
		USP_002_VERIFICA_TPROYECTO(al_acae, as_periodo, al_error);
    
		IF al_error < 0 THEN
    	RETURN; ---ya existe proyecto
    END IF;
    
    FOR cu_proyecto IN ctproyecto LOOP

      SELECT personaid
        INTO lnidpersona
        FROM sca.persona
       WHERE tipdocumentoper = 'RUC' AND numdocumentoper = cu_proyecto.rucprop;

      IF lnidpersona > 0 THEN
      	BEGIN
          ---lnpryid := SCA.SQ_PROYECTO.CURRVAL + 1;
          SELECT NVL(MAX(pryid), 0) + 1 INTO lnpryid FROM sca.proyecto;
          
          INSERT INTO sca.proyecto
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

END;

END;
/

prompt
prompt Creating procedure USP_003_ELIMINA_TRANSACCIONES
prompt ================================================
prompt
CREATE OR REPLACE PROCEDURE SCA.USP_003_ELIMINA_TRANSACCIONES(al_acae IN INTEGER, as_periodo IN VARCHAR2, al_error OUT INT) IS
BEGIN
/*Elimina las transacciones enviadas en el periodo*/
	al_error := 0;
  
  BEGIN
    DELETE SCA.EXPEDIENTEDOCUMENTO
     WHERE (expid, nsecuencia) IN (SELECT a.expid, nsecuencia
                                        FROM SCA.EXPEDIENTEPASO a,
                                             SCA.EXPEDIENTE b
                                       WHERE a.expid = b.expid AND
                                             b.personaid = al_acae AND
                                             a.Periodo = as_periodo); ---se ejecuta el trigger que borra todos los docs
     EXCEPTION
     WHEN OTHERS THEN
     	al_error := -2; ---error de base de datos
      RETURN;  
	END;
  
  BEGIN
	DELETE sca.expedientepaso
   WHERE expid IN (SELECT expid FROM sca.expediente WHERE personaid = al_acae) AND
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
CREATE OR REPLACE PROCEDURE SCA.USP_003_CARGA_EXPEDIENTE(al_acae IN INTEGER, as_periodo IN VARCHAR2, al_error OUT INT) IS
BEGIN
/*Carga el archivo de expedientes*/
DECLARE
lnpryid				INTEGER;
lexisteexp		INTEGER;
lexpid				INTEGER;
lnumsecuencia	INTEGER;
lniddocumento	INTEGER;
CURSOR ctexpediente IS SELECT * FROM SCA.Texpediente WHERE numacae = al_acae AND periodo = as_periodo ORDER BY numexpd, fchtran ASC;

BEGIN

		USP_003_ELIMINA_TRANSACCIONES(al_acae, as_periodo, al_error);
		IF al_error < 0 THEN
    	RETURN; ---error de BD eliminando las transacciones
    END IF;
    
    FOR cu_expediente IN ctexpediente LOOP

			SELECT pryid 
        INTO lnpryid
        FROM sca.proyecto 
       WHERE codproyecto = cu_expediente.codproy;
       
      lnpryid := NVL(lnpryid, 0);
      IF lnpryid <= 0 THEN
      	al_error := -4; --- proyecto no existe
        RETURN;
      END IF;
			---debe existir el proyecto...       
      
      SELECT COUNT(1)
        INTO lexisteexp
       FROM sca.expediente
      WHERE personaid = al_acae AND numexpediente = cu_expediente.numexpd;

			IF lexisteexp = 0 THEN
      	---lexpid := SCA.SQ_EXPEDIENTE.CURRVAL + 1;
        SELECT NVL(MAX(expid), 0) + 1 INTO lexpid FROM SCA.EXPEDIENTE;
        
        BEGIN
          INSERT INTO sca.expediente
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
       		FROM sca.expediente
      	 WHERE personaid = al_acae AND numexpediente = cu_expediente.numexpd;
      END IF;           
   
			lnumsecuencia := 0;
      ---expedientepaso
      SELECT m.numsecuencia
        INTO lnumsecuencia
        FROM sca.estadostupa m
       WHERE m.tiptramite = 'SCA' AND m.tippaso = cu_expediente.tiptran;

			IF lnumsecuencia <= 0 THEN
      	al_error := -5; ---no existe secuencia para la transacción.
        RETURN;
      END IF;
      
      BEGIN
        INSERT INTO sca.expedientepaso
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
      IF cu_expediente.tiptran IN ('RDE', 'RAP', 'ITA') THEN

    /*		SELECT lniddocumento = MAX(documentoid)
          FROM sca.documento;

        lniddocumento := NVL(lniddocumento) + 1;*/

        IF cu_expediente.tiptran IN ('RDE', 'RAP') THEN
          ---lniddocumento := sca.sq_documento.currval + 1;
					SELECT NVL(MAX(docid), 0) + 1 INTO lniddocumento FROM sca.documento;
          
					BEGIN
            INSERT INTO sca.documento
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
            INSERT INTO sca.expedientedocumento
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
            INSERT INTO sca.resolucion
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
          ---lniddocumento := sca.sq_documento.currval + 1;
          SELECT NVL(MAX(docid), 0) + 1 INTO lniddocumento FROM sca.documento;
          
          BEGIN
            INSERT INTO sca.documento
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
            INSERT INTO sca.expedientedocumento
              (expid, nsecuencia, nsecuenciadoc, docid)
            VALUES (lexpid,
                  lnumsecuencia,
                  2,
                  lniddocumento);
                  
            EXCEPTION
            WHEN OTHERS THEN
            	al_error := -2; ---error de BD
          END;    

          ---eia
          BEGIN
            INSERT INTO sca.eia
              (docid, txtresumen)
            VALUES (lniddocumento,
                  cu_expediente.dscbiga);
                  
            EXCEPTION
            WHEN OTHERS THEN
            	al_error := -2; ---error de BD
          END;    

        END IF;

        IF cu_expediente.tiptran = 'ITA' THEN
	        SELECT NVL(MAX(docid), 0) + 1 INTO lniddocumento FROM sca.documento;
      ---    lniddocumento := sca.sq_documento.currval + 1;
          
          BEGIN
            INSERT INTO sca.documento
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
            INSERT INTO sca.expedientedocumento
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
     END IF;

    END LOOP;

END;

END;
/


spool off

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>    
    <title>MINAM - SCA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="Description" content="-- MINAM PERU Ministerio del Medio Ambiente (MINAM).">
	<META NAME="Keywords" CONTENT="PERU,  MINAM ,  Perú, economy, MINISTERIO, AMBIENTE, Statistical , Ministerio del Ambiente, estadisticas, Indicadores, Indicadores Ambientales">
	<link href="<%= request.getContextPath() %>/public/css/web/template_css.css" rel="stylesheet" type="text/css">
	<link href="<%= request.getContextPath() %>/public/css/web/acordionv2.css" rel="stylesheet" type="text/css">
        
        <script type="text/javascript" src="<%= request.getContextPath() %>/public/js/web/includes/acordeon/accordian.pack.js"></script>
	<script>
	function MM_openBrWindow(theURL,winName,features) { //v2.0
	  window.open(theURL,winName,features);
	}
	</script>
        <script language="javascript">
        function doCargarParametros() {
            var frm=document.forms[0];
            frm.action="acaeForm!doCargarParametros";
            frm.submit();  
        }
        
        </script>
  </head>
  <body onload="new Accordian('basic-accordian',5,'header_highlight');">
    <table summary="Main Table for Techshelp" border="0" cellpadding="0" cellspacing="0" width="1000">
      <tr>
        <td colspan="2">
         <%@ include file="/pages/tiles/cabecera.jsp" %>
        </td>
      </tr>
      <tr>
        <td width="240" align="left" valign="top">
          <%@ include file="/pages/tiles/menuADM.jsp" %>
        </td>
        <td width="800" valign="top">
        <table width="90%" class="titulo" align="center" cellspacing="0" cellpadding="0" height="36">
        <tr>
            <td align="center" bgcolor="#F2FEE6" class="titulo">Bienvenidos al Sistema de Registro de Certificaciones Ambientales - SCA </td>
        </tr>
        </table>
        <br />
        <table width="100%" border="0" align="center" cellspacing="0" cellpadding="0">
        <tr>
            <td>
                <font color="Green">¿Qué son Certificaciones Ambientales?</font>
                <div>
                    Las Certificaciones Ambientales son las resoluciones que aprueban el instrumento de gestión ambiental emitida 
                    por la Autoridad Competente de Administración y Ejecución -ACAE, mediante la cual se aprueba la DIA o el EIA 
                    respectivos, al haber cumplido el proyecto o la actividad con los requisitos de forma y fondo establecidos en 
                    el SEIA, y en el que se establecen los compromisos que debe cumplir el proponente para prevenir, mitigar, corregir, 
                    compensar y manejar los impactos ambientales negativos del proyecto o actividad.
                </div>

                <font color="Green">¿Para qué tipo de actividades o proyectos se deben gestionar las Certificaciones Ambientales?</font>
                <div>
                    Todos aquellos relacionados a las políticas, planes y programas de nivel nacional, regional y local que puedan 
                    originar implicaciones ambientales significativas, así como los proyectos de inversión pública, privada o de capital 
                    mixto, que impliquen actividades, construcciones, obras, y otras actividades comerciales y de servicios que puedan 
                    causar impactos ambientales negativos significativos. (Artículo 2º del D.L. 1078).
                </div>
                <font color="Green">¿Es obligatoria la Certificación Ambiental?</font>
                <div>
                No podrá iniciarse la ejecución de proyectos ni actividades de servicios y comercio referidos en el punto anterior y 
                ninguna autoridad nacional, sectorial, regional o local, podrán aprobarlas, autorizarlas, permitirlas, concederlas o 
                habilitarlas si no cuentan previamente con la Certificación Ambiental contenida en la resolución expedida por la respectiva 
                autoridad competente. (Artículo 3º del D.L. 1078).
                </div>
            </td>
        </tr>
        </table>          
        </td>
      </tr>
      <tr>
        <td colspan="2" align="left" background="<%= request.getContextPath() %>/public/img/web/cool-blue_r9_c8.jpg" valign="top">        
          <%@ include file="/pages/tiles/pie.jsp" %>
        </td>
      </tr>
    </table>
  </body>
</html>
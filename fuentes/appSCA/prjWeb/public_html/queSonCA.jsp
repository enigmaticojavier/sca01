<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1"%>
<%
response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>    
    <title>MINAM - RCA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="Description" content="-- MINAM PERU Ministerio del Medio Ambiente (MINAM).">
	<META NAME="Keywords" CONTENT="PERU,  MINAM ,  Per�, economy, MINISTERIO, AMBIENTE, Statistical , Ministerio del Ambiente, estadisticas, Indicadores, Indicadores Ambientales">
	<link href="<%= request.getContextPath() %>/public/css/web/template_css.css" rel="stylesheet" type="text/css">
	<link href="<%= request.getContextPath() %>/public/css/web/acordionv2.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="<%= request.getContextPath() %>/public/js/web/includes/acordeon/accordian.pack.js"></script>
	<script>
	function MM_openBrWindow(theURL,winName,features) { //v2.0
	  window.open(theURL,winName,features);
	}
	</script>
    	
    	<script type="text/javascript" src="public/js/ajax/ajax.js"></script>
  </head>
  <body onload="new Accordian('basic-accordian',5,'header_highlight');">
    <table summary="Main Table for Techshelp" border="0" cellpadding="0" cellspacing="0" width="1000">
      <tr>
        <td colspan="2">
         <%@ include file="pages/tiles/cabecera.jsp" %>
        </td>
      </tr>
      <tr>
        <td width="240" align="left" valign="top">
          <%@ include file="pages/tiles/menu.jsp" %>
        </td>
        <td width="800" valign="top">
        <table width="90%" class="titulo" align="center" cellspacing="0" cellpadding="0" height="36">
        <tr>
            <td align="center" bgcolor="#F2FEE6" class="titulo">Bienvenidos al Registro de Certificaciones Ambientales - RCA </td>
        </tr>
        </table>
        <br />
        
        <img src="<%= request.getContextPath() %>/public/img/web/Foto_CA.jpg" align="right" border="2">
          <font color="Green">�Qu� son Certificaciones Ambientales?</font>
          <br/>
            <div>
                Las Certificaciones Ambientales son las resoluciones que aprueban el instrumento de gesti�n ambiental emitida 
                por la Autoridad Competente de Administraci�n y Ejecuci�n -ACAE, mediante la cual se aprueba la DIA o el EIA 
                respectivos, al haber cumplido el proyecto o la actividad con los requisitos de forma y fondo establecidos en 
                el SEIA, y en el que se establecen los compromisos que debe cumplir el proponente para prevenir, mitigar, corregir, 
                compensar y manejar los impactos ambientales negativos del proyecto o actividad.
            </div>
            <p/>
            <font color="Green">�Para qu� tipo de actividades o proyectos se deben gestionar las Certificaciones Ambientales?</font>
            <br/>
            <div>
                Todos aquellos relacionados a las pol�ticas, planes y programas de nivel nacional, regional y local que puedan 
                originar implicaciones ambientales significativas, as� como los proyectos de inversi�n p�blica, privada o de capital 
                mixto, que impliquen actividades, construcciones, obras, y otras actividades comerciales y de servicios que puedan 
                causar impactos ambientales negativos significativos. (Art�culo 2� del D.L. 1078).
            </div>
            <p/>
            <font color="Green">�Es obligatoria la Certificaci�n Ambiental?</font>
            <br/>
            <div>
            No podr� iniciarse la ejecuci�n de proyectos ni actividades de servicios y comercio referidos en el punto anterior y 
            ninguna autoridad nacional, sectorial, regional o local, podr�n aprobarlas, autorizarlas, permitirlas, concederlas o 
            habilitarlas si no cuentan previamente con la Certificaci�n Ambiental contenida en la resoluci�n expedida por la respectiva 
            autoridad competente. (Art�culo 3� del D.L. 1078).
            </div>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="left" background="public/img/web/cool-blue_r9_c8.jpg" valign="top">        
          <%@ include file="pages/tiles/pie.jsp" %>
        </td>
      </tr>
    </table>
  </body>
</html>
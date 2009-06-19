<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
            <td align="center" bgcolor="#F2FEE6" class="titulo">Bienvenidos al Sistema de Registro de Certificaciones Ambientales - SCA </td>
        </tr>
        </table>
        <br />
          <font color="Green">Normas legales</font>
          <br/>
            <div>
            <font color="Green">Sistema Nacional de Evaluación de Impacto Ambiental</font>
            <br/>
            <ul>
                <li>Ley del Sistema de Evaluación de Impacto Ambiental, Ley Nº 27446 del 23/04/2001. Modificado por:</li>
                <li>Decreto Legislativo que modifica la Ley Nº 27446, Ley del Sistema Nacional de Evaluación de Impacto Ambiental, Decreto Legislativo Nº1078 del 28/06/2008.</li>
            </ul>
            <p/>
            <font color="Green">Gestión Ambiental</font>
            <ul>
                <li>Ley de Creación Organización y Funciones del Ministerio del Ambiente, Decreto Legislativo Nº 1013 del  14/05/2008. Modificado por:</li>
                <li>Decreto Legislativo que modifica disposiciones del Decreto Legislativo Nº 1013, Decreto Legislativo Nº1039 del 26/06/2008.</li>
                <li>Ley General del Ambiente, Ley Nº 28611 del  15/10/2005. Modificado por: </li>
                <li>Decreto Legislativo que modifica la Ley Nº 28611 Ley General del Ambiente, Decreto Legislativo Nº 1055 del 27/06/2008.</li>
                <li>Ley Marco de la Gestión Ambiental, Ley Nº 28245 del 08/06/2004.</li>           </div>
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
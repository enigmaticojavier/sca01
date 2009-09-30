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
        <td width="800" valign="top" colspan="">
        <table width="90%" class="titulo" align="center" cellspacing="0" cellpadding="0" height="36">
        <tr>
            <td align="center" bgcolor="#F2FEE6" class="titulo">Bienvenidos al Registro de Certificaciones Ambientales - RCA </td>
        </tr>
        </table>
            <table width="90%" height= "36">
                <tr>
                    <td>
                        <span style="color: #008000">¿Qué son Certificaciones Ambientales?</span>
          <br/>
            <div>
		La Certificación Ambiental es el título habilitante extendido por la Autoridad 
		Competente que implica la aprobación del instrumento de gestión ambiental 
		(DÍA, EIA-sd, EIA-d) así como la determinación de la viabilidad ambiental de un 
		proyecto de inversión en aquellos aspectos vinculados a la prevención, mitigación,
		corrección, compensación y manejo de los impactos ambientales negativos 
		significativos derivados de los mismos.
            </div>
            <p/>
            <font color="Green">¿Para qué tipo de proyectos se deben gestionar las Certificaciones Ambientales?</font>
            <br/>
            <div>
 		Para todos aquellos proyectos de inversión pública, privada o de capital mixto,
		que por su naturaleza pudieran generar impactos ambientales negativos de carácter 
		significativo y que estén relacionados con los criterios de protección ambiental 
		establecidos.
            </div>
            <p/>
            <font color="Green">Obligatoriedad de la Certificación Ambiental</font>
            <br/>
            <div>
		Toda personal natural o jurídica, de derecho público o privado, nacional o extranjera, 
                que pretenda desarrollar un proyecto de inversión susceptible de generar impactos 
                ambientales negativos de carácter significativo, debe gestionar una 
		Certificación Ambiental ante la Autoridad Competente que corresponda.
            </div>
                    </td>
            <td width="33%" valign="top" align="right">
            <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="209" height="317" title="banner2" align="right">
              <param name="movie" value="public/swf/web/banner2.swf" />
              <param name="quality" value="high" />
              <embed src="public/swf/web/banner2.swf" quality="high" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width="209" height="317"></embed>
            </object>
            </td>
                </tr>
            </table>
        <br />
        </td>      </tr>
      <tr>
        <td colspan="2" align="left" background="public/img/web/cool-blue_r9_c8.jpg" valign="top">        
          <%@ include file="pages/tiles/pie.jsp" %>
        </td>
      </tr>
    </table>
  </body>
</html>
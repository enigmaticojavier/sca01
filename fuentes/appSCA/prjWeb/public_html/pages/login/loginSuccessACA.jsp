<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<html>
  <head>    
    <title>MINAM - SCA</title>
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
    	
    	<script type="text/javascript" src="<%= request.getContextPath() %>/public/js/ajax/ajax.js"></script>
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
          <%@ include file="/pages/tiles/menuACA.jsp" %>
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
                <div align="center">
                <s:property value="txtValor"/>
                </div>                
                <br/>
                <table border="1" cellpadding="0" cellspacing="0" width="90%">
                <tr>
                        <td>Autoridad Sectorial:</td><td><s:property value="acae.txtValor"/></td>
                </tr>
                <tr>
                        <td>Instituci�n / Dependencia:</td><td><s:property value="acae.txtSubSector"/></td>
                </tr>
                <tr>
                        <td>Profesional Responsable:</td><td><s:property value="acae.txtApellidosNombres"/></td>
                </tr>
                <tr>
                        <td>Periodo a informar:</td><td>falta</td>
                </tr>
                <tr>
                        <td>Fecha Actual:</td><td><s:property value="acae.fechaActual"/></td>
                </tr>
                </table>
            </td>
        </tr>
        </table>          
        </td>
      </tr>
      <tr>
        <td colspan="2" align="left" background="../../public/img/web/cool-blue_r9_c8.jpg" valign="top">        
          <%@ include file="/pages/tiles/pie.jsp" %>
        </td>
      </tr>
    </table>
  </body>
</html>
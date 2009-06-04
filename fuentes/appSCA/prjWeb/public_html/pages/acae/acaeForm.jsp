<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
        <script language="javascript">
        function cambiarTipoAcae(){
          var frm=document.forms[0];
          frm.action="acaeForm!buscarInstitucionXTipoAcae";
          frm.submit();  
        }
        function cambiarInstitucion(){
          var frm=document.forms[0];
          frm.action="acaeForm!buscarDependenciaXInstitucion";
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
                <div align="center">
                <s:property value="txtValor"/>
                </div>
                <br/>
                <s:form>  
                <tr>
                <td colspan="2">1. Datos de la Instituci�n</td>
                </tr>
                <s:textfield label="Denominaci�n" name="persona.txtRazonSocial" value="%{persona.txtRazonSocial}"/>
                <s:select label="Tipo Acae" name="tipoAcae" value="tipoAcae" list="parTipoAcae" listKey="codParametro" listValue="txtValor" onchange="javascript:cambiarTipoAcae()"/>
                <s:select label="Institucion" name="clsSector" value="clsSector" list="parInstitucion" listKey="codParametro" listValue="txtValor" onchange="javascript:cambiarInstitucion()"/>
                <s:select label="Dependencia" name="clsSubSector" value="clsSubSector" list="parDependencia" listKey="clsSubSector" listValue="txtSubSector"/>
                <s:textfield label="Domicilio" name="persona.txtDomicilio" value="%{persona.txtDomicilio}"/>
                <s:select label="Departamento" name="ubigeoId" value="ubigeoId" list="ubiDepartamentos" listKey="ubigeoId" listValue="txtDescripcion"/>
                </s:form>
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
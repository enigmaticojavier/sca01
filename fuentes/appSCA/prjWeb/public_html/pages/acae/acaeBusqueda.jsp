<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>

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
                <div align="center">
                <s:property value="txtValor"/>
                </div>
                <br/>
                <s:form action="acaeModifica!doBuscarAcae" method="POST">
                    <s:textfield label="Nombre de la ACAE a consultar" name="acae.txtRazonSocial" value="%{persona.txtRazonSocial}" size="50" maxlength="255"/>
                    <s:submit value="Consultar" align="center"/>                   
                </s:form>
                 <s:set name="acaes" value="acaes" scope="request" />
                    <s:if test="%{acaes==null || acaes.size()==0}">
                        No existen ACAEs que cumplan el criterio de búsqueda
                    </s:if>
                    <s:else>
                        <display:table name="acaes" requestURI="acaeModifica!doBuscarAcae" excludedParams="*" class="dataTable" id="acae" pagesize="10" style="width:600" export="false">
                                                        
                            <display:column property="personaId" title="Id" style="width:5"  media="html" />
                            <display:column property="txtRazonSocial" title="Razón Social" style="width:495" media="html" />
                            <display:column property="txtValor" title="Institución" style="width:100" media="html"/>
                            <display:column href="acaeModifica!doBuscarDatos" paramId="personaId" paramProperty="personaId" title="Modificar" style="width:5%" media="html">
                                Modificar
                            </display:column>
                        </display:table>      
                    </s:else>
                    <s:actionmessage />
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
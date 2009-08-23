<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%
response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <LINK HREF="styles/displaytagsca.css" REL="stylesheet" TYPE="text/css">
    <title><s:text name="label.parametro.titulo"/></title>
    <script language="javascript">
        function cambiarTipoParametro(){
          var frm=document.forms[0];
          frm.action="index";
          frm.submit();
        }
        function nuevoParametro(){
          var frm=document.forms[0];
          frm.action="parametro!input";
          frm.submit();
        }
    </script>
</head>
<body align="center" leftmargin="0" topmargin="0" width="700">
    
    <s:if test="mensajeError.codigo!=null">
    <div class="titleDiv">
    <s:label name="mensajeError.mensaje" label="Mensaje" />
    </div>
    </s:if>
    <!--div class="titleDiv"><s:text name="label.parametro.titulo"/></div-->
    <h1 align="left"><s:text name="label.parametro.titulo"/></h1>
    <form action="">
    <s:select label="Tipo de Parámetro" name="tipParametro" value="tipParametro" list="tipoParametros" listKey="tipParametro" listValue="txtParametro" onchange="javascript:cambiarTipoParametro()"/>
    <br/>
    
    <br/>
        <s:set name="parametros" value="parametros" scope="request" />
        <display:table name="parametros" requestURI="index" excludedParams="*" class="dataTable" id="parametro" pagesize="10" style="width:700" export="false">
            <display:setProperty name="export.csv" value="false" /> 
            <display:setProperty name="export.xls" value="false" />
            <display:setProperty name="export.xml" value="false" />
            <display:setProperty name="export.xls.filename" value="parametro.xls"/> 
            <display:column property="idParametro" title="Id" style="width:10"  />
            <display:column property="txtValor" title="Descripción del Parámetro" style="width:400"  />
            <display:column property="codParametro" title="Valor del Parámetro" style="width:50"  />
            <display:column href="parametro!input" paramId="idParametro" paramProperty="idParametro" title="Detalle" style="width:15" >Detalle</display:column>
            <%/*display:column href="parametro!delete" paramId="parametro.idParametro" paramProperty="idParametro" title="Eliminar" style="width:5%">Eliminar</display:column*/%>
        </display:table>
        <a href="javascript:nuevoParametro()">Nuevo Parametro</a>
        <s:actionmessage />
        
    </form>
</body>
</html>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
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
<body align="center" leftmargin="0" topmargin="0" width="500">
    
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
        <display:table name="parametros" requestURI="index" class="dataTable" id="parametro" pagesize="10" style="width:800">
            <display:column property="idParametro" title="parametro" style="width:1%"  />
            <display:column property="txtValor" title="Valor" style="width:35%"  />
            <display:column property="codParametro" title="codParametro" style="width:5%"  />
            <display:column href="parametro!input" paramId="idParametro" paramProperty="idParametro" title="Ver Detalle" style="width:5%" >Detalle</display:column>
            <display:column href="parametro!delete" paramId="parametro.idParametro" paramProperty="idParametro" title="Eliminar" style="width:5%">Eliminar</display:column>
            <!--paramIs es una propiedad del action -->
            <td class="nowrap">
                <s:url action="parametro!input" id="url">
                    <s:param name="parametro.idParametro" value="idParametro"/>
                </s:url>
                <a href="<s:property value="#url"/>">Edit</a>
            </td>    
            <td class="nowrap">    
                &nbsp;&nbsp;&nbsp;
                <s:url action="parametro!delete.action" id="url">
                    <s:param name="parametro.idParametro" value="idParametro"/>
                </s:url>
                <a href="<s:property value="#url"/>">Delete</a>
            </td>
            
        </display:table>
        <a href="javascript:nuevoParametro()">Nuevo Parametro</a>
        <s:actionmessage />
        
    </form>
</body>
</html>
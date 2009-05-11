<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <title><s:text name="label.parametro.titulo"/></title>
    <script language="javascript">
        function cambiarTipoParametro(){
          var frm=document.forms[0];
          frm.action="parametroInicio";
          frm.submit();
        }
    </script>
</head>
<body>
<div class="titleDiv"><s:text name="label.parametro.titulo"/></div>

    <form action="">
    <s:select name="tipParametro" value="tipParametro" list="tipoParametros" listKey="tipParametro" listValue="txtParametro" onchange="javascript:cambiarTipoParametro()"/>
    
    <h1><s:text name="label.parametro.titulo"/></h1>
    <s:url id="url" action="parametro!input" />
    <a href="<s:property value="#url"/>">Nuevo Parametro</a>
    <br/><br/>
    <table class="borderAll">
        <tr>
            <th><s:text name="label.parametro.idParametro"/></th>
            <th><s:text name="label.parametro.txtValor"/></th>
            <th><s:text name="label.parametro.codParametro"/></th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
    </table>
    
    </form>
</body>
</html>
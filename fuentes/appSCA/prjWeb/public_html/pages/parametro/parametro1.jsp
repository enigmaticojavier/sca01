<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <title><s:text name="label.parametro.titulo"/></title>
    <script language="javascript">
        function cambiarTipoParametro(){
          var frm=document.forms[0];
          frm.action="index";
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
        
        <s:iterator value="parametros" status="status">
            <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
                <td class="nowrap"><s:property value="idParametro"/></td>
                <td class="nowrap"><s:property value="txtValor"/></td>
                <td class="nowrap"><s:property value="codParametro"/></td>
                <td class="nowrap">
                    <s:url action="parametro!input" id="url">
                        <s:param name="parametro.idParametro" value="idParametro"/>
                    </s:url>
                    <a href="<s:property value="#url"/>">Edit</a>
                </td>    
                <td class="nowrap">    
                    &nbsp;&nbsp;&nbsp;
                    <s:url action="parametro!delete" id="url">
                        <s:param name="parametro.idParametro" value="idParametro"/>
                    </s:url>
                    <a href="<s:property value="#url"/>">Delete</a>
                </td>
            </tr>
        </s:iterator>
    </table>
    
    </form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <title><s:text name="label.Parametro"/></title>
</head>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:text name="Proyecto"/></h1>
<s:url id="url" action="crud!input" />
<a href="<s:property value="#url"/>">Add New Parametro</a>
<br/><br/>
<table class="borderAll">
    <tr>
        <th><s:text name="Id"/></th>
        <th><s:text name="Descripcion"/></th>
        <th><s:text name="Valor"/></th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
    </tr>
    <s:iterator value="parametros" status="status">
        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
            <td class="nowrap"><s:property value="idParametro"/></td>
            <td class="nowrap"><s:property value="txtValor"/></td>
            <td class="nowrap"><s:property value="codParametro"/></td>
            <td class="nowrap">
                <s:url action="crud!input" id="url">
                    <s:param name="employee.employeeId" value="employeeId"/>
                </s:url>
                <a href="<s:property value="#url"/>">Edit</a>
            </td>    
            <td class="nowrap">    
                &nbsp;&nbsp;&nbsp;
                <s:url action="crud!delete" id="url">
                    <s:param name="employee.employeeId" value="employeeId"/>
                </s:url>
                <a href="<s:property value="#url"/>">Delete</a>
            </td>
        </tr>
    </s:iterator>
    </table>
</body>
</html>




<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Showcase</title>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>

<body>
<table class="wwFormTable">
<tr>
<td><s:property value="archProponenteFileName" /></td>
</tr>

<tr>
<td><s:property value="archProyectoFileName" /></td>
</tr>

<tr>
<td><s:property value="archExpedienteFileName" /></td>
</tr>



</table>

</body>
</html>
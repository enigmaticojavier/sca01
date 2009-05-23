<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="parametro==null || parametro.idParametro == null">
    <s:set name="title" value="%{'Nuevo Parametro'}"/>
</s:if>
<s:else>
    <s:set name="title" value="%{'Actualización Parametro'}"/>
</s:else>
<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <LINK HREF="styles/displaytagsca.css" REL="stylesheet" TYPE="text/css">
    <title><s:text name="label.parametro.titulo"/></title>
</head>
<body>
<!--div class="titleDiv"><s:text name="label.parametro.titulo"/></div-->
 <h1><s:text name="label.parametro.titulo"/></h1>
<h1><s:property value="#title"/></h1>

<s:actionerror />
<s:actionmessage />
<s:form action="parametro!save.action" method="post">
    <s:if test="parametro==null || parametro.idParametro == null">
        <s:textfield name="parametro.idParametro" disabled="true" value="%{parametro.idParametro}" label="%{getText('label.parametro.idParametro')}" size="20"/>    
    </s:if>
    <s:else>
        <s:textfield name="parametro.idParametro" disabled="false" value="%{parametro.idParametro}" label="%{getText('label.parametro.idParametro')}" size="20"/>
    </s:else>
    <s:if test="parametro==null || parametro.idParametro == null">
        <s:textfield name="parametro.tipParametro" readonly="true" value="%{parametro.tipParametro}" label="%{getText('label.parametro.tipParametro')}" size="40"/>
        <s:textfield name="parametro.txtParametro" readonly="true" value="%{parametro.txtParametro}" label="%{getText('label.parametro.txtParametro')}" size="40"/>
    </s:if>
    <s:else>
        <s:textfield name="parametro.tipParametro" readonly="true" value="%{parametro.tipParametro}" label="%{getText('label.parametro.tipParametro')}" size="40"/>
        <s:textfield name="parametro.txtParametro" readonly="true" value="%{parametro.txtParametro}" label="%{getText('label.parametro.txtParametro')}" size="40"/>
    </s:else>
    <s:textfield name="parametro.codParametro" value="%{parametro.codParametro}" label="%{getText('label.parametro.codParametro')}" size="40"/>
    <s:textfield name="parametro.txtValor" value="%{parametro.txtValor}" label="%{getText('label.parametro.txtValor')}" size="40"/>
    <s:submit value="%{getText('button.label.submit')}"/>
    <s:submit value="%{getText('button.label.cancel')}" name="redirect-action:index"/>
</s:form>
</body>
</html>
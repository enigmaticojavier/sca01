<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1"%>
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
    <script language="javascript">
        function saveParametro(){
          if (validar()){  
              var frm=document.forms[0];
              frm.action="parametro!save.action";
              frm.submit();
          }    
        }
        function validar(){
          var frm=document.forms[0];
          var obj=document.getElementById('parametro.codParametro');
          if (obj.value==""){
             alert("Ingrese Código Parametro");
             obj.focus();
             return false;
          }
          var obj=document.getElementById('parametro.txtValor');
          if (obj.value==""){
             alert("Ingrese Descripción Parametro");
             obj.focus();
             return false;
          }
          return true;
        } 
    </script>
</head>
<body>
 
    
        <!-- Copia Skeleton Ini -->
    <table summary="Main Table for Techshelp" border="0" cellpadding="0" cellspacing="0" width="1000">
      <tr>
        <td colspan="2">
         <%@ include file="/pages/tiles/cabecera.jsp" %>
        </td>
      </tr>
      <tr>
        <td width="240" align="left" valign="top">
          <%@ include file="/pages/tiles/menu.jsp"%>
        </td>
        <td width="560" valign="top">
    <!-- Copia Skeleton Fin -->    
    
    <h1><s:text name="label.parametro.titulo"/></h1>
    <h1><s:property value="#title"/></h1>
    <s:actionerror />
    <s:actionmessage />   
    <s:form theme="simple" method="post">
        <table>    
            <tr>
                <td>
                    <s:label value="%{getText('label.parametro.idParametro')}"/>
                </td>
                <td>
                    <s:if test="parametro==null || parametro.idParametro == null">
                        <s:textfield name="parametro.idParametro" disabled="true" value="%{parametro.idParametro}" size="10"/>
                    </s:if>
                    <s:else>
                        <s:textfield name="parametro.idParametro" readonly="true" value="%{parametro.idParametro}" label="%{getText('label.parametro.idParametro')}" size="10"/>
                    </s:else>
                </td>
            </tr>    
            <tr>
                <td>
                    <s:label value="%{getText('label.parametro.tipParametro')}"/>
                </td>
                <td>
                    <s:textfield name="parametro.tipParametro" readonly="true" value="%{parametro.tipParametro}" size="20"/>
                </td>    
            </tr>    
            <tr>
                <td >
                    <s:label value="%{getText('label.parametro.txtParametro')}"/>
                </td>
                <td>    
                    <s:textfield name="parametro.txtParametro" readonly="true" value="%{parametro.txtParametro}" size="40"/>
                </td>    
            </tr>    
            <tr>
                <td >
                    <s:label value="%{getText('label.parametro.codParametro')}"/>
                </td>
                <td>
                    <s:textfield name="parametro.codParametro" value="%{parametro.codParametro}" size="40"/>
                </td>    
            </tr>    
            <tr>
                <td> 
                    <s:label value="%{getText('label.parametro.txtValor')}"/>
                </td>
                <td>
                    <s:textfield name="parametro.txtValor" value="%{parametro.txtValor}" label="%{getText('label.parametro.txtValor')}" size="40"/>
                </td>    
            </tr>    
            <tr>    
                <td colspan="2">    
                    <!--s:submit value="%{getText('button.label.submit')}"/-->
                    <input type="button" value="Grabar" onclick="javascript:saveParametro()"/>
                    <input type="button" value="Regresar" onclick="javascript:window.history.go(-1)"/>
                </td>    
            </tr>
        </table>
    </s:form>
    
    <!-- Copia Skeleton Ini -->
        </td>
      </tr>
      <tr>
        <td colspan="2" align="left" background="public/img/web/cool-blue_r9_c8.jpg" valign="top" width="100%">        
          <%@ include file="/pages/tiles/pie.jsp" %>
        </td>
      </tr>
      </table>
    <!-- Copia Skeleton Fin -->
    
</body>
</html>
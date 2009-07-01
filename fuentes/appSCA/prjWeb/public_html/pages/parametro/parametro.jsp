<!--%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1"%-->
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html>
<head>
    <link href="<%= request.getContextPath() %>/public/css/web/template_css.css" rel="stylesheet" type="text/css">
    <link href="<%= request.getContextPath() %>/public/css/web/acordionv2.css" rel="stylesheet" type="text/css">
    <LINK HREF="styles/displaytagsca.css" REL="stylesheet" TYPE="text/css">
    <title><s:text name="label.parametro.titulo"/></title>
    <script language="javascript">
        function cambiarTipoParametro(){
          var frm=frmParametro;
          frm.action="index";
          frm.submit();
        }
        function nuevoParametro(){
          var frm=frmParametro;
          frm.action="parametro!input";
          frm.submit();
        }
    </script>
</head>
<body align="center" leftmargin="0" topmargin="0" width="700">
    
    <!-- Copia Skeleton Ini -->
    <table summary="Main Table for Techshelp" border="0" cellpadding="0" cellspacing="0" width="1000">
      <tr>
        <td colspan="2">
         <%@ include file="/pages/tiles/cabecera.jsp" %>
        </td>
      </tr>
      <tr>
        <td width="240" align="left" valign="top">
         
          <%@ include file="/pages/tiles/menuADM.jsp"%>
        </td>
        <td width="560" valign="top">
    <!-- Copia Skeleton Fin -->
        <s:form theme="simple" name="frmParametro">
        <table width="100%">
          <tr> 
            <td bgcolor="Green" colspan="2">
                <font color="White"><s:text name="label.parametro.titulo"/></font>
            </td>
          </tr>
          <tr> 
            <td colspan="2">
                <s:if test="mensajeError.codigo!=null">
                <div class="titleDiv">
                <s:label name="mensajeError.mensaje" label="Mensaje" />
                </div>
                </s:if>
            </td>    
          </tr>
          <tr>   
            <td>
                <s:label value="Tipo de Parámetro"/>
            </td>
            <td>
                <s:select name="tipParametro" value="tipParametro" list="tipoParametros" listKey="tipParametro" listValue="txtParametro" onchange="javascript:cambiarTipoParametro()"/>
            </td>
          </tr>  
          <tr>
            <td colspan="2">
                <s:set name="parametros" value="parametros" scope="request" />
                <display:table name="parametros" requestURI="index" excludedParams="*" class="dataTable" id="parametro" pagesize="10" style="width:100%" export="false">
                    <display:setProperty name="export.csv" value="false" /> 
                    <display:setProperty name="export.xls" value="false" />
                    <display:setProperty name="export.xml" value="false" />
                    <display:setProperty name="export.xls.filename" value="parametro.xls"/> 
                    <display:column property="idParametro" title="Id" style="width:10" media="cvs"/>
                    <display:column property="txtValor" title="Descripción del Parámetro" style="width:400"  />
                    <display:column property="codParametro" title="Valor del Parámetro" style="width:50"  />
                    <display:column href="parametro!input" paramId="idParametro" paramProperty="idParametro" title="Detalle" style="width:15" >Detalle</display:column>
                    <%/*display:column href="parametro!delete" paramId="parametro.idParametro" paramProperty="idParametro" title="Eliminar" style="width:5%">Eliminar</display:column*/%>
                </display:table>
                <a href="javascript:nuevoParametro()">Nuevo Parametro</a>
                <s:actionmessage />
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
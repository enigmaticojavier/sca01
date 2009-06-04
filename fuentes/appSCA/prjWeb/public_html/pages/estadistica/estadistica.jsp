<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>



<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <LINK HREF="styles/displaytagsca.css" REL="stylesheet" TYPE="text/css">
    <title><s:text name="label.proyecto.titulo"/></title>
    <script language="javascript">
        function listarEstadistica(){
              var frm=document.forms[0];
              frm.action="estadistica";
              frm.submit();  
        }
        function validaFecha(fld) {
            var RegExPattern = /^((((0?[1-9]|[12]\d|3[01])[\.\-\/](0?[13578]|1[02])[\.\-\/]((1[6-9]|[2-9]\d)?\d{2}))|((0?[1-9]|[12]\d|30)[\.\-\/](0?[13456789]|1[012])[\.\-\/]((1[6-9]|[2-9]\d)?\d{2}))|((0?[1-9]|1\d|2[0-8])[\.\-\/]0?2[\.\-\/]((1[6-9]|[2-9]\d)?\d{2}))|(29[\.\-\/]0?2[\.\-\/]((1[6-9]|[2-9]\d)?(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00)|00)))|(((0[1-9]|[12]\d|3[01])(0[13578]|1[02])((1[6-9]|[2-9]\d)?\d{2}))|((0[1-9]|[12]\d|30)(0[13456789]|1[012])((1[6-9]|[2-9]\d)?\d{2}))|((0[1-9]|1\d|2[0-8])02((1[6-9]|[2-9]\d)?\d{2}))|(2902((1[6-9]|[2-9]\d)?(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00)|00))))$/;
            var errorMessage = 'Fecha no valida';
            if ((fld.value.match(RegExPattern)) && (fld.value!='')) {
                return true;
            } else {
                alert(errorMessage);
                fld.focus();
                return false;
            } 
        }
    </script>
</head>
<body align="center" leftmargin="0" topmargin="0" width="500">
    
    
    <br>
    
        
    <s:if test="mensajeError.codigo!=null">
    <div class="titleDiv">
    <s:label name="mensajeError.mensaje" label="Mensaje" />
    </div>
    </s:if>
        <s:form theme="simple">
                
            <table>    
            <tr><td align="center">
                <h1 align="left"><s:text name="label.estadistica.titulo"/></h1>        
            </td></tr>
            <tr><td align="center">
                <table>
                  <tr>
                    <td>
                        <s:label value="Periodo"/>
                    </td>    
                    <td>
                        <s:select name="periodo" value="periodo" list="parPeriodos" listKey="periodo" listValue="periodo"/>
                    </td>    
                  </tr>  
                  <tr>
                    <td >
                        <s:label value="Tipo de ACAE" />
                    </td>    
                    <td>
                        <s:select name="tipAcae" value="tipAcae" list="parTipoAcae" listKey="codParametro" listValue="txtValor"/>
                    </td>
                  </tr>   
                  
                  <tr>
                    <td colspan="2" align="center">
                        <s:submit value="%{getText('button.label.buscar')}" onclick="listarEstadistica()"/>        
                    </td>
                  </tr> 
                  
                </table>   
            </td></tr>
            <tr><td>
                <display:table name="estadisticas" requestURI="index" class="dataTable" id="estadistica" pagesize="10" style="width:500">
                    <display:column property="dscClsSector" title="Instituci�n" style="width:5%" group="1"/>
                    <display:column property="dscClsTipificacion" title="Tipo de Estudio" style="width:40%" />
                    <display:column property="evaluacion" title="Evaluacion" style="width:0%" />
                    <display:column property="aprobado" title="Aprobado" style="width:15%" />
                    <display:column property="desaprobado" title="Desaprobado" style="width:15%" />
                    <display:column property="anulado" title="Anulado" style="width:15%" />
                    <display:column property="desistido" title="Desistido" style="width:15%" />
                    <display:column property="total" title="Total" style="width:15%" />
                    <!--paramId es una propiedad del action -->
                </display:table>
                <s:actionmessage />
            </td></tr>
        </table>
        </s:form>
        
    
</body>
</html>
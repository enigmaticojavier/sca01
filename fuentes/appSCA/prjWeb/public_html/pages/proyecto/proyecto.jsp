<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!--%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %-->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>



<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <LINK HREF="styles/displaytagsca.css" REL="stylesheet" TYPE="text/css">
    <!--LINK HREF="styles/fecha.css" REL="stylesheet" TYPE="text/css"-->
    <!--LINK HREF="styles/DatePicker.css" REL="stylesheet" TYPE="text/css"-->
    <!--script src="script/fecha.js"></script-->
    <!--script src="script/DatePicker.js"></script-->
    <title><s:text name="label.proyecto.titulo"/></title>
    <script language="javascript">
        function cambiarTipoAcae(){
          var frm=frmProyecto;
          frm.method="post";
          frm.action="proyecto!buscarInstitucionXTipoAcae";
          frm.submit();  
        }
        function cambiarInstitucion(){
          var frm=frmProyecto;
          frm.method="post";
          frm.action="proyecto!buscarDependenciaXInstitucion";
          frm.submit();
        }
        function buscarProyecto(){
          var valid = validar();  
          //alert(valid);
          //if (valid){
              var frm=frmProyecto;
              frm.method="post";
              frm.action="proyecto!buscarProyecto";
              frm.submit();  
          //}    
        }
        function validar(){
          var obj = document.getElementById('fchExpedienteDesde');
          /*
          if (!validaFecha(obj)){
             obj.focus();
             return false;
          }
          obj = document.getElementById('fchExpedienteHasta');
          if (!validaFecha(obj)){
             obj.focus();
             return false;
          }
          */
          return true;  
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
<body align="center" leftmargin="0" topmargin="0" width="600">
    
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
        <td width="800" valign="top">
    <!-- Copia Skeleton Fin -->
            <s:if test="mensajeError.codigo!=null">
            <div class="titleDiv">
            <s:label name="mensajeError.mensaje" label="Mensaje" />
            </div>
            </s:if>
            <s:form name="frmProyecto" theme="simple" method="POST">
                <table>    
                <tr><td align="center">
                    <h1 align="left"><s:text name="label.proyecto.titulo"/></h1>        
                </td></tr>
                <tr><td align="center">
                    <table>
                      <tr>
                        <td align="left">
                            <s:label value="%{getText('label.proyecto.txtDescripcion')}"/>
                        </td>    
                        <td align="left">
                            <s:textfield name="txtDescripcion" value="%{txtDescripcion}" size="60"/>
                        </td>
                      </tr>   
                      <tr> 
                        <td align="left">
                            <s:label value="Departamento"/>
                        </td>    
                        <td align="left">    
                            <s:select name="ubigeoId" value="ubigeoId" list="ubiDepartamentos" listKey="ubigeoId" listValue="txtDescripcion"/>
                        </td>
                      </tr>    
                      <tr> 
                        <td align="left">    
                            <s:label value="Categoria del Proyecto"/>
                        </td>    
                        <td align="left">    
                            <s:select name="clsTipificacion" value="clsTipificacion" list="parCategProy" listKey="codParametro" listValue="txtValor"/>
                        </td>    
                      </tr>  
                      <tr>
                        <td align="left">
                            <s:label value="%{getText('label.proyecto.fchExpediente')}"/>
                        </td>    
                        <td align="left">
                            <s:label value="Desde"/>
                            <s:textfield name="fchExpedienteDesde" value="%{fchExpedienteDesde}" size="10" maxLength="10">
                               <s:param name="value">
                                 <s:date name="fchExpedienteDesde" format="dd/MM/yyyy" />
                               </s:param>
                            </s:textfield>
                            <s:label value="Hasta"/>
                            <s:textfield name="fchExpedienteHasta" value="%{fchExpedienteHasta}" size="10" maxLength="10">
                               <s:param name="value">
                                 <s:date name="fchExpedienteHasta" format="dd/MM/yyyy" />
                               </s:param>
                            </s:textfield>
                        </td>    
                      </tr>  
                      <tr>
                        <td align="left">
                            <s:label value="Estado del Trámite"/>
                        </td>    
                        <td align="left">
                            <s:select name="estadoTramite" value="estadoTramite" list="parEstadoTramite" listKey="codParametro" listValue="txtValor"/>
                        </td>    
                      </tr>  
                      <tr>
                        <td align="left">
                            <s:label value="Tipo ACAE" />
                        </td>    
                        <td align="left">
                            <s:select name="tipoAcae" value="tipoAcae" list="parTipoAcae" listKey="codParametro" listValue="txtValor" onchange="javascript:cambiarTipoAcae()"/>
                        </td>
                      </tr>   
                      <tr>
                        <td align="left">
                            <s:label value="Institución" />
                        </td>    
                        <td align="left">
                            <s:select name="clsSector" value="clsSector" list="parInstitucion" listKey="codParametro" listValue="txtValor" onchange="javascript:cambiarInstitucion()"/>        
                        </td>
                      </tr>  
                      <tr>
                        <td align="left">
                            <s:label value="Dependencia"/>
                        </td>    
                        <td align="left">
                            <s:select name="clsSubSector" value="clsSubSector" list="parDependencia" listKey="clsSubSector" listValue="txtSubSector"/>        
                        </td>
                      </tr> 
                      <tr>
                        <td colspan="2" align="center">
                            <!--s:submit value="%{getText('button.label.buscar')}" onclick="buscarProyecto()"/--> 
                            <input type="button" value="Buscar" onclick="buscarProyecto()"/>  
                        </td>
                      </tr> 
                    </table>   
                </td></tr>
                <tr><td>
                    
                    <s:set name="proyectos" value="proyectos" scope="request" />
                    <s:if test="%{proyectos==null || proyectos.size()==0}">
                        No existen proyectos que cumplan el criterio de búsqueda
                    </s:if>
                    <s:else>
                        <display:table name="proyectos" requestURI="proyecto!buscarProyecto" excludedParams="*" class="dataTable" id="proyecto" pagesize="10" style="width:800" export="true">
                            <display:setProperty name="export.csv" value="false" /> 
                            <display:setProperty name="export.xls" value="true" />
                            <display:setProperty name="export.xml" value="false" />
                            <display:setProperty name="export.xls.filename" value="proyecto.xls"/> 
                            <display:column property="pryId" title="" style="width:5"  media="html" />
                            <display:column property="txtDescripcion" title="Nombre del Proyecto" style="width:600" media="html excel csv" />
                            <display:column property="dscClsTipificacion" title="Clasificación" style="width:50" media="html excel csv"/>
                            <display:column property="proponente.persona.txtRazonSocial" title="Proponente" style="width:70" media="html excel csv"/>
                            <display:column title="Fec Presen" style="width:10" media="html excel csv">
                                <fmt:formatDate value="${proyecto.fchExpediente}" pattern="dd/MM/yyyy"/> 
                            </display:column> 
                            <display:column property="ubigeo.txtDescripcion" title="Departamento" style="width:15" media="html excel csv"/>
                            <display:column property="estadoTramite" title="Est. Act. Trámite" style="width:10" media="html excel csv"/>
                            <display:column href="proyectoForm!input" paramId="pryId" paramProperty="pryId" title="Detalle" style="width:5%" media="html">
                                Detalle
                            </display:column>
                            <!--paramId es una propiedad del action -->
                        </display:table>      
                    </s:else>
                    <s:actionmessage />
                </td></tr>
            </table>
            </s:form>
    <!-- Copia Skeleton Ini -->
        </td>
      </tr>
      <tr>
        <td colspan="2" align="left" background="public/img/web/cool-blue_r9_c8.jpg" valign="top">        
          <%@ include file="/pages/tiles/pie.jsp" %>
        </td>
      </tr>
      </table>
    <!-- Copia Skeleton Fin -->
    
    
    
</body>
</html>
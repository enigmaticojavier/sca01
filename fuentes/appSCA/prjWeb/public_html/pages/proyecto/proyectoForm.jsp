<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
          var frm=document.forms[0];
          frm.action="proyecto!buscarInstitucionXTipoAcae";
          frm.submit();  
        }
        function cambiarInstitucion(){
          var frm=document.forms[0];
          frm.action="proyecto!buscarDependenciaXInstitucion";
          frm.submit();
        }
        function buscarProyecto(){
          //var valid = validar();  
          //alert(valid);
          //if (valid){
              var frm=document.forms[0];
              frm.action="proyecto!buscarProyecto.action";
              frm.submit();  
          //}    
        }
        function validar(){
          alert('jaj');  
          var obj = document.getElementById('fchExpedienteDesde');
          if (!validaFecha(obj)){
             alert('jaj111');              
             return false;
          }
          alert('jaj1');  
          obj = document.getElementById('fchExpedienteHasta');
          if (!validaFecha(obj)){
             return false;
          }
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
<body align="center" leftmargin="0" topmargin="0" width="500">
    
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
            <s:form theme="simple">
                <table>    
                <tr><td align="center">
                    <h1 align="left"><s:text name="label.proyecto.titulo"/></h1>        
                </td></tr>
                <tr><td align="center">
                    <table>
                      <tr>
                        <td >
                            <s:label value="%{getText('label.proyecto.txtDescripcion')}"/>
                        </td>    
                        <td>
                            <s:textfield name="proyecto.txtDescripcion" value="%{proyecto.txtDescripcion}" size="40" readonly="true"/>
                        </td>
                      </tr>   
                      <tr> 
                        <td>    
                            <s:label value="Categoría del Proyecto"/>
                        </td>    
                        <td>    
                            <s:textfield name="proyecto.dscClsTipificacion" value="%{proyecto.dscClsTipificacion}" size="60" readonly="true"/>
                        </td>    
                      </tr>  
                      <tr> 
                        <td>    
                            <s:label value="Fecha Inicio"/>
                        </td>    
                        <td>    
                            <s:textfield name="proyecto.fchExpediente" value="%{proyecto.fchExpediente}" size="10" readonly="true">
                               <s:param name="value"> 
                                <s:date name="proyecto.fchExpediente" format="dd/MM/yyyy" />
                               </s:param> 
                            </s:textfield>
                        </td>    
                      </tr>  
                      <tr> 
                        <td>    
                            <s:label value="Institución" />
                        </td>    
                        <td>    
                            <s:textfield name="proyecto.dscClsSector" value="%{proyecto.dscClsSector}" size="40" readonly="true"/>
                        </td>    
                      </tr>  
                      <tr> 
                        <td>    
                            <s:label value="Dependencia"/>
                        </td>
                        <td>    
                            <s:textfield name="proyecto.dscClsSubSector" value="%{proyecto.dscClsSubSector}" size="40" readonly="true"/>
                        </td>    
                      </tr>  
                    <!--/table>   
                </td></tr>
                <tr><td align="center">
                    <table-->
                      <tr> 
                        <td>    
                            <s:label value="RUC" />
                        </td>    
                        <td>    
                            <s:textfield name="proyecto.proponente.persona.numDocumentoPer" value="%{proyecto.proponente.persona.numDocumentoPer}" size="10" readonly="true"/>
                        </td>    
                      <tr> 
                        <td>    
                            <s:label value="Razón Social" />
                        </td>    
                        <td>    
                            <s:textfield name="proyecto.proponente.persona.txtRazonSocial" value="%{proyecto.proponente.persona.txtRazonSocial}" size="40" readonly="true"/>
                        </td>    
                      <tr> 
                        <td>    
                            <s:label value="Representante Legal" />
                        </td>    
                        <td>    
                            <s:textfield name="proyecto.proponente.txtNombresRl" value="%{proyecto.proponente.txtNombresRl}" size="40" readonly="true"/>
                        </td>    
                      </tr>  
                    </table>   
                </td></tr>
                <tr><td>
                    
                    <display:table name="expedienteDocumentos" requestURI="proyectoForm" class="dataTable" id="expedienteDocumento" pagesize="10" style="width:620">
                        <display:column property="expedientePaso.expediente.expId" title="Id" style="width:1%"  />
                        <display:column property="expedientePaso.expediente.numExpediente" title="Nro Exp" style="width:40%"  />
                        <display:column title="Fecha Transacción"> 
                            <fmt:formatDate value="${expedienteDocumento.expedientePaso.expediente.fchExpediente}" pattern="dd/MM/yyyy"/> 
                        </display:column>
                        <display:column property="documento.dscTipoDocumento" title="Tipo Documento" style="width:40%"  />
                        <display:column property="expedientePaso.dscTipPaso" title="Descripción" style="width:40%"  />
                        <display:column property="documento.codDocumento" title="Nro Documento" style="width:40%"  />
                        <display:column title="Archivos" style="width:40%"> 
                            <c:forEach var="imagen" items="${expedienteDocumento.documento.lstImagenDocumento}" varStatus="rowCounter">
                                <a href="<%=request.getContextPath()%>/DescargaServlet?file=<c:out value="${imagen.txtRutaImagen}"/>">Ver</a>
                            </c:forEach>
                        </display:column>
                        <%/*display:column href="proyectoExpediente!input" paramId="pryId" paramProperty="pryId" title="Ver Detalle" style="width:5%"--Detalle</isplay:column--*/%>
                        <!--paramId es una propiedad del action -->
                    </display:table>
                    <s:actionmessage />
                </td></tr>
                <tr><td>
                   <a href="javascript:window.history.go(-1)">Retornar</a>&nbsp;        
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
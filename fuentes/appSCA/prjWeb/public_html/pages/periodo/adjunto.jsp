<!--%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1"%-->
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>

<%
    String rutaServer=request.getContextPath();
%>

<html>
<head>
    <title><s:text name="label.proyecto.titulo"/></title>
    
    <LINK HREF="styles/displaytagsca.css" REL="stylesheet" TYPE="text/css">
    <link href="<%= request.getContextPath() %>/public/css/web/template_css.css" rel="stylesheet" type="text/css">
    <link href="<%= request.getContextPath() %>/public/css/web/acordionv2.css" rel="stylesheet" type="text/css">
    
    <script language="javascript">
        function buscarCargarPeriodo(){
            var frm=document.frmArchivo;
            frm.action="upload!list";
            frm.submit();
        }
        
        function cargarArchivoAdjunto(docId){
          var frm=document.frmArchivo;
          var periodoSeleccionado=document.getElementById("periodoSeleccionado").value;
          frm.action="adjunto!cargaArchivoAdjunto?periodoSeleccionado="+periodoSeleccionado+"&docId="+docId;
          if (validarArchivo(frm.archAdjunto)){
             try{
                frm.submit();
             }catch(e){
                alert("Archivo Incorrecto");
                frm.archProponente.focus();
             }   
          }
        }
        function validarArchivo(obj){
          if (obj.value==''){
             alert("Ingrese Archivo");
             obj.focus();
             return false;
          } 
          return true;
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
          <%@ include file="/pages/tiles/menuACA.jsp"%>
        </td>
        <td width="800" valign="top">
    <!-- Copia Skeleton Fin -->
    
            <s:form name="frmBuscar"  theme="simple" action="upload!list" method="POST">
                <table>    
                    <tr>
                        <td align="center">
                            <s:if test="mensajeError.codigo!=null">
                                <div class="titleDiv">
                                    <s:label name="mensajeError.mensaje" label="Mensaje"/>
                                </div>
                            </s:if>
                        </td>
                   </tr>
                </table>   
                <table width="90%" class="titulo" align="center" cellspacing="0" cellpadding="0" height="36">
                <tr>
                    <td align="center" bgcolor="#F2FEE6" class="titulo">Bienvenidos al Sistema de Registro de Certificaciones Ambientales - SCA </td>
                </tr>
                </table>
                <br />
                <table border="1" cellpadding="0" cellspacing="0" width="90%">
                    <tr>
                        <td>ACAE:</td>
                        <td><s:property value="acae.txtValor"/>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>Dependencia:</td>
                        <td><s:property value="acae.txtSubSector"/>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>Profesional Responsable:</td>
                        <td><s:property value="acae.txtApellidosNombres"/>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>
                            Periodo a informar:
                        </td>    
                        <td>
                            <s:select name="periodoSeleccionado" value="periodoSeleccionado" list="parPeriodos" listKey="periodo" listValue="periodo"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <!--input type="button" value="Buscar" onclick="buscarCargarPeriodo()"-->
                            <s:submit value="%{getText('button.label.buscar')}" onclick="buscarCargarPeriodo()"/>        
                        </td>    
                    </tr>
                </table>
            </s:form>
            <s:form name="frmArchivo"  theme="simple" action="archivo!cargaArchivoProponente" method="POST" enctype="multipart/form-data">
            <table>
                <tr>
                    <td align="center">
                        <s:url action="upload" id="urlUpload">
                            <s:param name="periodoSeleccionado" value="periodoSeleccionado"/>
                        </s:url>
                        <h3 align="left"><a href="<s:property value="#urlUpload"/>">Carga de Operaciones</a></h3>
                    </td>
                    <td>
                        &nbsp;
                    </td>
                    <td align="center">
                        <s:url action="adjunto" id="urlAdjunto">
                            <s:param name="periodoSeleccionado" value="periodoSeleccionado"/>
                        </s:url>
                        <h3 align="left"><a href="<s:property value="#urlAdjunto"/>">Envio de Documentos Adjuntos</a></h3>
                    </td>
                </tr>
            </table>
                
            <display:table name="expedienteDocumentos" requestURI="adjunto" class="dataTable" id="expedienteDocumento" pagesize="20" style="width:720">
                <display:column property="expedientePaso.expediente.expId" title="Id" style="width:1%"/>
                <display:column property="documento.docId" title="docId" style="width:1%" media="html excel csv"/>
                <display:column property="expedientePaso.expediente.proyecto.txtDescripcion" title="Proyecto" style="width:500"/>
                <display:column property="expedientePaso.tipPaso" title="Tran" style="width:1"/>
                <display:column title="Fec Trans" style="width:1"> 
                    <fmt:formatDate value="${expedienteDocumento.expedientePaso.expediente.fchExpediente}" pattern="dd/MM/yyyy"/>
                </display:column>
                <display:column property="expedientePaso.tipPaso" title="Doc" style="width:5"/>
                <display:column title="Archivos" style="width:80"> 
                    <table>
                        <tr>
                            <td>
                                <s:file name="archAdjunto" disabled="false" size="25"/>
                            </td>
                        </tr>
                    </table>
                </display:column>
                <display:column title="" style="width:5"> 
                    <input type="button" name="cargar" readonly="true" size="1" value="cargar"                  
                    onclick="cargarArchivoAdjunto('<c:out value="${expedienteDocumento.documento.docId}"/>')" />
                </display:column>
                <display:column title="Archivos" style="width:40%"> 
                    <c:forEach var="imagen" items="${expedienteDocumento.documento.lstImagenDocumento}" varStatus="rowCounter">
                        <a href="<%=request.getContextPath()%>/DescargaServlet?file=<c:out value="${imagen.txtRutaImagen}"/>"><c:out value="${imagen.txtNomArchivo}"/></a>
                    </c:forEach>
                </display:column>
            </display:table>
            </s:form>
            
    <!-- Copia Skeleton Ini -->
        </td>
      </tr>
      <tr>
        <td colspan="2" align="left" background="<%=request.getContextPath()%>public/img/web/cool-blue_r9_c8.jpg" valign="top">
          <%@ include file="/pages/tiles/pie.jsp" %>
        </td>
      </tr>
      </table>
    <!-- Copia Skeleton Fin -->
        
    
</body>
</html>





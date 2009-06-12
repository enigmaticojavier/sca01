<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1"%>
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
    <script language="javascript">
        function cargarArchivoProponente(){
          var frm=document.frmArchivo;
          frm.action="archivo!cargaArchivoProponente";
          if (validarArchivo(frm.archProponente)){
             try{
                frm.submit();
             }catch(e){
                alert("Archivo Incorrecto");
                frm.archProponente.focus();
             }   
          }
        }
        function cargarArchivoProyecto(){
          var frm=document.frmArchivo;
          frm.action="archivo!cargaArchivoProyecto";
          if (validarArchivo(frm.archProyecto)){
            try{
                frm.submit();
            }catch(e){
                alert("Archivo Incorrecto");
                frm.archProyecto.focus();
            }   
          }   
        }
        function cargarArchivoExpediente(){
          var frm=document.frmArchivo;
          frm.action="archivo!cargaArchivoExpediente";
          if (validarArchivo(frm.archExpediente)){
             try{
                frm.submit();
             }catch(e){
                alert("Archivo Incorrecto");
                frm.archExpediente.focus();
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
          <%@ include file="/pages/tiles/menu.jsp"%>
        </td>
        <td width="800" valign="top">
    <!-- Copia Skeleton Fin -->
    
                <s:form name="frmArchivo"  theme="simple" action="doUpload" method="POST" enctype="multipart/form-data">
                <table>    
                    <tr>
                        <td align="center">
                            <s:if test="mensajeError.codigo!=null">
                            <div class="titleDiv">
                            <s:label name="mensajeError.mensaje" label="Mensaje" />
                            </div>
                            </s:if>
                        </td>
                   </tr>
                   <tr>
                        <td align="center">
                            <h1 align="left"><s:text name="label.proyecto.titulo"/></h1>
                        </td>
                    </tr>
                </table>        
                <table>    
                    <tr>
                        <td align="center">
                                <table border="1">
                                  <tr>
                                    <td>
                                        <s:label value="No"/>
                                    </td>
                                    <td >
                                        <s:label value="Archivo"/>
                                    </td>    
                                    <td>
                                        <s:label value="Ubicación"/>
                                    </td>
                                    <td>
                                        <s:label value="Estado"/>
                                    </td>
                                  </tr>
                                  <tr>
                                    <td width="18">
                                        <s:label value="1"/>
                                    </td>
                                    <td width="100">
                                        <s:label value="Proponente"/>
                                    </td>    
                                    <td width="500">
                                        <s:if test="estadoCargaProponente.equals('true')">
                                            <s:file name="archProponente" disabled="false" size="40"/>
                                            <input type="button" name="cargar" readonly="true" size="300" value="cargar" onclick="cargarArchivoProponente();"/>
                                        </s:if>
                                        <s:if test="estadoCargaProponente.equals('false')">
                                            <s:file name="archProponente" disabled="true" size="40"/>
                                            <input type="button" name="cargar" disabled size="300" value="cargar" onclick="cargarArchivoProponente();"/>
                                        </s:if>
                                    </td>
                                    <td width="10">
                                        <s:if test="estadoCargaProponente.equals('true')">
                                            <s:checkbox name="chkEstado" disabled="true" value="true"/>
                                        </s:if>
                                        <s:if test="estadoCargaProponente.equals('false')">    
                                            <s:checkbox name="chkEstado" disabled="true" value="false"/>
                                        </s:if>    
                                    </td>
                                  </tr>
                            <!--/s:form-->
                            <!--s:form name="frmArchivoProyecto"  theme="simple" action="doUpload" method="POST" enctype="multipart/form-data"-->
                                  <tr>
                                    <td width="18">
                                        <s:label value="2"/>
                                    </td>
                                    <td width="100">
                                        <s:label value="Proyecto"/>
                                    </td>    
                                    <td width="500">
                                        <s:if test="estadoCargaProyecto.equals('true')">
                                            <s:file name="archProyecto" disabled="false" size="40"/>
                                            <input type="button" name="cargar" readonly="true" size="300" value="cargar" onclick="cargarArchivoProyecto();"/>
                                        </s:if>
                                        <s:if test="estadoCargaProyecto.equals('false')">
                                            <s:file name="archProyecto" disabled="true" size="40"/>
                                            <input type="button" name="cargar" disabled size="300" value="cargar" onclick="cargarArchivoProyecto();"/>
                                        </s:if>
                                    </td>
                                    <td width="10">
                                        <s:if test="estadoCargaProyecto.equals('true')">
                                            <s:checkbox name="chkEstado" disabled="true" value="true"/>
                                        </s:if>
                                        <s:if test="estadoCargaProyecto.equals('false')">    
                                            <s:checkbox name="chkEstado" disabled="true" value="false"/>
                                        </s:if>    
                                    </td>
                                  </tr>
                            <!--/s:form-->
                            <!--s:form name="frmArchivoExpediente"  theme="simple" action="doUpload" method="POST" enctype="multipart/form-data"-->
                                  <tr>
                                    <td width="18">
                                        <s:label value="3"/>
                                    </td>
                                    <td width="100">
                                        <s:label value="Expediente"/>
                                    </td>    
                                    <td width="500">
                                        <s:if test="estadoCargaExpediente.equals('true')">
                                            <s:file name="archExpediente" disabled="false" size="40"/>
                                            <input type="button" name="cargar" readonly="true" size="300" value="cargar" onclick="cargarArchivoExpediente();"/>
                                        </s:if>
                                        <s:if test="estadoCargaExpediente.equals('false')">
                                            <s:file name="archExpediente" disabled="true" size="40"/>
                                            <input type="button" name="cargar" disabled size="300" value="cargar" onclick="cargarArchivoExpediente();"/>
                                        </s:if>
                                    </td>
                                    <td width="10">
                                        <s:if test="estadoCargaExpediente.equals('true')">
                                            <s:checkbox name="chkEstado" disabled="true" value="true"/>
                                        </s:if>
                                        <s:if test="estadoCargaExpediente.equals('false')">    
                                            <s:checkbox name="chkEstado" disabled="true" value="false"/>
                                        </s:if>    
                                    </td>
                                  </tr>
                                </table>  
                  </td>
                </tr>
            </table>        
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





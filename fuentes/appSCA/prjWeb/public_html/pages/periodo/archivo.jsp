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
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="Description" content="-- MINAM PERU Ministerio del Medio Ambiente (MINAM).">
	<META NAME="Keywords" CONTENT="PERU,  MINAM ,  Perú, economy, MINISTERIO, AMBIENTE, Statistical , Ministerio del Ambiente, estadisticas, Indicadores, Indicadores Ambientales">
	<link href="<%= request.getContextPath() %>/public/css/web/template_css.css" rel="stylesheet" type="text/css">
	<link href="<%= request.getContextPath() %>/public/css/web/acordionv2.css" rel="stylesheet" type="text/css">
        
        <!--LINK HREF="styles/displaytagsca.css" REL="stylesheet" TYPE="text/css"-->
        
        <script type="text/javascript" src="<%= request.getContextPath() %>/public/js/web/includes/acordeon/accordian.pack.js"></script>
	<script>
	function MM_openBrWindow(theURL,winName,features) { //v2.0
	  window.open(theURL,winName,features);
	}
	</script>
    	
    	<script type="text/javascript" src="<%= request.getContextPath() %>/public/js/ajax/ajax.js"></script>
    
        <script language="javascript">
        function buscarCargarPeriodo(){
            var frm=document.frmArchivo;
            frm.action="upload!list";
            frm.submit();
        }
        
        function cargarArchivoProponente(){
          var frm=document.frmArchivo;
          var periodoSeleccionado=document.getElementById("periodoSeleccionado").value;
          frm.action="upload!cargaArchivoProponente?periodoSeleccionado="+periodoSeleccionado;
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
          var periodoSeleccionado=document.getElementById("periodoSeleccionado").value;
          frm.action="upload!cargaArchivoProyecto?periodoSeleccionado="+periodoSeleccionado;
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
          var periodoSeleccionado=document.getElementById("periodoSeleccionado").value;
          frm.action="upload!cargaArchivoExpediente?periodoSeleccionado="+periodoSeleccionado;
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
                        <td>Autoridad Sectorial:</td>
                        <td><s:property value="acae.txtValor"/>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>Institución / Dependencia:</td>
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
                <table >
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
                <table border="1" cellpadding="0" cellspacing="0">
                    <tr>
                        <td align="center">
                                <table border="1">
                                  <tr>
                                    <td colspan="5" bgcolor="Green"><font color="White">Carga de Operaciones</font></td>
                                  </tr>
                                  <tr>
                                    <td bgcolor="Green">
                                        <font color="White"><s:label value="No"/></font>
                                    </td>
                                    <td bgcolor="Green">
                                        <font color="White"><s:label value="Archivo"/></font>
                                    </td>    
                                    <td bgcolor="Green">
                                        <font color="White"><s:label value="Ubicación"/></font>
                                    </td>
                                    <td bgcolor="Green">
                                        <font color="White"><s:label value="Fecha Carga"/></font>
                                    </td>
                                    <td bgcolor="Green">
                                        <font color="White"><s:label value="Estado"/></font>
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
                                        <s:if test="estadoCargaProponente!=null">
                                            <s:if test="estadoCargaProponente.equals('true')">
                                                <s:file name="archProponente" disabled="false" size="40"/>
                                                <input type="button" name="cargar" readonly="true" size="300" value="cargar" onclick="cargarArchivoProponente();"/>
                                            </s:if>
                                            <s:if test="estadoCargaProponente.equals('false')">
                                                <s:file name="archProponente" disabled="true" size="40"/>
                                                <input type="button" name="cargar" disabled size="300" value="cargar" onclick="cargarArchivoProponente();"/>
                                            </s:if>
                                        </s:if>
                                        <s:else>
                                            &nbsp;
                                        </s:else>
                                    </td>
                                    <td>
                                        &nbsp;
                                        <s:textfield name="controlEnvio.fchEnvioPro" value="%{controlEnvio.fchEnvioPro}" size="10" readonly="true">
                                           <s:param name="value"> 
                                            <s:date name="controlEnvio.fchEnvioPro" format="dd/MM/yyyy" />
                                           </s:param> 
                                        </s:textfield>
                                    </td>
                                    <td width="10">
                                        <s:if test="estadoCargaProponente!=null">
                                            <s:if test="estadoCargaProponente.equals('true')">
                                                <s:checkbox name="chkEstado" disabled="true" value="true"/>
                                            </s:if>
                                            <s:if test="estadoCargaProponente.equals('false')">    
                                                <s:checkbox name="chkEstado" disabled="true" value="false"/>
                                            </s:if>
                                        </s:if>
                                        <s:else>
                                            &nbsp;
                                        </s:else>
                                    </td>
                                  </tr>
                                  
                                  <tr>
                                    <td width="18">
                                        <s:label value="2"/>
                                    </td>
                                    <td width="100">
                                        <s:label value="Proyecto"/>
                                    </td>    
                                    <td width="500">
                                        <s:if test="estadoCargaProyecto!=null">
                                            <s:if test="estadoCargaProyecto.equals('true')">
                                                <s:file name="archProyecto" disabled="false" size="40"/>
                                                <input type="button" name="cargar" readonly="true" size="300" value="cargar" onclick="cargarArchivoProyecto();"/>
                                            </s:if>
                                            <s:if test="estadoCargaProyecto.equals('false')">
                                                <s:file name="archProyecto" disabled="true" size="40"/>
                                                <input type="button" name="cargar" disabled size="300" value="cargar" onclick="cargarArchivoProyecto();"/>
                                            </s:if>
                                        </s:if>
                                        <s:else>
                                            &nbsp;
                                        </s:else>
                                    </td>
                                    <td>
                                        &nbsp;
                                        <s:textfield name="controlEnvio.fchEnvioPry" value="%{controlEnvio.fchEnvioPry}" size="10" readonly="true">
                                           <s:param name="value"> 
                                            <s:date name="controlEnvio.fchEnvioPry" format="dd/MM/yyyy" />
                                           </s:param> 
                                        </s:textfield>
                                    </td>
                                    <td width="10">
                                        <s:if test="estadoCargaProyecto!=null">
                                            <s:if test="estadoCargaProyecto.equals('true')">
                                                <s:checkbox name="chkEstado" disabled="true" value="true"/>
                                            </s:if>
                                            <s:if test="estadoCargaProyecto.equals('false')">    
                                                <s:checkbox name="chkEstado" disabled="true" value="false"/>
                                            </s:if>
                                        </s:if>
                                        <s:else>
                                            &nbsp;
                                        </s:else>
                                    </td>
                                  </tr>
                            
                                  <tr>
                                    <td width="18">
                                        <s:label value="3"/>
                                    </td>
                                    <td width="100">
                                        <s:label value="Expediente"/>
                                    </td>    
                                    <td width="500">
                                        <s:if test="estadoCargaExpediente!=null">
                                            <s:if test="estadoCargaExpediente.equals('true')">
                                                <s:file name="archExpediente" disabled="false" size="40"/>
                                                <input type="button" name="cargar" readonly="true" size="300" value="cargar" onclick="cargarArchivoExpediente();"/>
                                            </s:if>
                                            <s:if test="estadoCargaExpediente.equals('false')">
                                                <s:file name="archExpediente" disabled="true" size="40"/>
                                                <input type="button" name="cargar" disabled size="300" value="cargar" onclick="cargarArchivoExpediente();"/>
                                            </s:if>
                                        </s:if>
                                        <s:else>
                                            &nbsp;
                                        </s:else>
                                    </td>
                                    <td>
                                        &nbsp;
                                        <s:textfield name="controlEnvio.fchEnvioExp" value="%{controlEnvio.fchEnvioExp}" size="10" readonly="true">
                                           <s:param name="value"> 
                                            <s:date name="controlEnvio.fchEnvioExp" format="dd/MM/yyyy" />
                                           </s:param> 
                                        </s:textfield>
                                    </td>
                                    <td width="10">
                                        <s:if test="estadoCargaExpediente!=null">
                                            <s:if test="estadoCargaExpediente.equals('true')">
                                                <s:checkbox name="chkEstado" disabled="true" value="true"/>
                                            </s:if>
                                            <s:if test="estadoCargaExpediente.equals('false')">    
                                                <s:checkbox name="chkEstado" disabled="true" value="false"/>
                                            </s:if>
                                        </s:if>
                                        <s:else>
                                            &nbsp;
                                        </s:else>
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





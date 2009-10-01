<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
response.addHeader("Pragma","no-cache"); 
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); 
response.addHeader("Cache-Control","pre-check=0,post-check=0"); 
response.setDateHeader("Expires",0); 
%>
<html>
  <head>    
    <title>MINAM - RCA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="Description" content="-- MINAM PERU Ministerio del Medio Ambiente (MINAM).">
	<META NAME="Keywords" CONTENT="PERU,  MINAM ,  Per�, economy, MINISTERIO, AMBIENTE, Statistical , Ministerio del Ambiente, estadisticas, Indicadores, Indicadores Ambientales">
	<link href="<%= request.getContextPath() %>/public/css/web/template_css.css" rel="stylesheet" type="text/css">
	<link href="<%= request.getContextPath() %>/public/css/web/acordionv2.css" rel="stylesheet" type="text/css">
        
        <script type="text/javascript" src="<%= request.getContextPath() %>/public/js/web/includes/acordeon/accordian.pack.js"></script>
	<script>
	function MM_openBrWindow(theURL,winName,features) { //v2.0
	  window.open(theURL,winName,features);
	}
	</script>
        <script language="javascript">
        function doCargarParametros() {
            var frm=document.forms[0];
            frm.method="post";
            frm.action="acaeModifica!doCargarParametros";
            frm.submit();  
        }
        function enviar(form){
          if (validar(form)){  
              form.submit();
          }    
        }
        function validar(form){          
          var obj=document.getElementById('usuario.usuario');
          if (obj.value==""){
             alert("Ingrese Usuario");
             obj.focus();
             return false;
          }
          var obj=document.getElementById('usuario.codClave');
          if (obj.value==""){
             alert("Ingrese Clave");
             obj.focus();
             return false;
          } else {
            var obj2=document.getElementById('codClave2');
            if (obj.value!=obj2.value) {
                alert("Las claves deben ser iguales");
                obj2.focus();
                return false;
            }
          }          
          return true;
        } 
        </script>
  </head>
  <body onload="new Accordian('basic-accordian',5,'header_highlight');">
    <table summary="Main Table for Techshelp" border="0" cellpadding="0" cellspacing="0" width="1000">
      <tr>
        <td colspan="2">
         <%@ include file="/pages/tiles/cabecera.jsp" %>
        </td>
      </tr>
      <tr>
        <td width="240" align="left" valign="top">
          <%@ include file="/pages/tiles/menuADM.jsp" %>
        </td>
        <td width="800" valign="top">
        <table width="90%" class="titulo" align="center" cellspacing="0" cellpadding="0" height="36">
        <tr>
            <td align="center" bgcolor="#F2FEE6" class="titulo">Bienvenidos al Registro de Certificaciones Ambientales - RCA </td>
        </tr>
        </table>
        <br />
        <table width="100%" border="0" align="center" cellspacing="0" cellpadding="0">
        <tr>
            <td>
                <div align="center">
                <s:property value="txtValor"/>
                </div>
                <br/>
                <s:form action="acaeModifica!doActualizarAcae" method="POST">
                <s:actionerror />
                <s:fielderror /> 
                <tr>
                <td colspan="2" bgcolor="Green"><font color="White">1. Datos de la Instituci�n</font></td>
                </tr>                
                <s:select label="Tipo ACAE" name="tipoAcae" value="tipoAcae" list="parTipoAcae" listKey="codParametro" listValue="txtValor" onchange="javascript:doCargarParametros()"/>
                <s:select label="ACAE" name="clsSector" value="clsSector" list="parInstitucion" listKey="codParametro" listValue="txtValor" onchange="javascript:doCargarParametros()"/>
                <s:textfield label="Denominaci�n" name="persona.txtRazonSocial" value="%{persona.txtRazonSocial}" size="50" maxlength="255"/>
                
                <s:textfield label="Domicilio" name="persona.txtDomicilio" value="%{persona.txtDomicilio}" size="50" maxlength="255"/>
                <s:select label="Departamento" name="codDepartamento" value="codDepartamento" list="ubiDepartamentos" listKey="codDepartamento" listValue="txtDescripcion" onchange="javascript:doCargarParametros()" emptyOption="SELECCCIONAR"/>
                <s:select label="Provincia" name="codProvincia" value="codProvincia" list="ubiProvincia" listKey="codProvincia" listValue="txtDescripcion" onchange="javascript:doCargarParametros()" emptyOption="SELECCCIONAR"/>
                <s:select label="Distrito" name="codDistrito" value="codDistrito" list="ubiDistrito" listKey="codDistrito" listValue="txtDescripcion" emptyOption="SELECCCIONAR" />
                <s:textfield label="Tel�fono" name="persona.telefono" value="%{persona.telefono}" size="15" maxlength="15"/>
                <s:textfield label="Fax" name="persona.fax" value="%{persona.fax}" size="15" maxlength="15"/>
                <s:textfield label="Web" name="persona.txtWeb" value="%{persona.txtWeb}" size="50" maxlength="255"/>
                <tr>
                <td colspan="2" bgcolor="Green"><font color="White">2. Datos del personal responsable</font></td>                
                </tr>
                <s:textfield label="Tel�fono" name="acae.telefonoGer" value="%{acae.telefonoGer}" size="10" maxlength="15"/>
                <s:textfield label="Anexo" name="acae.anexoGer" value="%{acae.anexoGer}" size="10" maxlength="15"/>
                <s:textfield label="Email" name="persona.txtEmail" value="%{persona.txtEmail}" size="50"/>
                <s:textfield label="Apellidos y Nombres" name="acae.txtApellidosNombres" value="%{acae.txtApellidosNombres}" size="50" maxlength="500"/>
                <s:textfield label="Cargo" name="acae.txtCargo" value="%{acae.txtCargo}" size="50" maxlength="255"/>
                <tr>
                <td colspan="2" bgcolor="Green"><font color="White">3. Informaci�n para el Sistema</font></td>                
                </tr>
                <s:textfield label="Usuario" name="usuario.usuario" value="%{usuario.usuario}" size="50" maxlength="50"/>
                <s:password label="Clave" name="usuario.codClave" value="%{usuario.codClave}" size="50" maxlength="50" /> 
                <s:password label="Repetir Clave" name="codClave2" value="%{codClave2}" size="50" maxlength="50"/>
                <s:hidden name="usuario.tipUsuario" value="ACA"/>
                <s:hidden name="persona.personaId" value="%{persona.personaId}"/>
                <tr>
                <td>
                <input type="button" value="Aceptar" onclick="javascript:enviar(this.form)" align="center"/>
                </td>
                </tr>
                
                </s:form>
            </td>
        </tr>
        </table>          
        </td>
      </tr>
      <tr>
        <td colspan="2" align="left" background="<%= request.getContextPath() %>/public/img/web/cool-blue_r9_c8.jpg" valign="top">        
          <%@ include file="/pages/tiles/pie.jsp" %>
        </td>
      </tr>
    </table>
  </body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>SINIA - Sistema Nacional de Informaci�n Ambiental</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="Description" content="-- MINAM PERU Ministerio del Medio Ambiente (MINAM).">
	<META NAME="Keywords" CONTENT="PERU,  MINAM ,  Perú, economy, MINISTERIO, AMBIENTE, Statistical , Ministerio del Ambiente, estadisticas, Indicadores, Indicadores Ambientales">

	<link href="public/css/web/template_css.css" rel="stylesheet" type="text/css">
	<link href="public/css/web/acordionv2.css" rel="stylesheet" type="text/css">
        <script language="javascript">
        function cambiarTipoAcae(){
          var frm=document.forms[0];
          frm.action="acaeForm!buscarInstitucionXTipoAcae";
          frm.submit();  
        }
        function cambiarInstitucion(){
          var frm=document.forms[0];
          frm.action="acaeForm!buscarDependenciaXInstitucion";
          frm.submit();
        }
        </script>
        
	<script>
	function MM_openBrWindow(theURL,winName,features) { //v2.0
	  window.open(theURL,winName,features);
	}
	</script>
    <script type="text/javascript" src="public/js/web/includes/acordeon/accordian.pack.js"></script>
    <style type="text/css">
<!--
.encabezado2 {
	color: #000000;
	font-size: 10px;
	background-repeat: no-repeat;
	font-weight:bold;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

}
.style1 {
font-family:"Trebuchet MS";
font-size:10px;
color: #FFFFFF;
}
.style2 {color: #FFFFFF}

-->
    </style>
</head>
<body onload="new Accordian('basic-accordian',5,'header_highlight');">

<table summary="Main Table for Techshelp" border="0" cellpadding="0" cellspacing="0" width="1000">
  <tr>

    <td align="left" background="public/img/web/cool-blue_r1_c14.jpg" valign="top">

	<table width="100%" border="0" cellpadding="0" cellspacing="0"> 
	  <tr align="left" valign="top">
        <td colspan="6"><object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="1000" height="138" id="logo(0)" align="middle">
          <param name="allowScriptAccess" value="sameDomain" />
          <param name="movie" value="public/swf/web/banner_sinia.swf" />
          <param name="quality" value="high" />
          <param name="bgcolor" value="#ffffff" />
          <embed src="public/swf/web/banner_sinia.swf" quality="high" bgcolor="#ffffff" width="1000" height="138" name="logo(0)" align="middle" allowscriptaccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />        
</object></td>
	  </tr>
	 	<tr align="center" valign="middle">
        <td align="center" valign="middle" height="24" width="170" background="public/img/web/boton-superior-inactivo.gif" class="encabezado2" ><a href="index.php" target="_parent">Inicio</a></td>
        <td align="center" valign="middle" height="24" width="170" background="public/img/web/boton-superior-inactivo.gif" class="encabezado2"><a href="index1.php" target="_parent">Qu&eacute; es SINIA</a></td>
        <td align="center" valign="middle" height="24" width="170" background="public/img/web/boton-superior-inactivo.gif" class="encabezado2"><a href="index2.php" target="_parent">Antecedentes</a></td>
        <td align="center" valign="middle" height="24" width="170" background="public/img/web/boton-superior-inactivo.gif" class="encabezado2"><a href="index4.php" target="_parent">Objetivos</a></td>
        <td align="center" valign="middle" height="24" width="170" background="public/img/web/boton-superior-inactivo.gif" class="encabezado2"><a href="index3.php" target="_parent">Marco Legal</a></td>
        <td align="center" valign="middle" height="24" width="170" background="public/img/web/boton-superior-inactivo.gif" class="encabezado2"><a href="contacto.php" target="_parent">Contáctenos</a></td>
	 	</tr>   
</table>
	</td>
  </tr>
<!--  <tr>
    <td align="left" background="public/img/web/cool-blue_r3_c2.jpg" valign="top">
	<table border="0" cellpadding="0" cellspacing="0" width="790">
      <tbody>
	  <tr align="left" valign="top">
        <td class="date" background="public/img/web/cool-blue_r3_c1.jpg" valign="middle" width="181"></td>
        <td height="32" valign="middle"><span class="pathway">Home</span></td>
      </tr>
      </tbody>
	</table>
	</td>
  </tr>-->
  <tr>

    <td align="left" valign="top">
	<table summary="Main Table for Content, Navigation and Information" border="0" cellpadding="0" cellspacing="0" width="100%">
      
	  <tr align="left" valign="top">
        <td width="240" background="public/img/web/cool-blue_r5_c1.jpg">
			  
              <script language="javascript">

function MM_openBrWindow2(theURL,winName,features) {
  window.open(theURL,winName,features);
}
//-->
            </script>
			<div id="basic-accordian" >
              <!--Parent of the Accordion-->
              <!--Start of each accordion item-->
              
			  <!--Heading of the accordion ( clicked to show n hide ) -->
              <!--Prefix of heading (the DIV above this) and content (the DIV below this) to be same... eg. foo-header & foo-content-->                            
              <div id="test1-header" class="accordion_headings"> <a href="#0">SCA</a></div>
			  <div id="test1-content">
                <!--DIV which show/hide on click of header-->
                <!--This DIV is for inline styling like padding...-->
                <div class="accordion_child">
                  <table width="100%">
                    
                    <tr>
                      <td width="4%">&nbsp;</td>
                      <td width="96%"><a href="<%= request.getContextPath() %>/acaeForm!list">Inscripci�n del ACAE</a></td>
                    </tr>
                    <tr>
                      <td colspan="2"><img src="public/img/web/fondo_menu.jpg" width="220" height="1" /></td>
                    </tr>
                    
                    <tr>
                      <td width="4%">&nbsp;</td>
                      <td width="96%"><a href="index.php?idTipoElementoInformacion=10">Consulta / Modificaci�n de Datos</a></td>
                    </tr>
                    <tr>
                      <td colspan="2"><img src="public/img/web/fondo_menu.jpg" width="220" height="1" /></td>
                    </tr>                    
                    <tr>
                      <td width="4%">&nbsp;</td>
                      <s:url action="index" id="urlParametro">
                        <s:param name="parametro.idParametro" value="idParametro"/>
                      </s:url>
                      <td width="96%"><a href="<s:property value="#urlParametro"/>">Configuraci�n de Par�metros</a></td>
                    </tr>
                    <tr>
                      <td colspan="2"><img src="public/img/web/fondo_menu.jpg" width="220" height="1" /></td>
                    </tr>
                    <tr>
                      <td width="4%">&nbsp;</td>
                      <td width="96%"><a href="<%= request.getContextPath() %>/doLogout.action">Cerrar Sesi�n</a></td>
                    </tr>
                    <tr>
                      <td colspan="2"><img src="public/img/web/fondo_menu.jpg" width="220" height="1" /></td>
                    </tr>
                  </table>
                </div>
		      </div>
			  
             
              <div id="test2-header" class="accordion_headings" ><a href="#0">Cont�ctenos</a></div>
			  <!--Heading of the accordion ( clicked to show n hide ) -->
              <!--Prefix of heading (the DIV above this) and content (the DIV below this) to be same... eg. foo-header & foo-content-->
              <div id="test2-content">
                <!--DIV which show/hide on click of header-->
                <!--This DIV is for inline styling like padding...-->
                <div class="accordion_child">
                  <table width="100%">
                    <tr>
                      <td bgcolor="#F8FBFF"><a href="contacto.php" target="_parent">Comentarios y Sugerencias </a></td>
                    </tr>
                    <tr>
                      <td><img src="public/img/web/fondo_menu.jpg" alt="1" width="220" height="1" /></td>
                    </tr>
                  </table>
                </div>
              </div>
			  <!--End of each accordion item-->
            </div>
			<!--End of accordion parent-->
            <table width="100%" border="0" height="2">
              <tr>
                <td height="1" bgcolor="#92D050"></td>
              </tr>
            </table>
            <br />
            
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p><br>
            </p></td>
        <td width="579"><table border="0" cellpadding="0" cellspacing="0" width="100%">

          <tr>
            <th width="100%" align="center" valign="top" scope="col">
			<br>
            <table width="650" class="titulo" align="center" cellspacing="0" cellpadding="0" height="36">
                <tr>
                    <td align="center" bgcolor="#F2FEE6" class="titulo">
                    Bienvenidos al Sistema de Informaci�n de Certificaciones Ambientales - SCA</td>
                </tr>
            </table>
            <s:property value="txtValor"/>
	
            <div id="div_buscar">
            <s:form>  
              <tr>
                <td colspan="2">1. Datos de la Instituci�n</td>
              </tr>
              <s:textfield label="Denominaci�n" name="txtRazonSocial" value="" />              
              <s:select label="Tipo Acae" name="tipoAcae" value="tipoAcae" list="parTipoAcae" listKey="codParametro" listValue="txtValor" onchange="javascript:cambiarTipoAcae()"/>
              <s:select label="Institucion" name="clsSector" value="clsSector" list="parInstitucion" listKey="codParametro" listValue="txtValor" onchange="javascript:cambiarInstitucion()"/>
              <s:select label="Dependencia" name="clsSubSector" value="clsSubSector" list="parDependencia" listKey="clsSubSector" listValue="txtSubSector"/>
            </s:form>
            </div>
	</th>
     </tr>
    </table>
    </td>
    </tr>
    </table>
  </td>
  </tr>
  <tr>
    <td align="left" background="public/img/web/cool-blue_r9_c8.jpg" valign="top"><table summary="Footer Table for Terms links and Top of page link" border="0" cellpadding="0" cellspacing="0" width="100%">
      <tr>
        <td width="239" align="center" valign="middle" bgcolor="#7DBB3B">&nbsp;</td>
        <td width="577" align="center" valign="middle" bgcolor="#7DBB3B"><a href="http://www.minam.gob.pe" class="pie">MINISTERIO DEL AMBIENTE</a><br />
          <span class="style1">Email: <a href="mailto:sinia@minam.gob.pe" class="pie">sinia@minam.gob.pe</a>,<br />
    Tel�fono:(511)   2255370 / Fax:(511) 2255369 <br />
    Av. Guardia Civil N� 205 - San Borja<br />
    Lima Per�</span></td>
        <td width="184" align="center" valign="middle" bgcolor="#7DBB3B">&nbsp;</td>
      </tr>
    </table>
    </td>
  </tr>

</table>
</body>

</html>

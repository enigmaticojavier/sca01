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
    
        <s:actionerror />
        <s:fielderror />

        <s:if test="mensajeError.codigo!=null">
        <div class="titleDiv">
        <s:label name="mensajeError.mensaje" label="Mensaje" />
        </div>
        </s:if>
            <s:form theme="simple" action="doUpload" method="POST" enctype="multipart/form-data">
                <table>    
                <tr><td align="center">
                    <h1 align="left"><s:text name="label.proyecto.titulo"/></h1>        
                </td></tr>
                <tr><td align="center">
                    <table>
                      <tr>
                        <td >
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
                        <td >
                            <s:label value="1"/>
                        </td>
                        <td >
                            <s:label value="Proponente"/>
                        </td>    
                        <td>
                            <s:file name="archProponente" label="File"/>
                        </td>
                        <td>
                            <s:label value="Estado"/>
                        </td>
                      </tr>
                      <tr>
                        <td >
                            <s:label value="2"/>
                        </td>
                        <td >
                            <s:label value="Proyecto"/>
                        </td>    
                        <td>
                            <s:file name="archProyecto" label="File"/>
                        </td>
                        <td>
                            <s:label value="Estado"/>
                        </td>
                      </tr>
                      <tr>
                        <td >
                            <s:label value="3"/>
                        </td>
                        <td >
                            <s:label value="Expediente"/>
                        </td>    
                        <td>
                            <s:file name="archExpediente" label="File"/>
                        </td>
                        <td>
                            <s:label value="Estado"/>
                        </td>
                      </tr>
                      <tr>
                        <td colspan="4" >
                            <s:submit />      
                        </td>
                      </tr>
                    </table>   
                </td></tr>
                <tr><td>
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





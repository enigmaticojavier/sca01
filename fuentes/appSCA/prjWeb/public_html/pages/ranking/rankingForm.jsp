<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>
<%@page import="gob.pe.minam.sca.pojo.Usuario"%>


<html>
<head>
    <link href="<%= request.getContextPath() %>/public/css/web/template_css.css" rel="stylesheet" type="text/css">
    <link href="<%= request.getContextPath() %>/public/css/web/acordionv2.css" rel="stylesheet" type="text/css">
    
    <LINK HREF="styles/displaytagsca.css" REL="stylesheet" TYPE="text/css">
    
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
    
        <s:if test="mensajeError.codigo!=null">
        <div class="titleDiv">
        <s:label name="mensajeError.mensaje" label="Mensaje" />
        </div>
        </s:if>
            <s:form theme="simple">
                <table>    
                <tr>
                    <td bgcolor="Green">
                        <font color="White">1. Proponente</font>
                    </td>
                </tr>
                <tr><td align="center">
                    <table>
                      <tr>
                        <td >
                            <s:label value="Proponente"/>
                            <!--s:label value="%{proponente}"/-->
                        </td>    
                        <td>
                            <s:textarea rows="3" cols="60" name="dscProponente" value="%{txtAgrupacion}" readonly="true" width="100" />
                        </td>
                      </tr>   
                    </table>   
                </td></tr>
                <tr>
                    <td bgcolor="Green">
                        <font color="White">2. Proyectos</font>
                    </td>
                </tr>
                <tr><td>
                    <display:table name="proyectos" requestURI="rankingForm!input?clsTipificacion=${clsTipificacion}&estadoTramite=${estadoTramite}&tipoPersoneria=${tipoPersoneria}&proponente=${proponente}&tipoAcae=${tipoAcae}&clsSector=${clsSector}&clsSubSector=${clsSubSector}&codDepartamento=${codDepartamento}&codProvincia=${codProvincia}&codDistrito=${codDistrito}&anoPeriodo=${anoPeriodo}&tipoDoc=${tipoDoc}&ordenRanking=${ordenRanking}&idAgrupacion=${idAgrupacion}&txtAgrupacion=${txtAgrupacion}" excludedParams="*" class="dataTable" id="proyecto" pagesize="10" style="width:800" export="true">
                    <!--display:table name="proyectos" requestURI="ReportServlet?clsTipificacion=${clsTipificacion}&estadoTramite=${estadoTramite}&proponente=${proponente}&tipoAcae=${tipoAcae}&clsSector=${clsSector}&clsSubSector=${clsSubSector}&codDepartamento=${codDepartamento}&codProvincia=${codProvincia}&codDistrito=${codDistrito}&anoPeriodo=${anoPeriodo}&tipoDoc=${tipoDoc}" excludedParams="*" class="dataTable" id="proyecto" pagesize="10" style="width:800" export="true"-->
                           <display:setProperty name="export.csv" value="false" /> 
                            <display:setProperty name="export.xls" value="true" />
                            <display:setProperty name="export.xml" value="false" />
                            <display:setProperty name="export.xls.filename" value="proyecto.xls"/> 
                            <display:column property="pryId" title="" style="width:1"  media="csv" />
                            <display:column property="actividad" title="Actividad" style="width:100" media="html excel csv" />
                            <display:column property="txtDescripcion" title="Nombre del Proyecto" style="width:600" media="html excel csv" />
                            <display:column property="dscClsTipificacion" title="Clasi<br>fica" style="width:50" media="html excel csv"/>
                            <display:column property="proponente.persona.txtRazonSocial" title="Proponente" style="width:70" media="html excel csv"/>
                            <display:column title="Fec Pres" style="width:10" media="html excel csv">
                                <fmt:formatDate value="${proyecto.fchExpediente}" pattern="dd/MM/yyyy"/> 
                            </display:column> 
                            <display:column property="ubigeo.txtDescripcion" title="Departamento" style="width:15" media="html excel csv"/>
                            <display:column property="estadoTramite" title="Est. Act.<br>Trámite" style="width:10" media="html excel csv"/>
                    </display:table>
                    <s:actionmessage />
                </td></tr>
            </table>
            </s:form>
        
</body>
</html>
<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!--%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="gob.pe.minam.sca.pojo.Usuario"%>
<%@page import="java.util.Date"%>

<head>
    
    <style type="text/css">
      body { background-color: white; }
      #tabs {
        display: block;
        float: left;
        width: 100%;
      }
      a.tab {
        border-collapse: collapse;
        border-style: solid solid none solid;
        border-color: black;
        border-width: 1px 1px 0px 1px;
        background-color: green;
        padding: 2px 0.5em 0px 0.5em;
        margin-top: 4px;
        margin-right: 2px;
        font-family: arial;
        text-decoration: none;
        float: left;
      }
      a.tab:hover {
        border-color: black;
        background-color: white;
      }
      .panel { border: solid 0px black; background-color: white; padding: 2px; height: 210px; overflow: auto;}
    </style>
    <script language="JavaScript" type="text/javascript">
      var panels = new Array('panel1', 'panel2');
      var selectedTab = null;
      function showPanel(tab, name)
      {
        if (name=='undefined' || name=='null' || name==''){ name="panel1";selectedTab=tab;}
        //alert("tab-->"+tab+"-->name-->"+name);
        if (selectedTab)
        {
          //alert("selectedTab-->"+selectedTab);
          selectedTab.style.backgroundColor = '';
          selectedTab.style.paddingTop = '';
          selectedTab.style.marginTop = '4px';
          selectedTab = tab;
        }else{
            var pan;
            if (name=="panel1"){
                pan=document.getElementById('tab1');
            }else{
                pan=document.getElementById('tab2');
            }
            pan.style.backgroundColor = '';
            pan.style.paddingTop = '';
            pan.style.marginTop = '4px';
            selectedTab = pan;
        }
        selectedTab.style.backgroundColor = 'white';
        selectedTab.style.paddingTop = '6px';
        selectedTab.style.marginTop = '0px';
        for(i = 0; i < panels.length; i++)
        {
          document.getElementById(panels[i]).style.display = (name == panels[i]) ? 'block':'none';
        }
        return false;
      }
    </script>
    
    <link href="<%= request.getContextPath() %>/public/css/web/template_css.css" rel="stylesheet" type="text/css">
    <link href="<%= request.getContextPath() %>/public/css/web/acordionv2.css" rel="stylesheet" type="text/css">
    <LINK HREF="<%= request.getContextPath() %>/styles/displaytagsca.css" REL="stylesheet" TYPE="text/css">
  
    <script src="public/js/AnchorPosition.js"></script>
    <script src="public/js/date.js"></script>
    <script src="public/js/PopupWindow.js"></script>
    <script src="public/js/CalendarPopup.js"></script>
    <title><s:text name="label.proyecto.titulo"/></title>
    <script language="javascript">
        function cambiarDepartamento(){
          var frm=frmProyecto;
          frm.method="post";
          frm.action="ranking!buscarProvXDpto";
          frm.submit();  
        }
        function cambiarProvincia(){
          var frm=frmProyecto;
          frm.method="post";
          frm.action="ranking!buscarDistXProv";
          frm.submit();   
        }
        function cambiarTipoAcae(){
          var frm=frmProyecto;
          frm.method="post";
          frm.action="ranking!buscarInstitucionXTipoAcae";
          frm.submit();  
        }
        function cambiarInstitucion(){
          var frm=frmProyecto;
          frm.method="post";
          frm.action="ranking!buscarDependenciaXInstitucion";
          frm.submit();
        }
        function cambiarTipoPersoneria(){
          var frm=frmProyecto;
          frm.method="post";
          frm.action="ranking!buscarProponente";
          frm.submit();  
        }
        function buscarProyecto(){
          var valid = validar();  
          //alert(valid);
          //if (valid){
              var frm=frmProyecto;
              frm.method="post";
              frm.action="ranking!buscarRanking";
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
        
        function mostrarReporte(clsTipificacion,estadoTramite,tipoPersoneria,proponente,tipoAcae,clsSector,clsSubSector,codDepartamento,codProvincia,codDistrito,anoPeriodo,tipoDoc,ordenRanking){
            var frm = document.frmProyecto;
            var txtClsTipificacion = frm.clsTipificacion.options[frm.clsTipificacion.selectedIndex].text;
            var txtEstadoTramite = frm.estadoTramite.options[frm.estadoTramite.selectedIndex].text;
            var txtTipoPersoneria = frm.tipoPersoneria.options[frm.tipoPersoneria.selectedIndex].text;
            var txtProponente = frm.proponente.options[frm.proponente.selectedIndex].text;
            var txtTipoAcae = frm.tipoAcae.options[frm.tipoAcae.selectedIndex].text;
            var txtClsSector = frm.clsSector.options[frm.clsSector.selectedIndex].text;
            var txtClsSubSector = frm.clsSubSector.options[frm.clsSubSector.selectedIndex].text;
            var txtCodDepartamento = frm.codDepartamento.options[frm.codDepartamento.selectedIndex].text;
            var txtCodProvincia = frm.codProvincia.options[frm.codProvincia.selectedIndex].text;
            var txtCodDistrito = frm.codDistrito.options[frm.codDistrito.selectedIndex].text;
            var txtAnoPeriodo = frm.anoPeriodo.options[frm.anoPeriodo.selectedIndex].text;
            var txtTipoDoc = frm.tipoDoc.options[frm.tipoDoc.selectedIndex].text;
            frm.action="rankingForm!mostrarReporte?clsTipificacion="+clsTipificacion+"&estadoTramite="+estadoTramite+"&tipoPersoneria="+tipoPersoneria+"&proponente="+proponente+"&tipoAcae="+tipoAcae+"&clsSector="+clsSector+"&clsSubSector="+clsSubSector+"&codDepartamento="+codDepartamento+"&codProvincia="+codProvincia+"&codDistrito="+codDistrito+"&anoPeriodo="+anoPeriodo+"&tipoDoc="+tipoDoc+"&ordenRanking="+ordenRanking;
            frm.action=frm.action+"&txtClsTipificacion="+txtClsTipificacion+"&txtEstadoTramite="+txtEstadoTramite+"&txtTipoPersoneria="+txtTipoPersoneria+"&txtProponente="+txtProponente+"&txtTipoAcae="+txtTipoAcae+"&txtClsSector="+txtClsSector+"&txtClsSubSector="+txtClsSubSector+"&txtCodDepartamento="+txtCodDepartamento+"&txtCodProvincia="+txtCodProvincia+"&txtCodDistrito="+txtCodDistrito+"&txtAnoPeriodo="+txtAnoPeriodo+"&txtTipoDoc="+txtTipoDoc;
            window.open (frm.action,"Ranking","menubar=0,resizable=1,scrollbars=1,status=0,toolbar=0"); 
        }
        

    </script>
    
    <SCRIPT LANGUAGE="JavaScript" ID="jscal">
     var calDesde = new CalendarPopup("divCalendarDesde");
     calDesde.showNavigationDropdowns();
     var calHasta = new CalendarPopup("divCalendarHasta");
     calHasta.showNavigationDropdowns();
     document.write(getCalendarStyles());
    </SCRIPT>
    
    
</head>
<body onload="showPanel(document.getElementById('idUrl'),'<%=session.getAttribute("panel")%>')" align="center" leftmargin="0" topmargin="0" width="600">
    
    <!-- Copia Skeleton Ini -->
    <jsp:useBean id="fecIni" class="java.util.Date"/>
        
    <table summary="Main Table for Techshelp" border="0" cellpadding="0" cellspacing="0" width="1000">
      <tr>
        <td colspan="2">
         <%@ include file="/pages/tiles/cabecera.jsp" %>
        </td>
      </tr>
      <tr>
        <td width="240" align="left" valign="top">
           <% Usuario usuario =  (Usuario)session.getAttribute("Usuario");
           if (usuario!=null && usuario.getTipUsuario().equals("ACA")){%>
                 <%@ include file="/pages/tiles/menuACA.jsp"%>
           <%}else{%>
                <%@ include file="/pages/tiles/menu.jsp"%>
           <%}%>
        </td>
        <td width="800" valign="top">
    <!-- Copia Skeleton Fin -->
            
            <s:if test="mensajeError.codigo!=null">
            <div class="titleDiv">
            <s:label name="mensajeError.mensaje" label="Mensaje" />
            </div>
            </s:if>
            <s:form name="frmProyecto" theme="simple" method="POST">
                <s:hidden name="panel" value="panel"/>
                
                <s:hidden name="hidClsTipificacion" value="hidClsTipificacion"/>
                <s:hidden name="hidEstadoTramite" value="hidEstadoTramite"/>
                <s:hidden name="hidProponente" value="hidProponente"/>
                <s:hidden name="hidTipoAcae" value="hidTipoAcae"/>
                <s:hidden name="hidClsSector" value="hidClsSector"/>
                <s:hidden name="hidClsSubSector" value="hidClsSubSector"/>
                <s:hidden name="hidCodDepartamento" value="hidCodDepartamento"/>
                <s:hidden name="hidCodProvincia" value="hidCodProvincia"/>
                <s:hidden name="hidCodDistrito" value="hidCodDistrito"/>
                <s:hidden name="hidAnoPeriodo" value="hidAnoPeriodo"/>
                <s:hidden name="hidTipoDoc" value="hidTipoDoc"/>
                
                <table>    
                <tr>
                    <td bgcolor="Green">
                        <font color="White"><s:text name="label.ranking.titulo1"/></font>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table>
                          <tr> 
                            <td align="left">    
                                <s:label value="Seleccione ranking"/>
                            </td>    
                            <td align="left">    
                                <s:select name="ordenRanking" value="ordenRanking" list="selOrdenRanking" listKey="codParametro" listValue="txtValor"/>
                            </td>    
                          </tr>    
                        </table>
                    </td>
                </tr>
                <tr>
                    <td bgcolor="Green">
                        <font color="White"><s:text name="label.ranking.titulo2"/></font>
                    </td>
                </tr>
                
                <tr><td align="center">
                        
                </td></tr>
                <tr><td align="center">
                    <div id="tabs">
                    <a href="" id="idUrl"/>
                    <a href="" class="tab" onmousedown="return event.returnValue = showPanel(this, 'panel1');" id="tab1" onclick="return false;">Básico</a>
                    <a href="" class="tab" onmousedown="return event.returnValue = showPanel(this, 'panel2');" id="tab2" onclick="return false;">Avanzado</a>
                    </div>
                    <!--div class="panel" id="panel1" style="display: block"-->
                    <div class="panel" id="panel1" style="display: none">
                    <table>
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
                            <s:label value="Estado del Trámite"/>
                        </td>    
                        <td align="left">
                            <s:select name="estadoTramite" value="estadoTramite" list="parEstadoTramite" listKey="codParametro" listValue="txtValor"/>
                        </td>    
                      </tr>  
                      <tr>
                        <td align="left">
                            <s:label value="Tipo de Personería del Proponente"/>
                        </td>    
                        <td align="left">
                            <s:select name="tipoPersoneria" value="tipoPersoneria" list="selTipoPersoneria" listKey="codParametro" listValue="txtValor" onchange="javascript:cambiarTipoPersoneria()"/>
                        </td>    
                      </tr>  
                      <tr>
                        <td align="left">
                            <s:label value="Proponente"/>
                        </td>    
                        <td align="left">
                            <s:select name="proponente" value="proponente" list="selProponente" listKey="personaId" listValue="txtRazonSocial"/>
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
                            <s:select name="clsSubSector" value="clsSubSector" list="parDependencia" listKey="personaId" listValue="txtRazonSocial"/>
                        </td>
                      </tr> 
                    </table>   
                    </div>
                    <div class="panel" id="panel2" style="display: none">
                      <table>
                      <tr> 
                        <td align="left">    
                            <s:label value="Departamento"/>
                        </td>    
                        <td align="left">    
                            <s:select name="codDepartamento" value="codDepartamento" list="ubiDepartamentos" listKey="codDepartamento" listValue="txtDescripcion" onchange="javascript:cambiarDepartamento()" emptyOption="SELECCCIONAR"/>
                        </td>    
                      </tr>    
                      <tr> 
                        <td align="left">    
                            <s:label value="Provincia"/>
                        </td>    
                        <td align="left">    
                            <s:select name="codProvincia" value="codProvincia" list="ubiProvincia" listKey="codProvincia" listValue="txtDescripcion" onchange="javascript:cambiarProvincia()" emptyOption="SELECCCIONAR"/>
                        </td>    
                      </tr>
                      <tr> 
                        <td align="left">    
                            <s:label value="Distrito"/>
                        </td>    
                        <td align="left">    
                            <s:select name="codDistrito" value="codDistrito" list="ubiDistrito" listKey="codDistrito" listValue="txtDescripcion" emptyOption="SELECCCIONAR" />
                        </td>    
                      </tr>
                      <tr> 
                        <td align="left">    
                            <s:label value="Año de Presentación"/>
                        </td>    
                        <td align="left">    
                            <s:select name="anoPeriodo" value="anoPeriodo" list="selAnoPeriodo" listKey="periodo" listValue="periodo"/>
                        </td>    
                      </tr>    
                      <tr> 
                        <td align="left">    
                            <s:label value="Tipo de Documento que incluyó en el trámite"/>
                        </td>    
                        <td align="left">    
                            <s:select name="tipoDoc" value="tipoDoc" list="parTipoDoc" listKey="codParametro" listValue="txtValor"/>
                        </td>    
                      </tr>    
                      </table>
                    </div>
                        <table>
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
                    <s:if test="%{showMsgFind==true && (proyectosResumen==null || proyectosResumen.size()==0)}">
                        No existen proyectos que cumplan el criterio de búsqueda
                    </s:if>
                    <s:else>
                        <display:table name="proyectosResumen" requestURI="ranking!buscarRanking?clsTipificacion=${clsTipificacion}&estadoTramite=${estadoTramite}&tipoPersoneria=${tipoPersoneria}&proponente=${proponente}&tipoAcae=${tipoAcae}&clsSector=${clsSector}&clsSubSector=${clsSubSector}&codDepartamento=${codDepartamento}&codProvincia=${codProvincia}&codDistrito=${codDistrito}&anoPeriodo=${anoPeriodo}&tipoDoc=${tipoDoc}" excludedParams="*" class="dataTable" id="proyecto" pagesize="10" style="width:800" export="false">
                            <display:setProperty name="export.csv" value="false" /> 
                            <display:setProperty name="export.xls" value="true" />
                            <display:setProperty name="export.xml" value="false" />
                            <display:setProperty name="export.xls.filename" value="proyecto.xls"/> 
                            <display:column property="fila" title="Fila" style="width:70" media="html excel csv"/>
                            <display:column property="txt" title="${txtOrdenRanking}" style="width:70" media="html excel csv"/>
                            <display:column property="contador" title="contador" style="width:10" media="html excel csv"/>
                            <display:column paramId="personaId" paramProperty="id" title="Detalle" style="width:5%" media="html">
                                <a target="_blank" href="rankingForm!input?clsTipificacion=${clsTipificacion}&estadoTramite=${estadoTramite}&tipoPersoneria=${tipoPersoneria}&proponente=${proponente}&tipoAcae=${tipoAcae}&clsSector=${clsSector}&clsSubSector=${clsSubSector}&codDepartamento=${codDepartamento}&codProvincia=${codProvincia}&codDistrito=${codDistrito}&anoPeriodo=${anoPeriodo}&tipoDoc=${tipoDoc}&ordenRanking=${ordenRanking}&idAgrupacion=${proyecto.id}&txtAgrupacion=${proyecto.txt}">
                                    Detalle
                                </a>
                            </display:column>
                            <!--paramId es una propiedad del action -->
                        </display:table>   
                        
                    </s:else>
                    
                    <s:if test="%{showMsgFind==true && (proyectosResumen==null || proyectosResumen.size()==0)}">
                    </s:if>
                    <s:else>                        
                    <!--a target="_blank" href="rankingForm!mostrarReporte?clsTipificacion=${clsTipificacion}&estadoTramite=${estadoTramite}&tipoPersoneria=${tipoPersoneria}&proponente=${proponente}&tipoAcae=${tipoAcae}&clsSector=${clsSector}&clsSubSector=${clsSubSector}&codDepartamento=${codDepartamento}&codProvincia=${codProvincia}&codDistrito=${codDistrito}&anoPeriodo=${anoPeriodo}&tipoDoc=${tipoDoc}"-->
                    <a href="#" onclick="javascript:mostrarReporte('${clsTipificacion}','${estadoTramite}','${tipoPersoneria}','${proponente}','${tipoAcae}','${clsSector}','${clsSubSector}','${codDepartamento}','${codProvincia}','${codDistrito}','${anoPeriodo}','${tipoDoc}','${ordenRanking}')">
                        Reporte
                    </a>
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
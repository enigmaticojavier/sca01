<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
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
    
    
    
    <s:if test="mensajeError.codigo!=null">
    <div class="titleDiv">
    <s:label name="mensajeError.mensaje" label="Mensaje" />
    </div>
    </s:if>
    <!--div class="titleDiv"><s:text name="label.parametro.titulo"/></div-->
    <h1 align="left"><s:text name="label.proyecto.titulo"/></h1>
    
        <form >
                <div>
                <table>
                <s:textfield label="%{getText('label.proyecto.txtDescripcion')}" name="txtDescripcion" value="%{txtDescripcion}" size="40"/>
                <s:select label="Departamento" name="ubigeoId" value="ubigeoId" list="ubiDepartamentos" listKey="ubigeoId" listValue="txtDescripcion"/>
                <s:select label="Categoria del Proyecto" name="clsTipificacion" value="clsTipificacion" list="parCategProy" listKey="codParametro" listValue="txtValor"/>
                </table>
                </div>
                <div>
                <!--s:label label="Fecha de Presentacion" /-->
                <s:textfield label="%{getText('label.proyecto.fchExpedienteDesde')}" name="fchExpedienteDesde" value="%{fchExpedienteDesde}" size="10">
                   <s:param name="value">
                     <s:date name="fchExpedienteDesde" format="dd/MM/yyyy" />
                   </s:param>
                </s:textfield>
                <!--input type=button value="select" onclick="displayDatePicker('fchExpedienteDesde', this);"-->
                
                <s:textfield label="%{getText('label.proyecto.fchExpedienteHasta')}" name="fchExpedienteHasta" value="%{fchExpedienteHasta}" size="10">
                   <s:param name="value">
                     <s:date name="fchExpedienteHasta" format="dd/MM/yyyy" />
                   </s:param>
                </s:textfield>
                
                </div>
                <div>
                <s:select label="Estado del Tramite" name="estadoTramite" value="estadoTramite" list="parEstadoTramite" listKey="codParametro" listValue="txtValor"/>
                </div>
                <div>
                <s:select label="Tipo Acae" name="tipoAcae" value="tipoAcae" list="parTipoAcae" listKey="codParametro" listValue="txtValor" onchange="javascript:cambiarTipoAcae()"/>
                </div>
                <div>
                <s:select label="Institucion" name="clsSector" value="clsSector" list="parInstitucion" listKey="codParametro" listValue="txtValor" onchange="javascript:cambiarInstitucion()"/>
                </div>
                <div>
                <s:select label="Dependencia" name="clsSubSector" value="clsSubSector" list="parDependencia" listKey="clsSubSector" listValue="txtSubSector"/>
                </div>
                
                <s:submit value="%{getText('button.label.submit')}" onclick="buscarProyecto()"/>
        
        
        <display:table name="proyectos" requestURI="index" class="dataTable" id="parametro" pagesize="10" style="width:800">
            <display:column property="pryId" title="proyecto.pryId" style="width:1%"  />
            <display:column property="txtDescripcion" title="proyecto.txtDescripcion" style="width:35%"  />
            <display:column property="clsTipificacion" title="proyecto.clsTipificacion" style="width:35%"  />
            <display:column property="personaId" title="proyecto.personaId" style="width:35%"  />
            <display:column property="fchExpediente" title="proyecto.fchExpediente" style="width:35%"  />
            <display:column property="ubigeoId" title="proyecto.ubigeoId" style="width:35%"  />
            <display:column property="ubigeoId" title="proyecto.estado" style="width:5%"  />
            <display:column href="proyecto!input" paramId="pryId" paramProperty="pryId" title="Ver Detalle" style="width:5%" >Detalle</display:column>
            <!--paramId es una propiedad del action -->
        </display:table>
        
        <s:actionmessage />
        
    </form>
</body>
</html>
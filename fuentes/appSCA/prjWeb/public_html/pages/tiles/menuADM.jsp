<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
	<td>			  
	        <script language="javascript">
		function MM_openBrWindow2(theURL,winName,features) {
	  		window.open(theURL,winName,features);
		}
	        </script>
	   <div id="basic-accordian" >
              <!--Parent of the Accordion-->
              <!--Start of each accordion item-->
              <div id="test-header" class="accordion_headings header_highlight" ><a href="#0">SCA</a></div>
	      <!--Heading of the accordion ( clicked to show n hide ) -->
              <!--Prefix of heading (the DIV above this) and content (the DIV below this) to be same... eg. foo-header & foo-content-->
              
		<div id="test-content">
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
                      <td width="96%"><a href="<%= request.getContextPath() %>/acaeModifica!doMuestra">Consulta/Modificaci�n de Datos de las ACAE</a></td>
                    </tr>
                    <tr>
                      <td colspan="2"><img src="public/img/web/fondo_menu.jpg" width="220" height="1" /></td>
                    </tr>                    
                    <tr>
                      <td width="4%">&nbsp;</td>
                      <td width="96%">
                        <s:url action="index" id="urlParametro">
                          <s:param name="parametro.idParametro" value="idParametro"/>
                        </s:url>
                        <a href="<s:property value="#urlParametro"/>">Configuraci�n de Par�metros</a></td>
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
           <p><br />
           </p>
       </td>
       </tr>
</table>           
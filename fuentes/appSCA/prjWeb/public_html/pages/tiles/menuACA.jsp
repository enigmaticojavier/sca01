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
              
		<div id="test1-content">
                <!--DIV which show/hide on click of header-->
                <!--This DIV is for inline styling like padding...-->
                <div class="accordion_child">
                  <table width="100%">
                    
                    <tr>
                      <td width="4%">&nbsp;</td>
                      <td width="96%"><a href="index.php?idTipoElementoInformacion=14">Preparación / Envío de Información Periódica</a></td>
                    </tr>
                    <tr>
                      <td colspan="2"><img src="public/img/web/fondo_menu.jpg" width="220" height="1" /></td>
                    </tr>
                    <tr>
                      <td width="4%">&nbsp;</td>
                      <td width="96%"><a href="index.php?idTipoElementoInformacion=14">Consultas</a></td>
                    </tr>
                    <tr>
                      <td colspan="2"><img src="public/img/web/fondo_menu.jpg" width="220" height="1" /></td>
                    </tr>
                    <tr>
                      <td width="4%">&nbsp;</td>
                      <td width="96%"><a href="index.php?idTipoElementoInformacion=14">Estadísticas</a></td>
                    </tr>
                    <tr>
                      <td colspan="2"><img src="public/img/web/fondo_menu.jpg" width="220" height="1" /></td>
                    </tr>
                    <tr>
                      <td width="4%">&nbsp;</td>
                      <td width="96%"><a href="<%= request.getContextPath() %>/doLogout.action">Cerrar Sesión</a></td>
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
            <s:form action="doLogin" method="POST" >            
              <tr>
                <td height="34" valign="middle" class="login1"><div align="center"><br />
                <span class="style2">ACCESO A USUARIOS</span></div></td>
              </tr>
              <tr>
                <td width="235" height="132" class="login2">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="4%">&nbsp;</td>
                    <td width="92%">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <s:actionerror />
                        <s:fielderror />                      
                      <s:textfield name="usuario" value="" label="Usuario"/>
					  <s:password name="codClave" value="" label="Clave"/>
                      <tr>
                        <td colspan="2">&nbsp;</td>
                      </tr>
                      <s:submit value="Ingresar" align="center"/>
                    </table>
                    </td>
                    <td width="4%">&nbsp;</td>
                  </tr>

                </table></td>
              </tr>
            </s:form>
           <p>&nbsp;</p>
           <p>&nbsp;</p>
           <p>&nbsp;</p>
           <p>&nbsp;</p>
           <p><br />
           </p>
       </td>
       </tr>
</table>           
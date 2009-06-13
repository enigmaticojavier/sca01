<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>index</title>
    
    <script language="javascript">
        function verParametro(){
          var frm=document.forms[0];
          frm.action="parametro!list";
          frm.submit();
        }
    </script>
    
  </head>
  <body>
  <form action="">
    <table cellspacing="2" cellpadding="3" border="1" width="100%">
      <tr>
          <td class="nowrap">
          <!--input type="button" value="Parametro" onclick="verParametro()"-->
                <s:url action="index" id="url">
                    <s:param name="parametro.idParametro" value="idParametro"/>
                </s:url>
                <a href="<s:property value="#url"/>">Parametros</a>
                <br>
                <s:url action="proyecto" id="urlProyecto">
                    <s:param name="parametro.idParametro" value="idProyecto"/>
                </s:url>
                <a href="<s:property value="#urlProyecto"/>">Proyecto</a>
                <br>
                <s:url action="estadistica" id="urlEstadistica">
                    <s:param name="parametro.idParametro" value="idEstadistica"/>
                </s:url>
                <a href="<s:property value="#urlEstadistica"/>">Estadistica</a>
                <br>
                <s:url action="archivo" id="urlArchivo">
                    <s:param name="parametro.idArchivo" value="idArchivo"/>
                </s:url>
                <a href="<s:property value="#urlArchivo"/>">Archivo</a>
                <br>
                <a href="<%=request.getContextPath()%>/DescargaServlet">Descarga</a>
                
                <br>
                <s:url action="upload" id="urlUpload">
                    <s:param name="parametro.idParametro" value="idUpload"/>
                </s:url>
                <a href="<s:property value="#urlUpload"/>">Upload</a>
                
                
            </td>
            
        
      </tr>
     </table> 
  </form>
  </body>
</html>
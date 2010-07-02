<%-- 
    Document   : historia
    Created on : 02-jul-2010, 0:10:31
    Author     : FREDY
--%>


<%@include file="ValidarSession.jsp"%>
<%@include file="cabecera.jsp"%>
<div id="cuerpo" align="center">
  <form name="form1" method="post" action="HistoriaBusquedaServlet">
  <tr>
    <td rowspan="5" width="200">&nbsp;</td>
    <td colspan="4">&nbsp;</td>
    <td rowspan="5" width="200">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="4"><div align="center">REGISTRO DE EVENTOS</div></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Buscar por usuario:</td>
    <td><input name="nombre" type="text" id="nombre"></td>
    <td><input type="submit" name="Submit" value="Buscar"></td>
    <td></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</form>
<table class="subtitulo" width="960" border="0" bordercolor="#999999" align="center" bgcolor="#ffffff">
    <tr bgcolor="#0099FF" class="titulo">
    <td width="20"><div align="center"><strong>Nº</strong></div></td>
    <td width="120"><div align="center"><strong>Id User</strong></div></td>
    <td width="170"><div align="center"><strong>Accion</strong></div></td>
    <td width="170"><div align="center"><strong>Objeto</strong></div></td>
    <td width="180"><div align="center"><strong>Nombre Obj.</strong></div></td>
    <td width="180"><div align="center"><strong>Fecha</strong></div></td>
    <td width="120"><div align="center"><strong>Hora</strong></div></td>
  </tr>
  <%@page import="java.util.*,mantenimiento.modelo.Historias" %>
   <%String status;%>
  <%
  	Collection <Historias> listah= (ArrayList <Historias>)request.getAttribute("arreglo");
  	if(listah!=null){
            int a=1;
            String x="";

  		for(Historias Historias:listah){
                  if(a%2==0){
                      x="bgcolor='#ECF5FF'";
                  }else{
                      x="";
                  }
                  %>
  <tr <%=x %>>
    <td><div align="center"><%=a %></div></td>
    <td><%= Historias.getUsuario() %></td>
    <td><%= Historias.getAccion() %></td>
    <td><%= Historias.getObjeto() %></td>
    <td><%= Historias.getNom_objeto() %></td>
    <td><div align="center"><%= Historias.getFecha() %></div></td>
    <td><div align="center"><%= Historias.getHora() %></div></td>
   </tr>
<%
        a++;
 		}
  	}else{ %>
          <tr>
    <td colspan="7"><p></p><p align="center">Ingrese un valor el el espacio de busqueda y presione el boton buscar</p>
    <p></p></td>
  </tr>
        <%
        }
%>
</table>
</div>

<%@include file="pie.jsp" %>
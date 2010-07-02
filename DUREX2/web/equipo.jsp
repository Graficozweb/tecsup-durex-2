<%-- 
    Document   : equipo
    Created on : 14/06/2010, 04:18:33 PM
    Author     : Albert
--%>

<%@include file="ValidarSession.jsp"%>
<%@include file="cabecera.jsp"%>

   <table class="subtitulo" align="center" width="960" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
<form name="form1" method="post" action="EquipoBuscarServlet">
  <tr>
    <td rowspan="5" width="200">&nbsp;</td>
    <td colspan="4">&nbsp;</td>
    <td rowspan="5" width="200">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="4"><div align="center">Mantenimiento de Equipos</div></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>Buscar por nombre:</td>
    <td><input name="nombre" type="text" id="nombre"></td>
    <td><input type="submit" name="Submit" value="Buscar"></td>
    <td><input type="button" name="Submit" value="Nuevo" onClick="window.location='agregarequipo.jsp'"></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  </form>
</table>
   <table class="subtitulo" width="960" border="0" cellspacing="0" cellpadding="0" bordercolor="#999999" align="center" bgcolor="#ffffff">
    <tr bgcolor="#0099FF" class="titulo">
    <td width="50"><div align="center"><strong>Nro</strong></div></td>
    <td width="100"><div align="center"><strong>ID Equipo</strong></div></td>
    <td width="100"><div align="center"><strong>Nombre</strong></div></td>
    <td width="100"><div align="center"><strong>Modelo</strong></div></td>
    <td width="100"><div align="center"><strong>Marca</strong></div></td>
    <td width="100"><div align="center"><strong>Nro. Serie</strong></div></td>
    <td width="134"><div align="center"><strong>Acciones</strong></div></td>
  </tr>
  <%@page import="java.util.*,mantenimiento.modelo.Equipo" %>
   <%String status;%>
  <%
  	Collection <Equipo> listau= (ArrayList <Equipo>)request.getAttribute("arreglo");
  	if(listau!=null){
            int a=1;
            String x="";

  		for(Equipo Equipo:listau){
                  if(a%2==0){
                      x="bgcolor='#ECF5FF'";
                  }else{
                      x="";
                  }
                  %>
  <tr <%=x %>>
    <td><div align="center"><%=a %></div></td>
    <td><div align="center"><%= Equipo.getIdequipo() %></div></td>
    <td><div align="center"><%= Equipo.getNombre() %></div></td>
    <td><div align="center"><%= Equipo.getModelo() %></div></td>
    <td><div align="center"><%= Equipo.getMarca() %></div></td>
    <td><div align="center"><%= Equipo.getNro_serie() %></div></td>
   <%--<td><%=status%></td>--%>
   <td><div align="center"><a href="EquipoEditarServlet?equipo=<%= Equipo.getIdequipo()%>">Editar</a>-<a href="eliminarequipo.jsp">Eliminar</a></div></td>
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
<%@include file="pie.jsp"%>

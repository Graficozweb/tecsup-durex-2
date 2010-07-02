<%-- 
    Document   : usuarios
    Created on : 19-jun-2010, 17:06:24
    Author     : FREDY
--%>

<%@include file="ValidarSession.jsp"%>
<%@include file="cabecera.jsp"%>

<table class="subtitulo" align="center" width="960" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
<form name="form1" method="post" action="UsuarioBuscarServlet">
  <tr>
    <td rowspan="5" width="200">&nbsp;</td>
    <td colspan="4">&nbsp;</td>
    <td rowspan="5" width="200">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="4"><div align="center">Mantenimiento de Usuarios</div></td>
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
    <td><input type="button" name="Submit" value="Nuevo" onclick="window.location='usuarioAgregar.jsp'"></td>
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
    <td width="50"><div align="center"><strong>Nº</strong></div></td>
    <td width="100"><div align="center"><strong>Id User</strong></div></td>
    <td width="100"><div align="center"><strong>Nombre</strong></div></td>
    <td width="100"><div align="center"><strong>Paterno</strong></div></td>
    <td width="134"><div align="center"><strong>Materno</strong></div></td>
    <td width="134"><div align="center"><strong>Estado</strong></div></td>
    <td width="180"><div align="center"><strong>Acciones</strong></div></td>
  </tr>
  <%@page import="java.util.*,mantenimiento.modelo.Usuario" %>
   <%String status;%>
  <%
  	Collection <Usuario> listau= (ArrayList <Usuario>)request.getAttribute("arreglo");
  	if(listau!=null){
            int a=1;
            String x="";

  		for(Usuario Usuario:listau){
                  if(a%2==0){
                      x="bgcolor='#ECF5FF'";
                  }else{
                      x="";
                  }
                  %>
  <tr <%=x %>>
    <td><div align="center"><%=a %></div></td>
    <td><%= Usuario.getIdUsuario() %></td>
    <td><%= Usuario.getNombre() %></td>
    <td><%= Usuario.getPaterno() %></td>
    <td><%= Usuario.getMaterno() %></td>
    <td><%= Usuario.getStatus() %></td>
   <%--<td><%=status%></td>--%>
   <td><div align="center"><a href="UsuarioEditarServlet?usuario=<%= Usuario.getIdUsuario()%>">Editar</a></div></td>
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


<%@include file="pie.jsp" %>
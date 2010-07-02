
<%--
    Document   : usuarioAgregar
    Created on : 19-jun-2010, 18:22:50
    Author     : FREDY
--%>
<%@include file="ValidarSession.jsp" %>
<%@include file="cabecera.jsp" %>
<%@page import="mantenimiento.modelo.Usuario"%>

<table class="subtitulo" width="960" border="0" cellspacing="0" cellpadding="0" align="center" bgcolor="#ffffff">
  <form name="form1" method="post" action="UsuarioModificarServlet">

      <%
Usuario user= (Usuario)request.getAttribute("Usuario");
String idnombre=user.getIdUsuario();
%>
  <tr>
    <td rowspan="13" width="320">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td rowspan="13" width="320"><input name="historia" type="hidden" id="historia" value="${sessionScope.USUARIO_ACTUAL.idUsuario }"></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">
      <p><strong>Editar Usuario <%= user.getIdUsuario() %></strong></p>
      <p></p>
    </div></td>
  </tr>
  <tr>
    <td>Usuario:*</td>
    <td><input name="usuario_no_request" type="text" id="" value="<%= idnombre %>" disabled>
    <input name="usuario" type="hidden" id="" value="<%= user.getIdUsuario() %>"></td>
  </tr>
  <tr>
    <td>Clave:*</td>
    <td><input name="clave1" type="password" id="" value="<%= user.getClave() %>"/></td>
  </tr>
  <tr>
    <td>Repetir Clave:*</td>
    <td><input name="clave2" type="password" id="" value="<%= user.getClave() %>"/></td>
  </tr>
  <tr>
    <td>Nombre:*</td>
    <td><input name="nombre" type="text" id="" value="<%= user.getNombre() %>"/></td>
  </tr>
  <tr>
    <td>A. Paterno:*</td>
    <td><input name="paterno" type="text" id="" value="<%= user.getPaterno() %>"/></td>
  </tr>
  <tr>
    <td>A.Materno:*</td>
    <td><input name="materno" type="text" id="" value="<%= user.getMaterno() %>"/></td>
  </tr>
  <tr>
    <td>Correo:</td>
    <td><input name="correo" type="text" id="" value="<%= user.getMail()%>"/></td>
  </tr>
  <tr>
    <td>Tel&eacute;fono:</td>
    <td><input name="telefono" type="text" id="" value="<%= user.getTelefono() %>"/></td>
  </tr>
  <tr>
    <td>Estado:*</td>
    <td> <%
      	if("1".equals(user.getEstado())){

      	%>
     <input name="estado" type="radio" value="1" checked="checked">
        Activo
        <input name="estado" type="radio" value="0">
        Inactivo
      <%}else{ %>
       <input name="estado" type="radio" value="1">
        Activo
        <input name="estado" type="radio" value="0" checked="checked">
        Inactivo
      <%
      }
      %></td>
  </tr>

  <tr>
    <td colspan="2" align="center">
        <input type="submit" name="Submit" value="Guardar">

        <input type="button" name="Submit" value="Regresar" onclick="window.location='usuarios.jsp'">    </td>
  </tr>
    <tr>
    <td colspan="2" align="center">&nbsp;</td>
  </tr>
  </form>
</table>
<%@include file="pie.jsp" %>
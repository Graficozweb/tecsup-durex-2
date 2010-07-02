<%-- 
    Document   : grupoBuscar
    Created on : 19-jun-2010, 16:23:52
    Author     : FREDY
--%>
<%@include file="cabecera.jsp" %>
<table align="center" width="960" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
<form name="form1" method="post" action="GrupoBuscarServlet">
  <tr>
    <td rowspan="5" width="200">&nbsp;</td>
    <td colspan="4">&nbsp;</td>
    <td rowspan="5" width="200">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="4"><div align="center">Mantenimiento de Gupos de Herramientas</div></td>
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
    <td><input type="button" name="Submit" value="Nuevo" onclick="window.location='grupoAgregar.jsp'"></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  </form>
</table>

<table width="100%" border="1">
  <tr>
    <th>Id</th>
    <th>Nombre</th>
    <th>Descripci&oacute;n</th>
    <th>Acciones</th>
  </tr>
  <c:forEach items="${grupo}" var="g">
  <tr>
    <td>${g.idGrupo}</td>
    <%--<td>${c.idCategoria}</td>--%>
    <td>${g.nombre}</td>
    <td>${g.descripcion}</td>
    <td><a href="GrupoEditarServlet?idGrupo=${g.idGrupo}">Editar</a> - <a href="GrupoEliminarServlet?idGrupo=${g.idGrupo}">Eliminar</a> </td>
  </tr>
</c:forEach>
</table>
<%@include file="pie.jsp" %>
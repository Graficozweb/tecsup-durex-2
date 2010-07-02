
<%--
    Document   : usuarioAgregar
    Created on : 19-jun-2010, 18:22:50
    Author     : FREDY
--%>
<%@include file="ValidarSession.jsp" %>
<%@include file="cabecera.jsp" %>
<%@page import="mantenimiento.modelo.Grupo"%>

<table class="subtitulo" width="960" border="0" cellspacing="0" cellpadding="0" align="center" bgcolor="#ffffff">
    <form name="form1" method="post" action="GrupoActualizarServlet">

        <%
                    Grupo user = (Grupo) request.getAttribute("IdGrupo");
        %>
        <tr>
            <td width="320" rowspan="6">&nbsp;</td>
            <td colspan="2">&nbsp;</td>
            <td width="320" rowspan="6">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="2"><div align="center"><p>EDITAR GRUPO DE HERRAMIENTAS</p><p>&nbsp;</p></div></td>
        </tr>
        <tr>
            <td>Nombre:</td>
            <td><input type="text" name="nombre" id="nombre" value="<%= user.getNombre()%>"/></td>
        </tr>
        <tr>
            <td>Descripci&oacute;n:</td>
            <td><input type="hidden" name="idGrupo" id="idGrupo" value="<%= user.getIdgrupo()%>"/></td>
            <%--<td><input type="text" name="descripcion" id="descripcion" value="<%= user.getDescripcion()%>"/></td>--%>
        </tr>
        <tr>
            <td colspan="2"><textarea name="descripcion" id="descripcion" cols="45" rows="5"><%= user.getDescripcion()%></textarea></td>
        </tr>
        <tr>
            <td><p><input  type="submit" value="Guardar"></p><p>&nbsp;</p></td>
            <td><div align="right"><p><a href="grupo_herramienta.jsp" <%--style="display: none"--%>><p><img src="Imagenes/volver_icono.jpg" alt="" width="40" height="37" /></a></p><p>&nbsp;</p></div></td>
        </tr>
    </form>
</table>
<%@include file="pie.jsp" %>
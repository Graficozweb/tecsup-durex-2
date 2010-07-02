<%-- 
    Document   : equipo_partes
    Created on : 22/06/2010, 11:52:55 AM
    Author     : Albert
--%>

<%@include file="ValidarSession.jsp"%>
<%@include file="cabecera.jsp"%>
<table class="subtitulo" align="center" width="960" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
    <form name="form1" method="post" action="PartesBuscarServlet">
        <tr>
            <td rowspan="5" width="200">&nbsp;</td>
            <td colspan="4">&nbsp;</td>
            <td rowspan="5" width="200">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="4"><div align="center">Mantenimiento de Partes de Equipo</div></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>Buscar por nombre:</td>
            <td><input name="nombre" type="text"></td>
            <td><input type="submit" name="Submit" value="Buscar"></td>
            <td><input type="button" name="Submit" value="Nuevo" onclick="window.location='nuevaparte.jsp'"></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
    </form>
</table>


<table  width="960" border="0" cellspacing="0" cellpadding="1" bordercolor="#999999" bordercolorlight="#999999" align="center" bgcolor="#ffffff" class="subtitulo">
    <tr bgcolor="#0099FF" class="titulo">
        <td><div align="center"><strong>ID</strong></div></td>
        <td><div align="center"><strong>Equipo</strong></div></td>
        <td><div align="center"><strong>Nombre</strong></div></td>
        <td><div align="center"><strong>Descripci&oacute;n</strong></div></td>
        <td><div align="center"><strong>Acciones</strong></div></td>

    </tr>
    <%  int a = 1;
                String x = "";
    %>
    <c:forEach items="${parte}" var="p">
        <%
                    if (a % 2 == 0) {
                        x = "bgcolor='#ECF5FF'";
                    } else {
                        x = "";
                    }
        %>
        <tr <%=x%>>
            <td><div align="center">${p.idparte}</div></td>
            <td><div align="center">${p.idequipo}</div></td>
            <td><div align="center">${p.nombre}</div></td>
            <td><div align="center">${p.descripcion}</div></td>
            <td><div align="center"><a href="PartesEditarServlet?idparte=${p.idparte}">Editar</a> - <a href="PartesEliminarServlet?idparte=${p.idparte}">Eliminar</a></div> </td>
        </tr>
        <% a++;%>
    </c:forEach>
    <%--
    <tr><td colspan="9">&nbsp;</td></tr>
    --%>
</table>
<%@include file="pie.jsp"%>
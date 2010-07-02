<%--
    Document   : principal
    Created on : 13-jun-2010, 20:33:19
    Author     : FREDY
--%>


<%@include file="ValidarSession.jsp"%>
<%@include file="cabecera.jsp"%>
<table class="subtitulo" align="center" width="960" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
    <form name="form1" method="post" action="HerramientaBuscarServlet">
        <tr>
            <td rowspan="5" width="200">&nbsp;</td>
            <td colspan="4">&nbsp;</td>
            <td rowspan="5" width="200">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="4"><div align="center">Mantenimiento de Herramientas</div></td>
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
            <td><input type="button" name="Submit" value="Nuevo" onclick="window.location='herramientaNuevo.jsp'"></td>
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
        <td><div align="center"><strong>Grupo</strong></div></td>
        <td><div align="center"><strong>Nombre</strong></div></td>
        <td><div align="center"><strong>Marca</strong></div></td>
        <td><div align="center"><strong>Modelo</strong></div></td>
        <td><div align="center"><strong>Dimensiones</strong></div></td>
        <td><div align="center"><strong>Distribuidor</strong></div></td>
        <td><div align="center"><strong>Acciones</strong></div></td>
    </tr>
    <%  int a = 1;
                String x = "";
    %>
    <c:forEach items="${herramienta}" var="p">
        <%
                    if (a % 2 == 0) {
                        x = "bgcolor='#ECF5FF'";
                    } else {
                        x = "";
                    }
        %>
        <tr <%=x%>>
            <td>${p.idherramienta}</td>
            <td>${p.nombreGrupo}</td>
            <td>${p.nombre}</td>
            <td>${p.marca}</td>
            <td>${p.modelo}</td>
            <td>${p.dimensiones}</td>
            <td>${p.fabricante}</td>

            <td><div align="center"><a href="HerramientaEditarServlet?idHerramienta=${p.idherramienta}">Editar</a> - <a href="HerramientaEliminarServlet?idHerramienta=${p.idherramienta}">Eliminar</a></div> </td>
        </tr>
        <% a++;%>
    </c:forEach>
    <%--
    <tr><td colspan="9">&nbsp;</td></tr>
    --%>
</table>

<%@include file="pie.jsp"%>
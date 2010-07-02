<%-- 
    Document   : equipo_partes
    Created on : 22/06/2010, 11:15:24 AM
    Author     : Albert
--%>

<%@include file="ValidarSession.jsp"%>
<%@include file="cabecera.jsp"%>
<%@page import="mantenimiento.dao.EquipoDAO"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mantenimiento.modelo.Equipo"%>

<table width="960" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff" align="center">

<form name="form1" method="post" action="<%=request.getContextPath()%>/PartesNuevoServlet" enctype="multipart/form-data">
    <tr>
        <td rowspan="10" width="320">&nbsp;</td>
        <td colspan="2">&nbsp;</td>
        <td rowspan="10" width="320">&nbsp;</td>
    </tr>
    <tr>
        <td colspan="2"><div align="center">
                <p>Nueva parte de Equipo</p><p></p></div>
        </td>
    </tr>
    <tr>
        <td>Equipo:</td>
        <td><select name="equipo">
                <option>-- Seleccione --</option>
                <% EquipoDAO dao = new EquipoDAO();
                            Collection<Equipo> lcateg = (ArrayList<Equipo>) dao.buscarPorNombre("");
                            if (lcateg != null) {
                                for (Equipo c : lcateg) {

                %>
                <option value="<%= c.getIdequipo()%>"><%= c.getNombre()%></option>
                <%
                                }
                            }
                %>
            </select></td>
    </tr>
    <tr>
        <td>Nombre:</td>
        <td><input type="text" name="nombre"></td>
    </tr>
    <tr>
        <td>Descripcion:</td>
        <td><input type="text" name="descripcion"></td>
    </tr>
    <tr>
        <td><input type="submit" name="Submit" value="Guardar"/></td>
        <td><div align="right"><a href="equipo.jsp"><img src="Imagenes/volver_icono.jpg" alt="" width="40" height="37" /></a></div>
        </td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
</form>
</table>
<%@include file="pie.jsp" %>

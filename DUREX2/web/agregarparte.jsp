<%-- 
    Document   : agregarparte
    Created on : 14/06/2010, 08:42:18 PM
    Author     : Albert
--%>

<%@include file="ValidarSession.jsp"%>
<%@include file="cabecera.jsp"%>
<%@page import="mantenimiento.dao.EquipoDAO"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mantenimiento.modelo.Equipo"%>
<table width="960" align="center" bgcolor="#FFFFFF">
<tr>
	<td>
<p style="font-family: Calibri"><strong>Equipos --&gt; Partes</strong></p>

<form name="form1" method="post" action="<%=request.getContextPath()%>/ProductoInsertarServlet" enctype="multipart/form-data">
    <table width="336" border="1">
        <tr>
            <td width="92">Categoria:</td>
            <td width="228"><select name="idequipo">
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
            <td>Descripci&oacute;n:</td>
            <td><textarea name="descripcion" cols="45" rows="5"></textarea></td>
        </tr>

    </table>
</form>
	</td>
</tr>
</table>
<p><strong> </strong></p>
<%@include file="pie.jsp"%>
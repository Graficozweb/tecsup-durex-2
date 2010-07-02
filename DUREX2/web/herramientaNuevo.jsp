<%-- 
    Document   : herramientaNuevo
    Created on : 18-jun-2010, 15:53:51
    Author     : FREDY
--%>
<%@include file="ValidarSession.jsp"%>
<%@include file="cabecera.jsp"%>
<%@page import="mantenimiento.dao.GrupoDAO"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mantenimiento.modelo.Grupo"%>

<table width="960" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff" align="center">

<form name="form1" method="post" action="<%=request.getContextPath()%>/HerramientaNuevoServlet" enctype="multipart/form-data">
    <tr>
        <td rowspan="10" width="320">&nbsp;</td>
        <td colspan="2">&nbsp;</td>
        <td rowspan="10" width="320">&nbsp;</td>
    </tr>
    <tr>
        <td colspan="2"><div align="center">
                <p>Herramienta Nueva</p><p></p></div>
        </td>
    </tr>
    <tr>
        <td>Grupo:</td>
        <td><select name="grupo">
                <option>-- Seleccione --</option>
                <% GrupoDAO dao = new GrupoDAO();
                            Collection<Grupo> lcateg = (ArrayList<Grupo>) dao.buscarPorNombre("");
                            if (lcateg != null) {
                                for (Grupo c : lcateg) {

                %>
                <option value="<%= c.getIdgrupo()%>"><%= c.getNombre()%></option>
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
        <td>Marca:</td>
        <td><input type="text" name="marca"></td>
    </tr>
    <tr>
        <td>Modelo:</td>
        <td><input type="text" name="modelo"></td>
    </tr>
    <tr>
        <td>Dimensiones:</td>
        <td><input type="text" name="dimensiones"></td>
    </tr>
    <tr>
        <td>Distribuidor:</td>
        <td><input type="text" name="fabricante"></td>
    </tr>
    <tr>
        <td><input type="submit" name="Submit" value="Guardar"/></td>
        <td><div align="right"><a href="herramienta.jsp"><img src="Imagenes/volver_icono.jpg" alt="" width="40" height="37" /></a></div>
        </td>
    </tr>
    <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
</form>
</table>
                <%@include file="pie.jsp" %>
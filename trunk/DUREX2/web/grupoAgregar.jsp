<%-- 
    Document   : grupoAgregar
    Created on : 18-jun-2010, 12:16:06
    Author     : FREDY
--%>


<%@include file="ValidarSession.jsp"%>
<%@include file="cabecera.jsp"%>

<table width="960" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff" align="center">
    <form name="form1" method="post" action="GrupoNuevoServlet">
        <tr>
            <td width="320" rowspan="6">&nbsp;</td>
            <td colspan="2">&nbsp;</td>
            <td width="320" rowspan="6">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="2"><div align="center"><p>AGREGAR GRUPO DE HERRAMIENTAS</p><p>&nbsp;</p></div></td>
        </tr>
        <tr>
            <td>Nombre:</td>
            <td><input type="text" name="nombre" id="nombre"/></td>
        </tr>
        <tr>
            <td>Descripci&oacute;n:</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td colspan="2"><textarea name="descripcion" id="descripcion" cols="45" rows="5"></textarea></td>
        </tr>
        <tr>
            <td><p><input  type="submit" value="Guardar"></p><p>&nbsp;</p></td>
            <td><div align="right"><p><a href="grupo_herramienta.jsp" <%--style="display: none"--%>><p><img src="Imagenes/volver_icono.jpg" alt="" width="40" height="37" /></a></p><p>&nbsp;</p></div></td>
        </tr>
    </form>
</table>


<%@include file="pie.jsp"%>
<%-- 
    Document   : eliminarequipo
    Created on : 15/06/2010, 06:27:34 PM
    Author     : Albert
--%>
<%@include file="ValidarSession.jsp"%>
<%@include file="cabecera.jsp"%>

<form name="form1" method="post" action="EquipoEliminarServlet">
    <table width="960" border="0" bgcolor="#FFFFFF" align="center">
        <tr>
            <td colspan="2" class="estilo" style="font-family: Calibri"><p>ELIMINAR EQUIPO</p>
            <p>&nbsp;</p></td>
</tr>
        <tr>
            <td width="471"><div align="right" style="font-family: Calibri; font-weight: bold">ID Equipo:</div></td>
          <td width="479"><input name="idequipo" type="text" /></td>
      </tr>
        <tr>
            <td><div align="right" style="font-family: Calibri"><img src="Imagenes/trash empty blue2.png" width="40" height="37" />
              <input name="btnenviar" type="submit" value="Eliminar">
          </div></td>
          <td><span style="font-family: Calibri"><img src="Imagenes/volver_icono.jpg" alt="" width="40" height="37" />
          <input name="btnnuevo" type="button" value="Salir" onclick="window.location='equipo.jsp'">
          </span></td>
      </tr>
    </table>
</form>

<%@include file="pie.jsp"%>
<%-- 
    Document   : editarequipo
    Created on : 21/06/2010, 08:04:44 PM
    Author     : Albert
--%>

<%@include file="ValidarSession.jsp" %>
<%@include file="cabecera.jsp" %>
<%@page import="mantenimiento.modelo.Equipo"%>
<table class="subtitulo" width="960" border="0" cellspacing="0" cellpadding="0" align="center" bgcolor="#ffffff">
  <form name="form1" method="post" action="EquipoModificarServlet">
    <%
Equipo equi= (Equipo)request.getAttribute("equipo");
%>
<tr>
    <td><input name="idequipo" type="hidden" value="<%= equi.getIdequipo() %>" /></td>
    <td>&nbsp;</td>
</tr>
<tr>
      <td colspan="4"><div align="center">
        <p><strong>Editar Equipo <%= equi.getIdequipo() %></strong></p>
        <p></p>
      </div>      </td>
    </tr>
    <tr>
      <td colspan="4"><div align="center" style="font-family: Calibri"><span class="fuente Estilo9" style="font-size: 24px"><strong>Datos T&eacute;cnicos</strong></span></div></td>
    </tr>
    <tr>
      <td width="221"><span style="font-family: Calibri"><strong>Nombre del equipo*</strong></span></td>
      <td><input name="nombre" type="text" value="<%= equi.getNombre() %>" /></td>
      <td><span style="font-family: Calibri"><strong>Funcion que realiza*</strong></span></td>
      <td><input name="funcion" type="text" value="<%= equi.getFuncion() %>" /></td>
    </tr>
    <tr>
      <td><span style="font-family: Calibri"><strong>Ubicaci&oacute;n*</strong></span></td>
      <td><input name="ubicacion" type="text" value="<%= equi.getUbicacion() %>" /></td>
      <td><span style="font-family: Calibri"><strong>Tama&ntilde;o*</strong></span></td>
      <td><input name="tamano" type="text" value="<%= equi.getTamano() %>" /></td>
    </tr>
    <tr>
      <td width="221"><span style="font-family: Calibri"><strong>Capacidad/Velocidad</strong></span></td>
      <td width="268"><input name="capacidad_velocidad" type="text" value="<%= equi.getCapacidad_velocidad() %>" /></td>
      <td><span style="font-family: Calibri"><strong>Marca*</strong></span></td>
      <td><input name="marca" type="text" value="<%= equi.getMarca() %>" /></td>
    </tr>
    <tr>
      <td><span style="font-family: Calibri"><strong>Modelo*</strong></span></td>
      <td><input name="modelo" type="text" value="<%= equi.getModelo() %>" /></td>
      <td><span style="font-family: Calibri"><strong>Proveedor*</strong></span></td>
      <td><input name="proveedor" type="text" value="<%= equi.getProveedor() %>" /></td>
    </tr>
    <tr>
      <td><span style="font-family: Calibri"><strong>Tel&eacute;fono</strong></span></td>
      <td><input name="telefono" type="text" value="<%= equi.getTelefono() %>"/></td>
      <td><span style="font-family: Calibri"><strong>Potencia</strong></span></td>
      <td><input name="potencia" type="text" value="<%= equi.getPotencia() %>" /></td>
    </tr>
    <tr>
      <td><span style="font-family: Calibri"><strong>Voltaje</strong></span></td>
      <td><input name="voltaje" type="text" value="<%= equi.getVoltaje() %>" /></td>
      <td width="221"><span style="font-family: Calibri"><strong>Lectura de su vida util</strong></span></td>
      <td><input name="vida_util" type="text" value="<%= equi.getVida_util() %>"/></td>
    </tr>
    <tr>
      <td width="221" align="left"><span style="font-family: Calibri"><strong>Fecha de Fabricaci&oacute;n</strong></span></td>
      <td><input name="fecha_fab" type="text" value="<%= equi.getFecha_fab() %>" /></td>
      <td><span style="font-family: Calibri"><strong>Fecha de Instalaci&oacute;n</strong></span></td>
      <td><input name="fecha_insta" type="text" value="<%= equi.getFecha_insta() %>" /></td>
    </tr>
    <tr>
      <td><span style="font-family: Calibri"><strong>Fecha de ultima actualizaci&oacute;n</strong></span></td>
      <td><input name="actualizacion" type="text" value="<%= equi.getActualizacion() %>" /></td>
      <td><span style="font-family: Calibri"><strong>Estado de equipo</strong></span></td>
      <td><input name="estado_equipo" type="text" value="<%= equi.getEstado_equipo() %>"/></td>
    </tr>
    <tr>
      <td width="221"><span style="font-family: Calibri"><strong>Costo Original (US$)</strong></span></td>
      <td width="268"><input name="costo_original" type="text" value="<%= equi.getCosto_original() %>" /></td>
      <td width="221"><div align="left" style="font-family: Calibri"><strong>Costo Actual(US$)</strong></div></td>
      <td width="268"><input name="costo_actual" type="text" value="<%= equi.getCosto_actual() %>" /></td>
    </tr>
    <tr>
      <td><span style="font-family: Calibri"><strong>Criticidad</strong></span></td>
      <td><input name="criticidad" type="text" value="<%= equi.getCriticidad() %>" /></td>
      <td><span style="font-family: Calibri"><strong>Nro.Serie</strong></span></td>
      <td><input name="nro_serie" type="text" value="<%= equi.getNro_serie() %>" /></td>
    </tr>
    <tr>
      <td colspan="15" align="center"><div align="left" style="font-style: italic; font-size: 14px; font-family: Calibri; font-weight: bold">*Campos Obligatorios</div></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><img src="Imagenes/volver_icono.jpg" alt="iconos" width="32" height="29" /><input name="btnretornar" type="button" value="Regresar" onClick="window.location='equipo.jsp'"></td>
      <td colspan="13" align="center"><img src="Imagenes/save.jpg" alt="imagenes" width="32" height="33" /><input name="btnguardar" type="submit" value="Guardar"></td>

  </form>
</table>

  <%@include file="pie.jsp" %>

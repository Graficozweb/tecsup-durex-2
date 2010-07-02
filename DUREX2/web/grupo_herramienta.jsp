<%-- 
    Document   : grupo_herramienta
    Created on : 18-jun-2010, 12:12:36
    Author     : FREDY
--%>

<%@include file="ValidarSession.jsp"%>
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

<table width="960" border="0" cellspacing="0" cellpadding="1" bordercolor="#999999" align="center" bgcolor="#ffffff">
  <tr  bgcolor="#0099FF" class="titulo">
      <th>Item Nº</th>
    <th>Id</th>
    <th>Nombre</th>
    <th>Descripci&oacute;n</th>
    <th>Acciones</th>
  </tr>
   <%@page import="java.util.*,mantenimiento.modelo.Grupo" %>
   <%String status;%>
  <%
  	Collection <Grupo> listag= (ArrayList <Grupo>)request.getAttribute("arreglo2");
  	if(listag!=null){
            int a=1;
            String x="";

  		for(Grupo Grupo:listag){
                  if(a%2==0){
                      x="bgcolor='#ECF5FF'";
                  }else{
                      x="";
                  }
                  %>
  <tr <%=x %>>
    <td><div align="center"><%=a %></div></td>
    <td>00<%= Grupo.getIdgrupo() %></td>
    <td><%= Grupo.getNombre() %></td>
    <td><%= Grupo.getDescripcion() %></td>

   <%--<td><%=status%></td>--%>
   <td><div align="center"><a href="GrupoEditarServlet?idGrupo=<%= Grupo.getIdgrupo()%>">Editar</a></div></td>
   </tr>
<%
        a++;
 		}
  	}else{ %>
          <tr>
    <td colspan="7"><p></p><p align="center">Ingrese un valor el el espacio de busqueda y presione el boton buscar</p>
    <p></p></td>
  </tr>
        <%
        }
%>

</table>
<%@include file="pie.jsp" %>
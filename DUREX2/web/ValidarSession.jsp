<%-- 
    Document   : ValidarSession
    Created on : 13-jun-2010, 20:35:41
    Author     : FREDY
--%>

<%@page import="mantenimiento.modelo.Usuario" %>
<%

Usuario usuario_actual = (Usuario)session.getAttribute("USUARIO_ACTUAL");
if (usuario_actual == null){
	request.getRequestDispatcher("error.jsp").forward(request, response);
	return;
}

%>
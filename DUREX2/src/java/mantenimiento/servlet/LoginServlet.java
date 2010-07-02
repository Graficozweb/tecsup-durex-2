/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantenimiento.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mantenimiento.dao.UsuarioDAO;
import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.excepcion.LoginExcepcion;
import mantenimiento.modelo.Usuario;

/**
 * Servlet implementation class for Servlet: LoginServlet
 *
 */
public class LoginServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 *
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/*
	 * (non-Java-doc)
	 *
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Java-doc)
	 *
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");

		UsuarioDAO dao = new UsuarioDAO();

		try {
			Usuario vo = dao.validar(usuario, clave);
			HttpSession session = request.getSession();
			session.setAttribute("USUARIO_ACTUAL", vo);
			response.sendRedirect("PortadaServlet");
			return;
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		} catch (LoginExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error_login.jsp");
			rd.forward(request, response);
		}

	}
}
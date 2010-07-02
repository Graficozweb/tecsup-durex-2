

package mantenimiento.servlet.usuario;

import java.io.IOException;
import java.util.Collection;

/**
 *
 * @author FREDY
 */
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimiento.dao.UsuarioDAO;
import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Usuario;

/**
 * Servlet implementation class for Servlet: UsuarioBuscarServlet
 *
 */
public class UsuarioBuscarServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 *
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public UsuarioBuscarServlet() {
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

		System.out.println("UsuarioBuscarServlet");
		String x = request.getParameter("nombre");
		System.out.println(x);
		UsuarioDAO dao = new UsuarioDAO();
		Collection<Usuario> y;
		try {
			y = dao.buscarPorNombre(x);
			// Guardar arreglo en ambiente request
			request.setAttribute("arreglo", y);

			// Hacer forward a jsp (cooperacion)
			RequestDispatcher rd = request
					.getRequestDispatcher("/usuarios.jsp");
			rd.forward(request, response);
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}

	}

}
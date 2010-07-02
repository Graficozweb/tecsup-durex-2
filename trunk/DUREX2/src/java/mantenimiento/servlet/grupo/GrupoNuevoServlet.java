package mantenimiento.servlet.grupo;
/**
 *
 * @author FREDY
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimiento.dao.GrupoDAO;
import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Grupo;

/**
 * Servlet implementation class for Servlet: CategoriaNuevoServlet
 *
 */
public class    GrupoNuevoServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 *
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public  GrupoNuevoServlet() {
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
		// TODO Auto-generated method stub
		GrupoDAO dao = new GrupoDAO();
		Grupo vo = new Grupo();
		vo.setNombre(request.getParameter("nombre"));
		vo.setDescripcion(request.getParameter("descripcion"));
		try {
			dao.insertar(vo);
			request.getRequestDispatcher("/grupo_herramienta.jsp").forward(
					request, response);
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}

	}
}
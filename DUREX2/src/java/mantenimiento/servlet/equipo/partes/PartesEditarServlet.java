package mantenimiento.servlet.equipo.partes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimiento.dao.Equipo_partesDAO;
import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Equipo_partes;


/**
 * Servlet implementation class for Servlet: PartesEditarServlet
 * 
 */
public class PartesEditarServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public PartesEditarServlet() {
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
		Equipo_partesDAO dao = new Equipo_partesDAO();
		int id = Integer.parseInt(request.getParameter("idEquipo_partes"));
		Equipo_partes vo;
		try {
			vo = dao.obtener(id);
			request.setAttribute("Equipo_partes", vo);
			request.getRequestDispatcher("/Equipo_partesEditar.jsp").forward(
					request, response);
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}

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
	}
}
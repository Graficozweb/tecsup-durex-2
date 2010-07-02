package mantenimiento.servlet.equipo.partes;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimiento.dao.ParteDAO;
import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Parte;


/**
 * Servlet implementation class for Servlet: ProductoBuscarServlet
 *
 */
public class PartesBuscarServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 *
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public PartesBuscarServlet() {
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
		processRequest(request, response);
	}

	/*
	 * (non-Java-doc)
	 *
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ParteDAO dao = new ParteDAO();
		Collection<Parte> lparte;
		try {
			lparte = dao.buscarPorNombre(request.getParameter("nombre"));
                        System.out.println("size Collection<herramienta>: "+lparte.size());
			request.setAttribute("parte", lparte);
			request.setAttribute("buscar", request.getParameter("nombre"));
			System.out.println(request.getParameter("nombre"));
			request.getRequestDispatcher("parte.jsp").forward(request,
					response);
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
package mantenimiento.servlet.herramienta;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimiento.dao.HerramientaDAO;
import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Herramienta;

/**
 * Servlet implementation class for Servlet: ProductoBuscarServlet
 *
 */
public class HerramientaBuscarServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 *
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public HerramientaBuscarServlet() {
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
		HerramientaDAO dao = new HerramientaDAO();
		Collection<Herramienta> lherramienta;
		try {
			lherramienta = dao.buscarPorNombre(request.getParameter("nombre"));
                        System.out.println("size Collection<herramienta>: "+lherramienta.size());
			request.setAttribute("herramienta", lherramienta);
			request.setAttribute("buscar", request.getParameter("nombre"));
			System.out.println(request.getParameter("nombre"));

			request.getRequestDispatcher("herramienta.jsp").forward(request,
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
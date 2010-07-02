package mantenimiento.servlet.equipo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimiento.dao.EquipoDAO;
import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Equipo;

/**
 * Servlet implementation class for Servlet: EquipoBuscarServlet
 * 
 */
public class EquipoBuscarServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public EquipoBuscarServlet() {
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
		System.out.println("EquipoBuscarServlet");
		String x = request.getParameter("nombre");
		System.out.println(x);
		EquipoDAO dao = new EquipoDAO();
		Collection<Equipo> y;
		try {
			y = dao.buscarPorNombre(x);
			// Guardar arreglo en ambiente request
			request.setAttribute("arreglo", y);

			// Hacer forward a jsp (cooperacion)
			RequestDispatcher rd = request.getRequestDispatcher("/equipo.jsp");
			rd.forward(request, response);
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);

	}
}
}
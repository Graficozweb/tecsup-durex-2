package mantenimiento.servlet.grupo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimiento.dao.GrupoDAO;
import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Grupo;

/**
 * Servlet implementation class for Servlet: UsuarioEditarServlet
 *
 */
public class GrupoEditarServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 *
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public GrupoEditarServlet() {
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

		String z = request.getParameter("idGrupo");
                int x=Integer.parseInt(z);
                System.out.println("idGrupo aaaaaaaaaa: "+z);
		GrupoDAO dao = new GrupoDAO();
		Grupo vo;
		try {
			vo = dao.obtener(x);
			request.setAttribute("IdGrupo", vo);

			RequestDispatcher rd = request
					.getRequestDispatcher("/grupoEditar.jsp");
			rd.forward(request, response);
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
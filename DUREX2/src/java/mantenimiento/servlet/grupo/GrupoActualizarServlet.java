/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * Servlet implementation class for Servlet: UsuarioModificarServlet
 *
 */
public class GrupoActualizarServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 *
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public GrupoActualizarServlet() {
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

		int a =Integer.parseInt(request.getParameter("idGrupo"));
		String b = request.getParameter("nombre");
		String c = request.getParameter("descripcion");


		Grupo vo = new Grupo();
		vo.setIdgrupo(a);
		vo.setNombre(b);
		vo.setDescripcion(c);


		GrupoDAO dao = new GrupoDAO();
		try {
			dao.actualizar(vo);
			RequestDispatcher rd = request
					.getRequestDispatcher("/grupo_herramienta.jsp");
			rd.forward(request, response);
		} catch (DAOExcepcion e1) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}

	}
}
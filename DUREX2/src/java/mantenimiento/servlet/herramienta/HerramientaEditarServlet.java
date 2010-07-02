/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantenimiento.servlet.herramienta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimiento.dao.HerramientaDAO;
import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Herramienta;
/**
 *
 * @author FREDY
 */

public class HerramientaEditarServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 *
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public HerramientaEditarServlet() {
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
		HerramientaDAO dao = new HerramientaDAO();
		int id = Integer.parseInt(request.getParameter("idHerramienta"));
                System.out.println("herramienta editar servlet id: "+id);
                System.out.println("id: "+id);
                System.out.println("id: "+id);
		Herramienta vo;
		try {
			vo = dao.obtenerHerramientaPorId(id);
                        request.setAttribute("Herramienta", vo);
			request.getRequestDispatcher("/herramientaEditar.jsp").forward(
					request, response);

//                        vo = dao.obtenerProductoPorId(id);
//			request.setAttribute("producto", vo);
//			request.getRequestDispatcher("/productoEditar.jsp").forward(
//					request, response);
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
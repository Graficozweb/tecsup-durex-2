
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

 public class HerramientaActualizarServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;

    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public HerramientaActualizarServlet() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("HerramientaActualizarServlet: inicio");
		Herramienta vo = new Herramienta();
		int id=Integer.parseInt(request.getParameter("grupo"));
		vo.setIdgrupo(id);
		int idp=Integer.parseInt(request.getParameter("idHerramienta"));
		vo.setIdherramienta(idp);
		vo.setNombre(request.getParameter("nombre"));
		vo.setModelo(request.getParameter("modelo"));
		vo.setMarca(request.getParameter("marca"));
                vo.setDimensiones(request.getParameter("dimensiones"));
                vo.setFabricante(request.getParameter("fabricante"));

		HerramientaDAO dao= new HerramientaDAO();
		try {
			dao.actualizar(vo);
			request.getRequestDispatcher("/herramienta.jsp").forward(request, response);
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}

	}
}
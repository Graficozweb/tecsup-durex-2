

package mantenimiento.servlet.Historias;

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

import mantenimiento.dao.HistoriaDAO;
import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Historias;

/**
 * Servlet implementation class for Servlet: UsuarioBuscarServlet
 *
 */
public class HistoriasBuscarServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 *
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public HistoriasBuscarServlet() {
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
            System.out.println("------INICIO DE SERVLET BUSCAR------");
		System.out.println("HistoriaBuscarServlet");
		String x = request.getParameter("nombre");
		System.out.println(x);
                System.out.println("......se inserto el valor imput a la variable");
		HistoriaDAO dao = new HistoriaDAO();
		Collection<Historias> y;
		try {
			y = dao.buscarPorUsuario(x);
                        System.out.println("se guardo el resultado de busqueda en collection y.");
			// Guardar arreglo en ambiente request
			request.setAttribute("arreglo", y);

			// Hacer forward a jsp (cooperacion)
			RequestDispatcher rd = request
					.getRequestDispatcher("/historia.jsp");
			rd.forward(request, response);
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}

	}

}
package mantenimiento.servlet.equipo.partes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimiento.dao.ParteDAO;
import mantenimiento.modelo.Parte;



public class PartesNuevoServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	public PartesNuevoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Debe haber creado el directorio /imagenes/ en el Web Page y colocar
		// el jar en la carpeta /lib/

		System.out.println("ProductoInsertarServlet: processRequest: inicio");

		String equipo = "";
		String nombre = "";
		String descripcion = "";

                try {
			Parte vo = new Parte();
			vo.setIdequipo(Integer.parseInt(equipo));
			vo.setNombre(nombre);
                        vo.setDescripcion(descripcion);
                       
			ParteDAO dao = new ParteDAO();

                        dao.insertar(vo);
       			request.getRequestDispatcher("/herramienta.jsp").forward(request, response);
		
		} catch (Exception ioe) {
			System.err.println(ioe.toString());
		}

        }
}
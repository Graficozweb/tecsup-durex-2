package mantenimiento.servlet.equipo.partes;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimiento.dao.ParteDAO;
import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Parte;

public class PartesInsertarServlet extends javax.servlet.http.HttpServlet
        implements javax.servlet.Servlet {

    static final long serialVersionUID = 1L;

    public PartesInsertarServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // Debe haber creado el directorio /imagenes/ en el Web Page y colocar
        // el jar en la carpeta /lib/

        System.out.println("PartesInsertarServlet: processRequest: inicio");

        String equipo = "";
        String nombre = "";
        String descripcion = "";

        ParteDAO dao = new ParteDAO();
        Parte vo = new Parte();
        vo.setNombreequipo(equipo);
        vo.setNombre(nombre);
        vo.setDescripcion(descripcion);
                try {
			dao.insertar(vo);
			request.getRequestDispatcher("/grupo_herramienta.jsp").forward(
					request, response);
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
    }



}

package mantenimiento.servlet.equipo;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimiento.dao.EquipoDAO;
import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Equipo;



/**
 * Servlet implementation class for Servlet: EquipoInsertarServlet
 * 
 */
public class EquipoInsertarServlet extends javax.servlet.http.HttpServlet
        implements javax.servlet.Servlet {

    static final long serialVersionUID = 1L;

    /*
     * (non-Java-doc)
     *
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public EquipoInsertarServlet() {
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
        EquipoDAO dao = new EquipoDAO();
        Equipo vo = new Equipo();

        vo.setNombre(request.getParameter("nombre"));
        vo.setFuncion(request.getParameter("funcion"));
        vo.setUbicacion(request.getParameter("ubicacion"));
        vo.setTamano(request.getParameter("tamano"));
        vo.setCapacidad_velocidad(request.getParameter("capacidad_velocidad"));
        vo.setMarca(request.getParameter("marca"));
        vo.setModelo(request.getParameter("modelo"));
        vo.setProveedor(request.getParameter("proveedor"));
        vo.setTelefono(request.getParameter("telefono"));
        vo.setPotencia(request.getParameter("potencia"));
        vo.setVoltaje(request.getParameter("voltaje"));
        vo.setVida_util(request.getParameter("vida_util"));
        vo.setFecha_fab(request.getParameter("fecha_fab"));
        vo.setFecha_insta(request.getParameter("fecha_insta"));
        vo.setActualizacion(request.getParameter("actualizacion"));
        vo.setCosto_original(request.getParameter("costo_original"));
        vo.setCosto_actual(request.getParameter("costo_actual"));
        vo.setEstado_equipo(request.getParameter("estado_equipo"));
        vo.setCriticidad(request.getParameter("criticidad"));
        vo.setNro_serie(request.getParameter("nro_serie"));
        try {
            dao.insertar(vo);
            request.getRequestDispatcher("/equipo.jsp").forward(
                    request, response);
        } catch (DAOExcepcion e) {
            System.err.println("Error");
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }

    }
}

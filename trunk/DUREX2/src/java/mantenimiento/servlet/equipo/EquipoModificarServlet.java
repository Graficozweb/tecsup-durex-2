/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Albert
 */
public class EquipoModificarServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 *
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public EquipoModificarServlet() {
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

        String a = request.getParameter("nombre");
        String b = request.getParameter("funcion");
        String c = request.getParameter("ubicacion");
        String d = request.getParameter("tamano");
        String e = request.getParameter("capacidad_velocidad");
        String f = request.getParameter("marca");
        String g = request.getParameter("modelo");
        String h = request.getParameter("proveedor");
        String i = request.getParameter("telefono");
        String j = request.getParameter("potencia");
        String k = request.getParameter("voltaje");
        String l = request.getParameter("vida_util");
        String m = request.getParameter("fecha_fab");
        String n = request.getParameter("fecha_insta");
        String o = request.getParameter("actualizacion");
        String p = request.getParameter("costo_original");
        String q = request.getParameter("costo_actual");
        String r = request.getParameter("estado_equipo");
        String s = request.getParameter("criticidad");
        String t = request.getParameter("nro_serie");
        int x = Integer.parseInt(request.getParameter("idequipo"));
        System.out.println(x);

        Equipo vo = new Equipo();

        
        vo.setNombre(a);
        vo.setFuncion(b);
        vo.setUbicacion(c);
        vo.setTamano(d);
        vo.setCapacidad_velocidad(e);
        vo.setMarca(f);
        vo.setModelo(g);
        vo.setProveedor(h);
        vo.setTelefono(i);
        vo.setPotencia(j);
        vo.setVoltaje(k);
        vo.setVida_util(l);
        vo.setFecha_fab(m);
        vo.setFecha_insta(n);
        vo.setActualizacion(o);
        vo.setCosto_original(p);
        vo.setCosto_actual(q);
        vo.setEstado_equipo(r);
        vo.setCriticidad(s);
        vo.setNro_serie(t);
        vo.setIdequipo(x);
        System.out.println(x);

        EquipoDAO dao = new EquipoDAO();

        try {
            dao.actualizar(vo);
            RequestDispatcher rd = request.getRequestDispatcher("/equipo.jsp");
            rd.forward(request, response);
        } catch (DAOExcepcion e1) {
            System.err.println("Error");
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantenimiento.servlet.usuario;

/**
 *
 * @author FREDY
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimiento.dao.HistoriaDAO;

import mantenimiento.dao.UsuarioDAO;
import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Fecha;
import mantenimiento.modelo.Historias;
import mantenimiento.modelo.Usuario;

/**
 * Servlet implementation class for Servlet: UsuarioModificarServlet
 *
 */
public class UsuarioModificarServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 *
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public UsuarioModificarServlet() {
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

		String a = request.getParameter("usuario");
		String b = request.getParameter("clave1");
		String c = request.getParameter("nombre");
		String d = request.getParameter("paterno");
		String e = request.getParameter("materno");
		String f = request.getParameter("correo");
		String h = request.getParameter("telefono");
		String i = request.getParameter("estado");

		Usuario vo = new Usuario();
		vo.setIdUsuario(a);
		vo.setClave(b);
		vo.setNombre(c);
		vo.setPaterno(d);
		vo.setMaterno(e);
		vo.setMail(f);
		vo.setTelefono(h);
		vo.setEstado(i);

		UsuarioDAO dao = new UsuarioDAO();
		try {
			dao.actualizar(vo);
			RequestDispatcher rd = request
					.getRequestDispatcher("/usuarios.jsp");
			rd.forward(request, response);
		} catch (DAOExcepcion e1) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}


                 System.out.println("si historia etitar usuario------------");
        System.out.println("si pasa--------------------------------------");
        System.out.println("si pasa--------------------------------------");
        System.out.println("si pasa--------------------------------------");

        Historias vo2 = new Historias();
        Fecha fe = new Fecha();
        String usr1 = request.getParameter("historia");
        System.out.println(usr1);
        System.out.println("xxxxxxxxxxxxxxxxxx--------------------------------------");
        System.out.println("xxxxxxxxxxxxxxxxxx--------------------------------------");
        System.out.println("xxxxxxxxxxxxxxxxxx--------------------------------------");
        vo2.setUsuario(usr1);

        System.out.println("xxxxxxxxxxxxxxxxxx--------------------------------------");
        System.out.println("xxxxxxxxxxxxxxxxxx--------------------------------------");
        System.out.println("xxxxxxxxxxxxxxxxxx--------------------------------------");
        System.out.println("xxxxxxxxxxxxxxxxxx--------------------------------------");
//        vo2.getUsuario()
        vo2.setAccion("Editar");
        vo2.setObjeto("Usuario");
        vo2.setNom_objeto(a);
        vo2.setFecha(fe.getFecha());
        vo2.setHora(fe.getHora());
        HistoriaDAO hi = new HistoriaDAO();
        try {
            hi.insertar(vo2);
            System.out.println("se inserto la historia correctamente.");
        } catch (DAOExcepcion e1) {
            System.err.println("Error de historia");
        }
        System.out.println("si pasa--------------------------------------");
        System.out.println("si pasa--------------------------------------");
        System.out.println("si pasa--------------------------------------");


	}
}
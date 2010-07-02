package mantenimiento.servlet.usuario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimiento.dao.UsuarioDAO;
import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Usuario;

import mantenimiento.dao.HistoriaDAO;
import mantenimiento.modelo.Historias;
import mantenimiento.modelo.Fecha;

/**
 *
 * @author FREDY
 */
public class UsuarioInsertarServlet extends javax.servlet.http.HttpServlet
        implements javax.servlet.Servlet {

    static final long serialVersionUID = 1L;

    /*
     * (non-Java-doc)
     *
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public UsuarioInsertarServlet() {
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
        //
        String a = request.getParameter("usuario");
        String b = request.getParameter("clave1");
        String b2 = request.getParameter("clave2");
        String c = request.getParameter("nombre");
        String d = request.getParameter("paterno");
        String e = request.getParameter("materno");
        String f = request.getParameter("correo");
        String g = request.getParameter("telefono");
        String h = request.getParameter("estado");
        System.out.print("valor usuario " + "<" + a + ">");
        System.out.println(a);
        int nombre = c.length();
        int paterno = d.length();
        int materno = e.length();
        int user = a.length();
        System.out.println("status: " + h);
        System.out.println(user);
        int passw = b.length();
        //pruebas fallidas
//        if(h.equals("0")|| h.equals("1")){
//        int status=3;
//        }

//        int status = h.length();
//        System.out.println("status " + "<" + status + ">");
//if(h!=0){
//    System.out.println("stadi es null!!!!!!!!!!!!");
//}
        //comparar claves de autentificacion
//        a.equals("") && a.equals(null)
        if (user == 0 || nombre == 0 || paterno == 0 || materno == 0 || h.equals("2") || passw < 5) {
            RequestDispatcher rd = request.getRequestDispatcher("errorAdduser.jsp");
            rd.forward(request, response);
        } else {
            if (b.equals(b2)) {

                Usuario vo = new Usuario();
                vo.setIdUsuario(a);
                vo.setClave(b);
                vo.setNombre(c);
                vo.setPaterno(d);
                vo.setMaterno(e);
                vo.setMail(f);
                vo.setTelefono(g);
                vo.setEstado(h);

                UsuarioDAO dao = new UsuarioDAO();
                try {
                    dao.insertar(vo);
                    RequestDispatcher rd = request.getRequestDispatcher("usuarios.jsp");
                    rd.forward(request, response);
                } catch (DAOExcepcion e1) {
                    System.err.println("Error");
                    RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
                    rd.forward(request, response);
                }
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/errorPassw.jsp");
                rd.forward(request, response);

            }
        }
        System.out.println("si pasa--------------------------------------");
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
        vo2.setAccion("Crear");
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

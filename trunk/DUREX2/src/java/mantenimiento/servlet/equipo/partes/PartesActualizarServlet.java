package mantenimiento.servlet.equipo.partes;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimiento.dao.ParteDAO;
import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Parte;




/**
 * Servlet implementation class for Servlet: PartesActualizarServlet
 *
 */
 public class PartesActualizarServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public PartesActualizarServlet() {
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
		System.out.println("ParteActualizarServlet: inicio");
		Parte vo = new Parte();
		int id=Integer.parseInt(request.getParameter("categoria"));
		vo.setIdparte(id);
		int idp=Integer.parseInt(request.getParameter("idParte"));
		vo.setIdparte(idp);
		vo.setNombre(request.getParameter("nombre"));
		vo.setDescripcion(request.getParameter("descripcion"));
		
		
		ParteDAO dao= new ParteDAO();
		try {
			dao.actualizar(vo);
			request.getRequestDispatcher("/ParteBuscar.jsp").forward(request, response);
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		
	}   	  	    
}
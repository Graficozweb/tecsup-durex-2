package mantenimiento.servlet.herramienta;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import mantenimiento.dao.HerramientaDAO;
import mantenimiento.modelo.Herramienta;

public class HerramientaNuevoServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	public HerramientaNuevoServlet() {
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

		String grupo = "";
		String nombre = "";
		String marca = "";
		String modelo = "";
		String dimensiones = "";
		String fabricante = "";
		String nombreImagen = "ALFAS";

		DiskFileUpload fu = new DiskFileUpload();
		// Tamanioo maximo que debe tener el archivo, sino lanzara un
		// FileUploadException
		fu.setSizeMax(5000000);

		try {
			List lista = fu.parseRequest(request);
			Iterator itr = lista.iterator();
			while (itr.hasNext()) {
				FileItem fi = (FileItem) itr.next();
				if (!fi.isFormField()) {
					nombreImagen = fi.getName();
					if (!"".equals(nombreImagen)) {
						int slash = nombreImagen.lastIndexOf("\\");
						if (slash != -1) {
							nombreImagen = nombreImagen.substring(slash + 1);
							System.out.println("1: " + nombreImagen);
						}
						// Windows no reconoce /'s
						slash = nombreImagen.lastIndexOf("/");
						if (slash != -1) {
							nombreImagen = nombreImagen.substring(slash + 1);
							System.out.println("2: " + nombreImagen);
						}
						// En caso el nombre del archivo sea C:archivo.txt
						slash = nombreImagen.lastIndexOf(":");
						if (slash != -1) {
							nombreImagen = nombreImagen.substring(slash + 1);
							System.out.println("3: " + nombreImagen);
						}
						File directorio = new File(getServletContext()
								.getRealPath("imagenes/"));
						File pathUpload = new File(directorio + "\\"
								+ nombreImagen);
						fi.write(pathUpload);
						System.out.println("Upload; fieldName: " + fi.getFieldName()
								+ ", fileName: " + nombreImagen
								+ ", contentType: " + fi.getContentType()
								+ ", sizeInBytes: " + fi.getSize()
								+ ", pathUpload: " + pathUpload);
					} else {
						nombreImagen = "";
					}
				}

				if ("grupo".equals(fi.getFieldName())) {
					grupo = fi.getString();
				}
				if ("nombre".equals(fi.getFieldName())) {
					nombre = fi.getString();
				}
				if ("marca".equals(fi.getFieldName())) {
					marca = fi.getString();
				}
				if ("modelo".equals(fi.getFieldName())) {
					modelo = fi.getString();
				}
				if ("dimensiones".equals(fi.getFieldName())) {
					dimensiones = fi.getString();
				}
                                if("fabricante".equals(fi.getFieldName())){
                                        fabricante = fi.getString();
                                }
			}
			Herramienta vo = new Herramienta();
			vo.setIdgrupo(Integer.parseInt(grupo));
			vo.setNombre(nombre);
                        vo.setMarca(marca);
                        vo.setModelo(modelo);
                        vo.setDimensiones(dimensiones);
                        vo.setFabricante(fabricante);

//			vo.setPrecio(Float.parseFloat(precio));
//			vo.setStock(Integer.parseInt(stock));
			HerramientaDAO dao = new HerramientaDAO();
			dao.insertar(vo);
			request.getRequestDispatcher("/herramienta.jsp").forward(
					request, response);

		} catch (FileUploadException fue) {
			System.err.println(fue.toString());
		} catch (Exception ioe) {
			System.err.println(ioe.toString());
		}

	}
}
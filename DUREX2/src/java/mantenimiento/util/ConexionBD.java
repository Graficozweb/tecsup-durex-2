/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantenimiento.util;



/**
 *
 * @author FREDY
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	public static Connection obtenerConexion() throws SQLException {
		// Configurar archivo /server/default/deploy/mysql-ds.xml
		// Connection con = null;
		// try {
		// InitialContext initialContext = new InitialContext();
		// DataSource ds = (DataSource)
		// initialContext.lookup("java:trastienda");
		// con = ds.getConnection();
		//
		// } catch (NamingException ex) {
		// System.out.println(ex.getMessage());
		// throw new SQLException("No se pudo encontrar el DataSource.");
		// } catch (SQLException ex) {
		// System.out.println(ex.getMessage());
		// throw new SQLException("No se pudo obtener una conexion.");
		// }
		// return con;

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/DUREX",
					"root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}

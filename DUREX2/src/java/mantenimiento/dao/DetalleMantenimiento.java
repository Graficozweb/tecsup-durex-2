package mantenimiento.dao;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Actividades;
import mantenimiento.modelo.Repuestos;
import mantenimiento.modelo.Trabajador;
import mantenimiento.util.ConexionBD;


public class DetalleMantenimiento extends BaseDAO {

	public Actividades obtenerActividadesPorId(int idActividades) throws DAOExcepcion {
		Actividades vo = new Actividades();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select * from Actividadess where idActividades=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idActividades);

			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdActividades(rs.getInt(1));
				vo.setDescripcion(rs.getString(2));
				vo.setHoras_hombre(rs.getInt(3));
				vo.setCostos(rs.getInt(4));
				vo.setTiempo(rs.getInt(5));

			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
/*
	public Collection<Actividades> buscarID(String nombre)
			throws DAOExcepcion {
//		String query = "select Actividades.*,grupo.nombre as ngrupo from Actividades,grupo where Actividades.nombre like ? and grupo.idgrupo=Actividades.idgrupo";
		String query = "select Actividades.*,grupo.nombre as ngrupo from Actividadess,grupo where Actividadess.nombre like ? and grupo.idgrupo=Actividadess.idgrupo";
		Collection<Actividades> c = new ArrayList<Actividades>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Actividades vo = new Actividades();
				vo.setIdActividades(rs.getInt(1));
				vo.setDescripcion(rs.getString(2));
				vo.setHoras_hombre(rs.getInt(3));
				vo.setCostos(rs.getInt(4));
				vo.setTiempo(rs.getInt(5));
				c.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}
*/

	public Actividades insertar(Actividades vo) throws DAOExcepcion {
		String query = "INSERT INTO Actividades(descripcion,horas_hombre,costos,tiempo) VALUES (?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);

			stmt.setString(1, vo.getDescripcion());
			stmt.setInt(2, vo.getHoras_hombre());
			stmt.setInt(3, vo.getCostos());
			stmt.setInt(4, vo.getTiempo());

			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
			// Obtener el ultimo id
			int id = 0;
			query = "SELECT LAST_INSERT_ID()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			vo.setIdActividades(id);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public void eliminar(int idActividades) throws DAOExcepcion {
		String query = "DELETE FROM Actividades WHERE idActividades=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idActividades);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public Actividades actualizar(Actividades vo) throws DAOExcepcion {
		String query = "update Actividades set descripcion=?,horas_hombre=?,costos=?,tiempo=? where idActividadess=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);

			stmt.setString(1, vo.getDescripcion());
			stmt.setInt(2, vo.getHoras_hombre());
			stmt.setInt(3, vo.getCostos());
			stmt.setInt(4, vo.getTiempo());
                        stmt.setInt(5, vo.getIdActividades());

			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}




        //-------------------EMPIEZA TRABAJADOR---------------------------

          public Trabajador obtenerTrabajador(int idTrabajador) throws DAOExcepcion {
		Trabajador vo = new Trabajador();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select * from Trabajador where idTrabajador=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idTrabajador);

			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdTrabajador(rs.getInt(1));
				vo.setFuncion(rs.getString(2));
				vo.setCosto_horas(rs.getInt(3));

//
//				vo.setImagen(rs.getString(8));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
/*
	public Collection<Trabajador> buscarPorFuncion(String funcion)
			throws DAOExcepcion {
//		String query = "select Trabajador.*,grupo.nombre as ngrupo from Trabajador,grupo where Trabajador.nombre like ? and grupo.idgrupo=Trabajador.idgrupo";
		String query = "select Trabajador.*,grupo.nombre as ngrupo from Trabajador,grupo where Trabajador.nombre like ? and grupo.idgrupo=Trabajadors.idgrupo";
		Collection<Trabajador> c = new ArrayList<Trabajador>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + funcion + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Trabajador vo = new Trabajador();
				vo.setIdTrabajador(rs.getInt(1));
				vo.setFuncion(rs.getString(2));
				vo.setCosto_horas(rs.getInt(3));

				c.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}
*/
          
	public Trabajador insertar(Trabajador vo) throws DAOExcepcion {
		String query = "INSERT INTO Trabajador(funcion,costo_Horas) VALUES (?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getFuncion());
			stmt.setInt(2, vo.getCosto_horas());

//			stmt.setString(7, vo.getImagen());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
			// Obtener el ultimo id
			int id = 0;
			query = "SELECT LAST_INSERT_ID()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			vo.setIdTrabajador(id);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public void eliminarTrabajador(int idTrabajador) throws DAOExcepcion {
		String query = "DELETE FROM Trabajadors WHERE idTrabajador=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idTrabajador);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public Trabajador actualizar(Trabajador vo) throws DAOExcepcion {
		String query = "update Trabajador set nombre=?,marca=?,modelo=?,dimensiones=?,fabricante=?,idgrupo=? where idTrabajador=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getFuncion());
			stmt.setInt(2, vo.getCosto_horas());

//			stmt.setString(6, vo.getImagen());

			stmt.setInt(3, vo.getIdTrabajador());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

        //-----------------------ACA empieza Repuestos-----------------------------

        public Repuestos obtenerRepuestosId(int idRepuestos) throws DAOExcepcion {
		Repuestos vo = new Repuestos();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select * from Repuestos where idRepuestos=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idRepuestos);

			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdRepuestos(rs.getInt(1));

				vo.setNombre(rs.getString(2));
				vo.setDescripcion(rs.getString(3));
//				vo.setModelo(rs.getFloat(5));
				vo.setCantidad(rs.getInt(4));
				vo.setCosto(rs.getInt(5));

//				vo.setImagen(rs.getString(8));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
/*
	public Collection<Repuestos> buscarPorNombre(String nombre)
			throws DAOExcepcion {
//		String query = "select Repuestos.*,grupo.nombre as ngrupo from Repuestos,grupo where Repuestos.nombre like ? and grupo.idgrupo=Repuestos.idgrupo";
		String query = "select Repuestoss.*,grupo.nombre as ngrupo from Repuestoss,grupo where Repuestoss.nombre like ? and grupo.idgrupo=Repuestoss.idgrupo";
		Collection<Repuestos> c = new ArrayList<Repuestos>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Repuestos vo = new Repuestos();
				vo.setIdRepuestos(rs.getInt(1));
				vo.setIdgrupo(rs.getInt(2));
				vo.setNombre(rs.getString(3));
				vo.setMarca(rs.getString(4));
				vo.setModelo(rs.getString(5));
				vo.setDimensiones(rs.getString(6));
				vo.setFabricante(rs.getString(7));
				vo.setNombreGrupo(rs.getString("ngrupo"));
				c.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return c;
	}
*/
     
	public Repuestos insertar(Repuestos vo) throws DAOExcepcion {
		String query = "INSERT INTO Repuestos(nombre,descripcion,cantidad,costo) VALUES (?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);

			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getDescripcion());
			stmt.setInt(3, vo.getCantidad());
			stmt.setInt(4, vo.getCosto());

//			stmt.setString(7, vo.getImagen());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo insertar");
			}
			// Obtener el ultimo id
			int id = 0;
			query = "SELECT LAST_INSERT_ID()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			vo.setIdRepuestos(id);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public void eliminarRepuestos(int idRepuestos) throws DAOExcepcion {
		String query = "DELETE FROM Repuestos WHERE idRepuestos=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idRepuestos);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo eliminar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}

	public Repuestos actualizar(Repuestos vo) throws DAOExcepcion {
		String query = "update Repuestos set nombre=?,descripcion=?,cantidad=?,costo=? where idRepuestos=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getDescripcion());
			stmt.setInt(3, vo.getCantidad());
			stmt.setInt(4, vo.getCosto());

			stmt.setInt(5, vo.getIdRepuestos());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo actualizar");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
}

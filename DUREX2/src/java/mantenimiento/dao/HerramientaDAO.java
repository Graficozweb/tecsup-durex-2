package mantenimiento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Herramienta;
import mantenimiento.util.ConexionBD;

public class HerramientaDAO extends BaseDAO {

	public Herramienta obtenerHerramientaPorId(int idHerramienta) throws DAOExcepcion {
		Herramienta vo = new Herramienta();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select * from herramientas where idHerramientas=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idHerramienta);

			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdherramienta(rs.getInt(1));
				vo.setIdgrupo(rs.getInt(2));
				vo.setNombre(rs.getString(3));
				vo.setMarca(rs.getString(4));
//				vo.setModelo(rs.getFloat(5));
				vo.setModelo(rs.getString(5));
				vo.setDimensiones(rs.getString(6));
				vo.setFabricante(rs.getString(7));
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

	public Collection<Herramienta> buscarPorNombre(String nombre)
			throws DAOExcepcion {
//		String query = "select herramienta.*,grupo.nombre as ngrupo from herramienta,grupo where herramienta.nombre like ? and grupo.idgrupo=herramienta.idgrupo";
		String query = "select herramientas.*,grupo.nombre as ngrupo from herramientas,grupo where herramientas.nombre like ? and grupo.idgrupo=herramientas.idgrupo";
		Collection<Herramienta> c = new ArrayList<Herramienta>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Herramienta vo = new Herramienta();
				vo.setIdherramienta(rs.getInt(1));
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

	public Herramienta insertar(Herramienta vo) throws DAOExcepcion {
		String query = "INSERT INTO herramientas(idgrupo,nombre,marca,modelo,dimensiones,fabricante) VALUES (?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getIdgrupo());
			stmt.setString(2, vo.getNombre());
			stmt.setString(3, vo.getMarca());
			stmt.setString(4, vo.getModelo());
			stmt.setString(5, vo.getDimensiones());
			stmt.setString(6, vo.getFabricante());
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
			vo.setIdherramienta(id);
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

	public void eliminar(int idHerramientas) throws DAOExcepcion {
		String query = "DELETE FROM herramientas WHERE idHerramientas=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idHerramientas);
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

	public Herramienta actualizar(Herramienta vo) throws DAOExcepcion {
		String query = "update herramientas set nombre=?,marca=?,modelo=?,dimensiones=?,fabricante=?,idgrupo=? where idHerramientas=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getMarca());
			stmt.setString(3, vo.getModelo());
			stmt.setString(4, vo.getDimensiones());
			stmt.setString(5, vo.getFabricante());
//			stmt.setString(6, vo.getImagen());
			stmt.setInt(6, vo.getIdgrupo());
			stmt.setInt(7, vo.getIdherramienta());
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

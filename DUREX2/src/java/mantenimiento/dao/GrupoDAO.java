
package mantenimiento.dao;

/**
 *
 * @author FREDY
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Grupo;
import mantenimiento.util.ConexionBD;

public class GrupoDAO extends BaseDAO {

	public Collection<Grupo> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		String query = "select idgrupo, nombre, descripcion from grupo where nombre like ?";
		Collection<Grupo> lista = new ArrayList<Grupo>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Grupo vo = new Grupo();
				vo.setIdgrupo(rs.getInt("idgrupo"));
				vo.setNombre(rs.getString("nombre"));
				vo.setDescripcion(rs.getString("descripcion"));
				lista.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		System.out.println(lista.size());
		return lista;
	}

	public Grupo insertar(Grupo vo) throws DAOExcepcion {
		String query = "INSERT INTO grupo(nombre,descripcion) VALUES (?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getDescripcion());
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
			vo.setIdgrupo(id);

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

	public Grupo obtener(int idGrupo) throws DAOExcepcion {
		Grupo vo = new Grupo();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select grupo.* from grupo where idgrupo=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idGrupo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdgrupo(rs.getInt(1));
				vo.setNombre(rs.getString(2));
				vo.setDescripcion(rs.getString(3));
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

	public void eliminar(int idGrupo) throws DAOExcepcion {
		String query = "DELETE FROM grupo WHERE idgrupo=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1,idGrupo);
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

	public Grupo actualizar(Grupo vo) throws DAOExcepcion {
		String query = "update grupo set nombre=?,descripcion=? where idgrupo=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getDescripcion());
			stmt.setInt(3, vo.getIdgrupo());
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

	public Collection<Grupo> listar() throws DAOExcepcion {
		Collection<Grupo> c = new ArrayList<Grupo>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT idgrupo,nombre,descripcion from grupo";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Grupo vo = new Grupo();
				vo.setIdgrupo(rs.getInt("idgrupo"));
				vo.setNombre(rs.getString("nombre"));
				vo.setDescripcion(rs.getString("descripcion"));
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

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantenimiento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Equipo_partes;
import mantenimiento.util.ConexionBD;




public class Equipo_partesDAO extends BaseDAO {

public Collection<Equipo_partes> buscarPorNombre(String nombre)
			throws DAOExcepcion {
		String query = "select idparte, nombre, descripcion from equipo_partes where nombre like ?";
		Collection<Equipo_partes> lista = new ArrayList<Equipo_partes>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Equipo_partes vo = new Equipo_partes();
				vo.setIdparte(rs.getInt("idparte"));
                                vo.setNom_equipo(rs.getString("nom_equipo"));
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

	public Equipo_partes insertar(Equipo_partes vo) throws DAOExcepcion {
		String query = "INSERT INTO equipo_partes (nom_equipo, equipo,nombre,descripcion) VALUES (?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
                        stmt.setString(1, vo.getNom_equipo());
			stmt.setString(2, vo.getNombre());
			stmt.setString(3, vo.getDescripcion());
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
			vo.setIdparte(id);

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

	public Equipo_partes obtener(int idCategoria) throws DAOExcepcion {
		Equipo_partes vo = new Equipo_partes();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select equipo_partes.* from equipo_partes where idparte=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCategoria);
			rs = stmt.executeQuery();
			if (rs.next()) {
                                vo.setIdparte(rs.getInt(1));
				vo.setNom_equipo(rs.getString(2));
                                vo.setNombre(rs.getString(3));
				vo.setDescripcion(rs.getString(4));
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

	public void eliminar(int idCategoria) throws DAOExcepcion {
		String query = "DELETE FROM equipo_partes WHERE idparte=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idCategoria);
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

	public Equipo_partes actualizar(Equipo_partes vo) throws DAOExcepcion {
		String query = "update equipo_partes set idequipo=?, nombre=?,descripcion=? where idparte=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
                        stmt.setString(1, vo.getNom_equipo());
			stmt.setString(2, vo.getNombre());
			stmt.setString(3, vo.getDescripcion());
			stmt.setInt(3, vo.getIdparte());
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

	public Collection<Equipo_partes> listar() throws DAOExcepcion {
		Collection<Equipo_partes> c = new ArrayList<Equipo_partes>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			String query = "SELECT idparte,nombre,descripcion from equipo_partes";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Equipo_partes vo = new Equipo_partes();
				vo.setIdparte(rs.getInt("idparte"));
                                vo.setNom_equipo(rs.getString("nom_equipo"));
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

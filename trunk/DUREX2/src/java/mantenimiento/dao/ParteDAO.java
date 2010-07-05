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
import mantenimiento.modelo.Parte;
import mantenimiento.util.ConexionBD;




public class ParteDAO extends BaseDAO {

	public Parte obtenerPartePorId(int idEquipo_partes) throws DAOExcepcion {
		Parte vo = new Parte();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select * from partes where equipo_idequipo=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idEquipo_partes);

			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdparte(rs.getInt(1));
				vo.setIdequipo(rs.getInt(2));
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

	public Collection<Parte> buscarPorNombre(String nombre)
			throws DAOExcepcion {
//		String query = "select Parte.*,grupo.nombre as ngrupo from Parte,grupo where Parte.nombre like ? and grupo.idgrupo=Parte.idgrupo";
		String query = "select partes.*,equipo.nombre as nequipo from partes,equipo where partes.nombre like ? and equipo.idequipo=partes.idequipo";
		Collection<Parte> c = new ArrayList<Parte>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + nombre + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Parte vo = new Parte();
				vo.setIdparte(rs.getInt(1));
				vo.setIdequipo(rs.getInt(2));
				vo.setNombre(rs.getString(3));
				vo.setDescripcion(rs.getString(4));
				vo.setNombreequipo(rs.getString("nequipo"));
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

	public Parte insertar(Parte vo) throws DAOExcepcion {
		String query = "INSERT INTO partes(equipo_idequipo,nombre,descripcion) VALUES (?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getIdequipo());
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

	public void eliminar(int idparte) throws DAOExcepcion {
		String query = "DELETE FROM partes WHERE idparte=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idparte);
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

	public Parte actualizar(Parte vo) throws DAOExcepcion {
		String query = "update partes set nombre=?,descripcion=?,idequipo=? where idparte=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getDescripcion());
			stmt.setInt(3, vo.getIdequipo());
			stmt.setInt(4, vo.getIdparte());
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
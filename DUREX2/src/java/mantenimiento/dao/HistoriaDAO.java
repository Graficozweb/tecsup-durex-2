package mantenimiento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Historias;
import mantenimiento.util.ConexionBD;

public class HistoriaDAO extends BaseDAO {

 public Collection<Historias> buscarPorUsuario(String nombre)
            throws DAOExcepcion {
        String query = "select cod_historia,usuario_id_usuario,accion,objeto,nombre_objeto,fecha,hora"
                + " from historia_usuario where usuario_id_usuario like ?";
        Collection<Historias> c = new ArrayList<Historias>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, "%" + nombre + "%");
            rs = stmt.executeQuery();
            String status;
            while (rs.next()) {
                Historias vo = new Historias();

                vo.setId(Integer.parseInt(rs.getString("cod_historia")));
                vo.setUsuario(rs.getString("usuario_id_usuario"));
                vo.setAccion(rs.getString("accion"));
                vo.setObjeto(rs.getString("objeto"));
                vo.setNom_objeto(rs.getString("nombre_objeto"));
                vo.setFecha(rs.getString("fecha"));
                vo.setHora(rs.getString("hora"));

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

	public Historias insertar(Historias vo) throws DAOExcepcion {
		String query = "INSERT INTO historia_usuario(usuario_id_usuario,accion,objeto,nombre_objeto,fecha,hora) VALUES (?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getUsuario());
			stmt.setString(2, vo.getAccion());
			stmt.setString(3, vo.getObjeto());
			stmt.setString(4, vo.getNom_objeto());
			stmt.setString(5, vo.getFecha());
			stmt.setString(6, vo.getHora());
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
			vo.setId(id);
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

	public void eliminar(int idHistorias) throws DAOExcepcion {
		String query = "DELETE FROM herramientas WHERE idHerramientas=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idHistorias);
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

	public Historias actualizar(Historias vo) throws DAOExcepcion {
		String query = "update herramientas set nombre=?,marca=?,modelo=?,dimensiones=?,fabricante=?,idgrupo=? where idHerramientas=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
//			con = ConexionBD.obtenerConexion();
//			stmt = con.prepareStatement(query);
//			stmt.setString(1, vo.getNombre());
//			stmt.setString(2, vo.getMarca());
//			stmt.setString(3, vo.getModelo());
//			stmt.setString(4, vo.getDimensiones());
//			stmt.setString(5, vo.getFabricante());
////			stmt.setString(6, vo.getImagen());
//			stmt.setInt(6, vo.getIdgrupo());
//			stmt.setInt(7, vo.getIdherramienta());
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

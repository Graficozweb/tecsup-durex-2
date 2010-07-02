/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import mantenimiento.excepcion.LoginExcepcion;
import mantenimiento.modelo.Usuario;
import mantenimiento.util.ConexionBD;

public class UsuarioDAO extends BaseDAO {

    public Usuario obtenerPorIdUsuario(String idUsuario) throws DAOExcepcion {
        String query = "select id_usuario, clave, nombre, paterno, materno, mail,telefono ,estado "
                + "from usuario where id_usuario=?";
        Usuario vo = new Usuario();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, idUsuario);
            rs = stmt.executeQuery();
            if (rs.next()) {
                vo.setIdUsuario(rs.getString("id_usuario"));
                vo.setClave(rs.getString("clave"));
                vo.setNombre(rs.getString("nombre"));
                vo.setPaterno(rs.getString("paterno"));
                vo.setMaterno(rs.getString("materno"));
                vo.setMail(rs.getString("mail"));
                vo.setTelefono(rs.getString("telefono"));
                vo.setEstado(rs.getString("estado"));
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

    public Collection<Usuario> buscarPorNombre(String nombre)
            throws DAOExcepcion {
        String query = "select id_usuario,clave,nombre,paterno,materno,mail,telefono,estado "
                + " from usuario where nombre like ?";
        Collection<Usuario> c = new ArrayList<Usuario>();
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
                Usuario vo = new Usuario();

                vo.setIdUsuario(rs.getString("id_usuario"));
                vo.setClave(rs.getString("clave"));
                vo.setNombre(rs.getString("nombre"));
                vo.setPaterno(rs.getString("paterno"));
                vo.setMaterno(rs.getString("materno"));
                vo.setMail(rs.getString("mail"));
                vo.setTelefono(rs.getString("telefono"));
//                vo.setEstado(rs.getString("estado"));
                vo.setStatus(rs.getString("estado"));
                //cambiar valor de estado para morltrarlo
//                status = rs.getString("estado");

                ////////////////////////////////////////
//                vo.setEstado(status);
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

    public Usuario insertar(Usuario vo) throws DAOExcepcion {
        String query = "INSERT INTO usuario (id_usuario,clave,nombre,paterno,materno,mail,telefono,estado) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        System.err.println(query);
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, vo.getIdUsuario());
            stmt.setString(2, vo.getClave());
            stmt.setString(3, vo.getNombre());
            stmt.setString(4, vo.getPaterno());
            stmt.setString(5, vo.getMaterno());
            stmt.setString(6, vo.getMail());
            stmt.setString(7, vo.getTelefono());
            stmt.setString(8, vo.getEstado());

            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo insertar");
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

    public Usuario actualizar(Usuario vo) throws DAOExcepcion {
        String query = "UPDATE usuario SET clave=?, nombre=?, paterno=?, materno=?, mail=?,"
                + " telefono=?, estado=? WHERE id_usuario=?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, vo.getClave());
            stmt.setString(2, vo.getNombre());
            stmt.setString(3, vo.getPaterno());
            stmt.setString(4, vo.getMaterno());
            stmt.setString(5, vo.getMail());
            stmt.setString(6, vo.getTelefono());
            stmt.setString(7, vo.getEstado());
            stmt.setString(8, vo.getIdUsuario());

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

    public void eliminar(String idUsuario) throws DAOExcepcion {
        String query = "DELETE FROM usuario WHERE id_usuario=?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, idUsuario);
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

    public Collection<Usuario> listarTodos() throws DAOExcepcion {
        String query = "select id_usuario,clave,nombre,paterno,materno,mail,telefono,estado"
                + " from usuario";
        Collection<Usuario> c = new ArrayList<Usuario>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario vo = new Usuario();
                vo.setIdUsuario(rs.getString("id_usuario"));
                vo.setClave(rs.getString("clave"));
                vo.setNombre(rs.getString("nombre"));
                vo.setPaterno(rs.getString("paterno"));
                vo.setMaterno(rs.getString("materno"));
                vo.setMail(rs.getString("mail"));
                vo.setTelefono(rs.getString("telefono"));
                vo.setEstado(rs.getString("estado"));
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

    public Usuario validar(String idUsuario, String clave)
            throws DAOExcepcion, LoginExcepcion {
        String query = "select id_usuario, id_aut, nombre, paterno,"
                + "materno, mail, telefono,"
                + "estado from usuario where id_usuario=? and clave=?";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario vo = new Usuario();
        try {
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, idUsuario);
            stmt.setString(2, clave);
            rs = stmt.executeQuery();

            if (rs.next()) {
                vo.setIdUsuario(rs.getString("id_usuario"));
                vo.setNombre(rs.getString("nombre"));
                vo.setPaterno(rs.getString("paterno"));
                vo.setMaterno(rs.getString("materno"));
                vo.setMail(rs.getString("mail"));
                vo.setTelefono(rs.getString("telefono"));
                vo.setEstado(rs.getString("estado"));
            } else {
                throw new LoginExcepcion("No existe");
            }
        } catch (LoginExcepcion e) {
            System.err.println(e.getMessage());
            throw new LoginExcepcion(e.getMessage());
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
}

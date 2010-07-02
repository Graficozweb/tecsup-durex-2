package mantenimiento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import mantenimiento.excepcion.DAOExcepcion;
import mantenimiento.modelo.Equipo;
import mantenimiento.util.ConexionBD;

public class EquipoDAO extends BaseDAO {

    public Collection<Equipo> buscarPorNombre(String nombre)
            throws DAOExcepcion {
        String query = "select idequipo, nombre, modelo, marca, nro_serie from equipo where nombre like ?";
        Collection<Equipo> lista = new ArrayList<Equipo>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, "%" + nombre + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Equipo vo = new Equipo();
                vo.setIdequipo(rs.getInt("idequipo"));
                vo.setNombre(rs.getString("nombre"));
                vo.setModelo(rs.getString("modelo"));
                vo.setMarca(rs.getString("marca"));
                vo.setNro_serie(rs.getString("nro_serie"));
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

    public Equipo insertar(Equipo vo) throws DAOExcepcion {
        String query = "INSERT INTO equipo (nombre,funcion,ubicacion,tamano,capacidad_velocidad,marca,modelo,proveedor,telefono,potencia,voltaje,vida_util,fecha_fab,fecha_insta,actualizacion,costo_original,costo_actual,estado_equipo,criticidad,nro_serie) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, vo.getNombre());
            stmt.setString(2, vo.getFuncion());
            stmt.setString(3, vo.getUbicacion());
            stmt.setString(4, vo.getTamano());
            stmt.setString(5, vo.getCapacidad_velocidad());
            stmt.setString(6, vo.getMarca());
            stmt.setString(7, vo.getModelo());
            stmt.setString(8, vo.getProveedor());
            stmt.setString(9, vo.getTelefono());
            stmt.setString(10, vo.getPotencia());
            stmt.setString(11, vo.getVoltaje());
            stmt.setString(12, vo.getVida_util());
            stmt.setString(13, vo.getFecha_fab());
            stmt.setString(14, vo.getFecha_insta());
            stmt.setString(15, vo.getActualizacion());
            stmt.setString(16, vo.getCosto_original());
            stmt.setString(17, vo.getCosto_actual());
            stmt.setString(18, vo.getEstado_equipo());
            stmt.setString(19, vo.getCriticidad());
            stmt.setString(20, vo.getNro_serie());
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
            vo.setIdequipo(id);

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

    public Equipo obtener(int idequipo) throws DAOExcepcion {
        Equipo vo = new Equipo();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "select equipo.* from equipo where idequipo=?";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idequipo);
            rs = stmt.executeQuery();
            if (rs.next()) {
                vo.setIdequipo(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setFuncion(rs.getString(3));
                vo.setUbicacion(rs.getString(4));
                vo.setTamano(rs.getString(5));
                vo.setCapacidad_velocidad(rs.getString(6));
                vo.setMarca(rs.getString(7));
                vo.setModelo(rs.getString(8));
                vo.setProveedor(rs.getString(9));
                vo.setTelefono(rs.getString(10));
                vo.setPotencia(rs.getString(11));
                vo.setVoltaje(rs.getString(12));
                vo.setVida_util(rs.getString(13));
                vo.setFecha_fab(rs.getString(14));
                vo.setFecha_insta(rs.getString(15));
                vo.setActualizacion(rs.getString(16));
                vo.setCosto_original(rs.getString(17));
                vo.setCosto_actual(rs.getString(18));
                vo.setEstado_equipo(rs.getString(19));
                vo.setCriticidad(rs.getString(20));
                vo.setNro_serie(rs.getString(21));
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

    public void eliminar(int idequipo) throws DAOExcepcion {
        String query = "delete from equipo WHERE idequipo=?";
        Connection con = null;
        PreparedStatement stmt = null;
        System.out.println(query);
        System.out.println(idequipo);
        try {
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idequipo);
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

    public Equipo actualizar(Equipo vo) throws DAOExcepcion {
        String query = "update equipo set nombre=?,funcion=?,ubicacion=?"
                + " ,tamano=?,capacidad_velocidad=?,marca=?,modelo=?, proveedor=?, telefono=?, potencia=?"
                + " ,voltaje=?,vida_util=?, fecha_fab=?,fecha_insta=?,actualizacion=?"
                + " ,costo_original=?,costo_actual=?, estado_equipo=?, criticidad=?"
                + " ,nro_serie=? where idequipo=?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);

            stmt.setString(1, vo.getNombre());
            stmt.setString(2, vo.getFuncion());
            stmt.setString(3, vo.getUbicacion());
            stmt.setString(4, vo.getTamano());
            stmt.setString(5, vo.getCapacidad_velocidad());
            stmt.setString(6, vo.getMarca());
            stmt.setString(7, vo.getModelo());
            stmt.setString(8, vo.getProveedor());
            stmt.setString(9, vo.getTelefono());
            stmt.setString(10, vo.getPotencia());
            stmt.setString(11, vo.getVoltaje());
            stmt.setString(12, vo.getVida_util());
            stmt.setString(13, vo.getFecha_fab());
            stmt.setString(14, vo.getFecha_insta());
            stmt.setString(15, vo.getActualizacion());
            stmt.setString(16, vo.getCosto_original());
            stmt.setString(17, vo.getCosto_actual());
            stmt.setString(18, vo.getEstado_equipo());
            stmt.setString(19, vo.getCriticidad());
            stmt.setString(20, vo.getNro_serie());
            stmt.setInt(21, vo.getIdequipo());

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

    public Collection<Equipo> listar() throws DAOExcepcion {
        Collection<Equipo> c = new ArrayList<Equipo>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionBD.obtenerConexion();
            String query = "SELECT nombre, funcion, ubicacion, tamano, capacidad_velocidad, marca, modelo, proveedor, telefono, voltaje, potencia, vida_util, fecha_fab, fecha_insta, actualizacion, costo_original, costo_actual, estado_equipo, criticidad, nro_serie from equipo";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Equipo vo = new Equipo();

                vo.setIdequipo(rs.getInt("idequipo"));
                vo.setNombre(rs.getString("nombre"));
                vo.setFuncion(rs.getString("funcion"));
                vo.setUbicacion(rs.getString("ubicacion"));
                vo.setTamano(rs.getString("tamano"));
                vo.setCapacidad_velocidad(rs.getString("capacidad_velocidad"));
                vo.setMarca(rs.getString("marca"));
                vo.setModelo(rs.getString("modelo"));
                vo.setProveedor(rs.getString("proveedor"));
                vo.setTelefono(rs.getString("telefono"));
                vo.setPotencia(rs.getString("potencia"));
                vo.setVoltaje(rs.getString("voltaje"));
                vo.setVida_util(rs.getString("vida_util"));
                vo.setFecha_fab(rs.getString("fecha_fab"));
                vo.setFecha_insta(rs.getString("fecha_insta"));
                vo.setActualizacion(rs.getString("actualizacion"));
                vo.setCosto_original(rs.getString("costo_original"));
                vo.setCosto_actual(rs.getString("costo_actual"));
                vo.setEstado_equipo(rs.getString("estado_equipo"));
                vo.setCriticidad(rs.getString("criticidad"));
                vo.setNro_serie(rs.getString("nro_serie"));
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

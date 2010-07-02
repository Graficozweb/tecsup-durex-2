/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantenimiento.modelo;

/**
 *
 * @author PFR
 */
public class Mantenimiento {

    private int idMantenimiento;
    private String idusuario;
    private int Detalle_Mantenimiento_idDetalle_Mantenimiento;
    private int equipo_idequipo;
    private String fecha_ini;
    private String fecha_fin;
    private String estado;
    private String descripcion;
    private String tipo_mant;
    private String criticidad;

    public int getDetalle_Mantenimiento_idDetalle_Mantenimiento() {
        return Detalle_Mantenimiento_idDetalle_Mantenimiento;
    }

    public void setDetalle_Mantenimiento_idDetalle_Mantenimiento(int Detalle_Mantenimiento_idDetalle_Mantenimiento) {
        this.Detalle_Mantenimiento_idDetalle_Mantenimiento = Detalle_Mantenimiento_idDetalle_Mantenimiento;
    }

    public String getCriticidad() {
        return criticidad;
    }

    public void setCriticidad(String criticidad) {
        this.criticidad = criticidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEquipo_idequipo() {
        return equipo_idequipo;
    }

    public void setEquipo_idequipo(int equipo_idequipo) {
        this.equipo_idequipo = equipo_idequipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getTipo_mant() {
        return tipo_mant;
    }

    public void setTipo_mant(String tipo_mant) {
        this.tipo_mant = tipo_mant;
    }

    

}

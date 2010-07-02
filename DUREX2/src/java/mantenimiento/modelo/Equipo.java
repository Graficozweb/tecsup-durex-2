/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantenimiento.modelo;

/**
 *
 * @author Albert
 */
public class Equipo {

        private int idequipo;
        private String nombre;
	private String funcion;
	private String ubicacion;
	private String tamano;
	private String capacidad_velocidad;
	private String marca;
	private String modelo;
        private String proveedor;
        private String telefono;
	private String potencia;
        private String voltaje;
	private String vida_util;
	private String fecha_fab;
	private String fecha_insta;
	private String actualizacion;
        private String costo_original;
	private String costo_actual;
        private String estado_equipo;
	private String criticidad;
        private String nro_serie;

    public String getActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(String actualizacion) {
        this.actualizacion = actualizacion;
    }

    public String getCapacidad_velocidad() {
        return capacidad_velocidad;
    }

    public void setCapacidad_velocidad(String capacidad_velocidad) {
        this.capacidad_velocidad = capacidad_velocidad;
    }

    public String getCosto_actual() {
        return costo_actual;
    }

    public void setCosto_actual(String costo_actual) {
        this.costo_actual = costo_actual;
    }

    public String getCosto_original() {
        return costo_original;
    }

    public void setCosto_original(String costo_original) {
        this.costo_original = costo_original;
    }

    public String getCriticidad() {
        return criticidad;
    }

    public void setCriticidad(String criticidad) {
        this.criticidad = criticidad;
    }

    public String getEstado_equipo() {
        return estado_equipo;
    }

    public void setEstado_equipo(String estado_equipo) {
        this.estado_equipo = estado_equipo;
    }

    public String getFecha_fab() {
        return fecha_fab;
    }

    public void setFecha_fab(String fecha_fab) {
        this.fecha_fab = fecha_fab;
    }

    public String getFecha_insta() {
        return fecha_insta;
    }

    public void setFecha_insta(String fecha_insta) {
        this.fecha_insta = fecha_insta;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipo) {
        this.idequipo = idequipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNro_serie() {
        return nro_serie;
    }

    public void setNro_serie(String nro_serie) {
        this.nro_serie = nro_serie;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getVida_util() {
        return vida_util;
    }

    public void setVida_util(String vida_util) {
        this.vida_util = vida_util;
    }

    public String getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(String voltaje) {
        this.voltaje = voltaje;
    }

 
}

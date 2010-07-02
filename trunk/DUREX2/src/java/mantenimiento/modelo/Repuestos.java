/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantenimiento.modelo;

/**
 *
 * @author supervisor
 */
public class Repuestos {

   private int idRepuestos;
   private String nombre;
   private String descripcion;
   private int cantidad;
   private int costo;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdRepuestos() {
        return idRepuestos;
    }

    public void setIdRepuestos(int idRepuestos) {
        this.idRepuestos = idRepuestos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

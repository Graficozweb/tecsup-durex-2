/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantenimiento.modelo;

/**
 *
 * @author supervisor
 */
public class Actividades {

    private int idActividades;
    private String descripcion;
    private int horas_hombre;
    private int costos;

    public int getCostos() {
        return costos;
    }

    public void setCostos(int costos) {
        this.costos = costos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHoras_hombre() {
        return horas_hombre;
    }

    public void setHoras_hombre(int horas_hombre) {
        this.horas_hombre = horas_hombre;
    }

    public int getIdActividades() {
        return idActividades;
    }

    public void setIdActividades(int idActividades) {
        this.idActividades = idActividades;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    private int tiempo;



}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantenimiento.modelo;

/**
 *
 * @author supervisor
 */
public class Trabajador {

    private int idTrabajador;

    public int getCosto_horas() {
        return costo_horas;
    }

    public void setCosto_horas(int costo_horas) {
        this.costo_horas = costo_horas;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
    private String funcion;
    private int costo_horas;


}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantenimiento.modelo;

/**
 *
 * @author Albert
 */
public class Parte {

    private int idparte;
    private int idequipo;
    private String nombre;
    private String descripcion;
    private String nombreequipo;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipo) {
        this.idequipo = idequipo;
    }

    public int getIdparte() {
        return idparte;
    }

    public void setIdparte(int idparte) {
        this.idparte = idparte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreequipo() {
        return nombreequipo;
    }

    public void setNombreequipo(String nombreequipo) {
        this.nombreequipo = nombreequipo;
    }
    

}

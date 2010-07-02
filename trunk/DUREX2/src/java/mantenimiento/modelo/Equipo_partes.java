/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantenimiento.modelo;

/**
 *
 * @author Albert
 */
public class Equipo_partes {

    private int idparte;
    private String nom_equipo;
    private String nombre;
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdparte() {
        return idparte;
    }

    public void setIdparte(int idparte) {
        this.idparte = idparte;
    }

    public String getNom_equipo() {
        return nom_equipo;
    }

    public void setNom_equipo(String nom_equipo) {
        this.nom_equipo = nom_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   

}

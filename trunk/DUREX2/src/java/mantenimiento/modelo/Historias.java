/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimiento.modelo;

/**
 *
 * @author FREDY
 */
public class Historias {

    private int id;
    private String usuario;
    private String accion;
    private String objeto;
    private String nom_objeto;
    private String fecha;
    private String hora;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_objeto() {
        return nom_objeto;
    }

    public void setNom_objeto(String nom_objeto) {
        this.nom_objeto = nom_objeto;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}

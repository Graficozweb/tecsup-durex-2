
package mantenimiento.modelo;
/**
 *
 * @author FREDY
 */
public class Usuario {
	private String idUsuario;
        private String id_aut;
	private String clave;
	private String nombre;
	private String paterno;
	private String materno;
	private String telefono;
	private String mail;
	private String estado;
        private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        
        if (status.equals("1")) {
            status = "Habilitado";
        } else {
            status = "Deshabilitado";
        }
        this.status = status;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getId_aut() {
        return id_aut;
    }

    public void setId_aut(String id_aut) {
        this.id_aut = id_aut;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }




}

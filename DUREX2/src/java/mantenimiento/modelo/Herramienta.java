package mantenimiento.modelo;

/**
 *
 * @author FREDY
 */
public class Herramienta {

    private int idherramienta;
    private int idgrupo;
    private String nombre;
    private String marca;
    private String modelo;
    private String dimensiones;
    private String fabricante;
    private String nombreGrupo;


    public int getIdherramienta() {
        return idherramienta;
    }

    public void setIdherramienta(int idherramienta) {
        this.idherramienta = idherramienta;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
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
}

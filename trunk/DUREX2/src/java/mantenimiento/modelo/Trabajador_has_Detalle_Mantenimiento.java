/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantenimiento.modelo;

/**
 *
 * @author PFR
 */
public class Trabajador_has_Detalle_Mantenimiento {

    private int Trabajador_idTrabajador;
    private int Detalle_Mantenimiento_idDetalle_Mantenimiento;

    public int getDetalle_Mantenimiento_idDetalle_Mantenimiento() {
        return Detalle_Mantenimiento_idDetalle_Mantenimiento;
    }

    public void setDetalle_Mantenimiento_idDetalle_Mantenimiento(int Detalle_Mantenimiento_idDetalle_Mantenimiento) {
        this.Detalle_Mantenimiento_idDetalle_Mantenimiento = Detalle_Mantenimiento_idDetalle_Mantenimiento;
    }

    public int getTrabajador_idTrabajador() {
        return Trabajador_idTrabajador;
    }

    public void setTrabajador_idTrabajador(int Trabajador_idTrabajador) {
        this.Trabajador_idTrabajador = Trabajador_idTrabajador;
    }


}

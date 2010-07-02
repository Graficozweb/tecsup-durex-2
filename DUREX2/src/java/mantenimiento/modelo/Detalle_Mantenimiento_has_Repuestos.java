/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantenimiento.modelo;

/**
 *
 * @author PFR
 */
public class Detalle_Mantenimiento_has_Repuestos {

    private int Detalle_Mantenimiento_idDetalleMantenimiento;
    private int Repuestos_idRepuestos;

    public int getDetalle_Mantenimiento_idDetalleMantenimiento() {
        return Detalle_Mantenimiento_idDetalleMantenimiento;
    }

    public void setDetalle_Mantenimiento_idDetalleMantenimiento(int Detalle_Mantenimiento_idDetalleMantenimiento) {
        this.Detalle_Mantenimiento_idDetalleMantenimiento = Detalle_Mantenimiento_idDetalleMantenimiento;
    }

    public int getRepuestos_idRepuestos() {
        return Repuestos_idRepuestos;
    }

    public void setRepuestos_idRepuestos(int Repuestos_idRepuestos) {
        this.Repuestos_idRepuestos = Repuestos_idRepuestos;
    }

}

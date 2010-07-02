/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mantenimiento.modelo;

import java.util.Calendar;

/**
 *
 * @author FREDY
 */
public class Fecha {
    
private String date;
private String time;
Calendar fecha = Calendar.getInstance();

    public String getFecha() {

              //formato para la fecha
      String dia=Integer.toString(fecha.get(Calendar.DATE));
      String mes=Integer.toString(fecha.get(Calendar.MONTH));
      String anio=Integer.toString(fecha.get(Calendar.YEAR));

 if(mes.length()==1){
       mes="0"+mes;
       }
       if(dia.length()==1){
       dia="0"+dia;
       }
       String fecha_actual=anio+"-"+mes+"-"+dia;
       date=fecha_actual;
        return date;
    }

    public String getHora() {

         // formato para la hora actual
     String hora= Integer.toString(fecha.get(Calendar.HOUR));
       String min= Integer.toString(fecha.get(Calendar.MINUTE));
       String sec= Integer.toString(fecha.get(Calendar.SECOND));

       if(hora.length()==1){
       hora="0"+hora;
       }
        if(min.length()==1){
       min="0"+min;
       }
        if(sec.length()==1){
       sec="0"+sec;
       }
       String hora_actual=hora+":"+min+":"+sec;
       time=hora_actual;
       return time;
    }

}


<%@include file="ValidarSession.jsp"%>
<%@include file="cabecera.jsp"%>.
<form action="ingresaroperaciones" method="post" name="form1"  id="form1">
<table align="center" width="960" border="0" cellspacing="0" cellpadding="0" width="402" bgcolor="#FFFFFF">
    

        

        

            <tr>
                <td colspan="3" class="estilo">   <p>&nbsp;</p> <div align="center">Operaciones Programadas</div>

                <p>&nbsp;</p>
                </td>

              
            </tr>
            <tr>


                <td colspan="4" class="estilo">

                    <div align="left">C&oacute;digo:
                        <input name="textfield7" type="text" id="codigomant" value="" size="15" />

                        Fecha Inicio:
                        <input name="textfield3" type="text1" id="fecha_ini" value="" size="18" />
                        Fecha final:
                        <input name="textfield6" type="text5" id="fecha_fin" value="" size="18" />
                    </div>
                </td>
            </tr>


            <tr>
                <td height="22" class="fuente">Equipo:</td>
                <td colspan="2" class="estilo">
                    <input name="textfield" type="text" id="equipo" value="" size="20" />
                    <input type="button" onclick="window.location='cronoacti.html'"  name="button" id="buscarequipo" value="Buscar" />
                </td>


            <tr>
                <td width="147" > <div align="left">Descripci&oacute;n:</div></td>
                <td colspan="2">

                    <textarea name="textarea" id="descripcion" cols="48" rows="2"></textarea>
            </tr>
            <tr>
                <td class="fuente"><div align="left" >Actividad:</div></td>
                <td colspan="2" class="estilo">
                    <input name="textfield2" type="text" id="idactividad" value="" size="20" />
                    <input type="button" onclick="window.location='cronoacti.html'"  name="button" id="buscarequipo" value="Buscar" />

                </td>
            </tr>
            <tr>
                <td height="22" class="fuente"><div align="left">Responsable:</div></td>
                <td colspan="2" class="estilo"> 
                        <input name="textfield5" type="text" id="idusuario" value="" size="20" />
                        <input type="button" onclick="window.location='cronoacti.html'"  name="button" id="buscarequipo" value="Buscar" />
                    </td>
            </tr>
            <tr>
                 <td height="22" class="fuente"><div align="left">Tipo de Mantenimiento</div></td>
             <td
            <select name="tipo_mant" id="tipo_mant">
                <option value="0">Elegir Mantenimiento</option>
                <option value="1">Mantenimiento Preventivo</option>
                <option value="2">Matenimiento Correctivo</option>
            </select>
            </td>
            </tr>

            <tr>
                <td class="fuente"><div align="left" >Criticidad:</div></td>
                <td width="48" class="estilo"><input name="textfield4" type="text" id="criticidad" value="16" size="6" /></td>
                <td width="125" class="fuente"><div align="center"><a href="escala.jsp">Escala</a></div>
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <input align="right" type="submit"  name="button" id="guardar" value="guardar" />

                </td>
            </tr>
            <tr>

            </tr>
            <tr>
                <td colspan="3"><span class="fuente Estilo15">

                        <a href="Mantenimiento.html"><img src="Imagenes/volver_icono.jpg" alt="" width="29" height="28" /></a> Volver

                    </span></td>

            </tr>

    
</table>
</form>



<%@include file="pie.jsp"%>


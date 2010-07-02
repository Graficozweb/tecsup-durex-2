<%-- 
    Document   : inventario
    Created on : 14/06/2010, 03:56:49 PM
    Author     : supervisor
--%>

<%@include file="ValidarSession.jsp"%>
<%@include file="cabecera.jsp"%>
<table align="center" width="960" bgcolor="#FFFFFF">
    <tr>
        <td >
            <p align="center" style="font-family: Calibri; font-size: 24px; font-weight: bold">Inventario</p>
      <div align="center"></div></td>
    </tr>

    <tr>
        <td ><div align="center">
        <p>&nbsp;</p>
        <div align="center">
                    <input type="button" onclick="window.location='equipo.jsp'"  name="equipos" id="equipos" value="                   Equipos                   " />
                </div>
            </div></td>
    </tr>
    <tr>
        <td><div align="center">
                    <input type="button" onclick="window.location='herramienta.jsp'"  name="herramientas" id="herramientas" value="                 Herramientas             " />
</div>
              </td>

    </tr>
    
    <tr>
        <td><div align="center">
                    <input type="button" onclick="window.location='parte_equipo.jsp'"  name="partes" id="partes" value="                    Partes                    " />
</div>
               </td>
		
    </tr>
     <tr>
        <td><div align="center">
          <input type="button" onclick="window.location='grupo_herramienta.jsp'"  name="grupos" id="grupos" value="                   Grupos                   " />
              </div>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
       <p>&nbsp;</p></td>
		
    </tr>
</table>

<%@include file="pie.jsp"%>
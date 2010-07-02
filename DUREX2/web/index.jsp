<%-- 
    Document   : index
    Created on : 13-jun-2010, 16:12:13
    Author     : FREDY
--%>

<%--<%@include file="cabecera.jsp"%>

<form action="LoginServlet" method="post">
Usuario: <input type="text" name="usuario"/> <br/>
Clave: <input type="password" name="clave"/> <br/>
<input type="submit" value="Ingresar"/>
</form>

<%@include file="pie.jsp"%>--%>
<html>
    <head>
        <style type="text/css">
            <!--
            .titulo {
                font-family: "Times New Roman", Times, serif;
                font-size: 36px;
                font-style: normal;
                line-height: normal;
                font-weight: bolder;
                font-variant: normal;
                color: #003399;
            }
            .pie_derechos {
                font-family: Verdana, Arial, Helvetica, sans-serif;
                font-size: 10px;
                font-weight: bold;
                color: #666666;
            }
            .subtitulo {
                font-family: Verdana, Arial, Helvetica, sans-serif;
                font-size: 12px;
                font-weight: bold;
                color: #666666;
            }
            -->
        </style>
        <title>Log In</title>
    </head>

    <body topmargin="0" leftmargin="0"  bgcolor="#EEEEEE">

        <form action="LoginServlet" method="post">

            <br><br><br><br>
            <table cellpadding="0" cellspacing="0" width="700px" class="grilla" align="center" border="0"  bgcolor="#048BBB">
                <tr>
                    <td colspan="4" style="color:#FFFFFF"><div align="center"><b>SOFTWARE DE MANTENIMIENTO</b></div></td>

                </tr>
            </table>
            <table cellpadding="0" cellspacing="0" border="0"  align="center" bgcolor="#FFFFFF" >
                <tr>
                    <td><img src="Imagenes/mantenimiento.jpg" width="369" height="268"></td>
                    <td width="329px" valign="top">
                        <table class="tabla" height="255px" width="300" border="0">
                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                            </tr>
                            <tr>
                                <td colspan="3" align=center><b>&nbsp;</b></td>
                            </tr>
                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>                               
                                <td>&nbsp;</td>
                            </tr>
                            <tr height="10%">
                                <td width="25%">&nbsp; </td>
                                <td class="subtitulo" style="color: #048BBB;">Usuario :</td>
                                <td>
                                    <input type="text" name="usuario"/>
                                </td>
                            </tr>
                            <tr height="10%">
                                <td>&nbsp;</td>
                                <td class="subtitulo" style="color: #048BBB;">Clave :</td>
                                <td>
                                    <input type="password" name="clave"/>
                                </td>
                            </tr>
                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td><input  type="submit" value="Ingresar">

                                    &nbsp;

                                </td>
                            </tr>
                            <tr>                             
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <% String y = (String) request.getAttribute("mensaje_error2");
                                            String error = " ";
                                            String x = (String) request.getAttribute("mensaje_error");
                                            String msj = " ";
                                            if (y == null) {
                                                if (x == null) {
                                                } else {
                                                    msj = "Usuario deshabilitado";
                                                    request.setAttribute("mensaje_error", "");
                                                }
                                            } else {
                                                error = "clave/usuario incorrectos";
                                                 request.setAttribute("mensaje_error2", "");
                                            }

                                %>
                                <td style="color:#DD0000"><%= error%><%= msj%></td>
                            </tr>

                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <table cellpadding="0" cellspacing="0" width="700px" class="grilla" align="center" bgcolor="#048BBB">
                <tr>
                    <td>&nbsp;</td>
                </tr>
            </table>

        </form>
    </body>
</html>

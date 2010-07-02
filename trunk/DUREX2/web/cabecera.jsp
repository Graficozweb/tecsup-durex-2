<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <style type="text/css">
            <!--
            .main {
                font: 14pt Verdana, Geneva, Arial, Helvetica, sans-serif;

            }
            .titulo {
                font-family: Verdana, Arial, Helvetica, sans-serif;
                font-size: 14px;
                font-weight: bold;
                color: #ffffff;
            }
            .pie_derechos {
                font-family: Verdana, Arial, Helvetica, sans-serif;
                font-size: 10px;
                font-weight: bold;
                color: #ffffff;
            }
            .subtitulo {
                font-family: Verdana, Arial, Helvetica, sans-serif;
                font-size: 12px;
                font-weight: bold;
                color: #666666;
            }
            ._sans {
                font-family: _sans;
                font-size: 12px;
                font-weight: bold;
                color: #000000;
            }
            #cuerpo{
                margin: auto;
                border-color:#834E1D;
                border-width: 1px;
                border-style: solid;
                width:960px;
            }
            -->
        </style>
        <% String display = "style='display: none'";%>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Software Mantenimiento</title>
        <script src="DWConfiguration/ActiveContent/IncludeFiles/AC_RunActiveContent.js" type="text/javascript"></script>

        <script language="JavaScript">
            function mueveReloj(){
                momentoActual = new Date()
                hora = momentoActual.getHours()
                minuto = momentoActual.getMinutes()
                segundo = momentoActual.getSeconds()

                horaImprimible = hora + " : " + minuto + " : " + segundo

                document.form_reloj.reloj.value = horaImprimible

                setTimeout("mueveReloj()",1000)
            }
        </script>
        <% String usr = "'${sessionScope.USUARIO_ACTUAL.id_usuario}'";%>

    </head>
    <%--#EEEEEE #0099CC--%>
    <body bgcolor="#EEEEEE" onload="mueveReloj()" style="font: 14pt Verdana, Geneva, Arial, Helvetica, sans-serif; ">
        <table width="960" border="0" align="center" bgcolor="#CCCCCC" height="20">
            <tr>
                <td class="subtitulo" style="color: #048BBB;"><strong style="color: #000000">Bienvenido al sistema:</strong>  <b>${sessionScope.USUARIO_ACTUAL.nombre } ${sessionScope.USUARIO_ACTUAL.paterno }</b></td>
                <td align="right" class="subtitulo"><a href="historia.jsp">Historial</a> | <a href="LogoutServlet">Salir</a></td>
            </tr>
        </table>
        <table width="960" border="0" align="center" class="grilla">
            <tr>
                <td width="960"><script type="text/javascript">
                        <%--AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0','width','960','height','150','title','header','src','file:///C|/Users/FREDY/Documents/NetBeansProjects/PRE-PREDUREX/web/swf/header','quality','high','pluginspage','http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash','movie','file:///C|/Users/FREDY/Documents/NetBeansProjects/PRE-PREDUREX/web/swf/header' ); //end AC code--%>
                    </script><noscript>
                        <%-- <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="900" height="550">
                       <param name="movie" value="swf/header.swf">
                       <param name="quality" value="high">
                       <embed src="swf/header.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="900" height="550"></embed>
                         </object>--%></noscript></td>
            </tr>
            <tr>
                <td width="100%" align="center">
                    <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="100%" height="150">
                        <param name="movie" value="swf/header.swf">
                        <param name="quality" value="high">
                        <embed src="swf/header.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="960" height="150"></embed>
                    </object>

            </tr>
        </table>
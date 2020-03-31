<%-- 
    Document   : Auto
    Created on : 30/03/2020, 07:33:58 PM
    Author     : Jose Sanchez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sistema de cotización de seguros de auto</h1>
        <h2>Datos personales</h2>
        <form name="FormaUno" action="Cotizacion.jsp" method="POST">
        <%
            out.println("<p>Estimado: " + request.getParameter("name") + " " + request.getParameter("lastname") + "</p>");
            out.println("<p>En función de los datos proporcionados </p>");
            if (request.getParameter("age") != null) {
                out.println("<p>Edad: " + request.getParameter("age") + "</p>");
            } else {
                out.println("<p>Edad: desconocido" + "</p>");
            }
            out.println("<p>Género: " + request.getParameter("genero") + "</p>");
            out.println("<p>Estado: " + request.getParameter("region") + "</p>");

            out.println("<input type='hidden' name='name' value='" + request.getParameter("name") + "'>");
            out.println("<input type='hidden' name='lastname' value='" + request.getParameter("lastname") + "'>");
            out.println("<input type='hidden' name='genero' value='" + request.getParameter("genero") + "'>");
            out.println("<input type='hidden' name='age' value='" + request.getParameter("age") + "'>");
            out.println("<input type='hidden' name='region' value='" + request.getParameter("region") + "'>");

        %>
        <h2>Datos del auto</h2>

        <table border="1">
            <thead>
                <tr>
                    <th>Campo</th>
                    <th>Valor</th>
                    
                </tr>
            </thead>
                <tbody>
                    <tr>
                        <td>Marca</td>
                        <td>
                            <select name="marca">
                                <option>Chevrolet</option>
                                <option>VW</option>
                                <option>Kia</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Modelo</td>
                        <td>
                            <input type="number" name="modelo" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>Placas</td>
                        <td>
                            <input type="text" name="placa" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Limpiar" name="btl" />
                        </td>
                        <td>
                            <input type="submit" value="Enviar" name="btEnviar" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>

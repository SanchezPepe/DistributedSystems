<%-- 
    Document   : final
    Created on : 30/03/2020, 05:35:46 PM
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
        <h1>Cotización del seguro</h1>
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

            out.println("<p>Marca: " + request.getParameter("marca") + "</p>");
            out.println("<p>Modelo: " + request.getParameter("modelo") + "</p>");
            out.println("<p>Placa: " + request.getParameter("placa") + "</p>");

            int costo = Integer.parseInt(request.getParameter("modelo"));
            out.println("<p>Cotización del seguro: </p>");
            out.println("$" + (1000 + costo));
        %>
    </body>
</html>

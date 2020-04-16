<%-- 
    Document   : index
    Created on : 15/04/2020, 05:30:42 PM
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
        <h1>Bienvenido a CineMás</h1>
        <form action="GetSuggestion">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Zona</td>
                        <td>
                            <select name="zona">
                                <option>Centro</option>
                                <option>Sur</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Tipo película</td>
                        <td>
                            <select name="tipo">
                                <option>Comedia</option>
                                <option>Suspenso</option>
                            </select>
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Limpiar" />
            <input type="submit" value="Ver recomendación" />
        </form>
    </body>
</html>

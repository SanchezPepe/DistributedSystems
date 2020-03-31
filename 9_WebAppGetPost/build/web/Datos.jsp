<%-- 
    Document   : index
    Created on : 30/03/2020, 05:34:53 PM
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
        <table border="1">
            <thead>
                <tr>
                    <th>Campo</th>
                    <th>Valor</th>
                </tr>
            </thead>
            <tbody>
            <form name="FormaUno" action="Auto.jsp" method="POST">

                <tr>
                    <td>Nombre</td>
                    <td>
                        <input type="text" name="name" value="" />
                    </td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td>
                        <input type="text" name="lastname" value="" />
                    </td>
                </tr>
                <tr>
                    <td>Género</td>
                    <td>
                        <input type="radio" name="genero" value="masc" />
                        <label for="masc">Masculino</label><br>
                        <input type="radio" name="genero" value="Femenino" />
                        <label for="fem">Femenino</label><br>
                    </td>
                </tr>
                <tr>
                    <td>Edad</td>
                    <td>
                        <input type="number" name="age" value="" />
                    </td>
                </tr>
                <tr>
                    <td>Estado</td>
                    <td>
                        <select name="region">
                            <option>CDMX</option>
                            <option>Jalisco</option>
                            <option>Nuevo León</option>
                        </select>
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
            </form>
        </tbody>
    </table>
</body>
</html>

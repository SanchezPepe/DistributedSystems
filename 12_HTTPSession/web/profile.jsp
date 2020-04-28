<%-- 
    Document   : profile
    Created on : 22/04/2020, 05:33:40 PM
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
        <%
            HttpSession mySession = request.getSession();
            if(mySession.getAttribute("usuario") != null){
                out.println("<p>" + mySession.getAttribute("usuario") + " aquí están tus fotos </p>");
                out.println("<a href='Signout'>Cerrar sesión</a>");
            } else {
                response.sendRedirect("index.html");
            }
        
        %>
        
    </body>
</html>

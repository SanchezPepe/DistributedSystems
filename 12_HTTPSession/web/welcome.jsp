<%-- 
    Document   : welcome
    Created on : 22/04/2020, 05:33:25 PM
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
            if(request.getParameter("contrasena") != null && request.getParameter("contrasena").equals("abc123")){
                HttpSession mySession = request.getSession();
                mySession.setAttribute("usuario", request.getParameter("usuario"));
                mySession.setAttribute("constrasena", request.getParameter("constrasena"));
                out.println("<p>Welcome " + request.getParameter("usuario") + "</p>");
                out.println("<a href='profile.jsp'>Visita tu perfil</a>");
            } else {
                response.sendRedirect("index.html");
            }
        %>
    </body>
</html>

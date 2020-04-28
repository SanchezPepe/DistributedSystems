<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%-- 
    Document   : index
    Created on : 27/04/2020, 05:27:43 PM
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
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");

                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/myDB", "root", "root");

                Statement query = con.createStatement();

                ResultSet rs = query.executeQuery("SELECT * FROM CUSTOMERS");
                out.println("<h1>Staff</h1>");
                while (rs.next()) {
                    out.println("Id: " + rs.getInt("ID"));
                    out.println(" Name: " + rs.getString("NAME"));
                    out.println(" Balance: " + rs.getDouble("BALANCE"));
                    out.println("<br>");
                }

                String q = "EMPTY";
                if (request.getParameter("update") != null) {
                    q = "UPDATE CUSTOMERS SET NAME = '" + request.getParameter("nameUp") + "', BALANCE = " + request.getParameter("balanceUp") + "WHERE id= " + request.getParameter("idUp");
                    query.executeUpdate(q);
                } else if (request.getParameter("add") != null) {
                    q = "INSERT INTO CUSTOMERS (id,name,balance) VALUES (" + request.getParameter("id") + ", '" + request.getParameter("name") + "', " + request.getParameter("balance") + ")";
                    query.executeUpdate(q);
                } else if (request.getParameter("delete") != null) {
                    q = "DELETE FROM CUSTOMERS WHERE id= " + request.getParameter("idDel");
                    query.executeUpdate(q);
                }
                
                con.commit();
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        %>
        <h2>Add a record</h2>
        <form action="index.jsp">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Id:<input type="text" name="id" value="" /></td>
                        <td>Name:<input type="text" name="name" value="" /></td>
                        <td>Balance:<input type="text" name="balance" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Add" name="add"/>
        </form>


        <h2>Delete a record</h2>
        <form action="index.jsp">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Id:<input type="text" name="idDel" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Delete" name="delete"/>
        </form>


        <h2>Update a record</h2>
        <form action="index.jsp">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Id:<input type="text" name="idUp" value="" /></td>
                        <td>Name:<input type="text" name="nameUp" value="" /></td>
                        <td>Balance:<input type="text" name="balanceUp" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Update" name="update"/>
        </form>

    </body>
</html>

<%-- 
    Document   : registrationform.jsp
    Created on : 16/04/2021, 18:01:40
    Author     : Alumne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body BGCOLOR="#FDF5E6">
        <% String nom = String.valueOf(session.getAttribute("nom"));%>
        <% String cognom = String.valueOf(session.getAttribute("cognom"));%>
        <% String email = String.valueOf(session.getAttribute("email"));%>
        
        <ul>
            <li><%= nom%></li>
            <li><%= cognom%></li>
            <li><%= email%></li>
        </ul>
    </body>
</html>

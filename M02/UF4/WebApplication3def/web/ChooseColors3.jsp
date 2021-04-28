<%-- 
    Document   : ChooseColors3
    Created on : 29/04/2021, 00:34:00
    Author     : ianlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        body{
            <jsp:useBean id="color" class="coreservlets.ColorBean" scope="application"/>
            <jsp:setProperty name="color" property="*"/>

            background: <jsp:getProperty name="color" property="background"/>;
            color: <jsp:getProperty name="color" property="foreground"/>;
        }

    </style>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>

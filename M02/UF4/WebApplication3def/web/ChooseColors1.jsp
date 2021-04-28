<%-- 
    Document   : ChooseColors1
    Created on : 28/04/2021, 20:44:43
    Author     : Alumne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <FORM ACTION="mostrarcolores" METHOD="POST">
            <label>Foreground Color</label>
            <input type="text" name="foreground"/>
            <br>
            <label>Background Color</label>
            <input type="text" name="background"/>
            <br>
            <input value="showcolor" type="submit"/>
        </FORM>
    </body>
</html>

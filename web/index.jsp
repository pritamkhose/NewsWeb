<%-- 
    Document   : index
    Created on : Dec 30, 2017, 11:39:23 AM
    Author     : Pritam
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
         // New location to be redirected
         String site = new String("http://localhost:8880/NewsWeb/News");
         response.setStatus(response.SC_MOVED_TEMPORARILY);
         response.setHeader("Location", site); 
      %>
    </body>
</html>

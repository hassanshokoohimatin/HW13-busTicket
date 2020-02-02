<%@ page import="ir.sunsor.entities.User" %>
<%@ page import="ir.sunsor.repositories.UserRepository" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2/1/2020
  Time: 12:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginSuccess</title>
</head>
<body>

<%
    String username = (String) session.getAttribute("username");
    User user = UserRepository.getInstance().findByUsername(username);
%>
<h3 style="text-align: center">successful login</h3><br>
<h3 style="text-align: center">welcome<%out.print(" " + user.getFirstName() + " " + user.getLastName());%></h3>
<br><br>
<a style="text-align: center" href="search.jsp">search ticket</a>

</body>
</html>

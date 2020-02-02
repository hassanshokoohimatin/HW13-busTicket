<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2/1/2020
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search</title>
</head>
<body>

<div style="text-align: center">

    <form action="search" method="post" style="display: flex">
        <input type="submit" value="search">
        <input type="date" name="date">
        <input list="origin" name="origin" placeholder="origin city">
        <datalist id="origin">
            <option value="tehran">
            <option value="tehran">
            <option value="tehran">
        </datalist>
        <input list="destination" name="destination" placeholder="destination city">
        <datalist id="destination">
            <option value="esfahan">
            <option value="shiraz">
            <option value="tabriz">
        </datalist>
    </form>

</div>

</body>
</html>

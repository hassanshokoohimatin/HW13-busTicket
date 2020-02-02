<%@ page import="java.util.List" %>
<%@ page import="ir.sunsor.entities.Trip" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>

<%
    String date =(String) session.getAttribute("date");
    String origin = (String) session.getAttribute("origin");
    String destination = (String) session.getAttribute("destination");
    List<Trip> trips = (List<Trip>) session.getAttribute("trips");
%>

<table>
    <tr>
        <th colspan="3">from <%=origin%> to <%=destination%> date: <%=date%></th>
    </tr>
    <tr>
        <th>trip id</th>
        <th>time</th>
        <th>choose</th>
    </tr>

    <%
        for (Trip i : trips){
            out.print("<tr>");
            out.print("<form action='add' method='get'>");
            out.print("<td>");
            out.print("<input type='text' style='display: none' name='tripId' value='"+i.getId()+"'>");
            out.print("<input type='submit' value='buy'>");
            out.print("</td>");
            out.print("</form>");
            out.print("<td>");
            out.print(i.getTripTime());
            out.print("</td>");
            out.print("<td>");
            out.print(i.getTripId());
            out.print("</td>");
            out.print("</tr>");
        }
    %>

</table>

</body>
</html>

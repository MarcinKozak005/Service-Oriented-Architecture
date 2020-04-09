<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Web App</title>
  </head>
  <body>
    <h1>First web app in JavaEE</h1>
    <p>Static content</p>
  <%
      Date date = new Date();
      out.print("<h2> "+date.toString() + "</h2>");
  %>
  </body>
</html>

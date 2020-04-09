
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login Page</title>
  </head>
  <body>
  <%
      if (session.getAttribute("loggedIn")!=null && (boolean)session.getAttribute("loggedIn")){
          request.getRequestDispatcher("/Feedback").forward(request,response);
      }
  %>

  <p>${errorMessage}</p>

  <form action="LoginAction" method="post">
    Login:<input type="text" name="login"><br>
    Password:<input type="password" name="password"><br>
    <input type="submit" value="Login">
  </form>

  </body>
</html>

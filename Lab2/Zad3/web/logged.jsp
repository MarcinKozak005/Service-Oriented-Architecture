<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logged In</title>
</head>
<body>
    <p>Welcome ${login}, You are now logged in</p>

    <form method="post" action="Feedback">
        Name:<input type="text" name="name"><br>
        Email:<input type="text" name="email"><br>
        Comment:<input type="text" name="comment"><br>
        <input type="submit" value="Send">
    </form>

    <p>
        ${Comments}
    </p>
</body>
</html>

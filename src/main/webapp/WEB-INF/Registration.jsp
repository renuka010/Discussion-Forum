<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css"></link>
<link rel="stylesheet" href="css/style3.css"/>
</head>
<body>
<!-- partial:index.partial.html -->
<div id="login-form-wrap">
  <h2>Register</h2>
  <form id="login-form" action="newuser" method="post">
    <p>
    <label for="username">UserName :</label><br>
    <input type="text" name="username" required><i><span></span><span></span></i>
    </p>
    <p>
    <label for="emailId">Email Id :</label><br>
    <input type="email" name="emailId" required><i><span></span><span></span></i>
    </p>
    <p>
    <label for="password1">Password :</label><br>
    <input type="password" name="password1" required><i><span></span><span></span></i>
    </p>
    <p>
    <label for="password2">Confirm Password :</label><br>
    <input type="password" name="password2" required><i><span></span><span></span></i>
    </p>
    <p>
    <input type="submit" value="Register">
    </p>
    <br>
    <h2>${message}</h2>
    </form>
</div>
</body>
</html>
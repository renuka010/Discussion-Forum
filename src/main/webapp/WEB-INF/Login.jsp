<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css"></link>
<link rel="stylesheet" href="css/style2.css"/>
</head>
<body>
<!-- partial:index.partial.html -->
<div id="login-form-wrap">
  <h2>Login</h2>
  <h3>${SPRING_SECURITY_LAST_EXCEPTION.message}</h3>
  <form id="login-form" action="login" method="post">
    <p>
    <input type="text" name="username" required><i><span></span><span></span></i>
    </p>
    <p>
    <input type="password" name="password" required><i><span></span><span></span></i>
    </p>
    <p>
    <input type="submit" value="Login">
    </p>
  </form>
  ${message}
  <div id="create-account-wrap">
    <p><a href="forgetpwd">Forget Password</a>Not a member? <a href="register">Create Account</a><p>
  </div><!--create-account-wrap-->
</div><!--login-form-wrap-->
<!-- partial -->
</body>
</html>
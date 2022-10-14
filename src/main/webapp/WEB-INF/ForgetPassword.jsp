<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css"></link>
<link rel="stylesheet" href="css/style3.css"/>

</head>


<body>

<div id="login-form-wrap">
<c:if test="${code eq 'email'}">
  <h2>Get OTP</h2>
  <form id="login-form" action="getotp">
    <p>
    <label for="emailId">Email Id :</label><br>
    <input type="email" name="emailId" required><i><span></span><span></span></i>
    </p>
    <p>
    <input type="submit" value="Send Otp">
    </p>
    <br>
    ${msg}
    </form>
</c:if>

<c:if test="${code eq 'otp'}">
  <h2>Enter OTP</h2>
  <h2>OTP only valid for 2 minutes</h2>	
  	
  <form id="login-form" action="otp" method="post">
    <p>
    <input type="hidden" id="otp1" name="otp1" value="${otp}"/>
    <input type="hidden" id="emailid" name="emailid" value="${emailid}"/>    		
    <label for="otp2">Enter OTP :</label><br>
    <input type="text" name="otp2" maxlength="6" required><i><span></span><span></span></i>
    </p>
    <p>
    <input type="submit" value="Next">
    </p>
    <h2>${msg}</h2>
    <br>
    </form>
    <form action="getotp">
    <input type="hidden" id="emailId" name="emailId" value="${emailid}"/>
    <input type="submit" value="Resend OTP">
    </form>
</c:if>

<c:if test="${code eq 'changepwd'}">
  <h2>Enter New Password</h2>
  <form id="login-form" action="changepwd" method="post">
    <p>
    <input type="hidden" id="emailid" name="emailid" value="${emailid}"/> 
    <label for="pwd1">Enter New Password :</label><br>
    <input type="password" name="pwd1" required><i><span></span><span></span></i>
    </p>
    <p>
    <label for="pwd2">Confirm Password :</label><br>
    <input type="password" name="pwd2" required><i><span></span><span></span></i>
    </p>
    <p>
    <input type="submit" value="Change Password">
    </p>
    <br>
    ${message}
    </form>
</c:if>

</div>
</body>
</html>
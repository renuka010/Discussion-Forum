<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Insert title here</title>
	<link rel="stylesheet" href="/css/style.css">
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
	<style>
		.askques
		{
			width:60%;
			margin: auto;
			background-color: #E5E4E2;
			padding: 30px;
		}
		textarea{
			resize:none;
			font-size: 16px;
		}
		</style>
	

</head>

<body>
<div class="wrapper">
    <nav>
      <input type="checkbox" id="show-search">
      <input type="checkbox" id="show-menu">
      <label for="show-menu" class="menu-icon"><i class="fas fa-bars"></i></label>
      <div class="content">
      <div class="logo"><a href="#">f Forum</a></div>
        <ul class="links">
          <li><a href="/">Home</a></li>
          <li><a href="/ask">Ask</a></li>
          <li>
            <a href="#" class="desktop-link">${userid}</a>
            <input type="checkbox" id="show-features">
            <label for="show-features">${userid}</label>
            <ul>
              <li><a href="/myactivity">My Activity</a></li>
              <li><a href="/change-password">Change Password</a></li>
              <li><a href="/logout">Log Out</a></li>
            </ul>
          </li>
        </ul>
      </div>
      <label for="show-search" class="search-icon"><i class="fas fa-search"></i></label>
      <form action="/search" class="search-box">
        <input type="text" id="keyword" name="keyword" placeholder="Type Something to Search..." required>
        <button type="submit" class="go-icon"><i class="fas fa-long-arrow-alt-right"></i></button>
      </form>
    </nav>
  </div>
   <br><br><br><br>
   <div class="askques">
   
	<form action="add" method="POST">
		<h3 style="text-align: center;"> Ask Question</h3>
  		<label for="title">Title :</label>
  			<textarea id="title" name="title" rows="1" cols="60" maxlength="100" wrap="hard" placeholder="Required" required></textarea><br><br>
  		<label for="body">Body :</label><br><br>
  			<textarea id="body" name="body" rows="5" cols="67" maxlength="3000" wrap="hard" placeholder="Required" required></textarea><br><br>
  		<input type="submit" value="Submit"><br><br>
	</form>
	${message}
   </div>
	
</body>
</html>
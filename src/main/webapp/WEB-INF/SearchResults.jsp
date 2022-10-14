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
	
	<link rel="stylesheet" href="css/style.css"></link>
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
  	
	<style>
		table, th, td {
	  		border: 1px solid black;
		}
	.postdisplay
	{
		height:200px;
		width:90%;
		border:5px solid white;
		background-color: lightgrey;
		margin: auto;
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
      <div class="logo"><a href="#" style="text-decoration: none;">f Forum</a></div>
        <ul class="links">
          <li><a href="/" style="text-decoration: none;">Home</a></li>
          <li><a href="/ask" style="text-decoration: none;">Ask</a></li>
          <li>
            <a href="#" class="desktop-link" style="text-decoration: none;">${userid}</a>
            <input type="checkbox" id="show-features">
            <label for="show-features">${userid}</label>
            <ul>
              <li><a href="/myactivity" style="text-decoration: none;">My Activity</a></li>
              <li><a href="/change-password" style="text-decoration: none;">Change Password</a></li>
              <li><a href="/logout" style="text-decoration: none;">Log Out</a></li>
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

		<c:forEach var="question" items="${questions}">
			<div class="postdisplay">
				<br>
				<h3>${question.title}</h3><br>
				${question.body}<br><br>
				<form action="/${question.id}">
					<input type="submit" value="View">
				</form>
				Posted by ${question.userId} ${question.dated}<br>
			</div>
		</c:forEach>
	
</body>
</html>
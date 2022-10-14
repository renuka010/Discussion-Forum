<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="css/style.css">
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
  	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
	<style>
		.viewques
		{
			width:93%;
			margin: auto;
			background-color: #ECF0F1;
			padding: 30px;
			border: 2px solid black;
		}
		.wrap{
			width:95%;
			margin: auto;
			background-color: #D0D3D4;
			padding: 30px;
		}
		input[type="submit"] {
  			display: block;
  			box-sizing: border-box;
  			width: 10%;
  			outline: none;
  			height: 50px;
  			line-height: 60px;
  			border-radius: 4px;
    		margin-left: auto;
    		margin-right: auto;
		}
		.button {
  			border: none;
  			color: white;
  			padding: 10px 12px;
  			text-align: center;
  			text-decoration: none;
  			display: inline-block;
  			font-size: 16px;
  			margin: 4px 2px;
  			transition-duration: 0.4s;
  			cursor: pointer;
		}
		.button2 {
  			background-color: white; 
  			color: black; 
  			border: 1px solid black;
			}
		.button2:hover {
  			background-color: #008CBA;
  			color: white;
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
   <div class="wrap">
   <br>
   <br><br>
	<c:forEach var="dto" items="${activityDto}">
			<c:if test="${empty dto.title}">
				<div class="viewques">
					<br>
					<table style="width:100%">
						<tr>
							<td style="width:80%">
								Answered ${dto.body}<br>
							</td>
							<td style="width:20%">
								<form action="/${dto.quesId}">
   									<button type="submit" class="button button2" ><span class="bi bi-binoculars-fill"></span></button>
									<p style="text-align: right;">${dto.dated}</p>
   								</form>
							</td>
						</tr>
					</table>
				</div>
			</c:if>
			<c:if test="${not empty dto.title}">
				<div class="viewques">
					<br>
					<table style="width:100%">
						<tr>
							<td style="width:80%">
								Asked <b>${dto.title}</b><br>
								${dto.body}
							</td>
							<td style="width:20%">
								<form action="/${dto.quesId}">
   									<button type="submit" class="button button2" ><span class="bi bi-binoculars-fill"></span></button>
									<p style="text-align: right;">${dto.dated}</p>
								</form>
							</td>
						</tr>
					</table>
				</div>	
			</c:if>
		</table>
	</c:forEach>
	<br>
	
	</div>
</body>
</html>
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
		}
		.viewans
		{
			width:80%;
			margin: auto;
			background-color: #F7F9F9;
			padding: 30px;
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
		textarea{
			resize:none;
  			width: 80%;
  			padding: 0 0 0 10px;
  			margin: 0;
  			color: #000000;
  			border: 1px solid #c2c0ca;
  			font-style: normal;
  			font-size: 16px;
  			position: relative;
  			display: block;
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
   <div class="viewques">
   		<br>
   		<table style="width:100%">
   			<tr>
   				<td style="width:90%">
   					${quesDto.userId} posted on ${quesDto.dated}<br>
   					<h3>${quesDto.title}</h3><br>
   					${quesDto.body}<br><br>
   				</td>
   				<td style="width:10%">
   					<c:if test="${userid eq quesDto.userId}">
   						<form action="/${quesDto.id}/delete">
   							<p style="text-align: right;"><button type="submit" class="button button2" ><span class="bi bi-trash-fill"></span></button></p>
   						</form>
   					</c:if>
   				</td>
   			</tr>
   		</table>
   </div>
   <br><br>
	<c:forEach var="answer" items="${quesDto.answers}">
			<div class="viewans">
			<br>
   		<table style="width:100%">
   			<tr>
   				<td style="width:90%">
   					<h4>${answer.body}</h4><br><br>
				<p style="text-align: right;">
					${answer.userId} <br> ${answer.dated}
				</p>
   				</td>
   				<td style="width:10%">
   					<c:if test="${userid eq answer.userId}">
   						<form action="/del">
   							<input type="hidden" id="id" name="id" value="${answer.id}"/>
   							<input type="hidden" id="qid" name="qid" value="${quesDto.id}"/>
   							<p style="text-align: right;"><button type="submit" class="button button2" ><span class="bi bi-trash-fill"></span></button></p>
   						</form>
   					</c:if>
   				</td>
   			</tr>
   		</table>
				</div><br>
	</c:forEach>
	<br>
	
	<form action="${quesDto.id}" method="post">
		<input type="hidden" id="userId" name="userId" value="${userid}"/>
   		<input type="hidden" id="quesId" name="quesId" value="${quesDto.id}"/>
		<textarea id="body" name="body" rows="4" maxlength="3000" wrap="hard" required></textarea><br><br>
		<input type="submit" value="Post">
	</form>
	
	</div>
</body>
</html>
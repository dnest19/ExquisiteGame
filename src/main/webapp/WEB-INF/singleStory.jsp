<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exquisite Stories</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>
<body>
<div class="container overflow-hidden">
	<div class="row p-2 gy-4 bg-success">
		<div class="col-5">
			<h1>Exquisite Stories</h1>
		</div>
		<div class="col-sm">
			<a href="/stories" class="p-4 text-dark">Stories</a>
		</div>
		<div class="col-sm">
			<a href="/profile" class="p-4 text-dark">Profile</a>
		</div>
		<div class="col-sm">
			<a href="/logout" class="p-4 text-dark">Log Out</a>
		</div>

	</div>

	<div class="row">
		<div class="col border border-dark p-1">
		<h3>${story.title }</h3>
		<p>Genre: ${story.genre }</p>
		<p>${story.text }</p>
		<p>Contributors:</p>
			  <p>  <c:forEach items="${story.users}" var="user">
			    	 ${user.email } ,
			    </c:forEach>
			  </p>
		
	</div>
  </div>
</body>
</html>
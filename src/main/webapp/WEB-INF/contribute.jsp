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
	
		<h3>Contribute to ${story.title }</h3>
	<div class="row">
		<div class="col border border-dark p-1">
		<p>${story.text }</p> <br>
		<p>Genre: ${story.genre }</p> <br>
		<p>Max Length (characters): ${story.max_length }</p> <br>
			<form:form action="/story/${story.id}/update" method="POST" modelAttribute="story">  
			<form:input type="hidden" value="${story.id}" path="id"/>
			<form:input type="hidden" value="${user}" path="users"/>
			<form:input type="hidden" value="${story.text}" path="text"/>
			<form:input type="hidden" value="${story.title}" path="title"/>
			<form:input type="hidden" value="${story.genre}" path="genre"/>
			<form:input type="hidden" value="${story.max_length}" path="max_length"/>
			<div class="form-group">
			<form:label path="sentence">Your Sentence: </form:label><br>
			<form:errors path="sentence"/>
			<form:textarea path="sentence"/><br>
		</div>
			<button class="btn btn-primary">Submit</button>
		</form:form>
		</div>
	</div>
  </div>
</body>
</html>
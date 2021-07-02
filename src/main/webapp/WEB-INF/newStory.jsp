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
	<h3>Create a New Story!</h3>
	<div class="row">
		
			<form:form action="/story/${story.id}/create" method="POST" modelAttribute="story">  
			<form:input type="hidden" value="${story.id}" path="id"/>
			<div class="form-group">
			<form:label path="title">Title: </form:label><br>
			<form:errors path="title"/>
			<form:input path="title"/><br>
			<form:label path="text">First Sentence: </form:label><br>
			<form:errors path="text"/>
			<form:textarea path="text"/><br>
			<form:label path="genre">Genre: </form:label><br>
			<form:errors path="genre"/>
			<form:input path="genre"/><br>
			<form:label path="max_length">Max Length: </form:label><br>
			<form:errors path="max_length"/>
			<form:input path="max_length"/><br>
		</div>
			<button class="btn btn-primary">Submit</button>
		</form:form>
	</div>
  </div>
</body>
</html>
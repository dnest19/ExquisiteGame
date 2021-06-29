<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
</head>
<body>
<div class="container">
<div class="row">
<div class="col">
<p>${loginError }</p>
<h4>Login</h4>
<form method="POST" action="/login">
<div class="form-group">
<label>Email</label>
<input class="form-control" type="email" name="loginEmail">
</div>
<div class="form-group">
<label>Password</label>
<input class="form-control" type="password" name="loginPass">
</div>
<button class="btn btn-primary">Login</button>
</form>
</div>
<div class="col">
		<h2>Register</h2>
		<form:form action="/register" method="POST" modelAttribute="user">
			<div class="form-group">
				<form:label path="email">Email</form:label>
				<form:errors path="email"/>
				<form:input class="form-control" path="email"/>
			</div>
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:errors path="password"/>
				<form:input class="form-control" type="password" path="password"/>
			</div>
			<input class="btn btn-primary" type="submit" value="submit">
		</form:form>
</div>

</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Main Page</title>
		<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sandstone/bootstrap.min.css" rel="stylesheet" integrity="sha384-G3Fme2BM4boCE9tHx9zHvcxaQoAkksPQa/8oyn1Dzqv7gdcXChereUsXGx6LtbqA" crossorigin="anonymous">
	</head>
	<body>
		<h1>SESSION STATUS CHECK: Your GH service has value... ${ (gs == null ? "null" : gs) }</h1>
		<h1>SESSION STATUS CHECK: Your GH username is... ${ (gs.user == null ? "null" : gs.user.name ) }</h1>
			
		<form action="/">
			<input type="submit" value="Get GitHub session code." class="btn btn-primary"/>
		</form>
		
		<c:if test="${ user != null }">
			<p>Name: ${ user.name }</p>
			<p>Email: ${ user.email }</p>
			<div class="container">
				<div class="col-sm-3">
					<img src="${ user.avatarUrl }"/>
				</div>
				<div class="col-sm-3">
					
				</div>
				<div class="col-sm-3"></div>
			</div>
		</c:if>
		
		<a href="/count-test" class="btn btn-primary">Go To Session Count Test</a>
		
<form action="/cookie-test">
	<input type="submit" value="Go to cookie test page"/>
</form>
	</body>
</html>
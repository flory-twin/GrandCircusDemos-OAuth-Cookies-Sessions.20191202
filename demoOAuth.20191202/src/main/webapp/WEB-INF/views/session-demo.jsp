<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sandstone/bootstrap.min.css" rel="stylesheet" integrity="sha384-G3Fme2BM4boCE9tHx9zHvcxaQoAkksPQa/8oyn1Dzqv7gdcXChereUsXGx6LtbqA" crossorigin="anonymous">
	</head>
	<body>
		<h1>SESSION STATUS CHECK: Your GH service has value... ${ (gs == null ? "null" : gs) }</h1>
		<h1>SESSION STATUS CHECK: Your GH username is... ${ (gs.user == null ? "null" : gs.user.name ) }</h1>
	
		<div class="container">
			<p>
			Session ID is ${ sessionId }.
			</p>
			<p>
			Visitor count is ${ count }.
			</p>
		</div>
		
		
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index Page</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css" rel="stylesheet" integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp" crossorigin="anonymous">
</head>
<body>
Welcome!

<h1>SESSION STATUS CHECK: Your GH service has value... ${ (gs == null ? "null" : gs) }</h1>
		<h1>SESSION STATUS CHECK: Your GH username is... ${ (gs.user == null ? "null" : gs.user.name ) }</h1>

<!-- Will eventually route via HomeController.handleGithubCallback(). -->
<a class="btn btn-primary" href="${ gs.getGithubAccessRequestUrl() }">Login with Github</a>

<a href="/count-test" class="btn btn-primary">Go To Session Count Test</a>

<form action="/cookie-test">
	<input type="submit" value="Go to cookie test page"/>
</form>
</body>
</html>
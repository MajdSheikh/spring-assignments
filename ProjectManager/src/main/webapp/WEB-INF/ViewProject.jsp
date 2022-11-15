<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>success</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>






<div class="card">
<h1 class="card-header">Project Details</h1>
</div>
<div class="card-body">
		<br>
		
			<p class="card-title">Project: ${project.title} </p>
			<br>
			<p class="card-text">description: ${project.description}</p>
			<br>
			<p class="card-text">Due date: ${project.dueDate}</p>
			<br>

</div>
	    
 <div class="inline">
<div>

	    
	    <form:form action="/projects/${project.id}/delete" method="post"> 
	    	<input type="hidden" name="_method" value="delete">  
	    	<input type="submit" value="Delete" type="button" class="btn btn-danger">
	    </form:form>

</div>
<div>
<a href="/success" type="button" class="btn btn-outline-warning">Cancel</a>
</div>
</div>


</body>
</html>

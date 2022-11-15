<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create a project</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

<h1>Create a Project</h1>

	    <form:form action="/projects/create" method="POST" modelAttribute="project" class="container">
	    	
	        <div class="form-group col-md-6 break">
	            <form:label path="title"><strong>Project Title:</strong></form:label>
	            <form:errors path="title"/>
	            <form:input type="text" path="title" class="form-control"/>
	        </div>

	        <div class="form-group col-md-6 break" class="break"> 
	            <form:label path="description"><strong>Project description:</strong></form:label>
	            <form:errors path="description"/>
	            <form:textarea path="description" rows="5" class="form-control"></form:textarea>
	        </div>
	        
	        <div class="form-group col-md-6 break" class="break">
	            <form:label path="dueDate"><strong>Due Date:</strong></form:label>
	            <form:errors path="dueDate"/>
	            <form:input type="date" path="dueDate" class="form-control"/>
	        </div>
	        
	        <div >
				<form:errors path="leader" class="error"/>
				<form:input type="hidden" path="leader" value="${user.id}"/>
			</div>
	        <input  type="submit" value="Submit" type="button" class="btn btn-primary btn-lg btn-block">
	    </form:form>




</body>
</html>



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

<div class="spacee">
<h1>Welcome, ${ thisUser.userName }</h1>
<a href="/logout" class="mar">Logout</a>
</div>

<div class="space">
<h3>All Projects</h3>
<a href="projects/new" type="button" class="btn btn-outline-primary mar">+ New Project</a>
</div>

<div>
<table class="table table-striped table-dark table container">
	            <thead>
	                <tr>
	                    <th scope="col">Project</th>
	                    <th scope="col" >Team Lead</th>
	                    <th scope="col" >Due Date</th>
	                    <th scope="col">Actions</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach var="project" items="${allProjects}">
	            	<c:if test="${user_id != project.leader.id}">
		                <tr>
		                	<td scope="row"><a href="/projects/${project.id}/view"><c:out value="${project.title}"/></a></td>                	
		                    <td><c:out value="${project.leader.userName}"/></td>
		                    <td><c:out value="${project.dueDate}"/></td> 
							<td><a href="projects/${project.id}/join">Join Team</a></td>
		                </tr>
		                </c:if>
	                </c:forEach>
	            </tbody>
	        </table>
</div>


<h3>Your Projects</h3>
<div>
<table class="table table-striped table-dark container" >
	            <thead>
	                <tr>
	                    <th scope="col" style="width:10%">Project</th>
	                    <th scope="col" style="width:10%">Team Lead</th>
	                    <th scope="col" style="width:10%">Due Date</th>
	                    <th scope="col" style="width:10%">Actions</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach var="project" items="${yourProjects}">
		                <tr>
		                	<td scope="row"><a href="/projects/${project.id}/view"><c:out value="${project.title}"/></a></td>                	
		                    <td><c:out value="${project.leader.userName}"/></td>
		                    <td><c:out value="${project.dueDate}"/></td>  
		                    <c:choose>
		                    <c:when test="${user_id == project.leader.id }">
		                    <td><a href="/projects/${project.id}/edit">edit</a></td>
		                    </c:when>
		                    <c:otherwise>
		                    <td><a href="/projects/${project.id}/leave">leave team</a></td>
		                    </c:otherwise>
		                    </c:choose>
		                    
		                </tr>
	                </c:forEach>
	                
	                
	                <c:forEach var="project" items="${myProjects}">
		                <tr>
		                	<td scope="row"><a href="/projects/${project.id}/view"><c:out value="${project.title}"/></a></td>                	
		                    <td><c:out value="${project.leader.userName}"/></td>
		                    <td><c:out value="${project.dueDate}"/></td>  
		                    <c:choose>
		                    <c:when test="${user_id == project.leader.id }">
		                    <td><a href="/projects/${project.id}/edit">edit</a></td>
		                    </c:when>
		                    <c:otherwise>
		                    <td><a href="/projects/${project.id}/leave">leave team</a></td>
		                    </c:otherwise>
		                    </c:choose>
		                    
		                </tr>
	                </c:forEach>
	            </tbody>
	        </table>
</div>




</body>
</html>



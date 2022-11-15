<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>register and login</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

<div class="div">
<h1>Project Manager</h1>
<h3>A place for teams to manage projects</h3>
</div>


<div class="container">
 <div class="row">

<div class="col-md-6 mb-5">
<div class="card shadow p-5 animated zoomIn slow">
<h1>Register</h1>

<form:form action="/register" method="post" modelAttribute="newUser">

<div class="form-group">
        <form:label path="userName"> User Name: </form:label>
        <form:errors path="userName"/>
        <form:input path="userName" class="form-control"/>
</div>

<div class="form-group">
        <form:label path="email"> Email: </form:label>
        <form:errors path="email"/>
        <form:input path="email" class="form-control"/>
</div>

<div class="form-group">
        <form:label path="password"> Password: </form:label>
        <form:errors path="password"/>
        <form:input path="password" type="password" class="form-control"/>
</div>

<div class="form-group">
        <form:label path="confirm"> Confirm PW: </form:label>
        <form:errors path="confirm"/>
        <form:input path="confirm" type="password" class="form-control"/>
</div>

<div>
    <input type="submit" value="submit" class="btn btn-outline-dark btn-block rounded-pill"/>
</div>

</form:form>
</div>
</div>



<div class="col-md-6 mb-5">

<div class="card shadow animated zoomIn slow p-5">
<h3 class="text-center font-weight-bold text-uppercase mb-3">Login </h3>

<form:form action="/login" method="post" modelAttribute="newLogin">



<div class="form-group">
        <form:label path="email"> Email: </form:label>
        <form:errors path="email"/>
        <form:input path="email" class="form-control"/>
</div>

<div class="form-group">
        <form:label path="password"> Password: </form:label>
        <form:errors path="password"/>
        <form:input path="password" type="password" class="form-control"/>
</div>


<div>
    <input type="submit" value="submit"  class="btn btn-outline-dark btn-block rounded-pill"/>
</div>

</form:form>


</div>
</div>
</div>
</div>

</body>
</html>

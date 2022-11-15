<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Book Lender Dashboard</title>
		<link rel="stylesheet" type="text/css" href="/css/index.css">
	</head>
	<body>

	<p> hello, ${thisUser.userName}. Welcome to..</p>
	<a href="home">Back to the shelves</a>
	<h1>The Book Broker!</h1>


	<p>Available books to borrow</p>


 <table>
	            <thead>
	                <tr>
	                    <th>ID</th>
	                    <th>Title</th>
	                    <th>Author Name</th>
	                    <th>Owner</th>
	                    <th>Actions</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach var="book" items="${books}">
	            	<c:if test="${book.borrower.id != user_id}">
		                <tr>
		                	<td><c:out value="${book.id}"/></td>
		                	<td><a href="/books/${book.id}/view"><c:out value="${book.title}"/></a></td>                	
		                    <td><c:out value="${book.author}"/></td>
		                    <td><c:out value="${book.user.userName}"/></td>
		                    
		                    <td>
			                    <c:if test="${user_id == book.user.id}">
									<a href="/books/${book.id }/edit">edit</a>
									<form action="/books/${book.id}/delete" method="post">
									    <input type="hidden" name="_method" value="delete">
										<input type="submit" value="Delete">
									</form>
								</c:if>
		
			                    <c:if test="${user_id != book.user.id && book.borrower.id == null}">
									<a href="/${book.id }/borrow">Borrow</a>
								</c:if>
		                    </td>
		                </tr>
		                </c:if>
	                </c:forEach>
	            </tbody>
	        </table>

	        <h5>Books I'm Borrowing..</h5>
			
			<table>
			<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>	
				<th>Owner</th>
				<th>Actions</th>
			</tr>
			</thead>
				<tbody>
					<c:forEach var="book" items="${borrowedBooks }">
						<c:if test="${user_id == book.borrower.id}">
						<tr>
							<td><c:out value="${book.id}"/></td>
							<td><a href="/books/${book.id}/view"><c:out value="${book.title}"/></a></td>
							<td><c:out value="${book.author}"/></td>
							<td><c:out value="${book.user.userName}"/></td>
							<td >
							<a href="/${book.id }/return">Return</a>
							</td>
						</tr>
						</c:if>
						</c:forEach>
				</tbody>
			</table>
</body>
</html>

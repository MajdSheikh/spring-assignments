<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>

</head>
<body>
	<header>
        <h4><strong>Your GOLD: </strong></h4>
        <div class="output"><c:out value="${score}"/></div>
    </header>
    <main>
        <section>
            <h1>Farm</h1>
            <h3>(earns 10-20 gold)</h3>
            <form action="/process_money" method="post">
                <input type="hidden" name="gold" value="farm">
                <button type="submit"><strong>Find Gold!</strong></button>
            </form>
        </section>
        <section>
            <h1>Cave</h1>
            <h3>(earns 5-10 gold)</h3>
            <form action="/process_money" method="post">
                <input type="hidden" name="gold" value="cave">
                <button type="submit"><strong>Find Gold!</strong></button>
            </form>
        </section>
        <section>
            <h1>House</h1>
            <h3>(earns 2-5 gold)</h3>
            <form action="/process_money" method="post">
                <input type="hidden" name="gold" value="house">
                <button type="submit"><strong>Find Gold!</strong></button>
            </form>
        </section>
        <section>
            <h1>Quest</h1>
            <h3>(earns/takes 0-50 gold)</h3>
            <form action="/process_money" method="post">
                <input type="hidden" name="gold" value="quest">
                <button type="submit"><strong>Find Gold!</strong></button>
            </form>
        </section>
    </main>
	<footer>
        <h2>Activities:</h2>
        <div class="activities">
        <c:forEach var="message" items="${messages}">
            <p class="activity"><c:out value="${message}"/></p>
        </c:forEach>
        </div>
    </footer>
</body>
</html>
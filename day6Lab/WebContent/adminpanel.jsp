<%@page import="pojos.Candidates"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<table style="background-color: cyan; margin: auto;" border="1">
		<caption>Cadidate wise Result List</caption>
		<tr><th>Name</th><th>Party</th><th>Votes</th></tr>
	<c:forEach var="cd" items="${sessionScope.candidate.dao.allCandidatesParty}">
	<tr><td>${cd.name}</td><td>${cd.party}</td><td>${cd.votes}</td></tr>
	</c:forEach>
	</table>
	
	<table style="background-color: cyan; margin: auto;" border="1">
		<caption>Party wise Result List</caption>
		<tr><th>Party</th><th>Votes</th></tr>
	<c:forEach var="cd" items="${sessionScope.candidate.dao.allCandidates}">
	<tr><td>${cd.party}</td><td>${cd.votes}</td></tr>
	</c:forEach>
	</table>
</body>
</html>
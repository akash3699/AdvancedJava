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
<h3 align="center">Select The Party and Click Vote</h3>
<form action="voteprocess.jsp">
		<table style="background-color: cyan; margin: auto;" border="1">
			<c:forEach var="p" items="${sessionScope.candidate.allParties}">
			<tr><td><input type="radio" value="${p.party}" name=party>${p.party}</td></tr>
			</c:forEach>
			<tr><td><input type=submit value="Vote" /></td></tr>
		</table>
</form>
</body>
</html>
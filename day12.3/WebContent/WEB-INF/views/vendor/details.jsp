<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>${requestScope.mesg}</h4>
	<h5>Hello ${sessionScope.user_dtls.name}</h5>
	<h5>Account Details Summary : </h5>
	<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<th>Id</th>
				<th>Account Type</th>
				<th>Balance</th>
			</tr>
			<c:forEach var="ba" items="${sessionScope.user_dtls.bankAccounts}">
			<tr>
				<td>${ba.accountNo}</td>
				<td>${ba.type}</td>
				<td>${ba.balance}</td>
			</tr>
			</c:forEach>
		</table>
	
	<h5>
		<a href="<spring:url value='/vendor/addAccount?vid=${sessionScope.user_dtls.id}'/>">Create Account</a>
	</h5>
	
	<h5>
		<a href="<spring:url value='/user/logout'/>">Log Me Out</a>
	</h5>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Hello , ${sessionScope.user_dtls.name}</h5>
	<%
		session.invalidate();
	%>
	<h5>You have logged out...</h5>
	<h5>
		<a href="login3.jsp">Visit Again</a>
	</h5>
</body>
</html>
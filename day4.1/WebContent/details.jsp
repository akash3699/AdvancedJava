<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Login Successful</h4>
	<h5>User Details : ${sessionScope.user_dtls}</h5>
	<h5>
		<a href="logout.jsp">Log Me Out</a>
	</h5>
</body>
</html>
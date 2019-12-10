<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="cust" />
<body>
	<jsp:forward page="${sessionScope.cust.authenticateCustomer()}.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Student Admission Status :
		${sessionScope.student.registerStudent()}</h4>
	<h5>
		<a href="index.jsp">Back To Index Page</a>
	</h5>
</body>
</html>
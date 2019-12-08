<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>
		<%
			out.print("Email : " + request.getParameter("em"));
		%>
	</h4>
	<h4>
		<%
			out.print("PWD : " + request.getParameter("pass"));
		%>
	</h4>

</body>
</html>
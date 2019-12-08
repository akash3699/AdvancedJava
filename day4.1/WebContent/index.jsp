<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome </title>
</head>
<body>
	<h4>
		Welcome 2 JSP @
		<%=new Date()%></h4>
	<h4>
		<a href="comments.jsp">Testing JSP comments</a>
	</h4>
	<h4>
		<a href="login.jsp">Testing Scriptlets</a>
	</h4>
	<h4>
		<a href="login2.jsp">Testing JSP Expression</a>
	</h4>
	<h4>
		<a href="test1.jsp">Testing JSP Declaration</a>
	</h4>
	<h4>
		<a href="login3.jsp">Testing JSP EL</a>
	</h4>
	<h4>
		<a href="topics.jsp">Display All Tutorials Topics</a>
	</h4>

</body>
</html>
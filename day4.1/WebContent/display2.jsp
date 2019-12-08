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
		JSession ID :
		<%=session.getId()%></h4>
	<h4>
		Email :
		<%=request.getParameter("em")%></h4>
	<h4>
		PWD :
		<%=request.getParameter("pass")%></h4>
		<%-- <%= request.setAttribute("nm", 1234) %> --%>
</body>
</html>
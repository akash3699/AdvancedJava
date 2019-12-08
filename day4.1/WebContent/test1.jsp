<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!//JSP declaration block
	String mesg = "some message!!!!";
	int counter = 0;

	int test() {
		System.out.println("in test");
		return ++counter;
	}

	//can override life cycle method
	public void jspInit() {
		System.out.println("in jsp init");
	}%>
<body>
	<%
		out.print("servicing clnts...."+test());
		System.out.println("in _jspService " + Thread.currentThread());
	%>
</body>
<%!//can override life cycle method
	public void jspDestroy() {
		System.out.println("in jsp destroy");
	}%>
</html>
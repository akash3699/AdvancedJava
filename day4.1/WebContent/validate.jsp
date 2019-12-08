<%@page import="java.time.LocalDate"%>
<%@page import="com.app.sunbeam.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!//JSP declaration block
	HashMap<String, User> users;

	public void jspInit() {
		users = new HashMap<>();
		//populate Map
		users.put("abc@gmail.com", new User("abc@gmail.com", "abc", "1234", LocalDate.parse("1995-01-01")));
		users.put("abc2@gmail.com", new User("abc2@gmail.com", "abc2", "2234", LocalDate.parse("1999-01-01")));

	}%>
<body>
	<%
		//validation logic
		//read req params
		String email = request.getParameter("em");
		String pwd = request.getParameter("pass");
		User u = users.get(email);
		if (u != null) {
			//email : valid , chk for pwd
			if (u.getPassword().equals(pwd)) {
				//successful login
				//save user details under session scope

				session.setAttribute("user_dtls", u);
				//redirect
				response.sendRedirect("details.jsp");
			} else {
				//invalid pwd : retry link
	%>
	<h4>
		Invalid Login , Pls <a href="login3.jsp">Retry</a>
	</h4>
	<%
		}
	%>
	<%
	} else { %>
	<h4>
		New User , Pls <a href="register.jsp">Register</a>
	</h4>
	<%
		}
	%>
</body>
<%!public void jspDestroy() {
		users = null;
	}%>
</html>
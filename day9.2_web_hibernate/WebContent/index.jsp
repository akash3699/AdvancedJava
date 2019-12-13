<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="course" class="beans.CourseBean" scope="session" />
<jsp:useBean id="student" class="beans.StudentBean" scope="session" />
<body>
	<h4>
		<a href="reg_form.jsp">Student Admission</a>
	</h4>
	<h4>
		<a href="choose_course.jsp">Fetch Course Details</a>
	</h4>
</body>
</html>
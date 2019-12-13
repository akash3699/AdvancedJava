<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="adr_form.jsp">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter User Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Choose Course</td>
				<td><select name="courseNm">
						<c:forEach var="s" items="${sessionScope.course.courseNames}">
							<option value="${s}">${s}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Enter Adhar card Num</td>
				<td><input type="text" name="cardNum" /></td>
			</tr>
			<tr>
				<td>Card Created In City</td>
				<td><input type="text" name="cardCity" /></td>
			</tr>
			<tr>
				<td>Date of Creation</td>
				<td><input type="date" name="cardDate" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Next" /></td>
			</tr>
		</table>
	</form>


</body>
</html>
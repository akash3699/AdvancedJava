<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="student" />
<body>
	Status : ${sessionScope.student.addPartialDetails()}
	<form action="edu_form.jsp">
		<table style="background-color: cyan; margin: auto;" border="1">
			<caption>Student Address Details</caption>
			<tr>
				<td>Enter City</td>
				<td><input type="text" name="city" /></td>
			</tr>
			<tr>
				<td>Enter State</td>
				<td><input type="text" name="state" /></td>
			</tr>
			<tr>
				<td>Enter Country</td>
				<td><input type="text" name="country" /></td>
			</tr>
			<tr>
				<td>Enter Phone No</td>
				<td><input type="text" name="phoneNo" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Next" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
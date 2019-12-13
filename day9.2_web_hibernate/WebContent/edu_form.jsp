<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="student" />
<body>
	Status : ${sessionScope.student.linkAddressDetails()}
	<form action="status.jsp">
		<table style="background-color: cyan; margin: auto;" border="1">
			<caption>Education Qualifications</caption>
			<tr>
				<td>Choose Type</td>
				<td><select name="type">
						<option value="SSC">SSC</option>
						<option value="HSC">HSC</option>
						<option value="DEG">DEG</option>
				</select></td>
			</tr>
			<tr>
				<td>Enter Year</td>
				<td><input type="number" name="year" /></td>
			</tr>
			<tr>
				<td>Enter GPA</td>
				<td><input type="number" name="gpa" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="btn" value="Register Student" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="btn" value="Add Qualifications"
					formaction="edu_form.jsp" /></td>
			</tr>
		</table>
	</form>
	<c:if test="${param.btn eq 'Add Qualifications'}">
		<jsp:setProperty property="*" name="student" />
		${sessionScope.student.addEduQuals()}
		
	</c:if>

</body>
</html>
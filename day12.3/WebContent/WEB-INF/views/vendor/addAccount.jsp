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
${sessionScope.AcType}
	<h3 style="color: red;">${requestScope.mesg}</h3>
	<form method="post">
		<table style="background-color: cyan; margin: auto;" border="1">
			
				<tr>
				<td><input type="radio" name="actype" value="SAVING" > </td><td>SAVING </td></tr>
				<tr><td><input type="radio" name="actype" value="FD" > </td><td>FD</td></tr>
				<tr><td><input type="radio" name="actype" value="LOAN" > </td><td>LOAN</td></tr>
				<tr><td><input type="radio" name="actype" value="CURRENT" > </td><td>CURRENT </td>
								
				</tr>
			<tr>
				<td>Enter Balance</td>
				<td><input type="number" name="balance" ></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" ></td>
			</tr>
		</table>
	</form>

</body>
</html>
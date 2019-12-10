<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<jsp:useBean id="voter" class="beans.VoterBean" scope="session" /> 

<body>
	<%-- <h3 style="color: red;">${sessionScope.voter.message}</h3> --%>
	<form action="registerProcess.jsp">
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
				<td>Enter Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
			<td><input type="radio" name="role" value="voter" />Voter</td>
			<td><input type="radio" name="role" value="admin" />Admin</td>
			
			</tr>

			<tr>
				<td><input type="submit" value="Register" /></td>
			
			
				<td><a href="login.jsp">Login</a></td>
				</tr>
			
		</table>
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3 style="color: red;">${requestScope.mesg}</h3>
	<form method="post">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter User Name</td>
				<td><input type="text" value="${requestScope.update_use_dtls.name}" name="nm" /></td>
			</tr>
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" value="${requestScope.update_use_dtls.email}" name="em" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" value="${requestScope.update_use_dtls.password}" name="pass" /></td>
			</tr>
			<tr>
				<td>Enter Reg Amount</td>
				<td><input type="number" value="${requestScope.update_use_dtls.reg_amount}" name="regAmount" /></td>
			</tr>
			<tr>
				<td>Enter Reg Date</td>
				<td><input type="Date" value="${requestScope.update_use_dtls.reg_date}" name="regDate" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update Vendor" /></td>
			</tr>
		</table>
	</form>

</body>
</html>
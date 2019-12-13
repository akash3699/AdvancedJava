<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="add_account.jsp">
	<table id="table-1" margin="auto">
		<tbody>
			<tr>
			<td>VendorID</td>
				<td><input type="number" name="vendorId" placeholder="vendorId" /></td>
			</tr>
			<tr>
			<td>Balance</td>
				<td><input type="number" name="balance"  placeholder="Balance" /></td>
				
			</tr>
			<tr>
				<td>Account Type</td></tr>
				<tr><td><input type="radio" name="AcType" value="SAVING" />Saving</td></tr>
				<tr><td><input type="radio" name="AcType" value="FD" />FD</td></tr>
				<tr><td><input type="radio" name="AcType" value="CURRENT" />CURRENT</td></tr>
				<tr><td><input type="radio" name="AcType" value="LOAN" />Loan</td>
			</tr>
			
			<tr>
				<td><input type="submit"  placeholder="Add Account" /></td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>
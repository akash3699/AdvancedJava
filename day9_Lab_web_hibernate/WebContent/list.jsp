<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="vendor" class ="beans.VendorBean" scope="session"></jsp:useBean>
<body>
<form action="add_account.jsp" margin="auto">
	<table id="table-1"  border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>RegDate</th>
			<th>Phone NO</th>
			<th>Delete</th>
		</tr>
<c:forEach var="v" items="${sessionScope.vendor.fetchAllVendors()}">
		<tr>
			<td><a href="details.jsp?id=${v.vendorId}" >${v.name}</a></td>
			<td>${v.email}</td>
			<td>${v.reg_date}</td>
			<td>${v.myLoc.phone}</td>
			<td><a href="delete.jsp?id=${v.vendorId}">Delete</a></td>
		</tr>
</c:forEach>
</table>
</form>
</body>
</html>
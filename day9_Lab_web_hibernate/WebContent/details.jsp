<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="vendor"/>
<body>
<h4>Vendor Name : ${sessionScope.vendor.fetchAllVendorsWithAccounts().name}</h4>
<h4>Vendor Reg Date : ${sessionScope.vendor.fetchAllVendorsWithAccounts().reg_date}</h4>
<h4>Vendor Reg Amount : ${sessionScope.vendor.fetchAllVendorsWithAccounts().reg_amount}</h4>
<h4>Vendor Address Line 1: ${sessionScope.vendor.fetchAllVendorsWithLocation().myLoc.adrLine1}</h4>
<h4>Vendor Address Line 2: ${sessionScope.vendor.fetchAllVendorsWithLocation().myLoc.adrLine2}</h4>
<h4>Vendor Address Zip Code: ${sessionScope.vendor.fetchAllVendorsWithLocation().myLoc.zipCode}</h4>
<h4>Vendor Phone: ${sessionScope.vendor.fetchAllVendorsWithLocation().myLoc.phone}</h4>
  
<form action="add_account.jsp" margin="auto">
	<table id="table-1"  border="1">
		<tr>
			<th>Account NO</th>
			<th>Account Type</th>
			<th>Account Balance</th>
		</tr>
<c:forEach var="v" items="${sessionScope.vendor.fetchAllVendorsWithAccounts().bankAccounts}">
		<tr>
			<td>${v.accountNo}</td>
			<td>${v.type}</td>
			<td>${v.balance}</td>
			
		</tr>
</c:forEach>
</table>
</form>
<h3><a href="services.jsp" >Services</a></h3>
</body>
</html>
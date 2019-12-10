<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Status</title>
</head>
<jsp:setProperty property="*" name="voter" />
<body>
<c:choose>
<c:when test="${sessionScope.voter.message eq 'Already Casted the Vote'}">
<h4>Already Casted the Vote</h4>
</c:when>
<c:otherwise>
Successfully Casted the vote
</c:otherwise>
</c:choose>

<%-- <c:if test="${sessionScope.voter.message}">
		<h4>You have already voted.....</h4>
	</c:if> --%>
${pageContext.session.invalidate()}
</body>
</html>
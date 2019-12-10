<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <jsp:useBean id="voter" class="beans.VoterBean" scope="session" /> --%>
<jsp:setProperty property="*" name="voter" /> 
</head>
<body>
	<jsp:forward page="${sessionScope.voter.addVoter()}.jsp"></jsp:forward>
</body>
</html>
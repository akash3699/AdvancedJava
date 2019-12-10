<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="voter" />
<body>
	<jsp:forward page="${sessionScope.voter.authenticateVoter()}.jsp"></jsp:forward>
</body>
</html>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="com.app.sunbeam.Tutorial"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Tutorial Topics</title>
</head>
<body>
<%-- ${applicationScope.all_tuts.keySet()}; --%>
	<form action="tutorials.jsp" >
		<table style="background-color: cyan; margin: auto;" border="1">
		<caption>Tutorials Topics</caption>
			<tr>
				<td>Choose Topic</td>
			</tr>
			<%
			Set<String> keys =((HashMap<String, List<Tutorial>>) 
					getServletContext().getAttribute("all_tuts")).keySet();
			for(String s : keys)
			{
			%>
			<tr>
			<td><input type="radio" name="topic" value="<%=s%>" /><%=s%></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td><input type="submit" value="Choose Topics" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
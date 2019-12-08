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
<title>Insert title here</title>
</head>
<body>
<form action="tutorials.jsp" >
		<table style="background-color: cyan; margin: auto;" border="1">
		<caption>Tutorials Topics</caption>
			<tr>
				<td>Select</td><td>Details</td><td>Author Name</td>
			</tr>
<%
			/* Set<String> keys =((HashMap<String, List<Tutorial>>) 
					getServletContext().getAttribute("all_tuts")).keySet(); */
					List<Tutorial> keys = (((HashMap<String, List<Tutorial>>) getServletContext().getAttribute("all_tuts")).get(request.getParameter("topic")));
					System.out.println(keys);
					Integer sr=1;
			for(Tutorial s : keys) 
			{
				
			%>
			<tr>
			<td><%=sr%></td><td><%=s.getDetails()%></td><td> <%=s.getAuthor()%></td><br>
			</tr>
			<%
			sr = sr+1;
			}
			%>
			</table>
	</form>
			
</body>
</html>
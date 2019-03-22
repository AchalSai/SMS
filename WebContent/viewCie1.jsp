<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




	<table>
		<tr>
			<th>Student id</th>
			<th>Subject name</th>
			<th>Marks obtained</th>
			<th>Total marks</th>
		</tr>
		<c:forEach items="${list3}" var="lis">
			<tr>
				<td>${lis.sid}</td>
				<td>${lis.subname}</td>
				<td>${lis.marks_obtained}</td>
				<td>${lis.total_marks}</td>
			</tr>
		</c:forEach>
	</table>

	<a href="admin.jsp"> Go to main page</a>
</body>
</html>
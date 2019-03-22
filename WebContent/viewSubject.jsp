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
			<tr><th>Subject Id  </th>
				<th>Subject Name    </th>
				<th>Total Marks  </th>
			</tr>
			<c:forEach items="${list2}" var="lis">
				<tr>
					<td>  ${lis.subid}</td>
					<td>  ${lis.subname}</td>
					<td>  ${lis.total_marks}</td>
				
				</tr>
			</c:forEach>
		</table>

<a href="admin.jsp"> Go to main page</a>
</body>
</html>
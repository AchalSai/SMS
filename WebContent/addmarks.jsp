<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

Cookie cookies[]=request.getCookies();
for(Cookie ck:cookies) {
	  if(ck.getName().equals("k")) {
		int  c=Integer.parseInt(ck.getValue());
		  out.println("c="+c);
	  }
		  
}


//Cookie cookie = new Cookie("c", c+"");		

%>

	<form action="addmarks">
		Enter sid:<input type="text" name="sid"> <br>
		Enter subname:<input type="text" name="subname"><br>
        Enter marks obtained:<input type="text" name="marks_obtained">	<br>
		<input type="submit">
	</form>
</body>
</html>
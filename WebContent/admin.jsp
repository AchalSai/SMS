<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="adminservices">

<h2>Student Info</h2>
<input type="radio" name="services" value="1"> DisplayStudents <br>
<input type="radio" name="services" value="2"> AddStudent<br>
<input type="radio" name="services" value="3"> DeleteStudent<br>
<input type="radio" name="services" value="4"> UpdateStudent<br>
<h2>Counsellor-Student Mappping</h2>
<input type="radio" name="services" value="5"> DisplayCounsellorStudent<br>
<input type="radio" name="services" value="6"> AddCounsellorStudent<br>
<input type="radio" name="services" value="7"> DeleteCounsellorStudent<br>
<input type="radio" name="services" value="8"> UpdateCounsellorStudent<br>
<h2>Academics</h2>
<input type="radio" name="services" value="9"> ViewSubjects<br>
<input type="radio" name="services" value="10"> AddSubject<br>
<input type="radio" name="services" value="11"> DeleteSubject<br>
<input type="radio" name="services" value="12"> UpdateSubject<br>
<h2>Cie1</h2>
<input type="radio" name="services" value="13"> ViewMarks<br>
<input type="radio" name="services" value="14"> ViewMarksById<br>
<input type="radio" name="services" value="15"> AddMarks<br>
<input type="radio" name="services" value="16"> DeleteMarksById<br>
<input type="radio" name="services" value="17"> DeleteMarksByIdSub<br>
<input type="radio" name="services" value="18"> UpdateMarks<br>
<input type="submit">
</form>
</body>
</html>
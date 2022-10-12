<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicle Search Page</title>
</head>
<body>
	<form action="autoSearchServlet" method="post">
		Make: <input type="text" name="make">
		<button type="submit" name="searchAutoByThis" value="make">Search by Make</button>
		Model: <input type="text" name="model">
		<button type="submit" name="searchAutoByThis" value="model">Search by Model</button>
		Year: <input type="text" name="year">
		<button type="submit" name="searchAutoByThis" value="year">Search by Year</button>
	</form>
	<a href="index.jsp">Add more vehicles</a>
</body>
</html>
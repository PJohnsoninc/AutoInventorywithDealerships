<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Existing Vehicle</title>
</head>
<body>
	<form action="editAutoServlet" method="post">
		Make: <input type="text" name="make" value="${autoToEdit.make.brandName }">
		Model: <input type="text" name="model" value="${autoToEdit.model }">
		Year: <input type="text" name="year" value="${autoToEdit.year }">
		<input type="hidden" name="id" value="${autoToEdit.id }">
		<input type="submit" value="Save Edited Vehicle">
	</form>
</body>
</html>
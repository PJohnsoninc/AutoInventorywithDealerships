<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Existing Brand</title>
</head>
<body>
	<form action="editBrandServlet" method="post">
		Brand: <input type="text" name="brand" value="${brandToEdit.brandName }">
		<input type="hidden" name="id" value="${brandToEdit.id }">
		<input type="submit" value="Save Edited Brand">
	</form>
</body>
</html>
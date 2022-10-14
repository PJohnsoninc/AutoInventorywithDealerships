<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Auto Index Page</title>
</head>
<body>
	
	<h2>Add Brand</h2>
	<form action="addBrandServlet" method="post">
		Brand: <input type="text" name="brand">
		<input type="submit" value="Add Brand">
	</form><br>
	<a href="viewAllBrandsServlet">View all brands</a><br>
	
	<a href="passToAutoServlet">Enter Vehicle</a><br>
	<a href="viewAllAutoServlet">View full inventory</a><br>
	<a href="auto-search.jsp">Search through vehicles</a><br />
	
	<a href = "viewAllDealershipsServlet">View all auto dealerships</a> <br />
	<a href = "addAutosForDealershipServlet">Create a new dealership auto list</a>
</body>
</html>
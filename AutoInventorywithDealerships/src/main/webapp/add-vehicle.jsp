<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add Vehicle</h2>
	<form action="addAutoServlet" method="post">
		Make:<br>
		<table>
			<c:forEach items="${requestScope.allBrands }" var="currentBrand">
				<tr>
					<td><input type="radio" name="id" value="${currentBrand.id }"></td>
					<td>${currentBrand.brandName }</td>
				</tr>
			</c:forEach>
		</table>
		Model: <input type="text" name="model"><br>
		Year: <input type="text" name="year"><br>
		<input type="submit" value="Add Vehicle">
	</form><br>
		
	<a href="index.jsp">Add more Brands</a><br>
	<a href="viewAllAutoServlet">View full inventory</a><br>
	<a href="auto-search.jsp">Search through vehicles</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Brands</title>
</head>
<body>
	<form action="brandNavServlet" method="post">
		<table>
			<c:forEach items="${requestScope.allBrands }" var="currentBrand">
				<tr>
					<td><input type="radio" name="id" value="${currentBrand.id }"></td>
					<td>${currentBrand.brandName }</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToBrand">
		<input type="submit" value="delete" name="doThisToBrand">
		<input type="submit" value="add" name="doThisToBrand">
	</form>
</body>
</html>
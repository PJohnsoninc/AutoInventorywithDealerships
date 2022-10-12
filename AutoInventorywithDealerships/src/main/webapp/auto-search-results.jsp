<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicle Search Results Page</title>
</head>
<body>
	<form action="navServlet" method="post">
		<table>
			<c:forEach items="${requestScope.autoResults }" var="currentVehicle">
				<tr>
					<td><input type="radio" name="id" value="${currentVehicle.id }"></td>
					<td>${currentVehicle.make }</td>
					<td>${currentVehicle.model }</td>
					<td>${currentVehicle.year }</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToAuto">
		<input type="submit" value="delete" name="doThisToAuto">
		<input type="submit" value="add" name="doThisToAuto">
	</form>
</body>
</html>
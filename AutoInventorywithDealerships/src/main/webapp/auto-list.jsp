<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Inventory</title>
</head>
<body>
	<form action="autoNavServlet" method="post">
		<table>
			<c:forEach items="${requestScope.allAuto }" var="currentVehicle">
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
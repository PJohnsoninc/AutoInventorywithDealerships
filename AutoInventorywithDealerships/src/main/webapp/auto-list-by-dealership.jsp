<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="dealershipNavigationServlet">
<table>
<c:forEach items="${requestScope.allDealerships}" var="currentdealership">
<tr>
	<td><input type="radio" name="id" value="${currentdealership.id}"></td>
	<td><h2>${currentdealership.name}</h2></td>
</tr>
	
<tr>
	<td colspan="3">Last Modified: ${currentdealership.lastModified}</td>
</tr>


<c:forEach var="listVal" items="${currentdealership.listOfVehicles}">
<tr><td></td>
<td colspan="3">
${listVal.make}, ${listVal.model}, ${listVal.year}
</td>
</tr>
</c:forEach>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToDealership">
<input type="submit" value="delete" name="doThisToDealership">
<input type="submit" value="add" name="doThisToDealership">

</form>
<a href="addAutosForDealershipServlet">Create a new dealership list</a><br />
<a href="index.jsp">Add an auto or brand instead</a>



</body>
</html>
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

<form action = "editDealershipServlet" method="post">
<input type ="hidden" name = "id" value= "${dealershipToEdit.id}">
Dealership Name: <input type ="text" name = "dealershipName" value= "${dealershipToEdit.dealershipName}"><br />

Last modified: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> <input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">
Brand Name: <input type = "text" name = "brandName" value= "${brandToEdit.brand.brandName}"><br />

Available Autos:<br />

<select name = "allAutosToAdd" multiple size = "6">
<c:forEach items = "${requestScope.allAutos}" var="currentauto">
<option value = "${currentauto.id}">${currentauto.make} | ${currentauto.model} | ${currentauto.year}</option>
</c:forEach>
</select>
<br />
<input type="submit" value="Edit Dealership and Add Autos">
</form>
<a href = "index.jsp">Go add auto or brand</a>


</body>
</html>
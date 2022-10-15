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

<form action = "createNewDealershipServlet" method="post">
Dealership Name: <input type="text" name = "dealershipName"><br />
Last Modified: <input type="text" name = "month" placeholder="mm" size="4">
<input type="text" name = "day" placeholder="dd" size="4">
<input type="text" name = "year" placeholder="yyyy" size="4"><br />

Available Brands to Carry:<br>
<select name = "allBrandsToAdd" multiple size = "6">
<c:forEach items = "${requestScope.allBrands}" var="currentbrand">
<option value = "${currentbrand.id}">${currentbrand.brandName}</option>
</c:forEach>
</select>
<br />

Available Autos: <br>
<select name = "allAutosToAdd" multiple size = "6">
<c:forEach items = "${requestScope.allAutos}" var="currentauto">
<option value = "${currentauto.id}">${currentauto.make} | ${currentauto.model} | ${currentauto.year}</option>
</c:forEach>
</select>
<br />
<input type="submit" value="Create Dealership and Add Autos">
</form>
<a href = "index.jsp">Go add auto or brand instead</a>



</body>
</html>
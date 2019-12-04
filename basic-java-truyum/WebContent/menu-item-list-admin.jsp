<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style\style.css">

</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<header>
truYum
<img src="images\truyum-logo-light.png">
<a  id="me" href="ShowMenuItemListAdmin">Menu</a>
</header>
<br>
<br><br>
<br>
<h2>Menu Items</h2>
<table>
<tr>
<th class="new">Name</th>
<th class="pew">Price</th>
<th >Active</th>
<th>Date of launch</th>
<th >Category</th>
<th >Free Delivery</th>
<th >Action</th>
</tr>
<c:forEach var="menuitem" items="${menuItemList}">
<tr>
<td class="new">${menuitem.name }</td>
<td class="pew"><fmt:setLocale value="en_IN"/><fmt:formatNumber value="${menuitem.price }" type="currency" groupingUsed="false" minFractionDigits="2" ></fmt:formatNumber></td>
<td ><c:if test="${menuitem.active eq true}">Yes</c:if>
<c:if test="${menuitem.active eq false}">No</c:if></td>

<td ><fmt:formatDate value="${menuitem.dateOfLaunch}" type='date' pattern='dd/MM/yyyy' dateStyle='short'/></td>
<td >${menuitem.category}</td>
<td><c:if test="${menuitem.freeDelivery eq true}"> Yes</c:if>
<c:if test="${menuitem.freeDelivery eq false}"> No</c:if></td>

<td><a href="ShowEditMenuItem?menuItemId=${menuitem.id}">Edit</a></td>
</tr>

</c:forEach>
</table>
<footer>
<p id="b">Copyright © 2019</p></footer>
</body>
</html>
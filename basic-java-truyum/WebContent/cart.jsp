<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style\st2.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<body>
<header>
truYum
<img src="images\truyum-logo-light.png">
<a  id="me" href="mShowMenuItemCustomer">Menu</a>
<a id="ca" href="ShowCart">Cart</a>
</header>
<br>
<br>
<h2> Cart</h2>
<c:if test="${ removeCartStatus eq true }"><p id="alert2"><b>Item removed from cart successfully</b></p> </c:if>
<table>
<tr>
<th class="new">Name</th>
<th >Free Delivery</th>
<th class="pew">Price</th>

<th ></th>
</tr>
<c:forEach var="item" items="${clist }">
<tr>
<td class="new">${item.name }</td>
<td><c:if test="${item.freeDelivery eq true }">Yes</c:if>
<c:if test="${item.freeDelivery eq false }">No</c:if></td>
<td class="pew"><fmt:setLocale value="en_IN"/><fmt:formatNumber value="${item.price }" type="currency" groupingUsed="false" minFractionDigits="2" ></fmt:formatNumber></td>

<td><a href="RemoveCart?menuItemId=${item.id} ">Delete</a></td>
</tr>
</c:forEach>

<th ></th>
<th ><b>Total</b></th>

<td class="pew"><b>Rs.${total}</b></td>
<tr>


</table>
<footer>
<p id="b">Copyright © 2019</p></footer>
</body>
</html>
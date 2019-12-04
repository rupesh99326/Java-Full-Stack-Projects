<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style\st3.css">
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<header> truYum <img src="images\truyum-logo-light.png">
	<a id="me" href="ShowMenuItemListAdmin">Menu</a> </header>
	<br>
	<br>
	<h2>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;Edit Menu Item</h2>



	<form name="menuItemForm" action="EditMenuItem" method="Post">
		<table>
			<tr>
				<td colspan="4"><b>Name</b></td>
			</tr>

			<tr>
				<td colspan="4"><input type="text" id="t1" name="name"
					value="${menuItem.name }" required></td>
			</tr>
			<tr>
				<td><b>Price(Rs.)</b></td>
				<td><b>Active</b></td>
				<td><b>Date of Launch</b></td>
				<td><b>Category</b></td>
			</tr>

			<tr>
				<td><input type="text" name="price" id="balu" value="${menuItem.price }" ></td>
				<td><input type="radio" name="Active" value="Yes"<c:if test="${menuItem.active eq true}">checked</c:if>>Yes<input type="radio" name="Active" value="No"<c:if test="${menuitem.active eq false}">checked</c:if>>No
					
				 </td>
					
					
					
<td><input type="text" name="date" value="<fmt:formatDate value="${menuItem.dateOfLaunch}" type='date' pattern='dd/MM/yyyy' dateStyle='short' />" ></td>
<td><select name="select">

<option value="${menuItem.category }"<c:if test="${menuItem.category  eq 'Main Course'}">selected</c:if>>Main Course</option>
<option value="${menuItem.category }"<c:if test="${menuItem.category  eq 'Starters'}">selected</c:if>>Starters</option>

<option value="${menuItem.category }"<c:if test="${menuItem.category  eq 'Dessert'}">selected</c:if>>Dessert</option>
<option value="${menuItem.category }"<c:if test="${menuItem.category  eq 'Drinks'}">selected</c:if>>Drinks</option>

</select></td>
</tr>

<tr>
<td colspan="4"><input type="checkbox" name="Delivery" value="yes" <c:if test="${menuItem.freeDelivery eq true}">checked</c:if>><b>Free Delivery</b>


</td>

</tr>

<tr>
<input type="hidden" name="id" value="${menuItem.id }">
<td colspan="4"><button type="submit" id="b2" onclick="return validateMenuItemForm()">Save</button></td>
</table>

</form>
<footer>
<p id="b">Copyright © 2019</p></footer>
<script src="js\script1.js"></script>
</script>
</body>
</html>
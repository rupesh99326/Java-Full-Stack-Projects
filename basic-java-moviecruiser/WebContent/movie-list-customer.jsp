<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style\style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<header> Movie Cruiser <img src="images\logo.png"> <a
		id="mov" href="ShowMovieListCustomer">Movies</a> <a id="fav"
		href="ShowFavorites">Favorites</a> <%@taglib prefix="c"
		uri="http://java.sun.com/jsp/jstl/core"%> <%@taglib
		prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	</header>
	<br>
	<br>
	<br>
	<br>
	<h2>Movies</h2>
	<c:if test="${addFavoritesStatus eq true }">
		<p id="alert2">
			<b>Item added to cart successfully</b>
		</p>
	</c:if>
	<table>
		<tr>
			<th class="new">Title</th>
			<th class="Boxoffice">Box Office</th>
			<th id="pew">Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach var="movie" items="${movieList}">
			<tr>
				<td class="new">${movie.title}</td>
				<td class="pew"><fmt:setLocale value="en_US" /> <fmt:formatNumber
						value="${movie.boxoffice}" type="currency" minFractionDigits="0"></fmt:formatNumber></td>
				<td>${movie.genre }</td>


				<td><c:if test="${movie.hasteaser eq true}"> Yes</c:if> <c:if
						test="${movie.hasteaser eq false}"> No</c:if></td>
				<td><a href="AddToFavorites?movieId=${movie.id}">Add to
						Favorite</a></td>
			</tr>
		</c:forEach>

	</table>
	<footer>
	<p id="b">Copyright © 2019</p>
	</footer>



</body>
</html>
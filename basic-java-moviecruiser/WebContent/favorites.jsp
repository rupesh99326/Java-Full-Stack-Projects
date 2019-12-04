<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style\style.css">
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<header> Movie Cruiser <img src="images\logo.png"> <a
		id="mov" href="ShowMovieCustomer">Movies</a> <a id="fav"
		href="ShowFavorites">Favorites</a> </header>
	<br>
	<br>
	<h2 id="ir">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Favorites</h2>
	<br>
	<c:if test="${ removeFavoritesStatus eq true }">
		<p id="alert2">
			<b>Item removed from favorites successfully</b>
		</p>
	</c:if>

	<br>
	<table>
		<tr>
			<th class="new">Title</th>
			<th class="Boxoffice">Box Office</th>
			<th id="p">Genre</th>

		</tr>
		<c:forEach var="item" items="${flist.getMovieList() }">
			<tr>
				<td class="new">${item.title }</td>
				<td class="pew"><fmt:setLocale value="en_IN" />
					<fmt:formatNumber value="${item.boxoffice }" type="currency"
						minFractionDigits="0"></fmt:formatNumber></td>

				<td>${item.genre }</td>
				<td><a href="RemoveFavorites?movieId=${item.id}">Delete</a></td>
			</tr>
		</c:forEach>

		<tr>
			<td id="ig"><br>
			<br> <b>No. of Favorites: ${flist.nooffavorites} </b></td>
		</tr>
	</table>
	<footer>
	<p id="b">copyright © 2019</p>
	</footer>
</body>
</html>
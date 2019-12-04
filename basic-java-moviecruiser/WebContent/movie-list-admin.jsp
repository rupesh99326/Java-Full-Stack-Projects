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
	<header> Movie Cruiser <img src="images\logo.png"> <a
		id="mov" href="ShowMovieListAdmin">Movies</a> </header>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>







	<h2 id="u">Movies</h2>
	<br>
	<table id="table1">
		<tr>
			<th class="new">Title</th>
			<th class="pew">Box Office</th>
			<th>Active</th>
			<th>Date of launch</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach var="movie" items="${movieList}">
			<tr>
				<td class="new">${movie.title}</td>
				<td class="pew"><fmt:setLocale value="en_US" /> <fmt:formatNumber
						value="${movie.boxoffice }" type="currency" minFractionDigits="0"></fmt:formatNumber></td>
				<td><c:if test="${movie.active eq true}">Yes</c:if> <c:if
						test="${movie.active eq false}">No</c:if></td>
				<td><fmt:formatDate value="${movie.dateOfLaunch}" type='date'
						pattern='dd/MM/yyyy' dateStyle='short' /></td>
				<td>${movie.genre }</td>
				<td><c:if test="${movie.hasteaser eq true}"> Yes</c:if> <c:if
						test="${movie.hasteaser eq false}"> No</c:if></td>
				<td><a href="ShowEditMovie?movieId=${movie.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<footer>
	<p id="b">Copyright © 2019</p>
	</footer>
</body>
</html>
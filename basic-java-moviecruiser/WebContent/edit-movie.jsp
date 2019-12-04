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
		id="mv" href="movie-list-admin.html">Movies</a> </header>
	<br>
	<br>
	<h2 id="h21">Edit Movie</h2>

	<br>
	<br>

	<form name="movieForm" action="EditMovie" method="Post">
		<table>
			<tr>
				<td colspan="4" class="df"><label for="t1"><b>Title</b></label></td>
			</tr>
			<tr>
				<td colspan="4" class="df"><input type="text" id="t1"
					name="name" value="${movie.title }" required></td>
			</tr>
			<tr>
				<td class="df"><label for="t2"><b>Gross($)</b></label></td>
				<td class="df"><label for="t3"><b>Active</b></label></td>
				<td class="df"><label for="t4"><b>Date of Launch</b></label></td>
				<td class="df"><label for="t5"><b>Genre</b></label></td>
			</tr>
			<tr>
				<td class="df"><input type="text" name="price" id="t2"
					value="${movie.boxoffice }" required></td>
				<td class="df"><input type="radio" name="active" value="yes"
					id="t3" <c:if test="${movie.active eq true}"> checked</c:if>>Yes<input
					type="radio" name="active" value="no"
					<c:if test="${movie.active eq false}">checked</c:if>>No</td>
				<td class="df"><input type="text" name="dateOfLaunch" id="t4"
					value="<fmt:formatDate value="${movie.dateOfLaunch}" type='date' pattern='dd/MM/yyyy' dateStyle='short' />">
				</td>
				<td class="df"><select name="select" id="t5">
						<option></option>
						<option value="Superhero"
							<c:if test="${movie.genre  eq 'Superhero'}">selected</c:if>>Superhero</option>
						<option value="Science Fiction"
							<c:if test="${movie.genre  eq 'Science Fiction'}">selected</c:if>>Science
							Fiction</option>
						<option value="Superhero"
							<c:if test="${movie.genre  eq 'Superhero'}">selected</c:if>>Superhero</option>
						<option value="Romance"
							<c:if test="${movie.genre  eq 'Romance'}">selected</c:if>>Romance</option>
						<option value="Comedy"
							<c:if test="${movie.genre  eq 'Comedy'}">selected</c:if>>Comedy</option>
						<option value="Adventure"
							<c:if test="${movie.genre  eq 'Adventure'}">selected</c:if>>Adventure</option>
						<option value="Thriller"
							<c:if test="${movie.genre  eq 'Thriller'}">selected</c:if>>Thriller</option>
				</select></td>
			</tr>
			<tr>



				<td colspan="4" class="df"><input type="checkbox" id="m"
					name="Delivery" value="yes"
					<c:if test="${movie.hasteaser eq true}">checked</c:if>><b>Has
						Teaser</b>
			</tr>
			<tr>
				<input type="hidden" name="id" value="${movie.id }">
				<td colspan="4" class="df"><button type="submit" id="b2"
						onclick="return validateMovieForm()">Save</button></td>
		</table>
	</form>
	<footer>
	<p id="b">Copyright © 2019</p>
	</footer>
	<script src="js/script2.js" >
		</script>
	</script>
</body>
</html>
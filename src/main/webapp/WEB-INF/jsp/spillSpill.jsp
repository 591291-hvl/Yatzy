<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- Fra https://purecss.io/ -->
<title>Yatzy</title>
<style>
input[type=checkbox] {
	display: none;
}

input#dice1[type=checkbox]+label {
	background-repeat: no-repeat;
	background-size: cover;
	border-color: Black;
	border-style: solid;
	height: 50px;
	width: 50px;
	display: inline-block;
	padding: 0 0 0 0px;
}

input#dice2[type=checkbox]+label {
	background-repeat: no-repeat;
	background-size: cover;
	border-color: Black;
	border-style: solid;
	height: 50px;
	width: 50px;
	display: inline-block;
	padding: 0 0 0 0px;
}

input#dice3[type=checkbox]+label {
	background-repeat: no-repeat;
	background-size: cover;
	border-color: Black;
	border-style: solid;
	height: 50px;
	width: 50px;
	display: inline-block;
	padding: 0 0 0 0px;
}

input#dice4[type=checkbox]+label {
	background-repeat: no-repeat;
	background-size: cover;
	border-color: Black;
	border-style: solid;
	height: 50px;
	width: 50px;
	display: inline-block;
	padding: 0 0 0 0px;
}

input#dice5[type=checkbox]+label {
	background-repeat: no-repeat;
	background-size: cover;
	border-color: Black;
	border-style: solid;
	height: 50px;
	width: 50px;
	display: inline-block;
	padding: 0 0 0 0px;
}

input#dice1[type=checkbox]:checked+label {
	border-color: red;
	border-style: solid;
	height: 50px;
	width: 50px;
	display: inline-block;
	padding: 0 0 0 0px;
}

input#dice2[type=checkbox]:checked+label {
	border-color: red;
	border-style: solid;
	height: 50px;
	width: 50px;
	display: inline-block;
	padding: 0 0 0 0px;
}

input#dice3[type=checkbox]:checked+label {
	border-color: red;
	border-style: solid;
	height: 50px;
	width: 50px;
	display: inline-block;
	padding: 0 0 0 0px;
}

input#dice4[type=checkbox]:checked+label {
	border-color: red;
	border-style: solid;
	height: 50px;
	width: 50px;
	display: inline-block;
	padding: 0 0 0 0px;
}

input#dice5[type=checkbox]:checked+label {
	border-color: red;
	border-style: solid;
	height: 50px;
	width: 50px;
	display: inline-block;
	padding: 0 0 0 0px;
}
</style>
</head>

<body>
	<h1>Yatzy</h1>
	<table>
		<tr>
			<th></th>
			<c:forEach items="${spillere}" var="s">
				<th><c:out value="${s.navn}" /></th>
			</c:forEach>
		</tr>

		<c:forEach begin="0" end="${fn:length(brett) - 1}" var="i">
			<tr>
				<td><c:out value="${rowInfo[i]}" /></td>
				<c:forEach begin="0" end="${fn:length(brett[i]) - 1}" var="j">
					<td><c:out value="${brett[i][j]}" /></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

	<form method="post">

		<!-- Repeat with loop -->
		<c:forEach begin="0" end="${fn:length(terninger) - 1}" var="i">
			<input type="checkbox" name='dices'
				id="dice<c:out value="${i+1}" />"
				value="dice<c:out value="${i+1}" />" />
			<label for="dice<c:out value="${i+1}" />"
				style="background-image: url('images/<c:out value="${terninger[i]}.png'" />)"></label>
		</c:forEach>

	<button type="submit" name="btn" value="btnStart" class="pure-button pure-button-primary">Behold terninger</button>
		

	</form>


</body>
</html>
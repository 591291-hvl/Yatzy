<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Yatzy</title>
</head>
<body>
	<h1>Yatzy</h1>
	<h2>
		<a href="LagSpillServlet">Lag Nytt Spill</a>
	</h2>
	<table>
	<tr bgcolor="#cccccc">
			<th align="left">Brukernavn</th>
			<th align="left">Navn</th>
			<th align="left">Epost</th>
		</tr>

	<c:forEach items="${spillere}" var="s">
		<tr>
			<td><c:out value="${s.brukernavn}"/></td>
			<td><c:out value="${s.navn}"/></td>
			<td><c:out value="${s.epost}"/></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>
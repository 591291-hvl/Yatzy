<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>SpillerListe</title>
</head>
<body>
	<h2>Spillerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th align="left">Id</th>
			<th align="left">Navn</th>

		</tr>

		<c:forEach items="${spillere}" var="s">

		
		<td>${s.id}</td>
		<td>${s.name}</td>
		
		</c:forEach>
	</table>
</body>
</html>
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
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Yatzy</title>
</head>
<body>
	<h1>Yatzy</h1>
	
	<form method="post">
		<h2>Bli med i spill</h2>
		<label for="spillID">Spill kode:</label>
          <input type="text" name="spillID" id="spillID" value="${landingsside.spillID}"
               placeholder="Skriv inn spill kode"
               title="Koden innholder ofte tall"
           />
          <span class="melding">${landingside.spillKodeMelding}</span>
	
	
	
		<button type="submit" class="pure-button pure-button-primary">Lag nytt spill</button>
	</form>
	
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
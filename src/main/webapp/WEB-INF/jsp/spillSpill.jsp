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


</body>
</html>
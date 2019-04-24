
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Attori</title>
<style type="text/css">
<jsp:include page="../frammenti/css/table.css"></jsp:include>

</style>

</head>
<body>
	
<table class="blueTable" style="height: 150px;" width="406">
<thead>
<tr>
<th>Id Attore</th>
<th>Nome Attore</th>
<th>Cognome Attore</th>
<th>Età Attore</th>
</tr>
</thead>
<tfoot>
<tr>
<td colspan="4">&nbsp;</td>
</tr>
</tfoot>
<tbody>
	<c:forEach  items= "${listaattori}" var="a">
<tr>
	
	
					<td><c:out value="${a.idAttore}" /></td>
					<td><c:out value="${a.nomeAttore}" /></td>
					<td><c:out value="${a.cognomeAttore}" /></td>
					<td><c:out value="${a.etaAttore}" /></td>
					
</tr>

</c:forEach>
</tbody>
</table>
</body>
</html>
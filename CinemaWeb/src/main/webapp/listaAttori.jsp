
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Attori</title>
<jsp:include page="frammenti/html/navbar.html"></jsp:include>
<jsp:include page="frammenti/html/bootstrap.html"></jsp:include>
<style type="text/css">
<jsp:include page="frammenti/css/table.css"></jsp:include>
<jsp:include page="frammenti/css/navbar.css"></jsp:include>
</style>
</head>
<body>
	
<table class="blueTable" style="height: 150px;" width="406">
<thead>
<tr>
<th>Id Attore</th>
<th>Nome Attore</th>
<th>Cognome Attore</th>
<th>Et� Attore</th>
<th colspan=2>Action</th>
</tr>
</thead>

<tbody>
	<c:forEach  items= "${attori}" var="attore">
<tr>
	
	
					<td><c:out value="${attore.idAttore}" /></td>
					<td><c:out value="${attore.nomeAttore}" /></td>
					<td><c:out value="${attore.cognomeAttore}" /></td>
					<td><c:out value="${attore.etaAttore}" /></td>
					 <td><a href="AttoreController?action=edit&idAttore=<c:out value="${attore.idAttore}"/>">Update</a></td>
                    <td><a href="AttoreController?action=delete&idAttore=<c:out value="${attore.idAttore}"/>" onclick="return confirm('conferma cancellazione di ${attore.cognomeAttore}?')">Delete</a></td>
					
</tr>

</c:forEach>
</tbody>
</table>
 <p><a href="AttoreController?action=insert">Aggiungi Attore</a></p>
</body>
</html>
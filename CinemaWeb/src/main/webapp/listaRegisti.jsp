<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registi</title>
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
<th>Id Regista</th>
<th>Nome Regista</th>
<th>Cognome Regista</th>
<th>Età Regista</th>
<th colspan=2>Action</th>
</tr>
</thead>

<tbody>
	<c:forEach  items= "${registi}" var="regista">
<tr>
	
	
					<td><c:out value="${regista.idRegista}" /></td>
					<td><c:out value="${regista.nomeRegista}" /></td>
					<td><c:out value="${regista.cognomeRegista}" /></td>
					<td><c:out value="${regista.etaRegista}" /></td>
					 <td><a href="RegistaController?action=edit&idRegista=<c:out value="${regista.idRegista}"/>">Update</a></td>
                    <td><a href="RegistaController?action=delete&idRegista=<c:out value="${regista.idRegista}"/>" onclick="return confirm('conferma cancellazione di ${regista.cognomeRegista}?')">Delete</a></td>
					
</tr>

</c:forEach>
</tbody>
</table>
 <p><a href="RegistaController?action=insert">Aggiungi Regista</a></p>
</body>
</html>
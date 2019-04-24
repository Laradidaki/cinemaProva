<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Film</title>
<style type="text/css">
<jsp:include page="../frammenti/css/table.css"></jsp:include>

</style>

</head>
<body>
	
<table class="blueTable" style="height: 150px;" width="406">
<thead>
<tr>
<th>Id Film</th>
<th>Nome Film</th>
</tr>
</thead>
<tfoot>
<tr>
<td colspan="4">&nbsp;</td>
</tr>
</tfoot>
<tbody>
	<c:forEach  items= "${listafilm}" var="f">
<tr>
	
					<td><c:out value="${f.idFilm}" /></td>
					<td><c:out value="${f.nomeFilm}" /></td>
					
</tr>

</c:forEach>
</tbody>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%= request.getContextPath()+"/aggiungifilm" %>" method="post">
Inserisci l'id del film<input type="text" name="idFilm" value=""/><br>
Inserisci il titolo del film<input type="text" name="titoloFilm" value=""/><br>
Inserisci la durata del film<input type="text" name="durataFilm" value=""/><br>
Inserisci l'anno di produzione del film<input type="text" name="annoFilm" value=""/><br>
Inserisci il budget del film<input type="text" name="costoFilm" value=""/><br>
		<input type="submit" value="submit"/>
</form>
</body>
</html>
<%@page import="java.util.List"%>
<h1>titolo pagina 1</h1>
<p>

<%
List<String>carrello= (List<String>)request.getSession().getAttribute("carrello");
	if (carrello != null && carrello.size()>0 ) {
		for(String articolo:carrello){
			out.println(articolo+ "<br>");
		}
		
	}
	else {
		out.println("Non ci sono articoli nel carrello");
	}
%>



</p>
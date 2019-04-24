<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DB Cinema</title>
</head>
<body>
<form action="<%= request.getContextPath()+"/dbcinemacontroller" %>" method="get">
<%
Connection con;
Statement sql;
ResultSet rs;
try{Class.forName("com.mysql.jdbc.Driver").newInstance();}
catch(Exception e){out.print(e);}
try{
    String uri="jdbc:mysql://localhost:3306/cinema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    con=DriverManager.getConnection(uri,"root","");
    sql=con.createStatement();
    rs=sql.executeQuery("SELECT * FROM attore");
    out.print("<table border=2>");
    out.print("<tr>");
    out.print("<th width=100>"+"nomeAttore");
    out.print("<th width=100>"+"cognomeAttore");
    out.print("<th width=100>"+"etaAttore");
    out.print("</tr>");
    while(rs.next()){
        out.print("<tr>");
        out.print("<td>"+rs.getString(1)+"</td>");
        out.print("<td>"+rs.getString(2)+"</td>");
        out.print("<td>"+rs.getString(3)+"</td>");
        out.print("</tr>");
    }
    out.print("</table>");
    con.close();
}
catch(SQLException e1){out.print(e1);}
%>
</body>
</html>
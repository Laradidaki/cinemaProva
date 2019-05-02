package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Attore;
import model.Utente;
import servletvecchie.DBConnection;


@WebServlet("/registrazione")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	Connection connection;
	Statement statement;
	DBConnection dbcon;
	List<Attore> lista=new ArrayList<Attore>();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			String nome=request.getParameter("nome");
			String cognome=request.getParameter("cognome");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String sql="insert into utente(username, password, nome, cognome) values(?,?,?,?)";
			dbcon= new DBConnection();
			connection=dbcon.getConnection();
//			Utente utente= new Utente();
//			utente.setNome(request.getParameter("nome"));
//			utente.setCognome(request.getParameter("cognome"));
//			utente.setUsername(request.getParameter("username"));
//			utente.setPassword(request.getParameter("password"));
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, nome);
			ps.setString(4, cognome);
			ps.executeUpdate();
			
			request.getRequestDispatcher("confermaRegistrazione.jsp").forward(request, response);
				
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
		

}

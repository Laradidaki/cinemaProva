package oggetti;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import servlet.DBConnection;

public class UtenteDao {

		static Connection connection;
		
		static ResultSet resultSet;
		static DBConnection dbcon;
	 
	 public static Utente login(Utente utente) { 
		 
		
		 String username = utente.getUsername();
		 String password = utente.getPassword();
		 Statement statement=null;
		 String searchQuery = "select username,password from utente where username='" + username + "' AND password='" + password + "'";
		 
		 System.out.println("Your user name is " + username);
		 System.out.println("Your password is " + password);
		 System.out.println("Query: "+searchQuery); 
		 try { 
			 //connessione al DB
			 dbcon= new DBConnection();
			 connection=dbcon.getConnection();
			 statement=connection.createStatement(); 
			 resultSet = statement.executeQuery(searchQuery);
			 boolean user = resultSet.next(); 
			 // se l'utente non è registrato inizializzo la variabile a false
			 if (!user) { 
				 System.out.println("Spiacente. Non è ancora registrato");
			
				 utente.setValid(false);
			 } 
			 //se l'utente è registrato la inizializzo a true
			 else if (user)
			 {
			 String nome = resultSet.getString("nome");
			 String cognome = resultSet.getString("cognome"); 
			 System.out.println("Welcome " + nome);
			 utente.setNome(nome);
			 utente.setCognome(cognome);
			 utente.setValid(true); 
			 }
			 }
		 catch (Exception ex) 
		 {
				 System.out.println("Login fallito, si è verificata la seguente eccezione " + ex); 
		
		 } 
	
		 finally 
		 { if (resultSet != null)
		
		 { 
			 try { resultSet.close();
		 } 
		 
		 catch (Exception e)
		 {
			 
		 } 
		 resultSet = null; }
		 
		 if (statement != null)
		
		 { try 
		
		 { 
		
			 statement.close(); 
		 } 
		
		 catch (Exception e)
		 {
			 
		 } 
		 statement = null; 
		
		 } 
		 if (connection != null) 
		 
		 { 
			 try 
			 {
				 connection.close();
			 } 
			 catch (Exception e)
			 { 
				 
			 } 
			 connection = null;
			 } 
		 } 
		 return utente;
		 } 
		 
	 }



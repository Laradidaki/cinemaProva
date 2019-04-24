package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oggetti.Utente;
import oggetti.UtenteDao;

@WebServlet("/loginNuovo")
public class LoginNuovo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 Utente utente = new Utente();
			 utente.setUsername(request.getParameter("username"));
			 utente.setPassword(request.getParameter("password"));
			 utente = UtenteDao.login(utente);
			 if (utente.isValid()) 
			 { 
//				 HttpSession session = request.getSession(true);
//			     session.setAttribute("currentSessionUser",utente);
			     response.sendRedirect("loginValido.jsp");
			 //pagina di login avvenuto con successo
			 }
		 else response.sendRedirect("loginNonValido.jsp");
		 //pagina di errore
		 }
		 
	   catch (Throwable theException)
	  { 
		
		   System.out.println(theException);
		
	  } 
	
	}	 
	
		 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

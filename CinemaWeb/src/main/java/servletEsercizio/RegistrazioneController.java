package servletEsercizio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registraprova")
public class RegistrazioneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		}
	 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		azioni(request, response);
		String nome= request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>Ciao</title></head>");
		out.println("<body>");
		out.println("<h1>Ciao " +nome+ " " +cognome+ "</h1>");
		out.println("</body>");
		out.println("</html>");
	
	//response.getWriter().append(" "+(String) request.getAttribute("Akita"));
	}
		
	
	
	
	protected void azioni(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
	response.getWriter().append("Served at:").append(request.getContextPath());
		
		response.getWriter().append(" Metodo:"+ request.getMethod());
		
		response.getWriter().append(" Context:"+ request.getContextPath());
		
		response.getWriter().append(" parametro:" + request.getParameter("pippo"));
		
		String[] parametri= request.getParameterValues("pippo");
		
		for (String param : parametri) {
			response.getWriter().append(" Parametro:"+param);
			
			request.setAttribute("Akita", "prova");
	}
	}

}

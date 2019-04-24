package servletEsercizio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dispatcher
 */
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		
		String pagina= request.getParameter("pagina");
		if (pagina != null && !pagina.trim().equals("")) {
			if(pagina.equals("1")) {
				
			List<String>carrello=(List<String>) request.getSession().getAttribute("carrello");
			if(carrello==null) {
				carrello=new ArrayList<String>();
				request.getSession().setAttribute("carrello", carrello);
			
			}
			String articolo=request.getParameter("articolo");
			if(articolo!=null && !articolo.trim().equals("")) {
			carrello.add(articolo);
			}
				request.getServletContext().getRequestDispatcher("/jsp/pagina1.jsp").include(request, response);	
			}
			
			else if(pagina.equals("2")) {
				request.getServletContext().getRequestDispatcher("/jsp/pagina2.jsp").include(request, response);
			}
			
			else if(pagina.equals("3")) {
				request.getServletContext().getRequestDispatcher("/jsp/pagina3.jsp").include(request, response);
				
			}
		}
			else {
				request.getServletContext().getRequestDispatcher("/jsp/body.jsp").include(request, response);
			
		}
		//request.getServletContext().getRequestDispatcher("/jsp/body.jsp").include(request, response);
		//request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

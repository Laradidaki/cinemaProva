package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttoreDao;
import model.Attore;

/**
 * Servlet implementation class AttoreController
 */
public class AttoreController extends HttpServlet {
	   private static final long serialVersionUID = 1L;
	    private static String INSERT_OR_EDIT = "/attore.jsp";
	    private static String LISTA_ATTORI = "/listaAttori.jsp";
	    private AttoreDao dao;

	    public AttoreController() {
	        super();
	        dao = new AttoreDao();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward="";
	        String action = request.getParameter("action");

	        if (action.equalsIgnoreCase("delete")){
	            int idAttore = Integer.parseInt((String)request.getParameter("idAttore"));
	            dao.deleteAttore(idAttore);
	            forward = LISTA_ATTORI;
	            request.setAttribute("attori", dao.getAllAttori());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT;
	            int idAttore = Integer.parseInt((String)request.getParameter("idAttore"));
	            Attore attore = dao.getAttoreById(idAttore);
	            request.setAttribute("attore", attore);
	        } else if (action.equalsIgnoreCase("listaAttori")){
	            forward = LISTA_ATTORI;
	            request.setAttribute("attori", dao.getAllAttori());
	        } else {
	            forward = INSERT_OR_EDIT;
	        }

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        Attore attore = new Attore();
	        attore.setNomeAttore(request.getParameter("nomeAttore"));
	        attore.setCognomeAttore(request.getParameter("cognomeAttore"));
	        attore.setEtaAttore(request.getParameter("etaAttore"));
	        String idAttore = request.getParameter("idAttore");
	        if(idAttore == null || idAttore.isEmpty())
	        {
	            dao.addAttore(attore);
	        }
	        else
	        {
	            attore.setIdAttore(Integer.parseInt(idAttore));
	            dao.updateAttore(attore);
	        }
	        RequestDispatcher view = request.getRequestDispatcher(LISTA_ATTORI);
	        request.setAttribute("attori", dao.getAllAttori());
	        view.forward(request, response);
	    }

}

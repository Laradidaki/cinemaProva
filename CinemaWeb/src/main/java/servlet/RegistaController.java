package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.RegistaDao;
import model.Regista;

/**
 * Servlet implementation class RegistaController
 */
public class RegistaController extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    private static String INSERT_OR_EDIT = "/regista.jsp";
	    private static String LISTA_REGISTI = "/listaRegisti.jsp";
	    private RegistaDao dao;

	    public RegistaController() {
	        super();
	        dao = new RegistaDao();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward="";
	        String action = request.getParameter("action");

	        if (action.equalsIgnoreCase("delete")){
	            int idRegista = Integer.parseInt((String)request.getParameter("idRegista"));
	            dao.deleteRegista(idRegista);
	            forward = LISTA_REGISTI;
	            request.setAttribute("registi", dao.getAllRegisti());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT;
	            int idRegista = Integer.parseInt((String)request.getParameter("idRegista"));
	            Regista regista = dao.getRegistaById(idRegista);
	            request.setAttribute("regista", regista);
	        } else if (action.equalsIgnoreCase("listaRegisti")){
	            forward = LISTA_REGISTI;
	            request.setAttribute("registi", dao.getAllRegisti());
	        } else {
	            forward = INSERT_OR_EDIT;
	        }

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        Regista regista= new Regista();
	        regista.setNomeRegista(request.getParameter("nomeRegista"));
	        regista.setCognomeRegista(request.getParameter("cognomeRegista"));
	        regista.setEtaRegista(request.getParameter("etaRegista"));
	        String idRegista = request.getParameter("idRegista");
	        if(idRegista == null || idRegista.isEmpty())
	        {
	            dao.addRegista(regista);
	        }
	        else
	        {
	            regista.setIdRegista(Integer.parseInt(idRegista));
	            dao.updateRegista(regista);
	        }
	        RequestDispatcher view = request.getRequestDispatcher(LISTA_REGISTI);
	        request.setAttribute("registi", dao.getAllRegisti());
	        view.forward(request, response);
	    }

}

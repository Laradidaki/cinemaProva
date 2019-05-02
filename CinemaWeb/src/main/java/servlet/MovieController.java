package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.FilmDao;
import model.Film;


/**
 * Servlet implementation class MovieController
 */
public class MovieController extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    private static String INSERT_OR_EDIT = "/film.jsp";
	    private static String LISTA_FILM = "/listaFilm.jsp";
	    private FilmDao dao;

	    public MovieController() {
	        super();
	        dao = new FilmDao();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward="";
	        String action = request.getParameter("action");

	        if (action.equalsIgnoreCase("delete")){
	            int idFilm = Integer.parseInt(request.getParameter("idFilm"));
	            dao.deleteFilm(idFilm);
	            forward = LISTA_FILM;
	            request.setAttribute("movies", dao.getAllFilm());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT;
	            int idFilm = Integer.parseInt(request.getParameter("idFilm"));
	            Film film = dao.getFilmById(idFilm);
	            request.setAttribute("film", film);
	        } else if (action.equalsIgnoreCase("listaFilm")){
	            forward = LISTA_FILM;
	            request.setAttribute("movies", dao.getAllFilm());
	        } else {
	            forward = INSERT_OR_EDIT;
	        }

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        Film film = new Film();
	        film.setNomeFilm(request.getParameter("nomeFilm"));
	        film.setDurataFilm(request.getParameter("durataFilm"));
	        film.setAnnoFilm(request.getParameter("annoFilm"));
	        film.setCostoFilm(request.getParameter("costoFilm"));
	        String idFilm = request.getParameter("idFilm");
	        if(idFilm == null || idFilm.isEmpty())
	        {
	            dao.addFilm(film);
	        }
	        else
	        {
	            film.setIdFilm(Integer.parseInt(idFilm));
	            dao.updateFilm(film);
	        }
	        RequestDispatcher view = request.getRequestDispatcher(LISTA_FILM);
	        request.setAttribute("movies", dao.getAllFilm());
	        view.forward(request, response);
	    }

}

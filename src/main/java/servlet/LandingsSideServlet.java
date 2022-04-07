package servlet;


import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SpillerDAO;
import entity.Spiller;


@WebServlet(name = "LandingsSideServlet", urlPatterns = "/LandingsSideServlet")
public class LandingsSideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private SpillerDAO spillerDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Henter alle deltagerene sortert etter navn
		List<Spiller> spillere = spillerDao.finnAlleEtterBrukernavn();
		
		for(Spiller s : spillere) {
			System.out.println(s.toString());
		}

		// Setter deltagerene som atributt i requesten, hentes ut i jsp siden...
		request.setAttribute("spillere", spillere);

		// Gå til deltagerlisten
		request.getRequestDispatcher("WEB-INF/jsp/landingsside.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

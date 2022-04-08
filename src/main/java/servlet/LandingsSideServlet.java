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
import dao.YatzyDAO;
import entity.Spiller;
import entity.Yatzy;


@WebServlet(name = "LandingsSideServlet", urlPatterns = "/LandingsSideServlet")
public class LandingsSideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private SpillerDAO spillerDao;
	@EJB
	private YatzyDAO yatzyDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Henter alle deltagerene sortert etter navn
		List<Spiller> spillere = spillerDao.finnAlleEtterBrukernavn();
		
		for(Spiller s : spillere) {
			System.out.println(s.toString());
		}

		// Setter deltagerene som atributt i requesten, hentes ut i jsp siden...
		request.setAttribute("spillere", spillere);

		// G� til deltagerlisten
		request.getRequestDispatcher("WEB-INF/jsp/landingsside.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//check which button was pressed
		if(true) {
			//send to existing game, or error
			
		}
		//create new game
		//Spiller spiller = (Spiller) request.getSession().getAttribute("spiller");
		//System.out.println(spiller.toString());
		Yatzy yatzy = new Yatzy();
		yatzy.setAntall(0);
		yatzy.setBrett("");
		System.out.println(yatzy.toString());
		System.out.println((yatzyDao == null) + "==============================");
		yatzyDao.lagNyttSpill(yatzy);
		
		
		
		response.sendRedirect("LagSpillServlet");
		
	}

}

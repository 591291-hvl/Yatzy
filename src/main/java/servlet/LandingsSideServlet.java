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
//	@EJB
//	private SpilldeltagelseDAO deltagelsDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Henter alle deltagerene sortert etter navn
		List<Spiller> spillere = spillerDao.finnAlleEtterBrukernavn();
		
		for(Spiller s : spillere) {
			System.out.println(s.toString());
		}

		// Setter deltagerene som atributt i requesten, hentes ut i jsp siden...
		request.setAttribute("spillere", spillere);
		
		request.setAttribute("spillKodeMelding", request.getSession().getAttribute("spillKodeMelding"));

		// G� til deltagerlisten
		request.getRequestDispatcher("WEB-INF/jsp/landingsside.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String btnValue = request.getParameter("btn");
		//check which button was pressed
		if(btnValue.equals("bliMed")) {
			//send to existing game, or error
			String inpValue = request.getParameter("spillID");
			if(inpValue.isBlank()) {
				request.getSession().setAttribute("spillKodeMelding", "Ingen spillkode");
				response.sendRedirect("LandingsSideServlet");
				return;
			}
			//wrong spillID
			if(!yatzyDao.spillFinnes(Integer.parseInt(inpValue))) {
				request.getSession().setAttribute("spillKodeMelding", "Feil spillkode");
				response.sendRedirect("LandingsSideServlet");
				return;
			}else {//Riktig
				//add user to game
				//redirect to game side
//				Spiller spiller = (Spiller) request.getSession().getAttribute("spiller");
//				SpilldeltagelseEntityPK deltagelse = new SpilldeltagelseEntityPK();
//				deltagelse.setBrukernavn(spiller.getBrukernavn());
//				deltagelse.setId(Integer.parseInt(inpValue));
//				deltagelsDao.lagre(deltagelse);
				
				
				return;
			}
			
		}
		//create new game
		Spiller spiller = (Spiller) request.getSession().getAttribute("spiller");
		Yatzy yatzy = new Yatzy();
		yatzy.setAntall(0);
		yatzy.setBrett("");
		yatzyDao.lagNyttSpill(yatzy);
		
		yatzy.leggTilSpiller(spiller);
		yatzyDao.leggTilSpiller(yatzy, spiller);
		
		
		response.sendRedirect("LagSpillServlet");
		
	}

}

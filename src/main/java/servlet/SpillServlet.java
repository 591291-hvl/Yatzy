package servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.Board;
import backend.RoundUtils;
import dao.SpillerDAO;
import dao.YatzyDAO;
import entity.SpillerEntity;
import entity.YatzyEntity;

import backend.Yatzy;

/**
 * Servlet implementation class SpillServlet
 */
@WebServlet("/SpillServlet")
public class SpillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private SpillerDAO spillerDao;
	@EJB
	private YatzyDAO yatzyDao;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int yatzyID = (int) request.getSession().getAttribute("yatzyID");
		YatzyEntity yatzy = yatzyDao.finnSpillID(yatzyID);

		// get board
		int[][] brettArray = yatzy.toArray();
		request.setAttribute("brett", brettArray);

		// get players
		List<SpillerEntity> spillere = yatzy.getSpillere();
		request.setAttribute("spillere", spillere);

		// get brettInfo
		Board board = new Board(0);

		String[] rowInfo = board.getRowInfo();
		request.setAttribute("rowInfo", rowInfo);
		
		// show cell playing for
		request.setAttribute("row", yatzy.getRunde());
		request.setAttribute("collum", yatzy.getPlayerTurn());
		
		//Terninger
		int[] terninger = yatzy.getTerningArray();
		request.setAttribute("terninger", terninger);
		
		

		request.getRequestDispatcher("WEB-INF/jsp/spillSpill.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		//game logic
		
		//each time servlet gets a post:
		
		//it needs to check who sendt, and how many times prior
		
		//post contains 5 "boolean" values, dices to lock
		
		//after reciving 2 times, game needs to update value in table
		//and then change playing user
		
		SpillerEntity spiller = (SpillerEntity) request.getSession().getAttribute("spiller");
		int yatzyID = (int) request.getSession().getAttribute("yatzyID");
		YatzyEntity yatzy = yatzyDao.finnSpillID(yatzyID);
		
		//check if correct player sendt inn
		if(!yatzy.getSpillere().get(yatzyDao.finnSpillerTur(yatzyID)).getBrukernavn().equals(spiller.getBrukernavn())) {
			//wrong player sendt inn
			//send error message
			
			response.sendRedirect("SpillServlet");
			return;
		}
		
		//Stopp om spill ikke er aktivt
		if(yatzy.getAktiv() != 1) {
			response.sendRedirect("SpillServlet");
			return;
		}
		
		//get dices
		String[] names = request.getParameterValues("dices");
		
		int[] diceVal;
		
		//when no dices keep, gives null
		if(names == null){
			diceVal = new int[0];
		}else {
			diceVal = new int[names.length];
			for(int i = 0; i < names.length; i++) {
				diceVal[i] = Integer.parseInt(names[i].substring(4))-1;
				System.out.print(diceVal[i] + " ");
			}
		}
		
		
		
		
		//roll dices
		yatzy.setTurnsPlayed(yatzy.getTurnsPlayed()+1);
		yatzy.trillTerning(yatzy.getTerningArray(), diceVal);
		
		if(yatzy.getTurnsPlayed() == 2) {
			//bord value
			Yatzy yatzyGame = new Yatzy(yatzy.toArray());
			yatzyGame.gameLogic(yatzy.getPlayerTurn(), yatzy.getRunde()+1, yatzy.getTerningArray());
			yatzy.toArrayString(yatzyGame.getBoard().getBoard());
			

			
			//update totals
			yatzyGame.getBoard().setValue(yatzy.getPlayerTurn(), 6, RoundUtils.firstSum(yatzy.getPlayerTurn(), yatzyGame.getBoard()));
			yatzyGame.getBoard().setValue(yatzy.getPlayerTurn(), 17, RoundUtils.totalSum(yatzy.getPlayerTurn(), yatzyGame.getBoard()));
			yatzy.toArrayString(yatzyGame.getBoard().getBoard());
			//player turn
			yatzy.setTurnsPlayed(0);
			yatzy.setPlayerTurn(yatzy.getPlayerTurn() + 1);
			
			if(yatzy.getPlayerTurn() == yatzy.getAntall()) {
				yatzy.setPlayerTurn(0);
				//skip sum and bonus
				if(yatzy.getRunde() == 5) {
					//set bonus val
					yatzyGame.getBoard().setValue(yatzy.getPlayerTurn(), 7, RoundUtils.bonus(RoundUtils.firstSum(yatzy.getPlayerTurn(), yatzyGame.getBoard())));
					yatzy.setRunde(8);
				}else {
					yatzy.setRunde(yatzy.getRunde()+1);
				}

			}
			
			
			//reset dice
			diceVal = new int[0];
			yatzy.trillTerning(yatzy.getTerningArray(), diceVal);
			
			// stopp p?? runde 18
			if(yatzy.getRunde() >= 17) {
				yatzy.setAktiv(0);
			}
		}
		
		
		yatzyDao.update(yatzy);
		
		
		
		response.sendRedirect("SpillServlet");
	}

}
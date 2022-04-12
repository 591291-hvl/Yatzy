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
		
		//Terninger
		int[] terninger = {1,2,3,4,5};
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
		
		String[] names = request.getParameterValues("dices");
		
		int[] diceVal = new int[names.length];
		for(int i = 0; i < names.length; i++) {
			diceVal[i] = Integer.parseInt(names[i].substring(4));
			System.out.print(diceVal[i] + " ");
		}
		
		response.sendRedirect("SpillServlet");
	}

}

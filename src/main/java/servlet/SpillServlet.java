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
import entity.Spiller;
import entity.Yatzy;

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
		Yatzy yatzy = yatzyDao.finnSpillID(yatzyID);

		// get board
		int[][] brettArray = yatzy.toArray();
		request.setAttribute("brett", brettArray);

		// get players
		List<Spiller> spillere = yatzy.getSpillere();
		request.setAttribute("spillere", spillere);

		// get brettInfo
		Board board = new Board(0);

		String[] rowInfo = board.getRowInfo();
		request.setAttribute("rowInfo", rowInfo);

		request.getRequestDispatcher("WEB-INF/jsp/spillSpill.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.sendRedirect("SpillServlet");
	}

}

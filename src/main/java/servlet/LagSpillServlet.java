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

@WebServlet(name = "LagSpillServlet", urlPatterns = "/LagSpillServlet")
public class LagSpillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private SpillerDAO spillerDao;
	@EJB
	private YatzyDAO yatzyDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		//get yatzy game code(id)
		int yatzyID = (int) request.getSession().getAttribute("yatzyID");
		Yatzy yatzy = yatzyDao.finnSpillID(yatzyID);
		
		
		List<Spiller> spillere =  yatzy.getSpillere();
		
		request.setAttribute("yatzyID", yatzy.getId());

		request.setAttribute("spillere", spillere);
		
		for (Spiller s : spillere) {
			System.out.println(s.toString());
		}
		
		request.getRequestDispatcher("WEB-INF/jsp/lagSpill.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.sendRedirect("LagSpillServlet");

	}
}

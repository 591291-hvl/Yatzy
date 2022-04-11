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
import entity.SpillerEntity;
import entity.YatzyEntity;

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
		YatzyEntity yatzy = yatzyDao.finnSpillID(yatzyID);
		
		//game is started, send others to game page
		if(yatzy.getAktiv() == 1) {
			response.sendRedirect("SpillServlet");
			return;
		}
		
		
		List<SpillerEntity> spillere =  yatzy.getSpillere();
		
		request.setAttribute("yatzyID", yatzy.getId());

		request.setAttribute("spillere", spillere);
		
		for (SpillerEntity s : spillere) {
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
		
		
		//user starts game
		int yatzyID = (int) request.getSession().getAttribute("yatzyID");
		YatzyEntity yatzy = yatzyDao.finnSpillID(yatzyID);
		
		yatzy.startSpill();
		
		yatzyDao.update(yatzy);
		
		//error message
//		if(false) {
//			
//			response.sendRedirect("LagSpillServlet");
//			return;
//			
//		}
		
		//send ny page
		response.sendRedirect("SpillServlet");
		
		

	}
}

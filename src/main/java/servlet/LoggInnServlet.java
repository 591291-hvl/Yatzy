package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SpillerDAO;
import entity.Spiller;
import password.PassordUtil;


@WebServlet(name = "LoggInnServlet", urlPatterns = "/LoggInnServlet")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private SpillerDAO spillerDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/logginn.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Henter brukernavn og passord fra loggin siden
		String brukernavn = request.getParameter("brukernavn");
		String passord = request.getParameter("passord");

		// Henter spiller med oppgitt mobilnr
		Spiller spiller = spillerDao.finnMedBrukernavn(brukernavn);

		// Deltager finnes i databasen
		if (spiller != null) {

			String hash = spiller.getPassord().getHash();
			String salt = spiller.getPassord().getSalt();

			// Passord er riktig
			if (PassordUtil.validerMedSalt(passord, salt, hash)) {

				// Lager ny sesjon og setter deltager som atributt
				HttpSession sesjon = request.getSession(true);
				sesjon.setAttribute("spiller", spiller);

				// Sender den ferdig innloggede spilleren videre til å velge yatzy spill
				response.sendRedirect("LandingsSideServlet");

			} else { // Passord er feil

				response.sendRedirect("LoggInnServlet");

			}

		} else { // Deltager finnes ikke i databasen

			response.sendRedirect("LoggInnServlet");

		}

	}

}
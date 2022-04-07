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
import servletUtil.SpillerForm;


/**
 * Servlet implementation class RegistrerServlet
 */
@WebServlet(name = "RegistrerServlet", urlPatterns = "/RegistrerServlet")
public class RegistrerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private SpillerDAO spillerDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/registreringsskjema.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Lager spillerForm objekt (hjelpeklasse) og fyller inn med opplysningene
		// opgitt i skjemaet på nettsiden
		SpillerForm spillerForm = new SpillerForm();
		spillerForm.populerFraRequestOgSettOppEvtFeilmeldinger(request, spillerDao);

		// Ser om det opgitte brukernavnet er registrert
		boolean erRegistrert = spillerDao.erRegistrert(spillerForm.getBrukernavn());

		// Skjekker at alle feltene er gyldig, og at det opgitte brukernavnet er ledig
		if (spillerForm.isAlleGyldig() && !erRegistrert) {

			// Lager en spiller fra opplysningene i skjemaet
			Spiller spiller = spillerForm.lagSpillerFraForm();

			// Lager en session
			HttpSession sesjon = request.getSession(true);

			// Setter deltager objektet som atributt i sesjonen
			sesjon.setAttribute("spiller", spiller);

			// Lagrer spiller i databasen
			spillerDao.lagre(spiller);

			// Sende videre til spillerlisten
			response.sendRedirect("LandingsSideServlet");

			// Bruker eksisterer allerede i databasen
		} else if (erRegistrert) {

			// Sender til innloggings siden
			response.sendRedirect("LoggInnServlet");

		} else {

			// Legger spiller form som atributt i sesjonen for å vise evt feilmeldinger
			request.getSession().setAttribute("spillerForm", spillerForm);

			// Laster inn siden på nytt med feilmeldinger
			response.sendRedirect("RegistrerServlet");

		}

	}

}

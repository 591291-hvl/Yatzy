package servlet;

import dao.PersonDAO;
import entity.PersonEntity;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PersonServlet", value = "/PersonServlet")
public class PersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private PersonDAO pDAO;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        // Henter alle deltagerene sortert etter navn
        List<PersonEntity> spillere = pDAO.getAllPersons();

        // Setter deltagerene som atributt i requesten, hentes ut i jsp siden...
        request.setAttribute("spillere", spillere);

        // G� til deltagerlisten
        request.getRequestDispatcher("WEB-INF/jsp/personServlet.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("PersonServlet");
    }
}

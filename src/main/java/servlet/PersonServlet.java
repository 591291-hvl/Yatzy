package servlet;

import dao.PersonDAO;
import entity.PersonEntity;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.ejb.EJB;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PersonServlet", value = "/PersonServlet")
public class PersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @EJB
    private PersonDAO pDAO;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // Henter alle deltagerene sortert etter navn
        List<PersonEntity> spillere = pDAO.getAllPersons();

        // Setter deltagerene som atributt i requesten, hentes ut i jsp siden...
        request.setAttribute("spillere", spillere);

        // G� til deltagerlisten
        request.getRequestDispatcher("WEB-INF/personServlet.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // Henter alle deltagerene sortert etter navn
        List<PersonEntity> spillere = pDAO.getAllPersons();

        // Setter deltagerene som atributt i requesten, hentes ut i jsp siden...
        request.setAttribute("spillere", spillere);

        // G� til deltagerlisten
        request.getRequestDispatcher("WEB-INF/personServlet.jsp").forward(request, response);
    }
}

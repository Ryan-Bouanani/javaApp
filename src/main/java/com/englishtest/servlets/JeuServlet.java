package com.englishtest.servlets;

import com.englishtest.pojos.Joueur;
import com.englishtest.pojos.Partie;
import com.englishtest.pojos.Question;
import com.englishtest.services.GameService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/jeu")
public class JeuServlet extends HttpServlet {
    private final GameService gameService = new GameService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Joueur joueur = (Joueur) session.getAttribute("joueur");

        if (joueur == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        Partie partie = (Partie) session.getAttribute("partie");
        if (partie == null) {
            partie = gameService.creerNouvellePartie(joueur);
            session.setAttribute("partie", partie);
        }

        Question question = gameService.poserNouvelleQuestion(partie);
        if (question == null) {
            response.sendRedirect("fin.jsp");
            return;
        }

        session.setAttribute("question", question);
        request.setAttribute("verbe", question.getVerbe());
        request.getRequestDispatcher("jeu.jsp").forward(request, response);
    }
}
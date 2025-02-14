package com.englishtest.servlets;

import com.englishtest.pojos.Joueur;
import com.englishtest.services.JoueurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
    private final JoueurService joueurService = new JoueurService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Joueur joueur = joueurService.connecterJoueur(email, password);
        if (joueur != null) {
            HttpSession session = request.getSession();
            session.setAttribute("joueur", joueur);
            response.sendRedirect("jeu.jsp");
        } else {
            request.setAttribute("error", "Email ou mot de passe incorrect !");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
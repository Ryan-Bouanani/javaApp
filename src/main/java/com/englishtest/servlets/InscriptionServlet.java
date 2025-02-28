package com.englishtest.servlets;

import com.englishtest.services.JoueurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
    private final JoueurService joueurService = new JoueurService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String password = request.getParameter("password");
        String niveau = request.getParameter("niveau"); // 🔹 Ajout du champ niveau
        int idVille = Integer.parseInt(request.getParameter("idVille"));

        boolean inscrit = joueurService.inscrireJoueur(email, nom, prenom, password, niveau, idVille);

        if (inscrit) {
            response.sendRedirect("login.jsp?success=1");
        } else {
            response.sendRedirect("inscription.jsp?error=1");
        }
    }
}

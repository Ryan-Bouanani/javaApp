package com.englishtest.services;

import com.englishtest.dao.JoueurDAO;
import com.englishtest.dao.VilleDAO;
import com.englishtest.pojos.Joueur;
import com.englishtest.pojos.Ville;

import java.util.Optional;

public class JoueurService {
    private final JoueurDAO joueurDAO = new JoueurDAO();
    private final VilleDAO villeDAO = new VilleDAO();

    public boolean inscrireJoueur(String email, String nom, String prenom, String password, String niveau, int idVille) {
        if (joueurDAO.findByEmail(email).isPresent()) return false;

        Ville ville = villeDAO.findById((long) idVille);
        if (ville == null) return false; // Ville inexistante

        Joueur joueur = new Joueur();
        joueur.setEmail(email);
        joueur.setNom(nom);
        joueur.setPrenom(prenom);
        joueur.setMotDePasse(password);
        joueur.setNiveau(niveau);
        joueur.setVille(ville);

        joueurDAO.save(joueur);
        return true;
    }

    public Joueur connecterJoueur(String email, String password) {
        Optional<Joueur> joueurOpt = joueurDAO.findByEmail(email);
        if (joueurOpt.isPresent() && joueurOpt.get().getMotDePasse().equals(password)) {
            return joueurOpt.get(); // 🔹 Retourne l'objet joueur si les identifiants sont corrects
        }
        return null; // 🔹 Retourne null si l'authentification échoue
    }
}

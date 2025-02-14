package com.englishTest.tests;

import com.englishtest.dao.JoueurDAO;
import com.englishtest.dao.VilleDAO;
import com.englishtest.pojos.Joueur;
import com.englishtest.pojos.Ville;

public class TestDAO {
    public static void main(String[] args) {
        VilleDAO villeDAO = new VilleDAO();
        JoueurDAO joueurDAO = new JoueurDAO();

        // Création d'une ville
        Ville ville = new Ville();
        ville.setNom("Paris");
        villeDAO.save(ville);

        // Création d'un joueur
        Joueur joueur = new Joueur();
        joueur.setNom("Dupont");
        joueur.setPrenom("Jean");
        joueur.setEmail("jean.dupont@example.com");
        joueur.setMotDePasse("password123");
        joueur.setVille(ville);
        joueurDAO.save(joueur);

        // Vérification
        System.out.println("Liste des joueurs : " + joueurDAO.findAll());
    }
}

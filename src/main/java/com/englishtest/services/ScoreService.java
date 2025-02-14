package com.englishtest.services;

import com.englishtest.dao.PartieDAO;
import com.englishtest.pojos.Partie;

import java.util.List;

public class ScoreService {
    private final PartieDAO partieDAO = new PartieDAO();

    /**
     * Récupère toutes les parties d'un joueur donné.
     *
     * @param joueurId Identifiant du joueur
     * @return Liste des parties du joueur
     */
    public List<Partie> getPartiesByJoueur(int joueurId) {
        return partieDAO.findByJoueurId(joueurId);
    }

    /**
     * Calcule le score total d'un joueur sur toutes ses parties.
     *
     * @param joueurId Identifiant du joueur
     * @return Score total du joueur (calculé en mémoire)
     */
    public int calculerScoreTotal(int joueurId) {
        List<Partie> parties = partieDAO.findByJoueurId(joueurId);
        return parties.size() * 10; // Exemple : 10 points par partie
    }
}

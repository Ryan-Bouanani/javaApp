package com.englishtest.services;

import com.englishtest.dao.PartieDAO;
import com.englishtest.dao.QuestionDAO;
import com.englishtest.dao.VerbeDAO;
import com.englishtest.pojos.Joueur;
import com.englishtest.pojos.Partie;
import com.englishtest.pojos.Question;
import com.englishtest.pojos.Verbe;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class GameService {
    private final PartieDAO partieDAO = new PartieDAO();
    private final VerbeDAO verbeDAO = new VerbeDAO();
    private final QuestionDAO questionDAO = new QuestionDAO();
    private final Random random = new Random();

    public Partie creerNouvellePartie(Joueur joueur) {
        Partie partie = new Partie();
        partie.setJoueur(joueur);
        partie.setDateHeure(LocalDateTime.now());
        partieDAO.save(partie);
        return partie;
    }

    public Question poserNouvelleQuestion(Partie partie) {
        List<Verbe> verbes = verbeDAO.findAll();
        if (verbes.isEmpty()) return null;

        Verbe verbeChoisi = verbes.get(random.nextInt(verbes.size()));

        Question question = new Question();
        question.setPartie(partie);
        question.setVerbe(verbeChoisi);
        questionDAO.save(question);

        return question;
    }

    public boolean verifierReponse(Partie partie, Question question, String reponsePreterit, String reponseParticipePasse) {
        return question.getVerbe().getPreterit().equalsIgnoreCase(reponsePreterit)
                && question.getVerbe().getParticipePasse().equalsIgnoreCase(reponseParticipePasse);
    }
}

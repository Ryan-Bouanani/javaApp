package com.englishtest.dao;

import com.englishtest.pojos.Partie;
import com.englishtest.utilities.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class PartieDAO extends GenericDAO<Partie> {
    public PartieDAO() {
        super(Partie.class);
    }

    // Liste toutes les parties d'un joueur
    public List<Partie> findByJoueurId(int joueurId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Partie p WHERE p.joueur.id = :joueurId", Partie.class)
                    .setParameter("joueurId", joueurId)
                    .list();
        }
    }
}

package com.englishtest.dao;

import com.englishtest.pojos.Joueur;
import com.englishtest.utilities.HibernateUtil;
import org.hibernate.Session;
import java.util.Optional;

public class JoueurDAO extends GenericDAO<Joueur> {
    public JoueurDAO() {
        super(Joueur.class);
    }

    public Optional<Joueur> findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.createQuery(
                    "FROM Joueur j JOIN FETCH j.ville WHERE j.email = :email", Joueur.class)
                    .setParameter("email", email)
                    .uniqueResult());
        }
    }
}

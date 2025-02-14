package com.englishTest.tests;

import com.englishtest.utilities.HibernateUtil;
import org.hibernate.Session;

public class TestEntities {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Les entités JPA sont bien configurées !");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la connexion avec Hibernate.");
        }
    }
}

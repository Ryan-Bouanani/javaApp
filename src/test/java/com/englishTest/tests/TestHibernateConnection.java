package com.englishTest.tests;

import com.englishtest.utilities.HibernateUtil;
import org.hibernate.Session;

public class TestHibernateConnection {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Connexion à la base SQLite réussie !");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }
}

package com.englishtest.dao;

import com.englishtest.pojos.Question;
import com.englishtest.utilities.HibernateUtil;
import org.hibernate.Session;

public class QuestionDAO extends GenericDAO<Question> {
    public QuestionDAO() {
        super(Question.class);
    }

    // Suppression de `marquerReponseCorrecte` car il n'y a pas de champ correcte
}

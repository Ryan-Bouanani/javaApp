package com.englishtest.pojos;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idPartie", nullable = false)
    private Partie partie;

    @ManyToOne
    @JoinColumn(name = "idVerbe", nullable = false)
    private Verbe verbe;

    @Column(nullable = false, length = 100)
    private String reponsePreterit;

    @Column(nullable = false, length = 100)
    private String reponseParticipePasse;

    @Column(nullable = false)
    private Timestamp dateEnvoi;

    @Column
    private Timestamp dateReponse;

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Partie getPartie() { return partie; }
    public void setPartie(Partie partie) { this.partie = partie; }

    public Verbe getVerbe() { return verbe; }
    public void setVerbe(Verbe verbe) { this.verbe = verbe; }

    public String getReponsePreterit() { return reponsePreterit; }
    public void setReponsePreterit(String reponsePreterit) { this.reponsePreterit = reponsePreterit; }

    public String getReponseParticipePasse() { return reponseParticipePasse; }
    public void setReponseParticipePasse(String reponseParticipePasse) { this.reponseParticipePasse = reponseParticipePasse; }

    public Timestamp getDateEnvoi() { return dateEnvoi; }
    public void setDateEnvoi(Timestamp dateEnvoi) { this.dateEnvoi = dateEnvoi; }

    public Timestamp getDateReponse() { return dateReponse; }
    public void setDateReponse(Timestamp dateReponse) { this.dateReponse = dateReponse; }
}

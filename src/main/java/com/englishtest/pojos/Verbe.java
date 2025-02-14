package com.englishtest.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "verbe")
public class Verbe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String baseVerbale;

    @Column(nullable = false, length = 100)
    private String preterit;

    @Column(nullable = false, length = 100)
    private String participePasse;

    @Column(nullable = false, length = 100)
    private String traduction;

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getBaseVerbale() { return baseVerbale; }
    public void setBaseVerbale(String baseVerbale) { this.baseVerbale = baseVerbale; }

    public String getPreterit() { return preterit; }
    public void setPreterit(String preterit) { this.preterit = preterit; }

    public String getParticipePasse() { return participePasse; }
    public void setParticipePasse(String participePasse) { this.participePasse = participePasse; }

    public String getTraduction() { return traduction; }
    public void setTraduction(String traduction) { this.traduction = traduction; }
}

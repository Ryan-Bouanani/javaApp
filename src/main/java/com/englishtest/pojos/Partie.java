package com.englishtest.pojos;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "partie")
public class Partie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idJoueur", nullable = false)
    private Joueur joueur;

    @Transient // Cette variable ne sera pas stockée en base
    private int score = 0;

    @Column(nullable = false)
    private LocalDateTime dateHeure;

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Joueur getJoueur() { return joueur; }
    public void setJoueur(Joueur joueur) { this.joueur = joueur; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public LocalDateTime getDateHeure() { return dateHeure; }
    public void setDateHeure(LocalDateTime dateHeure) { this.dateHeure = dateHeure; }
}

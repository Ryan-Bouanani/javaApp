package com.englishtest.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "ville")
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 10)
    private String cp;

    @Column(nullable = false, length = 100)
    private String nom;

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCp() { return cp; }
    public void setCp(String cp) { this.cp = cp; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}

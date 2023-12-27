package com.example.phase1.model;

public class Modules {
    private Integer id;
    private String intitule;
    private Filiere filiere;
    private Enseignant professeur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Enseignant getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Enseignant professeur) {
        this.professeur = professeur;
    }

    public Modules(String intitule, Filiere filiere, Enseignant professeur) {
        this.intitule = intitule;
        this.filiere = filiere;
        this.professeur = professeur;
    }
}

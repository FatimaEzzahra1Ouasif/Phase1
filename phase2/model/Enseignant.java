package com.example.phase1.model;

public class Enseignant {
    private Integer id;
    private String nom, prenom, email, grade;
    private Departement departement;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Enseignant() {
    }

    public Enseignant(String nom, String prenom, String email, String grade, Departement departement) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.grade = grade;
        this.departement = departement;
    }
}

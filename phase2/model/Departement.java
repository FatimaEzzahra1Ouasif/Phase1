package com.example.phase1.model;

public class Departement {
    private Integer id;
    private String intitule;
    private Enseignant responsable;

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

    public Enseignant getResponsable() {
        return responsable;
    }

    public void setResponsable(Enseignant responsable) {
        this.responsable = responsable;
    }

    public Departement() {
    }

    public Departement(String intitule) {
        this.intitule = intitule;
    }

    public Departement(String intitule, Enseignant responsable) {
        this.intitule = intitule;
        this.responsable = responsable;
    }
}

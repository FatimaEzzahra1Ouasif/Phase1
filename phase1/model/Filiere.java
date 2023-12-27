package com.example.phase1.model;

public class Filiere {
    private Integer id;
    private String intitule;
    private Enseignant responsable;
    private Departement departement;

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

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Filiere(String intitule, Enseignant responsable, Departement departement) {
        this.intitule = intitule;
        this.responsable = responsable;
        this.departement = departement;
    }


}

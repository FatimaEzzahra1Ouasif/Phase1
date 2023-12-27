package com.example.phase1.services;

import com.example.phase1.model.Etudiant;

import java.util.ArrayList;
import java.util.List;

public class EtudiantService implements EtudiantInterface{
    private static List<Etudiant> etudiants = new ArrayList<>();

    public EtudiantService(List<Etudiant> etudiants) {
    }


    @Override
    public void afficherInformations() {
        for (Etudiant etudiant : etudiants) {
            System.out.println("Nom: " + etudiant.getNom());
            System.out.println("Prénom: " + etudiant.getPrenom());
            System.out.println("Email: " + etudiant.getEmail());
            System.out.println("Apogée: " + etudiant.getApogee());
            System.out.println("Filière: " + etudiant.getFiliere().getIntitule());
            System.out.println("---------------");
        }
    }

    @Override
    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        System.out.println("Étudiant ajouté avec succès.");
    }

    @Override
    public void supprimerEtudiant(Etudiant etudiant) {
        etudiants.remove(etudiant);
        System.out.println("Étudiant supprimé avec succès.");
    }

    @Override
    public void modifierEtudiant(Etudiant etudiant, String nom, String prenom, String email, int apogee) {
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setEmail(email);
        etudiant.setApogee(apogee);
        System.out.println("Informations de l'étudiant modifiées avec succès.");
    }
}

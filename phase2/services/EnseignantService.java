package com.example.phase1.services;

import com.example.phase1.model.Enseignant;

import java.util.ArrayList;
import java.util.List;

public class EnseignantService implements EnseignantInterface {
    private static List<Enseignant> enseignants = new ArrayList<>();
    public EnseignantService(List<Enseignant> enseignants) {}
    public Enseignant rechercherEnseignantParNom(String nom) {
        for (Enseignant enseignant : enseignants) {
            if (enseignant.getNom().equals(nom)) {
                return enseignant;
            }
        }
        return null;
    }
    public void supprimerEnseignant(String nomASupprimer) {
        Enseignant enseignantASupprimer = rechercherEnseignantParNom(nomASupprimer);
        if (enseignantASupprimer != null) {
            enseignants.remove(enseignantASupprimer);
            System.out.println("Enseignant supprimé avec succès.");
        } else {
            System.out.println("Enseignant non trouvé avec le nom : " + nomASupprimer);
        }
    }
    @Override
    public void afficherInformations() {
        for (Enseignant enseignant : enseignants) {
            System.out.println("Nom de l'enseignant: " + enseignant.getNom());
            System.out.println("Prénom de l'enseignant: " + enseignant.getPrenom());
            System.out.println("Email de l'enseignant: " + enseignant.getEmail());
            System.out.println("Grade de l'enseignant: " + enseignant.getGrade());
            System.out.println("Département de l'enseignant: " + enseignant.getDepartement().getIntitule());
            System.out.println("---------------");
        }
    }

    public void ajouterEnseignant(Enseignant enseignant) {
        enseignants.add(enseignant);
        System.out.println("Enseignant ajouté avec succès.");
    }

    public void modifierEnseignant(Enseignant enseignant, String email, String grade) {
        enseignant.setEmail(email);
        enseignant.setGrade(grade);
        System.out.println("Informations de l'enseignant modifiées avec succès.");
    }
@Override
    public Enseignant searchEnseignantByName(String name) {
        for (Enseignant enseignant : enseignants) {
            if (enseignant.getNom().equalsIgnoreCase(name)) {
                return enseignant;
            }
        }
        return null;
    }

}

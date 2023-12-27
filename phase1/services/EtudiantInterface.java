package com.example.phase1.services;

import com.example.phase1.model.*;

public interface EtudiantInterface {
    void afficherInformations();
    void ajouterEtudiant(Etudiant etudiant);
    void supprimerEtudiant(Etudiant etudiant);
    void modifierEtudiant(Etudiant etudiant, String nom, String prenom, String email, int apogee);

}

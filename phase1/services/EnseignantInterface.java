package com.example.phase1.services;

import com.example.phase1.model.Enseignant;

public interface EnseignantInterface {

    Enseignant  searchEnseignantByName(String nom);
    void afficherInformations();
    void supprimerEnseignant(String nomASupprimer);
     void ajouterEnseignant(Enseignant enseignant);
    void modifierEnseignant(Enseignant enseignant, String email, String grade) ;




    }

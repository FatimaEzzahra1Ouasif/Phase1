package com.example.phase1.services;

import com.example.phase1.model.*;

public interface FiliereInterface {
    void supprimerFiliere(String nomFiliereASupprimer);
    void afficherListeFilieres();
    void ajouterFiliere(Filiere filiere);
    void ajouterModule(Modules module);
    void supprimerModule(Modules module);
    void modifierResponsable(Enseignant responsable);
}

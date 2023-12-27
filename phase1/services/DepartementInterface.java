package com.example.phase1.services;

import com.example.phase1.model.*;

public interface DepartementInterface {
    void afficherInformations();
     void ajouterDepartement(Departement departement) ;
    void modifierResponsable(String intitule, Enseignant nouveauResponsable);
    void supprimerDepartement(String intitule);




}

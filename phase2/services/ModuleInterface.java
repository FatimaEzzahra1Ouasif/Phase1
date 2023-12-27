package com.example.phase1.services;

import com.example.phase1.model.Modules;

public interface ModuleInterface {
    void afficherInformations();
    void ajouterModule(Modules module) ;
    void supprimerModule(Modules module);
    void modifierModule(Modules module, String intitule);


}

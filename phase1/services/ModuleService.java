package com.example.phase1.services;

import com.example.phase1.model.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleService implements ModuleInterface {
    private static List<Modules> modules = new ArrayList<>();
    @Override
    public void afficherInformations() {
        for (Modules module : modules) {
            System.out.println("Intitulé du module: " + module.getIntitule());
            System.out.println("Filière du module: " + module.getFiliere().getIntitule());
            System.out.println("Professeur du module: " + module.getProfesseur().getNom() + " " + module.getProfesseur().getPrenom());
            System.out.println("---------------");
        }
    }

    public void ajouterModule(Modules module) {
        modules.add(module);
        System.out.println("Module ajouté avec succès.");
    }

    public void supprimerModule(Modules module) {
        modules.remove(module);
        System.out.println("Module supprimé avec succès.");
    }

    public void modifierModule(Modules module, String intitule) {
        module.setIntitule(intitule);
        System.out.println("Informations du module modifiées avec succès.");
    }
}

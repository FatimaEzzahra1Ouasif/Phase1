package com.example.phase1.services;

import com.example.phase1.model.Enseignant;
import com.example.phase1.model.Filiere;
import com.example.phase1.model.Modules;

import java.util.List;

public class FiliereService implements FiliereInterface {
    private Enseignant responsable;
    private List<Modules> modules;
    private List<Filiere> filieres;

    public FiliereService(Enseignant responsable, List<Modules> modules) {
        this.responsable = responsable;
        this.modules = modules;
    }

    public FiliereService(List<Filiere> filieres) {
    }
    @Override
    public void ajouterFiliere(Filiere filiere) {
        filieres.add(filiere);
        System.out.println("Filière ajoutée avec succès.");
    }

    @Override
    public void supprimerFiliere(String nomFiliereASupprimer) {
        Filiere filiereASupprimer = rechercherFiliereParNom(nomFiliereASupprimer);
        if (filiereASupprimer != null) {
            filieres.remove(filiereASupprimer);
            System.out.println("Filière supprimée avec succès.");
        } else {
            System.out.println("Aucune filière trouvée avec le nom : " + nomFiliereASupprimer);
        }
    }

    @Override
    public void afficherListeFilieres() {
        if (filieres.isEmpty()) {
            System.out.println("Aucune filière disponible.");
        } else {
            System.out.println("Liste des filières : ");
            for (Filiere filiere : filieres) {
                System.out.println("Intitulé : " + filiere.getIntitule());
                System.out.println("Responsable : " + filiere.getResponsable().getNom() + " " + filiere.getResponsable().getPrenom());
                System.out.println("Département : " + filiere.getDepartement().getIntitule());
                System.out.println("-----");
            }
        }
    }

    private Filiere rechercherFiliereParNom(String nomFiliere) {
        for (Filiere filiere : filieres) {
            if (filiere.getIntitule().equalsIgnoreCase(nomFiliere)) {
                return filiere;
            }
        }
        return null;
    }

    @Override
    public void ajouterModule(Modules module) {
        modules.add(module);
        System.out.println("Module ajouté avec succès à la filière.");
    }

    @Override
    public void supprimerModule(Modules module) {
        modules.remove(module);
        System.out.println("Module supprimé avec succès de la filière.");
    }

    @Override
    public void modifierResponsable(Enseignant responsable) {
        this.responsable = responsable;
        System.out.println("Responsable de la filière modifié avec succès.");
    }
}

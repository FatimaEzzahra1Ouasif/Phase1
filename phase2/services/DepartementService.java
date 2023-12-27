package com.example.phase1.services;
import com.example.phase1.model.Departement;
import com.example.phase1.model.Enseignant;
import java.util.List;

public class DepartementService implements DepartementInterface {
    private final List<Departement> departements;
    public DepartementService(List<Departement> departements) {
        this.departements = departements;
    }

    @Override
    public void afficherInformations() {
        for (Departement departement : departements) {
            System.out.println("Intitulé du département : " + departement.getIntitule());
            System.out.println("Responsable du département : " +
                    departement.getResponsable().getNom() + " " +
                    departement.getResponsable().getPrenom());
            System.out.println("-----");
        }
    }

    public void ajouterDepartement(Departement departement) {
        departements.add(departement);
        System.out.println("Département ajouté avec succès.");
    }

    public void modifierResponsable(String intitule, Enseignant nouveauResponsable) {
        for (Departement departement : departements) {
            if (departement.getIntitule().equalsIgnoreCase(intitule)) {
                departement.setResponsable(nouveauResponsable);
                System.out.println("Responsable du département modifié avec succès.");
                return;
            }
        }
        System.out.println("Aucun département trouvé avec l'intitulé fourni.");
    }

    public void supprimerDepartement(String intitule) {
        Departement departementASupprimer = null;
        for (Departement departement : departements) {
            if (departement.getIntitule().equalsIgnoreCase(intitule)) {
                departementASupprimer = departement;
                break;
            }
        }

        if (departementASupprimer != null) {
            departements.remove(departementASupprimer);
            System.out.println("Département supprimé avec succès.");
        } else {
            System.out.println("Aucun département trouvé avec l'intitulé fourni.");
        }
    }
}

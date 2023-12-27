package com.example.phase1;
import com.example.phase1.services.EnseignantService;
import com.example.phase1.services.EtudiantService;
import com.example.phase1.services.FiliereService;
import com.example.phase1.services.DepartementService;
import com.example.phase1.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProgramme {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Departement> departements = new ArrayList<>();
        List<Enseignant> enseignants = new ArrayList<>();
        List<Filiere> filieres = new ArrayList<>();
        List<Module> modules = new ArrayList<>();
        List<Etudiant> etudiants = new ArrayList<>();

        DepartementService departementService = new DepartementService(departements);
        EnseignantService enseignantService = new EnseignantService(enseignants);
        FiliereService filiereService = new FiliereService(filieres);
        EtudiantService etudiantService = new EtudiantService(etudiants);

        int choix;

        do {
            System.out.println("Menu:");
            System.out.println("1. Gérer les départements");
            System.out.println("2. Gérer les enseignants");
            System.out.println("3. Gérer les étudiants");
            System.out.println("4. Gérer les filières");
            System.out.println("5. Quitter");

            System.out.print("Choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    gererDepartements(scanner, departementService);
                    break;
                case 2:
                    gererEnseignants(scanner, enseignantService);
                    break;
                case 3:
                    gererEtudiants(scanner, etudiantService);
                    break;
                case 4:
                    gererFilieres(scanner, filiereService);
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        } while (choix != 5);

        scanner.close();
    }

    private static void gererDepartements(Scanner scanner, DepartementService departementService) {
        System.out.println("1. Ajouter un département");
        System.out.println("2. Supprimer un département");
        System.out.println("3. Modifier les informations d'un département");
        System.out.println("4. Afficher la liste des départements");
        System.out.print("Choix : ");
        int choixDepartement = scanner.nextInt();
        scanner.nextLine();
        switch (choixDepartement) {
            case 1:
                System.out.println("Ajout d'un département : ");
                System.out.print("Intitulé du département : ");
                String depIntitule = scanner.nextLine();

                System.out.println("Création du responsable du département : ");
                System.out.print("Nom du responsable : ");
                String ensNom = scanner.nextLine();
                System.out.print("Prénom du responsable : ");
                String ensPrenom = scanner.nextLine();
                System.out.print("Email du responsable : ");
                String ensEmail = scanner.nextLine();
                System.out.print("Grade du responsable : ");
                String ensGrade = scanner.nextLine();

                Enseignant responsableDepartement = new Enseignant(ensNom, ensPrenom, ensEmail, ensGrade, null);
                Departement departement = new Departement(depIntitule, responsableDepartement);
                responsableDepartement.setDepartement(departement);
                departementService.ajouterDepartement(departement);
                break;

            case 2:
                System.out.print("Intitulé du département à supprimer : ");
                String intituleASupprimer = scanner.nextLine();
                departementService.supprimerDepartement(intituleASupprimer);
                break;

            case 3:
                System.out.print("Intitulé du département à modifier : ");
                String intituleAModifier = scanner.nextLine();

                System.out.println("Nouvel intitulé du département : ");
                String nouveauIntitule = scanner.nextLine();

                System.out.println("Nouveau responsable du département : ");
                System.out.print("Nom du responsable : ");
                String nouveauEnsNom = scanner.nextLine();
                System.out.print("Prénom du responsable : ");
                String nouveauEnsPrenom = scanner.nextLine();
                System.out.print("Email du responsable : ");
                String nouveauEnsEmail = scanner.nextLine();
                System.out.print("Grade du responsable : ");
                String nouveauEnsGrade = scanner.nextLine();

                Enseignant nouveauResponsable = new Enseignant(nouveauEnsNom, nouveauEnsPrenom, nouveauEnsEmail, nouveauEnsGrade, null);
                departementService.modifierResponsable(intituleAModifier, nouveauResponsable);
                break;

            case 4:
                departementService.afficherInformations();
                break;

            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }
    }

    private static void gererEnseignants(Scanner scanner, EnseignantService enseignantService) {
        System.out.println("1. Ajouter un enseignant");
        System.out.println("2. Supprimer un enseignant");
        System.out.println("3. Modifier les informations d'un enseignant");
        System.out.println("4. Afficher la liste des enseignants");
        System.out.print("Choix : ");
        int choixEnseignant = scanner.nextInt();
        scanner.nextLine();

        switch (choixEnseignant) {
            case 1:
                System.out.println("Ajout d'un enseignant : ");
                System.out.print("Nom de l'enseignant : ");
                String nomAjouter = scanner.nextLine();
                System.out.print("Prénom de l'enseignant : ");
                String prenomAjouter = scanner.nextLine();
                System.out.print("Email de l'enseignant : ");
                String emailAjouter = scanner.nextLine();
                System.out.print("Grade de l'enseignant : ");
                String gradeAjouter = scanner.nextLine();

                Enseignant nouvelEnseignant = new Enseignant(nomAjouter, prenomAjouter, emailAjouter, gradeAjouter, null);
                enseignantService.ajouterEnseignant(nouvelEnseignant);
                break;

            case 2:
                System.out.print("Nom de l'enseignant à supprimer : ");
                String nomASupprimer = scanner.nextLine();
                enseignantService.supprimerEnseignant(nomASupprimer);
                break;
            case 3:
                System.out.print("Nom de l'enseignant à modifier : ");
                String nomAModifier = scanner.next();

                System.out.print("Nouveau nom : ");
                String nouveauNom = scanner.next();

                System.out.print("Nouveau prénom : ");
                String nouveauPrenom = scanner.next();

                System.out.print("Nouvel email : ");
                String nouvelEmail = scanner.next();

                System.out.print("Nouveau grade : ");
                String nouveauGrade = scanner.next();

                Enseignant enseignantAModifier = enseignantService.searchEnseignantByName(nomAModifier);
                if (enseignantAModifier != null) {
                    Enseignant enseignantModifie = new Enseignant(nouveauNom, nouveauPrenom, nouvelEmail, nouveauGrade, null);
                    enseignantService.modifierEnseignant(enseignantAModifier, nouvelEmail, nouveauGrade);
                } else {
                    System.out.println("Aucun enseignant trouvé avec le nom fourni.");
                }
                break;


            case 4:
                enseignantService.afficherInformations();
                break;

            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }
    }


    private static void gererEtudiants(Scanner scanner, EtudiantService etudiantService) {
        System.out.println("1. Ajouter un étudiant");
        System.out.println("2. Supprimer un étudiant");
        System.out.println("3. Modifier les informations d'un étudiant");
        System.out.println("4. Afficher la liste des étudiants");
        System.out.print("Choix : ");
        int choixEtudiant = scanner.nextInt();

        switch (choixEtudiant) {
            case 1:
                System.out.println("Ajout d'un étudiant");
                break;
            case 2:
                System.out.print("Nom de l'étudiant à supprimer : ");
                String nomASupprimer = scanner.next();
                break;
            case 3:
                System.out.print("Nom de l'étudiant à modifier : ");
                String nomAModifier = scanner.next();
                break;
            case 4:
                etudiantService.afficherInformations();
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }
    }


    private static void gererFilieres(Scanner scanner, FiliereService filiereService) {
        System.out.println("1. Ajouter une filière");
        System.out.println("2. Supprimer une filière");
        System.out.println("3. Modifier les informations d'une filière");
        System.out.println("4. Afficher la liste des filières");
        System.out.print("Choix : ");
        int choixFiliere = scanner.nextInt();

        switch (choixFiliere) {
            case 1:
                System.out.println("Création d'une nouvelle filière : ");
                System.out.print("Intitulé de la filière : ");
                String nouvelIntitule = scanner.nextLine();

                System.out.println("Création du responsable de la filière : ");
                System.out.print("Nom du responsable : ");
                String nomResponsable = scanner.nextLine();
                System.out.print("Prénom du responsable : ");
                String prenomResponsable = scanner.nextLine();
                System.out.print("Email du responsable : ");
                String emailResponsable = scanner.nextLine();
                System.out.print("Grade du responsable : ");
                String gradeResponsable = scanner.nextLine();

                Enseignant responsableFiliere = new Enseignant(nomResponsable, prenomResponsable, emailResponsable, gradeResponsable, null);
                Filiere nouvelleFiliere = new Filiere(nouvelIntitule, responsableFiliere, null);

                filiereService.ajouterFiliere(nouvelleFiliere);
                break;
            case 2:
                System.out.print("Nom de la filière à supprimer : ");
                String nomFiliereASupprimer = scanner.next();
                filiereService.supprimerFiliere(nomFiliereASupprimer);
                break;
            case 3:
                break;
            case 4:
                filiereService.afficherListeFilieres();
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }
    }
}

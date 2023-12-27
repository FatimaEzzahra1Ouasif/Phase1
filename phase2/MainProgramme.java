package com.example.phase1;

import com.example.phase1.dao.*;
import com.example.phase1.model.*;
import java.sql.Connection;
import java.util.List;

public class MainProgramme {
    public static void main(String[] args) {
        // Ce block du code est pour tester les fonction du la  class DepartmentDao

        // ce code et pour Établir une connexion avec la base de données
        Connection connection = MaConnection.getConnection();
        //  pour Initialiser la Classe DepartementDao
        DepartementDao departementDao = new DepartementDao();

        Departement departement = new Departement("Informatique");
        departementDao.addDepartement(departement);

        //supprimer le departement qui contient id = 1
        departementDao.deleteDepartement(1);

        int departementIdToSearch = 3;
        Departement searchedDepartement = departementDao.searchDepartementById(departementIdToSearch);

        if (searchedDepartement != null) {
            System.out.println("Departement found:");
            System.out.println("ID: " + searchedDepartement.getId());
            System.out.println("Intitule: " + searchedDepartement.getIntitule());
        } else {
            System.out.println("Aucun département trouvé avec l'ID fourni.");
        }
        // modifier un Departement qui contient ID = 3 ;
        int ID = 3;
        departement.setIntitule("Nouveau département");
        departement.setId(ID);
        departementDao.updateDepartement(departement);

        //fin















        // Fermer la connexion à la base de données
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

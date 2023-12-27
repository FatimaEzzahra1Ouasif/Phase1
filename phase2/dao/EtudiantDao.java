package com.example.phase1.dao;
import com.example.phase1.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDao {
    private Connection connection;
    private EnseignantDao enseignantDao;
    private DepartementDao departementDao;

    public Filiere getFiliereById(int id) {
        String query = "SELECT * FROM filiere WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String intitule = resultSet.getString("intitule");
                    int enseignantId = resultSet.getInt("enseignant_id");
                    int departementId = resultSet.getInt("departement_id");
                    Enseignant enseignant = enseignantDao.getEnseignantById(enseignantId);
                    Departement departement = departementDao.getDepartementById(departementId);
                    return new Filiere(id, intitule, enseignant, departement);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void addEtudiant(Etudiant etudiant) {
        String query = "INSERT INTO etudiant (nom, prenom, email, apogee, filiere_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getEmail());
            preparedStatement.setInt(4, etudiant.getApogee());
            preparedStatement.setInt(5, etudiant.getFiliere().getId());

            preparedStatement.executeUpdate();
            System.out.println("Étudiant ajouté avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEtudiant(int id) {
        String query = "DELETE FROM etudiant WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Étudiant supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEtudiant(Etudiant etudiant) {
        String query = "UPDATE etudiant SET nom = ?, prenom = ?, email = ?, apogee = ?, filiere_id = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getEmail());
            preparedStatement.setInt(4, etudiant.getApogee());
            preparedStatement.setInt(5, etudiant.getFiliere().getId());
            preparedStatement.setInt(6, etudiant.getId());
            preparedStatement.executeUpdate();
            System.out.println("Informations de l'étudiant modifiées avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Etudiant> getAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();
        String query = "SELECT * FROM etudiant";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                int apogee = resultSet.getInt("apogee");
                int filiereId = resultSet.getInt("filiere_id");

                Filiere filiere = getFiliereById(filiereId);

                Etudiant etudiant = new Etudiant(id, nom, prenom, email, apogee, filiere);
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etudiants;
    }

}

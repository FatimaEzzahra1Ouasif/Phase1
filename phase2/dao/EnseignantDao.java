package com.example.phase1.dao;

import com.example.phase1.model.Enseignant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EnseignantDao {
    private Connection connection;

    public EnseignantDao() {
        this.connection = MaConnection.getConnection();
    }
    public Enseignant getEnseignantById(int id) {
        String query = "SELECT * FROM enseignant WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Replace "column_name" with the actual column names in your database
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    String email = resultSet.getString("email");
                    String grade = resultSet.getString("grade");

                    return new Enseignant(nom, prenom, email, grade, null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public void ajouterEnseignant(Enseignant enseignant) {
        String query = "INSERT INTO enseignant (nom, prenom, email, grade, departement_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, enseignant.getNom());
            preparedStatement.setString(2, enseignant.getPrenom());
            preparedStatement.setString(3, enseignant.getEmail());
            preparedStatement.setString(4, enseignant.getGrade());
             // Vérifier si l'ID du département n'est pas null avant de le définir
            if (enseignant.getDepartement() != null && enseignant.getDepartement().getId() != null) {
                preparedStatement.setInt(5, enseignant.getDepartement().getId());
            } else {
                System.out.println("Avertissement : L'ID du département est null pour l'Enseignant.");
            }
            preparedStatement.executeUpdate();
            System.out.println("Enseignant ajouté avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Enseignant> getAllEnseignants() {
        List<Enseignant> enseignants = new ArrayList<>();
        try {
            String query = "SELECT * FROM enseignant";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Enseignant enseignant = new Enseignant();
                    enseignant.setId(resultSet.getInt("id"));
                    enseignant.setNom(resultSet.getString("nom"));
                    enseignant.setPrenom(resultSet.getString("prenom"));
                    enseignant.setEmail(resultSet.getString("email"));
                    enseignant.setGrade(resultSet.getString("grade"));
                    enseignants.add(enseignant);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignants;
    }

    public void updateEnseignant(Enseignant enseignant) {
        try {
            String query = "UPDATE enseignant SET nom=?, prenom=?, email=?, grade=?, departement_id=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, enseignant.getNom());
                preparedStatement.setString(2, enseignant.getPrenom());
                preparedStatement.setString(3, enseignant.getEmail());
                preparedStatement.setString(4, enseignant.getGrade());
                preparedStatement.setInt(5, enseignant.getDepartement().getId());
                preparedStatement.setInt(6, enseignant.getId());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Enseignant mis à jour avec succès.");
                } else {
                    System.out.println("Erreur lors de la mise à jour de l'enseignant.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEnseignant(int enseignantId) {
        try {
            String query = "DELETE FROM enseignant WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, enseignantId);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Enseignant supprimé avec succès.");
                } else {
                    System.out.println("Aucun enseignant trouvé avec l'ID fourni.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Enseignant searchEnseignantById(int enseignantId) {
        try {
            String query = "SELECT * FROM enseignant WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, enseignantId);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Enseignant enseignant = new Enseignant();
                    enseignant.setId(resultSet.getInt("id"));
                    enseignant.setNom(resultSet.getString("nom"));
                    enseignant.setPrenom(resultSet.getString("prenom"));
                    enseignant.setEmail(resultSet.getString("email"));
                    enseignant.setGrade(resultSet.getString("grade"));
                    return enseignant;
                } else {
                    System.out.println("Aucun enseignant trouvé avec l'ID fourni.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }}

package com.example.phase1.dao;
import com.example.phase1.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartementDao {
    private Connection connection;
    public DepartementDao() {
        this.connection = MaConnection.getConnection();
    }

    public Departement getDepartementById(int id) {
        Departement departement = null;
        String query = "SELECT * FROM departement WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String intitule = resultSet.getString("intitule");
                    departement = new Departement(intitule, null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departement;
    }
    public void addDepartement(Departement departement) {
        try {
            String query = "INSERT INTO departement (intitule) VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, departement.getIntitule());
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Département ajouté avec succès.");
                } else {
                    System.out.println("Erreur lors de l'ajout du département.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateDepartement(Departement departement) {
        try {
            String query = "UPDATE departement SET intitule=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, departement.getIntitule());
                preparedStatement.setInt(2, departement.getId());
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Département mis à jour avec succès.");
                } else {
                    System.out.println("Erreur lors de la mise à jour du département.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDepartement(int departementId) {
        try {
            String query = "DELETE FROM departement WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, departementId);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Département supprimé avec succès.");
                } else {
                    System.out.println("Aucun département trouvé avec l'ID fourni.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Departement searchDepartementById(int departementId) {
        try {
            String query = "SELECT * FROM departement WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, departementId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Departement departement = new Departement();
                    departement.setId(resultSet.getInt("id"));
                    departement.setIntitule(resultSet.getString("intitule"));
                    return departement;
                } else {
                    System.out.println("Aucun département trouvé avec l'ID fourni.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

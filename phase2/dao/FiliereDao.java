package com.example.phase1.dao;
import com.example.phase1.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FiliereDao {

    private Connection connection;

    public FiliereDao(Connection connection) {
        this.connection = connection;
    }

    public void createFiliere(Filiere filiere) {
        String query = "INSERT INTO Filiere (intitule, responsable_id, departement_id) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, filiere.getIntitule());
            preparedStatement.setInt(2, filiere.getResponsable().getId());
            preparedStatement.setInt(3, filiere.getDepartement().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Filiere getFiliereById(int filiereId) {
        String query = "SELECT * FROM Filiere WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, filiereId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String intitule = resultSet.getString("intitule");
                    int responsableId = resultSet.getInt("responsable_id");
                    int departementId = resultSet.getInt("departement_id");
                    EnseignantDao enseignantDao = new EnseignantDao();
                    Enseignant responsable = enseignantDao.getEnseignantById(responsableId);
                    DepartementDao departementDao = new DepartementDao();
                    Departement departement = departementDao.getDepartementById(departementId);
                    return new Filiere(id, intitule, responsable, departement);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Filiere> getAllFilieres() {
        List<Filiere> filieres = new ArrayList<>();
        String query = "SELECT * FROM Filiere";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String intitule = resultSet.getString("intitule");
                int responsableId = resultSet.getInt("responsable_id");
                int departementId = resultSet.getInt("departement_id");

                EnseignantDao enseignantDao = new EnseignantDao();
                Enseignant responsable = enseignantDao.getEnseignantById(responsableId);

                DepartementDao departementDao = new DepartementDao();
                Departement departement = departementDao.getDepartementById(departementId);

                filieres.add(new Filiere(id, intitule, responsable, departement));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filieres;
    }

    public void updateFiliere(Filiere filiere) {
        String query = "UPDATE Filiere SET intitule = ?, responsable_id = ?, departement_id = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, filiere.getIntitule());
            preparedStatement.setInt(2, filiere.getResponsable().getId());
            preparedStatement.setInt(3, filiere.getDepartement().getId());
            preparedStatement.setInt(4, filiere.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFiliereById(int filiereId) {
        String query = "DELETE FROM Filiere WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, filiereId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package service;

import config.DataBaseConnectionConfig;

import java.sql.*;

public class CityService {
    public void addCity(int cityId, String cityName) {
        try (Connection conn = DataBaseConnectionConfig.getConnection()) {
            // Проверка уникальности идентификатора города
            String checkCityId = "SELECT id FROM cities WHERE id = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(checkCityId)) {
                pstmt.setInt(1, cityId);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Город с идентификатором " + cityId + " уже существует.");
                    return;
                }
            }


            String checkCityName = "SELECT name FROM cities WHERE name = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(checkCityName)) {
                pstmt.setString(1, cityName);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Город с названием " + cityName + " уже существует.");
                    return;
                }
            }


            String insertCity = "INSERT INTO cities (id, name) VALUES (?, ?);";
            try (PreparedStatement pstmt = conn.prepareStatement(insertCity)) {
                pstmt.setInt(1, cityId);
                pstmt.setString(2, cityName);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void deleteCity(int cityId) {
        try (Connection conn = DataBaseConnectionConfig.getConnection()) {
            String updateStudents = "UPDATE students SET cityid = NULL WHERE cityid = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(updateStudents)) {
                pstmt.setInt(1, cityId);
                pstmt.executeUpdate();
            }

            String deleteCity = "DELETE FROM cities WHERE id = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteCity)) {
                pstmt.setInt(1, cityId);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printCity() {
        try (Connection conn = DataBaseConnectionConfig.getConnection()) {
            String selectCities = "SELECT id, name FROM cities ORDER BY id;";
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(selectCities);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    System.out.println("ID: " + id + ", Name: " + name);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



}

package service;

import config.DataBaseConnectionConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentService {

    public void addStudent(int studentId, String studentName, String cityName) {
        try (Connection conn = DataBaseConnectionConfig.getConnection()) {
            if (studentExists(conn, studentId)) {
                System.out.println("Студент с идентификатором " + studentId + " уже существует.");
                return;
            }

            List<Integer> cityIds = getCityIds(conn, cityName);
            int cityId;
            if (cityIds.isEmpty()) {
                cityId = addNewCity(conn, cityName);
            } else {
                cityId = cityIds.get(0);
            }

            addStudent(conn, studentId, studentName, cityId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean studentExists(Connection conn, int studentId) throws SQLException {
        String checkStudentId = "SELECT id FROM students WHERE id = ?;";
        try (PreparedStatement pstmt = conn.prepareStatement(checkStudentId)) {
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
    }

    public List<Integer> getCityIds(Connection conn, String cityName) throws SQLException {
        List<Integer> cityIds = new ArrayList<>();
        String sql = "SELECT id FROM cities WHERE name = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cityName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                cityIds.add(rs.getInt("id"));
            }
        }
        return cityIds;
    }

    private int addNewCity(Connection conn, String cityName) throws SQLException {
        int maxCityId = 0;
        String selectMaxCityId = "SELECT MAX(id) FROM cities;";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(selectMaxCityId);
            if (rs.next()) {
                maxCityId = rs.getInt(1);
            }
        }

        int newCityId = maxCityId + 1;

        String insertCity = "INSERT INTO cities (id, name) VALUES (?, ?);";
        try (PreparedStatement pstmt = conn.prepareStatement(insertCity)) {
            pstmt.setInt(1, newCityId);
            pstmt.setString(2, cityName);
            pstmt.executeUpdate();
        }

        return newCityId;
    }

    private void addStudent(Connection conn, int studentId, String studentName, int cityId) throws SQLException {
        String insertStudent = "INSERT INTO students (id, name, cityid) VALUES (?, ?, ?);";
        try (PreparedStatement pstmt = conn.prepareStatement(insertStudent)) {
            pstmt.setInt(1, studentId);
            pstmt.setString(2, studentName);
            pstmt.setInt(3, cityId);
            pstmt.executeUpdate();
        }
    }


    public void deleteStudent(int studentId) {
        try (Connection conn = DataBaseConnectionConfig.getConnection()) {
            String deleteStudent = "DELETE FROM students WHERE id = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteStudent)) {
                pstmt.setInt(1, studentId);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printStudents() {
        try (Connection conn = DataBaseConnectionConfig.getConnection()) {
            String selectStudents = "SELECT s.id, s.name, c.name AS city_name FROM students s LEFT JOIN cities c ON s.cityid = c.id ORDER BY s.id;";
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(selectStudents);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String cityName = rs.getString("city_name");
                    System.out.println("ID: " + id + ", Name: " + name + ", City: " + (cityName != null ? cityName : "N/A"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateStudentCity(int studentId, int cityId) {
        try (Connection conn = DataBaseConnectionConfig.getConnection()) {
            String updateStudent = "UPDATE students SET cityid = ? WHERE id = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(updateStudent)) {
                pstmt.setInt(1, cityId);
                pstmt.setInt(2, studentId);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
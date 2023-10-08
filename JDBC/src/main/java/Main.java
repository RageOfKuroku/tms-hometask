import hometask.org.service.CityService;
import hometask.org.service.StudentService;

import java.sql.*;


public class Main {
    public static void main(String[] args) {

        StudentService student = new StudentService();

        CityService city = new CityService();

        city.addCity(8, "Moscow");

        student.addStudent(10,"KirKir", "Prague");

        student.updateStudentCity(9,5);

        student.deleteStudent(3);

        city.deleteCity(7);

        student.printStudents();
        city.printCity();


    }
}

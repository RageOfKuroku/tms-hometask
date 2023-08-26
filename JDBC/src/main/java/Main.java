import service.CityService;
import service.StudentService;

import java.sql.*;


public class Main {
    public static void main(String[] args) {

        StudentService student = new StudentService();

        CityService city = new CityService();

        city.addCity(4, "Vologda");

        student.addStudent(8,"Volodya", "Moscow");

        student.updateStudentCity(4,2);

        student.deleteStudent(3);

        city.deleteCity(3);

        student.printStudents();
        city.printCity();


    }
}

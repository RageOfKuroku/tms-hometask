package hometask.org.service;

import posts.Director;

public class EmployeeSearch {
    public static boolean searchByName(Director sourceDirector, String name) {
        return searchEmployeeByName(sourceDirector, name);
    }

    private static boolean searchEmployeeByName(Employee employee, String name) {
        if (employee == null) {
            return false;
        }

        if (employee.name.equals(name)) {
            return true;
        }

        if (employee instanceof Director director) {
            for (Employee subordinate : director.employees) {
                if (searchEmployeeByName(subordinate, name)) {
                    return true;
                }
            }
        }

        return false;
    }
}

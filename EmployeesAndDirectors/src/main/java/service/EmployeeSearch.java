package service;

import posts.Director;
import posts.Worker;

public class EmployeeSearch {
    public static boolean search(Employee director, String nameOfWorker) {
        for (Employee employee : director.employees) {
            if (employee != null) {
                if (employee.name.equals(nameOfWorker)) {
                    return true;
                }
            } else {
                break;
            }
        }

        return false;
    }

}

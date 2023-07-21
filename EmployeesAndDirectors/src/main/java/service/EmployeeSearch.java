package service;

import posts.Director;
import posts.Worker;

public class EmployeeSearch {
    public static boolean search(Director director, String nameOfWorker) {
        for (Worker worker : director.workers) {
            if (worker != null) {
                if (worker.name.equals(nameOfWorker)) {
                    return true;
                }
            } else {
                break;
            }
        }
        for (Director director1 : director.directors) {
            if (director1 != null) {
                if (director1.name.equals(nameOfWorker)) {
                    return true;
                }
                search(director1, nameOfWorker);
            }
        }
        return false;
    }

}

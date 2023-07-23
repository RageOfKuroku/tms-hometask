package service;


public class EmployeeSearch {
    public static boolean search(Employee sourceDirector, String name) {
        return searchWorker(sourceDirector, name) || searchDirector(sourceDirector, name);
    }

    private static boolean searchWorker(Employee employee, String name) {
        if (employee == null) {
            return false;
        }

        if (employee.post.equals(Post.WORKER) && employee.name.equals(name)) {
            return true;
        }

        for (Employee subordinate : employee.employees) {
            if (searchWorker(subordinate, name)) {
                return true;
            }
        }

        return false;
    }

    private static boolean searchDirector(Employee employee, String name) {
        if (employee == null) {
            return false;
        }

        if (employee.post.equals(Post.DIRECTOR) && employee.name.equals(name)) {
            return true;
        }

        for (Employee subordinate : employee.employees) {
            if (searchDirector(subordinate, name)) {
                return true;
            }
        }

        return false;
    }
}




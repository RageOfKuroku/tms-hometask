package service;

import posts.Director;

public abstract class InfoAboutDirector {

    public static void info(Director sourceDirector) {
        System.out.println("-------------------------------------------------------------");
        System.out.println(sourceDirector + "\nПодчинённые: ");
        for (Employee employee : sourceDirector.employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static void infoFromDirector(Director sourceDirector) {
        info(sourceDirector);
        for (Employee employee : sourceDirector.employees) {
            if (employee instanceof Director) {
                infoFromDirector((Director) employee);
            }
        }
    }
}

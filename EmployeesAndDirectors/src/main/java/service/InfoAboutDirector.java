package service;



public abstract class InfoAboutDirector {

    public static void info(Employee sourceDirector) {

        if (sourceDirector.post == Post.DIRECTOR) {
            System.out.println("-------------------------------------------------------------");
            System.out.println(sourceDirector + "\nПодчинённые: ");
        }
        for (Employee employee : sourceDirector.employees) {
            if (employee != null && sourceDirector.post == Post.DIRECTOR) {
                System.out.println(employee);
            }
        }


    }

    public static void infoFromDirector(Employee sourceDirector) {
        info(sourceDirector);
        for (Employee employee : sourceDirector.employees) {
            if (employee != null) {
                infoFromDirector(employee);
            } else break;

        }

    }
}

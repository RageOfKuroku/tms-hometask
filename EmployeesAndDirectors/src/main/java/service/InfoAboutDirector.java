package service;

import posts.Director;
import posts.Worker;


public abstract class InfoAboutDirector {

    public static void info(Director sourceDirector) {
        System.out.println(sourceDirector + "\nПодчинённые: ");
        for (Worker worker : sourceDirector.workers) {
            if (worker != null) {
                System.out.println(worker);
            }
        }
        for(Director director : sourceDirector.directors) {
            if(director != null) {
                System.out.println(director);
            }
        }

    }

    public static void infoFromDirector(Director sourceDirector) {
        info(sourceDirector);
        System.out.println("-------------------------------------------------------------");
        for(Director director : sourceDirector.directors) {
            if(director != null) {
                infoFromDirector(director);
            }else break;

        }

    }
}

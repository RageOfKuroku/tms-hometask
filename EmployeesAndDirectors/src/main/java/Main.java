import posts.Director;
import posts.Worker;
import service.EmployeeSearch;
import service.InfoAboutDirector;
import service.Post;

public class Main {
    public static void main(String[] args) {

        Director director = new Director("Egor", "Efimenko", Post.DIRECTOR, 15);
        Director director1 = new Director("Elon", "Musk", Post.DIRECTOR, 30);
        Director director2 = new Director("George", "Washington",Post.DIRECTOR,20);
        Worker work1 = new Worker("Allah", "Muhhamed", Post.WORKER, 20);
        Worker work2 = new Worker("Abdul", "Babul", Post.WORKER, 20);
        Worker work3 = new Worker("Ahmed", "Rahmed", Post.WORKER, 20);
        Worker work4 = new Worker("Azamat", "Taliev", Post.WORKER, 15);


        director.addWorker(work1, work2);
        director.addDirector(director1);
        director1.addWorker(work3);
        director1.addDirector(director2);
        director2.addWorker(work4);
        InfoAboutDirector.infoFromDirector(director);

        System.out.println("Проверка на наличие сотрудника: ");
        System.out.println(EmployeeSearch.search(director, "Allah"));
        System.out.println(EmployeeSearch.search(director, "Ahmed"));
        System.out.println(EmployeeSearch.search(director1, "Egor"));


    }

}

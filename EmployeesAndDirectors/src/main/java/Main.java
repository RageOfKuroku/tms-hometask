import posts.Director;
import posts.Worker;
import service.Employee;
import service.EmployeeSearch;
import service.InfoAboutDirector;
import service.Post;

public class Main {
    public static void main(String[] args) {

        Employee director = new Director("Egor", "Efimenko", Post.DIRECTOR, 15);
        Employee director1 = new Director("Elon", "Musk", Post.DIRECTOR, 30);
        Employee director2 = new Director("George", "Washington", Post.DIRECTOR, 20);
        Employee work1 = new Worker("Allah", "Muhhamed", Post.WORKER, 20);
        Employee work2 = new Worker("Abdul", "Babul", Post.WORKER, 20);
        Employee work3 = new Worker("Ahmed", "Rahmed", Post.WORKER, 20);
        Employee work4 = new Worker("Azamat", "Taliev", Post.WORKER, 15);


        director.addEmployee(work1, work2);
        director.addEmployee(director1);
        director1.addEmployee(work3);
        director1.addEmployee(director2);
        director2.addEmployee(work4);
        InfoAboutDirector.infoFromDirector(director);

        System.out.println("Проверка на наличие сотрудника: ");
        System.out.println(EmployeeSearch.search(director, "Allah"));
        System.out.println(EmployeeSearch.search(director, "Ahmed"));
        System.out.println(EmployeeSearch.search(director1, "Egor"));


    }

}

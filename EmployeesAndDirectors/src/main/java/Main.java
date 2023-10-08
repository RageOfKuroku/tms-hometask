import posts.Director;
import posts.Worker;
import hometask.org.service.EmployeeSearch;
import hometask.org.service.InfoAboutDirector;


public class Main {
    public static void main(String[] args) {

        Director director = new Director("Egor", "Efimenko", 15);
        Director director1 = new Director("Elon", "Musk", 30);
        Director director2 = new Director("George", "Washington", 20);
        Worker work1 = new Worker("Allah", "Muhhamed", 20);
        Worker work2 = new Worker("Abdul", "Babul", 20);
        Worker work3 = new Worker("Ahmed", "Rahmed", 20);
        Worker work4 = new Worker("Azamat", "Taliev", 15);


        director.addEmployee(work1, work2);
        director.addEmployee(director1);
        director1.addEmployee(work3);
        director1.addEmployee(director2);
        director2.addEmployee(work4);
        InfoAboutDirector.infoFromDirector(director);

        System.out.println("Проверка на наличие сотрудника: ");
        System.out.println(EmployeeSearch.searchByName(director, "Azamat")); // Возвращает true(т.к все работники являются подчинёнными Egor(director))
        System.out.println(EmployeeSearch.searchByName(director2, "Ahmed")); // Возвращает false(Ahmed(work3) не является подчинённым George(director2))


    }

}

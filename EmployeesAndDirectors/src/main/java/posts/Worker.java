package posts;

import service.Employee;
import service.Post;

public class Worker extends Employee {
    public Worker(String name, String surname, Post post, int workExp) {
        super(name, surname, post, workExp);
    }

    public String toString() {
        return "\nФио: " + name + " " + surname + "\nДолжность: " + post + "\nСтаж работы: " + workExp + " лет" + "\n" + "Заработная плата: " + countingSalary();
    }
}
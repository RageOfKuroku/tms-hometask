package posts;

import hometask.org.service.Employee;
import hometask.org.service.Post;

public class Worker extends Employee {
    public Worker(String name, String surname, int workExp) {
        super(name, surname, workExp);
        this.post = Post.WORKER;

    }

    public String toString() {
        return "\nФио: " + name + " " + surname + "\nДолжность: " + post + "\nСтаж работы: " + workExp + " лет" + "\n" + "Заработная плата: " + countingSalary();
    }
}

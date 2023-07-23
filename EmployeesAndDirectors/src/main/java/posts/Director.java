package posts;

import service.Employee;
import service.Post;

public class Director extends Employee {
    public Director(String name, String surname, Post post, int workExp) {
        super(name, surname, post, workExp);
    }

    private int countWorkers() {
        int count = 1;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public double countingSalary() {
        return basePost * post.getCoeffisients() * workExp * countWorkers();
    }

    @Override
    public String toString() {
        return "\nДолжность: " + post + "\nФио: " + name + " " + surname + "\nКоличество подчинённых: " + countWorkers() + " человек" + "\nСтаж работы: " + workExp + " лет" + "\n" + "Заработная плата: " + countingSalary();
    }
}

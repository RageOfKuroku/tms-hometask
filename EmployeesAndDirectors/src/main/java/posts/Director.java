package posts;

import hometask.org.service.Employee;
import hometask.org.service.Post;

public class Director extends Employee {
    public Employee[] employees = new Employee[15];

    public Director(String name, String surname, int workExp) {
        super(name, surname, workExp);
        this.post = Post.DIRECTOR;
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

    public void addEmployee(Employee... sourceEmployee) {
        for (Employee employee : sourceEmployee) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    employees[i] = employee;
                    break;
                }
            }
        }
    }

    @Override
    public double countingSalary() {
        return basePost * post.getCoeffisients() * workExp * countWorkers();
    }

    @Override
    public String toString() {
        return "\nДолжность: " + post +
                "\nФио: " + name + " " + surname +
                "\nКоличество подчинённых: " + countWorkers() + " человек" +
                "\nСтаж работы: " + workExp + " лет" + "\n" +
                "Заработная плата: " + countingSalary();

    }
}

package posts;

import service.Employee;
import service.Post;

public class Director extends Employee {
    public Worker[] workers = new Worker[15];
    public Director[] directors = new Director[15];

    public void addWorker(Worker... sourceWorker) {
        for (Worker worker : sourceWorker) {
            for (int i = 0; i < workers.length; i++) {
                if (workers[i] == null) {
                    workers[i] = worker;
                    break;
                }
            }
        }
    }

    public void addDirector(Director... sourceDirector) {
        for (Director director : sourceDirector) {
            for (int i = 0; i < directors.length; i++) {
                if (directors[i] == null) {
                    directors[i] = director;
                    break;
                }
            }
        }
    }

    public Director(String name, String surname, Post post, int workExp) {
        super(name, surname, post, workExp);
    }

    private int countWorkers() {
        int counter = 0;

        for (Worker worker : workers) {
            if (worker != null) {
                counter++;
            } else {
                break;
            }
        }
        for (Director director : directors) {
            if (director != null) {
                counter++;
            } else {
                break;
            }
        }

        return counter;
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

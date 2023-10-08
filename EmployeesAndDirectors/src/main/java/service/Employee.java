package hometask.org.service;

public abstract class Employee {
    public String name;
    public String surname;
    public Post post;
    public int workExp;
    public double basePost = 1.5;

    public Employee(String name, String surname, int workExp) {
        this.name = name;
        this.surname = surname;
        this.workExp = workExp;
    }

    public double countingSalary() {
        return basePost * post.getCoeffisients() * workExp;
    }
}

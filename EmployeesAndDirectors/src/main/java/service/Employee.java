package service;

public abstract class Employee {
    public String name;
    public String surname;
    public Post post;
    public int workExp;
    public double basePost = 1.5;

    public Employee(String name, String surname, Post post, int workExp) {
        this.name = name;
        this.surname = surname;
        this.post = post;
        this.workExp = workExp;
    }
    public double countingSalary() {
          return basePost * post.getCoeffisients() * workExp;
    }


}

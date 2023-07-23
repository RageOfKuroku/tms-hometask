package service;

public abstract class Employee {
    public String name;
    public String surname;
    public Post post;
    public int workExp;
    public double basePost = 1.5;

    public Employee[] employees = new Employee[15];

    public Employee(String name, String surname, Post post, int workExp) {
        this.name = name;
        this.surname = surname;
        this.post = post;
        this.workExp = workExp;
    }

    public double countingSalary() {
        return basePost * post.getCoeffisients() * workExp;
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


}

package MainTask2;

public class Main {
    public static void main(String[] args) {
        EmployeeService employee1 = new Worker();
        EmployeeService employee2 = new Accountant();
        EmployeeService employee3 = new Director();

        EmployeeService[] employees = {employee1, employee2, employee3};
        for (EmployeeService employee: employees) {
            System.out.print("Должность - ");
            employee.print();
        }
    }
}


class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    String department;

    Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    @Override
    void display() {
        System.out.println("Manager Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Rahul", 25000);
        Manager m1 = new Manager("Riya", 45000, "IT");

        System.out.println("--- Employee Details ---");
        e1.display();

        System.out.println("\n--- Manager Details ---");
        m1.display();
    }
}

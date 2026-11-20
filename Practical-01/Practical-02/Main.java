
import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    int[] marks = new int[5];

    static String collegeName = "ABC College";

    Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    int calculateTotal() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    double calculatePercentage() {
        return calculateTotal() / 5.0;
    }

    void displayResult() {
        System.out.println("\n----- Student Details -----");
        System.out.println("College: " + collegeName);
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Total Marks: " + calculateTotal() + "/500");
        System.out.println("Percentage: " + calculatePercentage() + "%");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] marks = new int[5];

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks of subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        Student s1 = new Student(name, rollNo, marks);
        s1.displayResult();

        sc.close();
    }
}

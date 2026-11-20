
import java.util.Scanner;

public class StudentResultCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] marks = new int[5];
        int total = 0;
        double percentage;
        String grade;

        System.out.println("Student Result Calculator");

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks of subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            total += marks[i];
        }

        percentage = (total / 500.0) * 100;

        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "Fail";
        }

        System.out.println("\n----- Student Result -----");
        System.out.println("Total Marks: " + total + "/500");
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}

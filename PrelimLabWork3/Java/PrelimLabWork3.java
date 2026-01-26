import java.util.Scanner;

public class PrelimLabWork3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==== Required Prelim Exam Score Calculator =====");

        // Input
        System.out.print("Enter Attendance score: ");
        double attendance = sc.nextDouble();

        System.out.print("Enter Lab Work 1 score: ");
        double lab1 = sc.nextDouble();

        System.out.print("Enter Lab Work 2 score: ");
        double lab2 = sc.nextDouble();

        System.out.print("Enter Lab Work 3 score: ");
        double lab3 = sc.nextDouble();

        // Compute Lab Work Average
        double labAverage = (lab1 + lab2 + lab3) / 3;

        // Compute Class Standing (30% of Prelim Grade)
        double classStanding = (attendance * 0.40) + (labAverage * 0.60);

        // Compute required Prelim Exam scores for target grades
        // Prelim Grade = (Prelim Exam * 0.70) + (Class Standing * 0.30)
        double requiredPassing = (75 - (classStanding * 0.30)) / 0.70;
        double requiredExcellent = (100 - (classStanding * 0.30)) / 0.70;

        // Output
        System.out.println("\n===== RESULTS =====");
        System.out.printf("Attendance: %.2f%n", attendance);
        System.out.printf("Lab Work 1: %.2f%n", lab1);
        System.out.printf("Lab Work 2: %.2f%n", lab2);
        System.out.printf("Lab Work 3: %.2f%n", lab3);
        System.out.printf("Lab Work Average: %.2f%n", labAverage);
        System.out.printf("Class Standing: %.2f%n", classStanding);

        System.out.println("\nRequired Prelim Exam Scores:");
        if (requiredPassing > 100) {
            System.out.println("To PASS (75): Impossible based on current Class Standing.");
        } else if (requiredPassing <= 0) {
            System.out.println("To PASS (75): You are already passing even with 0 exam score!");
        } else {
            System.out.printf("To PASS (75): %.2f%n", requiredPassing);
        }

        if (requiredExcellent > 100) {
            System.out.println("To get EXCELLENT (100): Impossible.");
        } else {
            System.out.printf("To get EXCELLENT (100): %.2f%n", requiredExcellent);
        }

        sc.close();
    }
}

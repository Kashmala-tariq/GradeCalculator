 import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== CGPA Calculator Pro ===");
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("How many semesters? ");
        int totalSems = sc.nextInt();

        Student s1 = new Student(name, totalSems);

        for (int i = 1; i <= totalSems; i++) {
            System.out.print("Enter GPA for Sem " + i + ": ");
            double gpa = sc.nextDouble();
            s1.addGPA(i, gpa);
        }

        CGPAAnalyzer analyzer = new CGPAAnalyzer();

        System.out.println("\n========== REPORT ==========");
        System.out.println("Student Name: " + s1.name);
        System.out.println("Overall CGPA: " + String.format("%.2f", s1.calculateCGPA()));
        System.out.println("Best Semester: " + analyzer.getBestSemester(s1));
        analyzer.showBarChart(s1);
        System.out.println("============================");

        sc.close();
    }
}
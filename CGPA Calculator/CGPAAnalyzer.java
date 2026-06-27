public class CGPAAnalyzer {

    public int getBestSemester(Student s) {
        int bestSem = 1;
        double maxGPA = s.semesterGPAs[0];
        for (int i = 1; i < s.semesterGPAs.length; i++) {
            if (s.semesterGPAs[i] > maxGPA) {
                maxGPA = s.semesterGPAs[i];
                bestSem = i + 1;
            }
        }
        return bestSem;
    }

    public void showBarChart(Student s) {
        System.out.println("\n--- GPA Trend Chart ---");
        for (int i = 0; i < s.semesterGPAs.length; i++) {
            System.out.print("Sem " + (i + 1) + ": ");
            int stars = (int)(s.semesterGPAs[i]);
            for (int j = 0; j < stars; j++) {
                System.out.print(" * ");
            }
            System.out.println(" " + s.semesterGPAs[i]);
        }
    }
}
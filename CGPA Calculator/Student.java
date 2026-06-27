public class Student {
    String name;
    double[] semesterGPAs;

    public Student(String name, int totalSemesters) {
        this.name = name;
        this.semesterGPAs = new double[totalSemesters];
    }

    public void addGPA(int semester, double gpa) {
        semesterGPAs[semester - 1] = gpa;
    }

    public double calculateCGPA() {
        double sum = 0;
        for (double gpa : semesterGPAs) {
            sum += gpa;
        }
        return sum / semesterGPAs.length;
    }
}
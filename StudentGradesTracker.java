import java.util.Scanner;

public class StudentGradesTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        // Arrays to store student grades
        int[] grades = new int[numberOfStudents];
        char[] letterGrades = new char[numberOfStudents];

        // Input grades for each student and calculate letter grade
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter the grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
            letterGrades[i] = getLetterGrade(grades[i]);
        }

        // Calculate sum, highest, and lowest grades
        int sum = 0;
        int highestGrade = grades[0];
        int lowestGrade = grades[0];

        for (int i = 0; i < numberOfStudents; i++) {
            sum += grades[i];

            if (grades[i] > highestGrade) {
                highestGrade = grades[i];
            }
            if (grades[i] < lowestGrade) {
                lowestGrade = grades[i];
            }
        }

        // Calculate average
        double averageGrade = (double) sum / numberOfStudents;

        // Output the results
        System.out.println("\n--- Grade Report ---");
        System.out.println("a) Average Grade: " + averageGrade + " (" + getLetterGrade((int) averageGrade) + ")");
        System.out.println("b) Highest Grade: " + highestGrade + " (" + getLetterGrade(highestGrade) + ")");
        System.out.println("c) Lowest Grade: " + lowestGrade + " (" + getLetterGrade(lowestGrade) + ")");
        System.out.print("d) All Grades: ");
        
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print(grades[i] + " (" + letterGrades[i] + ")");
            if (i < numberOfStudents - 1) {
                System.out.print(", ");
            }
        }
    }

    // Method to determine letter grade based on numeric grade
    public static char getLetterGrade(int grade) {
        if (grade >= 90) {
            return 'A';
        } else if (grade >= 80) {
            return 'B';
        } else if (grade >= 70) {
            return 'C';
        } else if (grade >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
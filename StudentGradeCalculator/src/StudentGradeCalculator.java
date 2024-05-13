import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the marks obtained in each subject (out of 100):");

        System.out.print("Subject 1: ");
        int subject1 = scanner.nextInt();

        System.out.print("Subject 2: ");
        int subject2 = scanner.nextInt();

        System.out.print("Subject 3: ");
        int subject3 = scanner.nextInt();

        System.out.print("Subject 4: ");
        int subject4 = scanner.nextInt();

        System.out.print("Subject 5: ");
        int subject5 = scanner.nextInt();
        
        System.out.print("Subject 6: ");
        int subject6 = scanner.nextInt();

        int totalMarks = subject1 + subject2 + subject3 + subject4 + subject5+ subject6;


        double averagePercentage = (double) totalMarks / 6;

        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

      
        System.out.println("\nTotal Marks: " + totalMarks+"out of 600");
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

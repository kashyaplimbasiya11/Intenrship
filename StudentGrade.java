import java.util.Scanner;

public class StudentGrade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of subjects :");
        int Totalsub = scanner.nextInt();

        int[] marks = new int[Totalsub];

        for (int i = 0; i < Totalsub; i++) {
            System.out.println("Enter your marks Subject " + (i + 1) );
            marks[i] = scanner.nextInt();
        }
        int totalMarks = printtotalMarks(marks);
   
        double averagePercentage = printPercentage(totalMarks, Totalsub);

        char grade = printGrade(averagePercentage);

        print(totalMarks, averagePercentage, grade);

    
    }
    public static int printtotalMarks(int[] marks) {
        int total = 0;

        for (int mark : marks) {
            total =total + mark;
        }
        return total;
    }
      public static double printPercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }
    public static char printGrade(double percentage) {
        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else {
            System.out.println("you are fail");
            return 'F';   
         }
      }

    public static void print(int totalMarks, double avgPercentage, char grade) {
        System.out.println("Your Total Marks: " + totalMarks);
        System.out.println("Your percantage Percentage: " + avgPercentage + "%");
        System.out.println("Grade: " + grade);
    }
}


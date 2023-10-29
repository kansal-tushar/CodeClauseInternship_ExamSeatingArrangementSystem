import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public class Student {
        String name;
        int rollNo;
        int year;
        int semester;

        public Student(String name, int rollNo, int year, int semester) {
            this.name = name;
            this.rollNo = rollNo;
            this.year = year;
            this.semester = semester;
        }
    }

    public List<Student> getStudents(Scanner scanner, int total) {
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            
            System.out.print("Enter the roll number of student " + (i + 1) + ": ");
            int rollNo = scanner.nextInt();
            
            System.out.print("Enter the year of student " + (i + 1) + ": ");
            int year = scanner.nextInt();
            
            System.out.print("Enter the semester of student " + (i + 1) + ": ");
            int semester = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            // Use the local variables to instantiate a Student and add to the list
            students.add(new Student(name, rollNo, year, semester));
        }

        return students;
    }
}

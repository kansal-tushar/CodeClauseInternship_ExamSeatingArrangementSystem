import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Login login = new Login();
        if (!login.isValid(scanner)) {
            System.out.println("Invalid credentials. Exiting...");
            scanner.close();
            return;
        }
        
        
        System.out.print("Enter the number of classes: ");
        int classCount = scanner.nextInt();

        System.out.print("Enter the number of seats per class: ");
        int seatsEach = scanner.nextInt();

        System.out.print("Enter the number of total students: ");
        int total = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        
        Input input = new Input();
        List<Input.Student> students = input.getStudents(scanner, total);

        ArrangeSeats arranger = new ArrangeSeats();
        List<ArrangeSeats.Room> rooms = arranger.setup(students, classCount, seatsEach);

        System.out.println("Seat Layout:");
        for (ArrangeSeats.Room room : rooms) {
            System.out.println("Class: " + room.name);
            while (!room.seats.isEmpty()) {
                Input.Student student = room.seats.poll();
                System.out.printf("Seat %d: Name: %s | Roll No: %d | Year: %d | Semester: %d\n",
                    (seatsEach - room.seats.size()), student.name, student.rollNo, student.year, student.semester);
            }
            System.out.println("---------");
        }

        scanner.close();
    }
}

import java.util.Scanner;

public class Login {

    private final String USERNAME = "admin";
    private final String PASSWORD = "admin123";

    public boolean isValid(Scanner scanner) {
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        return USERNAME.equals(inputUsername) && PASSWORD.equals(inputPassword);
    }
}

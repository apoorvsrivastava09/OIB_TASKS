import java.util.Scanner;

public class OnlineExamSystem {
    private static String username;
    private static String password;
    private static int timer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Online Exam System");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    System.out.println("Exiting the exam system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter your username: ");
        username = scanner.nextLine();
        System.out.print("Enter your password: ");
        password = scanner.nextLine();

        // Simulate authentication (you should replace this with real authentication logic)
        if (authenticateUser(username, password)) {
            showMainMenu(scanner);
        } else {
            System.out.println("Authentication failed. Please try again.");
        }
    }

    private static boolean authenticateUser(String username, String password) {
        // Simulate authentication logic (e.g., check against a database)
        return username.equals("user") && password.equals("password");
    }

    private static void showMainMenu(Scanner scanner) {
        while (true) {
            System.out.println("Main Menu");
            System.out.println("1. Update Profile");
            System.out.println("2. Change Password");
            System.out.println("3. Take Exam");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    updateProfile(scanner);
                    break;
                case 2:
                    changePassword(scanner);
                    break;
                case 3:
                    takeExam(scanner);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void updateProfile(Scanner scanner) {
        System.out.print("Enter your new name: ");
        String newName = scanner.nextLine();
        // Simulate updating the profile (e.g., save to a database)
        System.out.println("Profile updated successfully!");
    }

    private static void changePassword(Scanner scanner) {
        System.out.print("Enter your current password: ");
        String currentPassword = scanner.nextLine();
        System.out.print("Enter your new password: ");
        String newPassword = scanner.nextLine();
        // Simulate changing the password (e.g., update in a database)
        System.out.println("Password changed successfully!");
    }

    private static void takeExam(Scanner scanner) {
        System.out.println("Taking the exam...");
        System.out.print("Set the timer (in minutes): ");
        timer = scanner.nextInt();
        System.out.println("You have " + timer + " minutes to complete the exam.");

        // Simulate answering MCQs and auto-submitting
        try {
            Thread.sleep(timer * 60 * 1000); // Convert minutes to milliseconds
            System.out.println("Auto-submitting the exam...");
            // Add logic to auto-submit the exam here
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

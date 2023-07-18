import java.util.Scanner;

public class Admin extends Person implements Authonticate {
    private String AdminUserName;
    private String AdminPassword;

    public Admin(String adminUserName, String adminPassword) {
        AdminUserName = adminUserName;
        AdminPassword = adminPassword;
    }

    public Admin(String name, int age, String adminUserName, String adminPassword) {
        super(name, age);
        AdminUserName = adminUserName;
        AdminPassword = adminPassword;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String adminUsername = "admin";
        String adminPassword = "admin123";
        String customerUsername = "customer";
        String customerPassword = "customer123";

        System.out.println("Welcome to the Online Shopping Store");
        System.out.println("------------------------------------");
        System.out.println("Please login to continue:");

        // User login
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Check authentication
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            System.out.println("^^^^^^Welcome to the Admin view^^^^^^.");
            // Admin operations
            performAdminOperations();
        } else if (username.equals(customerUsername) && password.equals(customerPassword)) {
            System.out.println("Customer login successful.");
            // Customer operations

            // TODO: Perform customer operations
        } else {
            System.out.println("Invalid username or password. Login failed.");
            // End the program or display an error message as per your requirement
        }
    }

    public static void performAdminOperations() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //this part to select choise//
            System.out.print("Enter your choice");
            System.out.println("");
            System.out.println("1-view cities.");
            System.out.println("2-booking.");
            System.out.println("3-Exiting the menu.");
            System.out.println("4-Exiting the application and terminating the program.");

            String choice = scanner.nextLine();
            switch (choice) {
                case "3":
                    System.out.println("Exiting the menu.");
                    return;
                case "4":
                    System.out.println("Exiting the application.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    @Override
    public boolean LogIn(String username, String Password) {
        return this.AdminUserName.equals(username) && this.AdminPassword.equals(Password);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "AdminUserName='" + AdminUserName + '\'' +
                ", AdminPassword='" + AdminPassword + '\'' +
                '}';
    }
}

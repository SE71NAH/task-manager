import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Your existing Task Manager logic
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        // Launch the JavaFX application
        TaskManagerApp.launch(TaskManagerApp.class, args);

        // Your existing menu and task management logic
        while (true) {
            // Display a menu for user options
            System.out.println("Task Manager Menu:");
            System.out.println("1. Create Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Edit Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Save Tasks to File");
            System.out.println("6. Load Tasks from File");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Create a task
                    // Call taskManager.createTask() or a similar method
                    break;
                case 2:
                    // View tasks
                    // Call taskManager.viewTasks() or a similar method
                    break;
                // Implement cases 3, 4, 5, and 6 similarly
                case 0:
                    // Exit the program
                    System.out.println("Exiting Task Manager. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
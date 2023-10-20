import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private TaskManager taskManager;
    private Scanner scanner;

    public UserInterface(TaskManager taskManager) {
        this.taskManager = taskManager;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    createTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    editTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    saveTasks();
                    break;
                case 6:
                    loadTasks();
                    break;
                case 0:
                    System.out.println("Exiting Task Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void displayMenu() {
        System.out.println("Task Manager Menu:");
        System.out.println("1. Create Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Edit Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Save Tasks to File");
        System.out.println("6. Load Tasks from File");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void createTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        // Prompt for other task properties (description, deadline, priority) and create the task.
        // Call taskManager.createTask() with the collected input.
    }

    private void viewTasks() {
        taskManager.viewTasks();
    }

    private void editTask() {
        System.out.print("Enter the title of the task to edit: ");
        String title = scanner.nextLine();
        // Prompt for new task properties (title, description, deadline, priority) and edit the task.
        // Call taskManager.editTask() with the collected input.
    }

    private void deleteTask() {
        System.out.print("Enter the title of the task to delete: ");
        String title = scanner.nextLine();
        // Call taskManager.deleteTask() with the provided title.
    }

    private void saveTasks() {
        System.out.print("Enter the filename to save tasks: ");
        String fileName = scanner.nextLine();
        // Call taskManager.saveTasksToFile() with the provided filename.
    }

    private void loadTasks() {
        System.out.print("Enter the filename to load tasks from: ");
        String fileName = scanner.nextLine();
        // Call taskManager.loadTasksFromFile() with the provided filename.
    }
}

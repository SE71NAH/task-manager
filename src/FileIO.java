import java.io.*;
import java.util.List;

public class FileIO {
    public static void saveTasksToFile(List<Task> tasks, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(tasks);
            System.out.println("Tasks saved to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving tasks to file: " + e.getMessage());
        }
    }

    public static List<Task> loadTasksFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName)) ) {
            List<Task> tasks = (List<Task>) inputStream.readObject();
            System.out.println("Tasks loaded from file: " + fileName);
            return tasks;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading tasks from file: " + e.getMessage());
        }
        return null;
    }
}

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TaskManager {
    private List<Task> taskList = new ArrayList();

    public TaskManager() {
    }

    public void createTask(String title, String description, Date deadline, int priority) {
        Task newTask = new Task(title, description, deadline, priority);
        this.taskList.add(newTask);
    }

    public List<Task> viewTasks() {
        return taskList;
    }

    public Task findTaskByTitle(String title) {
        for (Task task : taskList) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }

    public void editTask(String title, String newTitle, String newDescription, Date newDeadline, int newPriority) {
        Task taskToEdit = this.findTaskByTitle(title);
        if (taskToEdit != null) {
            taskToEdit.setTitle(newTitle);
            taskToEdit.setDescription(newDescription);
            taskToEdit.setDeadline(newDeadline);
            taskToEdit.setPriority(newPriority);
            System.out.println("Task edited successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void deleteTask(String title) {
        Task taskToDelete = this.findTaskByTitle(title);
        if (taskToDelete != null) {
            this.taskList.remove(taskToDelete);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }
}


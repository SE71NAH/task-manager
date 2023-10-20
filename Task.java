public class Task {
    private String title;
    private String description;
    private Date deadline;
    private int priority;

    public Task(String title, String description, Date deadline, int priority) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
    }

    // Getters and setters for properties (title, description, deadline, priority)

    @Override
    public String toString() {
        // Customize this method to return a string representation of the task
        return "Title: " + title + "\nDescription: " + description;
    }
}

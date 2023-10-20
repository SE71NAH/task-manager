import java.util.Date;
import java.util.Iterator;
import java.util.Optional;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskManagerApp extends Application {
    private ListView<String> taskListView;
    private Button addButton;
    private Button editButton;
    private Button deleteButton;
    private TaskManager taskManager;
    private TextArea taskDetailsTextArea;

    public TaskManagerApp() {
    }

    public void start(Stage primaryStage) {
        this.taskManager = new TaskManager();
        this.taskListView = new ListView();
        this.addButton = new Button("Add Task");
        this.editButton = new Button("Edit Task");
        this.deleteButton = new Button("Delete Task");
        this.taskDetailsTextArea = new TextArea();
        this.addButton.setOnAction((event) -> {
            this.showCreateTaskDialog();
        });
        this.editButton.setOnAction((event) -> {
            this.showEditTaskDialog();
        });
        this.deleteButton.setOnAction((event) -> {
            this.showDeleteTaskDialog();
        });
        VBox root = new VBox(new Node[]{this.taskListView, this.addButton, this.editButton, this.deleteButton, this.taskDetailsTextArea});
        Scene scene = new Scene(root, 400.0, 300.0);
        primaryStage.setTitle("Task Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void showCreateTaskDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Create Task");
        dialog.setHeaderText("Enter task details:");
        dialog.setContentText("Title:");
        Optional<String> titleResult = dialog.showAndWait();
        titleResult.ifPresent((title) -> {
            TextInputDialog descriptionDialog = new TextInputDialog();
            descriptionDialog.setTitle("Create Task");
            descriptionDialog.setHeaderText("Enter task description:");
            descriptionDialog.setContentText("Description:");
            Optional<String> descriptionResult = descriptionDialog.showAndWait();
            String description = (String)descriptionResult.orElse("No Description");
            this.taskManager.createTask(title, description, (Date)null, 0);
            this.refreshTaskList();
        });
    }

    private void showEditTaskDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Edit Task");
        dialog.setHeaderText("Enter task title to edit:");
        dialog.setContentText("Title to Edit:");

        Optional<String> titleResult = dialog.showAndWait();
        titleResult.ifPresent(titleToEdit -> {
            Task taskToEdit = taskManager.findTaskByTitle(titleToEdit);

            if (taskToEdit != null) {
                // Create a dialog to edit the task details
                TextInputDialog editDialog = new TextInputDialog(taskToEdit.getTitle());
                editDialog.setTitle("Edit Task");
                editDialog.setHeaderText("Edit task details:");
                editDialog.setContentText("New Title:");

                Optional<String> newTitleResult = editDialog.showAndWait();
                newTitleResult.ifPresent(newTitle -> {
                    // Create a dialog for editing the description
                    TextInputDialog descriptionDialog = new TextInputDialog(taskToEdit.getDescription());
                    descriptionDialog.setTitle("Edit Task");
                    descriptionDialog.setHeaderText("Edit task description:");
                    descriptionDialog.setContentText("New Description:");

                    Optional<String> newDescriptionResult = descriptionDialog.showAndWait();
                    newDescriptionResult.ifPresent(newDescription -> {
                        // Update the task with the provided details
                        taskManager.editTask(taskToEdit.getTitle(), newTitle, newDescription, null, 0);
                        refreshTaskList();
                    });
                });
            } else {
                showAlert("Task Not Found", "The task with the specified title was not found.");
            }
        });
    }

    private void showDeleteTaskDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Delete Task");
        dialog.setHeaderText("Enter task title to delete:");
        dialog.setContentText("Title to Delete:");

        Optional<String> titleResult = dialog.showAndWait();
        titleResult.ifPresent(titleToDelete -> {
            if (taskManager.findTaskByTitle(titleToDelete) != null) {
                taskManager.deleteTask(titleToDelete);
                refreshTaskList();
            } else {
                showAlert("Task Not Found", "The task with the specified title was not found.");
            }
        });
    }

    private void refreshTaskList() {
        this.taskListView.getItems().clear();
        Iterator var1 = this.taskManager.viewTasks().iterator();

        while (var1.hasNext()) {
            Task task = (Task) var1.next();
            ObservableList var10000 = this.taskListView.getItems();
            String var10001 = task.getTitle();
            var10000.add(var10001 + ": " + task.getDescription());
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

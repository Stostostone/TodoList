package Ui;

import Source.ToDoList.TodoService;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class editScene {
    TodoService todoService = new TodoService();

    VBox editPage = new VBox(10);
    ListView<Text> list = new ListView<Text>();
    HBox nameTextBox = new HBox(10);
    HBox detailTextBox = new HBox(10);
    HBox dateTextBox = new HBox(10);

    public editScene(Stage stage) {

        Text title = new Text("Edit Scene");

        Label name = new Label("Todo name: ");
        Label detail = new Label("detail: ");
        Label date = new Label("date: ");

        Button editButton = new Button("Edit");
        editButton.setOnAction(e -> {

        });

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {

        });
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> {

        });
        Button deleteButton = new Button("Delete");

        editPage.getChildren().addAll(nameTextBox, detailTextBox, dateTextBox, editButton, saveButton, cancelButton );
    }

    public Node getEditPage() {
        return editPage;
    }
}

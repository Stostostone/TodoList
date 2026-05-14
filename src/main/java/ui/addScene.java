package ui;

import service.TodoService;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class addScene {

    VBox addPage = new VBox(10);
    HBox addButtonPage = new HBox(10);
    ListView<Text> list = new ListView<Text>();
    HBox nameTextBox = new HBox(10);
    HBox detailTextBox = new HBox(10);
    HBox dateTextBox = new HBox(10);

    public addScene(Stage stage, TodoService todoService, DisplayScene displayPage) {
        addPage.setPadding(new Insets(30));
        addButtonPage.setPadding(new Insets(30));

        Text title = new Text("Add: ");
        Label name = new Label("Todo name: ");
        Label detail = new Label("Todo detail: ");
        Label date = new Label("Todo date: ");

        TextField nameField = new TextField();
        nameField.setStyle("-fx-border-color: #f0f0f0");
        nameField.setPromptText("Todo name");
        nameField.setMaxWidth(1000);

        TextField detailField = new TextField();
        detailField.setStyle("-fx-border-color: #f0f0f0");
        detailField.setPromptText("details");
        detailField.setMaxWidth(1000);

        TextField dateField = new TextField();
        dateField.setStyle("-fx-border-color: #f0f0f0");
        dateField.setPromptText("date");
        dateField.setMaxWidth(1000);

        Button addButton = new Button("add");
        addButton.setOnAction(e -> {
            String inputName = nameField.getText();
            String inputDetail = detailField.getText();
            String inputDate = dateField.getText();
            todoService.addTodo(inputName, inputDetail, inputDate);
            dateField.clear();
            nameField.clear();
            detailField.clear();
            displayPage.refreshList();
        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> {
            dateField.clear();
            nameField.clear();
            detailField.clear();
            stage.setScene(addPage.getScene());
        });

        nameTextBox.getChildren().addAll(name, nameField);
        detailTextBox.getChildren().addAll(detail, detailField);
        dateTextBox.getChildren().addAll(date, dateField);
        addButtonPage.getChildren().addAll(addButton, cancelButton);
        addPage.getChildren().addAll(title, nameTextBox, detailTextBox, dateTextBox, addButtonPage);
        addButtonPage.getChildren().addAll();
    }

    public Node getAddPage() {
        return addPage;
    }
    public Node getAddButtonPage() {return addButtonPage;}
}

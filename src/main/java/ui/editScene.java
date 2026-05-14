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

public class editScene {

    VBox editPage = new VBox(10);
    HBox editButtonPage = new HBox(10);
    ListView<Text> list = new ListView<Text>();
    HBox nameTextBox = new HBox(10);
    HBox detailTextBox = new HBox(10);
    HBox dateTextBox = new HBox(10);

    public editScene(Stage stage, TodoService todoService, DisplayScene displayPage) {
        editPage.setPadding(new Insets(30));
        editButtonPage.setPadding(new Insets(30));

        Text title = new Text("Edit: ");
        Label name = new Label("Todo name: ");
        Label detail = new Label("Todo detail: ");
        Label date = new Label("Todo date: ");

        TextField nameField = new TextField();
        nameField.setStyle("-fx-border-color: #f5f5f5");
        nameField.setPromptText("Todo name");
        nameField.setMaxWidth(200);

        TextField detailField = new TextField();
        detailField.setStyle("-fx-border-color: #f5f5f5");
        detailField.setPromptText("details");
        detailField.setMaxWidth(200);

        TextField dateField = new TextField();
        dateField.setStyle("-fx-border-color: #f5f5f5");
        dateField.setPromptText("date");
        dateField.setMaxWidth(200);

        Button saveButton = new Button("save");
        saveButton.setOnAction(e -> {
            String inputName = nameField.getText();
            String inputDetail = detailField.getText();
            String inputDate = dateField.getText();
            int index =  list.getSelectionModel().getSelectedIndex() + 1;
            todoService.setTodoName(inputName, index);
            todoService.setTodoDetail(inputDetail, index);
            todoService.setTodoDate(inputDate, index);
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
            displayPage.refreshList();
        });

        nameTextBox.getChildren().addAll(name, nameField);
        detailTextBox.getChildren().addAll(detail, detailField);
        dateTextBox.getChildren().addAll(date, dateField);
        editButtonPage.getChildren().addAll(saveButton, cancelButton);
        editPage.getChildren().addAll(title, nameTextBox, detailTextBox, dateTextBox, editButtonPage);
        editButtonPage.getChildren().addAll();
    }

    public Node getEditPage() {
        return editPage;
    }
    public Node getEditButtonPage() {return editButtonPage;}
}

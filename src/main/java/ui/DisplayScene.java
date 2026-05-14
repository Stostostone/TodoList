package ui;

import service.TodoService;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.stream.IntStream;

public class DisplayScene {

    private final TodoService todoService;
    VBox displayRoot =  new VBox(10);
    ListView<String> list = new ListView<String>();
    HBox display = new HBox(10);
    HBox buttonRoot = new HBox(10);

    public DisplayScene(Stage stage, TodoService todoService) {
        displayRoot.setPadding(new Insets(30));
        buttonRoot.setPadding(new Insets(30));
        list.setPadding(new Insets(5));
        list.setStyle("-fx-background-color: #f5f5f5;");

        this.todoService = todoService;

        Label title = new Label("Todo List-------------- ");

        display.getChildren().addAll(list);
        displayRoot.getChildren().addAll(title, display);
        buttonRoot.getChildren().addAll();
        refreshList();
    }

    public void refreshList() {
        if (todoService == null) {
            list.setItems(FXCollections.observableArrayList("todo is null"));
            return;
        }
        if (todoService.getSize() == 0) {
            list.setItems(FXCollections.observableArrayList("No Todo List"));
            return;
        }
        list.setItems(FXCollections.observableArrayList(
                IntStream.range(0, todoService.getSize())
                        .mapToObj(i -> (i + 1) + ". " +
                                todoService.getTodo(i).getTodo() + " | " +
                                todoService.getTodo(i).getDetails() + " | " +
                                todoService.getTodo(i).getDate())
                        .toList()
        ));
    }

    public Node getDisplayPage() {return displayRoot;}
    public Node getDisplayButtonPage() {return buttonRoot;}
    public void deleteButton() {
        int index = list.getSelectionModel().getSelectedIndex();
        todoService.removeTodo(index);
    }
}

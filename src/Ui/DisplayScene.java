package Ui;

import Source.ToDoList.TodoService;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DisplayScene {

    TodoService  todoService = new TodoService();
    VBox displayRoot =  new VBox(10);



    public DisplayScene(Stage stage) {
        HBox display = new HBox(10);
        HBox button = new HBox(10);

        displayRoot.getChildren().addAll(
                display,
                button);
    }

    public Node getDisplayPage() {
        return displayRoot;
    }
}

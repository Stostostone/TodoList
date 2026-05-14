package ui;

import service.TodoService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//TODO: button事件绑定 ✔️
//TODO: 添加TODOList完整逻辑  状态:✔️
//TODO: 添加Observable和ListCell和文件持久化  状态:❌
//TODO: 添加流畅动画  状态:❌
//TODO: 添加CSS美化  状态:❌

public class UiApp extends Application {
    private Stage stage;
    private Scene scene;
    private TodoService todoService = new TodoService();

    @Override
    public void start(Stage stage) throws Exception {
        todoService.loadTodo();  //初始化数据，读取数据

        stage.setWidth(340);
        stage.setHeight(500);

        BorderPane root = new BorderPane();
        VBox emptyVBox = new VBox();
        HBox menuBar = new HBox();
        HBox buttonBar = new HBox();
        DisplayScene displayPage = new DisplayScene(stage, todoService);
        editScene editPage = new editScene(stage, todoService, displayPage);
        addScene addPage = new addScene(stage, todoService, displayPage);
        helpScene helpPage = new helpScene(stage, editPage, displayPage);

        root.setTop(menuBar);
        root.setCenter(displayPage.getDisplayPage());

        Button displayButton = new Button("Display");
        displayButton.setStyle("-fx-background-color: #f5f5f5;" +
                "-fx-background-radius: 0");
        displayButton.setOnAction(e -> {
            displayPage.refreshList();
            root.setTop(menuBar);
            root.setCenter(displayPage.getDisplayPage());
            root.setRight(emptyVBox);
            root.setBottom(buttonBar);
            stage.setWidth(340);
        });

        Button addButton = new Button("Add");
        addButton.setStyle("-fx-background-color: #f5f5f5;" +
                "-fx-background-radius: 0");
        addButton.setOnAction(e -> {
            root.setTop(menuBar);
            root.setCenter(displayPage.getDisplayPage());
            root.setRight(addPage.getAddPage());
            root.setBottom(buttonBar);
            stage.setWidth(700);
        });

        Button helpButton = new Button("Help");
        helpButton.setStyle("-fx-background-color: #f5f5f5;" +
                "-fx-background-radius: 0");
        helpButton.setOnAction(e -> {
            root.setTop(menuBar);
            root.setCenter(displayPage.getDisplayPage());
            root.setCenter(helpPage.getHelpScene());
            root.setRight(emptyVBox);
            stage.setWidth(340);
        });

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #f5f5f5;" +
                "-fx-background-radius: 0");
        backButton.setOnAction(e -> {
            displayPage.refreshList();
            root.setTop(menuBar);
            root.setRight(emptyVBox);
            root.setCenter(displayPage.getDisplayPage());
            root.setBottom(buttonBar);
            stage.setWidth(340);
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-background-color: #f5f5f5;" +
                "-fx-background-radius: 0");
        deleteButton.setOnAction(e -> {
            displayPage.deleteButton();
            displayPage.refreshList();
        });

        Button editButton = new Button("Edit");
        editButton.setStyle("-fx-background-color: #f5f5f5;" +
                "-fx-background-radius: 0");
        editButton.setOnAction(e -> {
            root.setTop(menuBar);
            root.setRight(editPage.getEditPage());
            root.setBottom(buttonBar);
            stage.setWidth(650);
        });

        menuBar.getChildren().addAll(
                displayButton,
                addButton,
                helpButton,
                backButton);
        buttonBar.getChildren().addAll(editButton, deleteButton);

        stage.setScene(new Scene(root));
        stage.show();
    }
}

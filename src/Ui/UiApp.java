package Ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class UiApp extends Application {
    private Stage stage;
    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setWidth(800);
        stage.setHeight(600);

        BorderPane root = new BorderPane();
        HBox menuBar = new HBox();
        DisplayScene displayPage = new DisplayScene(stage);
        editScene editScene = new editScene(stage);

        root.setTop(menuBar);
        root.setCenter(displayPage.getDisplayPage());

        Button displayButton = new Button("Display");
        displayButton.setStyle("-fx-background-color: #f0f0f0;" +
                "-fx-background-radius: 0");
        displayButton.setOnAction(e -> {
            root.setTop(menuBar);
            root.setCenter(displayPage.getDisplayPage());
        });

        Button editButton = new Button("Edit");
        editButton.setStyle("-fx-background-color: #f0f0f0;" +
                "-fx-background-radius: 0");
        editButton.setOnAction(e -> {
            root.setTop(menuBar);
            root.setCenter(editScene.getEditPage());
        });

        Button helpButton = new Button("Help");
        helpButton.setOnAction(e -> {

        });

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {

        });

        menuBar.getChildren().addAll(displayButton,
                editButton,
                helpButton,
                backButton);

        stage.setScene(new Scene(root));
        stage.show();
    }
}

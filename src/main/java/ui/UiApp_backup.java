package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UiApp_backup extends Application {

    //------------------------------------------
    //原Ui拆分为Ui和Page，已弃用
    //------------------------------------------
    @Override
    public void start(Stage stage) {
        VBox editRoot = new VBox(10);
        editRoot.setPadding(new Insets(0, 20, 0, 20));
        VBox displayRoot = new VBox(10);
        displayRoot.setPadding(new Insets(20));
        displayRoot.setPadding(new Insets(0,  20, 0, 20));
        HBox menubar = new HBox(0);
        HBox titleBox = new HBox(10);
        HBox inputBox = new HBox(10);
        HBox buttonBox = new HBox(10);

        Scene editScene = new Scene(editRoot, 500, 400);
        Scene displayScene = new Scene(displayRoot, 500, 400);
        displayScene.setFill(Color.WHITE);

        Button displayButton = new Button("Display");
        displayButton.setStyle("-fx-background-color: #f0f0f0;" +
                "-fx-background-radius: 0");
        displayButton.setOnAction(e -> {
            stage.setScene(displayScene);
        });

        Button editButton = new Button("edit");
        editButton.setOnAction(e -> {
           stage.setScene(editScene);
        });
        Button backButton = new Button("back");

        Button button = new Button("Button");
        button.setStyle("""
        -fx-background-radius: 15;
         -fx-font-size: 16;
        """);
        button.setOnAction(e -> System.out.println("Button clicked"));
        button.setEffect(new DropShadow());
        Button button2 = new Button("Button2");
        button2.setOnAction(e -> System.out.println("Button2 clicked"));
        button2.setEffect(new GaussianBlur());
        Button button3 = new Button("Button3");
        button3.setOnAction(e -> System.out.println("Button3 clicked"));

        TextField textField = new TextField("Enter text");

        TextField textField2 = new TextField("Enter text");
        TextField textField3 = new TextField("Enter text");



        Label title = new Label("TodoList");
        title.setFont(new Font(30));

        menubar.getChildren().addAll(displayButton, editButton, backButton);
        titleBox.getChildren().addAll(title);
        inputBox.getChildren().addAll(
                textField);
        buttonBox.getChildren().addAll(
                button,
                button2,
                button3);
        editRoot.getChildren().addAll(

                titleBox,
                inputBox,
                buttonBox);
        displayRoot.getChildren().addAll(
                menubar
        );

        stage.setTitle("Todo App");
        stage.setScene(displayScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
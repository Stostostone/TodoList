package Ui;

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

public class UiApp extends Application {

    //TODO: 添加TODOList完整逻辑  状态:❌
    //TODO: 添加流畅动画  状态:❌
    //TODO: 美化  状态:❌

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        HBox titleBox = new HBox(10);
        HBox inputBox = new HBox(10);
        HBox buttonBox = new HBox(10);

        Button button = new Button("Button");
        button.setStyle("""
        -fx-background-radius: 15;
         -fx-font-size: 16;
        """);
        button.setEffect(new DropShadow());
        Button button2 = new Button("Button2");
        button2.setEffect(new GaussianBlur());
        Button button3 = new Button("Button3");

        TextField textField = new TextField("Enter text");
        Label title = new Label("TodoList");
        title.setFont(new Font(30));

        titleBox.getChildren().addAll(title);
        inputBox.getChildren().addAll(
                textField);
        buttonBox.getChildren().addAll(
                button,
                button2,
                button3);
        root.getChildren().addAll(
                titleBox,
                inputBox,
                buttonBox);

        Scene scene = new Scene(root, 500, 400);

        scene.setFill(Color.WHITE);

        stage.setTitle("Todo App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
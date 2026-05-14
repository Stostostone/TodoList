package ui;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URI;

public class helpScene{
    VBox helpPage = new VBox(10);

    public helpScene(Stage stage, editScene editScene, DisplayScene displayScene) {

        helpPage.setPadding(new Insets(40));
        HBox developerBox = new HBox(10);
        HBox dateBox = new HBox(10);
        HBox versionBox = new HBox(10);
        VBox linkBox = new VBox(10);

        Text titleText = new Text("😊 Developer: LowlyStone");
        Text dateText = new Text("✅ Update time: 2026/5/12");
        Text versionText = new Text("😎 Version: v0.1.0");
        Text linkText = new Text("Github Link: ");
        Hyperlink link = new Hyperlink("https://github.com/LowlyStone/Developer");
        link.setOnAction(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/Stostostone/TodoList"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        developerBox.getChildren().addAll(titleText);
        dateBox.getChildren().addAll(dateText);
        versionBox.getChildren().addAll(versionText);
        linkBox.getChildren().addAll(linkText, link);
        helpPage.getChildren().addAll(
                developerBox,
                dateBox,
                versionBox,
                linkBox
        );
    }
    public Node getHelpScene(){
        return helpPage;
    }
}

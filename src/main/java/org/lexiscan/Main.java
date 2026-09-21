package org.lexiscan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                Main.class.getResource("/org/lexiscan/view/main-view.fxml")
        );

        Scene scene = new Scene(loader.load());

        scene.getStylesheets().add(
                Main.class.getResource(
                        "/org/lexiscan/view/styles/main-style.css"
                ).toExternalForm()
        );

        stage.setTitle("LexiScan");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
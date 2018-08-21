package jmines;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene primaryScene = new Scene(new GameWindow(), 600, 600);

        String stylesPath = getClass().getClassLoader().getResource("styles.css").toExternalForm();
        primaryScene.getStylesheets().add(stylesPath);

        primaryStage.setTitle("jMines");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

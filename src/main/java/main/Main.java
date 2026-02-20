package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import menus.MainMenuController;
import util.Text;

public class Main extends Application {

    private static final int WINDOW_WIDTH  = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final String WINDOW_TITLE = Text.GAMENAME;

    @Override
    public void start(Stage primaryStage) {

        // Scene Creation
        StackPane root = new StackPane();
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Main Menu creation
        MainMenuController mainMenuController = new MainMenuController(primaryStage);
        mainMenuController.show(root);

        // Configuration
        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

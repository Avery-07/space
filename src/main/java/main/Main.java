package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import menus.MainMenuController;

public class Main extends Application {

    private static final int WINDOW_WIDTH  = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static final String WINDOW_TITLE = "Mon Jeu";

    @Override
    public void start(Stage primaryStage) {
        // Construction du menu principal
        MainMenuController mainMenuController = new MainMenuController(primaryStage);

        // Création de la scène avec la vue du menu
        Scene scene = new Scene(mainMenuController.getView(), WINDOW_WIDTH, WINDOW_HEIGHT);

        // Configuration de la fenêtre
        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

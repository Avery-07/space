package menus;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Contrôleur du menu principal.
 * Relie les actions utilisateur (clics) à la logique applicative,
 * sans se préoccuper de la construction visuelle.
 */
public class MainMenuController {

    private final MainMenuView view;
    private final Stage        stage;

    public MainMenuController(Stage stage) {
        this.stage = stage;
        this.view = new MainMenuView();
        configureEvents();
    }

    private void configureEvents() {
        view.getBtnPlay().setOnAction(e -> launch());
        view.getBtnSettings().setOnAction(e -> settings());
        view.getBtnQuit().setOnAction(e -> stage.close());
    }

    private void launch() {
        // TODO : charger la scène de jeu
    }

    private void settings() {
        // TODO : afficher la fenêtre ou scène d'options
    }

    public void show(StackPane root) {
        view.show(root);
    }
}
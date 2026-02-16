package menus;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Contrôleur du menu principal.
 * Relie les actions utilisateur (clics) à la logique applicative,
 * sans se préoccuper de la construction visuelle.
 */
public class MainMenuController {

    private final MainMenuView vue;
    private final Stage        stage;

    public MainMenuController(Stage stage) {
        this.stage = stage;
        this.vue   = new MainMenuView();
        connecterActions();
    }

    private void connecterActions() {
        vue.getBtnPlay().setOnAction(e   -> launch());
        vue.getBtnSettings().setOnAction(e -> settings());
        vue.getBtnQuit().setOnAction(e -> stage.close());
    }

    private void launch() {
        // TODO : charger la scène de jeu
    }

    private void settings() {
        // TODO : afficher la fenêtre ou scène d'options
    }

    /**
     * Retourne la vue racine du menu, prête à être insérée dans une Scene.
     */
    public VBox getView() {
        return vue.getLocalRoot();
    }
}
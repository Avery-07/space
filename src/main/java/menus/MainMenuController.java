package menus;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.StellarSystem;
import service.SystemGenerator;
import service.SystemRenderer;

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

        // 1. Generate the data
        StellarSystem stellarSystem = SystemGenerator.generate("TIMERDE");

        // 2. Prepare the Visuals
        // We grab the current root from the stage to swap content
        StackPane root = (StackPane) stage.getScene().getRoot();
        root.getChildren().clear(); // Remove the menu buttons

        // 3. Create the Canvas
        Canvas canvas = new Canvas(stage.getWidth(), stage.getHeight());

        // Bind canvas size to the window size so it resizes if you stretch the window
        canvas.widthProperty().bind(stage.widthProperty());
        canvas.heightProperty().bind(stage.heightProperty());

        root.getChildren().add(canvas);

        // 4. Initialize and Start the Renderer
        SystemRenderer renderer = new SystemRenderer(canvas, stellarSystem);

        // Set a zoom level so the system fits (Adjust this based on your Generator scale)
        renderer.setZoom(0.3);

        renderer.start();

        System.out.println("System launched: " + stellarSystem.getName());
        System.out.println(stellarSystem);
    }

    private void settings() {
        // TODO : afficher la fenêtre ou scène d'options
    }

    public void show(StackPane root) {
        view.show(root);
    }
}
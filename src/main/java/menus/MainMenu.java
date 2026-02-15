package menus;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;

/**
 * Construit et gère le menu principal du jeu.
 * Contient les boutons Jouer, Options et Quitter.
 */
public class MainMenu {

    private final VBox  view;
    private final Stage stage;

    public MainMenu(Stage stage) {
        this.stage = stage;
        this.view  = buildMenu();
    }

    /**
     * Construit la mise en page du menu et retourne la vue racine.
     */
    private VBox buildMenu() {
        // --- Titre ---
        Label titre = new Label("MON JEU");
        titre.setFont(Font.font("Arial", FontWeight.BOLD, 64));
        titre.setTextFill(Color.WHITE);

        // --- Boutons ---
        Button btnJouer   = creerBouton("▶  Jouer");
        Button btnOptions = creerBouton("⚙  Options");
        Button btnQuitter = creerBouton("✖  Quitter");

        // Actions des boutons
        btnJouer.setOnAction(e -> lancerJeu());
        btnOptions.setOnAction(e -> ouvrirOptions());
        btnQuitter.setOnAction(e -> stage.close());

        // --- Conteneur principal ---
        VBox conteneur = new VBox(20, titre, btnJouer, btnOptions, btnQuitter);
        conteneur.setAlignment(Pos.CENTER);
        conteneur.setPadding(new Insets(40));
        conteneur.setBackground(new Background(
                new BackgroundFill(Color.web("#1a1a2e"), CornerRadii.EMPTY, Insets.EMPTY)
        ));

        return conteneur;
    }

    /**
     * Crée un bouton stylisé avec le texte donné.
     */
    private Button creerBouton(String texte) {
        Button bouton = new Button(texte);
        bouton.setMinWidth(220);
        bouton.setMinHeight(48);
        bouton.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 16));
        bouton.setTextFill(Color.WHITE);
        bouton.setBackground(new Background(
                new BackgroundFill(Color.web("#16213e"), new CornerRadii(8), Insets.EMPTY)
        ));

        // Effet hover
        bouton.setOnMouseEntered(e -> bouton.setBackground(new Background(
                new BackgroundFill(Color.web("#0f3460"), new CornerRadii(8), Insets.EMPTY)
        )));
        bouton.setOnMouseExited(e -> bouton.setBackground(new Background(
                new BackgroundFill(Color.web("#16213e"), new CornerRadii(8), Insets.EMPTY)
        )));

        return bouton;
    }

    // -------------------------------------------------------
    //  Actions
    // -------------------------------------------------------

    private void lancerJeu() {
        System.out.println("Démarrage de la partie...");
        // TODO : charger la scène de jeu
    }

    private void ouvrirOptions() {
        System.out.println("Ouverture des options...");
        // TODO : afficher la fenêtre ou scène d'options
    }

    // -------------------------------------------------------
    //  Getters
    // -------------------------------------------------------

    /**
     * Retourne la vue racine du menu, prête à être insérée dans une Scene.
     */
    public VBox getView() {
        return view;
    }
}
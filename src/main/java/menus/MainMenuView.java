package menus;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import util.Style;
import util.Text;

/**
 * Construit la vue du menu principal (titre + boutons).
 * Ne contient aucune logique métier : elle expose uniquement
 * les composants dont le contrôleur aura besoin.
 */
public class MainMenuView {

    private final VBox localRoot;
    private final Button btnPlay;
    private final Button btnSettings;
    private final Button btnQuit;

    public MainMenuView() {
        // --- Titre ---
        Label titre = new Label(Text.GAMENAME);
        Style.applyStyle(titre);

        // --- Boutons ---
        btnPlay = creerBouton("▶  " + Text.PLAY);
        btnSettings = creerBouton("⚙  " + Text.SETTINGS);
        btnQuit = creerBouton("✖  " + Text.QUIT);

        // --- Conteneur principal ---
        localRoot = new VBox(20, titre, btnPlay, btnSettings, btnQuit);
        localRoot.setAlignment(Pos.CENTER);
        localRoot.setPadding(new Insets(40));
        localRoot.setBackground(Style.BackgroundStyle());
    }

    private Button creerBouton(String texte) {
        Button bouton = new Button(texte);
        Style.applyStyle(bouton);
        return bouton;
    }

    public Button getBtnPlay()   { return btnPlay;   }
    public Button getBtnSettings() { return btnSettings; }
    public Button getBtnQuit() { return btnQuit; }

    public void show(StackPane root) {
        root.getChildren().add(localRoot);
    }
}

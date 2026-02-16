package util;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Classe utilitaire fournissant des méthodes statiques
 * pour appliquer un style visuel cohérent aux composants du menu.
 */
public abstract class Style {

    // --- Palette de couleurs ---
    public static final Color BACKGROUND_COLOR     = Color.web("#1a1a2e");
    public static final Color BUTTON_COLOR         = Color.web("#16213e");
    public static final Color HOVERED_BUTTON_COLOR = Color.web("#0f3460");
    public static final Color TEXT_COLOR           = Color.WHITE;

    /**
     * Applique le style du titre principal à un Label.
     *
     * @param label le label à styliser
     */
    public static void applyStyle(Label label) {
        label.setFont(Font.font("Arial", FontWeight.BOLD, 64));
        label.setTextFill(TEXT_COLOR);
    }

    /**
     * Applique le style standard à un bouton de menu,
     * y compris les effets de survol (hover).
     *
     * @param button le bouton à styliser
     */
    public static void applyStyle(Button button) {
        button.setMinWidth(220);
        button.setMinHeight(48);
        button.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 16));
        button.setTextFill(TEXT_COLOR);
        applyBackgroundStyle(button, BUTTON_COLOR);

        button.setOnMouseEntered(e -> applyBackgroundStyle(button, HOVERED_BUTTON_COLOR));
        button.setOnMouseExited(e  -> applyBackgroundStyle(button, BUTTON_COLOR));
    }

    /**
     * Retourne un Background uni adapté au panneau principal du menu.
     */
    public static Background BackgroundStyle() {
        return new Background(
                new BackgroundFill(BACKGROUND_COLOR, CornerRadii.EMPTY, Insets.EMPTY)
        );
    }

    // -------------------------------------------------------
    //  Méthodes privées
    // -------------------------------------------------------

    private static void applyBackgroundStyle(Button bouton, Color couleur) {
        bouton.setBackground(new Background(
                new BackgroundFill(couleur, new CornerRadii(8), Insets.EMPTY)
        ));
    }
}
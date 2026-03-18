package model;

import model.celestial.Star;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the root of a match.
 * Manages time and holds the stars that anchor the system.
 */
public class StellarSystem {
    private String name;
    private Star star;
    private double gameTime; // Total elapsed time in seconds

    public StellarSystem(String name) {
        this.name = name;
        this.gameTime = 0;
    }

    public void update(double deltaTime, double timeMultiplier) {
        this.gameTime += deltaTime * timeMultiplier;
        star.updatePosition(gameTime);
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public String toString() {
        return star.toString();
    }

    // Getters
    public Star getStar() { return star; }
    public String getName() { return name; }
    public double getGameTime() { return gameTime; }
}
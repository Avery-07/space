package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the root of a match.
 * Manages time and holds the stars that anchor the system.
 */
public class StellarSystem {
    private String name;
    private List<Star> stars;
    private double gameTime; // Total elapsed time in seconds

    public StellarSystem(String name) {
        this.name = name;
        this.stars = new ArrayList<>();
        this.gameTime = 0;
    }

    public void update(double deltaTime, double timeMultiplier) {
        this.gameTime += deltaTime * timeMultiplier;
        for (Star star : stars) {
            star.updatePosition(gameTime);
        }
    }

    public void addStar(Star star) {
        this.stars.add(star);
    }

    // Getters
    public List<Star> getStars() { return stars; }
    public double getGameTime() { return gameTime; }
}
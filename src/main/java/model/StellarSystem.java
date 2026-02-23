package model;

import java.util.ArrayList;

public class StellarSystem {
    private String systemName;
    private Star star;
    private double gameTime;

    public StellarSystem(String name) {
        this.systemName = name;
        this.star = new Star();
        this.gameTime = 0;
    }

    // The main heartbeat of the game model
    public void tick(double deltaTime, double speedMultiplier) {
        gameTime += deltaTime * speedMultiplier;
        star.update(deltaTime, speedMultiplier);
    }

    // Method to find a planet by ID for targeting systems
    public CelestialBody findBody(String name) {
        // Recursive search through the tree
        return null;
    }
}
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A Planet can be owned by a player and have its own satellites (Moons).
 */
class Planet extends OrbitingBody {
    private List<Moon> moons;
    private String ownerId; // Null if unoccupied

    public Planet(String name, Star parentStar, double size,
                  double orbitalRadius, double orbitalPeriod, double initialPhase) {
        super(name, parentStar, size, orbitalRadius, orbitalPeriod, initialPhase);
        this.moons = new ArrayList<>();
        this.ownerId = null;
    }

    @Override
    public void updatePosition(double totalTime) {
        super.updatePosition(totalTime);
        // Update all moons relative to this planet's new position
        for (Moon moon : moons) {
            moon.updatePosition(totalTime);
        }
    }

    public void addMoon(Moon moon) {
        this.moons.add(moon);
    }

    public void setOwner(String ownerId) { this.ownerId = ownerId; }
    public double getSize() { return size; }
}
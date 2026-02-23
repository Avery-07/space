package model;

import java.util.ArrayList;
import java.util.List;

public abstract class CelestialBody {
    protected String name;
    protected double semiMajorAxis; // Distance from parent
    protected double orbitalPeriod; // Time for one full orbit
    protected double currentPhase;  // Current angle in radians (0 to 2*PI)

    protected List<CelestialBody> satellites = new ArrayList<>();

    public CelestialBody(String name, double semiMajorAxis, double orbitalPeriod) {
        this.name = name;
        this.semiMajorAxis = semiMajorAxis;
        this.orbitalPeriod = orbitalPeriod;
        this.currentPhase = Math.random() * Math.PI * 2; // Random start position
    }

    // Update position based on time delta
    public void update(double deltaTime, double gameSpeed) {
        if (orbitalPeriod > 0) {
            double angularVelocity = (2 * Math.PI) / orbitalPeriod;
            currentPhase += angularVelocity * deltaTime * gameSpeed;
            currentPhase %= (2 * Math.PI);
        }

        // Update all moons/satellites relative to this body
        for (CelestialBody satellite : satellites) {
            satellite.update(deltaTime, gameSpeed);
        }
    }

    // Get Local X/Y (Relative to parent)
    public double getLocalX() { return Math.cos(currentPhase) * semiMajorAxis; }
    public double getLocalY() { return Math.sin(currentPhase) * semiMajorAxis; }
}
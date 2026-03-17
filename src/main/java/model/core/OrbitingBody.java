package model.core;

import util.AdditionalMath;

/**
 * Represents any body that revolves around another (Planets, Moons, Asteroids).
 */
public abstract class OrbitingBody extends CelestialBody {

    // present variables :
    // String name;
    // double x, y;
    // double size;

    protected CelestialBody parent;
    protected double orbitalRadius; // Distance from parent
    protected double orbitalPeriod; // Time for one full revolution
    protected double initialPhase;  // Starting angle in radians

    public OrbitingBody(String name, CelestialBody parent, double size,
                        double orbitalRadius, double initialPhase) {
        super(name, size);
        this.parent = parent;
        this.orbitalRadius = orbitalRadius;
        this.orbitalPeriod = AdditionalMath.DistanceToSpeed(orbitalRadius);
        this.initialPhase = initialPhase;
    }

    @Override
    public void updatePosition(double totalTime) {
        // Angular Velocity (2 * PI / Period)
        double angle = initialPhase + (2 * Math.PI * totalTime / orbitalPeriod);

        // Calculate position relative to parent
        this.x = parent.getX() + Math.cos(angle) * orbitalRadius;
        this.y = parent.getY() + Math.sin(angle) * orbitalRadius;
    }

    public double getOrbitalRadius() { return orbitalRadius; }
}
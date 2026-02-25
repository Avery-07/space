package model;

/**
 * Represents any body that revolves around another (Planets, Moons, Asteroids).
 */
abstract class OrbitingBody extends CelestialBody {
    protected CelestialBody parent;
    protected double orbitalRadius; // Distance from parent
    protected double orbitalPeriod; // Time for one full revolution
    protected double initialPhase;  // Starting angle in radians

    public OrbitingBody(String name, CelestialBody parent, double radius,
                        double orbitalRadius, double orbitalPeriod, double initialPhase) {
        super(name, radius);
        this.parent = parent;
        this.orbitalRadius = orbitalRadius;
        this.orbitalPeriod = orbitalPeriod;
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
}
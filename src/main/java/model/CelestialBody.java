package model;

/**
 * Base class for all objects in space.
 */
abstract class CelestialBody {
    protected String name;
    protected double x, y; // Global coordinates
    protected double mass;
    protected double radius;

    public CelestialBody(String name, double mass, double radius) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
    }

    public abstract void updatePosition(double totalTime);

    public double getX() { return x; }
    public double getY() { return y; }
}
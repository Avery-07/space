package model;

/**
 * Base class for all objects in space.
 */
abstract class CelestialBody {
    protected String name;
    protected double x, y; // Global coordinates
    protected double size;

    public CelestialBody(String name, double size) {
        this.name = name;
        this.size = size;
    }

    public abstract void updatePosition(double totalTime);

    public double getX() { return x; }
    public double getY() { return y; }
}
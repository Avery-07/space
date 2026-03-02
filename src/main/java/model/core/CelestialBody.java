package model.core;

/**
 * Base class for all objects in space.
 */
public abstract class CelestialBody {
    public String name;
    protected double x, y;
    public double size;

    public CelestialBody(String name, double size) {
        this.name = name;
        this.size = size;
    }

    public abstract void updatePosition(double totalTime);

    public double getX() { return x; }
    public double getY() { return y; }
}
package model.core;

import util.Position;

/**
 * Base class for all objects in space.
 */
public abstract class CelestialBody {
    protected String name;
    protected Position position;
    protected double size;

    public CelestialBody(String name, double size) {
        this.name = name;
        this.position = new Position();
        this.size = size;
    }

    public abstract void updatePosition(double totalTime);

    public String getName() { return name; }
    public Position getPosition() { return position; }
    public double getSize() { return size; }
    public void setName(String name) { this.name = name; }
    public void setPosition(Position position) { this.position = position; }
    public void setSize(double size) { this.size = size; }
}
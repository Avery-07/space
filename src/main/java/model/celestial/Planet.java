package model.celestial;

import model.core.OrbitingBody;

import java.util.ArrayList;
import java.util.List;

public class Planet extends OrbitingBody {

    // pre-existing variables :
    // String name;
    // double x, y, size;
    // CelestialBody parent;
    // double orbitalRadius, orbitalPeriod, initialPhase;

    private List<OrbitingBody> orbitingBodies;

    public Planet(String name, Star parentStar, double size, double orbitalRadius, double orbitalPeriod, double initialPhase) {
        super(name, parentStar, size, orbitalRadius, orbitalPeriod, initialPhase);
        this.orbitingBodies = new ArrayList<>();
    }

    @Override
    public void updatePosition(double totalTime) {
        super.updatePosition(totalTime);
        // Update all moons relative to this planet's new position
        for (OrbitingBody body : orbitingBodies) {
            body.updatePosition(totalTime);
        }
    }

    public void addMoon(Moon moon) {
        this.orbitingBodies.add(moon);
    }
}
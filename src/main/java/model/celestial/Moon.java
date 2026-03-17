package model.celestial;

import model.core.OrbitingBody;

public class Moon extends OrbitingBody {

    // pre-existing variables :
    // String name;
    // double x, y, size;
    // CelestialBody parent;
    // double orbitalRadius, orbitalPeriod, initialPhase;

    public Moon(String name, Planet parentPlanet, double size, double orbitalRadius, double initialPhase) {
        super(name, parentPlanet, size, orbitalRadius, initialPhase);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Moon: %s (Size: %.2f)", name, size));
        return sb.toString();
    }
}
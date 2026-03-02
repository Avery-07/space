package model.celestial;

import model.core.OrbitingBody;

public class Moon extends OrbitingBody {

    // pre-existing variables :
    // String name;
    // double x, y, size;
    // CelestialBody parent;
    // double orbitalRadius, orbitalPeriod, initialPhase;

    public Moon(String name, Planet parentPlanet, double size, double orbitalRadius, double orbitalPeriod, double initialPhase) {
        super(name, parentPlanet, size, orbitalRadius, orbitalPeriod, initialPhase);
    }
}
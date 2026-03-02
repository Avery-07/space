package model.celestial;

import model.core.CelestialBody;
import model.core.OrbitingBody;

public class AsteroidBelt extends OrbitingBody {

    // pre-existing variables :
    // String name;
    // double x, y, size;
    // CelestialBody parent;
    // double orbitalRadius, orbitalPeriod, initialPhase;

    public AsteroidBelt(String name, CelestialBody parentBody, double size, double orbitalRadius, double orbitalPeriod, double initialPhase) {
        super(name, parentBody, size, orbitalRadius, orbitalPeriod, initialPhase);
    }
}

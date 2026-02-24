package model;

/**
 * Moons are the smallest tier of orbiters.
 */
class Moon extends OrbitingBody {
    public Moon(String name, Planet parentPlanet, double mass, double radius,
                double orbitalRadius, double orbitalPeriod, double initialPhase) {
        super(name, parentPlanet, mass, radius, orbitalRadius, orbitalPeriod, initialPhase);
    }
}
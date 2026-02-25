package model;

/**
 * Moons are the smallest tier of orbiters.
 */
class Moon extends OrbitingBody {
    public Moon(String name, Planet parentPlanet, double size,
                double orbitalRadius, double orbitalPeriod, double initialPhase) {
        super(name, parentPlanet, size, orbitalRadius, orbitalPeriod, initialPhase);
    }
}
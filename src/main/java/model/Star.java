package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A Star sits at the center of its own orbital group.
 * In a multi-star system, stars could orbit a common barycenter.
 */
class Star extends CelestialBody {
    private List<Planet> planets;

    public Star(String name, double size) {
        super(name, size);
        this.planets = new ArrayList<>();
        // For a simple system, stars start at the origin
        this.x = 0;
        this.y = 0;
    }

    @Override
    public void updatePosition(double totalTime) {
        // If it's a single star, it stays at 0,0.
        // If binary, add orbital logic here similar to OrbitingBody.
        for (Planet planet : planets) {
            planet.updatePosition(totalTime);
        }
    }

    public void addPlanet(Planet planet) {
        this.planets.add(planet);
    }
}

package model.celestial;

import model.core.OrbitingBody;
import model.type.PlanetType;

import java.util.ArrayList;
import java.util.List;

public class Planet extends OrbitingBody {

    // pre-existing variables :
    // String name;
    // double x, y, size;
    // CelestialBody parent;
    // double orbitalRadius, orbitalPeriod, initialPhase;

    private PlanetType type;
    private List<OrbitingBody> satellites;

    public Planet(String name, PlanetType type , Star parentStar, double size, double orbitalRadius, double initialPhase) {
        super(name, parentStar, size, orbitalRadius, initialPhase);
        this.type = type;
        this.satellites = new ArrayList<>();
    }

    @Override
    public void updatePosition(double totalTime) {
        super.updatePosition(totalTime);
        for (OrbitingBody satellite : satellites) {
            satellite.updatePosition(totalTime);
        }
    }

    public void addSatellite(OrbitingBody satellite) {
        this.satellites.add(satellite);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Planet: %s (Size: %.2f)", name, size));
        for (OrbitingBody child : satellites) {
            // Indent children for a "tree" view in the console
            sb.append("\n   ").append(child.toString().replace("\n", "\n      "));
        }
        return sb.toString();
    }

    public PlanetType getType() { return type; }
    public List<OrbitingBody> getSatellites() { return satellites; }
}
package model.celestial;

import model.core.CelestialBody;
import model.core.OrbitingBody;

import java.util.ArrayList;
import java.util.List;

/**
 * A Star sits at the center of its own orbital group.
 * In a multi-star system, stars could orbit a common barycenter.
 */
public class Star extends CelestialBody {

    // pre-existing variables :
    // String name;
    // double x, y, size;

    private List<OrbitingBody> satellites;

    public Star(String name, double size) {
        super(name, size);
        this.satellites = new ArrayList<>();
        // For a simple system, stars start at the origin
        this.x = 0;
        this.y = 0;
    }

    @Override
    public void updatePosition(double totalTime) {
        // If it's a single star, it stays at 0,0.
        // If binary, add orbital logic here similar to OrbitingBody.
        for (OrbitingBody orbitingBody : satellites) {
            orbitingBody.updatePosition(totalTime);
        }
    }

    public void addSatellite(OrbitingBody satellite) {
        this.satellites.add(satellite);
    }

    @Override
    public String toString() {
        String str = "Star : " + name + "\nsize : " + size;
        for(OrbitingBody orbitingBody : satellites)
            if(orbitingBody instanceof Planet)
                str += "\n\n" + ((Planet) orbitingBody);
            else
                str += "\n\n" + ((AsteroidBelt) orbitingBody);
        return str;
    }

    public List<OrbitingBody> getSatellites() { return satellites; }
}

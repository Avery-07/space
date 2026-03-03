package service;

import model.StellarSystem;
import model.celestial.*;
import model.core.CelestialBody;
import model.type.PlanetType;

import java.util.Random;

import static util.AdditionalMath.round;

public class SystemGenerator {
    private static final Random RNG = new Random();

    // Physical Constants (Units are arbitrary for game scale)
    private static final double MIN_STAR_SIZE = 50.0;
    private static final double MAX_STAR_SIZE = 200.0;
    private static final double SYSTEM_SIZE_MULTIPLIER = 7.0;
    private static final double KEPLER_CONSTANT = 0.5; // Adjusts speed of time

    public static StellarSystem generate(String systemName) {
        StellarSystem sys = new StellarSystem(systemName);

        // 1. Generate the Star
        double starSize = MIN_STAR_SIZE + (MAX_STAR_SIZE - MIN_STAR_SIZE) * RNG.nextDouble();
        Star star = new Star(systemName + " Prime", starSize);
        sys.addStar(star);

        // 2. Calculate System Boundaries
        double maxRadius = starSize * SYSTEM_SIZE_MULTIPLIER;
        double frostLine = maxRadius * 0.4; // 2/5 distance

        // 3. Populate Orbits
        double currentRadius = starSize * 2.0; // Start orbiting outside the star
        while (currentRadius < maxRadius) {
            // Step distance between orbits (Randomized gap)
            currentRadius += 75 + RNG.nextDouble() * 100;
            if (currentRadius > maxRadius) break;

            // Chance for an Asteroid Belt vs a Planet
            if (RNG.nextDouble() < 0.1) {
                star.addSatellite(generateAsteroidBelt(star, currentRadius));
            } else {
                Planet p = generatePlanet(star, currentRadius, frostLine);
                generateSatellitesForPlanet(p);
                star.addSatellite(p);
            }
        }

        return sys;
    }

    private static Planet generatePlanet(Star star, double radius, double frostLine) {
        PlanetType type = (radius > frostLine && RNG.nextDouble() > 0.3) ? PlanetType.GASEOUS : PlanetType.ROCKY;

        // Gaseous planets are 3x-8x larger than rocky ones
        double sizeBase = (type == PlanetType.GASEOUS) ? 15.0 : 3.0;
        double size = round(sizeBase + RNG.nextDouble() * ((type == PlanetType.GASEOUS) ? 20.0 : 5.0));

        String name = "Planet " + (int)radius;
        double period = calculateKeplerPeriod(radius);
        double phase = RNG.nextDouble() * 2 * Math.PI;

        return new Planet(name, star, size, radius, period, phase);
    }

    private static AsteroidBelt generateAsteroidBelt(CelestialBody parent, double radius) {
        double period = calculateKeplerPeriod(radius);
        return new AsteroidBelt(parent.name + " Ring", parent, 1.0, radius, period, 0);
    }

    private static void generateSatellitesForPlanet(Planet parent) {
        // More size = more gravity = more moons
        int moonCount = (int) (parent.size / 5.0 * RNG.nextDouble());

        // Chance for planetary rings if it's a large planet
        if (parent.size > 15.0 && RNG.nextDouble() > 0.8) {
            parent.addSatellite(generateAsteroidBelt(parent, parent.size * 1.5));
        }

        for (int i = 0; i < moonCount; i++) {
            double moonRadius = parent.size + 10 + (i * 10);
            double moonPeriod = calculateKeplerPeriod(moonRadius) * 0.2; // Moons orbit faster
            Moon moon = new Moon(parent.name + "-m" + (i+1), parent, 1.0 + RNG.nextDouble() * 2,
                    moonRadius, moonPeriod, RNG.nextDouble() * 6.28);
            parent.addSatellite(moon);
        }
    }

    private static double calculateKeplerPeriod(double radius) {
        return KEPLER_CONSTANT * Math.sqrt(Math.pow(radius, 3));
    }
}
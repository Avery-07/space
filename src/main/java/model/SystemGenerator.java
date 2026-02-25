package model;

import java.util.Random;

import java.util.Random;

public class SystemGenerator {
    private static final Random RNG = new Random();

    // Configuration Constants
    private static final int MIN_PLANETS = 3;
    private static final int MAX_PLANETS = 8;
    private static final double MIN_PLANET_SIZE = 10.0;
    private static final double MAX_PLANET_SIZE = 50.0;

    // Orbital Spacing
    private static final double STAR_INNER_BOUND = 200.0; // Distance of first planet
    private static final double ORBIT_SPACING = 150.0;    // Average distance between planets

    public static StellarSystem generate(String systemName) {
        StellarSystem system = new StellarSystem(systemName);

        // 1. Generate the Sun
        double starSize = 100.0 + RNG.nextDouble() * 100.0;
        Star sun = new Star(systemName + " Prime", starSize);
        system.addStar(sun);

        // 2. Determine Number of Planets
        int numPlanets = RNG.nextInt(MAX_PLANETS - MIN_PLANETS + 1) + MIN_PLANETS;

        for (int i = 0; i < numPlanets; i++) {
            // Calculate orbital radius with some jitter so it's not a perfect grid
            double orbitalRadius = STAR_INNER_BOUND + (i * ORBIT_SPACING) + (RNG.nextDouble() * 50);

            // Orbital period (Further planets move slower: Kepler's 3rd Law approx)
            double orbitalPeriod = Math.pow(orbitalRadius, 1.5) * 0.1;

            double planetSize = MIN_PLANET_SIZE + RNG.nextDouble() * (MAX_PLANET_SIZE - MIN_PLANET_SIZE);
            double initialPhase = RNG.nextDouble() * Math.PI * 2;

            Planet planet = new Planet(
                    systemName + " " + (char)('b' + i),
                    sun,
                    planetSize,
                    orbitalRadius,
                    orbitalPeriod,
                    initialPhase
            );

            // 3. Generate Moons based on Planet Size
            generateMoonsForPlanet(planet);

            sun.addPlanet(planet);
        }

        return system;
    }

    private static void generateMoonsForPlanet(Planet parent) {
        // "Bigger planets have more moons on average" logic
        // Every 10 units of size grants a potential moon slot
        int maxMoons = (int)(parent.size / 10);
        int numMoons = RNG.nextInt(maxMoons + 1); // Random from 0 to maxMoons

        for (int i = 0; i < numMoons; i++) {
            double moonSize = parent.size * 0.2; // Moons are 20% of planet size
            double moonOrbit = (parent.size * 1.5) + (i * 15.0) + RNG.nextDouble() * 5.0;
            double moonPeriod = Math.pow(moonOrbit, 1.2) * 0.5;
            double moonPhase = RNG.nextDouble() * Math.PI * 2;

            Moon moon = new Moon(
                    parent.name + "-Moon " + (i + 1),
                    parent,
                    moonSize,
                    moonOrbit,
                    moonPeriod,
                    moonPhase
            );
            parent.addMoon(moon);
        }
    }
}
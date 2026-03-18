package service;

import model.StellarSystem;
import model.celestial.*;
import model.type.PlanetType;

import java.util.Random;

public class SystemGenerator {
    private static final Random RNG = new Random();

    // Physical Constants

    public static StellarSystem generate(String systemName) {
        StellarSystem sys = new StellarSystem(systemName);

        // 1. Generate the Star
        double starSize = 100;
        Star star = new Star(systemName + " Prime", starSize);
        sys.setStar(star);

        // 2. Populate Orbits
        Planet A0 = new Planet("TIMERDE_1", PlanetType.ROCKY, star, 10, 200, 0);

        Planet B0 = new Planet("TIMERDE_2", PlanetType.ROCKY, star, 30, 300, 0);
        Moon B1 = new Moon("TIMERDE_2_1", B0, 13, 40, 0);
        Moon B2 = new Moon("TIMERDE_2_2", B0, 5, 15, 0);
        B0.addSatellite(B1);
        B0.addSatellite(B2);

        Planet C0 = new Planet("TIMERDE_3", PlanetType.ROCKY, star, 20, 450, 0);
        Moon C1 = new Moon("TIMERDE_3_1", C0, 7, 20, 0);
        C0.addSatellite(C1);

        AsteroidBelt D0 = new AsteroidBelt("TIMERDE_3", star, 30, 600, 0);

        Planet E0 = new Planet("TIMERDE_4", PlanetType.GASEOUS, star, 65, 800, 0);
        Moon E1 = new Moon("TIMERDE_4_1", E0, 13, 40, 0);
        AsteroidBelt E2 = new AsteroidBelt("TIMERDE_3", star, 10, 50, 0);
        Moon E3 = new Moon("TIMERDE_4_3", E0, 18, 100, 0);
        C0.addSatellite(E1);
        //C0.addSatellite(E2);
        C0.addSatellite(E3);

        Planet F0 = new Planet("TIMERDE_5", PlanetType.GASEOUS, star, 37, 1100, 0);
        Moon F1 = new Moon("TIMERDE_5_1", F0, 7, 20, 0);
        Moon F2 = new Moon("TIMERDE_5_2", F0, 7, 20, 0);
        C0.addSatellite(F1);
        C0.addSatellite(F2);

        star.addSatellite(A0);
        star.addSatellite(B0);
        star.addSatellite(C0);
        star.addSatellite(D0);
        star.addSatellite(E0);
        star.addSatellite(F0);

        return sys;
    }
}